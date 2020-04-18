package cn.h.beeclub.organization.biz.domain;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "t_department")
public class DepartmentDo extends OrganCommonDo{
	private long organizationId;
	private String deptCode;
}
