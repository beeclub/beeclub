package cn.h.beeclub.common.base.dto;

import lombok.Data;

/**
 * 
 * @description 
 * @author hao.huang
 * @date 2019年11月28日
 */
@Data
public class OperationContext {
	private long organizationId;//机构ID
	private long departmentId;//组织ID
	private long employeeId;
	private long operator;
}
