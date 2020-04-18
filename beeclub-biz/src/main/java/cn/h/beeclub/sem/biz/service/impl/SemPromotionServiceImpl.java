package cn.h.beeclub.sem.biz.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import cn.h.beeclub.sem.biz.dto.SemPromotionDto;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.h.beeclub.common.base.page.PageParam;
import cn.h.beeclub.common.base.result.PageResult;
import cn.h.beeclub.common.util.PageUtils;
import cn.h.beeclub.sem.biz.dao.SemPromotionDao;
import cn.h.beeclub.sem.biz.domain.SemPromotionDo;
import cn.h.beeclub.sem.biz.service.SemPromotionService;

@Service
public class SemPromotionServiceImpl implements SemPromotionService{

	@Autowired
	private SemPromotionDao semPromotionDao;
	@Autowired
	private Mapper mapper;
	
	@Override
	public int createOnSave(SemPromotionDo param) {
		if(param.getId() != null) {
			return semPromotionDao.update(param);
		}else {
			return semPromotionDao.create(param);
		}
	}

	@Override
	public List<SemPromotionDto> listOnSaleByModule(Integer module) {
		return semPromotionDao.listOnSaleByModule(module).stream().map(v -> mapper.map(v, SemPromotionDto.class)).collect(Collectors.toList());
	}

	@Override
	public PageResult<SemPromotionDo> pageList(PageParam pageParam) {
		PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
		List<SemPromotionDo> res = semPromotionDao.listAll();
		return PageUtils.pageConvertPageResult(res);
	}

}
