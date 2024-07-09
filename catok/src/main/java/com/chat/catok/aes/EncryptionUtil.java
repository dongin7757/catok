package com.chat.catok.aes;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionUtil{

	private static final String ALGORITHM= "AES";
	private static final byte[] KEY = "comchatcatok1234".getBytes();
	
	public static String encode(String value) throws Exception {
		
		SecretKeySpec keySpec = new SecretKeySpec(KEY, ALGORITHM);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		
		cipher.init(Cipher.ENCRYPT_MODE, keySpec);
		byte[] encrypted = cipher.doFinal(value.getBytes());
		return Base64.getEncoder().encodeToString(encrypted);
	}
	
	public static String decode(String value) throws Exception {
		
		SecretKeySpec keySpec = new SecretKeySpec(KEY, ALGORITHM);
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		
		cipher.init(Cipher.DECRYPT_MODE, keySpec);
		byte[] original = cipher.doFinal(Base64.getDecoder().decode(value)); 
		
		return new String(original);
	}
	
	
}
