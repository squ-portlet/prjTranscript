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
 * File Name			:	Student.java
 * Package Name			:	om.edu.squ.squportal.portlet.transcript.dao.bo
 * Date of creation		:	Aug 12, 2018  2:30:27 PM
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
public class Student
{
	private	String 	studentId;
	private	String	studentNo;
	private	String	stdStatCode;
	private	String	gender;
	private	String	birthDay;
	private	int		cohort;
	private	String	studentName;
	private	String	collegeCode;
	private	String	collegeName;
	private	String	majorCode;
	private	String	majorName;
	private	String	minorCode;
	private	String	minorName;
	private	String	firstMajor;
	private	String	firstCollege;
	private	String	specCode;
	private	String	specName;
	private	int		degreeNumber;
	private	String	degreeName;
	private	String	empNumberAdvisor;
	private	String	empNumberAdvisor2;
	private	String	lAbrStatus;
	private	String	statusName;
	private	int		totalCreditTaken;
	private	int		totalCreditEarned;
	private	boolean	active;
	/**
	 * Getter Method	: getStudentId
	 * @return the studentId
	 * 
	 * Date				: Aug 12, 2018
	 */
	public String getStudentId()
	{
		return this.studentId;
	}
	/**
	 * Setter method : setStudentId
	 * @param studentId the studentId to set
	 * 
	 * Date          : Aug 12, 2018 2:40:20 PM
	 */
	public void setStudentId(String studentId)
	{
		this.studentId = studentId;
	}
	/**
	 * Getter Method	: getStudentNo
	 * @return the studentNo
	 * 
	 * Date				: Aug 12, 2018
	 */
	public String getStudentNo()
	{
		return this.studentNo;
	}
	/**
	 * Setter method : setStudentNo
	 * @param studentNo the studentNo to set
	 * 
	 * Date          : Aug 12, 2018 2:40:20 PM
	 */
	public void setStudentNo(String studentNo)
	{
		this.studentNo = studentNo;
	}
	/**
	 * Getter Method	: getStdStatCode
	 * @return the stdStatCode
	 * 
	 * Date				: Aug 12, 2018
	 */
	public String getStdStatCode()
	{
		return this.stdStatCode;
	}
	/**
	 * Setter method : setStdStatCode
	 * @param stdStatCode the stdStatCode to set
	 * 
	 * Date          : Aug 12, 2018 2:40:20 PM
	 */
	public void setStdStatCode(String stdStatCode)
	{
		this.stdStatCode = stdStatCode;
	}
	/**
	 * Getter Method	: getGender
	 * @return the gender
	 * 
	 * Date				: Aug 12, 2018
	 */
	public String getGender()
	{
		return this.gender;
	}
	
