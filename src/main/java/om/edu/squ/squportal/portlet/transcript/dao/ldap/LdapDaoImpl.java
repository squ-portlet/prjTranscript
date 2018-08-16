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
 * File Name			:	LdapDaoImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.transcript.dao.ldap
 * Date of creation		:	May 20, 2015  1:41:47 PM
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
package om.edu.squ.squportal.portlet.transcript.dao.ldap;

import java.util.List;

import javax.naming.NamingException;
import javax.naming.directory.Attributes;






import om.edu.squ.squportal.portlet.transcript.utility.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ldap.CommunicationException;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.DistinguishedName;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.filter.EqualsFilter;

/**
 * @author Bhabesh
 *
 */
public class LdapDaoImpl implements LdapDao
{
private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private LdapTemplate ldapTemplate;
	private LdapTemplate ldapTemplate2;

/*
 * 	Set LdapTemplate (check spring configuration file)
 */
	public void setLdapTemplate(LdapTemplate ldapTemplate) {
		this.ldapTemplate = ldapTemplate;
	}

	public void setLdapTemplate2(LdapTemplate ldapTemplate2) {
		this.ldapTemplate2 = ldapTemplate2;
	}

/**
 * Get the employee number from Ldap
 * 
 * @param userName
 * return	String employee number
 * (non-Javadoc)
 * @see edu.squ.portal.portlet.dao.LdapDao#getEmpNumber(java.lang.String)
 */
	public String  getEmpNumber(String userName)
	{
		String empNumber;
		try
		{
			empNumber = getEmpNumberLst(getCorrectUserName(userName)).get(0).toString();
		}
		catch(CommunicationException commEx )
		{
			empNumber = getEmpNumberLstAlternate(getCorrectUserName(userName)).get(0).toString();
			logger.error("communication with ldap failed", commEx.getExplanation());
		}
		return empNumber;
	}

	
/**
 * Get employee number from Ldap 	
 * @param userName
 * @return
 */
	@SuppressWarnings("deprecation")
	private List getEmpNumberLst(String userName) 
	{
		EqualsFilter filter = new EqualsFilter(Constants.LDAP_COMMON_NAME, userName);			// Ldap common name (cn=) attribute

		return ldapTemplate.search(
										DistinguishedName.EMPTY_PATH, filter.encode(), 
										new AttributesMapper() 
										{
											public Object mapFromAttributes(Attributes attrs) throws NamingException 
											{
												return attrs.get(Constants.LDAP_EMPLOYEE_NUMBER).get(); //get Ldap attribute
											}
										}							
									);
	}

	
	
	private List getEmpNumberLstAlternate(String userName) 
	{
		EqualsFilter filter = new EqualsFilter(Constants.LDAP_COMMON_NAME, userName);			// Ldap common name (cn=) attribute

		return ldapTemplate2.search(
										DistinguishedName.EMPTY_PATH, filter.encode(), 
										new AttributesMapper() 
										{
											public Object mapFromAttributes(Attributes attrs) throws NamingException 
											{
												return attrs.get(Constants.LDAP_EMPLOYEE_NUMBER2).get(); //get Ldap attribute
											}
										}							
									);
	}

	/**
	 * Correct User Name - Modify the username from request object
	 * @param userName
	 * @return String user name
	 */
	public String getCorrectUserName(String userName)
	{
		String correctUserName	=	null;
		if(userName.indexOf("[")>0)											// find Remove unwanted data with "[xx]"
		{
			correctUserName	=	userName.substring(0, userName.indexOf("["));
		}
		else
		{
			correctUserName = userName;
		}
		return correctUserName;
	}
	
	
}
