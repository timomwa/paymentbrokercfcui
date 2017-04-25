package ug.or.nda.beans;

import java.io.IOException;
import java.util.Properties;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;


public class LocalEncryptor {

	private static Logger logger = Logger.getLogger(LocalEncryptor.class);
	private static String key;
	private static String initVector;
	private static Properties props = new Properties();

	public static String encrypt(String value) {
		try {
			key = loadProperty(key,"enckey");
			initVector = loadProperty(initVector,"encInitVector");
			
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

			byte[] encrypted = cipher.doFinal(value.getBytes());
			//System.out.println("encrypted string: " + Base64.encodeBase64String(encrypted));

			return Base64.encodeBase64String(encrypted);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}

		return null;
	}

	private static String loadProperty(String field, String key) {
		if(field!=null)
			return field;
		try {
			props.load( LocalEncryptor.class.getResourceAsStream("/app.properties") );
		} catch (IOException ex) {
			logger.error(ex.getMessage(), ex);
		}
		field = props.getProperty(key);
		//System.out.println( key+" - > "+field);
		return field;
	}

	public static String decrypt(String encrypted) {
		try {
			key = loadProperty(key,"enckey");
			initVector = loadProperty(initVector,"encInitVector");
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

			byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

			return new String(original);
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}

		return null;
	}

}
