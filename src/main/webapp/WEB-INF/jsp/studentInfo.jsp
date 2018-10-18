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
    <h3 class="panel-title">Transcript Service</h3>
  </div>
  <div class="panel-body">
    <div class="row">
		  <div id="divStudentDetail">
			 		<div class="row">
			 			<div class="col-sm-2">Student Id</div>
			 			<div class="col-sm-1"><h4>${studentId}</h4></div>
			 			
			 			<div class="col-sm-1">Name</div>
			 			<div class="col-sm-5"><h4>${studentName}</h4></div>
			 		</div>
			 		<div class="row">
						<div class="col-sm-2">Date of Birth</div>
						<div class="col-sm-1"><h5>${birthDay}</h5></div>
						
						<div class="col-sm-1">Gender</div>
						<div class="col-sm-5"><h5>${gender}</h5></div>
					</div> 		
		  </div>
	</div>
  </div>
</div>

<div id="divStdSummary" class="container-fluid">

	<c:forEach items="${studentSummaryList}" var="student" varStatus="status">
	 	<div class="col-sm-5 col-md-5">
		    <div class="thumbnail">
		    <div style="text-align:center"><span class="dot">${status.count}</span></div>
		      
		      <div class="caption">
		        <h3>${student.degreeName} (${student.cohort})</h3>
		        <p>
		        	<div class="row">
		        		<div class="col-sm-12"><h5>${student.collegeName}</h5></div>
		        	</div>
		        	<div class="row">
		        		<div class="col-sm-2"><b>Major</b></div><div class="col-sm-6">${student.majorName}</div>
		        	</div>
			        <div class="row">
		        		<div class="col-sm-2"><b>Advisor</b></div><div class="col-sm-6">${student.empNumberAdvisor}</div>
		        	</div>		        		
		        </p>
		        <p>
			        <div class="row">
			        	<div class="col-sm-8">

			        	<portlet:resourceURL id="pdfTranscript" var="urlPdfTranscript" escapeXml="false">
							<portlet:param name="stdStatCode" value="${student.stdStatCode}"/>
							<portlet:param name="collegeName" value="${student.collegeName}"/>
						</portlet:resourceURL>
			        	
			        		<a href="${urlPdfTranscript}"  class="bttnClsTranscriptDownload btn btn-primary" role="button" >Download</a>
			        	</div>
<!--			        	
			        	<div class="col-sm-4">
	        				<a stdStatCode={{student.stdStatCode}}  class="bttnClsTranscript btn btn-primary" role="button">Transcript</a>
	        			</div>
-->

			        </div>
		        </p>
		      </div>
		     </div>
		</div> 	
	</c:forEach>	
		
			

</div>
