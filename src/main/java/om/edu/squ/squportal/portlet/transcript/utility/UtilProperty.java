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
 * File Name			:	UtilProperty.java
 * Package Name			:	om.edu.squ.squportal.portlet.transcript.utility
 * Date of creation		:	Aug 16, 2015  2:35:31 PM
 * Date of modification :	
 * 
 * Summary				:	
 *
 *
 * Copyright 2015 the original author or authors and Organization.
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
package om.edu.squ.squportal.portlet.transcript.utility;

import java.util.Locale;



import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * @author Bhabesh
 *
 */
public class UtilProperty
{
	 private static ResourceBundleMessageSource resourceBundle;
	 private UtilProperty()
	 {

	 };
	 
	    public static String getMessage(String code, Object[] args, Locale locale) 
	    {        
	    	activateResource();
	    	return resourceBundle.getMessage(code, args, locale);
	    }
	    public static String getMessage(String code, Object[] args) 
	    {	
	    	activateResource();
		 	return resourceBundle.getMessage(code, args,Locale.ENGLISH);
	    }

	    private static void activateResource()
	    {
	    	resourceBundle = new ResourceBundleMessageSource();
		 	resourceBundle.setBasenames(new String[] {Constants.RESOURCE_PROPERTY_FILE_NAME});     

	    }
	    
}
