package cn.h.beeclub.admin.system.dao;


import cn.h.beeclub.admin.system.domain.SysAdmin;
import cn.h.beeclub.admin.system.entity.IdAvailableEntity;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.session.RowBounds;

/**
 *
 */
public interface SysAdminDao {

    @Select("select * from t_sys_admin where mobile = #{mobile}")
    SysAdmin getSysAdminByMobile(@Param("mobile") String mobile);

    @Insert("INSERT INTO t_sys_admin ( mobile, `password`,name, icon, email, note, create_time, available) VALUES ( #{mobile}, #{password},#{name}, #{icon, jdbcType=VARCHAR},#{email, jdbcType=VARCHAR},#{note, jdbcType=VARCHAR}, NOW(),true)")
    int createAdmin(SysAdmin admin);

    @Select("select * from t_sys_admin order by id")
    List<SysAdmin> pageSysAdmin(RowBounds rowBounds);

    
    @Select("select * from t_sys_admin order by id")
    List<SysAdmin> pageSysAdmin2();
    
    @Update("update  t_sys_admin set login_time = NOW() where id = #{id}")
    int updateLoginTime(@Param("id") Long id);

    @Update("update  t_sys_admin set available = #{available} where id = #{id}")
	int switchAvailable(IdAvailableEntity param);
}
