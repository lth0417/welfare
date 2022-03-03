/*
 Navicat Premium Data Transfer

 Source Server         : 3306
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost:3306
 Source Schema         : public_wealth

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : 65001

 Date: 03/03/2022 18:03:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tb_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `category_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别代码',
  `category_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别名称',
  `category_lx` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类别类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_comment
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `project_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目ID',
  `user_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户ID',
  `user_id_to` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回复用户ID',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `create_time` timestamp(6) NULL DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_file
-- ----------------------------
DROP TABLE IF EXISTS `tb_file`;
CREATE TABLE `tb_file`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `project_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目ID',
  `file_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '保存路径',
  `create_time` timestamp(6) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(6) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_money
-- ----------------------------
DROP TABLE IF EXISTS `tb_money`;
CREATE TABLE `tb_money`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '捐款记录ID',
  `project_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '公益项目ID',
  `user_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL COMMENT '捐款者ID',
  `donate_money` decimal(10, 2) NULL DEFAULT NULL COMMENT '捐款金额',
  `donate_time` datetime(0) NULL DEFAULT NULL COMMENT '捐款时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin COMMENT = '捐赠记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_notice
-- ----------------------------
DROP TABLE IF EXISTS `tb_notice`;
CREATE TABLE `tb_notice`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `notice_title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告标题',
  `notice_content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公告内容',
  `file_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件ID',
  `status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_org
-- ----------------------------
DROP TABLE IF EXISTS `tb_org`;
CREATE TABLE `tb_org`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `org_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组织代码',
  `org_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组织名称',
  `adress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `linkman` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系方式',
  `email` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `create_time` timestamp(6) NULL DEFAULT NULL COMMENT '成立时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_project
-- ----------------------------
DROP TABLE IF EXISTS `tb_project`;
CREATE TABLE `tb_project`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目标题',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目内容',
  `user_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请人',
  `res_money` decimal(18, 2) NULL DEFAULT NULL COMMENT '目标金额',
  `now_money` decimal(18, 2) NULL DEFAULT NULL COMMENT '已有金额',
  `category_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属类别',
  `file_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件ID',
  `org_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公益组织代码',
  `org_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公益组织名称',
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '状态',
  `check_status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请状态',
  `check_user` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核员',
  `delete_flag` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '删除标志',
  `create_time` timestamp(6) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(6) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `role` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_role
-- ----------------------------
INSERT INTO `tb_role` VALUES ('1', 'admin');
INSERT INTO `tb_role` VALUES ('2', 'auditor');
INSERT INTO `tb_role` VALUES ('3', 'user');

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user`  (
  `id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `account` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `role_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `sfzh` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证',
  `nation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '民族',
  `sex` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birth` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出生日期',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `area` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '籍贯',
  `file_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '文件ID',
  `org_Id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公益组织ID',
  `balance` decimal(10, 2) NULL DEFAULT NULL COMMENT '账户余额',
  `status` varchar(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '状态：0-正常，1-禁用',
  `create_time` timestamp(6) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp(6) NULL DEFAULT NULL COMMENT '更新时间',
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '盐',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('836eee8aaf92468a8dc578a19490d86a', 'admin', 'd94dc73eba7908738f06a2fda8af72b5', '0', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '0', NULL, NULL, 'AucN)%IS');

SET FOREIGN_KEY_CHECKS = 1;
