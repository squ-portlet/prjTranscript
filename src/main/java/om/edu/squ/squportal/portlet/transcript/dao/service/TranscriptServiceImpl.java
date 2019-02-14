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
 * File Name			:	TranscriptServiceImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.transcript.dao.service
 * Date of creation		:	May 20, 2015  1:20:37 PM
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
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceResponse;






import om.edu.squ.portal.common.EmpCommon;
import om.edu.squ.squportal.portlet.transcript.dao.bo.Student;
import om.edu.squ.squportal.portlet.transcript.dao.bo.User;
import om.edu.squ.squportal.portlet.transcript.dao.db.TranscriptDbDao;
import om.edu.squ.squportal.portlet.transcript.dao.pdf.TranscriptPdfDao;
import om.edu.squ.squportal.portlet.transcript.dao.pdf.TranscriptPdfImpl;
import om.edu.squ.squportal.portlet.transcript.utility.Constants;
import om.edu.squ.squportal.portlet.transcript.utility.UtilService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.itextpdf.text.DocumentException;

/**
 * @author Bhabesh
 *
 */
public class TranscriptServiceImpl implements TranscriptServiceDao
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	TranscriptDbDao		transcriptDbDao;
	
	@Autowired
	TranscriptPdfDao	transcriptPdf;
	
	@Autowired
	UtilService			utilService;

	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.transcript.dao.service.TranscriptServiceDao#getPdfTranscript(java.lang.String, java.lang.String, java.lang.String, java.io.ByteArrayOutputStream, javax.portlet.ResourceResponse, java.util.Locale)
	 */
	public OutputStream getPdfTranscript(String studentNo, String stdStatCode, String collegeName, ByteArrayOutputStream	byos, ResourceResponse res, Locale locale) throws IOException, DocumentException
	{
		Resource				resource		=	null;
		InputStream				inputStream		=	null;
		OutputStream			outputStream	=	null;
		//TranscriptPdfImpl		transcriptPdf	=	new TranscriptPdfImpl();
		
			if(locale.getLanguage().equals("en"))
				{
					resource		=	new ClassPathResource(Constants.CONST_FILE_PDF_TEMPLATE_TRANSCRIPT_EN);
				}
			else
				{
					resource		=	new ClassPathResource(Constants.CONST_FILE_PDF_TEMPLATE_TRANSCRIPT_AR);
				}
			inputStream		=	resource.getInputStream();
			outputStream	=	transcriptPdf.getPdfTranscript(studentNo, stdStatCode, collegeName, byos, inputStream, res, locale);
		
		return outputStream;
	}
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.transcript.dao.service.TranscriptServiceDao#getStudentList(java.lang.String, java.util.Locale)
	 */
	 
	public List<Student> getStudentList(String studentId, Locale locale)
	{
		return transcriptDbDao.getStudentList(studentId, locale);
	}
	
	
	public Student getStudent(String stdStatCode, Locale locale)
	{
		return transcriptDbDao.getStudent(stdStatCode, locale);
	}
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.transcript.dao.service.TranscriptServiceDao#getUser(javax.portlet.PortletRequest)
	 */
	public User getUser(PortletRequest request)
	{
		return utilService.getUser(request.getRemoteUser());
	}

	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.transcript.dao.service.TranscriptServiceDao#isEligibleToViewTranscript(java.lang.String, javax.portlet.PortletRequest)
	 */
	public boolean isEligibleToViewTranscript(String studentId, PortletRequest request)
	{
		String empNumber	=	Constants.COST_COL_EMPLOYEE_PREFIX+getEmpNumber(request);
		return transcriptDbDao.isEligibleToViewTranscript(studentId, empNumber);
	}
	
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.transcript.dao.service.TranscriptServiceDao#getEmpNumber(javax.portlet.PortletRequest)
	 */
	public  String getEmpNumber(PortletRequest request)
	{

	    if(request.getRemoteUser()==null || request.getRemoteUser()=="")
	    {		    return null;
	    }
	    else 
	    {
			String strEmpNumber=null;
			try
			{
				EmpCommon	empCommon	=	new EmpCommon();
						strEmpNumber 	= 	empCommon.getEmployeeNumber(request.getRemoteUser());
			}
			catch(Exception ex)
			{
				logger.info("******* exception while getting emp no: " + ex.getMessage());
			}
			if(strEmpNumber==null || strEmpNumber=="")
			{
				return null;	
			}
			else return strEmpNumber;
			    
	    }
	    
	}
	
}
