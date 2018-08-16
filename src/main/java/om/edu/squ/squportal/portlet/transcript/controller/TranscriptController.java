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
 * File Name			:	TranscriptController.java
 * Package Name			:	om.edu.squ.squportal.portlet.avrequest.controller
 * Date of creation		:	May 20, 2015  1:49:40 PM
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
package om.edu.squ.squportal.portlet.transcript.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import om.edu.squ.squportal.portlet.transcript.dao.bo.Student;
import om.edu.squ.squportal.portlet.transcript.dao.service.TranscriptServiceDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.google.gson.Gson;
import com.itextpdf.text.DocumentException;

/**
 * @author Bhabesh
 *
 */
@Controller
@RequestMapping("VIEW")
public class TranscriptController
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	TranscriptServiceDao	transcriptService;
	
	@RequestMapping
	private String welcome(PortletRequest request, Model model)
	{
		return "welcome";
	}
	
	/**
	 * 
	 * method name  : getSummary
	 * @param studentId
	 * @param request
	 * @param response
	 * @param locale
	 * TranscriptController
	 * return type  : void
	 * 
	 * purpose		:
	 *
	 * Date    		:	Aug 14, 2018 12:57:12 PM
	 * @throws IOException 
	 */
	@ResourceMapping(value="resSummary")
	private void getSummary
						(
								@RequestParam("studentId") String studentId
							,	ResourceRequest	request
							, 	ResourceResponse	response
							, 	Locale	locale
						) throws IOException
	{
		Gson			gson				=	new Gson();
		List<Student>  	studentSummaryList	=	transcriptService.getStudentList(studentId, locale);
		response.getWriter().print(gson.toJson(studentSummaryList));
		
		logger.info("student list : "+gson.toJson(studentSummaryList));
	}
	
	/**
	 * 
	 * method name  : pdfTranscript
	 * @param request
	 * @param response
	 * @param locale
	 * TranscriptController
	 * return type  : void
	 * 
	 * purpose		:
	 *
	 * Date    		:	Aug 7, 2018 11:00:47 AM
	 * @throws DocumentException 
	 * @throws IOException 
	 */
	@ResourceMapping(value="pdfTranscript")
	private void pdfTranscript(
									//	@RequestParam("studentId") String studentId,
										ResourceRequest	request
									, 	ResourceResponse	response
									, 	Locale	locale
							  ) throws IOException, DocumentException
	{
		
		
		//List<Student> 	studentDetails			=	transcriptService.getStudentList(studentId);
		
		
		ByteArrayOutputStream	byos			=	new ByteArrayOutputStream();
		OutputStream			outputStream	=	transcriptService.getPdfTranscript("860000310", byos, response, locale);
		response.setContentType("application/pdf");
		response.setContentLength(byos.size());
		byos.writeTo(outputStream);
		
		
		
		outputStream.flush();
		outputStream.close();
	}
	
}
