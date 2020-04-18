

DROP TABLE IF EXISTS t_sys_user;
create table t_sys_user(
	id BIGINT UNSIGNED PRIMARY KEY auto_increment COMMENT '主键ID',
	username VARCHAR(11) NOT NULL COMMENT '用户名',
	`password` varchar(64) NOT NULL COMMENT '密码',
  slat VARCHAR(50) NOT NULL COMMENT '盐',
  `name` VARCHAR(32) NOT null COMMENT '姓名',
	locked boolean not null DEFAULT FALSE COMMENT '是否锁定',
 UNIQUE unq_username(username)
) COMMENT = "后台用户表";


DROP TABLE IF EXISTS t_sys_resource;
create table t_sys_resource(
	id BIGINT UNSIGNED PRIMARY KEY auto_increment COMMENT '主键ID',
  pid BIGINT UNSIGNED DEFAULT 0 COMMENT '上级资源Id',
	`name` VARCHAR(100) NOT null COMMENT '资源名称',
	type VARCHAR(50) NOT NULL COMMENT '资源类型',
  priority int UNSIGNED DEFAULT 0 COMMENT '显示顺序',
  permission VARCHAR(100) COMMENT '权限字符串',
	available boolean not null DEFAULT FALSE COMMENT '是否可用'
) COMMENT = "后台资源表";



DROP TABLE IF EXISTS t_sys_role;
create table t_sys_role(
	id BIGINT UNSIGNED PRIMARY KEY auto_increment COMMENT '主键ID',
	`name` VARCHAR(100) NOT null COMMENT '角色名称',
	description VARCHAR(100) NOT NULL COMMENT '角色描述',
	available boolean not null DEFAULT FALSE COMMENT '是否可用'
) COMMENT = "后台角色表";


DROP TABLE IF EXISTS t_sys_user_role;
create table t_sys_user_role(
	id BIGINT UNSIGNED PRIMARY KEY auto_increment COMMENT '主键ID',
  user_id BIGINT UNSIGNED NOT NULL COMMENT '用户id',
  role_id BIGINT UNSIGNED NOT NULL COMMENT '角色id',
	UNIQUE unq_com(user_id, role_id),
	INDEX ind_role_id(role_id)
) COMMENT = "后台用户角色关系表";


DROP TABLE IF EXISTS t_sys_role_resource;
create table t_sys_role_resource(
	id BIGINT UNSIGNED PRIMARY KEY auto_increment COMMENT '主键ID',
  role_id BIGINT UNSIGNED NOT NULL COMMENT '角色id',
	resource_id BIGINT UNSIGNED NOT NULL COMMENT '资源id',
	UNIQUE unq_com(role_id, resource_id),
	INDEX ind_resource_id(resource_id)
) COMMENT = "后台角色资源关系表";






