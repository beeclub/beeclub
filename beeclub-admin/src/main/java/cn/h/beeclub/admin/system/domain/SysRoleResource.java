package cn.h.beeclub.admin.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SysRoleResource {

	private Long id;
	private Long roleId;
	private Long resourceId;
}
