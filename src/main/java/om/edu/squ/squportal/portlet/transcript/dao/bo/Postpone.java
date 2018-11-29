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
 * File Name			:	Postpone.java
 * Package Name			:	om.edu.squ.squportal.portlet.transcript.dao.bo
 * Date of creation		:	Nov 13, 2018  12:39:27 PM
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

/**
 * @author Bhabesh
 *
 */
public class Postpone
{
	private	String	fromYrSem;
	private	String	toYrSem;
	private	String	postponeDate;
	/**
	 * Getter Method	: getFromYrSem
	 * @return the fromYrSem
	 * 
	 * Date				: Nov 13, 2018
	 */
	public String getFromYrSem()
	{
		return this.fromYrSem;
	}
	/**
	 * Setter method : setFromYrSem
	 * @param fromYrSem the fromYrSem to set
	 * 
	 * Date          : Nov 13, 2018 12:40:26 PM
	 */
	public void setFromYrSem(String fromYrSem)
	{
		this.fromYrSem = fromYrSem;
	}
	/**
	 * Getter Method	: getToYrSem
	 * @return the toYrSem
	 * 
	 * Date				: Nov 13, 2018
	 */
	public String getToYrSem()
	{
		return this.toYrSem;
	}
	/**
	 * Setter method : setToYrSem
	 * @param toYrSem the toYrSem to set
	 * 
	 * Date          : Nov 13, 2018 12:40:26 PM
	 */
	public void setToYrSem(String toYrSem)
	{
		this.toYrSem = toYrSem;
	}
	/**
	 * Getter Method	: getPostponeDate
	 * @return the postponeDate
	 * 
	 * Date				: Nov 13, 2018
	 */
	public String getPostponeDate()
	{
		return this.postponeDate;
	}
	/**
	 * Setter method : setPostponeDate
	 * @param postponeDate the postponeDate to set
	 * 
	 * Date          : Nov 13, 2018 12:40:26 PM
	 */
	public void setPostponeDate(String postponeDate)
	{
		this.postponeDate = postponeDate;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Postpone [fromYrSem=" + this.fromYrSem + ", toYrSem="
				+ this.toYrSem + ", postponeDate=" + this.postponeDate + "]";
	}
	
	
}
