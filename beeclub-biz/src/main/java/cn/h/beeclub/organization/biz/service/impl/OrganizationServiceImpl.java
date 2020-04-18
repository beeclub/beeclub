package cn.h.beeclub.organization.biz.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.h.beeclub.organization.biz.dao.OrganizationDao;
import cn.h.beeclub.organization.biz.domain.Organization;
import cn.h.beeclub.organization.biz.dto.OrganizationDto;
import cn.h.beeclub.organization.biz.mapper.OrganizationMapper;
import cn.h.beeclub.organization.biz.service.OrganizationService;

@Service
public class OrganizationServiceImpl extends ServiceImpl<OrganizationMapper, Organization> implements OrganizationService{

	@Autowired
	private OrganizationDao organizationDao;
	@Autowired
	private Mapper mapper;
	
	@Override
	public void save(OrganizationDto param) {
		Organization organizationDo = mapper.map(param, Organization.class);
		//生成
		if(organizationDo.getId() != null) {
			baseMapper.updateById(organizationDo);
		}else {
			baseMapper.insert(organizationDo);
		}
	}

	@Override
	public List<OrganizationDto> findByParam(OrganizationDto param) {
		List<Organization> selectList = baseMapper.selectList(null);
		return selectList.stream().map(v -> mapper.map(v, OrganizationDto.class)).collect(Collectors.toList());
	}
	
	@Override
	public List<OrganizationDto> findAll(){
		List<Organization> selectList = baseMapper.selectList(null);
		return selectList.stream().map(v -> mapper.map(v, OrganizationDto.class)).collect(Collectors.toList());
	}
}
