package cn.h.beeclub.system.biz.service;

import cn.h.beeclub.common.base.dto.OperationContext;
import cn.h.beeclub.common.base.page.PageParam;
import cn.h.beeclub.common.base.result.PageResult;
import cn.h.beeclub.system.biz.dto.DictCategoryDto;
import cn.h.beeclub.system.biz.dto.DictItemDto;

import java.util.List;

public interface DictService {

	void saveDictCategory(OperationContext context, DictCategoryDto param);

	PageResult<DictCategoryDto> pageDictCategory(PageParam pageParam,Boolean available);

	List<DictCategoryDto> listDictCategory(Boolean available);
	
	void saveDictItem(OperationContext context, DictItemDto param);

	List<DictItemDto> listDictItem(String cateCode, Boolean available);
}
