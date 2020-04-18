package cn.h.beeclub.admin.system.controller;

import cn.h.beeclub.common.base.BaseController;
import cn.h.beeclub.common.base.page.PageParam;
import cn.h.beeclub.common.base.result.PageResult;
import cn.h.beeclub.common.base.result.SimpleResult;
import cn.h.beeclub.system.biz.dto.DictCategoryDto;
import cn.h.beeclub.system.biz.dto.DictItemDto;
import cn.h.beeclub.system.biz.service.DictService;
import io.swagger.annotations.Api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Api(tags = "")
@RequestMapping("/dict")
public class DictController extends BaseController{

    @Autowired
    private DictService dictService;

    @PostMapping("/saveDictCategory")
    public SimpleResult<Boolean> saveDictCategory(@RequestBody DictCategoryDto param){
    	dictService.saveDictCategory(getContext(), param);
    	return SimpleResult.ok();
    }
    
    @GetMapping("/pageDictCategory")
    public SimpleResult<PageResult<DictCategoryDto>> pageDictCategory(PageParam pageParam, @RequestParam(value = "available", required = false) Boolean available){
    	return SimpleResult.ok(dictService.pageDictCategory(pageParam, available));
    }
    
    
    
    
    @PostMapping("/saveDictItem")
    public SimpleResult<Boolean> saveDictItem(@RequestBody DictItemDto param){
    	dictService.saveDictItem(getContext(), param);
    	return SimpleResult.ok();
    }
    
    
    @GetMapping("/listDictItem")
    public SimpleResult<List<DictItemDto>> listDictItem(
    		@RequestParam(value = "cateCode", required = false) String cateCode,
    		@RequestParam(value = "available", required = false) Boolean available){
    	return SimpleResult.ok(dictService.listDictItem(cateCode, available));
    }
}
