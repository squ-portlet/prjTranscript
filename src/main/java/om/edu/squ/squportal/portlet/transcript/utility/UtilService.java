/**
 * Project				:	prjTranscript
 * Organization			:	Sultan Qaboos University | Muscat | Oman
 * Centre				:	Centre for Information System
 * Department			:	Web & E-Services
 * 
 * Author				:	Bhabesh
 *
 * FrameWork			:	Spring 3.2.3 (Annotation) Portlet
 * 
 * File Name			:	UtilService.java
 * Package Name			:	om.edu.squ.squportal.portlet.transcript.utility
 * Date of creation		:	Aug 16, 2015  2:32:54 PM
 * Date of modification :	
 * 
 * Summary				:	
 *
 *
 * Copyright 2015 the original author or authors and Organization.
 *
 * Licensed under the SQU, CIS policy
 * you may not use this file except in compliance with the License.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * 
 */
package om.edu.squ.squportal.portlet.transcript.utility;

import javax.portlet.PortletRequest;









import om.edu.squ.portal.common.EmpCommon;
import om.edu.squ.squportal.portlet.transcript.dao.bo.User;
import om.edu.squ.squportal.portlet.transcript.dao.ldap.LdapDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Bhabesh
 *
 */
public class UtilService
{
private  final Logger logger = LoggerFactory.getLogger(UtilService.class);
	
	@Autowired
	LdapDao	ldapDao;

	/**
	 * 
	 * method name  : getUser
	 * @param strUserName
	 * @return
	 * UtilService
	 * return type  : User
	 * 
	 * purpose		:
	 *
	 * Date    		:	Dec 3, 2018 12:40:37 PM
	 */
	public User getUser(String strUserName)
	{
		User	user		=	new User();
		try
		{
		if (isStudent(strUserName.toUpperCase()))
		  {
			  user.setUserId(getStudentId(strUserName));
			  user.setUserType(Constants.USER_TYPE_STUDENT);
		  }
		  else
		  {
			EmpCommon	empCommon	=	new EmpCommon();
			user.setUserId(empCommon.getEmployeeNumber(strUserName));
			user.setUserType(Constants.USER_TYPE_EMPLOYEE);
		  }
		}
		catch(NullPointerException nullEx)
		{
			logger.error("Error :: No valid user logged in :: ,{}", nullEx.getMessage());
		}
		return user;
	}
	
	
	public  String getEmployeeNumber(PortletRequest request)
	{
		String empNumber	=	null;
		if (request.getRemoteUser() != null)
		{
			String remoteUser	=	request.getRemoteUser();
			try
			{
				empNumber			=	ldapDao.getEmpNumber(remoteUser);
			}
			catch(NullPointerException  nulEx)
			{
				empNumber = null;
				logger.error("LDAP - null pointer exception : ", nulEx.getMessage());
			}
			catch(Exception	comEx)
			{
				logger.error("communication with ldap failed", comEx.getMessage());
				empNumber = "com/ex";
			}


		}
		else
		{
			empNumber = "N/A";										// N/A = Not Available
			
			if (request.getRemoteUser() != null)
			{
				logger.error("user name : {} , not mapped properly",request.getRemoteUser());
			}
			else
			{
				logger.error("User not logged in");
			}
		}
		
		
		return empNumber;
		
	}
	
	/**
	 * 
	 * method name  : getUserName
	 * @param request
	 * @return
	 * UtilService
	 * return type  : String
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jun 3, 2015 2:19:27 PM
	 */
	public String getUserName(PortletRequest request)
	{
		String userName	=	null;
		if (request.getRemoteUser() != null)
		{
			String remoteUser	=	request.getRemoteUser();

			try
			{
				userName			=	ldapDao.getCorrectUserName(remoteUser);
			}
			catch(NullPointerException  nulEx)
			{
				userName = null;
				logger.error("LDAP - null pointer exception : ", nulEx.getMessage());
			}
			catch(Exception	comEx)
			{
				logger.error("communication with ldap failed", comEx.getMessage());
				userName = "com/ex";
			}
		}
		else
		{
			userName = "N/A";										// N/A = Not Available
			
			if (request.getRemoteUser() != null)
			{
				logger.error("user name : {} , not mapped properly",request.getRemoteUser());
			}
			else
			{
				logger.error("User not logged in");
			}
		}
		return userName;
	}
/**
 * 	
 * method name  : getStudentId
 * @param userId
 * @return
 * UtilService
 * return type  : String
 * 
 * purpose		: get Student Id
 *
 * Date    		:	Aug 10, 2015 12:34:51 PM
 */
	public  String getStudentId(String userId)
	{
			String studentId 	= new String();
			
			String userNamePart1 = new String();
		    String userNamePart2 = new String();
		    String userNamePart3 = new String();

		    
		    int    intStdID=0;
		    int    UserNamePart3Length =0; 
		    
		    if (userId.startsWith("M8") && (userId.length()==7))
		    	userId="M08"+userId.substring(2);
		    
		     if (userId.startsWith("D8") && (userId.length()==7))
		    	 userId="D08"+userId.substring(2);
		      
		    if (userId.startsWith("P8") && (userId.length()==7))
		    	userId="P08"+userId.substring(2);
		    
		        if (userId.startsWith("A"))
		        	userId="00"+userId.substring(1);
		          
		    userNamePart1 = userId.substring(0,2);
		    userNamePart2 = userId.substring(2,4);
		    userNamePart3 = userId.substring(4);

		  
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
		               studentId = "0"+studentId;
		          studentId = userNamePart2 + studentId + userNamePart3;
		      }
		    else
		    {
		        studentId= userId.substring(1);

		    }
		   
		     return studentId;

	}
	
/**
 * 	
 * method name  : isStudent
 * @param userName
 * @return
 * UtilService
 * return type  : boolean
 * 
 * purpose		: Confirm whether the user is student
 *
 * Date    		:	Aug 10, 2015 12:35:05 PM
 */
	public  boolean isStudent(String userName)
	{
		boolean	booStudent	=	false;
		String 	strUserName	=	userName.toUpperCase();
		
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
		  {
			  booStudent = true;
		  }
		
		
		return booStudent;
	}	
	
}
