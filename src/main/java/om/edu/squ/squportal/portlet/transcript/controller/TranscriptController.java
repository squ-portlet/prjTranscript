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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import om.edu.squ.squportal.portlet.transcript.dao.bo.Student;
import om.edu.squ.squportal.portlet.transcript.dao.bo.User;
import om.edu.squ.squportal.portlet.transcript.dao.service.TranscriptServiceDao;
import om.edu.squ.squportal.portlet.transcript.model.TranscriptModel;
import om.edu.squ.squportal.portlet.transcript.utility.Constants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.google.gson.Gson;
import com.itextpdf.text.DocumentException;
import com.liferay.portal.kernel.servlet.HttpHeaders;

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
	
	/**
	 * 
	 * method name  : welcome
	 * @param request
	 * @param response
	 * @param model
	 * @param locale
	 * @return
	 * TranscriptController
	 * return type  : String
	 * 
	 * purpose		: Default render
	 *
	 * Date    		:	Dec 3, 2018 12:52:56 PM
	 */
	@RequestMapping
	private String welcome(PortletRequest request, PortletResponse response, Model model, Locale locale)
	{
		model.addAttribute("transcriptModel", new TranscriptModel());
		
		User	user	=	transcriptService.getUser(request);
		
		if(user.getUserType().equals(Constants.USER_TYPE_STUDENT))
		{
			return studentDetails(user.getUserId(), request, response, model, locale);
		}
		else
		{
			return "welcome";
		}

		
	}

	
	@RequestMapping(params="action=submitStudentInfo")
	private void submitStudentId(
										ActionRequest request
									, 	ActionResponse response
									, 	@ModelAttribute("transcriptModel") TranscriptModel transcriptModel
									,   BindingResult	result
									,	Model			model
								)
	{
		String 	stdId	=	null;
				stdId	=	transcriptModel.getStdId();
		
				response.setRenderParameter("studentId", stdId);
				response.setRenderParameter("action", "studentDetails");
		
	}
	
	/**
	 * 
	 * method name  : studentDetails
	 * @param studentId
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * TranscriptController
	 * return type  : String
	 * 
	 * purpose		: Render to student details
	 *
	 * Date    		:	Oct 10, 2018 11:23:56 AM
	 */
	@RequestMapping(params="action=studentDetails")
	private	String	studentDetails(
										@RequestParam("studentId") 
										String 				studentId
									,	PortletRequest		request
									,	PortletResponse		response
									,	Model				model
									,	Locale				locale
								  )
	{
		List<Student>  	studentSummaryList	=	transcriptService.getStudentList(studentId, locale);
		model.addAttribute("studentSummaryList", studentSummaryList);
		model.addAttribute("student", studentSummaryList.get(0));
		return Constants.CONST_UI_STUDENT_INFO;
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
										//@RequestParam("stdStatCode") String stdStatCode,
										@ModelAttribute("student") Student student,
										ResourceRequest	request
									, 	ResourceResponse	response
									, 	Locale	locale
							  ) throws IOException, DocumentException
	{

		
		org.springframework.http.HttpHeaders	httpHeaders	=	new org.springframework.http.HttpHeaders();

		ByteArrayOutputStream	byos			=	new ByteArrayOutputStream();
		OutputStream			outputStream	=	transcriptService.getPdfTranscript(student.getStudentNo(), student.getStdStatCode(), student.getCollegeName(), byos, response, locale);
		response.setContentType("application/pdf");
		response.setContentLength(byos.size());
		response.setProperty(HttpHeaders.CONTENT_DISPOSITION, "inline;filename=\"" + "Transcript.pdf" + "\"");
	
		httpHeaders.setContentDispositionFormData("Transcript", "Transcript.pdf");

		
		
		byos.writeTo(outputStream);
		
		//outputStream.write(byos.toByteArray());
	

		//logger.info("byte stream : {}",byos);
		//Gson	gson	=	new Gson();
		//logger.info("byte stream json : {}", gson.toJson(byos));
		
		//response.getWriter().print(gson.toJson(outputStream));
		
		outputStream.flush();
		outputStream.close();
		
		
	     //response.setContentType("application/json");
	     //response.setCharacterEncoding("UTF-8");
	     //response.getWriter().write("success....");
		//response.setContentType("application/json");
		//response.getWriter().write("testing ");
	     
	}
	
}
