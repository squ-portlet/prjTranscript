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

import javax.portlet.ResourceResponse;

import om.edu.squ.squportal.portlet.transcript.dao.bo.Student;

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
	 * @param studentId
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
	public OutputStream getPdfTranscript(String studentId, ByteArrayOutputStream	byos, ResourceResponse res, Locale locale) throws IOException, DocumentException;
	
	
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
}
