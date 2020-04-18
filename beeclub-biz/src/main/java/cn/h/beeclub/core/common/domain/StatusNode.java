package cn.h.beeclub.core.common.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class StatusNode<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3994428273107442406L;
	private StatusNode<T> prev;
	private T current;
	private StatusNode<T> next;
}
