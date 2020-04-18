package cn.h.beeclub.core.base;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.h.beeclub.common.base.entity.LogEntity;

@Service
public class BaseService {

    
    private BaseDao baseDao;

    @Autowired
    public void setBaseDao(BaseDao baseDao) {
		this.baseDao = baseDao;
	}

    @Transactional
	public int update(String statement, Object param) {
    	return baseDao.update(statement, param);
    }
    
    @Transactional
    public int update(String statement) {
    	return baseDao.update(statement);
    }
    
    @Transactional
    public int insert(String statement, Object param) {
    	return baseDao.insert(statement, param);
    }
    
    @Transactional
    public int insert(String statement) {
    	return baseDao.insert(statement);
    }
    
    @Transactional
    public int delete(String statement, Object param) {
    	return baseDao.delete(statement, param);
    }
    
    @Transactional
    public int delete(String statement) {
    	return baseDao.delete(statement);
    }

	public <T> T getOne(String statement, Object param) {
		return baseDao.getOne(statement, param);
	}
	
	public <T> T getOne(String statement) {
		return baseDao.getOne(statement);
	}
    
	public <T> List<T> list(String statement, Object param) {
		return baseDao.list(statement, param);
	}
	
	public <T> List<T> list(String statement) {
		return baseDao.list(statement);
	}
	
	public <T> List<T> page(String statement, Object param, RowBounds rowBounds) {
		return baseDao.Page(statement, param ,rowBounds);
	}
	
	public void insertLog(LogEntity log) {
		
	};
}
