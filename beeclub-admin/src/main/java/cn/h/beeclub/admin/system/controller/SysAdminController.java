package cn.h.beeclub.admin.system.controller;

import cn.h.beeclub.admin.system.dao.SysAdminDao;
import cn.h.beeclub.admin.system.domain.SysAdmin;
import cn.h.beeclub.admin.system.entity.IdAvailableEntity;
import cn.h.beeclub.admin.system.service.SysAdminService;
import cn.h.beeclub.admin.system.service.SysRoleService;
import cn.h.beeclub.admin.system.vo.SysAdminRolesParamVo;
import cn.h.beeclub.common.base.page.PageParam;
import cn.h.beeclub.common.base.result.PageResult;
import cn.h.beeclub.common.base.result.PageResult;
import cn.h.beeclub.common.base.result.SimpleResult;

import java.util.List;

import cn.h.beeclub.common.util.PageUtils;
import cn.h.beeclub.core.base.BaseService;
import org.apache.ibatis.session.RowBounds;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@RestController
@RequestMapping("/sysAdmin")
public class SysAdminController {
    @Autowired
    private SysAdminService sysAdminService;
    @Autowired
    private SysAdminDao sysAdminDao;
    @Autowired
    private BaseService baseService;
    @Autowired
    private SysRoleService sysRoleService;


    @PostMapping("/createSysAdmin")
    public SimpleResult<Integer> saveSysAdmin(@ModelAttribute SysAdmin admin){
        if(admin.getId() == null){//新建
            sysAdminService.createSysAdmin(admin);
        }
        return new SimpleResult<>("新建成功");
    }
    
    @GetMapping("/common/getTest")
    @ResponseBody
    public List<SysAdmin> test(){
    	PageHelper.startPage(2, 2);
    	List<SysAdmin> res = sysAdminDao.pageSysAdmin2();
    	return res;
    }
    @GetMapping("/pageList")
    @RequiresPermissions("sysAdmin::query")
    public SimpleResult<PageResult<SysAdmin>> pageList(@ModelAttribute PageParam param){
        PageHelper.startPage(param.getPage(), param.getSize());
        List<SysAdmin> res = baseService.list("SysAdmin.listAll", null);
        return SimpleResult.page(res);
    }
    
    @PostMapping("/switchAvailable")
    @RequiresPermissions("sysAdmin::update")
    public SimpleResult<Boolean> switchAvailable(IdAvailableEntity param){
		int result = sysAdminService.switchAvailable(param);
		return result > 0 ? SimpleResult.ok() : SimpleResult.fail("切换失败 ");
    }
    
    @PostMapping("/changeAdminRoles")
    @RequiresPermissions("sysAdmin::changeAdminRoles")
    public SimpleResult<Boolean> changeAdminRoles(SysAdminRolesParamVo param){
    	sysRoleService.changeAdminRoles(param.getAdminId(), param.getRoleIds());
		return SimpleResult.ok();
    }
    
    @GetMapping("/getSysRoleIdsByAdminId/{adminId}")
    public SimpleResult<List<Long>> getSysRoleIdsByAdminId(@PathVariable("adminId") Long adminId){
        List<Long> res = sysRoleService.getSysRoleIdsByAdminId(adminId);
        return SimpleResult.ok(res);
    }
}
