package cn.h.beeclub.course.biz.service;

import java.util.List;
import java.util.Map;

import cn.h.beeclub.course.biz.doamin.CourseCategoryDo;
import cn.h.beeclub.course.biz.dto.CourseCategoryDto;

public interface CourseCategoryService {

	int updateOrSave(CourseCategoryDo param);
	
	
	List<CourseCategoryDto> listByParams(Map<String,Object> params);


	int deleteById(Long id);


	int updateAvailableById(Long id, Boolean available);

    List<CourseCategoryDto> listTopCourseCategory();
}
