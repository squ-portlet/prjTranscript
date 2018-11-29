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
 * File Name			:	TranscriptModel.java
 * Package Name			:	om.edu.squ.squportal.portlet.transcript.model
 * Date of creation		:	Oct 10, 2018  10:08:33 AM
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
package om.edu.squ.squportal.portlet.transcript.model;

/**
 * @author Bhabesh
 *
 */
public class TranscriptModel
{
	private String	stdId;

	/**
	 * Getter Method	: getStdId
	 * @return the stdId
	 * 
	 * Date				: Oct 10, 2018
	 */
	public String getStdId()
	{
		return this.stdId;
	}

	/**
	 * Setter method : setStdId
	 * @param stdId the stdId to set
	 * 
	 * Date          : Oct 10, 2018 10:11:13 AM
	 */
	public void setStdId(String stdId)
	{
		this.stdId = stdId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "TranscriptModel [stdId=" + this.stdId + "]";
	}
	
	
	
}
