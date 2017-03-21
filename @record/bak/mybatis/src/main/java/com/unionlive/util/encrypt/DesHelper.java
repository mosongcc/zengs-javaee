package com.unionlive.util.encrypt;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;


public class DesHelper {


	private static Cipher getCipher(int mode,String padding,String key,String charset) throws Exception {
		Cipher cipher = Cipher.getInstance(padding);
		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes(charset));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes(charset));
		cipher.init(mode, secretKey,iv);
		return cipher;
	}

	/**
	 * DES解密
	 * @param message 密文
	 * @param key 密钥
	 * @return
	 */
	public static byte[] decrypt(byte[] message,String padding, String key) throws Exception {
		return getCipher(Cipher.DECRYPT_MODE,padding,key,"UTF-8").doFinal(message);
	}
	public static String decrypt(String message,String padding, String key){
		try {
			byte[] retByte = decrypt(Base64.getDecoder().decode(message),padding,key);
			return new String(retByte,"UTF-8");
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	/**
	 * DES加密
	 * @param message 要加密的数据
	 * @param padding       DES/CBC/PKCS5Padding
	 * @param key 密钥
	 * @return
	 */
	public static byte[] encrypt(byte[] message,String padding, String key) throws Exception{
		return getCipher(Cipher.ENCRYPT_MODE,padding,key,"UTF-8").doFinal(message);
	}
	public static String encrypt(String message,String mac, String key){
		try {
			byte[] bytes= encrypt(message.getBytes("UTF-8"),mac,key);
			return Base64.getEncoder().encodeToString(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*public static void main(String[] args) {

		String message = "unionlive";
		String mac = "DES/CBC/PKCS5Padding";
		String key = "12345678";

		String r = encrypt(message,mac,key);//encryptBase64(message,mac,key);

		//g78SoLqsM8Y=
		//g78SoLqsM8bqcNqs8mHWcg==
		System.out.println(r);

		//R9oOp4Sc25yv8S4cTSoZuA==
		r = "R9oOp4Sc25yv8S4cTSoZuA==";
		r = decrypt(r,mac,key);
		System.out.println(r);
	}*/
	
}