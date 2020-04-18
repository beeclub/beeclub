package cn.h.beeclub.course.biz.dto;

import java.io.Serializable;
import java.util.List;

import cn.h.beeclub.common.base.entity.MetadataEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class CourseDecorationDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7100539247474017312L;
	/**
	 * 
	 */
	private String id;
	private String content;
	private List<String> imgs;
	
}
