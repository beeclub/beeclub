/*
Navicat MySQL Data Transfer

Source Server         : local-root
Source Server Version : 50727
Source Host           : localhost:3306
Source Database       : beeclub

Target Server Type    : MYSQL
Target Server Version : 50727
File Encoding         : 65001

Date: 2019-11-27 14:48:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_course_category
-- ----------------------------
DROP TABLE IF EXISTS `t_course_category`;
CREATE TABLE `t_course_category` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(64) NOT NULL,
  `pid` int(10) DEFAULT '0' COMMENT '上级id',
  `priority` int(4) DEFAULT '1' COMMENT '排序',
  `available` tinyint(1) NOT NULL DEFAULT '1' COMMENT '状态1有效0无效',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='课程表类别';

-- ----------------------------
-- Records of t_course_category
-- ----------------------------
INSERT INTO `t_course_category` VALUES ('1', '前沿-追求卓越', '0', '1', '1', '');
INSERT INTO `t_course_category` VALUES ('2', '前端-工程', '0', '1', '1', null);
INSERT INTO `t_course_category` VALUES ('3', '后端-架构', '0', '1', '1', null);
INSERT INTO `t_course_category` VALUES ('4', '移动-连接世界', '0', '1', '1', null);
INSERT INTO `t_course_category` VALUES ('5', 'UI-赏心悦目', '0', '1', '1', null);
INSERT INTO `t_course_category` VALUES ('6', '机器学习', '1', '1', '1', '');
INSERT INTO `t_course_category` VALUES ('8', '微服务', '1', '1', '1', null);
INSERT INTO `t_course_category` VALUES ('9', 'vue', '2', '1', '1', null);
INSERT INTO `t_course_category` VALUES ('10', 'webpack', '2', '1', '1', null);
INSERT INTO `t_course_category` VALUES ('11', 'java', '3', '1', '1', null);
INSERT INTO `t_course_category` VALUES ('12', 'nodejs', '3', '1', '1', null);
INSERT INTO `t_course_category` VALUES ('13', 'python', '3', '1', '1', null);
INSERT INTO `t_course_category` VALUES ('14', 'uniapp', '4', '1', '1', null);
INSERT INTO `t_course_category` VALUES ('15', 'ios', '4', '1', '1', null);
INSERT INTO `t_course_category` VALUES ('16', 'andriod', '4', '1', '1', null);
INSERT INTO `t_course_category` VALUES ('17', 'photoshop', '5', '1', '1', null);
INSERT INTO `t_course_category` VALUES ('18', '室内设计', '5', '1', '1', null);
