package cn.h.beeclub.course.biz.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import cn.h.beeclub.common.base.dto.BaseDto;
import cn.h.beeclub.common.base.entity.Pair.IdName;
import cn.h.beeclub.common.enums.CommonEnums.CourseStatus;
import cn.h.beeclub.common.enums.CommonEnums.PeriodType;
import cn.h.beeclub.sem.biz.dto.PriceDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class CourseMasterDto extends BaseDto{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3615256887044634724L;

	/**
	 * 主要内容
	 */
	private String id;                            //主键
	@NotBlank(message = "课程标题不能为空")
	private String title;                       //课程标题
	@NotBlank(message = "副标题不能为空")
	private String subhead;
	@NotBlank(message = "描述不能为空")
	private String description;//描述
	@NotBlank(message = "缩略图不能为空")
	private String thumb;//缩略图  宽高比
	@Size(min = 1, message = "课程类别必选")
	private List<Integer> category;//课程类别
	
//	private CourseType type = CourseType.video;//类型


	private BigDecimal duration;//时长
	
	private Integer perid;//周期
	private PeriodType peridType = PeriodType.hour;//周期类型
	//价格
	private PriceDto price = new PriceDto();
	
	private IdName<Long, String> master = new IdName<>();//讲师
	
	private Boolean online;
	
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date onlineTime;                    //上线时间
	private Integer difficultyLevel;            //难度等级1,2,3,4,5 入门 
	private List<String> tags = new ArrayList<String>();
	private CourseDecorationDto decoration = new CourseDecorationDto();
	private CourseStatus courseStatus = CourseStatus.init;

	private Long sort;//排序
}
