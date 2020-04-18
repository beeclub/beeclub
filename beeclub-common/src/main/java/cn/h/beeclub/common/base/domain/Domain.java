package cn.h.beeclub.common.base.domain;

import java.util.Date;

import cn.h.beeclub.common.base.dto.OperationContext;
import cn.h.beeclub.common.base.entity.MetadataEntity;
import lombok.Data;

public class Domain {
	
	@Data
	public static class MongoDomain{
		private MetadataEntity metadata;
		
		public MongoDomain() {
			super();
		}
		public MongoDomain(OperationContext context) {
			if(metadata == null) {
				metadata = new MetadataEntity();
				metadata.setCreateTime(new Date());
				metadata.setCreator(context.getEmployeeId());
				metadata.setDepartmentId(context.getDepartmentId());
				metadata.setOrganizationId(context.getOrganizationId());
				metadata.setState(1);
				metadata.setVersion(0);
			}
			metadata.setModifier(context.getEmployeeId());
			metadata.setModifyTime(new Date());
			metadata.setSynchState(false);
			metadata.setVersion(metadata.getVersion() + 1);
		}
	}
	
	@Data
	public static class BaseAuthEntity{
		/**
		 * 
		 */
		private long organizationId;
		private long departmentId;
		private long creator;
		private Date createTime;
		private Date modifyTime;
		private long modifier;
	}
	
	
	@Data
	public static class BaseEntity{
		private long creator;
		private Date createTime;
		private Date modifyTime;
		private long modifier;
	}

	@Data
	public static class BaseDo{
		private boolean available;
		private long creator;
		private Date createTime;
		private Date modifyTime;
		private long modifier;
	}
}
