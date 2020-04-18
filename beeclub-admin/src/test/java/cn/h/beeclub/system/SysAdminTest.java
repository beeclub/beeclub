package cn.h.beeclub.system;

import cn.h.beeclub.BaseTest;
import cn.h.beeclub.admin.system.dao.SysAdminDao;
import cn.h.beeclub.admin.system.domain.SysAdmin;
import cn.h.beeclub.admin.system.service.SysAdminService;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

public class SysAdminTest extends BaseTest {

    @Autowired
    private SysAdminService sysAdminService;
    
    @Autowired
    private SysAdminDao sysAdminDao;

    @Test
    public void createSysteAdmin(){
        SysAdmin sysAdmin = new SysAdmin();
        sysAdmin.setMobile("18761730350");
        sysAdminService.createSysAdmin(sysAdmin);
    }
    
    @Test
    public void selectPage() {
//    	RowBounds rowBounds = new RowBounds(2, 2);
    	PageHelper.startPage(2, 2);
    	List<SysAdmin> res = sysAdminDao.pageSysAdmin2();
    	Page<SysAdmin> resPage = (Page<SysAdmin>) res;
    	System.err.println(res.getClass().getName());
    	System.err.println(JSON.toJSONString(res));
    }
}
