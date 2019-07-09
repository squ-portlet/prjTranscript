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
 * File Name			:	TranscriptPdfImpl.java
 * Package Name			:	om.edu.squ.squportal.portlet.transcript.dao.pdf
 * Date of creation		:	Aug 7, 2018  11:45:33 AM
 * Date of modification :	
 * 
 * Summary				:	
 *
 *
 * Copyright 2018 the original author or authors and Organization.
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
package om.edu.squ.squportal.portlet.transcript.dao.pdf;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.ResourceResponse;

import om.edu.squ.squportal.portlet.transcript.dao.bo.GradeSemester;
import om.edu.squ.squportal.portlet.transcript.dao.bo.Postpone;
import om.edu.squ.squportal.portlet.transcript.dao.bo.RegistrationBO;
import om.edu.squ.squportal.portlet.transcript.dao.bo.Student;
import om.edu.squ.squportal.portlet.transcript.dao.bo.StudentStatus;
import om.edu.squ.squportal.portlet.transcript.dao.db.TranscriptDbDao;
import om.edu.squ.squportal.portlet.transcript.utility.Constants;
import om.edu.squ.squportal.portlet.transcript.utility.UtilProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @author Bhabesh
 *
 */
public class TranscriptPdfImpl implements TranscriptPdfDao
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	

    private static final 	Rectangle 			PAGE_SIZE 			= PageSize.A4;

    private					BaseFont			bFontReg			=	null;
    	
    private					Date				currentDate			=	null;
    private					SimpleDateFormat	currentSimpleDate	=	null;					
    
	@Autowired
	TranscriptDbDao		transcriptDbDao;
	
	public OutputStream getPdfTranscript(String studentNo, String stdStatCode,  String collegeName, ByteArrayOutputStream	byos, InputStream	inputStream, ResourceResponse res, Locale locale) throws IOException, DocumentException
	{
		bFontReg				=	BaseFont.createFont(Constants.CONST_FILE_FONT_ARIALUNI_REGULAR, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
		
		currentDate				=	new Date();		
		currentSimpleDate		=	null;

		if(locale.getLanguage().equals("en"))
		{
			currentSimpleDate	=	new	SimpleDateFormat("EEE, dd-MMM-yyyy");
		}
		else
		{
			currentSimpleDate	=	new	SimpleDateFormat("EEE, dd-MMM-yyyy", new Locale("ar", "OM"));
		}
	
		PdfReader				pdfTemplate				=	new PdfReader(inputStream);
		Student  				student				 	=	transcriptDbDao.getStudent(stdStatCode, locale);	
		float					gradePointCommulative	=	0.0f;
		
		

		try
		{
				PdfStamper		pdfStamper			=	new PdfStamper(pdfTemplate, byos );
				AcroFields form = pdfStamper.getAcroFields();
				form.addSubstitutionFont(bFontReg);
				
				pdfStamper.getAcroFields().setField("headerUniversityName", UtilProperty.getMessage("prop.transcript.header.university.name", null, locale) );
				pdfStamper.getAcroFields().setField("headerAnRName", UtilProperty.getMessage("prop.transcript.header.deanship.admission.and.registration.name", null, locale));
				pdfStamper.getAcroFields().setField("headerTranscriptName", UtilProperty.getMessage("prop.transcript.header.academic.transcript.text", null, locale));

				pdfStamper.getAcroFields().setField("lblDate", UtilProperty.getMessage("prop.transcript.label.date.text", null, locale));
				pdfStamper.getAcroFields().setField("txtDate",currentSimpleDate.format(currentDate));
				
				pdfStamper.getAcroFields().setField("lblStudentId", UtilProperty.getMessage("prop.transcript.label.stdudent.id", null, locale));
				pdfStamper.getAcroFields().setField("lblDOB", UtilProperty.getMessage("prop.transcript.label.stdudent.date.of.birth", null, locale));
				pdfStamper.getAcroFields().setField("lblName", UtilProperty.getMessage("prop.transcript.label.stdudent.name", null, locale));
				pdfStamper.getAcroFields().setField("lblGender", UtilProperty.getMessage("prop.transcript.label.stdudent.gender", null, locale));
				pdfStamper.getAcroFields().setField("lblCollege", UtilProperty.getMessage("prop.transcript.label.stdudent.college", null, locale));
				pdfStamper.getAcroFields().setField("lblFirstAdmitted", UtilProperty.getMessage("prop.transcript.label.stdudent.first.admitted.to", null, locale));
				pdfStamper.getAcroFields().setField("lblMajor", UtilProperty.getMessage("prop.transcript.label.stdudent.major", null, locale));
				
				if(student.getFirstMajor().trim().equals(""))
				{
					pdfStamper.getAcroFields().setField("lblFirstMajor", "");
					pdfStamper.getAcroFields().setField("lblFirstMajorColon", "");
					
				}
				else
				{
					pdfStamper.getAcroFields().setField("lblFirstMajor", UtilProperty.getMessage("prop.transcript.label.stdudent.major", null, locale));
				}
				
				pdfStamper.getAcroFields().setField("lblSchoolCertificateType", UtilProperty.getMessage("prop.transcript.label.stdudent.school.certificate", null, locale));
				pdfStamper.getAcroFields().setField("lblDegreeName", UtilProperty.getMessage("prop.transcript.label.stdudent.degree.name", null, locale));
				pdfStamper.getAcroFields().setField("lblStream", UtilProperty.getMessage("prop.transcript.label.stdudent.degree.stream", null, locale));
				pdfStamper.getAcroFields().setField("lblAdvisor", UtilProperty.getMessage("prop.transcript.label.stdudent.advisor", null, locale));

				pdfStamper.getAcroFields().setField("lblCourseNo", UtilProperty.getMessage("prop.transcript.label.course", null, locale));
				pdfStamper.getAcroFields().setField("lblCourseTitle", UtilProperty.getMessage("prop.transcript.label.course.title", null, locale));
				pdfStamper.getAcroFields().setField("lblCredits", UtilProperty.getMessage("prop.transcript.label.credits", null, locale));
				pdfStamper.getAcroFields().setField("lblGrade", UtilProperty.getMessage("prop.transcript.label.grade", null, locale));
				pdfStamper.getAcroFields().setField("lblRemarks", UtilProperty.getMessage("prop.transcript.label.remark", null, locale));
				pdfStamper.getAcroFields().setField("txtFrmStudentId", student.getStudentId() + " / "+student.getCohort());
				pdfStamper.getAcroFields().setField("txtFrmDOB", student.getBirthDay());
				
				pdfStamper.getAcroFields().setField("txtFrmStudentName", student.getStudentName());
				pdfStamper.getAcroFields().setField("txtFrmGender", student.getGender());
				
				pdfStamper.getAcroFields().setField("txtCollege", student.getCollegeName());
				pdfStamper.getAcroFields().setField("txtFrmAdmissionCollege", student.getFirstCollege());
				
				pdfStamper.getAcroFields().setField("txtFrmMajor", student.getMajorName());
				pdfStamper.getAcroFields().setField("txtFrmFirstMajor", student.getFirstMajor());
				pdfStamper.getAcroFields().setField("txtFrmSchoolCertificateType", student.getSchoolCertificateType());
				pdfStamper.getAcroFields().setField("txtFrmSchoolStream", student.getSchoolStream());
				
				if(! student.getSchoolPercentage().trim().equals("0"))
				{
					pdfStamper.getAcroFields().setField("txtFrmSchoolPercent", student.getSchoolPercentage()+"%");
				}
				
				
				pdfStamper.getAcroFields().setField("txtDegreeName", student.getDegreeName());
				pdfStamper.getAcroFields().setField("txtAdvisor01", student.getEmpNameAdvisor());
				pdfStamper.getAcroFields().setField("txtAdvisor02", student.getEmpNameAdvisor2());
				
				List<StudentStatus>	studentStatusList	=	transcriptDbDao.getStudentStatusList(studentNo, stdStatCode, collegeName, locale);
				
				PdfPTable			tableSemester		=	new	PdfPTable(5);
				PdfPCell			cellBlankNoBorder	=	setTableCell( " ",Rectangle.NO_BORDER,setFont_01());
				
				if(locale.getLanguage().equals("en"))
				{
					tableSemester.setWidths(new int[]{5,15,5,5,10});
				}
				else
				{
					tableSemester.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
					tableSemester.setWidths(new int[]{48,24,22,52,12});
				}
									
				pdfStamper.getAcroFields().setField("tblCourseNo", UtilProperty.getMessage("prop.transcript.label.course", null, locale));
				pdfStamper.getAcroFields().setField("tblCourseTitle", UtilProperty.getMessage("prop.transcript.label.course.title", null, locale));
				pdfStamper.getAcroFields().setField("tblCredits", UtilProperty.getMessage("prop.transcript.label.credits", null, locale));
				pdfStamper.getAcroFields().setField("tblGrade", UtilProperty.getMessage("prop.transcript.label.grade", null, locale));
				pdfStamper.getAcroFields().setField("tblRemarks", UtilProperty.getMessage("prop.transcript.label.remark", null, locale));

				for(StudentStatus stdStatus: studentStatusList)
				{
									gradePointCommulative	=	stdStatus.getGradePointCummulative();

									/* Semester display*/
									tableSemester.addCell(setTableCell(UtilProperty.getMessage("prop.transcript.semester.text", null, locale),PdfPCell.NO_BORDER,setFont_02()));
									PdfPCell	cellStatusYrSem		=	setTableCell(stdStatus.getCourseYear() + " " + stdStatus.getSemesterName(),Rectangle.NO_BORDER,setFont_02());
									tableSemester.addCell(cellStatusYrSem);

									/* History Display */
									if(null != stdStatus.getHistory() && !stdStatus.getHistory().trim().equals(""))
									{
										PdfPCell	cellStatusHistory	=	setTableCell(stdStatus.getHistory().trim(),Rectangle.NO_BORDER,setFont_03());
												cellStatusHistory.setColspan(3);
												if(locale.getLanguage().equals("en"))
												{
													cellStatusHistory.setHorizontalAlignment(Element.ALIGN_RIGHT);
												}
												else
												{
													cellStatusHistory.setHorizontalAlignment(Element.ALIGN_LEFT);
												}
										tableSemester.addCell(cellStatusHistory);
									}
									else
									{
										PdfPCell	cellStatusHistory	=	setTableCell("",Rectangle.NO_BORDER,setFont_03());
										cellStatusHistory.setColspan(3);
										tableSemester.addCell(cellStatusHistory);
									}
									tableSemester.completeRow();

									List<GradeSemester> gradeSemesters	=	transcriptDbDao.getStudentGradeList(student.getStudentNo(), String.valueOf(stdStatus.getSemesterCode()), stdStatus.getCourseYear(), locale);
									/******* Course Header *******/
									if(null != gradeSemesters && gradeSemesters.size() != 0)
									{
														tableSemester.addCell(setTableCell(UtilProperty.getMessage("prop.transcript.label.course", null, locale),PdfPCell.NO_BORDER,setFont_04()));
														tableSemester.addCell(setTableCell(UtilProperty.getMessage("prop.transcript.label.course.title", null, locale),PdfPCell.NO_BORDER,setFont_04()));
										
										PdfPCell	cellHdTblCredits	=	setTableCell(UtilProperty.getMessage("prop.transcript.label.credits", null, locale),PdfPCell.NO_BORDER,setFont_04());
													cellHdTblCredits.setHorizontalAlignment(Element.ALIGN_RIGHT);

														tableSemester.addCell(cellHdTblCredits);
	
										PdfPCell	cellHdTblGrade	=	setTableCell(UtilProperty.getMessage("prop.transcript.label.grade", null, locale),PdfPCell.NO_BORDER,setFont_04());
													cellHdTblGrade.setHorizontalAlignment(Element.ALIGN_RIGHT);

														tableSemester.addCell(cellHdTblGrade);													
										
										PdfPCell	cellHdTblRemark	=	setTableCell(UtilProperty.getMessage("prop.transcript.label.remark", null, locale),PdfPCell.NO_BORDER,setFont_04());
															cellHdTblRemark.setHorizontalAlignment(Element.ALIGN_CENTER);
															tableSemester.addCell(cellHdTblRemark);													
														
														tableSemester.completeRow();
										
										/* Grades Display */
										for (GradeSemester grade: gradeSemesters)
										{
														tableSemester.addCell(setTableCell(grade.getCourseNo(),PdfPCell.NO_BORDER,setFont_01()));
														tableSemester.addCell(setTableCell(grade.getCourseName(),PdfPCell.NO_BORDER,setFont_01()));
											PdfPCell	cellGradeCourseCredit =	(setTableCell(String.valueOf(grade.getCourseCredit()),PdfPCell.NO_BORDER,setFont_01()));
														cellGradeCourseCredit.setHorizontalAlignment(Element.ALIGN_RIGHT);
														tableSemester.addCell(cellGradeCourseCredit);

											PdfPCell	cellGradeCourseCreditValue	=	setTableCell(String.format("%1$2s", grade.getCourseCreditValue()),PdfPCell.NO_BORDER,setFont_01());
														cellGradeCourseCreditValue.setHorizontalAlignment(Element.ALIGN_RIGHT);
														tableSemester.addCell(cellGradeCourseCreditValue);
														if(grade.getRepeated().trim().equals(""))
														{
															tableSemester.addCell(setTableCell(" ",PdfPCell.NO_BORDER,setFont_01()));
														}
														else
														{
															tableSemester.addCell(
																					setTableCell(
																										UtilProperty.getMessage("prop.transcript.grade.repeated", null, locale)
																									+	grade.getRepeated()
																									,	PdfPCell.NO_BORDER
																									,	setFont_01()
																								)
																				);
														}
														tableSemester.completeRow();
										}									
									}
									/* one blank row */								
									cellBlankNoBorder.setBorder(PdfPCell.NO_BORDER);
									cellBlankNoBorder.setColspan(5);
									tableSemester.addCell(cellBlankNoBorder);
									tableSemester.completeRow();
									
									/* another loop for courses and related information */
									if(locale.getLanguage().equals("en"))
									{	
										tableSemester.addCell(setTableCell(UtilProperty.getMessage("prop.transcript.credits.text", null, locale),Rectangle.NO_BORDER,setFont_01()));
										
										tableSemester.addCell(
																	setTableCell(
																						UtilProperty.getMessage("prop.transcript.total.attempted.text", null, locale)	+	stdStatus.getCreditTakenCummulative()
																					,	Rectangle.NO_BORDER
																					,	setFont_01()
																				)
																);
									}
									else
									{	
										
										
										PdfPCell	cellTranscriptAttempted	=	setTableCell(
																								UtilProperty.getMessage("prop.transcript.total.attempted.text", null, locale)	+	stdStatus.getCreditTakenCummulative()
																							,	Rectangle.NO_BORDER
																							,	setFont_01()
																							);
													cellTranscriptAttempted.setBorder(PdfPCell.NO_BORDER);
													cellTranscriptAttempted.setColspan(2);
													tableSemester.addCell(cellTranscriptAttempted);
										
										
									}
									
									
	
									
									String		txtCreditTaken	=	(locale.getLanguage().equals("en")) 
																	?	UtilProperty.getMessage("prop.transcript.attempted.text", null, locale)	+	stdStatus.getCreditTaken()
																	:	UtilProperty.getMessage("prop.transcript.attempted.text", null, locale) + " : " + stdStatus.getCreditTaken();
												PdfPCell	cellCreditAttempted	= setTableCell(
																								txtCreditTaken
																							,	Rectangle.NO_BORDER
																							,	setFont_01()
																					);
												if(locale.getLanguage().equals("en"))
												{
													cellCreditAttempted.setHorizontalAlignment(Element.ALIGN_RIGHT);
												}

															
									tableSemester.addCell(cellCreditAttempted);	
									

									String		txtEarned	=	(locale.getLanguage().equals("en")) 
																?	UtilProperty.getMessage("prop.transcript.earned.text", null, locale)	+	stdStatus.getCreditEarned()
																:	 UtilProperty.getMessage("prop.transcript.earned.text", null, locale) + " : " + stdStatus.getCreditEarned() ;
	
									
									
												PdfPCell	cellCreditEarned	=	setTableCell(
																									txtEarned
																								,	Rectangle.NO_BORDER
																								,	setFont_01()
																						);
												if(locale.getLanguage().equals("en"))		
													{
														cellCreditEarned.setHorizontalAlignment(Element.ALIGN_RIGHT);
													}


									tableSemester.addCell(cellCreditEarned);
									
									
								
									
												PdfPCell	cellSemNCumGPA	=	setTableCell(
																							UtilProperty.getMessage("prop.transcript.sem.gpa.text", null, locale)	+ " " +	stdStatus.getSemGPA()
																						+	"    "
																						+ 	UtilProperty.getMessage("prop.transcript.cum.gpa.text", null, locale)	+ " " +	stdStatus.getCumGPA()
																						,	Rectangle.NO_BORDER
																						,	setFont_01()
																				);
															cellSemNCumGPA.setHorizontalAlignment(Element.ALIGN_RIGHT);
									tableSemester.addCell(cellSemNCumGPA);	

									tableSemester.completeRow();
									
									
								/*Semester course load status*/
									if(! stdStatus.getLoadStatusSemester().equals(stdStatus.getLoadStatusStudent()))
									{
										PdfPCell	cellSemCourseLoadStatus	=	setTableCell(
																									UtilProperty.getMessage("prop.transcript.semester.course.load.status.text", null, locale)
																								+	" "
																								+	stdStatus.getLoadStatusSemester(),Rectangle.NO_BORDER,setFont_03()
																							);
													cellSemCourseLoadStatus.setBorder(PdfPCell.NO_BORDER);
													cellSemCourseLoadStatus.setColspan(5);
													tableSemester.addCell(cellSemCourseLoadStatus);
													tableSemester.completeRow();
									}


									/*student course load status*/	
									String txtLoadStatusStudent	=	null;
									if(null != stdStatus.getLoadStatusStudent())
									{
										txtLoadStatusStudent	=	stdStatus.getLoadStatusStudent();
									}
									else
									{
										txtLoadStatusStudent	=	"";
									}

									PdfPCell	cellStdLoadStatus = setTableCell(UtilProperty.getMessage("prop.transcript.student.course.load.status.text", null, locale)+" "+txtLoadStatusStudent,Rectangle.NO_BORDER,setFont_03());
												cellStdLoadStatus.setColspan(5);
												cellStdLoadStatus.setBorder(PdfPCell.NO_BORDER);
												tableSemester.addCell(cellStdLoadStatus);
												tableSemester.completeRow();
									
									
									/*student distinction status*/									
									if(null!= stdStatus.getHonorDistinction() && ! stdStatus.getHonorDistinction().trim().equals(""))
									{
									PdfPCell	cellStdHonorList = setTableCell(UtilProperty.getMessage("prop.transcript.student.honours.list", null, locale)+" "+stdStatus.getHonorDistinction(),Rectangle.NO_BORDER,setFont_03());
												cellStdHonorList.setColspan(5);
												cellStdHonorList.setBorder(PdfPCell.NO_BORDER);
									tableSemester.addCell(cellStdHonorList);
									tableSemester.completeRow();
									}
									/*student excellent status*/									
									if(null!= stdStatus.getExcellentList() && ! stdStatus.getExcellentList().trim().equals(""))
									{
									PdfPCell	cellStdExcellentList = setTableCell(UtilProperty.getMessage("prop.transcript.student.excellent.list", null, locale)+" "+stdStatus.getExcellentList(),Rectangle.NO_BORDER,setFont_03());
												cellStdExcellentList.setColspan(5);
												cellStdExcellentList.setBorder(PdfPCell.NO_BORDER);
									tableSemester.addCell(cellStdExcellentList);
									tableSemester.completeRow();
									}	
									
									/* one blank row with top border*/								
									cellBlankNoBorder.setBorder(PdfPCell.TOP);
									cellBlankNoBorder.setColspan(5);
									tableSemester.addCell(cellBlankNoBorder);
									tableSemester.completeRow();
									/* ************************* */
																		
									
				}
				
				PdfPCell	cellTotalCreditsAttemped = setTableCell(
																	UtilProperty.getMessage("prop.transcript.total.grade.points.text", null, locale)
																+	" "
																+	gradePointCommulative	
																+	"      "
																+	UtilProperty.getMessage("prop.transcript.total.credits.attempted.text", null, locale)
																+	" : "
																+	 student.getTotalCreditTaken()
																,Rectangle.NO_BORDER
																,setFont_01()
																);
							cellTotalCreditsAttemped.setBorder(PdfPCell.BOTTOM);
							cellTotalCreditsAttemped.setColspan(2);
							tableSemester.addCell(cellTotalCreditsAttemped);
							
							
							cellBlankNoBorder.setColspan(1);
							cellBlankNoBorder.setBorder(PdfPCell.BOTTOM);
							tableSemester.addCell(cellBlankNoBorder);
							
				PdfPCell	cellTotalCreditsEarned = setTableCell(
																	UtilProperty.getMessage("prop.transcript.total.credits.earned.text", null, locale)
																	+ " : "
																	+	student.getTotalCreditEarned()
																	,	Rectangle.NO_BORDER,setFont_01()
																	);
							if(locale.getLanguage().equals("en"))
							{
								cellTotalCreditsEarned.setHorizontalAlignment(Element.ALIGN_LEFT);
							}

							cellTotalCreditsEarned.setColspan(2);
							cellTotalCreditsEarned.setBorder(PdfPCell.BOTTOM);
							tableSemester.addCell(cellTotalCreditsEarned);

				tableSemester.completeRow();
				
				cellBlankNoBorder.setBorder(PdfPCell.NO_BORDER);
				cellBlankNoBorder.setColspan(5);
				tableSemester.addCell(cellBlankNoBorder);
				tableSemester.completeRow();
				
				
				PdfPCell	cellTextNoGradeEntry = setTableCell(UtilProperty.getMessage("prop.transcript.no.grade.entries.after.text", null, locale),Rectangle.NO_BORDER,setFont_03());
							cellTextNoGradeEntry.setHorizontalAlignment(Element.ALIGN_CENTER);
				cellTextNoGradeEntry.setColspan(5);
				tableSemester.addCell(cellTextNoGradeEntry);

				cellBlankNoBorder.setColspan(5);
				cellBlankNoBorder.setBorder(PdfPCell.BOTTOM);
				tableSemester.addCell(cellBlankNoBorder);
				tableSemester.completeRow();
				
				tableSemester.completeRow();

				
/***** Student Current semester registration details ********/
				List<RegistrationBO>	registrations	=	transcriptDbDao.getRegistrationList(stdStatCode, collegeName);
				for(RegistrationBO semester: registrations)
				{
					tableSemester.addCell(setTableCell(UtilProperty.getMessage("prop.transcript.semester.current", null, locale),Rectangle.NO_BORDER,setFont_02()));
				PdfPCell	cellCurrentYrSem		=	setTableCell(semester.getStudentStatus().getCourseYear() + " " + semester.getStudentStatus().getSemesterName(),Rectangle.NO_BORDER,setFont_02());
							cellCurrentYrSem.setColspan(4);
				tableSemester.addCell(cellCurrentYrSem);
				tableSemester.completeRow();
				
					if(! semester.getStudentStatus().getHistory().trim().equals(""))
					{
					PdfPCell	cellCurrentSemHistory		=	setTableCell(semester.getStudentStatus().getHistory() ,Rectangle.NO_BORDER,setFont_02());
								cellCurrentSemHistory.setColspan(5);
					tableSemester.addCell(cellCurrentSemHistory);
					tableSemester.completeRow();
					}
					break;
				}
				
				for(RegistrationBO reg: registrations)
				{
					tableSemester.addCell(setTableCell(reg.getGradeSemester().getCourseNo(),PdfPCell.NO_BORDER,setFont_01()));
					tableSemester.addCell(setTableCell(reg.getGradeSemester().getCourseName(),PdfPCell.NO_BORDER,setFont_01()));
					PdfPCell	cellRegCourseCredit =	(setTableCell(String.valueOf(reg.getGradeSemester().getCourseCredit()),PdfPCell.NO_BORDER,setFont_01()));
					cellRegCourseCredit.setHorizontalAlignment(Element.ALIGN_RIGHT);
					tableSemester.addCell(cellRegCourseCredit);					
					
					tableSemester.addCell(setTableCell(" ",PdfPCell.NO_BORDER,setFont_01()));
					tableSemester.addCell(setTableCell(reg.getlAbrStatus(),PdfPCell.NO_BORDER,setFont_01()));
					
					tableSemester.completeRow();
				}
				
/***** Student Postponement details ********/				
				List<Postpone> 	postpones	=	transcriptDbDao.getPostponeList(stdStatCode);
				if(postpones.size()>0)
				{
					tableSemester.addCell(setTableCell(" ",PdfPCell.NO_BORDER,setFont_01()));
					tableSemester.addCell(setTableCell(UtilProperty.getMessage("prop.transcript.postpone.text", null, locale),PdfPCell.NO_BORDER,setFont_01()));
					tableSemester.addCell(setTableCell(UtilProperty.getMessage("prop.transcript.postpone.date.text", null, locale),PdfPCell.NO_BORDER,setFont_01()));
					tableSemester.addCell(setTableCell(UtilProperty.getMessage("prop.transcript.postpone.semester.from", null, locale),PdfPCell.NO_BORDER,setFont_01()));
					tableSemester.addCell(setTableCell(UtilProperty.getMessage("prop.transcript.postpone.semester.to", null, locale),PdfPCell.NO_BORDER,setFont_01()));
					tableSemester.completeRow();
					
					for(Postpone postpone: postpones)
					{
						tableSemester.addCell(setTableCell(" ",PdfPCell.NO_BORDER,setFont_01()));
						tableSemester.addCell(setTableCell(" ",PdfPCell.NO_BORDER,setFont_01()));
						tableSemester.addCell(setTableCell(postpone.getPostponeDate(),PdfPCell.NO_BORDER,setFont_01()));
						tableSemester.addCell(setTableCell(postpone.getFromYrSem(),PdfPCell.NO_BORDER,setFont_01()));
						tableSemester.addCell(setTableCell(postpone.getToYrSem(),PdfPCell.NO_BORDER,setFont_01()));
						tableSemester.completeRow();
					}
				}
				
				
/**** Student status ****/		
				cellBlankNoBorder.setColspan(5);
				cellBlankNoBorder.setBorder(Rectangle.NO_BORDER);
				tableSemester.addCell(cellBlankNoBorder);
				tableSemester.completeRow();
				
				PdfPCell	cellTextStudentStatus = setTableCell(UtilProperty.getMessage("prop.transcript.student.status.text", null, locale),Rectangle.NO_BORDER,setFont_01());
							cellTextStudentStatus.setColspan(2);
							tableSemester.addCell(cellTextStudentStatus);

				PdfPCell	cellStudentStatus = setTableCell(student.getStatusName(),Rectangle.NO_BORDER,setFont_02());
							cellStudentStatus.setColspan(3);
							tableSemester.addCell(cellStudentStatus);
				tableSemester.completeRow();
				

/***** End of Transcript ***/				

				cellBlankNoBorder.setColspan(5);
				if(locale.getLanguage().equals("en"))
				{
					cellBlankNoBorder.setRowspan(2);
				}
				cellBlankNoBorder.setBorder(Rectangle.NO_BORDER);
				tableSemester.addCell(cellBlankNoBorder);
				tableSemester.completeRow();

				PdfPCell	cellTextEndOfTranscript = setTableCell(UtilProperty.getMessage("prop.transcript.end.transcript.text", null, locale),Rectangle.NO_BORDER,setFont_01());
				cellTextEndOfTranscript.setHorizontalAlignment(Element.ALIGN_CENTER);
				cellTextEndOfTranscript.setColspan(5);
				tableSemester.addCell(cellTextEndOfTranscript);
				tableSemester.completeRow();
	
				cellBlankNoBorder.setColspan(5);
				cellBlankNoBorder.setBorder(Rectangle.NO_BORDER);
				tableSemester.addCell(cellBlankNoBorder);
				tableSemester.completeRow();

				
/******* KEY  ****/	
				PdfPCell	cellTextKeys = setTableCell(UtilProperty.getMessage("prop.transcript.key.text", null, locale),Rectangle.NO_BORDER,setFont_01());
							cellTextKeys.setColspan(5);
							tableSemester.addCell(cellTextKeys);
							tableSemester.completeRow();
				
				
				ColumnText	columnSemester		=	new ColumnText(pdfStamper.getOverContent(1));
				Rectangle	rectangleSemester	=	new Rectangle(-40,35,645,500);
				Rectangle	rectangleNewPage	=	new Rectangle(-40,35,645,725);
				rectangleNewPage.setBorder(0);
				columnSemester.setSimpleColumn(rectangleSemester);
				columnSemester.addElement(tableSemester);
				int status = columnSemester.go();
				int pagecount = 1;
				int linecount=1;
				while (ColumnText.hasMoreText(status)) {
			        status = triggerNewPage(pdfStamper, PAGE_SIZE, columnSemester, rectangleNewPage, ++pagecount);
			    }
				
				setHeader_01(pdfTemplate, pdfStamper, columnSemester, student, locale);
				setFooter_01(pdfTemplate, pdfStamper, locale);

				
				pdfStamper.getAcroFields().setGenerateAppearances(true);
				
				
				
				pdfStamper.setFormFlattening(true);
				pdfStamper.close();
				
		}
		catch(DocumentException exception)
		{
			logger.error("DocumentException. Details : {}",exception);
		}
		
		
		pdfTemplate.close();
		
		res.setContentType("application/pdf");
		
		return res.getPortletOutputStream();
	}
	
	
	/**
	 * 
	 * method name  : getTableCell
	 * @param text
	 * @param border
	 * @param font
	 * @return
	 * TranscriptPdfImpl
	 * return type  : PdfPCell
	 * 
	 * purpose		:
	 *
	 * Date    		:	Oct 24, 2018 11:52:16 AM
	 */
	private PdfPCell setTableCell(String text, int border, Font font)
	{
		Phrase		phrase		=	new Phrase(text, font);
		PdfPCell	pdfPCell	=	new PdfPCell(phrase);
					pdfPCell.setBorder(border);
			
		return pdfPCell;
	}
	
	
	
	
	/**
	 * 
	 * method name  : getFont_01
	 * @return
	 * TranscriptPdfImpl
	 * return type  : Font
	 * 
	 * purpose		:
	 *
	 * Date    		:	Oct 24, 2018 10:27:12 AM
	 */
	private	Font setFont_01()
	{
		return new Font(bFontReg,8,Font.NORMAL);
	}

	private	Font setFont_02()
	{
		return new Font(bFontReg,10,Font.BOLD);
	}
	private	Font setFont_03()
	{
		return new Font(bFontReg,10,Font.NORMAL);
	}
	
	private	Font setFont_04()
	{
		return new Font(bFontReg,8,Font.BOLD);
	}

	
	/**
	 * 
	 * method name  : triggerNewPage
	 * @param stamper
	 * @param pagesize
	 * @param column
	 * @param rect
	 * @param pagecount
	 * @return
	 * @throws DocumentException
	 * TranscriptPdfImpl
	 * return type  : int
	 * 
	 * purpose		:
	 *
	 * Date    		:	Nov 13, 2018 12:53:44 PM
	 */
	private int triggerNewPage(PdfStamper stamper, Rectangle pagesize, ColumnText column, Rectangle rect, int pagecount) throws DocumentException {

		
		stamper.insertPage(pagecount, pagesize);
	    PdfContentByte canvas = stamper.getOverContent(pagecount);
	    
	    canvas.rectangle(pagesize.getLeft(), pagesize.getBottom(), pagesize.getWidth(), pagesize.getHeight());
	   
	    column.setCanvas(canvas);
	    column.setSimpleColumn(rect);
	    
	    return column.go();
	}

	/**
	 * 
	 * method name  : setHeader_01
	 * @param reader
	 * @param stamper
	 * @param column
	 * @param student
	 * @param locale
	 * @throws DocumentException
	 * TranscriptPdfImpl
	 * return type  : void
	 * 
	 * purpose		:
	 *
	 * Date    		:	Nov 13, 2018 12:53:23 PM
	 */
	private void setHeader_01( PdfReader reader,PdfStamper stamper, ColumnText column, Student student, Locale locale) throws DocumentException
	{
		
		Phrase header_01 = new Phrase(UtilProperty.getMessage("prop.transcript.header.university.name", null, locale), new Font(bFontReg, 12));
		Phrase header_02 = new Phrase(UtilProperty.getMessage("prop.transcript.header.deanship.admission.and.registration.name", null, locale), new Font(bFontReg, 10));
		Phrase header_03 = new Phrase(UtilProperty.getMessage("prop.transcript.header.academic.transcript.text", null, locale), new Font(bFontReg, 10));
		
		for (int i = 2; i <= reader.getNumberOfPages(); i++) {
            float x = reader.getPageSize(i).getWidth() / 2;
            float y = reader.getPageSize(i).getTop(30);
            
            if(!locale.getLanguage().equals("en"))
            {
            	ColumnText.showTextAligned(	stamper.getOverContent(i), Element.ALIGN_CENTER, header_01, x, y, 0,PdfWriter.RUN_DIRECTION_RTL,0);
                ColumnText.showTextAligned(	stamper.getOverContent(i), Element.ALIGN_CENTER, header_02, x, y-15, 0,PdfWriter.RUN_DIRECTION_RTL,0);
                ColumnText.showTextAligned(	stamper.getOverContent(i), Element.ALIGN_CENTER, header_03, x, y-30, 0,PdfWriter.RUN_DIRECTION_RTL,0);
            }
            else{
            	ColumnText.showTextAligned(	stamper.getOverContent(i), Element.ALIGN_CENTER, header_01, x, y, 0);
                ColumnText.showTextAligned(	stamper.getOverContent(i), Element.ALIGN_CENTER, header_02, x, y-15, 0);
                ColumnText.showTextAligned(	stamper.getOverContent(i), Element.ALIGN_CENTER, header_03, x, y-30, 0);
            }
            
            
            
            
            PdfPTable			tableHeader_01		=	new	PdfPTable(6);
            tableHeader_01.setWidths(new int[]{3,10,1,7,3,7});
            if(!locale.getLanguage().equals("en"))
            {
            	tableHeader_01.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
            	tableHeader_01.setWidths(new int[]{7,6,7,6,10,3});
            }
            
    		
    		
    		Rectangle recHeaderSize_01 = new Rectangle(-40,650,640,750);
   		
            
            PdfPTable			tableHeader_02		=	new	PdfPTable(5);
    		tableHeader_02.setWidths(new int[]{4,8,5,4,8});
            
            PdfContentByte canvas = stamper.getOverContent(i);
            
            PdfPCell	hCell_01_01 = 	setTableCell( UtilProperty.getMessage("prop.transcript.header.name", null, locale), Rectangle.NO_BORDER,	setFont_03()) ; 
			hCell_01_01.setBorder(PdfPCell.BOTTOM);
			tableHeader_01.addCell(hCell_01_01);

            PdfPCell	hCell_01_02 = 	setTableCell(student.getStudentName(), Rectangle.NO_BORDER,	setFont_03()) ; 
			hCell_01_02.setBorder(PdfPCell.BOTTOM);
			tableHeader_01.addCell(hCell_01_02);
			
            PdfPCell	hCell_01_03 = 	setTableCell( UtilProperty.getMessage("prop.transcript.header.id", null, locale), Rectangle.NO_BORDER,	setFont_03()); 
			hCell_01_03.setBorder(PdfPCell.BOTTOM);
			tableHeader_01.addCell(hCell_01_03);

            PdfPCell	hCell_01_04 = 	setTableCell( student.getStudentId()+"/"+student.getCohort(), Rectangle.NO_BORDER,	setFont_03()); 
			hCell_01_04.setBorder(PdfPCell.BOTTOM);
			tableHeader_01.addCell(hCell_01_04);
			
            PdfPCell	hCell_01_05 = 	setTableCell( UtilProperty.getMessage("prop.transcript.header.degree", null, locale), Rectangle.NO_BORDER,	setFont_03()); 
			hCell_01_05.setBorder(PdfPCell.BOTTOM);
			tableHeader_01.addCell(hCell_01_05);
			
            PdfPCell	hCell_01_06 = 	setTableCell( student.getDegreeName(), Rectangle.NO_BORDER,	setFont_03()); 
			hCell_01_06.setBorder(PdfPCell.BOTTOM);
			tableHeader_01.addCell(hCell_01_06);
			
			tableHeader_01.completeRow();
			

			PdfPCell	hRow_01_04 = 	setTableCell( " ", Rectangle.NO_BORDER,	setFont_01());
						hRow_01_04.setColspan(6);
						tableHeader_01.addCell(hRow_01_04);
						tableHeader_01.completeRow();
			PdfPCell	hRow_01_05 = 	setTableCell( " ", Rectangle.NO_BORDER,	setFont_01());
						hRow_01_05.setColspan(6);
						tableHeader_01.addCell(hRow_01_05);
						tableHeader_01.completeRow();						
            
            /*---------------------------*/
            PdfPCell	hCell_02_01 = 	setTableCell( "Course No", Rectangle.NO_BORDER,	setFont_04()); 
						hCell_02_01.setBorder(PdfPCell.BOTTOM);
						tableHeader_02.addCell(hCell_02_01);
			PdfPCell	hCell_02_02 = 	setTableCell( "Course Title", Rectangle.NO_BORDER,	setFont_04());
						hCell_02_02.setBorder(PdfPCell.BOTTOM);
						tableHeader_02.addCell(hCell_02_02);
			PdfPCell	hCell_02_03 = 	setTableCell( "Credits", Rectangle.NO_BORDER,	setFont_04());
						hCell_02_03.setBorder(PdfPCell.BOTTOM);
						tableHeader_02.addCell(hCell_02_03);
			PdfPCell	hCell_02_04 = 	setTableCell( "Grade", Rectangle.NO_BORDER,	setFont_04());
						hCell_02_04.setBorder(PdfPCell.BOTTOM);
						tableHeader_02.addCell(hCell_02_04);
			PdfPCell	hCell_02_05 = 	setTableCell( "Remarks", Rectangle.NO_BORDER,	setFont_04());
						hCell_02_05.setBorder(PdfPCell.BOTTOM);
						tableHeader_02.addCell(hCell_02_05);

			tableHeader_02.completeRow();
			
			column.setCanvas(canvas);
			
			column.setSimpleColumn(recHeaderSize_01);
			column.addElement(tableHeader_01);
			
			int status = column.go();

        }
		
	}
	
	/**
	 * 
	 * method name  : setFooter_01
	 * @param reader
	 * @param stamper
	 * @param locale
	 * TranscriptPdfImpl
	 * return type  : void
	 * 
	 * purpose		:
	 *
	 * Date    		:	Nov 13, 2018 12:53:11 PM
	 */
	private void setFooter_01( PdfReader reader,PdfStamper stamper, Locale locale)
	{
		for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            float x = reader.getPageSize(i).getWidth() / 2;
            float y = reader.getPageSize(i).getBottom(20);
            if(locale.getLanguage().equals("en"))
            {
	        		ColumnText.showTextAligned(	
								stamper.getOverContent(i)
							, 	Element.ALIGN_CENTER
							, 	new Phrase(UtilProperty.getMessage("prop.transcript.footer.page.number", null, locale)+" "+i+"/"+reader.getNumberOfPages(), new Font(bFontReg, 8))
							, 	x
							, 	y
							, 	0
	        			);
            }
            else
            	{
            		ColumnText.showTextAligned(	
            	
            									stamper.getOverContent(i)
            								, 	Element.ALIGN_CENTER
            								, 	new Phrase(UtilProperty.getMessage("prop.transcript.footer.page.number", null, locale)+" "+i+"/"+reader.getNumberOfPages(), new Font(bFontReg, 8))
            								, 	x
            								, 	y
            								, 	0
            								,	PdfWriter.RUN_DIRECTION_RTL
            								,	0
            						);
            	}

        }
	}
	
}
