package cn.h.beeclub.admin.course.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.h.beeclub.common.base.entity.BaseTree;
import cn.h.beeclub.common.base.entity.TreeNode;
import cn.h.beeclub.common.base.entity.handler.TreeHandler;
import cn.h.beeclub.common.base.result.SimpleResult;
import cn.h.beeclub.course.biz.doamin.CourseCategoryDo;
import cn.h.beeclub.course.biz.dto.CourseCategoryDto;
import cn.h.beeclub.course.biz.service.CourseCategoryService;

@RestController
@RequestMapping("/courseCategory")
public class CourseCategoryController {

	@Autowired
	private CourseCategoryService courseCategoryService;
	
	@GetMapping("/treeTable")
//	@RequiresPermissions(value="sysResource::treeTable")
	public SimpleResult<List<CourseCategoryDto>> treeTable(@RequestParam Map<String,Object> params){
		List<CourseCategoryDto> listData = courseCategoryService.listByParams(params);
		return SimpleResult.ok((List<CourseCategoryDto>)TreeHandler.tree(listData, null));
	}
	
	@PostMapping("/save")
	public SimpleResult<Boolean> save(@ModelAttribute CourseCategoryDo param){
		int count = courseCategoryService.updateOrSave(param);
		return count > 0 ? SimpleResult.ok(true) : SimpleResult.fail("保存失败");
	}
	
	@GetMapping("/deleteById/{id}")
	public SimpleResult<Boolean> deleteById(@PathVariable("id") Long id){
		int count = courseCategoryService.deleteById(id);
		return count > 0 ? SimpleResult.ok(true) : SimpleResult.fail("删除失败");
	}
	
	@GetMapping("/updateAvailableById")
	public SimpleResult<Boolean> updateAvailableById(@RequestParam("id") Long id,@RequestParam("available") Boolean available){
		int count = courseCategoryService.updateAvailableById(id, available);
		return count > 0 ? SimpleResult.ok(true) : SimpleResult.fail("切换失败");
	}




}
