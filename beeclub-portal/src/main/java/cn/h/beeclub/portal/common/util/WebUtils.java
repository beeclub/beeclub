package cn.h.beeclub.portal.common.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebUtils {

	public static void writeJson2Response(String json, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(json);
		} catch (IOException e) {
			log.info("{}",e.getMessage());
		}finally {
			if(out != null) {
				out.close();
			}
		}
	}
}
