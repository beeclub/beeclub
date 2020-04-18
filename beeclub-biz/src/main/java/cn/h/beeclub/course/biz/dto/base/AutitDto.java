package cn.h.beeclub.course.biz.dto.base;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 
 * @description 
 * @author hao.huang
 * @date 2019年9月20日
 */
@Data
public class AutitDto<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4625842101718380595L;
	private String _id;
	private String auditType;// 审核类型
	private String submitUserName;// 提交人姓名
	private String submitUserId; // 提交人
	private String auditUserName; //
	private String auditUserId; //
	private Date submitDate; //
	private Date auditData; //
	private String result; //
	private String reason; //
	
	private String tilte;
	private String description;
	
	private T data;

}
