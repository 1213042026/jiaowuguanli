/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50636
Source Host           : localhost:3306
Source Database       : db_jiaowu

Target Server Type    : MYSQL
Target Server Version : 50636
File Encoding         : 65001

Date: 2017-05-25 14:35:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `userName` varchar(50) DEFAULT NULL COMMENT '用户名(登录用户名)',
  `userPw` varchar(50) DEFAULT NULL COMMENT '密码',
  `xingming` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'a', 'a', '管理员12');

-- ----------------------------
-- Table structure for t_chengji
-- ----------------------------
DROP TABLE IF EXISTS `t_chengji`;
CREATE TABLE `t_chengji` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '成绩编号',
  `xueshengId` int(11) DEFAULT NULL COMMENT '(外键)学生编号',
  `kaoshishi` varchar(255) DEFAULT NULL COMMENT '考试时间',
  `kechengId` int(255) DEFAULT NULL COMMENT '(外键)课程编号',
  `fenshu` decimal(10,1) DEFAULT NULL COMMENT '分数',
  PRIMARY KEY (`id`),
  KEY `FK_xuesheng_chengji` (`xueshengId`),
  KEY `FK_kecheng_chengji` (`kechengId`),
  CONSTRAINT `FK_kecheng_chengji` FOREIGN KEY (`kechengId`) REFERENCES `t_kecheng` (`id`),
  CONSTRAINT `FK_xuesheng_chengji` FOREIGN KEY (`xueshengId`) REFERENCES `t_xuesheng` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_chengji
-- ----------------------------
INSERT INTO `t_chengji` VALUES ('1', '2', '2017-03-02', '1', '98.0');
INSERT INTO `t_chengji` VALUES ('2', '2', '2017-03-02', '2', '98.0');
INSERT INTO `t_chengji` VALUES ('3', '3', '2017-05-24', '2', '80.0');
INSERT INTO `t_chengji` VALUES ('4', '4', '2017-05-24', '3', '90.0');
INSERT INTO `t_chengji` VALUES ('5', '4', '2017-05-24', '4', '98.0');

-- ----------------------------
-- Table structure for t_gonggao
-- ----------------------------
DROP TABLE IF EXISTS `t_gonggao`;
CREATE TABLE `t_gonggao` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公告编号',
  `title` varchar(255) DEFAULT NULL COMMENT '公告标题',
  `content` varchar(255) DEFAULT NULL COMMENT '公告内容',
  `addtime` varchar(255) DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_gonggao
-- ----------------------------
INSERT INTO `t_gonggao` VALUES ('1', '今天下午有计算机基础考试', '今天下午有计算机基础考试，请大家14:00到二教室进行考试。', '2017-05-24 10:07:18');
INSERT INTO `t_gonggao` VALUES ('3', '暑假放假最新通知', '今年暑假放假时间定为6-25日至9-1日，希望大家认真复习，做好期末考试准备。', '2017-05-24 10:19:46');

-- ----------------------------
-- Table structure for t_kecheng
-- ----------------------------
DROP TABLE IF EXISTS `t_kecheng`;
CREATE TABLE `t_kecheng` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '课程编号',
  `mingcheng` varchar(255) DEFAULT NULL COMMENT '课程名称',
  `zhuanyeid` int(11) DEFAULT NULL COMMENT '(外键)所属专业',
  `del` int(11) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `FK_zhuanye_kecheng` (`zhuanyeid`),
  CONSTRAINT `FK_zhuanye_kecheng` FOREIGN KEY (`zhuanyeid`) REFERENCES `t_zhuanye` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_kecheng
-- ----------------------------
INSERT INTO `t_kecheng` VALUES ('1', '计算机组成原理', '1', '0');
INSERT INTO `t_kecheng` VALUES ('2', 'Java程序设计', '1', '0');
INSERT INTO `t_kecheng` VALUES ('3', '通讯原理', '2', '0');
INSERT INTO `t_kecheng` VALUES ('4', '会计电算化', '3', '0');

