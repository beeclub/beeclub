package cn.h.beeclub.admin.system.vo;

import java.util.List;

import lombok.Data;

@Data
public class SysAdminRolesParamVo {

	private Long adminId;
	private List<Long> roleIds;
}
