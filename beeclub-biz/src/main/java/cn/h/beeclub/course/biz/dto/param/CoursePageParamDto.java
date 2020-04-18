package cn.h.beeclub.course.biz.dto.param;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Sort.Order;

import lombok.Data;

@Data
public class CoursePageParamDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8067214477426963694L;

	private Integer cateId;
	
	private List<Order> orders = new LinkedList<Order>();
}
