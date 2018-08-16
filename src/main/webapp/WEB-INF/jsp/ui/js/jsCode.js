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

	$(function(){
		$(document).on('click','#bttnSearch',function(event){
			event.preventDefault();
			var varStudentId			=	$('#txtStudentId').val();
			var	varStudentDTO	 	=	{studentId :  varStudentId };
			
			$.ajax({
				url		:	"${urlSummary}",
				type	:	'POST',
				cache	:	false,
				data	:	varStudentDTO,
				success	:	function(data)
				{
					
					var htmlData='';
					var students = JSON.parse(data);
					
					var i = 1;
					for (var key in students)
					{
						
						//student=students[key];
						student={student:students[key],countDegree:i++};

						htmlData = htmlData +  dataLoadHtml(student,'#hbSummary');
						
					}
					
					$('#divStdSummary').html(htmlData);
					
					/*
					tblRowDataApprover.visitedAdvisor.advisorVisited = $('[id=visitedAdvisor]').val();
					tblRowDataApprover.visitedAdvisor.comment=$('#comment').val();
					varTblProblistStudent.row( tblRowIndexApprover ).data(tblRowDataApprover).draw();
					$('#modalApprovForm').modal('toggle');
					*/
				},
				error	:	function(xhr, status, error)
				{

				}
			});
		});
		
		
		
		/* Handlebar data load */		
		function dataLoad(dataJson, hbTemplateId, tableId)
		{
			if ($.trim(dataJson))
			{
				var theAlertTemplate=$(hbTemplateId).html();
				var template = Handlebars.compile(theAlertTemplate);
				$(tableId).html(template(dataJson));
			}
			return true;
		}
		
		
		/* Handlebar data load */		
		function dataLoadHtml(dataJson, hbTemplateId)
		{
			if ($.trim(dataJson))
			{
				var theAlertTemplate=$(hbTemplateId).html();
				var template = Handlebars.compile(theAlertTemplate);
				return template(dataJson);
			}
			return true;
		}
		
	});

</script>