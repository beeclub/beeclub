package cn.h.beeclub.organization.biz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import cn.h.beeclub.organization.biz.domain.DepartmentDo;

public interface DepartmentDao{
	
	@Insert("insert into values()")
	int insert(DepartmentDo param);
	
	@Update("")
	int update(DepartmentDo param);
	
	@Update("")
	int updateStatus(@Param(value = "id") long id,@Param(value = "status") int status);
	
	@Delete("")
	int deleteById(@Param(value = "id") long id);
	
	@Select("select * from t_department")
	List<DepartmentDo> findAll();
	
	@Select("select * from t_department")
	List<DepartmentDo> findByParam(DepartmentDo param);
	
	@Select("select * from t_department where id = #{id}")
	DepartmentDo findById(@Param(value = "id") long id);
	
	@Select("select * from t_department where pid = #{pid}")
	List<DepartmentDo> findChildrenByPid(@Param(value = "pid") long pid);
	
	@Select("select * from t_department where pid = #{pid}")
	List<DepartmentDo> findAllByPid(@Param(value = "pid") long pid);
	
}
