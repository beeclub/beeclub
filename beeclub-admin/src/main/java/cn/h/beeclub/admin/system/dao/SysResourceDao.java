package cn.h.beeclub.admin.system.dao;

import org.apache.ibatis.annotations.Update;

import cn.h.beeclub.admin.system.entity.IdAvailableEntity;

public interface SysResourceDao {

	@Update("update t_sys_resource set available = #{available} where id = #{id}")
	int updateAvailableById(IdAvailableEntity param);
}
