package cn.h.beeclub.sem.biz.service;

import java.util.List;

import cn.h.beeclub.common.base.page.PageParam;
import cn.h.beeclub.common.base.result.PageResult;
import cn.h.beeclub.sem.biz.domain.SemPromotionDo;
import cn.h.beeclub.sem.biz.dto.SemPromotionDto;

public interface SemPromotionService {

	
	int createOnSave(SemPromotionDo param);
	
	List<SemPromotionDto> listOnSaleByModule(Integer module);

	PageResult<SemPromotionDo> pageList(PageParam pageParam);
}
