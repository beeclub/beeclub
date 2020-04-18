package cn.h.beeclub.admin.system.service.impl;

import cn.h.beeclub.admin.system.dao.SysAdminDao;
import cn.h.beeclub.admin.system.domain.SysAdmin;
import cn.h.beeclub.admin.system.entity.IdAvailableEntity;
import cn.h.beeclub.admin.system.service.SysAdminService;
import cn.h.beeclub.core.base.BaseDao;
import cn.h.beeclub.core.util.EncodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SysAdminServiceImpl implements SysAdminService {

    @Autowired
    private BaseDao baseDao;

    @Autowired
    private SysAdminDao sysAdminDao;

    @Override
    public SysAdmin getAdminByMoible(String mobile) {
    	return sysAdminDao.getSysAdminByMobile(mobile);

    }

    @Transactional
    @Override
    public void createSysAdmin(SysAdmin admin) {
        SysAdmin currentAdmin = sysAdminDao.getSysAdminByMobile(admin.getMobile());
        if(currentAdmin != null){
            throw new RuntimeException("手机号已经存在。");
        }
        admin.setPassword(EncodeUtils.encodePwd("888888"));
        sysAdminDao.createAdmin(admin);
    }

	@Override
	public SysAdmin getAdminByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateLoginTime(Long id) {
		return sysAdminDao.updateLoginTime(id);
	}

	@Override
	public int switchAvailable(IdAvailableEntity param) {
		return sysAdminDao.switchAvailable(param);
	}
}
