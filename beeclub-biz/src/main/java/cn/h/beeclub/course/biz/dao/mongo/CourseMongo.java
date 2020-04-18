package cn.h.beeclub.course.biz.dao.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import cn.h.beeclub.course.biz.doamin.CourseMasterDo;


@Component
public class CourseMongo {

	
	@Autowired
    private MongoOperations mongoOperations;
	
//	/**
//	 * 
//	 * @description 
//	 * @param courseMasterDo
//	 */
//	public void createCourse(CourseMasterDo courseMasterDo) {
//		mongoOperations.save(courseMasterDo, CourseMasterDo.DB_COLLECTION_NAME);
//	}
	
}
