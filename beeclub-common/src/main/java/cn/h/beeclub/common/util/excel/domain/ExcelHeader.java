package cn.h.beeclub.common.util.excel.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class ExcelHeader implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6361333666472941885L;
	private String title;
	private String property;
}
