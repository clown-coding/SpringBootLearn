/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : springboot-redis

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-01-22 14:14:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('1', 'D-AA');
INSERT INTO `department` VALUES ('2', 'D-BB');
INSERT INTO `department` VALUES ('3', 'D-CC');
INSERT INTO `department` VALUES ('4', 'D-DD');
INSERT INTO `department` VALUES ('6', 'D-EE');
INSERT INTO `department` VALUES ('8', '扫黄打非');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gender` int(2) DEFAULT NULL,
  `d_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', '张三', '哈哈@163.com', '1', '1');
INSERT INTO `employee` VALUES ('2', '李4', '456@163.com', '0', '2');
INSERT INTO `employee` VALUES ('3', '王5', '789@163.com', '1', '3');
INSERT INTO `employee` VALUES ('4', '赵6', '123@123.com', '0', '4');
INSERT INTO `employee` VALUES ('5', '田7', '456@123.com', '1', '6');
INSERT INTO `employee` VALUES ('6', '王8', '888@163.com', '0', '2');
INSERT INTO `employee` VALUES ('8', 'clown', 'joker@163.com', '0', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张3', '123');
INSERT INTO `user` VALUES ('2', '李4', '456');
INSERT INTO `user` VALUES ('3', '王5', '789');
INSERT INTO `user` VALUES ('4', '赵6', '852');
