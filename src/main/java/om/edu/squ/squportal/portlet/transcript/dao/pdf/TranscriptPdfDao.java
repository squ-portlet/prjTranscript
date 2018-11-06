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
 * File Name			:	TranscriptPdfDao.java
 * Package Name			:	om.edu.squ.squportal.portlet.transcript.dao.pdf
 * Date of creation		:	Aug 7, 2018  12:00:36 PM
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
import java.util.Locale;

import javax.portlet.ResourceResponse;

import com.itextpdf.text.DocumentException;

/**
 * @author Bhabesh
 *
 */
public interface TranscriptPdfDao
{
	/**
	 * 
	 * method name  : getPdfTranscript
	 * @param studentNo TODO
	 * @param stdStatCode TODO
	 * @param collegeName TODO
	 * @param byos
	 * @param inputStream
	 * @param res
	 * @param locale TODO
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 * TranscriptPdfDao
	 * return type  : OutputStream
	 * 
	 * purpose		: Generation of transcript in pdf format
	 *
	 * Date    		:	Aug 7, 2018 12:01:49 PM
	 */
	public OutputStream getPdfTranscript(String studentNo, String stdStatCode,  String collegeName, ByteArrayOutputStream	byos, InputStream	inputStream, ResourceResponse res, Locale locale) throws IOException, DocumentException;
}
