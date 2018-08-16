<!--  
 * Project 				:	prjTranscript
 * Organisation 		:	Sultan Qaboos University
 * Center				:	Center for Information System
 * Department 			:	Web & E-Services
 * Author				:	Bhabesh
 * 
 * FrameWork			:	Spring 3.2.3 (Annotation) Portlet
 * 
 * File Name			:	welcome.jsp
 * 
 * Date of Creation		:	17-March-2016
 *  
 * Summary				:	cssWelcome
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
    	<form class="form-inline container-fluid">
    		<div class="form-group">
    			<label for="exampleInputName2">Student Id</label>
    			<input type="text" class="form-control" id="txtStudentId" placeholder="Student Id">
  			</div>
    		<button type="button" id="bttnSearch" class="btn btn-default">
  				<span class="glyphicon glyphicon-search" aria-hidden="true"></span> Search Record
			</button>
		</form>
	</div>
  </div>
</div>

<div id="divStdSummary" class="container-fluid"/>

<%-- <div class="col-xs-2"><a href="${urlPdfTranscript}"><span class="glyphicon glyphicon-print" aria-hidden="true"></span> Transcript</a></div> --%>



