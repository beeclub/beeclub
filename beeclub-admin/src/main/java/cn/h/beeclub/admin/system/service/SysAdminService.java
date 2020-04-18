package cn.h.beeclub.admin.system.service;

import org.springframework.transaction.annotation.Transactional;

import cn.h.beeclub.admin.system.domain.SysAdmin;
import cn.h.beeclub.admin.system.entity.IdAvailableEntity;

public interface SysAdminService {

    SysAdmin getAdminByMoible(String mobile);

    @Transactional
    void createSysAdmin(SysAdmin sysAdmin);

	SysAdmin getAdminByEmail(String email);
	
	@Transactional
	int updateLoginTime(Long id);

	@Transactional
	int switchAvailable(IdAvailableEntity param);
	
}
