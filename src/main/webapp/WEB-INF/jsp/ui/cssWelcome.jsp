<!--  
 * Project 				:	prjTranscript
 * Organisation 		:	Sultan Qaboos University
 * Center				:	Center for Information System
 * Department 			:	Web & E-Services
 * Author				:	Bhabesh
 * 
 * FrameWork			:	Spring 3.2.3 (Annotation) Portlet
 * 
 * File Name			:	cssWelcome.jsp
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
<!-- UI side validation from http://bootstrapvalidator.com/ -->

<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags" %>

<spring:message code="url.squ.cdn" var="urlCdn"/>



<!-- ******************** CSS Declaration************************ --> 
<c:url value="${urlCdn}/bootstrap/3.1.1/dist/css/bootstrap.css" var="urlCssBootstrap"/>
<c:url value="${urlCdn}/bootstrap/3.1.1/dist/css/bootstrap-theme.min.css" var="urlCssBootstrapThemeMin"/>
<c:url value="${urlCdn}/jqueryui/1.11.4/jquery-ui.css" var="urlCssJQueryUiCustom"/>
<c:url value="${urlCdn}/bootstrap-arabic/bootstrap-3-arabic-master/dist/css/bootstrap-arabic.css" var="urlCssBootstrapArabic"/>
<c:url value="${urlCdn}/bootstrap-arabic/bootstrap-3-arabic-master/dist/css/bootstrap-arabic-theme.css" var="urlCssBootstrapArabicTheme"/>




<!-- ******************** CSS Declaration************************ --> 
<c:url value="${urlCdn}/bootstrap/3.1.1/dist/css/bootstrap.css" var="urlCssBootstrap"/>
<c:url value="${urlCdn}/bootstrap/3.1.1/dist/css/bootstrap-theme.min.css" var="urlCssBootstrapThemeMin"/>
<c:url value="${urlCdn}/jqueryui/1.11.4/jquery-ui.css" var="urlCssJQueryUiCustom"/>
<c:url value="${urlCdn}/bootstrap-arabic/bootstrap-3-arabic-master/dist/css/bootstrap-arabic.css" var="urlCssBootstrapArabic"/>
<c:url value="${urlCdn}/bootstrap-arabic/bootstrap-3-arabic-master/dist/css/bootstrap-arabic-theme.css" var="urlCssBootstrapArabicTheme"/>



	<!-- ------------ data table css declaration -->
<c:url value="${urlCdn}/DataTables/1.10.11/DataTables-1.10.11/css/dataTables.bootstrap.min.css" var="urlCssDataTableBSMin"/>
<c:url value="${urlCdn}/DataTables/1.10.11/Responsive-2.0.2/css/responsive.bootstrap.min.css" var="urlCssDataTableResponsiveBSMin"/>
<c:url value="${urlCdn}/DataTables/1.10.11/RowReorder-1.1.1/css/rowReorder.bootstrap.min.css" var="urlCssDataTableRowReorderBSMin"/>
<c:url value="${urlCdn}/DataTables/1.10.11/Buttons-1.1.2/css/buttons.dataTables.min.css" var="urlCssDataTableBttn"/>
<c:url value="${urlCdn}/DataTables/1.10.11/Buttons-1.1.2/css/buttons.bootstrap.min.css" var="urlCssDataTableBttnBS"/>

<!-- ******************** JS Declaration************************ -->

<c:url value="${urlCdn}/bootstrap/3.3.6/dist/js/bootstrap.min.js" var="urlJsBootStrapMin"/>
<c:url value="${urlCdn}/bootstrap/3.3.6/js/button.js" var="urlJsBootStrapButton"/>
<c:url value="${urlCdn}/bootstrap/3.3.6/js/modal.js" var="urlJsBootStrapModal"/>
<c:url value="${urlCdn}/bootstrap-arabic/bootstrap-3-arabic-master/3.3.6/js/bootstrap-arabic.js" var="urlJsBootstrapArabic"/>
<c:url value="${urlCdn}/jquery/1.11.3/jquery-1.11.3.min.js" var="urlJsJqueryMin"/>
<c:url value="${urlCdn}/jqueryui/1.11.4/jquery-ui.min.js" var="urlJsJqueryUIMin"/>
<c:url value="${urlCdn}/jqueryvalidation/1.13.1/jquery.validate.min.js" var="urlJsValidatorJquery"/>
<c:url value="${urlCdn}/jqueryvalidation/1.13.1/additional-methods.min.js" var="urlJsValidatorJqueryAddl"/>

