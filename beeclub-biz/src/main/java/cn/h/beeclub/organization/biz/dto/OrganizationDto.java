package cn.h.beeclub.organization.biz.dto;

import cn.h.beeclub.common.base.entity.TreeNode;
import cn.h.beeclub.common.enums.CommonEnums.OrganType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OrganizationDto  extends TreeNode<Long,OrganizationDto>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 401860688309903464L;
	private String name;
	private OrganType type;
}
