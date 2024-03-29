<!--  
 * Project 				:	prjTranscript
 * Organisation 		:	Sultan Qaboos University
 * Center				:	Center for Information System
 * Department 			:	Web & E-Services
 * Author				:	Bhabesh
 * 
 * FrameWork			:	Spring 3.2.3.RELEASE (Annotation) Portlet
 * 
 * File Name			:	transcript.hb.js
 * 
 * Date of Creation		:	14-August-2018
 *  
 * Summary				:	Handle Bars template
 *
 * Copyright 2018 the original author or authors.
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
 
 <!-- List of Students under particular probation -->
 <script id="hbSummary" type="text/x-handlebars-template">
	 	<div class="col-sm-5 col-md-5">
	 	
		    <div class="thumbnail">
		    <div style="text-align:center"><span class="dot">{{countDegree}}</span></div>
		      
		      <div class="caption">
		        <h3>{{student.degreeName}} ({{student.cohort}})</h3>
		        <p>
		        	<div class="row">
		        		<div class="col-sm-12"><h5>{{student.collegeName}}</h5></div>
		        	</div>
		        	<div class="row">
		        		<div class="col-sm-2"><b>Major</b></div><div class="col-sm-6">{{student.majorName}}</div>
		        	</div>
			        <div class="row">
		        		<div class="col-sm-2"><b>Advisor</b></div><div class="col-sm-6">{{student.empNumberAdvisor}}</div>
		        	</div>		        		
		        </p>
		        <p>
			        <div class="row">
			        	<div class="col-sm-8">
			        	
			        		<a stdStatCode={{student.stdStatCode}}  class="bttnClsTranscriptDownload btn btn-primary" role="button" >Download</a>
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
 </script>
 
 <script id="hbStudentDetail" type="text/x-handlebars-template">
 	<div class="panel-footer">
 		<div class="row">
 			<div class="col-sm-2">Student Id</div>
 			<div class="col-sm-1"><h4>{{student.studentId}}</h4></div>
 			
 			<div class="col-sm-1">Name</div>
 			<div class="col-sm-5"><h4>{{student.studentName}}</h4></div>
 		</div>
 		<div class="row">
			<div class="col-sm-2">Date of Birth</div>
			<div class="col-sm-1"><h5>{{student.birthDay}}</h5></div>
			
			<div class="col-sm-1">Gender</div>
			<div class="col-sm-5"><h5>{{student.gender}}</h5></div>
		</div> 		
 		
 	</div>
 </script>
 