package cn.h.beeclub.course.biz.doamin;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;

import cn.h.beeclub.common.api.dic.CodableValue;
import cn.h.beeclub.common.base.domain.Domain.MongoDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = CourseClassDo.DB_COLLECTION_NAME)
public class CourseClassDo extends MongoDomain{
	
	public static final String DB_COLLECTION_NAME = "course-class";
	
	//课时
	private String id;
	private String chapterId;//章节信息
	private String title;
	private String subhead;
	private String descrption;
	private BigDecimal duration;
	private CodableValue status;
	
}
