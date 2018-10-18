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
 * File Name			:	TranscriptPdfImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.transcript.dao.pdf
 * Date of creation		:	Aug 7, 2018  11:45:33 AM
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
package om.edu.squ.squportal.portlet.transcript.dao.pdf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

import javax.portlet.ResourceResponse;

import om.edu.squ.squportal.portlet.transcript.dao.bo.Student;
import om.edu.squ.squportal.portlet.transcript.dao.bo.StudentStatus;
import om.edu.squ.squportal.portlet.transcript.dao.db.TranscriptDbDao;
import om.edu.squ.squportal.portlet.transcript.utility.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author Bhabesh
 *
 */
public class TranscriptPdfImpl implements TranscriptPdfDao
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static final int INCH = 72;

    final private static float MARGIN_TOP = INCH / 4;
    final private static float MARGIN_BOTTOM = INCH / 2;
	
    private static final Rectangle PAGE_SIZE = PageSize.LETTER;
    private static final Rectangle TEMPLATE_SIZE = PageSize.LETTER;

    
	@Autowired
	TranscriptDbDao		transcriptDbDao;
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.transcript.dao.pdf.TranscriptPdfDao#getPdfTranscript(java.lang.String, java.lang.String, java.io.ByteArrayOutputStream, java.io.InputStream, javax.portlet.ResourceResponse, java.util.Locale)
	 */
	public OutputStream getPdfTranscript(String stdStatCode, String collegeName,  ByteArrayOutputStream	byos, InputStream	inputStream, ResourceResponse res, Locale locale) throws IOException
	{
		logger.info("stdStatCode : "+stdStatCode);
		logger.info("locale - language: "+locale.getLanguage());
		
		Document				document				=	new	Document(PAGE_SIZE);
		
		
		InputStream				inputStreamCourse		=	null;
		Resource				resourceCourse			=	null;
		
		
		
		PdfReader			pdfTemplate				=	new PdfReader(inputStream);
		
		Student  			student				 	=	transcriptDbDao.getStudent(stdStatCode, locale);	
		List<StudentStatus> statusList				=	transcriptDbDao.getStudentStatusList(stdStatCode, collegeName);
		
				logger.info("student id : {}, student statcode : {}", student.getStudentId(), student.getStdStatCode());
				logger.info("student : "+student);
				
		try
		{
			
				PdfWriter				pdfWriter				=	PdfWriter.getInstance(document, byos);
			
				PdfStamper		pdfStamper			=	new PdfStamper(pdfTemplate, byos );
				
				pdfStamper.getAcroFields().setField("txtFrmStudentId", student.getStudentId());
				pdfStamper.getAcroFields().setField("txtFrmDOB", student.getBirthDay());
				
				pdfStamper.getAcroFields().setField("txtFrmStudentName", student.getStudentName());
				pdfStamper.getAcroFields().setField("txtFrmGender", student.getGender());
				
				pdfStamper.getAcroFields().setField("txtCollege", student.getCollegeName());
				pdfStamper.getAcroFields().setField("txtFrmAdmissionCollege", student.getFirstCollege());
				
				pdfStamper.getAcroFields().setField("txtFrmMajor", student.getMajorName());
				pdfStamper.getAcroFields().setField("txtFrmFirstMajor", student.getFirstMajor());
				pdfStamper.getAcroFields().setField("txtFrmStream", "-");
				
				
				pdfStamper.getAcroFields().setField("txtDegreeName", student.getDegreeName());
				pdfStamper.getAcroFields().setField("txtAdvisor01", "-");
				pdfStamper.getAcroFields().setField("txtAdvisor02", "-");
				
				
				
				
				pdfStamper.getAcroFields().setGenerateAppearances(true);
				
				pdfStamper.setFormFlattening(true);
				pdfStamper.close();
				
		}
		catch(DocumentException exception)
		{
			logger.error("DocumentException. Details : {}",exception);
		}
		
		
		pdfTemplate.close();
		
		
		
							resourceCourse			=	new ClassPathResource(Constants.CONST_FILE_PDF_TEMPLATE_COURSE_EN);
							inputStreamCourse		=	resourceCourse.getInputStream();
		PdfReader			pdfTemplateCourse		=	new PdfReader(inputStreamCourse);
		
		
		
		
		res.setContentType("application/pdf");
		
		return res.getPortletOutputStream();
	}
}
