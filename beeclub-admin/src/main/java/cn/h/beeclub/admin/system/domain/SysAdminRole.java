package cn.h.beeclub.admin.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SysAdminRole {

	private Long id;
	private Long adminId;
	private Long roleId;
}
