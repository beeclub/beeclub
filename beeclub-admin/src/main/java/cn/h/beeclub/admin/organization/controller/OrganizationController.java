package cn.h.beeclub.admin.organization.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import cn.h.beeclub.common.base.BaseController;
import cn.h.beeclub.common.base.entity.handler.TreeHandler;
import cn.h.beeclub.common.base.result.SimpleResult;
import cn.h.beeclub.organization.biz.domain.Organization;
import cn.h.beeclub.organization.biz.dto.OrganizationDto;
import cn.h.beeclub.organization.biz.service.OrganizationService;

@RestController
@RequestMapping("/organization")
public class OrganizationController extends BaseController{
	
	@Autowired
	private OrganizationService organizationService;
	
	@PostMapping("/save")
	public SimpleResult<Boolean> save(@RequestBody OrganizationDto param){
		organizationService.save(param);
		return SimpleResult.ok();
	}
	
	@GetMapping("/treeTable")
	public SimpleResult<List<OrganizationDto>> treeTable(){
		List<OrganizationDto> listData = organizationService.findAll();
		return SimpleResult.ok((List<OrganizationDto>)TreeHandler.tree(listData, null));
	}
	
//	@GetMapping("/treeTable")
//	public SimpleResult<IPage<Organization>> TreeOrgan(Page<Organization> page) {
//		IPage<Organization> page2 = organizationService.page(page);
//		return SimpleResult.ok(page2);
//	}
//	970592599993
}
