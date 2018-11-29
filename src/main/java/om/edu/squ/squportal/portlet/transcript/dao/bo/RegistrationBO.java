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
 * File Name			:	RegistrationBO.java
 * Package Name			:	om.edu.squ.squportal.portlet.transcript.dao.bo
 * Date of creation		:	Nov 12, 2018  1:17:57 PM
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
public class RegistrationBO
{
	private	GradeSemester	gradeSemester;
	private	StudentStatus	studentStatus;
	private	String			lAbrStatus;
	/**
	 * Getter Method	: getGradeSemester
	 * @return the gradeSemester
	 * 
	 * Date				: Nov 12, 2018
	 */
	public GradeSemester getGradeSemester()
	{
		return this.gradeSemester;
	}
	/**
	 * Setter method : setGradeSemester
	 * @param gradeSemester the gradeSemester to set
	 * 
	 * Date          : Nov 12, 2018 1:19:06 PM
	 */
	public void setGradeSemester(GradeSemester gradeSemester)
	{
		this.gradeSemester = gradeSemester;
	}
	/**
	 * Getter Method	: getStudentStatus
	 * @return the studentStatus
	 * 
	 * Date				: Nov 12, 2018
	 */
	public StudentStatus getStudentStatus()
	{
		return this.studentStatus;
	}
	/**
	 * Setter method : setStudentStatus
	 * @param studentStatus the studentStatus to set
	 * 
	 * Date          : Nov 12, 2018 1:19:06 PM
	 */
	public void setStudentStatus(StudentStatus studentStatus)
	{
		this.studentStatus = studentStatus;
	}
	/**
	 * Getter Method	: getlAbrStatus
	 * @return the lAbrStatus
	 * 
	 * Date				: Nov 12, 2018
	 */
	public String getlAbrStatus()
	{
		return this.lAbrStatus;
	}
	/**
	 * Setter method : setlAbrStatus
	 * @param lAbrStatus the lAbrStatus to set
	 * 
	 * Date          : Nov 12, 2018 1:19:06 PM
	 */
	public void setlAbrStatus(String lAbrStatus)
	{
		this.lAbrStatus = lAbrStatus;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "RegistrationBO [gradeSemester=" + this.gradeSemester
				+ ", studentStatus=" + this.studentStatus + ", lAbrStatus="
				+ this.lAbrStatus + "]";
	}
	
	
}
