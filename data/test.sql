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
CREATE TABLE `student` (`username` varchar(100) NOT NULL ,`sex` varchar(100) NOT NULL ,`name` varchar(100) NOT NULL ,`address` varchar(100),`birthday` varchar(100),`telephone` varchar(100),`people` varchar(100) NOT NULL ,`branch` varchar(100),`committee` varchar(100), `password` varchar(100) NOT NULL ,`flat` Integer(2) DEFAULT '0');

-- ----------------------------
--  Records of `student`
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES ('1', 'man', '张三', 'bj-chaoyang','1997-1-1','18511111111','jack','A-part','ABC','123456','0'), ('2', 'man', '李四', 'bj-chaoyang','1997-10-2','18522222222','jack','C-part','ABC','123456','0');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
