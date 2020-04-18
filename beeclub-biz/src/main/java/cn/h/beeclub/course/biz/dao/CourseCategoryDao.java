package cn.h.beeclub.course.biz.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.h.beeclub.course.biz.doamin.CourseCategoryDo;

public interface CourseCategoryDao {

	
	List<CourseCategoryDo> listByParams(Map<String,Object> params);
	
	CourseCategoryDo getById(@Param("id") Long id);
	
	int create(CourseCategoryDo param);
	
	int update(CourseCategoryDo param);
	
	@Update("update t_course_category set available = #{available} where id = #{id}" )
	int updateAvailableById(@Param("id") Long id, @Param("available") Boolean available);

	@Delete("delete from t_course_category where id = #{id}")
	int deleteById(@Param("id") Long id);

	@Select("select * from t_course_category where available = true")
    List<CourseCategoryDo> listTopCourseCategory();
}
