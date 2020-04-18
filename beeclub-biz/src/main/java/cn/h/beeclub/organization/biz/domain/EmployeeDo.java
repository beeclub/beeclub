package cn.h.beeclub.organization.biz.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import cn.h.beeclub.common.base.domain.Domain.BaseAuthEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 
 * @description 
 * @author hao.huang
 * @date 2019年11月29日
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "t_employee")
public class EmployeeDo extends BaseAuthEntity{

	/**
	 * 
	 */
	@TableId
	private Long id;
	private String empCode;
	private String name;
	
}
