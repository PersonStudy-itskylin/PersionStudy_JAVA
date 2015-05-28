package cn.hglq4.eshop.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

	public DateHelper() {
		// TODO Auto-generated constructor stub
	}

	public static String format(String pattern) {
		SimpleDateFormat sf=new SimpleDateFormat(pattern);
		return sf.format(new Date(System.currentTimeMillis()));
	}

}
