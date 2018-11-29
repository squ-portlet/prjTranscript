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
 * File Name			:	GradeSemester.java
 * Package Name			:	om.edu.squ.squportal.portlet.transcript.dao.bo
 * Date of creation		:	Oct 25, 2018  1:39:21 PM
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
public class GradeSemester
{
	private	String	courseNo;
	private	String	courseName;
	private	int		courseCredit;
	private	String	courseCreditValue;
	private	int		courseGradePint;
	private	String	previousCourseNo;
	private	int		previousCourseYear;
	private	int		previousSemester;
	private	String	repeated;
	/**
	 * Getter Method	: getCourseNo
	 * @return the courseNo
	 * 
	 * Date				: Oct 25, 2018
	 */
	public String getCourseNo()
	{
		return this.courseNo;
	}
	/**
	 * Setter method : setCourseNo
	 * @param courseNo the courseNo to set
	 * 
	 * Date          : Oct 25, 2018 1:48:53 PM
	 */
	public void setCourseNo(String courseNo)
	{
		this.courseNo = courseNo;
	}
	/**
	 * Getter Method	: getCourseName
	 * @return the courseName
	 * 
	 * Date				: Oct 25, 2018
	 */
	public String getCourseName()
	{
		return this.courseName;
	}
	/**
	 * Setter method : setCourseName
	 * @param courseName the courseName to set
	 * 
	 * Date          : Oct 25, 2018 1:48:53 PM
	 */
	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}
	/**
	 * Getter Method	: getCourseCredit
	 * @return the courseCredit
	 * 
	 * Date				: Oct 25, 2018
	 */
	public int getCourseCredit()
	{
		return this.courseCredit;
	}
	/**
	 * Setter method : setCourseCredit
	 * @param courseCredit the courseCredit to set
	 * 
	 * Date          : Oct 25, 2018 1:48:53 PM
	 */
	public void setCourseCredit(int courseCredit)
	{
		this.courseCredit = courseCredit;
	}
	/**
	 * Getter Method	: getCourseCreditValue
	 * @return the courseCreditValue
	 * 
	 * Date				: Oct 25, 2018
	 */
	public String getCourseCreditValue()
	{
		return this.courseCreditValue;
	}
	/**
	 * Setter method : setCourseCreditValue
	 * @param courseCreditValue the courseCreditValue to set
	 * 
	 * Date          : Oct 25, 2018 1:48:53 PM
	 */
	public void setCourseCreditValue(String courseCreditValue)
	{
		this.courseCreditValue = courseCreditValue;
	}
	/**
	 * Getter Method	: getCourseGradePint
	 * @return the courseGradePint
	 * 
	 * Date				: Oct 25, 2018
	 */
	public int getCourseGradePint()
	{
		return this.courseGradePint;
	}
	/**
	 * Setter method : setCourseGradePint
	 * @param courseGradePint the courseGradePint to set
	 * 
	 * Date          : Oct 25, 2018 1:48:53 PM
	 */
	public void setCourseGradePint(int courseGradePint)
	{
		this.courseGradePint = courseGradePint;
	}
	/**
	 * Getter Method	: getPreviousCourseNo
	 * @return the previousCourseNo
	 * 
	 * Date				: Oct 25, 2018
	 */
	public String getPreviousCourseNo()
	{
		return this.previousCourseNo;
	}
	/**
	 * Setter method : setPreviousCourseNo
	 * @param previousCourseNo the previousCourseNo to set
	 * 
	 * Date          : Oct 25, 2018 1:48:53 PM
	 */
	public void setPreviousCourseNo(String previousCourseNo)
	{
		this.previousCourseNo = previousCourseNo;
	}
	/**
	 * Getter Method	: getPreviousCourseYear
	 * @return the previousCourseYear
	 * 
	 * Date				: Oct 25, 2018
	 */
	public int getPreviousCourseYear()
	{
		return this.previousCourseYear;
	}
	/**
	 * Setter method : setPreviousCourseYear
	 * @param previousCourseYear the previousCourseYear to set
	 * 
	 * Date          : Oct 25, 2018 1:48:53 PM
	 */
	public void setPreviousCourseYear(int previousCourseYear)
	{
		this.previousCourseYear = previousCourseYear;
	}
	/**
	 * Getter Method	: getPreviousSemester
	 * @return the previousSemester
	 * 
	 * Date				: Oct 25, 2018
	 */
	public int getPreviousSemester()
	{
		return this.previousSemester;
	}
	/**
	 * Setter method : setPreviousSemester
	 * @param previousSemester the previousSemester to set
	 * 
	 * Date          : Oct 25, 2018 1:48:53 PM
	 */
	public void setPreviousSemester(int previousSemester)
	{
		this.previousSemester = previousSemester;
	}
	/**
	 * Getter Method	: getRepeated
	 * @return the repeated
	 * 
	 * Date				: Oct 25, 2018
	 */
	public String getRepeated()
	{
		return this.repeated;
	}
	/**
	 * Setter method : setRepeated
	 * @param repeated the repeated to set
	 * 
	 * Date          : Oct 25, 2018 1:48:53 PM
	 */
	public void setRepeated(String repeated)
	{
		this.repeated = repeated;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "GradeSemester [courseNo=" + this.courseNo + ", courseName="
				+ this.courseName + ", courseCredit=" + this.courseCredit
				+ ", courseCreditValue=" + this.courseCreditValue
				+ ", courseGradePint=" + this.courseGradePint
				+ ", previousCourseNo=" + this.previousCourseNo
				+ ", previousCourseYear=" + this.previousCourseYear
				+ ", previousSemester=" + this.previousSemester + ", repeated="
				+ this.repeated + "]";
	}
	
	
}
