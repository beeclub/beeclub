package cn.h.beeclub.admin.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import cn.h.beeclub.common.base.BaseController;
import cn.h.beeclub.common.base.page.PageParam;
import cn.h.beeclub.common.base.result.PageResult;
import cn.h.beeclub.common.base.result.SimpleResult;
import cn.h.beeclub.common.util.OSSClientUtil;
import cn.h.beeclub.course.biz.dto.CourseMasterDto;
import cn.h.beeclub.course.biz.service.CourseMasterService;

/**
 * 
 * @description 
 * @author hao.huang
 * @date 2019年12月2日
 */
@RestController
@RequestMapping("/api/v1")
public class CourseMasterController extends BaseController{
	
	@Autowired
	private CourseMasterService courseMasterService;
	
	
	/**
	 * 保存课程
	 * @description 
	 * @param courseMaster
	 * @return
	 */
	@PostMapping("/course-master")
	@PutMapping("/course-master")
	@RequestMapping(value="/course-master", method = {RequestMethod.PUT, RequestMethod.POST})
	public SimpleResult<Boolean>  init(@RequestBody @Validated CourseMasterDto courseMaster){
		courseMasterService.init(courseMaster);
		return SimpleResult.ok(true);
	}
	
	@GetMapping("/course-master/page")
	public SimpleResult<PageResult<CourseMasterDto>> page(PageParam pageParam){
		return SimpleResult.ok(courseMasterService.page(pageParam));
	}

	@GetMapping("/course-master/{id}")
	public  SimpleResult<CourseMasterDto> getCourseDetail(@PathVariable("id") String id){
		return SimpleResult.ok(courseMasterService.findCourseMaster(id));
	}
}
