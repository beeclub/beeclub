package cn.h.beeclub.portal.common.util;

import java.util.HashMap;
import java.util.Map;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenUtils {
	
	/**
	 * pc token前缀
	 */
	public static final String PC_TOKEN_PRE = "pc_token_pre_";
	public static final String APP_TOKEN_PRE = "app_token_pre_";
	public static final String H5_TOKEN_PRE = "h5_token_pre_";
	public static final String TOKEN_SECRET = SecureUtil.md5("beeclub_web_scret");
	
	public static String generateToken(String email, Map<String,Object> claims) {
		;
		return Jwts.builder().claim("email", email).
				signWith(SignatureAlgorithm.HS256, TOKEN_SECRET.getBytes())
//				.addClaims(claims)
				.compact();
	}
	
	public static boolean verify(String token) {
		return Jwts.parser().isSigned(token);
	}
	
	@SuppressWarnings("unchecked")
	public static String getUsernameFromToken(String token) {
		Map<String,Object> body = (Map<String, Object>) parse(token);
		return (String) body.get("email");
	}
	
	public static Object parse(String token){
		return Jwts.parser().setSigningKey(TOKEN_SECRET.getBytes()).parse(token).getBody();
	}
	
	
	public static void main(String[] args) {
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("test", "Test1");
		claims.put("test2", "Test3");
		claims.put("test4", "Test5");
		claims.put("test6", "Test6");
		claims.put("test7", "Test7");
//		String str = generateToken("1570356753@qq.com", "123", claims);
//		System.out.println(str);
//		System.out.println(verify(str));
//		parse(str, "123");
	}
}
