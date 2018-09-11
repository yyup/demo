/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : haiyang

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-09-07 14:00:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for base_grade
-- ----------------------------
DROP TABLE IF EXISTS `base_grade`;
CREATE TABLE `base_grade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_grade
-- ----------------------------

-- ----------------------------
-- Table structure for base_user
-- ----------------------------
DROP TABLE IF EXISTS `base_user`;
CREATE TABLE `base_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of base_user
-- ----------------------------
INSERT INTO `base_user` VALUES ('1', 'yang');

-- ----------------------------
-- Table structure for common_member
-- ----------------------------
DROP TABLE IF EXISTS `common_member`;
CREATE TABLE `common_member` (
  `hxuuid` varchar(100) NOT NULL COMMENT 'PK',
  `member_nick` varchar(20) DEFAULT NULL COMMENT '昵称',
  `member_name` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `member_mobile` varchar(20) NOT NULL COMMENT '手机号码',
  `member_pwd` varchar(50) NOT NULL COMMENT '密码',
  `pattern_lock` varchar(50) DEFAULT NULL COMMENT '手势密码',
  `member_head` varchar(255) DEFAULT NULL COMMENT '头像',
  `first_char` char(2) DEFAULT NULL COMMENT '首字母',
  `member_sex` char(1) DEFAULT NULL COMMENT '性别1:男2:女',
  `member_email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `data_state` char(1) DEFAULT NULL COMMENT '是否有效 Y有效,N无效',
  `created_by` varchar(100) DEFAULT NULL COMMENT '创建人',
  `date_created` varchar(100) DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(100) DEFAULT NULL COMMENT '更新人',
  `date_updated` varchar(100) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`hxuuid`),
  UNIQUE KEY `member_mobile` (`member_mobile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of common_member
-- ----------------------------
INSERT INTO `common_member` VALUES ('dc853ca7-7b4c-11e8-b543-000ec6a85e96', '大白兔', '张三', '14759201111', '000000', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `common_member` VALUES ('dc8c4a20-7b4c-11e8-b543-000ec6a85e96', '解放', '李四', '14759201112', '000000', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `common_member` VALUES ('dc965853-7b4c-11e8-b543-000ec6a85e96', '经典', '王五', '14759201113', '000000', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `common_member` VALUES ('dc9be08a-7b4c-11e8-b543-000ec6a85e96', '英伦', '赵六', '14759201114', '000000', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `common_member` VALUES ('dca1e9c3-7b4c-11e8-b543-000ec6a85e96', '定位', '田七', '14759201115', '000000', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `common_member` VALUES ('dca8742f-7b4c-11e8-b543-000ec6a85e96', '基地', '老八', '14759201116', '000000', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `common_member` VALUES ('dcafdb0a-7b4c-11e8-b543-000ec6a85e96', '开讲啦', '万九', '14759201117', '000000', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `common_member` VALUES ('dcb71ca1-7b4c-11e8-b543-000ec6a85e96', '肺气肿', '整十', '14759201118', '000000', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `common_member` VALUES ('dcc02f3a-7b4c-11e8-b543-000ec6a85e96', '肺气肿', '钱千', '14759201119', '000000', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `common_member` VALUES ('dcc78cec-7b4c-11e8-b543-000ec6a85e96', '肺气肿', '金万', '14759201120', '000000', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `common_member` VALUES ('dccf0372-7b4c-11e8-b543-000ec6a85e96', '肺气肿', '钻亿', '14759201121', '000000', null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for manages_menu
-- ----------------------------
DROP TABLE IF EXISTS `manages_menu`;
CREATE TABLE `manages_menu` (
  `hxuuid` varchar(100) NOT NULL COMMENT 'PK',
  `menu_name` varchar(255) NOT NULL COMMENT '菜单名称',
  `menu_code` varchar(255) NOT NULL COMMENT '菜单编号',
  `parent_menu_code` varchar(255) DEFAULT NULL COMMENT 'top一级菜单，子菜单则为其父菜单的menu_code',
  `menu_desc` varchar(255) DEFAULT NULL COMMENT '菜单描述',
  `menu_url` varchar(255) DEFAULT NULL COMMENT '菜单地址',
  `menu_icon` varchar(32) DEFAULT NULL COMMENT '菜单图标',
  `weight` int(2) DEFAULT NULL COMMENT '菜单排序权重,最小的排在最前边',
  `data_state` char(1) DEFAULT NULL COMMENT '是否有效 Y有效,N无效',
  `created_by` varchar(100) DEFAULT NULL COMMENT '创建人',
  `date_created` varchar(100) DEFAULT NULL COMMENT '创建时间',
  `updated_by` varchar(100) DEFAULT NULL COMMENT '更新人',
  `date_updated` varchar(100) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`hxuuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='导航栏菜单表';

-- ----------------------------
-- Records of manages_menu
-- ----------------------------
INSERT INTO `manages_menu` VALUES ('2006b1e1-7b4c-11e8-b543-000ec6a85e96', '系统管理', 'system_manage', 'top', '系统管理菜单', '', null, '1', 'Y', 'system', '2018-06-29 11:25:52', 'system', '2018-06-29 11:25:52');
INSERT INTO `manages_menu` VALUES ('200ae335-7b4c-11e8-b543-000ec6a85e96', '用户管理', 'user_manage', 'system_manage', '用户管理', 'commonmember/list.hx', null, '1', 'Y', 'system', '2018-06-29 11:25:52', 'system', '2018-06-29 11:25:52');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'yang');
INSERT INTO `user` VALUES ('2', 'li');
