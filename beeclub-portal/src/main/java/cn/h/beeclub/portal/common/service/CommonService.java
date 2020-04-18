package cn.h.beeclub.portal.common.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.h.beeclub.common.api.dic.CodeValue;
import cn.h.beeclub.core.base.BaseDao;

@Service
public class CommonService {
	
	@Autowired
	private BaseDao baseDao;
	
	public List<CodeValue> getSimpleSelectId(String id) {
		List<CodeValue> res = null;
		String srcSql = baseDao.getOne("common.getSrcSqlById", id);
		if(StringUtils.isBlank(srcSql)) {
			//根据ID获取下拉框
			res = baseDao.getOne("common.getSimpleSelectId", id);
		}else {
			res = baseDao.getOne("common.getSimpleSelectSrcSql", srcSql);
		}
		return res;
	}
	
}
