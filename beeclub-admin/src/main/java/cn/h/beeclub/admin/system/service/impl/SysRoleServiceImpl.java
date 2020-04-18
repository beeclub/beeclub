package cn.h.beeclub.admin.system.service.impl;

import cn.h.beeclub.admin.system.dao.SysRoleDao;
import cn.h.beeclub.admin.system.domain.SysAdminRole;
import cn.h.beeclub.admin.system.domain.SysRole;
import cn.h.beeclub.admin.system.domain.SysRoleResource;
import cn.h.beeclub.admin.system.entity.IdAvailableEntity;
import cn.h.beeclub.admin.system.service.SysRoleService;
import cn.h.beeclub.core.base.BaseDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {
	
	@Autowired
	private BaseDao baseDao;
	
	@Autowired
	private SysRoleDao sysRoleDao;


	@Override
	public void createOrUpdate(SysRole sysRole) {
		if(sysRole.getId() != null) {
			baseDao.update("SysRole.update", sysRole);
		}else {
			baseDao.update("SysRole.insert", sysRole);
		}
		
	}

	@Override
	public int deleteById(Long id) {
		return baseDao.delete("SysRole.deleteById", id);
	}

	@Override
	public SysRole getOneById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateRolePermission(Long roleId, List<Long> resourceIds) {
		baseDao.delete("SysRole.deletePermissionsByRoleId", roleId);
		if(resourceIds.isEmpty()) {
			return;
		}else {
			for(Long resourceId : resourceIds) {
				SysRoleResource param = new SysRoleResource(null, roleId, resourceId);
				baseDao.insert("SysRole.insertRoleResource", param);
			}
		}
		
	}

	@Override
	public void changeAdminRoles(Long adminId, List<Long> roleIds) {
		sysRoleDao.deleteAdminRoleByAdminId(adminId);
		for(Long roleId : roleIds) {
			SysAdminRole adminRole = new SysAdminRole(null, adminId, roleId);
			sysRoleDao.insertAdminRole(adminRole);
		}
	}

	@Override
	public List<Long> getSysRoleIdsByAdminId(Long adminId) {
		return sysRoleDao.getSysRoleIdsByAdminId(adminId);
	}

	@Override
	public List<SysRole> listRolesByAvailable(boolean available) {
		return sysRoleDao.listRolesByAvailable(available);
	}

	@Override
	public int switchAvailable(IdAvailableEntity param) {
		return sysRoleDao.switchAvailable(param);
	}
}
