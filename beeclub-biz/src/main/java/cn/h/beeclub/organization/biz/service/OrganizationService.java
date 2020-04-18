package cn.h.beeclub.organization.biz.service;


import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

import cn.h.beeclub.organization.biz.domain.Organization;
import cn.h.beeclub.organization.biz.dto.OrganizationDto;

public interface OrganizationService extends IService<Organization>{

	
	void save(OrganizationDto param);
	
	List<OrganizationDto> findByParam(OrganizationDto param);
	
	List<OrganizationDto> findAll();
}
