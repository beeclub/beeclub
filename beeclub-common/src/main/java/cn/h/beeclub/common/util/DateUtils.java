package cn.h.beeclub.common.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

	
	public static String currentDateFormat() {
		return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS").format(LocalDateTime.now());
	}
	
	public static void main(String[] args) {
		for(int i = 0 ;i < 1000; i++) {
			System.out.println(currentDateFormat());
		}
	}
}
