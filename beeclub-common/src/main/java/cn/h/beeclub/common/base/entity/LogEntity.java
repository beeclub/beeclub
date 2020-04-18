package cn.h.beeclub.common.base.entity;

import java.util.Date;

import cn.h.beeclub.common.base.domain.Domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class LogEntity extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4447252947491698593L;
	private String optMethod;
	private String moduleName;
	private String operator;
	private String param;
	private Date insertTime; 
}
