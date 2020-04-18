package cn.h.beeclub.common.base.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class MetadataEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1071475187129779846L;
	private long organizationId;//机构ID
	private long departmentId;//部门ID
	private long employeeId;
	private int version;
	private int state = 1;
	private long creator;
	private Date createTime;
	private Date modifyTime;
	private long modifier;
	private boolean synchState;
}
