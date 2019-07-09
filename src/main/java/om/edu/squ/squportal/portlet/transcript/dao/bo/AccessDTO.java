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
 * File Name			:	AccessDTO.java
 * Package Name			:	om.edu.squ.squportal.portlet.transcript.dao.bo
 * Date of creation		:	Jan 8, 2019  10:13:50 AM
 * Date of modification :	
 * 
 * Summary				:	
 *
 *
 * Copyright 2019 the original author or authors and Organization.
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
package om.edu.squ.squportal.portlet.transcript.dao.bo;

/**
 * @author Bhabesh
 *
 */
public class AccessDTO
{
	private	String	roleAbrCode;
	private	String	accessDomain;
	private	String	accessLevel;
	/**
	 * Getter Method	: getRoleAbrCode
	 * @return the roleAbrCode
	 * 
	 * Date				: Jan 8, 2019
	 */
	public String getRoleAbrCode()
	{
		return this.roleAbrCode;
	}
	/**
	 * Setter method : setRoleAbrCode
	 * @param roleAbrCode the roleAbrCode to set
	 * 
	 * Date          : Jan 8, 2019 10:14:20 AM
	 */
	public void setRoleAbrCode(String roleAbrCode)
	{
		this.roleAbrCode = roleAbrCode;
	}
	/**
	 * Getter Method	: getAccessDomain
	 * @return the accessDomain
	 * 
	 * Date				: Jan 8, 2019
	 */
	public String getAccessDomain()
	{
		return this.accessDomain;
	}
	/**
	 * Setter method : setAccessDomain
	 * @param accessDomain the accessDomain to set
	 * 
	 * Date          : Jan 8, 2019 10:14:20 AM
	 */
	public void setAccessDomain(String accessDomain)
	{
		this.accessDomain = accessDomain;
	}
	/**
	 * Getter Method	: getAccessLevel
	 * @return the accessLevel
	 * 
	 * Date				: Jan 8, 2019
	 */
	public String getAccessLevel()
	{
		return this.accessLevel;
	}
	/**
	 * Setter method : setAccessLevel
	 * @param accessLevel the accessLevel to set
	 * 
	 * Date          : Jan 8, 2019 10:14:20 AM
	 */
	public void setAccessLevel(String accessLevel)
	{
		this.accessLevel = accessLevel;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "AccessDTO [roleAbrCode=" + this.roleAbrCode + ", accessDomain="
				+ this.accessDomain + ", accessLevel=" + this.accessLevel + "]";
	}
	
	
	
}
