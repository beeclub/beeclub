package cn.h.beeclub.course.biz.doamin;

import lombok.Data;

/**
 * 课程类别
 * @description 
 * @author hao.huang
 * @date 2019年11月19日
 */
@Data
public class CourseCategoryDo{
	
	private String id;
	private String pid;
	private String name;
	private Integer priority;
	private boolean available;
	private String remark;

}
