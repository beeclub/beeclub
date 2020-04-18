package cn.h.beeclub.sem.biz.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderDo {

    private Long id;
    private String code;//流水号
    private Integer type;//订单类型 1课程 2 商城
    private Long userId;//
    private BigDecimal amount;
    private Integer paymentType;//支付方式 1借记卡2信用卡3微信4支付宝5现金
    private Integer status;//订单状态 1未付款 2 已付款 3已发货 4已签收
    private BigDecimal postage;//邮费
    private Integer weight;//
    private Long voucherId;
    private Date createTime;
    private Date modifyTime;
}
