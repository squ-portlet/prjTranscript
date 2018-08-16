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
import om.edu.squ.squportal.portlet.transcript.dao.db.TranscriptDbDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * @author Bhabesh
 *
 */
public class TranscriptPdfImpl implements TranscriptPdfDao
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@Autowired
	TranscriptDbDao		transcriptDbDao;
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.transcript.dao.pdf.TranscriptPdfDao#getPdfTranscript(java.lang.String, java.io.ByteArrayOutputStream, java.io.InputStream, javax.portlet.ResourceResponse, java.util.Locale)
	 */
	public OutputStream getPdfTranscript(String studentId, ByteArrayOutputStream	byos,  InputStream	inputStream, ResourceResponse res, Locale locale) throws IOException, DocumentException
	{
		
		PdfReader		pdfTemplate			=	new PdfReader(inputStream);
		
		List<Student>  studentDetails 	=	transcriptDbDao.getStudentList(studentId, locale);	
		for (Student student: studentDetails)
			{
				logger.info("student id : {}, student statcode : {}", student.getStudentId(), student.getStdStatCode());
				
				PdfStamper		pdfStamper			=	new PdfStamper(pdfTemplate, byos );
				
				
				
				pdfStamper.getAcroFields().setField("txtFrmStudentId", studentId);
				
				
				
				
				pdfStamper.getAcroFields().setGenerateAppearances(true);
				
				pdfStamper.setFormFlattening(true);
				pdfStamper.close();
				
			}
		
		
		pdfTemplate.close();
		
		
		res.setContentType("application/pdf");
		
		return res.getPortletOutputStream();
	}
}
