import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author song
 * MD 32  16
 */
public class MD5 {

    public static final String CHARSET = "UTF-8";

    public static String code16(String input){
        return code32(input).substring(8, 24);
    }

    public static String code16(String input,String charset){
        return code32(input,charset).substring(8, 24);
    }

    public static String code32(String input){
        return code32(input,CHARSET);
    }
    public static String code32ToLowerCase(String input){
        return code32(input).toLowerCase();
    }

    /**
     * 计算MD5 大写
     * @param input
     * @return
     */
    public static String code32(String input,String charset) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes(charset));
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            // Now we need to zero pad it if you actually want the full 32 chars.
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext.toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /*public static void main(String[] args) {
        System.out.println(code32("11"));
    }*/

}
