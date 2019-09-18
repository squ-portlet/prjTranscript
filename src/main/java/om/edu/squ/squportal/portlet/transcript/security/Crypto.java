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
 * File Name			:	Crypto.java
 * Package Name			:	om.edu.squ.squportal.portlet.transcript.security
 * Date of creation		:	Sep 18, 2019  2:50:04 PM
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
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import om.edu.squ.squportal.portlet.transcript.dao.bo.Student;

/**
 * @author Bhabesh
 *
 */
public interface Crypto
{
	public 	static 	final	int		CRYPTO_ITERATION_COUNT	=	5;
	public 	static 	final	int		CRYPTO_KEY_SIZE			=	128;
	public	static	final	String	CRYPTO_PASSCODE			=	"8639fbf762977d8c4f49ecb96b1e368e";
	public	static	final	String	CHAR_F_SLASH			=	"/";
	public	static	final	String	CHAR_REPLACE			=	"*";
	
	/**
	 * 
	 * method name  : encrypt
	 * @param saltEncoded
	 * @param ivEncoded
	 * @param plaintext
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchPaddingException
	 * @throws InvalidParameterSpecException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidAlgorithmParameterException
	 * Crypto
	 * return type  : String
	 * 
	 * purpose		:	encryption using default password provided with package
	 *
	 * Date    		:	Sep 18, 2019 2:51:26 PM
	 */
	public String encrypt(String saltEncoded, String ivEncoded, String plaintext) throws 	UnsupportedEncodingException
																						, 	InvalidKeyException
																						, 	NoSuchAlgorithmException
																						, 	InvalidKeySpecException
																						, 	NoSuchPaddingException
																						, 	InvalidParameterSpecException
																						, 	IllegalBlockSizeException
																						, 	BadPaddingException
																						, 	InvalidAlgorithmParameterException;
	 

	/**
	 * 
	 * method name  : encrypt
	 * @param salt
	 * @param iv
	 * @param passphrase
	 * @param plaintext
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 * @throws InvalidKeySpecException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws InvalidParameterSpecException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 * @throws InvalidAlgorithmParameterException
	 * Crypto
	 * return type  : String
	 * 
	 * purpose		: encryption with custom password
	 *
	 * Date    		:	Sep 18, 2019 2:54:32 PM
	 */
	 public String encrypt(String saltEncoded, String ivEncoded, String passphrase, String plaintext) throws NoSuchAlgorithmException
																						, UnsupportedEncodingException
																						, InvalidKeySpecException
																						, NoSuchPaddingException
																						, InvalidKeyException
																						, InvalidParameterSpecException
																						, IllegalBlockSizeException
																						, BadPaddingException
																						, InvalidAlgorithmParameterException;
	 
	 /**
	  * 
	  * method name  : decrypt
	  * @param saltEncoded
	  * @param ivEncoded
	  * @param ciphertext
	  * @return
	  * @throws InvalidKeyException
	  * @throws NoSuchAlgorithmException
	  * @throws NoSuchPaddingException
	  * @throws InvalidKeySpecException
	  * @throws InvalidAlgorithmParameterException
	  * @throws IllegalBlockSizeException
	  * @throws BadPaddingException
	  * @throws UnsupportedEncodingException
	  * Crypto
	  * return type  : String
	  * 
	  * purpose		: decryption with default password
	  *
	  * Date    		:	Sep 18, 2019 2:55:58 PM
	  */
	 public String decrypt(String saltEncoded, String ivEncoded, String ciphertext) throws InvalidKeyException
																						, NoSuchAlgorithmException
																						, NoSuchPaddingException
																						, InvalidKeySpecException
																						, InvalidAlgorithmParameterException
																						, IllegalBlockSizeException
																						, BadPaddingException
																						, UnsupportedEncodingException;
	 
	 /**
	  * 
	  * method name  : decrypt
	  * @param saltEncoded
	  * @param ivEncoded
	  * @param passphrase
	  * @param ciphertext
	  * @return
	  * @throws NoSuchAlgorithmException
	  * @throws NoSuchPaddingException
	  * @throws InvalidKeySpecException
	  * @throws InvalidKeyException
	  * @throws InvalidAlgorithmParameterException
	  * @throws IllegalBlockSizeException
	  * @throws BadPaddingException
	  * @throws UnsupportedEncodingException
	  * Crypto
	  * return type  : String
	  * 
	  * purpose		:	decryption with custom password
	  *
	  * Date    		:	Sep 18, 2019 3:00:30 PM
	  */
	 public String decrypt(String saltEncoded, String ivEncoded, String passphrase, String ciphertext) throws NoSuchAlgorithmException
																						, NoSuchPaddingException
																						, InvalidKeySpecException
																						, InvalidKeyException
																						, InvalidAlgorithmParameterException
																						, IllegalBlockSizeException
																						, BadPaddingException
																						, UnsupportedEncodingException;
	 
	 
	 /**
	  * 
	  * method name  : generateSalt
	  * @return
	  * Crypto
	  * return type  : String
	  * 
	  * purpose		: Generate Salt
	  *
	  * Date    		:	Sep 18, 2019 3:01:03 PM
	  */
	 public String generateSalt();
	 
	 /**
	  * 
	  * method name  : generateIV
	  * @return
	  * @throws NoSuchAlgorithmException
	  * @throws NoSuchPaddingException
	  * Crypto
	  * return type  : String
	  * 
	  * purpose		: Generate IV
	  *
	  * Date    		:	Sep 18, 2019 3:01:24 PM
	  */
	 public  String generateIV() throws NoSuchAlgorithmException
										, 	NoSuchPaddingException;
	 
	 /**
	  * 
	  * method name  : setCryptEncode
	  * @param studentNormal
	  * @return
	  * Crypto
	  * return type  : Student
	  * 
	  * purpose		: set salt, iv and encrypted text 
	  *                 in object. Idea is to pass this object to client
	  *                 as per requirement.
	  *
	  * Date    		:	Sep 18, 2019 3:11:22 PM
	  */
	 public Student setCryptEncode(Student studentNormal); 
	 
}
