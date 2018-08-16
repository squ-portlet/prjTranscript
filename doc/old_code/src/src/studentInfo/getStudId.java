package studentInfo;

import java.io.*;
import java.util.*; 
import java.sql.*;


public class getStudId 
{
  public getStudId()
  {
  }
  
  public String getStudentId(String username) 
  {

    String userNamePart1 = new String();
    String userNamePart2 = new String();
    String userNamePart3 = new String();
    String UserName = new String();
    int    intStdID=0;
    int    UserNamePart3Length =0; 
    
    if (username.startsWith("M8") && (username.length()==7))
       username="M08"+username.substring(2);
    
     if (username.startsWith("D8") && (username.length()==7))
       username="D08"+username.substring(2);
      
    if (username.startsWith("P8") && (username.length()==7))
       username="P08"+username.substring(2);
       
    userNamePart1 = username.substring(0,2);
    userNamePart2 = username.substring(2,4);
    userNamePart3 = username.substring(4);
   // intStdID= Integer.parseInt(userName);
  
   if (  (     (userNamePart2.equals("86")) 
           ||  (userNamePart2.equals("87")) 
           ||  (userNamePart2.equals("88")) 
           ||  (userNamePart2.equals("89")) 
          )
          && ((userNamePart2.length()+userNamePart3.length())==6)
      )
      {
          UserNamePart3Length= userNamePart3.length();
          
          for (int i=0; i<(7-UserNamePart3Length); i++)
               UserName = "0"+UserName;
          UserName = userNamePart2 + UserName + userNamePart3;
      }
    else
        UserName= username.substring(2);
        
     return UserName;
  }// end getStudentId
}// end of class
