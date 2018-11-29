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
 * File Name			:	Constants.java
 * Package Name			:	om.edu.squ.squportal.portlet.transcript.utility
 * Date of creation		:	Aug 16, 2015  2:30:11 PM
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
package om.edu.squ.squportal.portlet.transcript.utility;

/**
 * @author Bhabesh
 *
 */
public interface Constants
{
	/**********LDAP***************************************/
	public	static	String	LDAP_COMMON_NAME									=	"cn";
	public	static	String	LDAP_EMPLOYEE_NUMBER								=	"employeenumber"; 
	public	static	String	LDAP_EMPLOYEE_NUMBER2								=	"description"; 
	/******************************************************/
	
	/************* PROPERTY FILE ******************************/
	public	static	String	RESOURCE_PROPERTY_FILE_NAME							=	"messages";

	
	/******************************************************/
	
	/************* SQL - TRANSCRIPT ******************************/
	public	static	final	String	CONST_SQL_STUDENT_DETAIL_LIST				=	"transcript.select.student.details.list";
	public	static	final	String	CONST_SQL_STUDENT_DETAIL					=	"transcript.select.student.details";
	public	static	final	String	CONST_SQL_STUDENT_STATUS_LIST				=	"transcript.select.student.status.list";
	public	static	final	String	CONST_SQL_STUDENT_GRADE_LIST				=	"transcript.select.student.grade.list";
	public	static	final	String	CONST_SQL_STUDENT_REG_LIST					=	"transcript.select.student.registration";
	public static	final	String	CONST_SQL_STUDENT_POSTPONE_LIST				=	"transcript.select.student.postpone.list";
	
	/******************************************************/
	
	/************* CONSTANT COLUMN ******************************/
	public static final	String	COST_COL_STD_ID									=	"STD_ID";
	public static final	String	COST_COL_STDNO									=	"STDNO";
	public static final	String	COST_COL_STDSTATCD								=	"STDSTATCD";
	public static final	String	COST_COL_GENDER									=	"GENDER";
	public static final	String	COST_COL_BIRTH_DAY								=	"BIRTH_DAY";
	public static final	String	COST_COL_COHORT									=	"COHORT";
	public static final	String	COST_COL_STD_NAME								=	"STD_NAME";
	public static final	String	COST_COL_COLLEGE_CODE							=	"COLLEGE_CODE";
	public static final	String	COST_COL_COLLEGE_NAME							=	"COLLEGE_NAME";
	public static final	String	COST_COL_MAJOR_CODE								=	"MAJOR_CODE";
	public static final	String	COST_COL_MAJOR_NAME								=	"MAJOR_NAME";
	public static final	String	COST_COL_MINOR_CODE								=	"MINOR_CODE";
	public static final	String	COST_COL_MINOR_NAME								=	"MINOR_NAME";
	public static final	String	COST_COL_FIRST_COLLEGE							=	"FIRST_COL";
	public static final	String	COST_COL_FIRST_MAJOR							=	"FIRST_MAJ";	
	public static final	String	COST_COL_SPEC_CODE								=	"SPEC_CODE";
	public static final	String	COST_COL_SPEC_NAME								=	"SPEC_NAME";
	public static final	String	COST_COL_DEGREE_NUMBER							=	"DEGREE_NUMBER";
	public static final	String	COST_COL_DEGREE_NAME							=	"DEGREE_NAME";
	public static final	String	COST_COL_ADVISOR01_EMP_NO						=	"ADVISOR01_EMP_NO";
	public static final	String	COST_COL_ADVISOR02_EMP_NO						=	"ADVISOR02_EMP_NO";
	public static final	String	COST_COL_ADVISOR01_EMP_NAME						=	"ADVISOR01_EMP_NAME";
	public static final	String	COST_COL_ADVISOR02_EMP_NAME						=	"ADVISOR02_EMP_NAME";
	public static final	String	COST_COL_L_ABR_STATUS							=	"L_ABR_STATUS";
	public static final	String	COST_COL_STATUS_NAME							=	"STATUS_NAME";
	public static final	String	COST_COL_TOTAL_CREDITS_TAKEN					=	"TOTAL_CREDITS_TAKEN";
	public static final	String	COST_COL_TOTAL_CREDITS_EARNED					=	"TOTAL_CREDITS_EARNED";
	public static final	String	COST_COL_SCHOOL_CERT_TYPE						=	"SCHOOL_CERT_TYPE";
	public static final	String	COST_COL_SCHOOL_STREAM							=	"SCHOOL_STREAM";
	public static final	String	COST_COL_SCHOOL_PERC							=	"SCHOOL_PERC";
	
	
	
