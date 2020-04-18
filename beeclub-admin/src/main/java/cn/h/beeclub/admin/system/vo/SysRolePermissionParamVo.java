package cn.h.beeclub.admin.system.vo;

import java.util.List;

import lombok.Data;

@Data
public class SysRolePermissionParamVo {

	private Long roleId;
	private List<Long> resourceIds;
}
