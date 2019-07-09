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
 * File Name			:	User.java
 * Package Name			:	om.edu.squ.squportal.portlet.transcript.dao.bo
 * Date of creation		:	Dec 3, 2018
 * Date of modification :	
 * 
 * Summary				:	
 *
 *
 * Copyright 2018 the original author or authors and Organization.
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

import java.io.Serializable;

/**
 * @author Bhabesh
 *
 */
public class User implements Serializable
{
	private static final long	serialVersionUID	= 1L;
	
	private String	userId;
	private	String	userType;
	/**
	 * Getter Method	: getUserId
	 * @return the userId
	 * 
	 * Date				: Jan 5, 2017
	 */
	public String getUserId()
	{
		return this.userId;
	}
	/**
	 * Setter method : setUserId
	 * @param userId the userId to set
	 * 
	 * Date          : Jan 5, 2017 3:14:48 PM
	 */
	public void setUserId(String userId)
	{
		this.userId = userId;
	}
	/**
	 * Getter Method	: getUserType
	 * @return the userType
	 * 
	 * Date				: Jan 5, 2017
	 */
	public String getUserType()
	{
		return this.userType;
	}
	/**
	 * Setter method : setUserType
	 * @param userType the userType to set
	 * 
	 * Date          : Jan 5, 2017 3:14:48 PM
	 */
	public void setUserType(String userType)
	{
		this.userType = userType;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "User [userId=" + this.userId + ", userType=" + this.userType
				+ "]";
	}
	
	
}
