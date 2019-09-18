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
 * File Name			:	CryptoAES.java
 * Package Name			:	om.edu.squ.squportal.portlet.transcript.security
 * Date of creation		:	Sep 18, 2019  2:47:01 PM
 * Date of modification :	
 * 
 * Summary				:	
 *
 *
 * Copyright 2019 the original author or authors and Organization.
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
package om.edu.squ.squportal.portlet.transcript.security;



import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import om.edu.squ.squportal.portlet.transcript.dao.bo.Student;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Bhabesh
 *
 */
public class CryptoAES implements Crypto
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static byte[] 	saltByte	=	null;
	private static byte[] 	ivBytes		=	null;
	private static int 		saltlength 	= 	CRYPTO_KEY_SIZE / 8;
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.transcript.security.Crypto#encrypt(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String encrypt(String saltEncoded, String ivEncoded, String plaintext)
																					throws 	UnsupportedEncodingException
																					, 		InvalidKeyException
																					,		NoSuchAlgorithmException
																					, 		InvalidKeySpecException
																					,		NoSuchPaddingException
																					, 		InvalidParameterSpecException
																					,		IllegalBlockSizeException
																					, 		BadPaddingException
																					,		InvalidAlgorithmParameterException
	{
		return encrypt(saltEncoded, ivEncoded, CRYPTO_PASSCODE, plaintext);
	}
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.transcript.security.Crypto#encrypt(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String encrypt(String saltEncoded, String ivEncoded, String passphrase,String plaintext) 
																					throws NoSuchAlgorithmException
																					,		UnsupportedEncodingException
																					, 		InvalidKeySpecException
																					,		NoSuchPaddingException
																					, 		InvalidKeyException
																					,		InvalidParameterSpecException
																					, 		IllegalBlockSizeException
																					,		BadPaddingException
																					, 		InvalidAlgorithmParameterException
	{
		byte[] 	encryptedTextBytes	=	null;
		String	encodedText			=	null;
		saltByte					=	Base64.decodeBase64(saltEncoded);
		ivBytes						=	Base64.decodeBase64(ivEncoded);
		
		
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		
		PBEKeySpec spec = new PBEKeySpec(
				passphrase.toCharArray(), 
	            saltByte, 
	            CRYPTO_ITERATION_COUNT, 
	            CRYPTO_KEY_SIZE
	            );
		
		SecretKey 		secretKey 	= 	factory.generateSecret(spec);
		SecretKeySpec 	secret 		= 	new SecretKeySpec(secretKey.getEncoded(), "AES");
		
		IvParameterSpec ivParams 	= 	new IvParameterSpec(ivBytes);
		
	    //encrypt the message
	    Cipher cipher 		= Cipher.getInstance("AES/CBC/PKCS5Padding");
	    cipher.init(Cipher.ENCRYPT_MODE, secret, ivParams);
	    

	    encryptedTextBytes	=	 	cipher.doFinal(plaintext.getBytes("UTF-8"));
	    encodedText			=		Base64.encodeBase64String(encryptedTextBytes);
		
		
		return encodedText;
	}
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.transcript.security.Crypto#decrypt(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public String decrypt(String saltEncoded, String ivEncoded, String ciphertext) 
																					throws 		InvalidKeyException
																							,	NoSuchAlgorithmException
																							, 	NoSuchPaddingException
																							,	InvalidKeySpecException
																							, 	InvalidAlgorithmParameterException
																							,	IllegalBlockSizeException
																							, 	BadPaddingException
																							,	UnsupportedEncodingException
	{
		return decrypt(saltEncoded, ivEncoded, CRYPTO_PASSCODE, ciphertext);
	}
	
	@Override
	public String decrypt(String saltEncoded, String ivEncoded,String passphrase, String ciphertext)
																					throws 			NoSuchAlgorithmException
																								, 	NoSuchPaddingException
																								,	InvalidKeySpecException
																								, 	InvalidKeyException
																								,	InvalidAlgorithmParameterException
																								, 	IllegalBlockSizeException
																								,	BadPaddingException
																								, 	UnsupportedEncodingException
	{
		String	salt		=	findUrlSeperator(saltEncoded, CHAR_REPLACE) ? saltEncoded.replaceAll("["+CHAR_REPLACE+"]",CHAR_F_SLASH) : saltEncoded; 	
		String	iv			=	findUrlSeperator(ivEncoded, CHAR_REPLACE) ? ivEncoded.replaceAll("["+CHAR_REPLACE+"]",CHAR_F_SLASH) : ivEncoded;
		String	encryptText	=	findUrlSeperator(ciphertext, CHAR_REPLACE) ? ciphertext.replaceAll("["+CHAR_REPLACE+"]",CHAR_F_SLASH) : ciphertext;
		
		saltByte					=	Base64.decodeBase64(salt);
		ivBytes						=	Base64.decodeBase64(iv);
		byte[]	decodeCipher		=	Base64.decodeBase64(encryptText);
		
		byte[]	deCryptedTextBytes	=	null;
		
		SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		PBEKeySpec spec = new PBEKeySpec(
				passphrase.toCharArray(), 
	            saltByte, 
	            CRYPTO_ITERATION_COUNT, 
	            CRYPTO_KEY_SIZE
	            );
		
		SecretKey 		secretKey 	= 	factory.generateSecret(spec);
		SecretKeySpec 	secret 		= 	new SecretKeySpec(secretKey.getEncoded(), "AES");
		
		IvParameterSpec ivParams 	= 	new IvParameterSpec(ivBytes);
		
		Cipher cipher 		= Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, secret, ivParams);
		
		deCryptedTextBytes	=	cipher.doFinal(decodeCipher);
		
		return new String(deCryptedTextBytes, "UTF-8");
	}
	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.transcript.security.Crypto#generateSalt()
	 */
	@Override
	public String generateSalt()
	{
	    SecureRandom	random 	= new SecureRandom(); //SecureRandom.getInstance("SHA1PRNG");
	    byte 			saltByte[] = new byte[saltlength];
	    				random.nextBytes(saltByte);
	    return Base64.encodeBase64String(saltByte);
	}

	
	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.transcript.security.Crypto#generateIV()
	 */
	@Override
	public String generateIV() 				throws 			NoSuchAlgorithmException
														,	NoSuchPaddingException
	{
		SecureRandom 	randomSecureRandom 	= 	 new SecureRandom(); //SecureRandom.getInstance("SHA1PRNG");
		Cipher 			cipher 				= 	Cipher.getInstance("AES/CBC/PKCS5Padding");
		byte[] 			ivByte				= 	new byte[cipher.getBlockSize()];
		
		randomSecureRandom.nextBytes(ivByte);
		return Base64.encodeBase64String(ivByte);
	}

	
	
	
	
	
	/**
	 * 
	 * method name  : findUrlSeperator
	 * @param sourceString
	 * @param findChar
	 * @return
	 * CryptoAES
	 * return type  : boolean
	 * 
	 * purpose		:find particular character available at source string.
	 * 				  In Base64 table 63th character is '/'
	 *                This function basically a safeguard to find some character like '/'
	 *                which consider separator in url and some other application.
	 *                Purpose it to replace to some other character if this function returns true.
	 *
	 * Date    		:	Sep 18, 2019 3:26:18 PM
	 */
	private	boolean findUrlSeperator(String sourceString, String findChar)
	{
		if(sourceString.indexOf(findChar.charAt(0))==-1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see om.edu.squ.squportal.portlet.transcript.security.Crypto#setCryptEncode(om.edu.squ.squportal.portlet.transcript.dao.bo.Student)
	 */
	@Override
	public Student setCryptEncode(Student studentNormal) 
	{
		Student student	=	new Student();
		try
		{
			String	salt		=	generateSalt();
			String	iv			=	generateIV();
			student.setSalt(getModidyForExChar(salt));
			student.setIv(getModidyForExChar(iv));
			
			student.setStudentId(studentNormal.getStudentId());
			student.setStudentNo(getModidyForExChar(encrypt(salt, iv, studentNormal.getStudentNo())));
			student.setStudentName(studentNormal.getStudentName());
			student.setStdStatCode(getModidyForExChar(encrypt(salt, iv, studentNormal.getStdStatCode())));
			student.setGender(studentNormal.getGender());
			student.setBirthDay(studentNormal.getBirthDay());
			student.setCohort(studentNormal.getCohort());
			student.setCollegeCode(studentNormal.getCollegeCode());
			student.setCollegeName(studentNormal.getCollegeName());
			student.setMajorCode(studentNormal.getMajorCode());
			student.setMajorName(studentNormal.getMajorName());
			student.setMinorCode(studentNormal.getMinorCode());
			student.setMinorName(studentNormal.getMinorName());
			student.setSpecCode(studentNormal.getSpecCode());
			student.setSpecName(studentNormal.getSpecName());
			student.setDegreeNumber(studentNormal.getDegreeNumber());
			student.setDegreeName(studentNormal.getDegreeName());
			student.setEmpNumberAdvisor(studentNormal.getEmpNumberAdvisor());
			student.setEmpNumberAdvisor2(studentNormal.getEmpNumberAdvisor2());
			student.setEmpNameAdvisor(studentNormal.getEmpNameAdvisor());
			student.setEmpNameAdvisor2(studentNormal.getEmpNameAdvisor2());
			student.setlAbrStatus(studentNormal.getlAbrStatus());
			
		}
		catch(Exception ex)
		{
			logger.error("Encryption in encoding. Details : {} ",ex.getMessage());
		}
		
		return student;
	}
	
	
	/**
	 * 
	 * method name  : getModidyForExChar
	 * @param strEnc
	 * @return
	 * CryptoAES
	 * return type  : String
	 * 
	 * purpose		:
	 *
	 * Date    		:	Sep 18, 2019 4:33:47 PM
	 */
	private String getModidyForExChar(String strEnc)
	{
		return findUrlSeperator(strEnc, CHAR_F_SLASH) ? strEnc.replaceAll(CHAR_F_SLASH, CHAR_REPLACE) : strEnc; 
	}
	
}
