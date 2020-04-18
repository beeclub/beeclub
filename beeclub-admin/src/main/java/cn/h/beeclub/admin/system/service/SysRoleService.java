package cn.h.beeclub.admin.system.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.h.beeclub.admin.system.domain.SysRole;
import cn.h.beeclub.admin.system.entity.IdAvailableEntity;

public interface SysRoleService {

	@Transactional
	void createOrUpdate(SysRole sysRole);

	int deleteById(Long id);

	SysRole getOneById(Long id);

	@Transactional
	void updateRolePermission(Long roleId, List<Long> resourceIds);
	
	List<SysRole> listRolesByAvailable(boolean available);
	
	@Transactional
	void changeAdminRoles(Long adminId,List<Long> roleIds);

	List<Long> getSysRoleIdsByAdminId(Long adminId);

	int switchAvailable(IdAvailableEntity param);
}
