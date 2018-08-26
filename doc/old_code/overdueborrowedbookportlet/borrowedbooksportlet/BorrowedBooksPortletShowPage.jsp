 
<style type="text/css">
<!--a:link, a:active,a:visited{
color:#75490f;
text-decoration:underline}
a:hoover{
color:#e6ded3;
text-decoration:none}
-->
</style>




<%@page contentType="text/html; charset=UTF-8"
        import="oracle.portal.provider.v2.render.PortletRenderRequest"
        import="oracle.portal.provider.v2.http.HttpCommonConstants"
        import="oracle.portal.provider.v2.ParameterDefinition"
        import="oracle.portal.provider.v2.render.PortletRendererUtil,         
                oracle.portal.provider.v2.render.http.HttpPortletRendererUtil, 
                oracle.portal.provider.v2.event.EventUtils,
                oracle.portal.utils.NameValue,
                oracle.portal.provider.v2.url.UrlUtils"
        import="oracle.portal.provider.v2.personalize.NameValuePersonalizationObject"
        import="java.util.ResourceBundle"
        import="java.sql.*,
                java.util.Date, java.text.SimpleDateFormat"
        import="java.lang.String "
        import="javax.servlet.http.HttpServletRequest"  
           import="oracle.portal.provider.v2.render.DefaultContainerRenderer"
        import="oracle.portal.provider.v2.render.PortletContainerRenderer"
        import="oracle.portal.utils.v2.SimpleParameterMap" 
        import="java.io.PrintWriter"
        import= "libpackage.UserPersonalInfo"
        import= "studentInfo.getStudId"
