package libpackage;

import java.io.*;
import javax.naming.*;
import java.util.*; 
import javax.naming.directory.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class UserPersonalInfo {
  public UserPersonalInfo()
  {
  }
public String getEmpId(String username, String ou) throws NamingException {

    String userName = new String();
    userName = username;
    Context initial = new InitialContext();
    Context env1 = (Context) initial.lookup("java:comp/env");
    String searchBase = "";
    
   if (ou.equals("ou=staff"))
      {
         searchBase  = (String) env1.lookup("oidSearchBaseStaff");
      }
  else if(ou.equals("ou=academic"))
      {
        searchBase  = (String) env1.lookup("oidSearchBaseAcademic");
      }
      
    String oidAdminDN  = (String) env1.lookup("oidAdminDN");
    String oidAdminPwd = (String) env1.lookup("oidAdminPwd");
    String ldapServer  = (String) env1.lookup("LDAPServer");
    String ldapPort    = (String) env1.lookup("LDAPPort");
//    String smtpHost    = (String) env1.lookup("smtpHost");
//    String smtpSender  = (String) env1.lookup("smtpSender");
//    String smtpSubject = (String) env1.lookup("smtpSubject");
//    String smtpContent = (String) env1.lookup("smtpContent");
    

    String userDN = "cn=" + userName + ", " + searchBase;
    
    
    // setup OID connection
    DirContext ctx = null;
    Hashtable env = new Hashtable();
    env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
    env.put(Context.PROVIDER_URL,"ldap://" + ldapServer + ":" + ldapPort + "/");
    env.put(Context.SECURITY_PRINCIPAL, oidAdminDN);
    env.put(Context.SECURITY_CREDENTIALS, oidAdminPwd);
    env.put(Context.SECURITY_AUTHENTICATION, "none");
    env.put(Context.SECURITY_PRINCIPAL, searchBase);
    try {
      ctx = new InitialDirContext(env);
    }
    catch (NamingException e) {
      return ("NotFound");
    }

    // retrieve Employee ID of user
    String ldapEmpId = "XXX";
    try {
      BasicAttributes currentAttr = 
        (BasicAttributes) ctx.getAttributes(userDN);
         ldapEmpId = (String) currentAttr.get("employeenumber").get();
               
    }
    catch (NamingException e) {
      // user not found in OID
      //response.sendError(500, "User not found");
      ldapEmpId ="NotFound"; 
    }
    
    catch(NullPointerException e) {
      ldapEmpId ="NotFound";
   }
   return ldapEmpId;
}

}