import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;


public class DesEncrypt {


	private static String message = null;
	private static String mac = "DES/CBC/PKCS5Padding";
	private static String key = "1qaz@WSX";

	public static void main(String[] args) {
		//test1();
		if(args.length==1||(args.length==2&&"0".equals(args[1]))){
			message = args[0];
			System.out.println(DesEncrypt.encrypt(message,mac,key));
			return;
		}
		if(args.length==2&&"1".equals(args[1])){
			System.out.println(DesEncrypt.decrypt(args[0],mac,key));
			return;
		}
		System.out.println("Error: Please set the encryption for content ");
		System.out.println("Example: java -jar des-encrypt.jar <content> <1| 0> ");
	}

	public static void test1() {

		String message = "unionlive";
		String mac = "DES/CBC/PKCS5Padding";
		String key = "1qaz@WSX";

		String r = encrypt(message,mac,key);

		//g78SoLqsM8Y=
		//g78SoLqsM8bqcNqs8mHWcg==
		System.out.println(r);

		//R9oOp4Sc25yv8S4cTSoZuA==
		r = decrypt(r,mac,key);
		System.out.println(r);
	}


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
			byte[] retByte = decrypt(hexString2Bytes(message),padding,key);
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
			return bytes2HexString(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	private final static byte[] hex = "0123456789ABCDEF".getBytes();

	private static int parse(char c) {
		if (c >= 'a')
			return (c - 'a' + 10) & 0x0f;
		if (c >= 'A')
			return (c - 'A' + 10) & 0x0f;
		return (c - '0') & 0x0f;
	}

	// 从字节数组到十六进制字符串转换
	public static String bytes2HexString(byte[] b) {
		byte[] buff = new byte[2 * b.length];
		for (int i = 0; i < b.length; i++) {
			buff[2 * i] = hex[(b[i] >> 4) & 0x0f];
			buff[2 * i + 1] = hex[b[i] & 0x0f];
		}
		return new String(buff);
	}

	// 从十六进制字符串到字节数组转换
	public static byte[] hexString2Bytes(String hexstr) {
		byte[] b = new byte[hexstr.length() / 2];
		int j = 0;
		for (int i = 0; i < b.length; i++) {
			char c0 = hexstr.charAt(j++);
			char c1 = hexstr.charAt(j++);
			b[i] = (byte) ((parse(c0) << 4) | parse(c1));
		}
		return b;
	}



	
}