	/**
	 * Getter Method	: getBirthDay
	 * @return the birthDay
	 * 
	 * Date				: Aug 27, 2018
	 */
	public String getBirthDay()
	{
		return this.birthDay;
	}
	/**
	 * Setter method : setBirthDay
	 * @param birthDay the birthDay to set
	 * 
	 * Date          : Aug 27, 2018 9:46:23 AM
	 */
	public void setBirthDay(String birthDay)
	{
		this.birthDay = birthDay;
	}
	/**
	 * Setter method : setGender
	 * @param gender the gender to set
	 * 
	 * Date          : Aug 12, 2018 2:40:20 PM
	 */
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	/**
	 * Getter Method	: getCohort
	 * @return the cohort
	 * 
	 * Date				: Aug 12, 2018
	 */
	public int getCohort()
	{
		return this.cohort;
	}
	/**
	 * Setter method : setCohort
	 * @param cohort the cohort to set
	 * 
	 * Date          : Aug 12, 2018 2:40:20 PM
	 */
	public void setCohort(int cohort)
	{
		this.cohort = cohort;
	}
	/**
	 * Getter Method	: getStudentName
	 * @return the studentName
	 * 
	 * Date				: Aug 12, 2018
	 */
	public String getStudentName()
	{
		return this.studentName;
	}
	/**
	 * Setter method : setStudentName
	 * @param studentName the studentName to set
	 * 
	 * Date          : Aug 12, 2018 2:40:20 PM
	 */
	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
	}
	/**
	 * Getter Method	: getCollegeCode
	 * @return the collegeCode
	 * 
	 * Date				: Aug 12, 2018
	 */
	public String getCollegeCode()
	{
		return this.collegeCode;
	}
	/**
	 * Setter method : setCollegeCode
	 * @param collegeCode the collegeCode to set
	 * 
	 * Date          : Aug 12, 2018 2:40:20 PM
	 */
	public void setCollegeCode(String collegeCode)
	{
		this.collegeCode = collegeCode;
	}
	/**
	 * Getter Method	: getCollegeName
	 * @return the collegeName
	 * 
	 * Date				: Aug 12, 2018
	 */
	public String getCollegeName()
	{
		return this.collegeName;
	}
	/**
	 * Setter method : setCollegeName
	 * @param collegeName the collegeName to set
	 * 
	 * Date          : Aug 12, 2018 2:40:20 PM
	 */
	public void setCollegeName(String collegeName)
	{
		this.collegeName = collegeName;
	}
	/**
	 * Getter Method	: getMajorCode
	 * @return the majorCode
	 * 
	 * Date				: Aug 12, 2018
	 */
	public String getMajorCode()
	{
		return this.majorCode;
	}
	/**
	 * Setter method : setMajorCode
	 * @param majorCode the majorCode to set
	 * 
	 * Date          : Aug 12, 2018 2:40:21 PM
	 */
	public void setMajorCode(String majorCode)
	{
		this.majorCode = majorCode;
	}
	/**
	 * Getter Method	: getMajorName
	 * @return the majorName
	 * 
	 * Date				: Aug 12, 2018
	 */
	public String getMajorName()
	{
		return this.majorName;
	}
	/**
	 * Setter method : setMajorName
	 * @param majorName the majorName to set
	 * 
	 * Date          : Aug 12, 2018 2:40:21 PM
	 */
	public void setMajorName(String majorName)
	{
		this.majorName = majorName;
	}
	/**
	 * Getter Method	: getMinorCode
	 * @return the minorCode
	 * 
	 * Date				: Aug 12, 2018
	 */
	public String getMinorCode()
	{
		return this.minorCode;
	}
	/**
	 * Setter method : setMinorCode
	 * @param minorCode the minorCode to set
	 * 
	 * Date          : Aug 12, 2018 2:40:21 PM
	 */
	public void setMinorCode(String minorCode)
	{
		this.minorCode = minorCode;
	}
	/**
	 * Getter Method	: getMinorName
	 * @return the minorName
	 * 
	 * Date				: Aug 12, 2018
	 */
	public String getMinorName()
	{
		return this.minorName;
	}
	/**
	 * Setter method : setMinorName
	 * @param minorName the minorName to set
	 * 
	 * Date          : Aug 12, 2018 2:40:21 PM
	 */
	public void setMinorName(String minorName)
	{
		this.minorName = minorName;
	}
	
	/**
	 * Getter Method	: getFirstMajor
	 * @return the firstMajor
	 * 
	 * Date				: Oct 14, 2018
	 */
	public String getFirstMajor()
	{
		return this.firstMajor;
	}
	/**
	 * Setter method : setFirstMajor
	 * @param firstMajor the firstMajor to set
	 * 
	 * Date          : Oct 14, 2018 9:37:57 AM
	 */
	public void setFirstMajor(String firstMajor)
	{
		this.firstMajor = firstMajor;
	}
	/**
	 * Getter Method	: getFirstCollege
	 * @return the firstCollege
	 * 
	 * Date				: Oct 14, 2018
	 */
	public String getFirstCollege()
	{
		return this.firstCollege;
	}
	/**
	 * Setter method : setFirstCollege
	 * @param firstCollege the firstCollege to set
	 * 
	 * Date          : Oct 14, 2018 9:37:57 AM
	 */
	public void setFirstCollege(String firstCollege)
	{
		this.firstCollege = firstCollege;
	}
	/**
	 * Getter Method	: getSpecCode
	 * @return the specCode
	 * 
	 * Date				: Aug 12, 2018
	 */
	public String getSpecCode()
	{
		return this.specCode;
	}
	/**
	 * Setter method : setSpecCode
	 * @param specCode the specCode to set
	 * 
	 * Date          : Aug 12, 2018 2:40:21 PM
	 */
	public void setSpecCode(String specCode)
	{
		this.specCode = specCode;
	}
	/**
	 * Getter Method	: getSpecName
	 * @return the specName
	 * 
	 * Date				: Aug 12, 2018
	 */
	public String getSpecName()
	{
		return this.specName;
	}
	/**
	 * Setter method : setSpecName
	 * @param specName the specName to set
	 * 
	 * Date          : Aug 12, 2018 2:40:21 PM
	 */
	public void setSpecName(String specName)
	{
		this.specName = specName;
	}
	
	/**
	 * Getter Method	: getDegreeNumber
	 * @return the degreeNumber
	 * 
	 * Date				: Aug 26, 2018
	 */
	public int getDegreeNumber()
	{
		return this.degreeNumber;
	}
	/**
	 * Setter method : setDegreeNumber
	 * @param degreeNumber the degreeNumber to set
	 * 
	 * Date          : Aug 26, 2018 10:20:28 AM
	 */
	public void setDegreeNumber(int degreeNumber)
	{
		this.degreeNumber = degreeNumber;
	}
	/**
	 * Getter Method	: getDegreeName
	 * @return the degreeName
	 * 
	 * Date				: Aug 26, 2018
	 */
	public String getDegreeName()
	{
		return this.degreeName;
	}
	/**
	 * Setter method : setDegreeName
	 * @param degreeName the degreeName to set
	 * 
	 * Date          : Aug 26, 2018 10:20:28 AM
	 */
	public void setDegreeName(String degreeName)
	{
		this.degreeName = degreeName;
	}
	/**
	 * Getter Method	: getEmpNumberAdvisor
	 * @return the empNumberAdvisor
	 * 
	 * Date				: Aug 12, 2018
	 */
	public String getEmpNumberAdvisor()
	{
		return this.empNumberAdvisor;
	}
	/**
	 * Setter method : setEmpNumberAdvisor
	 * @param empNumberAdvisor the empNumberAdvisor to set
	 * 
	 * Date          : Aug 12, 2018 2:40:21 PM
	 */
	public void setEmpNumberAdvisor(String empNumberAdvisor)
	{
		this.empNumberAdvisor = empNumberAdvisor;
	}
	/**
	 * Getter Method	: getEmpNumberAdvisor2
	 * @return the empNumberAdvisor2
	 * 
	 * Date				: Aug 12, 2018
	 */
	public String getEmpNumberAdvisor2()
	{
		return this.empNumberAdvisor2;
	}
	/**
	 * Setter method : setEmpNumberAdvisor2
	 * @param empNumberAdvisor2 the empNumberAdvisor2 to set
	 * 
	 * Date          : Aug 12, 2018 2:40:21 PM
	 */
	public void setEmpNumberAdvisor2(String empNumberAdvisor2)
	{
		this.empNumberAdvisor2 = empNumberAdvisor2;
	}
	/**
	 * Getter Method	: getlAbrStatus
	 * @return the lAbrStatus
	 * 
	 * Date				: Aug 12, 2018
	 */
	public String getlAbrStatus()
	{
		return this.lAbrStatus;
	}
	/**
	 * Setter method : setlAbrStatus
	 * @param lAbrStatus the lAbrStatus to set
	 * 
	 * Date          : Aug 12, 2018 2:40:21 PM
	 */
	public void setlAbrStatus(String lAbrStatus)
	{
		this.lAbrStatus = lAbrStatus;
	}
	/**
	 * Getter Method	: getStatusName
	 * @return the statusName
	 * 
	 * Date				: Nov 1, 2018
	 */
	public String getStatusName()
	{
		return this.statusName;
	}
	/**
	 * Setter method : setStatusName
	 * @param statusName the statusName to set
	 * 
	 * Date          : Nov 1, 2018 10:43:47 AM
	 */
	public void setStatusName(String statusName)
	{
		this.statusName = statusName;
	}
	/**
	 * Getter Method	: getTotalCreditTaken
	 * @return the totalCreditTaken
	 * 
	 * Date				: Nov 4, 2018
	 */
	public int getTotalCreditTaken()
	{
		return this.totalCreditTaken;
	}
	/**
	 * Setter method : setTotalCreditTaken
	 * @param totalCreditTaken the totalCreditTaken to set
	 * 
	 * Date          : Nov 4, 2018 1:47:54 PM
	 */
	public void setTotalCreditTaken(int totalCreditTaken)
	{
		this.totalCreditTaken = totalCreditTaken;
	}
	/**
	 * Getter Method	: getTotalCreditEarned
	 * @return the totalCreditEarned
	 * 
	 * Date				: Nov 4, 2018
	 */
	public int getTotalCreditEarned()
	{
		return this.totalCreditEarned;
	}
	/**
	 * Setter method : setTotalCreditEarned
	 * @param totalCreditEarned the totalCreditEarned to set
	 * 
	 * Date          : Nov 4, 2018 1:47:54 PM
	 */
	public void setTotalCreditEarned(int totalCreditEarned)
	{
		this.totalCreditEarned = totalCreditEarned;
	}
	/**
	 * Getter Method	: isActive
	 * @return the active
	 * 
	 * Date				: Aug 13, 2018
	 */
	public boolean isActive()
	{
		return this.active;
	}
	/**
	 * Setter method : setActive
	 * @param active the active to set
	 * 
	 * Date          : Aug 13, 2018 10:28:37 AM
	 */
	public void setActive(boolean active)
	{
		this.active = active;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "Student [studentId=" + this.studentId + ", studentNo="
				+ this.studentNo + ", stdStatCode=" + this.stdStatCode
				+ ", gender=" + this.gender + ", birthDay=" + this.birthDay
				+ ", cohort=" + this.cohort + ", studentName="
				+ this.studentName + ", collegeCode=" + this.collegeCode
				+ ", collegeName=" + this.collegeName + ", majorCode="
				+ this.majorCode + ", majorName=" + this.majorName
				+ ", minorCode=" + this.minorCode + ", minorName="
				+ this.minorName + ", firstMajor=" + this.firstMajor
				+ ", firstCollege=" + this.firstCollege + ", specCode="
				+ this.specCode + ", specName=" + this.specName
				+ ", degreeNumber=" + this.degreeNumber + ", degreeName="
				+ this.degreeName + ", empNumberAdvisor="
				+ this.empNumberAdvisor + ", empNumberAdvisor2="
				+ this.empNumberAdvisor2 + ", lAbrStatus=" + this.lAbrStatus
				+ ", statusName=" + this.statusName + ", totalCreditTaken="
				+ this.totalCreditTaken + ", totalCreditEarned="
				+ this.totalCreditEarned + ", active=" + this.active + "]";
	}
	
	
	
}
