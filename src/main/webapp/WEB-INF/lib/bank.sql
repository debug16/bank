/*
 Navicat MySQL Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80024
 Source Host           : localhost:3306
 Source Schema         : bank

 Target Server Type    : MySQL
 Target Server Version : 80024
 File Encoding         : 65001

 Date: 17/12/2021 10:01:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `AccountID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `Password` varchar(6) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `Remaining` decimal(10, 0) NULL DEFAULT NULL COMMENT '余额',
  PRIMARY KEY (`AccountID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('admin', 'admin', 15401);
INSERT INTO `account` VALUES ('test', '888888', 3999);
INSERT INTO `account` VALUES ('user', 'user', 104300);
INSERT INTO `account` VALUES ('张三', '123456', 100);

-- ----------------------------
-- Table structure for trade
-- ----------------------------
DROP TABLE IF EXISTS `trade`;
CREATE TABLE `trade`  (
  `ID` bigint(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT '流水号',
  `AccountID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `TradeType` int NULL DEFAULT NULL COMMENT '1存款 2取款 3转账',
  `TradeMoney` decimal(10, 2) NULL DEFAULT NULL COMMENT '交易金额',
  `TradeTime` datetime NULL DEFAULT NULL COMMENT '交易时间',
  `TradeDigest` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易摘要',
  PRIMARY KEY (`ID`) USING BTREE,
  INDEX `AccountId`(`AccountID`) USING BTREE,
  CONSTRAINT `AccountId` FOREIGN KEY (`AccountID`) REFERENCES `account` (`AccountID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of trade
-- ----------------------------
INSERT INTO `trade` VALUES (0000000001, 'admin', 2, 1000.00, '2021-12-08 15:54:11', '我取款了1000');
INSERT INTO `trade` VALUES (0000000002, 'admin', 2, 1000.00, '2021-12-05 19:27:03', '取款1000元');
INSERT INTO `trade` VALUES (0000000003, 'admin', 1, 10000.00, '2021-12-15 19:28:03', '存款了10000元');
INSERT INTO `trade` VALUES (0000000004, 'admin', 1, 10000.00, '2021-11-11 19:28:53', '存了10000元');
INSERT INTO `trade` VALUES (0000000005, 'admin', 3, 1.00, '2021-12-14 19:29:53', '我给user转了1元');
INSERT INTO `trade` VALUES (0000000006, 'admin', 3, 100.00, '2021-12-13 19:30:42', '我给user转了100元');
INSERT INTO `trade` VALUES (0000000007, 'admin', 3, 99.00, '2021-12-09 19:47:12', '给test转99元');
INSERT INTO `trade` VALUES (0000000008, 'user', 1, 1000.00, '2021-12-16 20:06:41', '存款1000');
INSERT INTO `trade` VALUES (0000000009, 'admin', 3, 1000.00, '2021-12-17 00:16:16', '给user转1000元');
INSERT INTO `trade` VALUES (0000000010, 'admin', 2, 399.00, '2021-12-17 00:20:03', '取款399.9');
INSERT INTO `trade` VALUES (0000000011, 'user', 1, 1000.00, '2021-12-17 00:33:04', '存款1000');
INSERT INTO `trade` VALUES (0000000012, 'user', 1, 100.00, '2021-12-17 01:12:47', '存款100');
INSERT INTO `trade` VALUES (0000000013, 'admin', 2, 1000.00, '2021-12-17 01:25:12', '取款1000');
INSERT INTO `trade` VALUES (0000000014, 'test', 1, 1000.00, '2021-12-17 01:31:11', '存1000');
INSERT INTO `trade` VALUES (0000000015, 'test', 1, 1000.00, '2021-12-17 01:32:28', '存1000');
INSERT INTO `trade` VALUES (0000000016, 'test', 1, 1000.00, '2021-12-17 01:32:40', '存1000');
INSERT INTO `trade` VALUES (0000000017, 'test', 3, 100.00, '2021-12-17 01:42:51', '向user转了100元');
INSERT INTO `trade` VALUES (0000000018, 'admin', 2, 1000.00, '2021-12-17 03:24:51', '取1000');
INSERT INTO `trade` VALUES (0000000019, 'admin', 3, 1000.00, '2021-12-17 09:37:25', '给user转1000');
INSERT INTO `trade` VALUES (0000000020, 'admin', 1, 1000.00, '2021-12-17 09:37:55', 'qeqe');
INSERT INTO `trade` VALUES (0000000021, 'admin', 2, 100000.00, '2021-12-17 09:38:41', '取款');

SET FOREIGN_KEY_CHECKS = 1;
