package cn.h.beeclub.common.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;

public class OSSUtils {

	public static final String endpoint = "http://oss-cn-shanghai.aliyuncs.com";
	// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录
	// https://ram.console.aliyun.com 创建RAM账号。
	public static final String accessKeyId = "***";
	public static final String accessKeySecret = "***";
	public static final String bucketName = "beeclub";

	public static String upload(ByteArrayInputStream arrayInputStream, String path) {
		// Endpoint以杭州为例，其它Region请按实际情况填写。

		// 创建OSSClient实例。
		OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
		// 创建PutObjectRequest对象。
		String content = "Hello OSS";
		// <yourObjectName>表示上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(content.getBytes());
		PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, path,
				byteArrayInputStream);

		// 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
		// ObjectMetadata metadata = new ObjectMetadata();
		// metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS,
		// StorageClass.Standard.toString());
		// metadata.setObjectAcl(CannedAccessControlList.Private);
		// putObjectRequest.setMetadata(metadata);

		// 上传字符串。
		PutObjectResult putObject = ossClient.putObject(putObjectRequest);
		
		//path
		Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
		URL url = ossClient.generatePresignedUrl(bucketName, path, expiration);
		
		// 关闭OSSClient。
		ossClient.shutdown();
		try {
			byteArrayInputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "https://beeclub.oss-cn-shanghai.aliyuncs.com" + url.getPath();
	}
	public static void main(String[] args) throws Throwable {
	}

}
