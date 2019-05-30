/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50640
Source Host           : localhost:3306
Source Database       : food

Target Server Type    : MYSQL
Target Server Version : 50640
File Encoding         : 65001

Date: 2019-02-25 13:52:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_comment`
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` bigint(10) NOT NULL DEFAULT '0',
  `forumId` bigint(10) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `comment_user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `t_food`
-- ----------------------------
DROP TABLE IF EXISTS `t_food`;
CREATE TABLE `t_food` (
  `id` bigint(20) NOT NULL DEFAULT '0',
  `foodName` varchar(255) DEFAULT NULL,
  `foodURL` varchar(255) DEFAULT NULL,
  `foodType` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `active` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_food
-- ----------------------------

-- ----------------------------
-- Table structure for `t_formu`
-- ----------------------------
DROP TABLE IF EXISTS `t_formu`;
CREATE TABLE `t_formu` (
  `Id` bigint(10) NOT NULL DEFAULT '0',
  `content` varchar(255) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `userAvatar` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `star` int(10) DEFAULT NULL,
  `isCheck` int(10) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_formu
-- ----------------------------

-- ----------------------------
-- Table structure for `t_history`
-- ----------------------------
DROP TABLE IF EXISTS `t_history`;
CREATE TABLE `t_history` (
  `id` bigint(10) NOT NULL,
  `recipeId` bigint(10) DEFAULT NULL,
  `userId` bigint(10) DEFAULT NULL,
  `readTime` varchar(255) DEFAULT NULL,
  `preference` float(10,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_history
-- ----------------------------

-- ----------------------------
-- Table structure for `t_ingredients`
-- ----------------------------
DROP TABLE IF EXISTS `t_ingredients`;
CREATE TABLE `t_ingredients` (
  `id` bigint(10) NOT NULL DEFAULT '0',
  `recipeId` bigint(10) DEFAULT NULL,
  `ingredient` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ingredients
-- ----------------------------

-- ----------------------------
-- Table structure for `t_picture`
-- ----------------------------
DROP TABLE IF EXISTS `t_picture`;
CREATE TABLE `t_picture` (
  `id` bigint(10) NOT NULL DEFAULT '0',
  `forumId` bigint(10) DEFAULT NULL,
  `pictureURL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_picture
-- ----------------------------

-- ----------------------------
-- Table structure for `t_star`
-- ----------------------------
DROP TABLE IF EXISTS `t_star`;
CREATE TABLE `t_star` (
  `id` bigint(10) NOT NULL DEFAULT '0',
  `forumId` bigint(10) DEFAULT NULL,
  `userId` bigint(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_star
-- ----------------------------

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userId` bigint(10) NOT NULL DEFAULT '0',
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `avatarURL` varchar(255) DEFAULT NULL,
  `userType` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------

-- ----------------------------
-- Table structure for `t_video`
-- ----------------------------
DROP TABLE IF EXISTS `t_video`;
CREATE TABLE `t_video` (
  `id` bigint(10) NOT NULL DEFAULT '0',
  `title` varchar(255) DEFAULT NULL,
  `videoURL` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `active` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_video
-- ----------------------------
