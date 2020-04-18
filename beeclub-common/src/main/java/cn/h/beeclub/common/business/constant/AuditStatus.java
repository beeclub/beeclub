package cn.h.beeclub.common.business.constant;

public enum AuditStatus {

	init("init", "提交审核"),auditing("auditing", "提交审核"),pass("pass","通过"), noPass("noPass","不通过");
	
	private String type;
	private String name;
	
	AuditStatus(String type, String name){
		this.type = type;
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}
	
}
