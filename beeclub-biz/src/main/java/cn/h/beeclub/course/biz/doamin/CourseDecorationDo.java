package cn.h.beeclub.course.biz.doamin;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import cn.h.beeclub.common.base.domain.Domain.MongoDomain;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = CourseDecorationDo.DB_COLLECTION_NAME)
public class CourseDecorationDo  extends MongoDomain{
	public static final String DB_COLLECTION_NAME = "course-decoration";
	
	private String id;
	private String content;
	private List<String> imgs;
}
