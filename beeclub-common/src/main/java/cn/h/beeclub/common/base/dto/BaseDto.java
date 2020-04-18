package cn.h.beeclub.common.base.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class BaseDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2390770967688587605L;
	private boolean available;
	private long creator;
	private Date createTime;
	private Date modifyTime;
	private long modifier;
}
