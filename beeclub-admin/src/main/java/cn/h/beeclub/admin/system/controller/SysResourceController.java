package cn.h.beeclub.admin.system.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.h.beeclub.core.auth.shiro.UserUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cn.h.beeclub.admin.system.domain.SysResource;
import cn.h.beeclub.admin.system.entity.IdAvailableEntity;
import cn.h.beeclub.admin.system.service.SysResourceService;
import cn.h.beeclub.common.base.entity.BaseTree;
import cn.h.beeclub.common.base.page.PageParam;
import cn.h.beeclub.common.base.result.PageResult;
import cn.h.beeclub.common.base.result.SimpleResult;
import cn.h.beeclub.core.base.BaseService;
import io.swagger.annotations.Api;

@Api(tags = "后台权限管理")
@RestController
@RequestMapping("/sysResource")
public class SysResourceController {
	
	@Autowired
	private SysResourceService sysResourceService;
	@Autowired
	private BaseService baseService;
	
	@PostMapping("/save")
//	@RequiresPermissions("sysResource::create")
	public SimpleResult<Boolean> create(@ModelAttribute SysResource permission){
		sysResourceService.createOrUpdate(permission);
		return SimpleResult.ok(true);
	}
	
	@GetMapping("/pageList")
	@RequiresPermissions("sysResource::pageList")
	public SimpleResult<PageResult<SysResource>> pageList(@ModelAttribute PageParam param){
		
		return SimpleResult.ok(null);
	}
	
	
	@GetMapping("/deleteById/{id}")
	@RequiresPermissions("sysResource::delete")
	public SimpleResult<Boolean> deleteById(@PathVariable Long id){
		int count = sysResourceService.deleteById(id);
		return count > 0 ? SimpleResult.ok(true) : SimpleResult.fail("");
	}
	
	
	@PostMapping("/update")
//	@RequiresPermissions("sysResource::update")
	public SimpleResult<Boolean> update(@ModelAttribute SysResource permission){
		sysResourceService.createOrUpdate(permission);
		return SimpleResult.ok(true);
	}
	
	@GetMapping("/treeTable")
//	@RequiresPermissions(value="sysResource::treeTable")
	public SimpleResult<List<SysResource>> treeTable(){
		List<SysResource> listData = baseService.list("SysResource.selectAll");
		List<SysResource> data = (List<SysResource>) BaseTree.tree(listData, SysResource.class, null);
		return SimpleResult.ok(data);
	}

	@GetMapping("/rolePermissions")
//	@RequiresPermissions(value="sysResource::rolePermissions")
	public SimpleResult<Map<String,Object>> rolePermissions(@RequestParam Long roleId){
		Long userId = UserUtils.getUserId();
		List<SysResource> listData = null;
//
//		param.put("roleId", roleId);
		//:default-checked-keys="[5]"
		if(userId == 1){
			listData = baseService.list("SysResource.selectAvailableByAdmin");
		}else{
			listData = baseService.list("SysResource.selectAvailableByUserId", userId);
		}
		List<SysResource> rolePermissions = (List<SysResource>) BaseTree.tree(listData, SysResource.class, null);

		List<SysResource> checkedListData = baseService.list("SysResource.selectAvailableByRoleId", roleId);
		List<SysResource> checkedLeafNodes = (List<SysResource>) BaseTree.getLeafNodes(checkedListData, SysResource.class, null);
		List<Long> checkedPermission = new ArrayList<Long>();
		
		checkedLeafNodes.forEach(node -> {
			checkedPermission.add(node.getId());
		});
		
		Map<String,Object> res = new HashMap<>();
		res.put("checkedPermission",checkedPermission);
		res.put("data",rolePermissions);
		return SimpleResult.ok(res);
	}
	
	@PostMapping("/updateAvailableById")
	public SimpleResult<Boolean> updateAvailableById(IdAvailableEntity param) {
		int result = sysResourceService.updateAvailableById(param);
		return result > 0 ? SimpleResult.ok() : SimpleResult.fail("切换失败 ");
	}
}
