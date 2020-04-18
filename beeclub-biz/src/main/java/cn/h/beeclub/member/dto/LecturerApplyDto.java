package cn.h.beeclub.member.dto;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 
 * @description 
 * @author hao.huang
 * @date 2019年10月12日
 */
@Data
public class LecturerApplyDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1001153458877857391L;
	private Long id;
    @ApiModelProperty(value = "手机号码")
    private String mobile;
    private String verifyCode;
    private String name;
    private String idCard;
    private String readme;

    private Integer step;
    private Date applyTime;
    
    
}
