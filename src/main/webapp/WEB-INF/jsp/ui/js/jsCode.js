<!--  
 * Project 				:	prjTranscript
 * Organisation 		:	Sultan Qaboos University
 * Center				:	Center for Information System
 * Department 			:	Web & E-Services
 * Author				:	Bhabesh
 * 
 * FrameWork			:	Spring 4.0.8.RELEASE (Annotation) Portlet
 * 
 * File Name			:	jsCode.jsp
 * 
 * Date of Creation		:	14-Aug-2018
 *  
 * Summary				:	java script for the service
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
<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<script type="text/javascript">

$(function() {
	/* Following code address to SIS common control portlet */
	$('#linkStudent').hide();	
	$('#linkEmployee').hide();
	$('#linkServiceOthers').hide();
//	$('#linkServiceOthers').click();
	$('#linkCourseWise').click();
	
	
	$('#idDownloadCourseTxt').hide();
	$('#idFormGroupFilterType').hide();
	$('#form-group-deptId').hide();
	$('#idDivCourses').hide();
	$('#idFormCheckChkSimpleSearch').hide();
	
	$('#form-group-majorId').show();
	$('#form-group-DegreeId').show();
	$('#form-group-statusId').show();
	$('#majorSubmitBttnId').show();
	
});



$(function() {
	/* Hide the common control portlet */
		<c:if test="${not empty studentSummaryList}">
			$('.portlet-boundary_prjSISGeneralDept_WAR_prjSISDeptGeneral_').hide();
		</c:if>
	
	$(document).on('click','.bttnClsTranscriptDownload',function(event){
		$('#idIfrTranscript').contents().find('body').html('<h3>Please Wait ..</h3>');
		$('#idIfrTranscript').show();
		$('#idIfrTranscript').attr('src',this.getAttribute("aurl"));
	});
	
});

</script>