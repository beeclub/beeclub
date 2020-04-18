package cn.h.beeclub.admin.system.controller;

import java.util.List;

import cn.h.beeclub.core.auth.shiro.UserUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;

import cn.h.beeclub.admin.system.domain.SysRole;
import cn.h.beeclub.admin.system.entity.IdAvailableEntity;
import cn.h.beeclub.admin.system.service.SysRoleService;
import cn.h.beeclub.admin.system.vo.SysRolePermissionParamVo;
import cn.h.beeclub.common.base.page.PageParam;
import cn.h.beeclub.common.base.result.PageResult;
import cn.h.beeclub.common.base.result.SimpleResult;
import cn.h.beeclub.common.util.PageUtils;
import cn.h.beeclub.core.base.BaseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "模块名称")
@RestController
@RequestMapping("/sysRole")
public class SysRoleController {

	@Autowired
	private SysRoleService sysRoleService;
	@Autowired
	private BaseService baseService;

	@PostMapping("/create")
	@RequiresPermissions("sysRole::create")
	public SimpleResult<Boolean> create() {
		return SimpleResult.ok(true);
	}

	@GetMapping("/pageList")
	@RequiresPermissions("sysRole::query")
	public SimpleResult<PageResult<SysRole>> pageList(@ModelAttribute PageParam param) {
		PageHelper.startPage(param.getPage(), param.getSize());
		List<SysRole> res = baseService.page("SysRole.listAll", null, new RowBounds(param.getPage(), param.getSize()));
		return SimpleResult.page(res);
	}

	@GetMapping("/delete/{id}")
	@RequiresPermissions("sysRole::delete")
	public SimpleResult<Boolean> delete(@PathVariable Long id) {
		int count = sysRoleService.deleteById(id);
		return count > 0 ? SimpleResult.ok(true) : SimpleResult.fail("删除失败");
	}

	@PostMapping("/save")
	@RequiresPermissions("sysRole::update")
	public SimpleResult<Boolean> update(@ModelAttribute SysRole sysRole) {
		sysRoleService.createOrUpdate(sysRole);
		return SimpleResult.ok(true);
	}

	@GetMapping("/queryList")
	@RequiresPermissions("sysRole::query")
	public SimpleResult<List<SysRole>> queryList() {
		List<SysRole> res = baseService.list("SysRole.listAll");
		return SimpleResult.ok(res);
	}

	@ApiOperation("")
	@PostMapping("/updateRolePermission")
	@RequiresPermissions("sysRole::updateRolePermission")
	public SimpleResult<Boolean> updateRolePermission(SysRolePermissionParamVo param) {
		sysRoleService.updateRolePermission(param.getRoleId(), param.getResourceIds());
		return SimpleResult.ok(true);
	}

	@GetMapping("/listRolesByAvailable")
//	@RequiresPermissions("sysRole::query")
	public SimpleResult<List<SysRole>> listRolesByAvailable(@RequestParam("available") boolean available) {
		List<SysRole> res = sysRoleService.listRolesByAvailable(available);
		return SimpleResult.ok(res);
	}

	@PostMapping("/switchAvailable")
	@RequiresPermissions("sysAdmin::update")
	public SimpleResult<Boolean> switchAvailable(IdAvailableEntity param) {
		int result = sysRoleService.switchAvailable(param);
		return result > 0 ? SimpleResult.ok() : SimpleResult.fail("切换失败 ");
	}

}
