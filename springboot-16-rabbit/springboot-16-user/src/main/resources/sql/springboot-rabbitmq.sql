/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : springboot-rabbitmq

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-01-22 21:59:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for accesskey
-- ----------------------------
DROP TABLE IF EXISTS `accesskey`;
CREATE TABLE `accesskey` (
  `id` varchar(255) NOT NULL,
  `access_key_id` varchar(255) DEFAULT NULL,
  `access_key_secret` varchar(255) DEFAULT NULL,
  `sign_name` varchar(255) DEFAULT NULL,
  `template_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of accesskey
-- ----------------------------
INSERT INTO `accesskey` VALUES ('1087689162657763328', 'LTAI8nK01G3gXmyo', 'xk6MYAadGPpYFkxkiWMrKMokHU6qab', '李剑宇', 'SMS_148865192');
INSERT INTO `accesskey` VALUES ('1087690534383915008', 'LTAI8nK01G3gXmyo', 'xk6MYAadGPpYFkxkiWMrKMokHU6qab', '李剑宇', 'SMS_156471578');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `lastdate` datetime(6) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `regdate` datetime(6) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `updatedate` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1087710056444727296', 'clown_coding@163.com', '2019-01-22 21:54:20.789000', '15764719456', 'clown', '$2a$10$xO6djPRyXc3hNB.R2qR8XuIcFTiC7RpmX5xNAEiVM4d76zeS2pVxe', '2019-01-22 21:54:20.789000', '1', '2019-01-22 21:54:20.789000');
