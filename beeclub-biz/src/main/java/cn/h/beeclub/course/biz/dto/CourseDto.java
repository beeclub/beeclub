package cn.h.beeclub.course.biz.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class CourseDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3312549911174990365L;
	private Long id; // 主键
	private String code; // 课程代码
	private String title; // 课程标题
	private String subhead; // 课程副标题
	private String directionCode; // 课程方向
	private String categoryCode; // 课程类别
	private String lecturerCode; // 讲师
	private BigDecimal originPrice; // 原始价格
	private BigDecimal disacountPrice; // 原始价格
	private Boolean free; // 是否免费
	private Integer type; // 类型1 专项课程 2系列课程
	private BigDecimal duration; // 时长
	private Long studyCount; // 学习人数
	private Date onlineTime; // 上线时间
	private BigDecimal favorableRate; // 好评率
	private Integer difficultyLevel; // 难度等级1,2,3,4,5 入门
	private Integer status; // 状态1有效0无效
	private Date createTime; // 插入时间
	private Date modifiedTime; // 修改时间
}
