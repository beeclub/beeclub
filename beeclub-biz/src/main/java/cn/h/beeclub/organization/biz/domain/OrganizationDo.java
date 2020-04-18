package cn.h.beeclub.organization.biz.domain;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@TableName(value = "t_organiztion")
public class OrganizationDo  extends OrganCommonDo{
	/*
	 * CREATE TABLE t_organization ( id BIGINT UNSIGNED PRIMARY KEY auto_increment
	 * COMMENT '主键ID', pid BIGINT UNSIGNED default 0 COMMENT '上级主键ID', `name`
	 * VARCHAR(16) COMMENT '姓名', type VARCHAR(10) COMMENT '类型', `status` TINYINT(1)
	 * DEFAULT 0 COMMENT '状态', creator BIGINT UNSIGNED COMMENT '创建者', modifier
	 * BIGINT UNSIGNED COMMENT '修改者', create_time datetime DEFAULT now() COMMENT
	 * '创建时间', modify_time datetime DEFAULT now() COMMENT '修改时间' ) COMMENT = '机构表';
	 */
	private String organCode;
}
