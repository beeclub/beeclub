package cn.h.beeclub.organization.biz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.h.beeclub.organization.biz.domain.OrganizationDo;

public interface OrganizationDao {
	
	int insert(OrganizationDo param);
	
	@Update("")
	int update(OrganizationDo param);
	
	@Update("")
	int updateStatus(@Param(value = "id") long id,@Param(value = "status") int status);
	
	@Delete("")
	int deleteById(@Param(value = "id") long id);
	
	@Select("select * from t_organization")
	List<OrganizationDo> findAll();
	
	@Select("select * from t_organization")
	List<OrganizationDo> findByParam(OrganizationDo param);
	
	@Select("select * from t_organization where id = #{id}")
	OrganizationDo findById(@Param(value = "id") long id);
	
	@Select("select * from t_organization where pid = #{pid}")
	List<OrganizationDo> findChildrenByPid(@Param(value = "pid") long pid);
	
	@Select("select * from t_organization where pid = #{pid}")
	List<OrganizationDo> findAllByPid(@Param(value = "pid") long pid);
	
}
