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
 * File Name			:	TranscriptDbDao.java
 * Package Name			:	om.edu.squ.squportal.portlet.transcript.dao.db
 * Date of creation		:	May 20, 2015  12:50:54 PM
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
package om.edu.squ.squportal.portlet.transcript.dao.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

import om.edu.squ.squportal.portlet.transcript.dao.bo.GradeSemester;
import om.edu.squ.squportal.portlet.transcript.dao.bo.Postpone;
import om.edu.squ.squportal.portlet.transcript.dao.bo.RegistrationBO;
import om.edu.squ.squportal.portlet.transcript.dao.bo.Student;
import om.edu.squ.squportal.portlet.transcript.dao.bo.StudentStatus;
import om.edu.squ.squportal.portlet.transcript.utility.Constants;

/**
 * @author Bhabesh
 *
 */
public interface TranscriptDbDao
{
	/**
	 * 
	 * method name  : getStudentList
	 * @param studentId
	 * @param locale TODO
	 * @return
	 * TranscriptDbDao
	 * return type  : List<Student>
	 * 
	 * purpose		: List of student details
	 *
	 * Date    		:	Aug 13, 2018 10:45:54 AM
	 */
	public List<Student> getStudentList(String studentId, Locale locale);
	
	/**
	 * 
	 * method name  : getStudent
	 * @param stdStatCode
	 * @param locale
	 * @return
	 * TranscriptDbDao
	 * return type  : Student
	 * 
	 * purpose		:	Get student details of particular degree
	 *
	 * Date    		:	Sep 5, 2018 3:59:42 PM
	 */
	public Student getStudent(String stdStatCode, Locale locale);
	
	/**
	 * 	
	 * method name  : getStudentStatusList
	 * @param studentNo TODO
	 * @param stdStatCode
	 * @param collegeName
	 * @return
	 * TranscriptDbDao
	 * return type  : List<StudentStatus>
	 * 
	 * purpose		: Get Status of student
	 *
	 * Date    		:	Oct 15, 2018 12:49:47 PM
	 */
	public List<StudentStatus>	getStudentStatusList(String studentNo, String stdStatCode, String collegeName);
	
	/**
	 * 
	 * method name  : getStudentGradeList
	 * @param studentNo
	 * @param semester
	 * @param courseYear
	 * @return
	 * TranscriptDbDao
	 * return type  : List<GradeSemester>
	 * 
	 * purpose		: 
	 *
	 * Date    		:	Oct 25, 2018 2:16:38 PM
	 */
	public List<GradeSemester>  getStudentGradeList(String studentNo, String semester, int courseYear );
	
	/**
	 * 
	 * method name  : getRegistrationList
	 * @param stdStatCode
	 * @param collegeName
	 * @return
	 * TranscriptDbDao
	 * return type  : List<RegistrationBO>
	 * 
	 * purpose		:
	 *
	 * Date    		:	Nov 12, 2018 1:53:21 PM
	 */
	public List<RegistrationBO> getRegistrationList(String stdStatCode,  String collegeName);
	
	/**
	 * 
	 * method name  : getPostponeList
	 * @param stdStatCode
	 * @return
	 * TranscriptDbDao
	 * return type  : List<Postpone>
	 * 
	 * purpose		:
	 *
	 * Date    		:	Nov 13, 2018 12:51:26 PM
	 */
	public List<Postpone>  getPostponeList(String stdStatCode);

}
