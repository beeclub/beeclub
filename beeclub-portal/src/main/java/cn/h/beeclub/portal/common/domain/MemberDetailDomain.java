package cn.h.beeclub.portal.common.domain;

import java.util.Date;

import lombok.Data;

@Data
public class MemberDetailDomain {

	private Long id;
    private String account;
	private Integer type;//普通
	private Date registerTime;
	
    private String mobile;//手机号码
    private String nickname;//nutset,
    private String birthday;//生日,
    private String headImg;
    private String qq;//,
    private String description;//描述,
    private String realname;//真名,
    private Integer gender;//性别
    private String email;//常用邮箱
    private String industry;//产业,
    private String profession;//职业,
    private String signature;//个性签名,
    private String wechat;//,
    private String relevanceMobile;//关联电话,
	
}
