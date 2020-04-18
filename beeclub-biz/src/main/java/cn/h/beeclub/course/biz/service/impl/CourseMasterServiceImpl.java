package cn.h.beeclub.course.biz.service.impl;

import cn.h.beeclub.common.base.dto.OperationContext;
import cn.h.beeclub.common.base.page.PageParam;
import cn.h.beeclub.common.base.result.PageResult;
import cn.h.beeclub.common.enums.CommonEnums.CourseStatus;
import cn.h.beeclub.common.util.ids.SnowflakeIdWorker;
import cn.h.beeclub.core.common.MongoConfig.BeeClubCollection;
import cn.h.beeclub.course.biz.doamin.CourseDecorationDo;
import cn.h.beeclub.course.biz.doamin.CourseMasterDo;
import cn.h.beeclub.course.biz.dto.CourseDecorationDto;
import cn.h.beeclub.course.biz.dto.CourseDto;
import cn.h.beeclub.course.biz.dto.CourseMasterDto;
import cn.h.beeclub.course.biz.dto.base.AutitDto;
import cn.h.beeclub.course.biz.dto.param.CoursePageParamDto;
import cn.h.beeclub.course.biz.service.CourseMasterService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.joran.conditional.Condition;

/**
 * 
 * @description 
 * @author hao.huang
 * @date 2019年8月23日
 */
@Service
public class CourseMasterServiceImpl implements CourseMasterService {

	@Autowired
	private MongoTemplate mongotemplate;
	
	@Autowired
	private Mapper mapper;
	
	/**
	 * id 1 1
	 */
	private SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);

	@Override
	public void init(CourseMasterDto courseMaster) {
		/**
		 * 
		 */
		if(StringUtils.isBlank(courseMaster.getId())) {
			courseMaster.setId(String.valueOf(idWorker.nextId()));
		}
		CourseMasterDo courseMasterDo = mapper.map(courseMaster, CourseMasterDo.class);
		mongotemplate.save(courseMasterDo, CourseMasterDo.DB_COLLECTION_NAME);
		CourseDecorationDto decoration = courseMaster.getDecoration();
		if(decoration == null) {
			decoration = new CourseDecorationDto();
		}
		CourseDecorationDo courseDecorationDo = mapper.map(decoration, CourseDecorationDo.class);
		courseDecorationDo.setId(courseMasterDo.getId());
		mongotemplate.save(courseDecorationDo, CourseDecorationDo.DB_COLLECTION_NAME);
		
	}

	@Override
	public void changeStatus(OperationContext context, long id, CourseStatus status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CourseMasterDto courseMaster) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CourseMasterDto> findAllCourse(OperationContext context) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CourseMasterDto findCourseMaster(String id) {
		CourseMasterDto courseMaster = mongotemplate.findById(id, CourseMasterDto.class, CourseMasterDo.DB_COLLECTION_NAME);
		if(courseMaster == null) {
			return null;
		}
		CourseDecorationDto decoration = mongotemplate.findById(id, CourseDecorationDto.class, CourseDecorationDo.DB_COLLECTION_NAME);
		courseMaster.setDecoration(decoration);
		return courseMaster;
	}

	@Override
	public PageResult<CourseMasterDto> page(PageParam pageParam) {
//		Criteria criteria = new 
		Query query = new Query();
		query.skip(pageParam.getSkip()).limit(pageParam.getSize());
		long cout = mongotemplate.count(query, CourseMasterDo.DB_COLLECTION_NAME);
		List<CourseMasterDto> resList = mongotemplate.find(query, CourseMasterDto.class, CourseMasterDo.DB_COLLECTION_NAME);
		PageResult<CourseMasterDto> res = new PageResult<CourseMasterDto>(cout, resList);
		return res;
	}

	@Override
	public PageImpl<CourseMasterDto> fontCoursePage(Pageable pageable, CoursePageParamDto param) {
		Criteria criteria = new Criteria();
		if(param.getCateId() != null) {
			criteria.and("category").is(param.getCateId());
		}
		Query query = new Query(criteria);
		long count = mongotemplate.count(query, CourseMasterDo.DB_COLLECTION_NAME);
		List<Order> orders = new ArrayList<Sort.Order>();
		if(param.getOrders() != null && !param.getOrders().isEmpty()) {
			query.with(Sort.by(orders));
		}
		query.with(pageable);
		List<CourseMasterDto> resList = mongotemplate.find(query, CourseMasterDto.class, CourseMasterDo.DB_COLLECTION_NAME);
		PageImpl<CourseMasterDto> resPage = new PageImpl<>(resList, pageable, count);
		return resPage;
	}

	@Override
	public List<CourseMasterDto> findCoursesByIds(List<String> ids) {
		Criteria criteria = Criteria.where("_id").in(ids);

        List<CourseMasterDo> courseMasterDos = mongotemplate.find(Query.query(criteria), CourseMasterDo.class, CourseMasterDo.DB_COLLECTION_NAME);

        return courseMasterDos.stream().map(v -> mapper.map(v, CourseMasterDto.class)).collect(Collectors.toList());
	}
}