<c:url value="/ui/js/download.js" var="urlJsDownloadJS"/>

	<!-- ------------ Data Table js declaration -->
<c:url value="${urlCdn}/DataTables/1.10.11/DataTables-1.10.11/js/jquery.dataTables.min.js" var="urlJsDataTableJQueryMin"/>
<c:url value="${urlCdn}/DataTables/1.10.11/DataTables-1.10.11/js/dataTables.bootstrap.min.js" var="urlJsDataTableBSMin"/>
<c:url value="${urlCdn}/DataTables/1.10.11/Responsive-2.0.2/js/dataTables.responsive.min.js" var="urlJsDataTableResponsiveMin"/>
<c:url value="${urlCdn}/DataTables/1.10.11/Responsive-2.0.2/js/responsive.bootstrap.min.js" var="urlJsDataTableResponsiveBSMin"/>
<c:url value="${urlCdn}/DataTables/1.10.11/RowReorder-1.1.1/js/dataTables.rowReorder.min.js" var="urlJsDataTableRowReorderBSMin"/>

<c:url value="${urlCdn}/DataTables/1.10.11/Buttons-1.1.2/js/dataTables.buttons.min.js" var="urlJsDataTableBttn"/>
<c:url value="${urlCdn}/DataTables/1.10.11/Buttons-1.1.2/js/buttons.flash.min.js" var="urlJsDataTableBttnFlash"/>
<c:url value="${urlCdn}/DataTables/1.10.11/Buttons-1.1.2/js/buttons.html5.min.js" var="urlJsDataTableBttnHtml5"/>
<c:url value="${urlCdn}/DataTables/1.10.11/Buttons-1.1.2/js/buttons.print.min.js" var="urlJsDataTableBttnPrint"/>

<!-- ------------ HandleBars js declaration -->
<c:url value="${urlCdn}/handlebars/4.0.5/handlebars-v4.0.5.js" var="urlJsHandleBars"/>
<%-- <c:url value="${urlCdn}/handlebars/4.0.5/handlebars.runtime-v4.0.5.js" var="urlJsHandleBarsRunTime"/> --%>

<!-- ------------ PdfMake js declaration -->
<c:url value="${urlCdn}/pdfmake/0.1.32/build/pdfmake.min.js" var="urlJsPdfMake"/>
<c:url value="${urlCdn}/pdfmake/0.1.32/build/vfs_fonts.js" var="urlJsPdfMakeFontVfs"/>

<!-- ------------ jszip js declaration -->
<c:url value="${urlCdn}/jszip/3.1.3/dist/jszip.min.js" var="urlJsJsZIP"/>


<!-- ******************** CSS implementation************************ --> 
<c:if test="${rc.locale.language == 'en'}" > 
 <link rel="stylesheet" type="text/css" href="${urlCssBootstrap}" />
 <link rel="stylesheet" type="text/css" href="${urlCssBootstrapThemeMin}" />
</c:if>
<c:if test="${rc.locale.language == 'ar'}" >
 <link rel="stylesheet" type="text/css" href="${urlCssBootstrapArabic}" />
 <link rel="stylesheet" type="text/css" href="${urlCssBootstrapArabicTheme}" />
