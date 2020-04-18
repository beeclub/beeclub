package cn.h.beeclub.common.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class WebUtils {

	
	public static String getLocalAddress() {
		InetAddress ip;
		try {
			ip = InetAddress.getLocalHost();
			byte[] address = ip.getAddress();
			StringBuilder sb = new StringBuilder();
			for (byte a : address) {
				int b = (a < 0) ? (a + 256) : a;
				sb.append(b).append(".");
				System.out.println("常规方法" + b + ".");
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "127.0.0.1";
	}
}
