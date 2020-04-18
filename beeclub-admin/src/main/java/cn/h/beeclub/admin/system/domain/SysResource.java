package cn.h.beeclub.admin.system.domain;

import cn.h.beeclub.common.base.entity.BaseTree;
import cn.h.beeclub.common.base.entity.BaseTreeNode;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@ApiModel(value = "权限")
@Data
@EqualsAndHashCode(callSuper=false)
public class SysResource extends BaseTree{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5160608229239134107L;
	private Long id;
	private Long pid;
	private String name;
	private Integer type;//0目录 1菜单 2按钮
	private String permission;
	private String uri;
	private String icon;
	private Integer priority;
	private Boolean available;

}
