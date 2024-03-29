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
 * File Name			:	TranscriptServiceDao.java
 * Package Name			:	om.edu.squ.squportal.portlet.transcript.dao.service
 * Date of creation		:	May 20, 2015  1:21:28 PM
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
package om.edu.squ.squportal.portlet.transcript.dao.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceResponse;

import om.edu.squ.squportal.portlet.transcript.dao.bo.Student;
import om.edu.squ.squportal.portlet.transcript.dao.bo.User;

import com.itextpdf.text.DocumentException;

/**
 * @author Bhabesh
 *
 */
public interface TranscriptServiceDao
{
	/**
	 * 
	 * method name  : getPdfTranscript
	 * @param studentNo TODO
	 * @param stdStatCode
	 * @param collegeName TODO
	 * @param byos
	 * @param res
	 * @param locale
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 * TranscriptServiceDao
	 * return type  : OutputStream
	 * 
	 * purpose		:
	 *
	 * Date    		:	Aug 13, 2018 12:08:00 PM
	 */
	public OutputStream getPdfTranscript(String studentNo, String stdStatCode, String collegeName, ByteArrayOutputStream	byos, ResourceResponse res, Locale locale) throws IOException, DocumentException;
	
	
	/**
	 * 
	 * method name  : getStudentList
	 * @param studentId
	 * @param locale TODO
	 * @return
	 * TranscriptServiceDao
	 * return type  : List<Student>
	 * 
	 * purpose		: Get student details of different degrees
	 *
	 * Date    		:	Aug 13, 2018 11:34:40 AM
	 */
	public List<Student> getStudentList(String studentId, Locale locale);
	
	/**
	 * 
	 * method name  : getStudent
	 * @param stdStatCode
	 * @param locale
	 * @return
	 * TranscriptServiceDao
	 * return type  : Student
	 * 
	 * purpose		:  Get student details of particular degree
	 *
	 * Date    		:	Sep 5, 2018 4:12:09 PM
	 */
	public Student getStudent(String stdStatCode, Locale locale);
	
	/**
	 * 
	 * method name  : getUser
	 * @param request
	 * @return
	 * TranscriptServiceImpl
	 * return type  : User
	 * 
	 * purpose		:  Get User
	 *
	 * Date    		:	Dec 3, 2018 12:46:39 PM
	 */
	public User getUser(PortletRequest request);
	
	/**
	 * 
	 * method name  : isEligibleToViewTranscript
	 * @param studentId
	 * @param request
	 * @return
	 * TranscriptServiceDao
	 * return type  : boolean
	 * 
	 * purpose		: Find eligibility of an academics to view transcript
	 *
	 * Date    		:	Jan 8, 2019 12:32:41 PM
	 */
	boolean isEligibleToViewTranscript(String studentId, PortletRequest request);
	
	/**
	 * 
	 * method name  : getEmpNumber
	 * @param request
	 * @return
	 * TranscriptServiceDao
	 * return type  : String
	 * 
	 * purpose		:
	 *
	 * Date    		:	Jan 8, 2019 11:50:34 AM
	 */
	public  String getEmpNumber(PortletRequest request);
}
