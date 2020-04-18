package cn.h.beeclub.core.base;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao {

    
    private SqlSessionTemplate sessionTemplate;
    
    @Autowired
	public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
		this.sessionTemplate = sessionTemplate;
	}

    public int update(String statement, Object param) {
    	return sessionTemplate.update(statement, param);
    }
    
    public int update(String statement) {
    	return sessionTemplate.update(statement);
    }
    
    
    public int insert(String statement, Object param) {
    	return sessionTemplate.insert(statement, param);
    }
    
    public int insert(String statement) {
    	return sessionTemplate.insert(statement);
    }
    
    public int delete(String statement, Object param) {
    	return sessionTemplate.delete(statement, param);
    }
    
    public int delete(String statement) {
    	return sessionTemplate.delete(statement);
    }

	public <T> T getOne(String statement, Object param) {
		return sessionTemplate.selectOne(statement, param);
	}
	
	public <T> T getOne(String statement) {
		return sessionTemplate.selectOne(statement);
	}
    
	public <T> List<T> list(String statement, Object param) {
		return sessionTemplate.selectList(statement, param);
	}
	
	public <T> List<T> list(String statement) {
		return sessionTemplate.selectList(statement);
	}
	
	public <T> List<T> Page(String statement, Object param, RowBounds rowBounds) {
		return sessionTemplate.selectList(statement, param ,rowBounds);
	}
	
}
