package cn.h.beeclub.admin.system.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.h.beeclub.admin.system.domain.SysResource;
import cn.h.beeclub.admin.system.entity.IdAvailableEntity;

public interface SysResourceService {
    List<String> getPermissionsByUserId(Long userId);

    @Transactional
	void createOrUpdate(SysResource permission);

	int deleteById(Long id);
	
	SysResource getOneById(Long id);
	
	List<SysResource> menuList(Long userId);

	int updateAvailableById(IdAvailableEntity param);
}