</c:if>

	<!-- ------------ datatable css implementation -->

 <link rel="stylesheet" type="text/css" href="${urlCssDataTableBSMin}" />
 <link rel="stylesheet" type="text/css" href="${urlCssDataTableResponsiveBSMin}" />
 <link rel="stylesheet" type="text/css" href="${urlCssDataTableRowReorderBSMin}" /> 
 <link rel="stylesheet" type="text/css" href="${urlCssDataTableBttn}" /> 
 <link rel="stylesheet" type="text/css" href="${urlCssDataTableBttnBS}" /> 


 <!-- link rel="stylesheet" type="text/css" href="${urlCssBootstrapMin}" /-->

 <link rel="stylesheet" type="text/css" href="${urlCssJQueryUiCustom}" />
 
  <!-- ******************** JS implementation************************ --> 
  <script type="text/javascript" src="${urlJsJqueryMin}"></script>
 <c:if test="${rc.locale.language == 'en'}" > 
 	<script type="text/javascript" src="${urlJsBootStrapMin}"></script>
 </c:if>
 <c:if test="${rc.locale.language == 'ar'}" >
 	<script type="text/javascript" src="${urlJsBootstrapArabic}"></script> 
 </c:if>
 <script type="text/javascript" src="${urlJsBootStrapButton}"></script> 
<%--  <script type="text/javascript" src="${urlJsBootStrapModal}"></script>  --%>
 <script type="text/javascript" src="${urlJsJqueryUIMin}"></script>
 
 
 <script type="text/javascript" src="${urlJsValidatorJquery}"></script>
<script type="text/javascript" src="${urlJsValidatorJqueryAddl}"></script>

	<!-- ------------ datatable js implementation -->
<script type="text/javascript" src="${urlJsDataTableJQueryMin}"></script>
<script type="text/javascript" src="${urlJsDataTableBSMin}"></script>
<script type="text/javascript" src="${urlJsDataTableResponsiveMin}"></script>
<script type="text/javascript" src="${urlJsDataTableResponsiveBSMin}"></script>
<script type="text/javascript" src="${urlJsDataTableRowReorderBSMin}"></script>
<script type="text/javascript" src="${urlJsDataTableBttn}"></script>
<script type="text/javascript" src="${urlJsDataTableBttnFlash}"></script>
<script type="text/javascript" src="${urlJsDataTableBttnHtml5}"></script>
<script type="text/javascript" src="${urlJsDataTableBttnPrint}"></script>

	<!-- ------------ HandleBars js implementation -->
<script type="text/javascript" src="${urlJsHandleBars}"></script>
<script type="text/javascript" src="${urlJsHandleBarsRunTime}"></script>

	<!-- ------------ PdfMake js implementation -->
<script type="text/javascript" src="${urlJsPdfMake}"></script>
<script type="text/javascript" src="${urlJsPdfMakeFontVfs}"></script>

	<!-- ------------ jszip js implementation -->	
<script type="text/javascript" src="${urlJsJsZIP}"></script>

<script type="text/javascript" src="${urlJsDownloadJS}"></script>

 
 <style>
 
 			
			.error {
			    color:red !important;
			}
			
			
			/* For Liferay */
			.aui .popover{
				background-color: #434a54;
			}  
			
			.popover-content {
			    background-color: white;
			}
			
			/* Liferay modal form */
			.aui .modal {
			height: fit-content;
			right:30%;
			/*left:30%;*/
			left:inherit;
			width: 50%;
			overflow-y: hidden;
			border-color:transparent;
			background-color:transparent;
			}
			
			
			@media (max-width: @screen-xs-min) {
			  .modal-xs { width: @modal-sm; }
			  .modal-sm {width: 350px;}
			}
			
			
			
			.modal-dialog {
			  max-width: @modal-md;
			  width: 100%;
			}
			
			.modal-sm {
			  max-width: @modal-sm;
			  height: 20%;
			}
			
			.modal-md {
			  max-width: @modal-sm;
			  height: 20%;
			}
			
			.modal-lg {
			  max-width: @modal-lg;
			}
	
 
 
	 .aui h1, .aui h2, .aui h3, .aui h4, .aui h5, .aui h6 {
	    margin: 5px 0;
	    /* font-family: inherit; */
	    /* font-weight: bold; */
	    /* line-height: 20px; */
	    /* color: inherit; */
	    /* text-rendering: optimizelegibility; */
		}
 
 	.dot {
		    height: 25px;
		    width: 25px;
		    background-color: #bbb;
		    border-radius: 50%;
		    display: inline-block;
	}

/* Reduce hight of panel header  */ 
 .panel-heading {
    padding: 0px;
}
 
 </style>
