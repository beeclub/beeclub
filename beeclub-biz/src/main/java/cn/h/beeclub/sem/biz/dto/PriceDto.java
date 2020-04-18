package cn.h.beeclub.sem.biz.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

@Data
public class PriceDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1229971515854475625L;
	private Boolean free = Boolean.TRUE;//是否免费
	private BigDecimal originPrice;             //原始价格
	private BigDecimal disacountPrice;          //折扣价格
	private BigDecimal disacountRatio = new BigDecimal(100);//折扣比例
	
}
