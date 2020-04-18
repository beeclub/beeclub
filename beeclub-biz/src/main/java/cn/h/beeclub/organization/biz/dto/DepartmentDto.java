package cn.h.beeclub.organization.biz.dto;

import cn.h.beeclub.common.base.entity.TreeNode;
import cn.h.beeclub.common.enums.CommonEnums.OrganType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class DepartmentDto extends TreeNode<Long, DepartmentDto>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6065483156664085994L;
	private String name;
	private OrganType type;
}
