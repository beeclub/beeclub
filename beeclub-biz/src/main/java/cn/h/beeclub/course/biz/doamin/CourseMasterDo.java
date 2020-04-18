package cn.h.beeclub.course.biz.doamin;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import cn.h.beeclub.common.base.domain.Domain.MongoDomain;
import cn.h.beeclub.common.base.entity.Pair.IdName;
import cn.h.beeclub.common.base.entity.Pair.ValueText;
import cn.h.beeclub.common.enums.CommonEnums.CourseStatus;
import cn.h.beeclub.common.enums.CommonEnums.CourseType;
import cn.h.beeclub.common.enums.CommonEnums.PeriodType;
import cn.h.beeclub.sem.biz.dto.PriceDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = CourseMasterDo.DB_COLLECTION_NAME)
public class CourseMasterDo extends MongoDomain {

	public static final String DB_COLLECTION_NAME = "course-master";

	/**
	 * 主要内容
	 */
	private String id; // 主键
	private String title; // 课程标题
	
	private String subhead;
	private String description;// 描述

	private String backgroundImage;//背景图片
	private String thumb;// 缩略图 宽高比
	private List<Integer> category; // 课程类别

	private CourseType type = CourseType.video;// 类型

	private BigDecimal duration;// 时长

	// 周期
//	private IdName<Integer, PeriodType> perid = new IdName<Integer, PeriodType>(1,PeriodType.hour);
	private Integer perid;//周期
	private PeriodType peridType = PeriodType.hour;//周期类型
	// 价格
	private PriceDto price = new PriceDto();
	private IdName<Long, String> master = new IdName<>();//讲师

	private Boolean online;
	private Date onlineTime; // 上线时间
	private Integer difficulty = 1; // 难度等级1,2,3,4,5 入门
	private List<String> tags = new ArrayList<String>();
	private CourseStatus courseStatus = CourseStatus.init;

	private Long sort;//排序

}
