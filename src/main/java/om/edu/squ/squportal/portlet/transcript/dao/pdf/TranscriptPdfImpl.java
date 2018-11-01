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
import java.util.List;
import java.util.Locale;

import javax.portlet.ResourceResponse;
import javax.swing.border.LineBorder;

import om.edu.squ.squportal.portlet.transcript.dao.bo.GradeSemester;
import om.edu.squ.squportal.portlet.transcript.dao.bo.Student;
import om.edu.squ.squportal.portlet.transcript.dao.bo.StudentStatus;
import om.edu.squ.squportal.portlet.transcript.dao.db.TranscriptDbDao;
import om.edu.squ.squportal.portlet.transcript.utility.Constants;
import om.edu.squ.squportal.portlet.transcript.utility.UtilProperty;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.google.gson.Gson;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.AcroFields.FieldPosition;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfAppearance;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;

/**
 * @author Bhabesh
 *
 */
public class TranscriptPdfImpl implements TranscriptPdfDao
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static final int INCH = 72;

    final private static float MARGIN_TOP = INCH / 4;
    final private static float MARGIN_BOTTOM = INCH / 2;
	
    private static final Rectangle PAGE_SIZE = PageSize.LETTER;
    private static final Rectangle TEMPLATE_SIZE = PageSize.LETTER;
    
    private float 	currPosition	=	0;
    private int 	currPage		=	0;;
    
	@Autowired
	TranscriptDbDao		transcriptDbDao;
	
	public OutputStream getPdfTranscript(String studentNo, String stdStatCode,  String collegeName, ByteArrayOutputStream	byos, InputStream	inputStream, ResourceResponse res, Locale locale) throws IOException
	{
		logger.info("stdStatCode : "+stdStatCode);
		logger.info("locale - language: "+locale.getLanguage());
		
//		Document				document				=	new	Document(PAGE_SIZE);
		
		
//		InputStream				inputStreamCourse		=	null;
//		Resource				resourceCourse			=	null;
		
		
		
		PdfReader				pdfTemplate				=	new PdfReader(inputStream);
		
		
		Student  				student				 	=	transcriptDbDao.getStudent(stdStatCode, locale);	
		//List<StudentStatus> statusList				=	transcriptDbDao.getStudentStatusList(studentNo, stdStatCode, collegeName);
		
				logger.info("student id : {}, student statcode : {}", student.getStudentId(), student.getStdStatCode());
				logger.info("student : "+student);
				
		try
		{
			
//				PdfWriter				pdfWriter				=	PdfWriter.getInstance(document, byos);
			
				PdfStamper		pdfStamper			=	new PdfStamper(pdfTemplate, byos );
				
				pdfStamper.getAcroFields().setField("txtFrmStudentId", student.getStudentId());
				pdfStamper.getAcroFields().setField("txtFrmDOB", student.getBirthDay());
				
				pdfStamper.getAcroFields().setField("txtFrmStudentName", student.getStudentName());
				pdfStamper.getAcroFields().setField("txtFrmGender", student.getGender());
				
				pdfStamper.getAcroFields().setField("txtCollege", student.getCollegeName());
				pdfStamper.getAcroFields().setField("txtFrmAdmissionCollege", student.getFirstCollege());
				
				pdfStamper.getAcroFields().setField("txtFrmMajor", student.getMajorName());
				pdfStamper.getAcroFields().setField("txtFrmFirstMajor", student.getFirstMajor());
				pdfStamper.getAcroFields().setField("txtFrmStream", "-");
				
				
				pdfStamper.getAcroFields().setField("txtDegreeName", student.getDegreeName());
				pdfStamper.getAcroFields().setField("txtAdvisor01", "-");
				pdfStamper.getAcroFields().setField("txtAdvisor02", "-");
				
				List<StudentStatus>	studentStatusList	=	transcriptDbDao.getStudentStatusList(studentNo, stdStatCode, collegeName);
				
				PdfPTable			tableSemester		=	new	PdfPTable(5);
				
				PdfPCell			cellBlankNoBorder	=	setTableCell( " ",Rectangle.NO_BORDER,setFont_01());
				//tableSemester.getDefaultCell().setPhrase(new Phrase("--", new Font(FontFamily.TIMES_ROMAN,8,Font.NORMAL)));
									//tableSemester.
//									tableSemester.setBreakPoints(0);
									tableSemester.setWidths(new int[]{4,8,5,4,8});

				for(StudentStatus stdStatus: studentStatusList)
				{

									/* Semester display*/
									tableSemester.addCell(setTableCell("SEMESTER :",Rectangle.NO_BORDER,setFont_02()));
									PdfPCell	cellStatusYrSem		=	setTableCell(stdStatus.getCourseYear() + " " + stdStatus.getSemesterName(),Rectangle.NO_BORDER,setFont_02());
												cellStatusYrSem.setColspan(4);
									tableSemester.addCell(cellStatusYrSem);
									tableSemester.completeRow();

									/* Major Display */
									if(null != stdStatus.getHistory() && !stdStatus.getHistory().trim().equals(""))
									{
										PdfPCell	cellStatusHistory	=	setTableCell(stdStatus.getHistory(),Rectangle.NO_BORDER,setFont_02());
												cellStatusHistory.setColspan(5);
										tableSemester.addCell(cellStatusHistory);
										tableSemester.completeRow();
									}

									/* Grades Display */
									List<GradeSemester> gradeSemesters	=	transcriptDbDao.getStudentGradeList(student.getStudentNo(), String.valueOf(stdStatus.getSemesterCode()), stdStatus.getCourseYear());
									
									for (GradeSemester grade: gradeSemesters)
									{
										tableSemester.addCell(setTableCell(grade.getCourseNo(),Rectangle.NO_BORDER,setFont_01()));
										tableSemester.addCell(setTableCell(grade.getCourseName(),Rectangle.NO_BORDER,setFont_01()));
										tableSemester.addCell(setTableCell(String.valueOf(grade.getCourseCredit()),Rectangle.NO_BORDER,setFont_01()));
										tableSemester.addCell(setTableCell(grade.getCourseCreditValue(),Rectangle.NO_BORDER,setFont_01()));
										tableSemester.addCell(setTableCell("",Rectangle.NO_BORDER,setFont_01()));
										tableSemester.completeRow();
									}									
									
									
									
									/* TODO another loop for courses and related information */
									tableSemester.addCell(setTableCell("CREDITS :",Rectangle.NO_BORDER,setFont_04()));
									
									tableSemester.addCell(
															setTableCell(
																			"TOTAL ATTEMPTED : "	+	stdStatus.getCreditTakenCummulative()
																			,	Rectangle.NO_BORDER
																			,	setFont_04()
																	)
														);	
									
									
									tableSemester.addCell(		
											setTableCell(
														"ATTEMPTED : 			"	+	stdStatus.getCreditTaken()
													,	Rectangle.NO_BORDER
													,	setFont_04()
											)
									);	
									
									tableSemester.addCell(		
											setTableCell(
														"EARNED : 			"	+	stdStatus.getCreditEarned()
													,	Rectangle.NO_BORDER
													,	setFont_04()
											)
									);
									
								
									
									
									tableSemester.addCell(		
																setTableCell(
																			"SEM GPA : 			"	+	stdStatus.getSemGPA()
																		+ 	" 	CUM GPA : 			"	+	stdStatus.getCumGPA()
																		,	Rectangle.NO_BORDER
																		,	setFont_04()
																)
														);	

									tableSemester.completeRow();
									
									
								/*Semester course load status*/
									tableSemester.addCell(setTableCell("SEMESTER COURSE LOAD STATUS :"+stdStatus.getLoadStatusSemester(),Rectangle.NO_BORDER,setFont_02())).setColspan(5);
									tableSemester.completeRow();
								/*student course load status*/									
									PdfPCell	cellStdLoadStatus = setTableCell("STUDENT COURSE LOAD STATUS :"+stdStatus.getLoadStatusStudent(),Rectangle.NO_BORDER,setFont_02());
												cellStdLoadStatus.setColspan(5);
												cellStdLoadStatus.setBorder(PdfPCell.BOTTOM);

									tableSemester.addCell(cellStdLoadStatus);
									
									logger.info("position for last row of semester : "+stdStatus.getCourseYear() + " " + stdStatus.getSemesterName() + " :bottom :: " 
											+cellStdLoadStatus.getBottom()
											+"vertical alignment "+cellStdLoadStatus.getVerticalAlignment()+ " height :: "+cellStdLoadStatus.getHeight());	
									
									
									tableSemester.completeRow();
									
				}
				
				PdfPCell	cellTotalCreditsAttemped = setTableCell("TOTAL CREDITS ATTEMPTED  :",Rectangle.NO_BORDER,setFont_04());
							cellTotalCreditsAttemped.setColspan(2);
							cellTotalCreditsAttemped.setBorder(PdfPCell.BOTTOM);
							tableSemester.addCell(cellTotalCreditsAttemped);
							
				PdfPCell	cellTotalCreditsEarned = setTableCell("TOTAL CREDITS EARNED  :",Rectangle.NO_BORDER,setFont_04());
							cellTotalCreditsEarned.setColspan(2);
							cellTotalCreditsEarned.setBorder(PdfPCell.BOTTOM);
							tableSemester.addCell(cellTotalCreditsEarned);
							
				PdfPCell	cellTotalGradePoints = setTableCell("TOTAL GRADE POINTS  :",Rectangle.NO_BORDER,setFont_04());
							cellTotalGradePoints.setColspan(2);
							cellTotalGradePoints.setBorder(PdfPCell.BOTTOM);
							tableSemester.addCell(cellTotalGradePoints);

				tableSemester.completeRow();
				
				
				cellBlankNoBorder.setColspan(5);
				tableSemester.addCell(cellBlankNoBorder);
				tableSemester.completeRow();
				
				
				PdfPCell	cellTextNoGradeEntry = setTableCell("NO GRADE ENTRIES BELOW THIS LINE",Rectangle.NO_BORDER,setFont_02());
							cellTextNoGradeEntry.setHorizontalAlignment(Element.ALIGN_CENTER);
				cellTextNoGradeEntry.setColspan(5);
				tableSemester.addCell(cellTextNoGradeEntry);

				cellBlankNoBorder.setColspan(5);
				cellBlankNoBorder.setBorder(PdfPCell.BOTTOM);
				tableSemester.addCell(cellBlankNoBorder);
				tableSemester.completeRow();
				
				tableSemester.completeRow();
				
				
/**** Student status ****/		
				cellBlankNoBorder.setColspan(5);
				cellBlankNoBorder.setBorder(Rectangle.NO_BORDER);
				tableSemester.addCell(cellBlankNoBorder);
				tableSemester.completeRow();
				
				PdfPCell	cellTextStudentStatus = setTableCell("STUDENT STATUS",Rectangle.NO_BORDER,setFont_04());
							cellTextStudentStatus.setColspan(2);
							tableSemester.addCell(cellTextStudentStatus);

				PdfPCell	cellStudentStatus = setTableCell(student.getStatusName(),Rectangle.NO_BORDER,setFont_02());
							cellStudentStatus.setColspan(3);
							tableSemester.addCell(cellStudentStatus);
				tableSemester.completeRow();
				

/***** End of Transcript ***/				

				cellBlankNoBorder.setColspan(5);
				cellBlankNoBorder.setRowspan(2);
				cellBlankNoBorder.setBorder(Rectangle.NO_BORDER);
				tableSemester.addCell(cellBlankNoBorder);
				tableSemester.completeRow();
				
				PdfPCell	cellTextEndOfTranscript = setTableCell("***** END OF TRANSCRIPT *****",Rectangle.NO_BORDER,setFont_04());
				cellTextEndOfTranscript.setHorizontalAlignment(Element.ALIGN_CENTER);
				cellTextEndOfTranscript.setColspan(5);
				tableSemester.addCell(cellTextEndOfTranscript);
				tableSemester.completeRow();
				
				cellBlankNoBorder.setColspan(5);
				cellBlankNoBorder.setBorder(Rectangle.NO_BORDER);
				tableSemester.addCell(cellBlankNoBorder);
				tableSemester.completeRow();

				
/******* KEY  ****/				
				PdfPCell	cellTextKeys = setTableCell(UtilProperty.getMessage("prop.transcript.key.text", null, locale),Rectangle.NO_BORDER,setFont_04());
							cellTextKeys.setColspan(5);
							tableSemester.addCell(cellTextKeys);
							tableSemester.completeRow();
				
				
				ColumnText	columnSemester		=	new ColumnText(pdfStamper.getOverContent(1));
				Rectangle	rectangleSemester	=	new Rectangle(0,35,600,505);
				//Rectangle	rectangleNewPage	=	new Rectangle(0,10,600,725);
				//Rectangle	rectangleNewPage	=	new Rectangle(0,35,600,650);
				Rectangle	rectangleNewPage	=	new Rectangle(0,35,600,675);
				columnSemester.setSimpleColumn(rectangleSemester);
				columnSemester.addElement(tableSemester);
				int status = columnSemester.go();
				int pagecount = 1;
				int linecount=1;
				while (ColumnText.hasMoreText(status)) {
			        status = triggerNewPage(pdfStamper, PAGE_SIZE, columnSemester, rectangleNewPage, ++pagecount);
			    }
				
				setHeader_01(pdfTemplate, pdfStamper, columnSemester, student);
				setFooter_01(pdfTemplate, pdfStamper);

				
				pdfStamper.getAcroFields().setGenerateAppearances(true);
				
				pdfStamper.setFormFlattening(true);
				pdfStamper.close();
				
		}
		catch(DocumentException exception)
		{
			logger.error("DocumentException. Details : {}",exception);
		}
		
		
		pdfTemplate.close();
		
/*		
							resourceCourse			=	new ClassPathResource(Constants.CONST_FILE_PDF_TEMPLATE_COURSE_EN);
							inputStreamCourse		=	resourceCourse.getInputStream();
		PdfReader			pdfTemplateCourse		=	new PdfReader(inputStreamCourse);
*/		
		
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
		return new Font(FontFamily.TIMES_ROMAN,8,Font.NORMAL);
	}

	private	Font setFont_02()
	{
		return new Font(FontFamily.HELVETICA,10,Font.BOLD);
	}
	private	Font setFont_03()
	{
		return new Font(FontFamily.HELVETICA,10,Font.NORMAL);
	}
	
	private	Font setFont_04()
	{
		return new Font(FontFamily.TIMES_ROMAN,8,Font.BOLD);
	}

	
	
	public int triggerNewPage(PdfStamper stamper, Rectangle pagesize, ColumnText column, Rectangle rect, int pagecount) throws DocumentException {
	    stamper.insertPage(pagecount, pagesize);
	    PdfContentByte canvas = stamper.getOverContent(pagecount);
	    column.setCanvas(canvas);
	    column.setSimpleColumn(rect);
	    return column.go();
	}

	private void setHeader_01( PdfReader reader,PdfStamper stamper, ColumnText column, Student student) throws DocumentException
	{
		
		Phrase header_01 = new Phrase("Sultan Qaboos University", new Font(FontFamily.HELVETICA, 12));
		Phrase header_02 = new Phrase("Deanship of Admissions and Registration", new Font(FontFamily.HELVETICA, 10));
		Phrase header_03 = new Phrase("Academic Transcript", new Font(FontFamily.HELVETICA, 10));
		Phrase header_04 = new Phrase("Name : "+student.getStudentName(), new Font(FontFamily.HELVETICA, 10));
		Phrase header_05 = new Phrase("Degree : "+student.getDegreeName(), new Font(FontFamily.HELVETICA, 10));
		
		for (int i = 2; i <= reader.getNumberOfPages(); i++) {
            float x = reader.getPageSize(i).getWidth() / 2;
            float y = reader.getPageSize(i).getTop(30);
            ColumnText.showTextAligned(	stamper.getOverContent(i), Element.ALIGN_CENTER, header_01, x, y, 0);
            ColumnText.showTextAligned(	stamper.getOverContent(i), Element.ALIGN_CENTER, header_02, x, y-15, 0);
            ColumnText.showTextAligned(	stamper.getOverContent(i), Element.ALIGN_CENTER, header_03, x, y-30, 0);
            //ColumnText.showTextAligned(	stamper.getOverContent(i), Element.ALIGN_LEFT, header_04, x, y-45, 0);
            
            PdfPTable			tableHeader_01		=	new	PdfPTable(6);
    		tableHeader_01.setWidths(new int[]{3,7,3,7,3,7});
    		Rectangle recHeaderSize_01 = new Rectangle(0,650,600,725);
    		
    		
    		
    		
    		
            
            PdfPTable			tableHeader_02		=	new	PdfPTable(5);
    		tableHeader_02.setWidths(new int[]{4,8,5,4,8});
    		//Rectangle recHeaderSize_02 = new Rectangle(0,650,600,700);
            
            PdfContentByte canvas = stamper.getOverContent(i);
            
            PdfPCell	hCell_01_01 = 	setTableCell( "Name : ", Rectangle.NO_BORDER,	setFont_02()) ; 
			hCell_01_01.setBorder(PdfPCell.BOTTOM);
			tableHeader_01.addCell(hCell_01_01);

            PdfPCell	hCell_01_02 = 	setTableCell(student.getStudentName(), Rectangle.NO_BORDER,	setFont_03()) ; 
			hCell_01_02.setBorder(PdfPCell.BOTTOM);
			tableHeader_01.addCell(hCell_01_02);
			
            PdfPCell	hCell_01_03 = 	setTableCell( "Id : ", Rectangle.NO_BORDER,	setFont_02()); 
			hCell_01_03.setBorder(PdfPCell.BOTTOM);
			tableHeader_01.addCell(hCell_01_03);

            PdfPCell	hCell_01_04 = 	setTableCell( student.getStudentId(), Rectangle.NO_BORDER,	setFont_03()); 
			hCell_01_04.setBorder(PdfPCell.BOTTOM);
			tableHeader_01.addCell(hCell_01_04);
			
            PdfPCell	hCell_01_05 = 	setTableCell( "Degree ", Rectangle.NO_BORDER,	setFont_02()); 
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
			//column.addElement(tableHeader_02);
			
			int status = column.go();

        }
		
		
		
	}
	
	private void setFooter_01( PdfReader reader,PdfStamper stamper)
	{
		Phrase footer_01 = new Phrase("Page No : ", new Font(FontFamily.HELVETICA, 8));

		
		for (int i = 1; i <= reader.getNumberOfPages(); i++) {
            float x = reader.getPageSize(i).getWidth() / 2;
            float y = reader.getPageSize(i).getBottom(20);
            ColumnText.showTextAligned(	
            									stamper.getOverContent(i)
            								, 	Element.ALIGN_CENTER
            								, 	new Phrase("Page No : "+i+"/"+reader.getNumberOfPages(), new Font(FontFamily.HELVETICA, 8))
            								, 	x
            								, 	y
            								, 	0
            						);

        }
	}
	
}
