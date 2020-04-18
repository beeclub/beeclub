package cn.h.beeclub.course.biz.dto;

import cn.h.beeclub.common.base.entity.BaseTree;
import cn.h.beeclub.common.base.entity.TreeNode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 课程类别
 * @description 
 * @author hao.huang
 * @date 2019年11月19日
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CourseCategoryDto extends TreeNode<Long, CourseCategoryDto>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -474654316541114440L;
	private String name;
	private Integer priority;
	private boolean available;
	private String remark;

}