	public static final	String	COST_COL_ACTIVE									=	"ACTIVE";
	
	public static final	String	COST_COL_SEM_GPA								=	"SEM_GPA";
	public static final	String	COST_COL_CUM_GPA								=	"CUM_GPA";
	public static final	String	COST_COL_CREDITS_EARNED							=	"CREDITS_EARNED";
	public static final	String	COST_COL_CREDITS_TAKEN							=	"CREDITS_TAKEN";
	public static final	String	COST_COL_CCYRCD									=	"CCYRCD";
	public static final	String	COST_COL_SEMCD									=	"SEMCD";
	public static final	String	COST_COL_GRADE_PTS								=	"GRADE_PTS";
	public static final	String	COST_COL_CUM_GRADE_PTS							=	"CUM_GRADE_PTS";
	public static final	String	COST_COL_SEMESTER_NAME							=	"SEMESTER_NAME";
	public static final	String	COST_COL_CUM_CREDITS_TAKEN						=	"CUM_CREDITS_TAKEN";
	public static final	String	COST_COL_SEMESTER_LOAD_STATUS					=	"SEMESTER_LOAD_STATUS";
	public static final	String	COST_COL_STD_LOAD_STAT							=	"STD_LOAD_STAT";
	public static final	String	COST_COL_HON_DIST								=	"HON_DIST";
	public static final	String	COST_COL_EXCLIST								=	"EXCLIST";
	public static final	String	COST_COL_HISTORY								=	"HISTORY";
	
	
	public static final	String	COST_COL_COURSE_NO								=	"COURSE_NO";
	public static final	String	COST_COL_COURSE_NAME							=	"COURSE_NAME";
	public static final	String	COST_COL_COURSE_CREDIT							=	"COURSE_CREDIT";
	public static final	String	COST_COL_COURSE_CREDIT_VALUE					=	"COURSE_CREDIT_VALUE";
	public static final	String	COST_COL_COURSE_GRADE_POINT						=	"COURSE_GRADE_POINT";
	public static final	String	COST_COL_PREVIOUS_COURSE_NO						=	"PREVIOUS_COURSE_NO";
	public static final	String	COST_COL_PREVIOUS_COURSE_YEAR					=	"PREVIOUS_COURSE_YEAR";
	public static final	String	COST_COL_PREVIOUS_SEM_CODE						=	"PREVIOUS_SEM_CODE";
	public static final	String	COST_COL_REPEATED								=	"REPEATED";
	
	
	public static final	String	COST_COL_FROM_YRSEM								=	"FROM_YRSEM";
	public static final	String	COST_COL_TO_YRSEM								=	"TO_YRSEM";
	public static final	String	COST_COL_PST_DATE								=	"PST_DATE";
	
	
	
	
	/******************************************************/
	
	
	/* **** JSP Pages *** */
	
	public static 	String	CONST_UI_STUDENT_INFO								=	"studentInfo";
	
	public static 	String	CONST_FILE_PDF_TEMPLATE_TRANSCRIPT_EN				=	"template/pdf/template_transcript_en.pdf";
	public static 	String	CONST_FILE_PDF_TEMPLATE_TRANSCRIPT_AR				=	"template/pdf/template_transcript_ar.pdf";
	public static 	String	CONST_FILE_PDF_TEMPLATE_COURSE_EN					=	"template/pdf/template_course_en.pdf";
	
	public static 	String	CONST_FILE_FONT_ARIALUNI_REGULAR					=	"template/pdf/font/ARIALUNI.TTF";
	
}
