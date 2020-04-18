package cn.h.beeclub.course.biz.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.h.beeclub.course.biz.dao.CourseCategoryDao;
import cn.h.beeclub.course.biz.doamin.CourseCategoryDo;
import cn.h.beeclub.course.biz.dto.CourseCategoryDto;
import cn.h.beeclub.course.biz.service.CourseCategoryService;

@Service
public class CourseCategoryServiceImpl implements CourseCategoryService{

	@Autowired
	private CourseCategoryDao courseCategoryDao;
	@Autowired
	private Mapper mapper;
	
	@Override
	public int updateOrSave(CourseCategoryDo param) {
		if(param.getId() == null) {
			//新建
			return courseCategoryDao.create(param);
		}else {
			return courseCategoryDao.update(param);
		}
	}

	@Override
	public List<CourseCategoryDto> listByParams(Map<String, Object> params) {
		List<CourseCategoryDo> categoryDos = courseCategoryDao.listByParams(params);
		List<CourseCategoryDto> res = new ArrayList<CourseCategoryDto>();
		
		categoryDos.forEach(cate -> {
			res.add(mapper.map(cate, CourseCategoryDto.class));
		});
		return res;
	}

	@Override
	public int deleteById(Long id) {
		return courseCategoryDao.deleteById(id);
	}

	@Override
	public int updateAvailableById(Long id, Boolean available) {
		return courseCategoryDao.updateAvailableById(id, available);
	}

	@Override
	public List<CourseCategoryDto> listTopCourseCategory() {
		List<CourseCategoryDo> categoryDos = courseCategoryDao.listTopCourseCategory();
		return categoryDos.stream().map(v -> mapper.map(v, CourseCategoryDto.class)).collect(Collectors.toList());
	}


}
