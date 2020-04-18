package cn.h.beeclub.course.biz.service;

import java.util.List;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import cn.h.beeclub.common.base.dto.OperationContext;
import cn.h.beeclub.common.base.page.PageParam;
import cn.h.beeclub.common.base.result.PageResult;
import cn.h.beeclub.common.enums.CommonEnums.CourseStatus;
import cn.h.beeclub.course.biz.dto.CourseMasterDto;
import cn.h.beeclub.course.biz.dto.param.CoursePageParamDto;

public interface CourseMasterService {

	/**
	 * 创建
	 * 
	 * @description
	 * @param courseMaster
	 */
	void init(CourseMasterDto courseMaster);

	/**
	 * 
	 * @description
	 * @param context
	 * @param id
	 * @param status
	 */
	void changeStatus(OperationContext context, long id, CourseStatus status);

	/**
	 * 
	 * @description
	 * @param courseMaster
	 */
	void update(CourseMasterDto courseMaster);

	/**
	 * 
	 * @description
	 */
	List<CourseMasterDto> findAllCourse(OperationContext context);

	/**
	 * 
	 * @description
	 * @param id
	 * @return
	 */
	CourseMasterDto findCourseMaster(String id);

	PageResult<CourseMasterDto> page(PageParam pageParam);

	/**
	 * 
	 * @description
	 * @param pageParam
	 * @param param
	 * @return
	 */
	PageImpl<CourseMasterDto> fontCoursePage(Pageable pageable, CoursePageParamDto param);

	/**
	 *
	 * @param ids
	 * @return
	 */
	List<CourseMasterDto> findCoursesByIds(List<String> ids);
}
