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
			var	varStudentDTO	 		=	{studentId :  varStudentId };
			
			
			
			$.ajax({
				url		:	"${urlSummary}",
				type	:	'POST',
				cache	:	false,
				data	:	varStudentDTO,
				success	:	function(data)
				{
					
					var htmlData='';
					var students = JSON.parse(data);
					var student;
					
					var i = 1;
					for (var key in students)
					{

						student={student:students[key],countDegree:i++};

						htmlData = htmlData +  dataLoadHtml(student,'#hbSummary');
						
					}
					
					dataLoad(student, '#hbStudentDetail', '#divStudentDetail');
					$('#divStdSummary').html(htmlData);

				},
				error	:	function(xhr, status, error)
				{

				}
			});
		});

		/* Transcript */
/*
		$(document).on('click','.bttnClsTranscriptDownload',function(event){

			var	varStdStatCode		=	this.getAttribute("stdStatCode");
			var varStudentDTO		= 	JSON.stringify({stdStatCode:varStdStatCode});
			console.log ("varStudentDTO : "+varStudentDTO);
			var student					=	{
					stdStatCode:varStdStatCode
				};
			
			console.log ("student : "+student);
			
			 var oReq = new XMLHttpRequest();
			    oReq.open('POST', '${urlPdfTranscript}', true);
			    oReq.setRequestHeader("Content-Type", "application/json");
			    oReq.setRequestHeader("Content-length", varStudentDTO.length);
			    oReq.setRequestHeader("Connection", "close");
			    
			    oReq.responseType = "blob";
			    
			    oReq.onload = function(oEvent) {
			        var blob = oReq.response;
			        console.log
			        var link=document.createElement('a');
			        link.href=window.URL.createObjectURL(blob);
			        link.download="transcript.pdf";
			        link.click();
			    };

			    oReq.send(varStudentDTO);

		});
		
*/		
		

		/* Transcript */
		$(document).on('click','.bttnClsTranscriptDownload',function(event){
			//event.preventDefault();
			var	varStdStatCode		=	this.getAttribute("stdStatCode");
			var varStudentDTO		= 	{stdStatCode:varStdStatCode};
			console.log ("statcode : "+varStdStatCode);
			
			var student					=	{
					stdStatCode:varStdStatCode
				};
			$.ajaxSetup({
					beforeSend:function(jqHHR, settings)
					{
						//settings.xhr().responseType='arraybuffer';
						settings.xhr().responseType='blob';
						settings.processData=false;
					}
				
			});
			
			
			$.ajax({
				url		:	"${urlPdfTranscript}",
				type	:	'GET',
				cache	:	false,
				data	:	varStudentDTO,
				//dataType:	"binary",
				success	:	function(data)
				{
					console.log('Inside success');
					 console.log("data : "+data); //ArrayBuffer
					 console.log("Blob : "+new Blob([data])) // Blob
					/* 
					 * https://stackoverflow.com/questions/1999607/download-and-open-pdf-file-using-ajax
					 * 
					 * http://danml.com/download.html
					 * 
					 */
					 
					  
				//	 var blob=new Blob([data], {type: 'application/pdf'}) ;
				   /*
					 var link=document.createElement('a');
				    link.href=window.URL.createObjectURL(blob);
				    link.download="transcript"+ new Date() +".pdf";
				    link.click();
				    */
			/*		 
					 var fileURL = URL.createObjectURL(blob);
					 console.log("fileURL : "+fileURL);
	                    var newWin = window.open(fileURL);
	                    newWin.focus();
	                    newWin.reload();
	         */
				    
				},
				error : function(xhr, status, error)
				{
					console.log('Inside error : xhr : '+xhr);
					console.log('Inside error : status : '+status);
					console.log('Inside error : error : '+error);
				}
			});
			
		});
		
		
		
		
		
		
		
		
		
		
		/*
		
		var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance 
xmlhttp.open("POST", "/json-handler");
xmlhttp.setRequestHeader("Content-Type", "application/json");
xmlhttp.send(JSON.stringify({name:"John Rambo", time:"2pm"}));
		
		
		*/
		
		
		
		
		
		
		
		
		/* Handlebar data load */		
		function dataLoad(dataJson, hbTemplateId, tableId)
		{
			//event.preventDefault();
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
			//event.preventDefault();
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