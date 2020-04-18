package cn.h.beeclub.system.biz.service.impl;

import cn.h.beeclub.common.base.dto.OperationContext;
import cn.h.beeclub.common.base.page.PageParam;
import cn.h.beeclub.common.base.result.PageResult;
import cn.h.beeclub.common.base.result.SimpleResult;
import cn.h.beeclub.common.util.PageUtils;
import cn.h.beeclub.system.biz.dao.DictDao;
import cn.h.beeclub.system.biz.domain.DictCategoryDo;
import cn.h.beeclub.system.biz.domain.DictItemDo;
import cn.h.beeclub.system.biz.dto.DictCategoryDto;
import cn.h.beeclub.system.biz.dto.DictItemDto;
import cn.h.beeclub.system.biz.service.DictService;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class DictServiceImpl implements DictService {

    @Autowired
    private DictDao dictDao;
    
    @Autowired
    private Mapper mapper;

	@Override
	public void saveDictCategory(OperationContext context, DictCategoryDto param) {
		DictCategoryDo categoryDo = mapper.map(param, DictCategoryDo.class);
		categoryDo.setModifier(context.getOperator());
		if(param.getId() == null) {
			categoryDo.setAvailable(true);
			categoryDo.setCreator(context.getOperator());
			
			dictDao.createDictCategory(categoryDo);
		}else {
			//更新
		}
	}

	@Override
	public PageResult<DictCategoryDto> pageDictCategory(PageParam pageParam, Boolean available) {
		PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
		List<DictCategoryDo> listDictCategory = dictDao.listDictCategory(available);
		PageResult<DictCategoryDto> res = PageUtils.pageConvertPageResult(listDictCategory, v -> mapper.map(v, DictCategoryDto.class));
		return res;
	}
	
	
	@Override
	public List<DictCategoryDto> listDictCategory(Boolean available) {
		return dictDao.listDictCategory(available).stream().map(v -> mapper.map(v, DictCategoryDto.class)).collect(Collectors.toList());
	}
	

	@Override
	public void saveDictItem(OperationContext context, DictItemDto param) {
		DictItemDo itemDo = mapper.map(param, DictItemDo.class);
		itemDo.setModifier(context.getOperator());
		if(param.getId() == null) {
			itemDo.setAvailable(true);
			itemDo.setCreator(context.getOperator());
			
			dictDao.createDictItem(itemDo);
		}else {
			//更新
		}
	}

	@Override
	public List<DictItemDto> listDictItem(String cateCode, Boolean available) {
		return dictDao.listDictItem(cateCode, available).stream().map(v -> mapper.map(v, DictItemDto.class)).collect(Collectors.toList());
	}

	

   
}
