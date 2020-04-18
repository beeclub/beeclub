package cn.h.beeclub.member.biz.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 
 * @description 
 * @author hao.huang
 * @date 2019年8月23日
 */
@Data
public class MemberDo {
	
	private Long id;
    private String account;
	private String password;
	private String salt;
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
