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
 * File Name			:	LdapDao.java
 * Package Name			:	om.edu.squ.squportal.portlet.transcript.dao.ldap
 * Date of creation		:	May 20, 2015  1:42:11 PM
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

/**
 * @author Bhabesh
 *
 */
public interface LdapDao
{
	/**
	 * 
	 * method name  : getEmpNumber
	 * @param userName
	 * @return
	 * LdapDao
	 * return type  : String
	 * 
	 * purpose		: Get Employee Number from LDAP
	 *
	 * Date    		:	Aug 4, 2012 11:38:19 AM
	 */
	public String getEmpNumber(String userName);
	/**
	 * 
	 * method name  : getCorrectUserName
	 * @param userName
	 * @return
	 * LdapDao
	 * return type  : String
	 * 
	 * purpose		: correct User Name
	 *
	 * Date    		:	Aug 4, 2012 11:38:26 AM
	 */
	public String getCorrectUserName(String userName);
}
