package org.wjlmgqs.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
/**
 * @author WJL
 * @date 2014-1-22
 * @email wjl@zving.com
 */
public class WebLogger {

	private static Logger logger = Logger.getLogger(WebLogger.class.getName());
	static{
		try {
			FileHandler fileHandler = new FileHandler("D:\\log_"+System.currentTimeMillis()+".log");
			final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			fileHandler.setFormatter(new Formatter() {
				@Override
				public String format(LogRecord arg0) {
					return String.format("%-8s",arg0.getLevel().getLocalizedName())+sdf.format(new Date(arg0.getMillis()) )+"  : "+ arg0.getMessage()+"\n";
				}
			});
			logger.addHandler(fileHandler);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void showWarning(String message){
		logger.log(Level.WARNING, message);
	}
	public static void showInfo(String message){
		logger.info(message);
	}
	public static void main(String[] args) {
		WebLogger.showInfo("Hello World");
	}
}
