/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : beeclub

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 31/03/2020 21:51:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_course_category
-- ----------------------------
DROP TABLE IF EXISTS `t_course_category`;
CREATE TABLE `t_course_category`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `pid` int(10) NULL DEFAULT 0 COMMENT '上级id',
  `priority` int(4) NULL DEFAULT 1 COMMENT '排序',
  `available` tinyint(1) NOT NULL DEFAULT 1 COMMENT '状态1有效0无效',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程表类别' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_course_category
-- ----------------------------
INSERT INTO `t_course_category` VALUES (19, 'IT互联网', 0, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (20, '编程语言', 19, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (21, 'C', 20, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (22, 'PHP', 20, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (23, 'Python', 20, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (24, 'C++', 20, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (25, 'Java', 20, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (26, 'Linux', 20, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (27, '互联网运营', 19, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (28, '淘宝运营', 27, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (29, '新媒体运营', 27, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (30, 'SEO', 27, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (31, 'SEM', 27, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (32, '网络营销', 27, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (33, '天猫运营', 27, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (34, '营销实战', 27, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (35, '前端开发', 19, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (36, 'JavaScript', 35, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (37, 'DIV', 35, 1, 1, '');
INSERT INTO `t_course_category` VALUES (38, '移动开发', 19, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (39, 'android', 38, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (40, 'iOS', 38, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (41, '游戏开发', 19, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (42, 'Cocos2d-x游戏开发', 41, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (43, 'Unity3d游戏开发', 41, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (44, '云计算大数据', 19, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (45, '大数据', 44, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (46, '区块链', 44, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (47, '人工智能', 44, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (48, '设计创作', 0, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (49, '视觉设计', 48, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (50, '平面设计', 49, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (51, 'Photoshop', 49, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (52, 'UI设计', 49, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (53, '形象设计', 49, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (54, '服装设计', 49, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (55, '淘宝美工', 49, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (56, '游戏动漫', 48, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (57, '游戏模型', 56, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (58, '插画', 56, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (59, '游戏原画', 56, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (60, '摄影', 48, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (61, '影视后期', 60, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (62, '影视特效', 61, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (63, '摄影拍摄', 60, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (64, '后期修图', 60, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (65, '环境艺术', 48, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (66, '室内设计', 65, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (67, '建筑设计', 65, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (68, '实用外语', 0, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (69, '英语', 68, 1, 1, NULL);
INSERT INTO `t_course_category` VALUES (70, '兴趣艺术', 0, 1, 1, NULL);

-- ----------------------------
-- Table structure for t_course_main
-- ----------------------------
DROP TABLE IF EXISTS `t_course_main`;
CREATE TABLE `t_course_main`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程代码',
  `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程标题',
  `subhead` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程副标题',
  `direction_code` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程方向',
  `category_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '课程类别',
  `lecturer_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '讲师',
  `origin_price` decimal(8, 2) NOT NULL DEFAULT 0.00 COMMENT '原始价格',
  `disacount_price` decimal(8, 2) NULL DEFAULT NULL COMMENT '原始价格',
  `free` tinyint(3) NULL DEFAULT 1 COMMENT '1免费 2收费 ',
  `type` tinyint(3) NULL DEFAULT 1 COMMENT '类型1 专项课程 2系列课程 ',
  `duration` decimal(8, 2) NOT NULL DEFAULT 1.00 COMMENT '时长',
  `study_count` int(11) NOT NULL DEFAULT 0 COMMENT '学习人数',
  `online_time` datetime(0) NOT NULL COMMENT '上线时间',
  `favorable_rate` decimal(8, 2) NOT NULL DEFAULT 100.00 COMMENT '好评率',
  `difficulty_level` tinyint(3) NOT NULL DEFAULT 1 COMMENT '难度等级1,2,3,4,5 入门 初级 中级 高级',
  `status` tinyint(3) NOT NULL DEFAULT 1 COMMENT '状态1有效0无效',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '插入时间',
  `modified_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '插入时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uk_code`(`code`) USING BTREE,
  INDEX `idx_code`(`code`) USING BTREE,
  INDEX `idx_lecturer_code`(`lecturer_code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '课程主表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `pid` bigint(20) UNSIGNED NULL DEFAULT 0 COMMENT '上级主键ID',
  `dept_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'diam',
  `organization_id` bigint(20) UNSIGNED NULL DEFAULT 0 COMMENT '机构ID',
  `name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '类型',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '状态',
  `creator` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '创建者',
  `modifier` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '修改者',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '组织表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES (1, 0, '0001-00', 2, '总监部', 'department', 1, 0, 0, '2019-11-29 21:00:31', '2019-11-29 21:00:31');
INSERT INTO `t_department` VALUES (2, 1, '0001-01', 2, '布道组', 'group', 1, 0, 0, '2019-11-30 22:07:44', '2019-11-30 22:07:44');

-- ----------------------------
-- Table structure for t_dict_category
-- ----------------------------
DROP TABLE IF EXISTS `t_dict_category`;
CREATE TABLE `t_dict_category`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '代码',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `available` tinyint(1) NULL DEFAULT 1 COMMENT '状态',
  `src_sql` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'sql',
  `creator` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modifier` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `modify_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `code`(`code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典类别表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_dict_category
-- ----------------------------
INSERT INTO `t_dict_category` VALUES (1, 'gender', '性别', 1, NULL, '1', '2019-12-18 01:12:12', '1', '2019-12-18 01:12:12');

-- ----------------------------
-- Table structure for t_dict_item
-- ----------------------------
DROP TABLE IF EXISTS `t_dict_item`;
CREATE TABLE `t_dict_item`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `cate_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '字典类型',
  `code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '值',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '名称',
  `label` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '标签',
  `available` tinyint(1) NULL DEFAULT 1 COMMENT '状态',
  `sort` int(11) NULL DEFAULT 0 COMMENT '排序',
  `defaulted` tinyint(1) NULL DEFAULT 0 COMMENT '是否默认',
  `creator` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modifier` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `modify_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `code`(`cate_code`, `code`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典子类表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_employee
-- ----------------------------
DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE `t_employee`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `emp_code` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '员工号',
  `organization_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '机构id',
  `department_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '部门id',
  `creator` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '创建者',
  `modifier` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '修改者',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '员工表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_member
-- ----------------------------
DROP TABLE IF EXISTS `t_member`;
CREATE TABLE `t_member`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `account` char(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电子邮件',
  `password` char(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `salt` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐',
  `type` tinyint(3) NULL DEFAULT 1,
  `register_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '注册时间',
  `mobile` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `nickname` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birthday` date NULL DEFAULT NULL COMMENT '生日',
  `head_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '常用邮箱',
  `industry` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产业',
  `profession` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职业',
  `signature` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '个性签名',
  `wechat` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unq_email`(`account`) USING BTREE,
  UNIQUE INDEX `uk_mobile`(`mobile`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_member
-- ----------------------------
INSERT INTO `t_member` VALUES (3, '1570356753@qq.com', '$2a$10$tr0ghz7cKRLB/apZxPkN6eYOs1oWsx3vEbYiWvipTvjSNP5yMs8ni', NULL, 1, '2019-08-24 12:07:28', NULL, '1570356753@qq.com', NULL, 'https://res-static.shiguangkey.com/file/udb/user/20190113/20/20190113204225606654065.jpg', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `t_member` VALUES (4, '1@qq.com', '$2a$10$5olYe4Q9F9NrcsSuQ4MQDusdjGGI0I2lq/agMWPr6M4sxB1AAabNC', NULL, 1, '2019-09-27 14:27:09', NULL, '1@qq.com', NULL, 'https://res-static.shiguangkey.com/file/udb/user/20190113/20/20190113204225606654065.jpg', NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '流水号',
  `type` tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '订单类型',
  `user_id` bigint(20) UNSIGNED NOT NULL COMMENT '用户ID',
  `amount` decimal(10, 2) UNSIGNED NOT NULL COMMENT '订单总额',
  `payment_type` tinyint(3) UNSIGNED NOT NULL COMMENT '支付方式 1借记卡2信用卡3微信4支付宝5现金',
  `status` tinyint(3) UNSIGNED NOT NULL COMMENT '订单状态 1未付款 2 已付款 3已发货 4已签收',
  `postage` decimal(10, 2) UNSIGNED NULL DEFAULT NULL COMMENT '邮费',
  `weight` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '重量(克)',
  `voucher_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '购物券ID',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unq_code`(`code`) USING BTREE,
  INDEX `idx_code`(`code`) USING BTREE,
  INDEX `idx_user_id`(`user_id`) USING BTREE,
  INDEX `idx_status`(`status`) USING BTREE,
  INDEX `idx_create_time`(`create_time`) USING BTREE,
  INDEX `idx_type`(`type`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item`  (
  `order_id` bigint(20) UNSIGNED NOT NULL COMMENT '订单号',
  `sku_id` bigint(20) UNSIGNED NOT NULL COMMENT '商品ID',
  `subject` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) UNSIGNED NOT NULL COMMENT '原价',
  `actual_price` decimal(10, 2) UNSIGNED NOT NULL COMMENT '实际购买价',
  `quantity` int(10) UNSIGNED NOT NULL COMMENT '购买数量',
  PRIMARY KEY (`order_id`, `sku_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单详情表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_organization
-- ----------------------------
DROP TABLE IF EXISTS `t_organization`;
CREATE TABLE `t_organization`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `pid` bigint(20) UNSIGNED NOT NULL DEFAULT 0 COMMENT '上级主键ID',
  `organ_code` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '机构代码',
  `name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
  `type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '类型',
  `status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '状态',
  `creator` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '创建者',
  `modifier` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '修改者',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '机构表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_organization
-- ----------------------------
INSERT INTO `t_organization` VALUES (1, 0, '0000', '小蜜蜂公司', 'company', 1, 0, 0, '2019-11-30 19:43:49', '2019-11-30 19:45:40');
INSERT INTO `t_organization` VALUES (2, 1, '0001', '小蜜蜂机构', 'organ', 0, 0, 0, '2019-11-30 21:15:52', '2019-11-30 21:15:52');

-- ----------------------------
-- Table structure for t_sem_promotion
-- ----------------------------
DROP TABLE IF EXISTS `t_sem_promotion`;
CREATE TABLE `t_sem_promotion`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '标题',
  `module` int(4) NOT NULL DEFAULT 1 COMMENT '模块 1 轮播图',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '跳转地址',
  `img` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `background_color` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `target` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '_bank' COMMENT '目标',
  `priority` int(10) UNSIGNED NULL DEFAULT 0 COMMENT '显示顺序',
  `on_sale` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否上架',
  `gmt_create` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `gmt_update` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间',
  PRIMARY KEY (`id`, `on_sale`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '营销推广表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sem_promotion
-- ----------------------------
INSERT INTO `t_sem_promotion` VALUES (1, '标题1', 1, '/course/detail.html?id=128234849969373184', 'http://beeclub.oss-cn-shanghai.aliyuncs.com/course/1577286925460.jpg?Expires=1892646922&OSSAccessKeyId=LTAI4Fv5EmuA9jMfJ79TzGdV&Signature=CYMc1WHLUyg86KqjtGVWLXiX6f8%3D', '#64B441', '_bank', 0, 1, '2019-10-22 18:44:19', '2019-10-22 18:44:19');
INSERT INTO `t_sem_promotion` VALUES (2, '标题2', 1, '/course/detail.html?id=128234849969373185', 'http://beeclub.oss-cn-shanghai.aliyuncs.com/course/1576903665894.jpg?Expires=1892263661&OSSAccessKeyId=LTAI4Fv5EmuA9jMfJ79TzGdV&Signature=ntsyVmDdiXAekGh%2FR5SMNNU6Bk4%3D', '#0037F6', '_bank', 0, 1, '2019-10-22 18:44:44', '2019-10-22 18:44:44');

-- ----------------------------
-- Table structure for t_sys_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_admin`;
CREATE TABLE `t_sys_admin`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mobile` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `avatar` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '头像',
  `email` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `note` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `available` tinyint(1) NULL DEFAULT 1 COMMENT '帐号启用状态：0->禁用；1->启用',
  `editable` tinyint(1) NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '后台用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_admin
-- ----------------------------
INSERT INTO `t_sys_admin` VALUES (1, 'admin', 'c600', '管理员', 'https://img2.mukewang.com/545865890001495702200220-100-100.jpg', NULL, NULL, '2019-08-19 18:35:18', '2020-03-24 20:36:17', 1, 0);
INSERT INTO `t_sys_admin` VALUES (2, '18761730350', 'c600', '黄浩', 'https://img2.mukewang.com/545865890001495702200220-100-100.jpg', NULL, NULL, '2019-08-19 19:05:30', '2019-10-20 07:52:42', 1, 1);
INSERT INTO `t_sys_admin` VALUES (3, '12312', '1123', NULL, NULL, NULL, NULL, NULL, NULL, 1, 1);
INSERT INTO `t_sys_admin` VALUES (4, '123', '214', NULL, NULL, NULL, NULL, NULL, NULL, 1, 1);
INSERT INTO `t_sys_admin` VALUES (5, '4132', '413', NULL, NULL, NULL, NULL, NULL, NULL, 1, 1);
INSERT INTO `t_sys_admin` VALUES (6, '3123', '442', NULL, NULL, NULL, NULL, NULL, NULL, 1, 1);
INSERT INTO `t_sys_admin` VALUES (7, '23432', '2432', NULL, NULL, NULL, NULL, NULL, NULL, 1, 1);

-- ----------------------------
-- Table structure for t_sys_admin_login_log
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_admin_login_log`;
CREATE TABLE `t_sys_admin_login_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` bigint(20) NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `ip` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `address` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `user_agent` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '浏览器登录类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '后台用户登录日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_sys_admin_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_admin_role`;
CREATE TABLE `t_sys_admin_role`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `admin_id` bigint(20) UNSIGNED NOT NULL COMMENT '用户id',
  `role_id` bigint(20) UNSIGNED NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unq_com`(`admin_id`, `role_id`) USING BTREE,
  INDEX `ind_role_id`(`role_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '后台用户角色关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_admin_role
-- ----------------------------
INSERT INTO `t_sys_admin_role` VALUES (4, 2, 1);

-- ----------------------------
-- Table structure for t_sys_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_resource`;
CREATE TABLE `t_sys_resource`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `pid` bigint(20) UNSIGNED NULL DEFAULT 0 COMMENT '上级资源Id',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '资源名称',
  `type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '资源类型',
  `permission` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限字符串',
  `uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '访问路径',
  `icon` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源图标',
  `priority` int(10) UNSIGNED NULL DEFAULT 0 COMMENT '显示顺序',
  `available` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否可用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 51 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '后台资源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_resource
-- ----------------------------
INSERT INTO `t_sys_resource` VALUES (1, 0, '首页', '1', 'dashboard', 'dashboard', 'el-icon-s-home', 1, 1);
INSERT INTO `t_sys_resource` VALUES (2, 0, '系统设置', '0', '', '', 'el-icon-setting', 2, 1);
INSERT INTO `t_sys_resource` VALUES (3, 34, '管理员管理', '1', '', 'adminManage', '', 1, 1);
INSERT INTO `t_sys_resource` VALUES (4, 34, '角色管理', '1', '', 'roleManage', '', 1, 1);
INSERT INTO `t_sys_resource` VALUES (5, 34, '权限资源', '1', '', 'resourceManage', '', 1, 1);
INSERT INTO `t_sys_resource` VALUES (6, 5, '查询', '2', 'sysResource::treeTable', 'sysResource/treeTable', '', 1, 1);
INSERT INTO `t_sys_resource` VALUES (7, 5, '新建', '2', 'sysResource::create', 'sysResource/create', '', 1, 1);
INSERT INTO `t_sys_resource` VALUES (8, 5, '修改', '2', 'sysResource::update', 'sysResource/update', '', 1, 1);
INSERT INTO `t_sys_resource` VALUES (9, 5, '删除', '2', 'sysResource::delete', 'sysResource/delete', '', 1, 1);
INSERT INTO `t_sys_resource` VALUES (10, 4, '新建', '2', 'sysRole::create', 'sysRole/create', '', 1, 1);
INSERT INTO `t_sys_resource` VALUES (11, 4, '查询', '2', 'sysRole::query', 'sysRole/query', '', 1, 1);
INSERT INTO `t_sys_resource` VALUES (12, 4, '更新', '2', 'sysRole::update', 'sysRole/update', '', 1, 1);
INSERT INTO `t_sys_resource` VALUES (13, 0, '多级菜单', '0', '', '', 'el-icon-s-help', 99, 1);
INSERT INTO `t_sys_resource` VALUES (14, 13, '二次菜单', '0', '', '', '', 1, 1);
INSERT INTO `t_sys_resource` VALUES (15, 14, '三级菜单', '0', '', 'test1', '', 1, 1);
INSERT INTO `t_sys_resource` VALUES (16, 14, '三级菜单', '1', '', 'test2', '', 1, 1);
INSERT INTO `t_sys_resource` VALUES (17, 13, '二级菜单2', '0', '', '', '', 1, 1);
INSERT INTO `t_sys_resource` VALUES (18, 17, '三级菜单21', '1', '', 'test3', '', 1, 1);
INSERT INTO `t_sys_resource` VALUES (19, 17, '三级菜单22', '1', '', 'test4', '', 1, 1);
INSERT INTO `t_sys_resource` VALUES (20, 0, '会员模块', '0', '', '', 'el-icon-s-custom', 3, 1);
INSERT INTO `t_sys_resource` VALUES (21, 20, '会员管理', '1', 'member::memberManage', 'memberManage', '', 1, 1);
INSERT INTO `t_sys_resource` VALUES (22, 20, '讲师申请', '1', 'member::lecturerApply', 'lecturerApply', '', 1, 1);
INSERT INTO `t_sys_resource` VALUES (23, 4, '分页查询', '2', 'sysRole::pageList', 'sysRole/pageList', '', 1, 1);
INSERT INTO `t_sys_resource` VALUES (24, 4, '分配权限', '2', 'sysRole::updateRolePermission', 'sysRole/updateRolePermission', '', 1, 1);
INSERT INTO `t_sys_resource` VALUES (25, 4, '删除角色', '2', 'sysRole::delete', '', '', 1, 1);
INSERT INTO `t_sys_resource` VALUES (26, 3, '查询', '2', 'sysAdmin::query', 'sysAdmin/pageList', '', 1, 1);
INSERT INTO `t_sys_resource` VALUES (27, 3, '更新管理员', '2', 'sysAdmin::update', '', '', 1, 1);
INSERT INTO `t_sys_resource` VALUES (28, 3, '分配权限', '2', 'sysAdmin::changeAdminRoles', 'sysAdmin/changeAdminRoles', '', 1, 1);
INSERT INTO `t_sys_resource` VALUES (29, 0, '课程', '0', '', '', 'el-icon-video-camera-solid', 4, 1);
INSERT INTO `t_sys_resource` VALUES (30, 44, '课程类别', '1', '', 'courseCategory', 'el-icon-menu', 1, 1);
INSERT INTO `t_sys_resource` VALUES (31, 44, '课程属性', '1', '', 'courseProperty', 'el-icon-guide', 1, 1);
INSERT INTO `t_sys_resource` VALUES (32, 44, '课程审核', '1', '', 'courseAudit', 'el-icon-s-grid', 1, 1);
INSERT INTO `t_sys_resource` VALUES (33, 44, '课程管理', '1', '', 'courseMaster', 'el-icon-s-shop', 1, 1);
INSERT INTO `t_sys_resource` VALUES (34, 2, '权限管理', '0', NULL, NULL, 'el-icon-warning', 1, 1);
INSERT INTO `t_sys_resource` VALUES (35, 2, '系统监控', '0', '', '', 'el-icon-video-camera', 1, 1);
INSERT INTO `t_sys_resource` VALUES (36, 35, '服务监控', '1', '', 'monitorService', '', 1, 1);
INSERT INTO `t_sys_resource` VALUES (37, 2, '系统管理', '0', '', '', 'el-icon-s-help', 1, 1);
INSERT INTO `t_sys_resource` VALUES (38, 37, '字典管理', '1', '', 'sysDict', '', 1, 1);
INSERT INTO `t_sys_resource` VALUES (39, 35, 'druid监控', '1', '', 'monitorDruid', '', 1, 1);
INSERT INTO `t_sys_resource` VALUES (40, 15, '四级菜单', '1', NULL, 'test55', NULL, 1, 1);
INSERT INTO `t_sys_resource` VALUES (41, 0, '营销模块', '0', NULL, NULL, 'el-icon-s-marketing', 5, 1);
INSERT INTO `t_sys_resource` VALUES (42, 41, '推广', '0', '', '', 'el-icon-s-promotion', 1, 1);
INSERT INTO `t_sys_resource` VALUES (43, 42, '推广管理', '1', NULL, 'promotionManage', NULL, 1, 1);
INSERT INTO `t_sys_resource` VALUES (44, 29, '课程中心', '0', '', '', 'el-icon-s-shop', 1, 1);
INSERT INTO `t_sys_resource` VALUES (45, 29, '讲师课程', '0', '', '', 'el-icon-suitcase-1', 1, 1);
INSERT INTO `t_sys_resource` VALUES (46, 45, '讲师课程管理', '1', NULL, 'lecturerCourse', NULL, 1, 1);
INSERT INTO `t_sys_resource` VALUES (47, 45, '课程编辑', '1', '', 'lecturerCourseEdit', '', 1, 0);
INSERT INTO `t_sys_resource` VALUES (48, 2, '机构管理', '0', '', '', 'el-icon-takeaway-box', 1, 1);
INSERT INTO `t_sys_resource` VALUES (49, 48, '组织管理', '1', '', 'organization', 'el-icon-place', 1, 1);
INSERT INTO `t_sys_resource` VALUES (50, 48, '员工管理', '1', NULL, 'employee', 'el-icon-user', 1, 1);

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `description` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色描述',
  `available` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否可用',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '后台角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES (1, '管理员', '管理员权限 与ADMIN相同，数据权限不一样', 1);
INSERT INTO `t_sys_role` VALUES (7, '5', '5', 0);
INSERT INTO `t_sys_role` VALUES (8, '7', '7', 1);
INSERT INTO `t_sys_role` VALUES (9, '8', '8', 1);
INSERT INTO `t_sys_role` VALUES (10, '9', '9', 1);
INSERT INTO `t_sys_role` VALUES (11, '10', '10', 1);
INSERT INTO `t_sys_role` VALUES (12, '11', '11', 1);
INSERT INTO `t_sys_role` VALUES (13, '12', '12', 1);
INSERT INTO `t_sys_role` VALUES (14, '123', '123', 1);
INSERT INTO `t_sys_role` VALUES (15, '44', '24', 1);
INSERT INTO `t_sys_role` VALUES (16, '55', '55', 1);

-- ----------------------------
-- Table structure for t_sys_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_resource`;
CREATE TABLE `t_sys_role_resource`  (
  `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `role_id` bigint(20) UNSIGNED NOT NULL COMMENT '角色id',
  `resource_id` bigint(20) UNSIGNED NOT NULL COMMENT '资源id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `unq_com`(`role_id`, `resource_id`) USING BTREE,
  INDEX `ind_resource_id`(`resource_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 118 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '后台角色资源关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_role_resource
-- ----------------------------
INSERT INTO `t_sys_role_resource` VALUES (36, 1, 1);
INSERT INTO `t_sys_role_resource` VALUES (37, 1, 2);
INSERT INTO `t_sys_role_resource` VALUES (38, 1, 3);
INSERT INTO `t_sys_role_resource` VALUES (42, 1, 4);
INSERT INTO `t_sys_role_resource` VALUES (49, 1, 5);
INSERT INTO `t_sys_role_resource` VALUES (50, 1, 6);
INSERT INTO `t_sys_role_resource` VALUES (51, 1, 7);
INSERT INTO `t_sys_role_resource` VALUES (52, 1, 8);
INSERT INTO `t_sys_role_resource` VALUES (53, 1, 9);
INSERT INTO `t_sys_role_resource` VALUES (43, 1, 10);
INSERT INTO `t_sys_role_resource` VALUES (44, 1, 11);
INSERT INTO `t_sys_role_resource` VALUES (45, 1, 12);
INSERT INTO `t_sys_role_resource` VALUES (62, 1, 13);
INSERT INTO `t_sys_role_resource` VALUES (63, 1, 14);
INSERT INTO `t_sys_role_resource` VALUES (64, 1, 15);
INSERT INTO `t_sys_role_resource` VALUES (65, 1, 16);
INSERT INTO `t_sys_role_resource` VALUES (66, 1, 17);
INSERT INTO `t_sys_role_resource` VALUES (67, 1, 18);
INSERT INTO `t_sys_role_resource` VALUES (68, 1, 19);
INSERT INTO `t_sys_role_resource` VALUES (54, 1, 20);
INSERT INTO `t_sys_role_resource` VALUES (55, 1, 21);
INSERT INTO `t_sys_role_resource` VALUES (56, 1, 22);
INSERT INTO `t_sys_role_resource` VALUES (46, 1, 23);
INSERT INTO `t_sys_role_resource` VALUES (47, 1, 24);
INSERT INTO `t_sys_role_resource` VALUES (48, 1, 25);
INSERT INTO `t_sys_role_resource` VALUES (39, 1, 26);
INSERT INTO `t_sys_role_resource` VALUES (40, 1, 27);
INSERT INTO `t_sys_role_resource` VALUES (41, 1, 28);
INSERT INTO `t_sys_role_resource` VALUES (57, 1, 29);
INSERT INTO `t_sys_role_resource` VALUES (58, 1, 30);
INSERT INTO `t_sys_role_resource` VALUES (59, 1, 31);
INSERT INTO `t_sys_role_resource` VALUES (60, 1, 32);
INSERT INTO `t_sys_role_resource` VALUES (61, 1, 33);
INSERT INTO `t_sys_role_resource` VALUES (69, 16, 1);
INSERT INTO `t_sys_role_resource` VALUES (70, 16, 2);
INSERT INTO `t_sys_role_resource` VALUES (72, 16, 3);
INSERT INTO `t_sys_role_resource` VALUES (76, 16, 4);
INSERT INTO `t_sys_role_resource` VALUES (83, 16, 5);
INSERT INTO `t_sys_role_resource` VALUES (84, 16, 6);
INSERT INTO `t_sys_role_resource` VALUES (85, 16, 7);
INSERT INTO `t_sys_role_resource` VALUES (86, 16, 8);
INSERT INTO `t_sys_role_resource` VALUES (87, 16, 9);
INSERT INTO `t_sys_role_resource` VALUES (77, 16, 10);
INSERT INTO `t_sys_role_resource` VALUES (78, 16, 11);
INSERT INTO `t_sys_role_resource` VALUES (79, 16, 12);
INSERT INTO `t_sys_role_resource` VALUES (110, 16, 13);
INSERT INTO `t_sys_role_resource` VALUES (111, 16, 14);
INSERT INTO `t_sys_role_resource` VALUES (112, 16, 15);
INSERT INTO `t_sys_role_resource` VALUES (114, 16, 16);
INSERT INTO `t_sys_role_resource` VALUES (115, 16, 17);
INSERT INTO `t_sys_role_resource` VALUES (116, 16, 18);
INSERT INTO `t_sys_role_resource` VALUES (117, 16, 19);
INSERT INTO `t_sys_role_resource` VALUES (96, 16, 20);
INSERT INTO `t_sys_role_resource` VALUES (97, 16, 21);
INSERT INTO `t_sys_role_resource` VALUES (98, 16, 22);
INSERT INTO `t_sys_role_resource` VALUES (80, 16, 23);
INSERT INTO `t_sys_role_resource` VALUES (81, 16, 24);
INSERT INTO `t_sys_role_resource` VALUES (82, 16, 25);
INSERT INTO `t_sys_role_resource` VALUES (73, 16, 26);
INSERT INTO `t_sys_role_resource` VALUES (74, 16, 27);
INSERT INTO `t_sys_role_resource` VALUES (75, 16, 28);
INSERT INTO `t_sys_role_resource` VALUES (99, 16, 29);
INSERT INTO `t_sys_role_resource` VALUES (101, 16, 30);
INSERT INTO `t_sys_role_resource` VALUES (102, 16, 31);
INSERT INTO `t_sys_role_resource` VALUES (103, 16, 32);
INSERT INTO `t_sys_role_resource` VALUES (104, 16, 33);
INSERT INTO `t_sys_role_resource` VALUES (71, 16, 34);
INSERT INTO `t_sys_role_resource` VALUES (88, 16, 35);
INSERT INTO `t_sys_role_resource` VALUES (89, 16, 36);
INSERT INTO `t_sys_role_resource` VALUES (91, 16, 37);
INSERT INTO `t_sys_role_resource` VALUES (92, 16, 38);
INSERT INTO `t_sys_role_resource` VALUES (90, 16, 39);
INSERT INTO `t_sys_role_resource` VALUES (113, 16, 40);
INSERT INTO `t_sys_role_resource` VALUES (107, 16, 41);
INSERT INTO `t_sys_role_resource` VALUES (108, 16, 42);
INSERT INTO `t_sys_role_resource` VALUES (109, 16, 43);
INSERT INTO `t_sys_role_resource` VALUES (100, 16, 44);
INSERT INTO `t_sys_role_resource` VALUES (105, 16, 45);
INSERT INTO `t_sys_role_resource` VALUES (106, 16, 46);
INSERT INTO `t_sys_role_resource` VALUES (93, 16, 48);
INSERT INTO `t_sys_role_resource` VALUES (94, 16, 49);
INSERT INTO `t_sys_role_resource` VALUES (95, 16, 50);

-- ----------------------------
-- Table structure for t_user_course
-- ----------------------------
DROP TABLE IF EXISTS `t_user_course`;
CREATE TABLE `t_user_course`  (
  `user_id` bigint(20) UNSIGNED NOT NULL COMMENT '用户id',
  `course_id` bigint(20) UNSIGNED NOT NULL COMMENT '课程id',
  `duration` int(10) UNSIGNED NULL DEFAULT 0 COMMENT '学习时长单位分钟',
  `evaluated` tinyint(1) NULL DEFAULT 0 COMMENT '是否已评价',
  `evaluation_level` int(10) UNSIGNED NULL DEFAULT 5 COMMENT '评价',
  `evaluation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '评价',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`user_id`, `course_id`) USING BTREE,
  INDEX `idx_course_id`(`course_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户课程表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for template
-- ----------------------------
DROP TABLE IF EXISTS `template`;
CREATE TABLE `template`  (
  `organization_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '机构id',
  `department_id` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '部门id',
  `creator` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '创建者',
  `modifier` bigint(20) UNSIGNED NULL DEFAULT NULL COMMENT '修改者',
  `create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '修改时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'template' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
