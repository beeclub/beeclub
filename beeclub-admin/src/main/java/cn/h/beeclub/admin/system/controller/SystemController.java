package cn.h.beeclub.admin.system.controller;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.h.beeclub.common.base.result.SimpleResult;

@RestController
@RequestMapping("/system")
public class SystemController {

	@Value("${server.domain}")
	private String domain;
	@Value("${server.port}")
	private int port;

	@GetMapping("/dbMonitor")
	public SimpleResult<String> dbMonitor(){
		return SimpleResult.ok(String.format("https://%s:%d/druid", domain, port));
	}

	public static void main(String[] args) throws UnknownHostException {
		InetAddress ip = InetAddress.getLocalHost();
		byte[] address = ip.getAddress();
		
		for (byte a : address) {
			int b = (a < 0) ? (a + 256) : a;
			System.out.println("常规方法" + b + ".");
		}
//		 InetAddress.get
	}
}
