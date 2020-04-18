package cn.h.beeclub.admin.sem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.h.beeclub.common.base.page.PageParam;
import cn.h.beeclub.common.base.result.PageResult;
import cn.h.beeclub.common.base.result.SimpleResult;
import cn.h.beeclub.common.util.PageUtils;
import cn.h.beeclub.sem.biz.domain.SemPromotionDo;
import cn.h.beeclub.sem.biz.service.SemPromotionService;

@RestController
@RequestMapping("/semPromotion")
public class SemPromotionController {

	@Autowired
	private SemPromotionService semPromotionService;
	
	@PostMapping("/saveSemPromotion")
	public SimpleResult<Boolean> saveSemPromotion(SemPromotionDo param){
		int count = semPromotionService.createOnSave(param);
		return count > 0 ? SimpleResult.ok() : SimpleResult.fail("保存失败");
	}
	
	
	@GetMapping("/pageList")
	public SimpleResult<PageResult<SemPromotionDo>> pageList(PageParam pageParam){
		PageResult<SemPromotionDo> res = semPromotionService.pageList(pageParam);
		return SimpleResult.ok(res);
	}
}
