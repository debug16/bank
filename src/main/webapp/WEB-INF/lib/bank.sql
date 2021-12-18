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

 Date: 19/12/2021 01:02:49
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
  `Remaining` decimal(10, 2) NULL DEFAULT NULL COMMENT '余额',
  PRIMARY KEY (`AccountID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('admin', 'admin', 31489.14);
INSERT INTO `account` VALUES ('test', '888888', 67223.24);
INSERT INTO `account` VALUES ('user', 'user', 108238.11);
INSERT INTO `account` VALUES ('张三', '123456', 100.00);

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
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

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
INSERT INTO `trade` VALUES (0000000022, 'admin', 1, 10000.00, '2021-12-17 10:04:28', '存10000');
INSERT INTO `trade` VALUES (0000000023, 'admin', 3, 1000.00, '2021-12-17 10:10:06', '转给user1000');
INSERT INTO `trade` VALUES (0000000024, 'admin', 3, 1000.00, '2021-12-17 10:10:27', '');
INSERT INTO `trade` VALUES (0000000025, 'admin', 3, 200.00, '2021-12-17 10:15:42', '');
INSERT INTO `trade` VALUES (0000000026, 'admin', 1, 500.00, '2021-12-17 10:15:58', '');
INSERT INTO `trade` VALUES (0000000027, 'test', 3, 66.00, '2021-12-17 10:39:53', '');
INSERT INTO `trade` VALUES (0000000028, 'test', 3, 66.00, '2021-12-17 11:10:59', '');
INSERT INTO `trade` VALUES (0000000029, 'test', 1, 200.00, '2021-12-17 11:11:22', '');
INSERT INTO `trade` VALUES (0000000030, 'admin', 1, 10000.00, '2021-12-17 21:38:12', '存一万');
INSERT INTO `trade` VALUES (0000000031, 'admin', 3, 123.09, '2021-12-17 21:43:18', '');
INSERT INTO `trade` VALUES (0000000032, 'admin', 1, 0.50, '2021-12-17 21:43:51', '');
INSERT INTO `trade` VALUES (0000000033, 'admin', 1, 0.50, '2021-12-17 21:44:16', '');
INSERT INTO `trade` VALUES (0000000034, 'admin', 1, 0.50, '2021-12-17 21:45:13', '');
INSERT INTO `trade` VALUES (0000000035, 'admin', 1, 0.50, '2021-12-17 21:45:29', '');
INSERT INTO `trade` VALUES (0000000036, 'admin', 1, 0.01, '2021-12-17 21:45:39', '');
INSERT INTO `trade` VALUES (0000000041, 'admin', 1, 100.99, '2021-12-17 23:49:28', '你成功存款【100.99】元，当前可用余额为【32725.91】元');
INSERT INTO `trade` VALUES (0000000042, 'admin', 1, 100.01, '2021-12-17 23:49:53', '你成功存款【100.01】元，当前可用余额为【32825.92】元');
INSERT INTO `trade` VALUES (0000000043, 'admin', 2, 100.01, '2021-12-17 23:50:12', '你成功取款【100.01】元，当前可用余额为【32725.91】元');
INSERT INTO `trade` VALUES (0000000044, 'admin', 3, 100.10, '2021-12-17 23:51:07', '你的账户向【test】成功转账【100.1】元；当前可用余额为【32725.91】元');
INSERT INTO `trade` VALUES (0000000045, 'admin', 3, 100.01, '2021-12-17 23:53:30', '你的账户向【user】成功转账【100.01】元；当前可用余额为【32525.80】元');
INSERT INTO `trade` VALUES (0000000046, 'admin', 1, 100.01, '2021-12-18 00:02:43', '你成功存款【100.01】元，当前可用余额为【32625.81】元');
INSERT INTO `trade` VALUES (0000000047, 'admin', 3, 100.01, '2021-12-18 00:03:06', '你的账户向【test】成功转账【100.01】元；当前可用余额为【32525.80】元');
INSERT INTO `trade` VALUES (0000000048, 'admin', 2, 123.53, '2021-12-18 00:04:14', '你成功取款【123.53】元，当前可用余额为【32402.27】元');
INSERT INTO `trade` VALUES (0000000049, 'admin', 3, 2.07, '2021-12-18 00:04:48', '你的账户向【user】成功转账【2.07】元；当前可用余额为【32400.20】元');
INSERT INTO `trade` VALUES (0000000050, 'admin', 3, 180.13, '2021-12-18 00:14:31', '你的账户向【test】成功转账【180.13】元；当前可用余额为【32220.07】元');
INSERT INTO `trade` VALUES (0000000051, 'admin', 2, 100.24, '2021-12-18 00:15:41', '你成功取款【100.24】元，当前可用余额为【32119.83】元');
INSERT INTO `trade` VALUES (0000000052, 'admin', 1, 100.27, '2021-12-18 00:16:33', '你成功存款【100.27】元，当前可用余额为【32220.10】元');
INSERT INTO `trade` VALUES (0000000053, 'admin', 2, 199.00, '2021-12-18 00:19:37', '你成功取款【199.0】元，当前可用余额为【32021.10】元');
INSERT INTO `trade` VALUES (0000000054, 'admin', 2, 199.00, '2021-12-18 00:20:15', '你成功取款【199.0】元，当前可用余额为【31822.10】元');
INSERT INTO `trade` VALUES (0000000055, 'admin', 3, 109.00, '2021-12-18 00:21:29', '你的账户向【test】成功转账【109.0】元；当前可用余额为【31713.10】元');
INSERT INTO `trade` VALUES (0000000056, 'admin', 3, 123.90, '2021-12-18 00:47:52', '你的账户向【user】成功转账【123.9】元；当前可用余额为【31589.20】元');
INSERT INTO `trade` VALUES (0000000057, 'admin', 3, 100.05, '2021-12-18 23:28:36', '你的账户向【user】成功转账【100.05】元；当前可用余额为【31489.15】元');
INSERT INTO `trade` VALUES (0000000058, 'admin', 1, 999.99, '2021-12-18 23:29:39', '你成功存款【999.99】元，当前可用余额为【32489.14】元');
INSERT INTO `trade` VALUES (0000000059, 'admin', 2, 1000.00, '2021-12-18 23:30:35', '你成功取款【1000.0】元，当前可用余额为【31489.14】元');

SET FOREIGN_KEY_CHECKS = 1;
