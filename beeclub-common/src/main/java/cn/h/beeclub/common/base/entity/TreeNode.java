package cn.h.beeclub.common.base.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class TreeNode<K,V> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4167461690221453266L;
	private K id;
	private K pid;
	private List<? extends TreeNode<K, V>> children;
	
	
}
