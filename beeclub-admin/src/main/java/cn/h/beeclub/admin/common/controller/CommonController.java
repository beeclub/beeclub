package cn.h.beeclub.admin.common.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.io.ByteStreams;

import cn.h.beeclub.common.base.result.SimpleResult;
import cn.h.beeclub.common.util.OSSClientUtil;
import cn.h.beeclub.common.util.OSSUtils;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;

@RestController
@RequestMapping("/api/v1")
public class CommonController {
	
	public static final String FILE_PATH = "/course/file/";

	@Autowired
	private OSSClientUtil ossClientUtil;
	/**
	 * 
	 * @description 
	 * @param file
	 * @return
	 * @throws IOException 
	 */
	@PostMapping("/upload/{type}")
	public SimpleResult<String> upload(MultipartFile file, @PathVariable("type") String type) throws IOException{
		
//		File fileFold = new File(FILE_PATH);
//		if(!fileFold.exists()) {
//			fileFold.mkdirs();
//		}
//		String fileName = file.getOriginalFilename();
//		String path = type + "/" + UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
//		return SimpleResult.ok(OSSUtils.upload(new ByteArrayInputStream(ByteStreams.toByteArray(file.getInputStream())), path));
		
		String imageUrl = ossClientUtil.checkImage(file);
		return SimpleResult.ok(imageUrl);
	}
	

	
	
	public static void main(String[] args) {
		String s = "https://cdn.lctest.cn/xcrm/dev/0c7994c7-2ac2-4466-9182-2700881e1114.jpg";
		String suffix = s.substring(s.lastIndexOf("."));System.out.println(suffix);
	}
}
