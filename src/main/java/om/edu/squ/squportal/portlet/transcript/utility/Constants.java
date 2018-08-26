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
	public	static	final	String	CONST_SQL_STUDENT_DETAIL					=	"transcript.select.student.details";
	
	/******************************************************/
	
	/************* CONSTANT COLUMN ******************************/
	public static final	String	COST_COL_STD_ID									=	"STD_ID";
	public static final	String	COST_COL_STDNO									=	"STDNO";
	public static final	String	COST_COL_STDSTATCD								=	"STDSTATCD";
	public static final	String	COST_COL_GENDER									=	"GENDER";
	public static final	String	COST_COL_COHORT									=	"COHORT";
	public static final	String	COST_COL_STD_NAME								=	"STD_NAME";
	public static final	String	COST_COL_COLLEGE_CODE							=	"COLLEGE_CODE";
	public static final	String	COST_COL_COLLEGE_NAME							=	"COLLEGE_NAME";
	public static final	String	COST_COL_MAJOR_CODE								=	"MAJOR_CODE";
	public static final	String	COST_COL_MAJOR_NAME								=	"MAJOR_NAME";
	public static final	String	COST_COL_MINOR_CODE								=	"MINOR_CODE";
	public static final	String	COST_COL_MINOR_NAME								=	"MINOR_NAME";
	public static final	String	COST_COL_SPEC_CODE								=	"SPEC_CODE";
	public static final	String	COST_COL_SPEC_NAME								=	"SPEC_NAME";
	public static final	String	COST_COL_DEGREE_NUMBER							=	"DEGREE_NUMBER";
	public static final	String	COST_COL_DEGREE_NAME							=	"DEGREE_NAME";
	public static final	String	COST_COL_ADVISOR01_EMP_NO						=	"ADVISOR01_EMP_NO";
	public static final	String	COST_COL_ADVISOR02_EMP_NO						=	"ADVISOR02_EMP_NO";
	public static final	String	COST_COL_L_ABR_STATUS							=	"L_ABR_STATUS";
	public static final	String	COST_COL_ACTIVE									=	"ACTIVE";
	/******************************************************/
	
	
	
	public static 	String	CONST_FILE_PDF_TEMPLATE_TRANSCRIPT_EN				=	"template/pdf/template_transcript_en.pdf";
}