%>
<%@ page errorPage="errorPage.jsp" %>
<%@ page isThreadSafe="false" %>
<%
Connection conn     = null;
oracle.jdbc.pool.OraclePooledConnection pc= null;  
Statement  stmt     = null;
ResultSet  rsQuery  = null;
String     strQuery = null;
String     flag;
String     strTitle;

   PortletRenderRequest pReq = (PortletRenderRequest)
      request.getAttribute(HttpCommonConstants.PORTLET_RENDER_REQUEST);
 /*
 // create new instance for DefaultContainerRenderer and PrintWriter
   DefaultContainerRenderer defaultContainerRenderer = new DefaultContainerRenderer();  
   PrintWriter printWriter = new PrintWriter(out);
   //create new instance form simpleParameterMap    
   SimpleParameterMap simpleParamMap = new SimpleParameterMap();
   */
  // getting the resource bundles         
  ResourceBundle rb =
      ResourceBundle.getBundle("LibraryServicesResourceBundle",pReq.getLocale());

  String strBookTitle     = rb.getString("BookTitle");
  String strMsgNoRecord   = rb.getString("ErrorMsgNoRecordeFound"); 
  String strBookOutDate   = rb.getString("BookOutDate"); 
  String strBookReturnDate= rb.getString("BookReturnDate");
  String strLibraryName   = rb.getString("LibraryName");

  String strUserName = pReq.getUser().getName();
  String strStdWhereClause= "";
  int    strLibraryUser=0;
  String strEmpId ="";

 /* if  ( strUserName.startsWith("D0") || strUserName.startsWith("M0") ||
        strUserName.startsWith("S0") || strUserName.startsWith("U0") ||
        strUserName.startsWith("V0") || strUserName.startsWith("P0")|| strUserName.startsWith("P8")
      )
        {   
           strLibraryUser =Integer.parseInt(strUserName.replaceFirst(strUserName.substring(0,1),""));
        }*/
  if (  strUserName.startsWith("S0") || strUserName.startsWith("S1")
      || strUserName.startsWith("S2") || strUserName.startsWith("S3")
      || strUserName.startsWith("S4") || strUserName.startsWith("S5")
      || strUserName.startsWith("S6") || strUserName.startsWith("S7")
      || strUserName.startsWith("S8") || strUserName.startsWith("S9")
      || strUserName.startsWith("U0") 
     || strUserName.startsWith("M0") || strUserName.startsWith("M1")
      || strUserName.startsWith("M2") || strUserName.startsWith("M3")
      || strUserName.startsWith("M4")|| strUserName.startsWith("M5")
      || strUserName.startsWith("M6") || strUserName.startsWith("M7")
      || strUserName.startsWith("M8")|| strUserName.startsWith("M9")
    ||  strUserName.startsWith("U1") // added on 09/09/2012 becuase to deal with students whose ids with no "U0" 
    || strUserName.startsWith("V0")|| strUserName.startsWith("V1") // added on 12/09/2012 becuase to deal with students whose ids with no "P0" and "V0" 
    || strUserName.startsWith("D0")  || strUserName.startsWith("D1")// added on 12/09/2012 becuase to deal with students whose ids with no "D0" amd "M0" 
   || strUserName.startsWith("D2")  || strUserName.startsWith("D3")
   || strUserName.startsWith("D4")  || strUserName.startsWith("D5")
   || strUserName.startsWith("D6")  || strUserName.startsWith("D7")
   || strUserName.startsWith("D8")  || strUserName.startsWith("D9")
   || strUserName.startsWith("P0")|| strUserName.startsWith("P1")
   || strUserName.startsWith("P2")|| strUserName.startsWith("P3")
   || strUserName.startsWith("P4")|| strUserName.startsWith("P5")
   || strUserName.startsWith("P6")|| strUserName.startsWith("P7")
   || strUserName.startsWith("P8")|| strUserName.startsWith("P9")
    
   )
    { // if the user is student 
      getStudId StudInfo       = new getStudId();
      strLibraryUser    = Integer.parseInt(StudInfo.getStudentId(strUserName));
    }
  else  
        {
           String userDn = pReq.getUser().getUserDN(); 
           String ou = userDn.substring(userDn.indexOf(",")+1, userDn.indexOf(",",userDn.indexOf(",")+1));  
           // reads the employee number from OID using the class UserPersonalInfo()
           strUserName = pReq.getUser().getName();
           UserPersonalInfo uinfo       = new UserPersonalInfo();
           strEmpId    = uinfo.getEmpId(strUserName,ou);
      
           if (strEmpId.equals("NotFound"))
              {
                  session.putValue("errorDescription2",  rb.getString("LibraryName") );
%>               <!-- employee number not found in OID. -->
                 <jsp:forward page="errorPage.jsp"> </jsp:forward> 
<%            } 
           else
                strLibraryUser= Integer.parseInt(strEmpId);
         }


  String strCurLocale = pReq.getLocale().toString();
  //The follwoing qeury gives the borrowed book name, the out date and the due date
 strQuery = " select  " +	
	          "        nvl(substr(marc0.tag,0, instr(marc0.tag,'|')-1),    " +
            "            substr(marc0.tag,0))	                               \""  + strBookTitle    + " \""+ 
            "       , null							                                     \""  + strLibraryName    + " \"" + 
	          "       , to_char(charge.date_time_charged,'dd/mm/yyyy hh24:mi') \""  + strBookOutDate    + " \"" +
	          "       , to_char(charge.date_time_due,'dd/mm/yyyy')             \""  + strBookReturnDate + " \"" +
            "       ,  decode(sign( charge.date_time_due - sysdate),-1,'"+rb.getString("OverdueBook")+"',' ')   overdue"+
            " from 	sirsi.charge, 	    " +
            " 	    sirsi.catalog, 	    " +
            " 	    sirsi.marc0, 	      " +
            " 	    sirsi.users		      " +
            " where charge.catalog_key = catalog.catalog_key "  +
            "   and catalog.marc		   = marc0.marc	         "  +
            "   and charge.user_key    = users.user_key      "  +
            "   and marc0.tag_number   = 245 	               "  +
          //  "   and charge.date_time_due >=sysdate           "  +
            "   and users.id = '" + strLibraryUser + "' " +
            " order by charge.date_time_due ";
 /*
  strQuery="SELECT    distinct                                               "+ 
         "           S.TTL_HDG_MAIN_STRNG_TXT                          \""  +strBookTitle+ " \""+
         "          ,DECODE(substr('"+strCurLocale+"',1,2),'en',N.ORG_ENG_NME,'ar',N.ORG_FR_NME)  \""  +strLibraryName+  "\""+ 
         "          ,TO_CHAR(CI.CIRT_ITM_CHRG_OUT_DTE,'DD/MM/YYYY')    \""  +strBookOutDate+    " \""+
         "          ,TO_CHAR(CI.CIRT_ITM_DUE_DTE,'DD/MM/YYYY')         \""  +strBookReturnDate+ " \""+
         " FROM                                                                                      "+
                  "PRSN_CIRTN             PC, "+
                  "CIRT_ITM               CI, "+
                  "CPY_ID                 Y, "+
                  "BIB_ITM                B, "+
                  "S_CACHE_BIB_ITM_DSPLY  S, "+
                  "ORG_NME                N  "+
          "WHERE        PC.PRSN_NBR            = CI.PRSN_NBR "+
                  "AND  Y.CPY_ID_NBR           = CI.CPY_ID_NBR "+
                  "AND  B.BIB_ITM_NBR          = Y.BIB_ITM_NBR "+
                  "AND  S.BIB_ITM_NBR          = Y.BIB_ITM_NBR "+
                  "AND  N.ORG_NBR              = CI.ORG_NBR     "+ 
 //                 "AND  CI.CIRT_ITM_DUE_DTE >= SYSDATE "+
                  "AND  PC.PRSN_CIRTN_BRCDE_NBR   ='"+strLibraryUser+"' "+
                  strStdWhereClause;
 */
  // connect to the library database
  javax.naming.InitialContext ic                     = new javax.naming.InitialContext();
  oracle.jdbc.pool.OracleConnectionPoolDataSource ds = (oracle.jdbc.pool.OracleConnectionPoolDataSource)ic.lookup("jdbc/pool/DSNEWLIB");

