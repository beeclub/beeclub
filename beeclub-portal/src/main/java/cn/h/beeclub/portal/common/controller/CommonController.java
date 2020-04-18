package cn.h.beeclub.portal.common.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.h.beeclub.common.api.dic.CodeValue;
import cn.h.beeclub.common.base.result.SimpleResult;
import cn.h.beeclub.portal.common.service.CommonService;
import cn.h.beeclub.portal.common.type.ParameterType.BaseServiceType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "common")
@Controller
@RequestMapping("/common")
public class CommonController {
	
	@Autowired
	private CommonService commonService;
	
	@ApiOperation(value = "")
	@RequestMapping(value="/baseService", method=RequestMethod.GET)
	public SimpleResult<Object> baseService(
			@RequestParam(required = true) BaseServiceType type, 
			@RequestParam(required = false) String id, 
			@RequestParam(required = false) String provider){
		if(StringUtils.isNoneBlank(id)) {
			//使用ID
		}
		
		switch (type) {
		case byId:
			List<CodeValue> res = commonService.getSimpleSelectId(id);
			return SimpleResult.ok(res);
		case byProvider:
			break;
		default:
			break;
		}
		
		
		return null;
	}
	
	
	
}
