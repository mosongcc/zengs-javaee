package com.unionlive.util.encrypt;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @Author Pine
 * @Date  2015-12-12
 * @Version 1.0
 * 
 *          对字符串进行 encode 与 decode 编码 <br/>
 *          应用在URL地址特殊符号与中文处理转换等操作
 */
public class URLCoderUtil {

	private static final String CHARSET = "utf-8";

	/**
	 * 编码 注意字符集 UTF-8
	 * @param val 待编码字符串
	 * @return
	 */
	public static String encode(String val) {
		return encode(val,CHARSET);
	}

	public static String encode(String val, String charset) {
		try {
			return val==null||val.trim().length()<=0?val: URLEncoder.encode(val, charset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 解码 注意字符集 UTF-8
	 * @param val  待解码字符串
	 * @return
	 */
	public static String decode(String val) {
		return decode(val, CHARSET);
	}

	public static String decode(String val, String charset) {
		try {
			return val==null||val.trim().length()<=0?val: URLDecoder.decode(val, charset);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*public static void main(String[] args) {
		//String val = URLEncoderUtil.encode("http://weixin.gold24.cn/GoldWeChatWeb/memberLogin.action");
		//String val = URLEncoderUtil.encode("http://pay1.gold24.cn/gold_serviceweb/wechat/index");
		String val = URLEncoderUtil.encode("http://pay1.gold24.cn/goldweb/");
		String val1 = URLEncoderUtil.decode(val);
		System.out.println(val);
		System.out.println(val1);
		
	}*/

}