try {
  pc         = (oracle.jdbc.pool.OraclePooledConnection)ds.getPooledConnection();
  conn       =  pc.getConnection();
 
  stmt = conn.createStatement (ResultSet.TYPE_SCROLL_INSENSITIVE,
                                    ResultSet.CONCUR_READ_ONLY); 
 // execute the query
  rsQuery= stmt.executeQuery(strQuery);           
   
 // GetResult(strQuery,"rsQuery"); 
 
  //get the meta data of the guery i.e. selected columns and their format
  ResultSetMetaData rsMeta = rsQuery.getMetaData();
  
  StringBuffer sbQuery = new StringBuffer();
  sbQuery.append("<table border=1><thead><tr>");
  // get the number of coulmns inthe query
  int colCount;
  colCount = rsMeta.getColumnCount();

  // creats the header of the table by getting the column names
  for (int col =1; col < colCount; col++) 
        if (col != 2)
              sbQuery.append("<TH class='PortletHeaderColor' align='center'><span class='PortletHeaderText'>" + rsMeta.getColumnName(col) + "</TH>");     

     sbQuery.append("</TR></THEAD><TBODY>");
         /* append the query result to the stringBuffer "sbQuery" and put them as rows/
            columns in the table */
  if (rsQuery.next()) 
     { rsQuery.previous();
       while (rsQuery.next())
          { 
             sbQuery.append("<TR ALIGN=TOP>");
             for (int col =1; col <= colCount; col++)            
                 if (col != 2)
                     sbQuery.append("<TD>" + rsQuery.getString(col) + "</TD>"); 

            sbQuery.append("</TR>");  
          }
      sbQuery.append("</TBODY></TABLE>"); 
%>
      <!--  dispaly the detail of borrowed books -->
      <center> 
          <%=sbQuery %>
      </center>
<%   } // if block end here
  else 
     { // if there is no borrowed books then print a message " No loan".
%>         <%=strMsgNoRecord%>
<%   } // else block end here
 } // try block ends here

catch (Exception e)
  {
    e.getMessage();
  }
finally
  {
//closing the resultset of the query , the connection and the statment    
     if (rsQuery!= null) rsQuery.close();
     if (stmt!= null) stmt.close();
     if (conn != null) conn.close();
     if (pc!= null) pc.close();
  }        
%>