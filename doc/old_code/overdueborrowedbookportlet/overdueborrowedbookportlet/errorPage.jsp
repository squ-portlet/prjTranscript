<%@ page isErrorPage="true" %>
<%@page contentType="text/html; charset=UTF-8"
        import="oracle.portal.provider.v2.url.UrlUtils"
        import="oracle.portal.provider.v2.render.PortletRenderRequest"
        import="oracle.portal.provider.v2.http.HttpCommonConstants"
        import="oracle.portal.provider.v2.ParameterDefinition"
        import="oracle.portal.provider.v2.render.PortletRendererUtil,
                oracle.portal.provider.v2.render.PortletContainerRenderer,
                oracle.portal.provider.v2.render.PortletRenderer,
                oracle.portal.provider.v2.render.DefaultContainerRenderer,
                oracle.portal.provider.v2.render.http.HttpPortletRendererUtil"
        import="oracle.portal.provider.v2.personalize.NameValuePersonalizationObject"
        import="java.util.ResourceBundle"
      
%>
<%
PortletRenderRequest pReq = (PortletRenderRequest)
      request.getAttribute(HttpCommonConstants.PORTLET_RENDER_REQUEST);
 
// get a resource bundle object for the current language      
   ResourceBundle rb = ResourceBundle.getBundle("LibraryServicesResourceBundle", 
                                                pReq.getLocale());
 %>
<html>
<head>
<title>JavaMail errorpage</title>
</head>
<body bgcolor="white">
 
<% session.putValue("errorDescription", exception.toString()); %>
<h2> 
    <%=rb.getString("ERROR_MSG_TEXT")  %> 
</h2>
<p>
<%
 if (session.getValue("errorDescription2")!= null)
    {
%>
         <%= session.getValue("errorDescription2") %>
<%
    }         
else  
    {
%>
         <%= session.getValue("errorDescription") %>
<%  }
%>
</p>
</body>
</html>
