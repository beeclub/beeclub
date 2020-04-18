package cn.h.beeclub.common.base.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class ElementTransferEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2114133151164065402L;
	private Long key;
	private String label;
	private boolean disabled;
}
