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
 * File Name			:	TranscriptDbImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.transcript.dao.db
 * Date of creation		:	May 20, 2015  12:49:49 PM
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
import java.util.Properties;

import om.edu.squ.squportal.portlet.transcript.dao.bo.Student;
import om.edu.squ.squportal.portlet.transcript.dao.bo.StudentStatus;
import om.edu.squ.squportal.portlet.transcript.utility.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * @author Bhabesh
 *
 */
public class TranscriptDbImpl implements TranscriptDbDao
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private	NamedParameterJdbcTemplate	namedParameterJdbcTemplate;
	private	Properties					queryProps;
	
	/**
	 * 
	 * method name  : setNamedParameterJdbcTemplate
	 * @param namedParameterJdbcTemplate
	 * TranscriptDbImpl
	 * return type  : void
	 * 
	 * purpose		:
	 *
	 * Date    		:	Mar 17, 2016 9:19:35 AM
	 */
	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate)
	{ 
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	/**
	 * 
	 * method name  : setQueryProps
	 * @param queryProps
	 * TranscriptDbImpl
	 * return type  : void
	 * 
	 * purpose		:
	 *
	 * Date    		:	Mar 17, 2016 9:19:42 AM
	 */
	public void setQueryProps(Properties queryProps)
	{
		this.queryProps = queryProps;
	}	
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.transcript.dao.db.TranscriptDbDao#getStudentList(java.lang.String, java.util.Locale)
	 */
	public List<Student> getStudentList(String studentId, Locale locale)
	{
		String SQL_STUDENT_DETAIL		=	queryProps.getProperty(Constants.CONST_SQL_STUDENT_DETAIL_LIST);
		
		RowMapper<Student> 	rowMapper		=	new RowMapper<Student>()
		{
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				Student	student	=	new Student();
						student.setStudentId(rs.getString(Constants.COST_COL_STD_ID));
						student.setStudentNo(rs.getString(Constants.COST_COL_STDNO));
						student.setStudentName(rs.getString(Constants.COST_COL_STD_NAME));
						student.setStdStatCode(rs.getString(Constants.COST_COL_STDSTATCD));
						student.setGender(rs.getString(Constants.COST_COL_GENDER));
						student.setBirthDay(rs.getString(Constants.COST_COL_BIRTH_DAY));
						student.setCohort(rs.getInt(Constants.COST_COL_COHORT));
						student.setCollegeCode(rs.getString(Constants.COST_COL_COLLEGE_CODE));
						student.setCollegeName(rs.getString(Constants.COST_COL_COLLEGE_NAME));
						student.setMajorCode(rs.getString(Constants.COST_COL_MAJOR_CODE));
						student.setMajorName(rs.getString(Constants.COST_COL_MAJOR_NAME));
						student.setMinorCode(rs.getString(Constants.COST_COL_MINOR_CODE));
						student.setMinorName(rs.getString(Constants.COST_COL_MINOR_NAME));
						student.setSpecCode(rs.getString(Constants.COST_COL_SPEC_CODE));
						student.setSpecName(rs.getString(Constants.COST_COL_SPEC_NAME));
						student.setDegreeNumber(rs.getInt(Constants.COST_COL_DEGREE_NUMBER));
						student.setDegreeName(rs.getString(Constants.COST_COL_DEGREE_NAME));
						student.setEmpNumberAdvisor(rs.getString(Constants.COST_COL_ADVISOR01_EMP_NO));
						student.setEmpNumberAdvisor2(rs.getString(Constants.COST_COL_ADVISOR02_EMP_NO));
						student.setlAbrStatus(rs.getString(Constants.COST_COL_L_ABR_STATUS));
						
				return student;
			}
		};
		
		Map<String, String> paramMap	=	new HashMap<String, String>();
		paramMap.put("paramLocale", locale.getLanguage());
		paramMap.put("paramStdId", studentId);
		
		
		return namedParameterJdbcTemplate.query(SQL_STUDENT_DETAIL, paramMap, rowMapper);
	}
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.transcript.dao.db.TranscriptDbDao#getStudent(java.lang.String, java.util.Locale)
	 */
	public Student getStudent(String stdStatCode, Locale locale)
	{
		String SQL_STUDENT_DETAIL		=	queryProps.getProperty(Constants.CONST_SQL_STUDENT_DETAIL);
		
		RowMapper<Student> 	rowMapper		=	new RowMapper<Student>()
		{
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				Student	student	=	new Student();
						student.setStudentId(rs.getString(Constants.COST_COL_STD_ID));
						student.setStudentNo(rs.getString(Constants.COST_COL_STDNO));
						student.setStudentName(rs.getString(Constants.COST_COL_STD_NAME));
						student.setStdStatCode(rs.getString(Constants.COST_COL_STDSTATCD));
						student.setGender(rs.getString(Constants.COST_COL_GENDER));
						student.setBirthDay(rs.getString(Constants.COST_COL_BIRTH_DAY));
						student.setCohort(rs.getInt(Constants.COST_COL_COHORT));
						student.setCollegeCode(rs.getString(Constants.COST_COL_COLLEGE_CODE));
						student.setCollegeName(rs.getString(Constants.COST_COL_COLLEGE_NAME));
						student.setMajorCode(rs.getString(Constants.COST_COL_MAJOR_CODE));
						student.setMajorName(rs.getString(Constants.COST_COL_MAJOR_NAME));
						student.setMinorCode(rs.getString(Constants.COST_COL_MINOR_CODE));
						student.setMinorName(rs.getString(Constants.COST_COL_MINOR_NAME));
						student.setFirstCollege(rs.getString(Constants.COST_COL_FIRST_COLLEGE));
						student.setFirstMajor(rs.getString(Constants.COST_COL_FIRST_MAJOR));
						student.setSpecCode(rs.getString(Constants.COST_COL_SPEC_CODE));
						student.setSpecName(rs.getString(Constants.COST_COL_SPEC_NAME));
						student.setDegreeNumber(rs.getInt(Constants.COST_COL_DEGREE_NUMBER));
						student.setDegreeName(rs.getString(Constants.COST_COL_DEGREE_NAME));
						student.setEmpNumberAdvisor(rs.getString(Constants.COST_COL_ADVISOR01_EMP_NO));
						student.setEmpNumberAdvisor2(rs.getString(Constants.COST_COL_ADVISOR02_EMP_NO));
						student.setlAbrStatus(rs.getString(Constants.COST_COL_L_ABR_STATUS));
						
				return student;
			}
		};
		
		Map<String, String> paramMap	=	new HashMap<String, String>();
		paramMap.put("paramLocale", locale.getLanguage());
		paramMap.put("paramStdStatCode", stdStatCode);
		
		
		return namedParameterJdbcTemplate.queryForObject(SQL_STUDENT_DETAIL, paramMap, rowMapper);
	}

	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.transcript.dao.db.TranscriptDbDao#getStudentStatusList(java.lang.String, java.lang.String)
	 */
	public List<StudentStatus>	getStudentStatusList(String stdStatCode, String collegeName)
	{
		String	SQL_STUDENT_STATUS_LIST		=	queryProps.getProperty(Constants.CONST_SQL_STUDENT_STATUS_LIST);
		
		RowMapper<StudentStatus> rowMapper		= new RowMapper<StudentStatus>()
		{
			
			@Override
			public StudentStatus mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				StudentStatus	studentStatus	=	new StudentStatus();
								studentStatus.setSemGPA(rs.getFloat(Constants.COST_COL_SEM_GPA));
								studentStatus.setCumGPA(rs.getFloat(Constants.COST_COL_CUM_GPA));
								studentStatus.setCreditEarned(rs.getInt(Constants.COST_COL_CREDITS_EARNED));
								studentStatus.setCreditTaken(rs.getInt(Constants.COST_COL_CREDITS_TAKEN));
								studentStatus.setCourseYear(rs.getInt(Constants.COST_COL_CCYRCD));
								studentStatus.setSemesterCode(rs.getInt(Constants.COST_COL_SEMCD));
								studentStatus.setGradePoint(rs.getFloat(Constants.COST_COL_GRADE_PTS));
								studentStatus.setGradePointCummulative(rs.getFloat(Constants.COST_COL_CUM_GRADE_PTS));
								studentStatus.setSemesterName(rs.getString(Constants.COST_COL_SEMESTER_NAME));
								studentStatus.setCreditTaken(rs.getInt(Constants.COST_COL_CUM_CREDITS_TAKEN));
								studentStatus.setLoadStatusSemester(rs.getString(Constants.COST_COL_SEMESTER_LOAD_STATUS));
								studentStatus.setLoadStatusStudent(rs.getString(Constants.COST_COL_STD_LOAD_STAT));
								studentStatus.setHonorDistinction(rs.getString(Constants.COST_COL_HON_DIST));
								studentStatus.setExcellentList(rs.getString(Constants.COST_COL_EXCLIST));
								studentStatus.setHistory(rs.getString(Constants.COST_COL_HISTORY));
								
				return studentStatus;
			}
		};
		
		
		Map<String,String> paramMap	=	new HashMap<String, String>();
		paramMap.put("paramStdStatCode", stdStatCode);
		paramMap.put("paramCollegeName", collegeName);
		
		
		
		return namedParameterJdbcTemplate.query(SQL_STUDENT_STATUS_LIST, paramMap, rowMapper);
	}
	
	
}
