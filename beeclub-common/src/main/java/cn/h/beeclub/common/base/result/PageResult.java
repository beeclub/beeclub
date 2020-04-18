package cn.h.beeclub.common.base.result;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class PageResult<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3677489954648454140L;
	
	public PageResult(int size, int page, long total, int pages, List<T> list) {
		this.size = size;
		this.page = page;
		this.total = total;
		this.pages = pages;
		this.list = list;
	}
	
	
	public PageResult(long total, List<T> list) {
		this.total = total;
		this.list = list;
	}
	
	public PageResult() {
	}

	private int size;
	private int page;
	private long total;
	private int pages;
	private List<T> list;
}
