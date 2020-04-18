package cn.h.beeclub.system.biz.dto;

import cn.h.beeclub.common.base.dto.BaseDto;
import lombok.Data;

import java.util.List;

@Data
public class DictCategoryDto extends BaseDto {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1314955368288807691L;
	private Long id;
    private String code;
    private String name;
    private String srcSql;

    private List<DictItemDto> items;
}
