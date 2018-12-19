<!--  
 * Project 				:	prjTranscript
 * Organisation 		:	Sultan Qaboos University
 * Center				:	Center for Information System
 * Department 			:	Web & E-Services
 * Author				:	Bhabesh
 * 
 * FrameWork			:	Spring 3.2.3 (Annotation) Portlet
 * 
 * File Name			:	studentInfo.jsp
 * 
 * Date of Creation		:	10-October-2018
 *  
 * Summary				:	
 *
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the SQU, CIS policy
 * you may not use this file except in compliance with the License.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */

-->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- link href="http://externalcdn.com/respond-proxy.html" id="respond-proxy" rel="respond-proxy" /-->

<portlet:resourceURL id="pdfTranscript" var="urlPdfTranscript"></portlet:resourceURL>
<portlet:resourceURL id="pdfTranscript" var="urlPdfTranscriptTest">
	<portlet:param name="stdStatCode" value="860000310"/>
</portlet:resourceURL>

<portlet:resourceURL id="resSummary" var="urlSummary"></portlet:resourceURL>


<%@include file="ui/cssWelcome.jsp" %>
<%@include file="ui/js/jsCode.js" %>
<%@include file="ui/js/transcript.hb.js" %>

<div class="panel panel-default container-fluid">
  <div class="panel-heading">
    <h3 class="panel-title"><spring:message code="prop.transcript.header.academic.transcript.text"/></h3>
  </div>
  <div class="panel-body">
    <div class="row">
		  <div id="divStudentDetail">
			 		<div class="row">
			 			<div class="col-sm-1">&nbsp;</div>
			 			<div class="col-sm-1"><spring:message code="prop.transcript.label.stdudent.id" /></div>
			 			<div class="col-sm-1"><h4>${student.studentId}</h4></div>
			 			
			 			<div class="col-sm-1"><spring:message code="prop.transcript.label.stdudent.name"/></div>
			 			<div class="col-sm-5"><h4>${student.studentName}</h4></div>
			 		</div>
			 		<div class="row">
			 			<div class="col-sm-1">&nbsp;</div>
						<div class="col-sm-1"><spring:message code="prop.transcript.label.stdudent.date.of.birth"/></div>
						<div class="col-sm-1"><h5>${student.birthDay}</h5></div>
						
						<div class="col-sm-1"><spring:message code="prop.transcript.label.stdudent.gender"/></div>
						<div class="col-sm-5"><h5>${student.gender}</h5></div>
					</div> 		
		  </div>
	</div>
  </div>
</div>

<div id="divStdSummary" class="container-fluid">

	<c:forEach items="${studentSummaryList}" var="student" varStatus="status">
       	<portlet:resourceURL id="pdfTranscript" var="urlPdfTranscript" escapeXml="false">
			<portlet:param name="stdStatCode" value="${student.stdStatCode}"/>
			<portlet:param name="studentNo" value="${student.studentNo}"/>
			<portlet:param name="collegeName" value="${student.collegeName}"/>
		</portlet:resourceURL>
	
		<div class="row">
			<div class="col-sm-1" style="text-align:center" ><span class="dot">${status.count}</span></div>
			<div class="col-sm-4">
					<h5>${student.degreeName} (${student.cohort})</h5>
			</div>
			<div class="col-sm-4">
					<div class="row">
				        		<div class="col-sm-12"><h5>${student.collegeName}</h5></div>
				    </div>
		        	<div class="row">
		        		<div class="col-sm-2"><b><spring:message code="prop.transcript.label.stdudent.major"/></b></div><div class="col-sm-6">${student.majorName}</div>
		        	</div>
			        <div class="row">
		        		<div class="col-sm-2"><b><spring:message code="prop.transcript.label.stdudent.advisor"/></b></div>
		        		<div class="col-sm-6">
		        				${student.empNameAdvisor}
		        				<c:if test="${not empty student.empNameAdvisor2 }">
		        					/ ${student.empNameAdvisor2}
		        				</c:if>
		        		</div>
		        	</div>	
			</div>
			<div class="col-sm-1">
					<a aurl="${urlPdfTranscript}" href="#"  class="bttnClsTranscriptDownload"  >
						<span class="glyphicon glyphicon-print" aria-hidden="true"></span>
					</a>
			</div>
		</div>
	</c:forEach>	
		
			

</div>



<iframe id='idIfrTranscript' src="" height="600px" width="100%" style="display: none; border: none;"></iframe>


