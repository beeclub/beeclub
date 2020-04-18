package cn.h.beeclub.portal.api.pub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.h.beeclub.common.base.result.SimpleResult;
import cn.h.beeclub.course.biz.dto.CourseMasterDto;
import cn.h.beeclub.course.biz.dto.param.CoursePageParamDto;
import cn.h.beeclub.course.biz.service.CourseMasterService;
import cn.h.beeclub.portal.common.constant.ApiConstant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("课程")
@RestController
@RequestMapping(ApiConstant.API_PUBLIC_V1_PREFIX)
public class PubCourseController {

	@Autowired
	private CourseMasterService courseMasterService;


	@GetMapping("/course/page")
	public SimpleResult<PageImpl<CourseMasterDto>> coursePage(
			@RequestParam(value = "cateId", required = false) Integer cateId, Pageable pageable) {
		CoursePageParamDto param = new CoursePageParamDto();
		param.setCateId(cateId);
		return SimpleResult.ok(courseMasterService.fontCoursePage(pageable, param));
	}

	@ApiOperation(value = "")
	@GetMapping("/course/{id}")
	public SimpleResult<CourseMasterDto> courseDetail(@PathVariable String id) {
		return SimpleResult.ok(courseMasterService.findCourseMaster(id));
	}

}
