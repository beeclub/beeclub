package cn.h.beeclub.course.biz.doamin;

import org.springframework.data.mongodb.core.mapping.Document;

import cn.h.beeclub.common.base.domain.Domain.MongoDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 章节信息
 * @description 
 * @author hao.huang
 * @date 2019年11月28日
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = CourseChapterDo.DB_COLLECTION_NAME)
public class CourseChapterDo extends MongoDomain{

	public static final String DB_COLLECTION_NAME = "course-chapter";
	
	/**
	 * 
	 */
	private String id;
	private String pid;
	private Long courseId;
	private String title;
	private Integer sort;
	
}
