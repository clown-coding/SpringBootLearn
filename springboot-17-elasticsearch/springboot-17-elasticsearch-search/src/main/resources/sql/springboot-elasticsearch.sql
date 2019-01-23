/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : springboot-elasticsearch

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-01-23 18:11:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` varchar(20) NOT NULL COMMENT 'ID',
  `columnid` varchar(20) DEFAULT NULL COMMENT '专栏ID',
  `userid` varchar(20) DEFAULT NULL COMMENT '用户ID',
  `title` varchar(100) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '文章正文',
  `image` varchar(100) DEFAULT NULL COMMENT '文章封面',
  `createtime` datetime DEFAULT NULL COMMENT '发表日期',
  `updatetime` datetime DEFAULT NULL COMMENT '修改日期',
  `ispublic` varchar(1) DEFAULT NULL COMMENT '是否公开',
  `istop` varchar(1) DEFAULT NULL COMMENT '是否置顶',
  `visits` int(20) DEFAULT NULL COMMENT '浏览量',
  `thumbup` int(20) DEFAULT NULL COMMENT '点赞数',
  `comment` int(20) DEFAULT NULL COMMENT '评论数',
  `state` varchar(1) DEFAULT NULL COMMENT '审核状态',
  `channelid` varchar(20) DEFAULT NULL COMMENT '所属频道',
  `url` varchar(100) DEFAULT NULL COMMENT 'URL',
  `type` varchar(1) DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章';

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1070217204299075584', '1', '1', 'springBootCLI的安装方式', '1.用下载的分发包进行安装 2.用Groovy Environment Manager进行安装 3.通过OS X Homebrew进行安装 4.使用MacPorts进行安装', null, '2018-12-05 15:24:00', null, '0', '1', '100', '2', null, '1', '1', 'http://www.baidu.com', '0');
INSERT INTO `article` VALUES ('1070677966993887232', '1', '1', 'springBootCLI install methods', 'custom install', null, '2018-12-06 21:54:54', null, '0', '0', '100', '100', '100', '0', '1', 'http://www.baidu.com', '0');
INSERT INTO `article` VALUES ('1070678227468554240', '1', '1', 'springBoot的特性有哪些', '1.起步依赖2.自动配置3.监控程序状态4.命令行界面', null, '2018-12-06 21:55:56', null, '0', '0', '200', '200', '200', '0', '1', 'http://www.baidu.com', '0');
INSERT INTO `article` VALUES ('1087980772297674752', '1', '1', 'springBoot的特性', '1.起步依赖2.自动配置3.监控程序状态4.命令行界面', null, '2019-01-23 15:50:04', '2019-01-23 15:51:26', '0', '0', '100', '10', '10', '0', '1', 'http://www.clown.com', '0');
INSERT INTO `article` VALUES ('1088013794371833856', '1', null, 'logstash安装并使用logstash-jdbc-input与mysql数据库同步', '1.安装logstash2.windows系统进行启动，输入命令3.配置logstash-jdbc-input面', null, '2019-01-23 18:01:18', null, '0', '0', '100', '10', '10', '0', '1', 'http://www.clown.com', '1');
