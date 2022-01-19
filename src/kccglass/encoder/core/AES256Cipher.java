package kccglass.encoder.core;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.springframework.util.StringUtils;

public class AES256Cipher {

	 private static volatile AES256Cipher INSTANCE;

	 final static String secretKey   = "12345678901234567890123456789012"; //32bit
	 static String IV = ""; //16bit

//	 public static AES256Cipher getInstance(){
//	     if(INSTANCE==null){
//	         synchronized(AES256Cipher.class){
//	             if(INSTANCE==null)
//	                 INSTANCE=new AES256Cipher();
//	         }
//	     }
//	     return INSTANCE;
//	 }

	 static {
		 IV = secretKey.substring(0,16);
	 }

//	 private AES256Cipher(){
//	     IV = secretKey.substring(0,16);
//	 }


	 //암호화
	 public static String AES_Encode(String str) throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException
	 		, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{

		 if ( StringUtils.isEmpty( str )) {
				 throw new RuntimeException ("암호화 할 값이 없습니다.");
		 }

		 String enStr = "";
		 byte[] keyData = secretKey.getBytes();

		 try {
			 SecretKey secureKey = new SecretKeySpec(keyData, "AES");

			 Cipher c = Cipher.getInstance("AES/CBC/PKCS5Padding");
			 c.init(Cipher.ENCRYPT_MODE, secureKey, new IvParameterSpec(IV.getBytes()));

			 byte[] encrypted = c.doFinal(str.getBytes("UTF-8"));
			 enStr = new String(Base64.encodeBase64(encrypted));

		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 return enStr;
	 }


	 //복호화
	 public static String AES_Decode(String str) throws java.io.UnsupportedEncodingException, NoSuchPaddingException
	 		, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{

		 if ( StringUtils.isEmpty( str )) {
				 throw new RuntimeException ("복호화 할 값이 없습니다.");
		 }

		 String deStr= "";
		 byte[] keyData = secretKey.getBytes();

		 try {
			   SecretKey secureKey = new SecretKeySpec(keyData, "AES");
			   Cipher c = null;

				c = Cipher.getInstance("AES/CBC/PKCS5Padding");
		    	c.init(Cipher.DECRYPT_MODE, secureKey, new IvParameterSpec(IV.getBytes("UTF-8")));

				byte[] byteStr = Base64.decodeBase64(str.getBytes());

				deStr =  new String(c.doFinal(byteStr),"UTF-8");

			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		  return deStr;
	 }

}