package cn.h.beeclub.admin.system.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.h.beeclub.admin.system.domain.SysAdminRole;
import cn.h.beeclub.admin.system.domain.SysRole;
import cn.h.beeclub.admin.system.entity.IdAvailableEntity;

public interface SysRoleDao {

	@Select("select * from t_sys_role where available = #{available}")
	List<SysRole> listRolesByAvailable(@Param("available") boolean available);
	
	@Delete("delete from t_sys_admin_role where admin_id = #{adminId}")
	int deleteAdminRoleByAdminId(@Param("adminId") Long adminId);
	
	@Insert("insert into t_sys_admin_role(admin_id, role_id) values (#{adminId}, #{roleId})")
	int insertAdminRole(SysAdminRole userRole);
	
	@Select("select r.id from t_sys_admin a, t_sys_admin_role ar, t_sys_role r where a.id = ar.admin_id AND ar.role_id = r.id AND r.available = TRUE AND a.id = #{adminId}")
	List<Long> getSysRoleIdsByAdminId(@Param("adminId") Long adminId);

	@Update("update  t_sys_role set available = #{available} where id = #{id}")
	int switchAvailable(IdAvailableEntity param);
}
