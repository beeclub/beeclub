package cn.h.beeclub.sem.biz.domain;

import java.math.BigDecimal;
import java.util.Date;

import cn.h.beeclub.common.base.domain.Domain.MongoDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OrderMasterDo extends MongoDomain{

	private Long id;
	private String orderNo;
	
	
	private BigDecimal payableAmount;//应付金额
	private BigDecimal actuallyAmount;//实付金额
	
	private Date createDate;
	
	
}
