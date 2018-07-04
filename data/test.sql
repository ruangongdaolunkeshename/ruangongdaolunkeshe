/*
 Navicat Premium Data Transfer

 Source Server         : LocalHost
 Source Server Type    : MySQL
 Source Server Version : 50621
 Source Host           : localhost
 Source Database       : test

 Target Server Type    : MySQL
 Target Server Version : 50621
 File Encoding         : utf-8

 Date: 07/01/2018 21:28:02 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` varchar(100) CHARACTER SET utf8 DEFAULT '121212' COMMENT 'id',
  `sex` varchar(100) CHARACTER SET utf8 DEFAULT 'man' COMMENT '性别',
  `name` varchar(100) CHARACTER SET utf8 DEFAULT 'Tom' COMMENT '姓名',
   `address` varchar(100) CHARACTER SET utf8 DEFAULT 'BJ-Chaoyang' COMMENT '地址',
   `birthday` varchar(100) CHARACTER SET utf8 DEFAULT '1997-1-1' COMMENT '生日',
   `telephone` varchar(100) CHARACTER SET utf8 DEFAULT '18511111111' COMMENT '手机',
   `people` varchar(100) CHARACTER SET utf8 DEFAULT 'Tom' COMMENT '推荐人',
   `branch` varchar(100) CHARACTER SET utf8 DEFAULT 'A-part' COMMENT '行业分会',
   `committe` varchar(100) CHARACTER SET utf8 DEFAULT 'ABC' COMMENT '委员会',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 COMMENT='注册表';

-- ----------------------------
--  Records of `student`
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES ('1', 'man', '张三', 'bj-chaoyang','1997-1-1','18511111111','jack','A-part','ABC'), ('2', 'man', '李四', bj-chaoyang','1997-10-2','18522222222','jack,'C-part','ABC');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
