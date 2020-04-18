package cn.h.beeclub.sem.biz.dto;

import lombok.Data;

@Data
public class SemPromotionDto {
    private Long id;
    private String title        ;//标题
    private Integer module       ;//模块 1 轮播图
    private String url          ;//跳转地址
    private String img;//
    private String backgroundColor;
    private String target       ;//目标
    private Integer priority     ;//显示顺序
    private boolean onSale      ;//是否上架
}
