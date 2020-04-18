package cn.h.beeclub.common.util;

public class ValidateUtils {

	
	public static boolean isEmail(String email) {
		if(email == null || email.length() == 0) {
			return false;
		}
		return email.matches("^[a-z0-9A-Z]+[- | a-z0-9A-Z . _]+@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-z]{2,}$");
	}
	
	public static void main(String[] args) {
		System.out.println(ValidateUtils.isEmail("2323@qq.com"));
	}
}
