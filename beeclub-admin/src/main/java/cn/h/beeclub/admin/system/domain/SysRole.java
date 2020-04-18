package cn.h.beeclub.admin.system.domain;

import lombok.Data;

@Data
public class SysRole {
	private Long id;
	private String name;
	private String description;
	private Boolean available;
}
