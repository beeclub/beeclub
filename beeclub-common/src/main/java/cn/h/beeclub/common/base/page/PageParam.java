package cn.h.beeclub.common.base.page;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * @description 
 * @author hao.huang
 * @date 2019年9月7日
 */
@Data
public class PageParam implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2257871870652275567L;
	private int size = 10;
	private int page = 1;
	
	public long getSkip() {
		if(page <= 0) {
			page = 1;
		}
		if(size == 0) {
			size = 10;
		}
		return size * (page - 1);
	}
}
