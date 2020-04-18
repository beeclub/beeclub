package cn.h.beeclub.sem.biz.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDo {
    private Long orderId;
    private Long        skuId;
    private String subject;
     private BigDecimal price;
    private BigDecimal actualPrice;
     private Integer       quantity;

}
