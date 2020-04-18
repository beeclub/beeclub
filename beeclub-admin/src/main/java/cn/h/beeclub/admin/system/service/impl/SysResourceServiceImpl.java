package cn.h.beeclub.admin.system.service.impl;

import cn.h.beeclub.admin.system.dao.SysResourceDao;
import cn.h.beeclub.admin.system.domain.SysResource;
import cn.h.beeclub.admin.system.entity.IdAvailableEntity;
import cn.h.beeclub.admin.system.service.SysResourceService;
import cn.h.beeclub.common.base.entity.BaseTree;
import cn.h.beeclub.core.base.BaseDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysResourceServiceImpl implements SysResourceService {
	
	@Autowired
	private BaseDao baseDao;
	
	@Autowired
	private SysResourceDao sysResourceDao;
	
    @Override
    public List<String> getPermissionsByUserId(Long userId) {
    	if(userId != 1) {
    		return baseDao.list("SysResource.getPermissionsByUserId", userId);
    	}
        return baseDao.list("SysResource.getPermissionOfAdmin");
    }

	@Override
	public void createOrUpdate(SysResource permission) {
		if(permission.getPid() == null) {
			permission.setPid(0L);
		}
		if(permission.getId() != null) {
			//update
			baseDao.update("SysResource.update",permission);
		}else {
			baseDao.update("SysResource.insert",permission);
		}
	}

	@Override
	public int deleteById(Long id) {
		return baseDao.delete("SysResource.deleteById", id);
	}

	@Override
	public SysResource getOneById(Long id) {
		return baseDao.getOne("SysResource.deleteById", id);
	}

	@Override
	public List<SysResource> menuList(Long userId) {
		List<SysResource> res = null;
		if(userId == 1) {
			res = baseDao.list("SysResource.getMenuByUserId", userId);
    	}
		res = baseDao.list("SysResource.getAdminMenu");
		return (List<SysResource>) BaseTree.tree(res, SysResource.class, null);
	}

	@Override
	public int updateAvailableById(IdAvailableEntity param) {
		return sysResourceDao.updateAvailableById(param);
	}
}
