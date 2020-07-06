/*
 Navicat MySQL Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : news

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 04/07/2020 13:43:25
*/


-- ----------------------------
-- Table structure for n_news
-- ----------------------------
DROP TABLE IF EXISTS `n_news`;
CREATE TABLE `n_news`  (
  `n_id` bigint(20) NOT NULL COMMENT 'news id',
  `n_title` varchar(50) NOT NULL COMMENT 'news title',
  `n_tag` varchar(100) NULL DEFAULT NULL COMMENT 'news tag',
  `n_content` text NOT NULL COMMENT 'news content',
  `n_create` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'news create time',
  `n_create_by` varchar(50)  NULL DEFAULT NULL COMMENT 'news create by',
  `n_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'new modified time',
  `n_modified_by` varchar(50)  NULL DEFAULT NULL COMMENT 'new modified by',
  PRIMARY KEY (`n_id`) USING BTREE
) ENGINE = InnoDB ;


-- ----------------------------
-- Table structure for n_user
-- ----------------------------
DROP TABLE IF EXISTS `n_user`;
CREATE TABLE `n_user`  (
  `n_id` bigint(20) NOT NULL COMMENT 'uuid',
  `n_account` varchar(50) NOT NULL COMMENT 'user account',
  `n_password` varchar(100) NOT NULL COMMENT 'user password',
  `n_type` enum('APP','ADMIN') NOT NULL COMMENT 'user type',
  `n_create` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'createtime',
  `n_create_by` varchar(50)  NULL DEFAULT NULL COMMENT 'create by',
  `n_modified` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'modify time',
  `n_modified_by` varchar(50)  NULL DEFAULT NULL COMMENT 'modify by',
  PRIMARY KEY (`n_id`) USING BTREE,
  UNIQUE INDEX `in_account`(`n_account`) USING BTREE
) ENGINE = InnoDB ;
