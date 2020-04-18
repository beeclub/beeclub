package cn.h.beeclub.system.biz.dto;

import cn.h.beeclub.common.base.dto.BaseDto;
import lombok.Data;

@Data
public class DictItemDto extends BaseDto {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
    private String cateCode;
    private String code;
    private String name;
    private String label;
    private Integer sort = 0;
    private Boolean defaulted = Boolean.FALSE;

}
