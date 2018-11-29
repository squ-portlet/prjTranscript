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
 * File Name			:	StudentStatus.java
 * Package Name			:	om.edu.squ.squportal.portlet.transcript.dao.bo
 * Date of creation		:	Oct 15, 2018  8:36:22 AM
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

import java.util.List;

/**
 * @author Bhabesh
 *
 */
public class StudentStatus
{
	private	float				semGPA;
	private	float				cumGPA;
	private	int					creditEarned;
	private	int					creditTaken;
	private	int					courseYear;
	private	int					semesterCode;
	private	String				semesterName;
	private	float				gradePoint;
	private	float				gradePointCummulative;
	private	int					creditTakenCummulative;
	private	String				loadStatusSemester;
	private	String				loadStatusStudent;
	private	String				honorDistinction;
	private	String				excellentList;
	private	String				history;
	private	List<GradeSemester>	gradeSemesters;
	
	
	/**
	 * Getter Method	: getSemGPA
	 * @return the semGPA
	 * 
	 * Date				: Oct 15, 2018
	 */
	public float getSemGPA()
	{
		return this.semGPA;
	}
	/**
	 * Setter method : setSemGPA
	 * @param semGPA the semGPA to set
	 * 
	 * Date          : Oct 15, 2018 8:53:23 AM
	 */
	public void setSemGPA(float semGPA)
	{
		this.semGPA = semGPA;
	}
	/**
	 * Getter Method	: getCumGPA
	 * @return the cumGPA
	 * 
	 * Date				: Oct 15, 2018
	 */
	public float getCumGPA()
	{
		return this.cumGPA;
	}
	/**
	 * Setter method : setCumGPA
	 * @param cumGPA the cumGPA to set
	 * 
	 * Date          : Oct 15, 2018 8:53:23 AM
	 */
	public void setCumGPA(float cumGPA)
	{
		this.cumGPA = cumGPA;
	}
	/**
	 * Getter Method	: getCreditEarned
	 * @return the creditEarned
	 * 
	 * Date				: Oct 15, 2018
	 */
	public int getCreditEarned()
	{
		return this.creditEarned;
	}
	/**
	 * Setter method : setCreditEarned
	 * @param creditEarned the creditEarned to set
	 * 
	 * Date          : Oct 15, 2018 8:53:23 AM
	 */
	public void setCreditEarned(int creditEarned)
	{
		this.creditEarned = creditEarned;
	}
	/**
	 * Getter Method	: getCreditTaken
	 * @return the creditTaken
	 * 
	 * Date				: Oct 15, 2018
	 */
	public int getCreditTaken()
	{
		return this.creditTaken;
	}
	/**
	 * Setter method : setCreditTaken
	 * @param creditTaken the creditTaken to set
	 * 
	 * Date          : Oct 15, 2018 8:53:23 AM
	 */
	public void setCreditTaken(int creditTaken)
	{
		this.creditTaken = creditTaken;
	}
	/**
	 * Getter Method	: getCourseYear
	 * @return the courseYear
	 * 
	 * Date				: Oct 15, 2018
	 */
	public int getCourseYear()
	{
		return this.courseYear;
	}
	/**
	 * Setter method : setCourseYear
	 * @param courseYear the courseYear to set
	 * 
	 * Date          : Oct 15, 2018 8:53:23 AM
	 */
	public void setCourseYear(int courseYear)
	{
		this.courseYear = courseYear;
	}
	/**
	 * Getter Method	: getSemesterCode
	 * @return the semesterCode
	 * 
	 * Date				: Oct 15, 2018
	 */
	public int getSemesterCode()
	{
		return this.semesterCode;
	}
	/**
	 * Setter method : setSemesterCode
	 * @param semesterCode the semesterCode to set
	 * 
	 * Date          : Oct 15, 2018 8:53:23 AM
	 */
	public void setSemesterCode(int semesterCode)
	{
		this.semesterCode = semesterCode;
	}
	/**
	 * Getter Method	: getSemesterName
	 * @return the semesterName
	 * 
	 * Date				: Oct 15, 2018
	 */
	public String getSemesterName()
	{
		return this.semesterName;
	}
	/**
	 * Setter method : setSemesterName
	 * @param semesterName the semesterName to set
	 * 
	 * Date          : Oct 15, 2018 8:53:23 AM
	 */
	public void setSemesterName(String semesterName)
	{
		this.semesterName = semesterName;
	}
	/**
	 * Getter Method	: getGradePoint
	 * @return the gradePoint
	 * 
	 * Date				: Oct 15, 2018
	 */
	public float getGradePoint()
	{
		return this.gradePoint;
	}
	/**
	 * Setter method : setGradePoint
	 * @param gradePoint the gradePoint to set
	 * 
	 * Date          : Oct 15, 2018 8:53:23 AM
	 */
	public void setGradePoint(float gradePoint)
	{
		this.gradePoint = gradePoint;
	}
	/**
	 * Getter Method	: getGradePointCummulative
	 * @return the gradePointCummulative
	 * 
	 * Date				: Oct 15, 2018
	 */
	public float getGradePointCummulative()
	{
		return this.gradePointCummulative;
	}
	/**
	 * Setter method : setGradePointCummulative
	 * @param gradePointCummulative the gradePointCummulative to set
	 * 
	 * Date          : Oct 15, 2018 8:53:23 AM
	 */
	public void setGradePointCummulative(float gradePointCummulative)
	{
		this.gradePointCummulative = gradePointCummulative;
	}
	/**
	 * Getter Method	: getCreditTakenCummulative
	 * @return the creditTakenCummulative
	 * 
	 * Date				: Oct 15, 2018
	 */
	public int getCreditTakenCummulative()
	{
		return this.creditTakenCummulative;
	}
	/**
	 * Setter method : setCreditTakenCummulative
	 * @param creditTakenCummulative the creditTakenCummulative to set
	 * 
	 * Date          : Oct 15, 2018 8:53:23 AM
	 */
	public void setCreditTakenCummulative(int creditTakenCummulative)
	{
		this.creditTakenCummulative = creditTakenCummulative;
	}
	/**
	 * Getter Method	: getLoadStatusSemester
	 * @return the loadStatusSemester
	 * 
	 * Date				: Oct 15, 2018
	 */
	public String getLoadStatusSemester()
	{
		return this.loadStatusSemester;
	}
	/**
	 * Setter method : setLoadStatusSemester
	 * @param loadStatusSemester the loadStatusSemester to set
	 * 
	 * Date          : Oct 15, 2018 8:53:23 AM
	 */
	public void setLoadStatusSemester(String loadStatusSemester)
	{
		this.loadStatusSemester = loadStatusSemester;
	}
	/**
	 * Getter Method	: getLoadStatusStudent
	 * @return the loadStatusStudent
	 * 
	 * Date				: Oct 15, 2018
	 */
	public String getLoadStatusStudent()
	{
		return this.loadStatusStudent;
	}
	/**
	 * Setter method : setLoadStatusStudent
	 * @param loadStatusStudent the loadStatusStudent to set
	 * 
	 * Date          : Oct 15, 2018 8:53:23 AM
	 */
	public void setLoadStatusStudent(String loadStatusStudent)
	{
		this.loadStatusStudent = loadStatusStudent;
	}
	/**
	 * Getter Method	: getHonorDistinction
	 * @return the honorDistinction
	 * 
	 * Date				: Oct 15, 2018
	 */
	public String getHonorDistinction()
	{
		return this.honorDistinction;
	}
	/**
	 * Setter method : setHonorDistinction
	 * @param honorDistinction the honorDistinction to set
	 * 
	 * Date          : Oct 15, 2018 8:53:23 AM
	 */
	public void setHonorDistinction(String honorDistinction)
	{
		this.honorDistinction = honorDistinction;
	}
	/**
	 * Getter Method	: getExcellentList
	 * @return the excellentList
	 * 
	 * Date				: Oct 15, 2018
	 */
	public String getExcellentList()
	{
		return this.excellentList;
	}
	/**
	 * Setter method : setExcellentList
	 * @param excellentList the excellentList to set
	 * 
	 * Date          : Oct 15, 2018 8:53:23 AM
	 */
	public void setExcellentList(String excellentList)
	{
		this.excellentList = excellentList;
	}
	/**
	 * Getter Method	: getHistory
	 * @return the history
	 * 
	 * Date				: Oct 15, 2018
	 */
	public String getHistory()
	{
		return this.history;
	}
	/**
	 * Setter method : setHistory
	 * @param history the history to set
	 * 
	 * Date          : Oct 15, 2018 8:53:23 AM
	 */
	public void setHistory(String history)
	{
		this.history = history;
	}
	/**
	 * Getter Method	: getGradeSemesters
	 * @return the gradeSemesters
	 * 
	 * Date				: Oct 28, 2018
	 */
	public List<GradeSemester> getGradeSemesters()
	{
		return this.gradeSemesters;
	}
	/**
	 * Setter method : setGradeSemesters
	 * @param gradeSemesters the gradeSemesters to set
	 * 
	 * Date          : Oct 28, 2018 8:26:20 AM
	 */
	public void setGradeSemesters(List<GradeSemester> gradeSemesters)
	{
		this.gradeSemesters = gradeSemesters;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString()
	{
		return "StudentStatus [semGPA=" + this.semGPA + ", cumGPA="
				+ this.cumGPA + ", creditEarned=" + this.creditEarned
				+ ", creditTaken=" + this.creditTaken + ", courseYear="
				+ this.courseYear + ", semesterCode=" + this.semesterCode
				+ ", semesterName=" + this.semesterName + ", gradePoint="
				+ this.gradePoint + ", gradePointCummulative="
				+ this.gradePointCummulative + ", creditTakenCummulative="
				+ this.creditTakenCummulative + ", loadStatusSemester="
				+ this.loadStatusSemester + ", loadStatusStudent="
				+ this.loadStatusStudent + ", honorDistinction="
				+ this.honorDistinction + ", excellentList="
				+ this.excellentList + ", history=" + this.history
				+ ", gradeSemesters=" + this.gradeSemesters + "]";
	}
	
	
	
}