-- ----------------------------
-- Table structure for t_laoshi
-- ----------------------------
DROP TABLE IF EXISTS `t_laoshi`;
CREATE TABLE `t_laoshi` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '老师id',
  `bianhao` varchar(55) DEFAULT NULL COMMENT '老师编号(登录用户名)',
  `xingming` varchar(55) DEFAULT NULL COMMENT '老师姓名',
  `xingbie` varchar(50) DEFAULT NULL COMMENT '老师性别',
  `nianling` varchar(50) DEFAULT NULL COMMENT '老师年龄',
  `loginpw` varchar(50) DEFAULT NULL COMMENT '老师密码',
  `zhuanyeid` int(11) DEFAULT NULL COMMENT '(外键)所属专业',
  `status` int(11) DEFAULT NULL COMMENT '是否审核',
  `del` int(11) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `FK_zhuanye_laoshi` (`zhuanyeid`),
  CONSTRAINT `FK_zhuanye_laoshi` FOREIGN KEY (`zhuanyeid`) REFERENCES `t_zhuanye` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_laoshi
-- ----------------------------
INSERT INTO `t_laoshi` VALUES ('1', '1', '陈老师2计算机', '男', '30', '1', '1', '1', '0');
INSERT INTO `t_laoshi` VALUES ('2', '0001 ', '李强强电子', '男', '45', '000000', '4', '1', '0');
INSERT INTO `t_laoshi` VALUES ('3', '0002', '张三老师会计', '男', '20', '1', '2', '1', '0');
INSERT INTO `t_laoshi` VALUES ('4', '0003', '刘老师机械', '女', '29', '1', '3', '1', '0');
INSERT INTO `t_laoshi` VALUES ('5', '0004', '王五计算机', '女', '34', '1', '1', '1', '0');

-- ----------------------------
-- Table structure for t_xuesheng
-- ----------------------------
DROP TABLE IF EXISTS `t_xuesheng`;
CREATE TABLE `t_xuesheng` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '学生id',
  `zhuanyeid` int(11) DEFAULT NULL COMMENT '(外键)专业编号',
  `xuehao` varchar(255) DEFAULT NULL COMMENT '学号(登录用户名)',
  `xingming` varchar(255) DEFAULT NULL COMMENT '姓名',
  `xingbie` varchar(255) DEFAULT NULL COMMENT '性别',
  `nianling` varchar(255) DEFAULT NULL COMMENT '年龄',
  `loginpw` varchar(255) DEFAULT NULL COMMENT '登录密码',
  `status` int(11) DEFAULT NULL COMMENT '是否审核',
  `del` int(11) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`),
  KEY `FK_zhuanye` (`zhuanyeid`),
  CONSTRAINT `FK_zhuanye` FOREIGN KEY (`zhuanyeid`) REFERENCES `t_zhuanye` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_xuesheng
-- ----------------------------
INSERT INTO `t_xuesheng` VALUES ('2', '1', '1', '计算机刘三', '男', '21', '1', '1', '0');
INSERT INTO `t_xuesheng` VALUES ('3', '2', '2012002', '电子信息专业赵刚', '男', '14', '000000', '1', '0');
INSERT INTO `t_xuesheng` VALUES ('4', '3', '2012003', '会计专业李强', '男', '13', '000000', '1', '0');
INSERT INTO `t_xuesheng` VALUES ('8', '4', '2012004', '机械设计专业李四', '女', '20', '1', '1', '0');
INSERT INTO `t_xuesheng` VALUES ('10', '1', '2012005', '计算机刘', '女', '23', '111', '1', '0');

-- ----------------------------
-- Table structure for t_zhuanye
-- ----------------------------
DROP TABLE IF EXISTS `t_zhuanye`;
CREATE TABLE `t_zhuanye` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '专业id',
  `mingcheng` varchar(255) DEFAULT NULL COMMENT '专业名称',
  `del` int(11) DEFAULT NULL COMMENT '是否删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_zhuanye
-- ----------------------------
INSERT INTO `t_zhuanye` VALUES ('1', '计算机专业', '0');
INSERT INTO `t_zhuanye` VALUES ('2', '电子信息专业', '0');
INSERT INTO `t_zhuanye` VALUES ('3', '会计专业', '0');
INSERT INTO `t_zhuanye` VALUES ('4', '机械设计专业', '0');
