package cn.h.beeclub.organization.biz.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.mongodb.repository.Query;

import cn.h.beeclub.organization.biz.domain.EmployeeDo;

public interface EmployeeDao {
	
	@Insert("insert into t_employee() values()")
	int insert(EmployeeDo param);
	
	@Update("")
	int update(EmployeeDo param);
	
	@Update("")
	int updateStatus(@Param(value = "id") long id,@Param(value = "status") int status);
	
	@Delete("")
	int deleteById(@Param(value = "id") long id);
	
	@Select("select * from t_employee")
	List<EmployeeDo> findAll();
	
	@Select("select * from t_employee")
	List<EmployeeDo> findByParam(EmployeeDo param);
	
	@Select("select * from t_employee where id = #{id}")
	EmployeeDo findById(@Param(value = "id") long id);
	
}
