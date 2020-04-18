package cn.h.beeclub.organization.biz.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import cn.h.beeclub.common.base.domain.Domain.BaseEntity;
import cn.h.beeclub.common.enums.CommonEnums.OrganType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class OrganCommonDo extends BaseEntity{

	/**
	 * 
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	private Long pid;
	private String name;
	private OrganType type;
	private int status;
	
	public static void main(String[] args) {
	}
}
