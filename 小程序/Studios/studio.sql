/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : studio

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2017-07-02 22:55:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `accountID` int(10) DEFAULT NULL,
  `accountName` varchar(30) DEFAULT NULL,
  `accountPwd` varchar(30) DEFAULT NULL,
  `accountType` int(4) DEFAULT NULL,
  `accountBalance` int(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'zbw', '123', '2', '500');
INSERT INTO `account` VALUES ('2', 'black', '123', '2', '0');
INSERT INTO `account` VALUES ('3', 'tom', '123', '2', '0');
INSERT INTO `account` VALUES ('4', 'admin', '123', '1', '1000');

-- ----------------------------
-- Table structure for cinema
-- ----------------------------
DROP TABLE IF EXISTS `cinema`;
CREATE TABLE `cinema` (
  `cinemaID` int(10) DEFAULT NULL,
  `cinemaName` varchar(30) DEFAULT NULL,
  `cinemaAddress` varchar(50) DEFAULT NULL,
  `cinemaMoney` int(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cinema
-- ----------------------------
INSERT INTO `cinema` VALUES ('1', '桥林影院', '桥林镇', '100');
INSERT INTO `cinema` VALUES ('2', '浦口影院', '浦口区', '200');
INSERT INTO `cinema` VALUES ('3', '江北影院', '江北大道101号', '0');
INSERT INTO `cinema` VALUES ('4', '长桥影院', '长桥路11号', '500');

-- ----------------------------
-- Table structure for days
-- ----------------------------
DROP TABLE IF EXISTS `days`;
CREATE TABLE `days` (
  `dayID` int(10) DEFAULT NULL,
  `dayName` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of days
-- ----------------------------
INSERT INTO `days` VALUES ('1', '今天');
INSERT INTO `days` VALUES ('2', '明天');
INSERT INTO `days` VALUES ('3', '后天');

-- ----------------------------
-- Table structure for films
-- ----------------------------
DROP TABLE IF EXISTS `films`;
CREATE TABLE `films` (
  `filmID` int(10) DEFAULT NULL,
  `filmName` varchar(30) DEFAULT NULL,
  `filmPrice` int(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of films
-- ----------------------------
INSERT INTO `films` VALUES ('1', '长城', '50');
INSERT INTO `films` VALUES ('2', '英雄', '50');
INSERT INTO `films` VALUES ('3', '三个火枪手', '50');
INSERT INTO `films` VALUES ('4', '白雪公主', '50');
INSERT INTO `films` VALUES ('5', '冰雪女王', '50');

-- ----------------------------
-- Table structure for schedule
-- ----------------------------
DROP TABLE IF EXISTS `schedule`;
CREATE TABLE `schedule` (
  `cinemaID` int(20) DEFAULT NULL,
  `videoHallID` int(10) DEFAULT NULL,
  `dayID` int(10) DEFAULT NULL,
  `timeID` int(10) DEFAULT NULL,
  `filmID` int(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule
-- ----------------------------
INSERT INTO `schedule` VALUES ('1', '1', '1', '1', '1');
INSERT INTO `schedule` VALUES ('1', '2', '1', '2', '2');
INSERT INTO `schedule` VALUES ('1', '3', '1', '3', '3');
INSERT INTO `schedule` VALUES ('1', '4', '2', '1', '1');
INSERT INTO `schedule` VALUES ('1', '5', '3', '2', '2');
INSERT INTO `schedule` VALUES ('2', '1', '1', '1', '1');
INSERT INTO `schedule` VALUES ('2', '2', '1', '2', '2');
INSERT INTO `schedule` VALUES ('2', '3', '1', '3', '3');
INSERT INTO `schedule` VALUES ('2', '4', '2', '1', '1');
INSERT INTO `schedule` VALUES ('2', '5', '3', '2', '2');
INSERT INTO `schedule` VALUES ('3', '1', '1', '1', '1');
INSERT INTO `schedule` VALUES ('3', '2', '1', '2', '2');
INSERT INTO `schedule` VALUES ('3', '3', '1', '3', '3');
INSERT INTO `schedule` VALUES ('3', '4', '2', '1', '1');
INSERT INTO `schedule` VALUES ('3', '5', '3', '2', '2');
INSERT INTO `schedule` VALUES ('4', '1', '1', '1', '1');
INSERT INTO `schedule` VALUES ('4', '2', '1', '2', '2');
INSERT INTO `schedule` VALUES ('4', '3', '1', '3', '3');
INSERT INTO `schedule` VALUES ('4', '4', '2', '1', '1');
INSERT INTO `schedule` VALUES ('4', '5', '3', '2', '2');

-- ----------------------------
-- Table structure for schedule1
-- ----------------------------
DROP TABLE IF EXISTS `schedule1`;
CREATE TABLE `schedule1` (
  `cinemaID` int(20) DEFAULT NULL,
  `videoHallID` int(10) DEFAULT NULL,
  `dayID` int(10) DEFAULT NULL,
  `timeID` int(10) DEFAULT NULL,
  `filmID` int(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule1
-- ----------------------------
INSERT INTO `schedule1` VALUES ('1', '1', '1', '1', '1');
INSERT INTO `schedule1` VALUES ('1', '2', '1', '2', '2');
INSERT INTO `schedule1` VALUES ('1', '3', '1', '3', '3');
INSERT INTO `schedule1` VALUES ('1', '4', '2', '1', '1');
INSERT INTO `schedule1` VALUES ('1', '5', '3', '2', '2');

-- ----------------------------
-- Table structure for schedule2
-- ----------------------------
DROP TABLE IF EXISTS `schedule2`;
CREATE TABLE `schedule2` (
  `cinemaID` int(20) DEFAULT NULL,
  `videoHallID` int(10) DEFAULT NULL,
  `dayID` int(10) DEFAULT NULL,
  `timeID` int(10) DEFAULT NULL,
  `filmID` int(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule2
-- ----------------------------
INSERT INTO `schedule2` VALUES ('2', '1', '1', '1', '1');
INSERT INTO `schedule2` VALUES ('2', '2', '1', '2', '2');
INSERT INTO `schedule2` VALUES ('2', '3', '1', '3', '3');
INSERT INTO `schedule2` VALUES ('2', '4', '2', '1', '1');
INSERT INTO `schedule2` VALUES ('2', '5', '3', '2', '2');

-- ----------------------------
-- Table structure for schedule3
-- ----------------------------
DROP TABLE IF EXISTS `schedule3`;
CREATE TABLE `schedule3` (
  `cinemaID` int(20) DEFAULT NULL,
  `videoHallID` int(10) DEFAULT NULL,
  `dayID` int(10) DEFAULT NULL,
  `timeID` int(10) DEFAULT NULL,
  `filmID` int(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule3
-- ----------------------------
INSERT INTO `schedule3` VALUES ('3', '1', '1', '1', '1');
INSERT INTO `schedule3` VALUES ('3', '2', '1', '2', '2');
INSERT INTO `schedule3` VALUES ('3', '3', '1', '3', '3');
INSERT INTO `schedule3` VALUES ('3', '4', '2', '1', '1');
INSERT INTO `schedule3` VALUES ('3', '5', '3', '2', '2');

-- ----------------------------
-- Table structure for schedule4
-- ----------------------------
DROP TABLE IF EXISTS `schedule4`;
CREATE TABLE `schedule4` (
  `cinemaID` int(20) DEFAULT NULL,
  `videoHallID` int(10) DEFAULT NULL,
  `dayID` int(10) DEFAULT NULL,
  `timeID` int(10) DEFAULT NULL,
  `filmID` int(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schedule4
-- ----------------------------
INSERT INTO `schedule4` VALUES ('4', '1', '1', '1', '1');
INSERT INTO `schedule4` VALUES ('4', '2', '1', '2', '2');
INSERT INTO `schedule4` VALUES ('4', '3', '1', '3', '3');
INSERT INTO `schedule4` VALUES ('4', '4', '2', '1', '1');
INSERT INTO `schedule4` VALUES ('4', '5', '3', '2', '2');

-- ----------------------------
-- Table structure for seats
-- ----------------------------
DROP TABLE IF EXISTS `seats`;
CREATE TABLE `seats` (
  `videoHallID` int(10) DEFAULT NULL,
  `seatID` int(10) DEFAULT NULL,
  `columnID` int(10) DEFAULT NULL,
  `rowID` int(10) DEFAULT NULL,
  `isSell` int(3) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of seats
-- ----------------------------
INSERT INTO `seats` VALUES ('1', '1', '1', '1', '0');
INSERT INTO `seats` VALUES ('1', '2', '1', '2', '0');
INSERT INTO `seats` VALUES ('1', '3', '1', '3', '0');
INSERT INTO `seats` VALUES ('1', '4', '1', '4', '0');
INSERT INTO `seats` VALUES ('1', '5', '1', '5', '0');
INSERT INTO `seats` VALUES ('1', '6', '2', '1', '0');
INSERT INTO `seats` VALUES ('1', '7', '2', '2', '0');
INSERT INTO `seats` VALUES ('1', '8', '2', '3', '0');
INSERT INTO `seats` VALUES ('1', '9', '2', '4', '0');
INSERT INTO `seats` VALUES ('1', '10', '2', '5', '0');
INSERT INTO `seats` VALUES ('1', '11', '3', '1', '0');
INSERT INTO `seats` VALUES ('1', '12', '3', '2', '0');
INSERT INTO `seats` VALUES ('1', '13', '3', '3', '0');
INSERT INTO `seats` VALUES ('1', '14', '3', '4', '0');
INSERT INTO `seats` VALUES ('1', '15', '3', '5', '0');
INSERT INTO `seats` VALUES ('1', '16', '4', '1', '0');
INSERT INTO `seats` VALUES ('1', '17', '4', '2', '0');
INSERT INTO `seats` VALUES ('1', '18', '4', '3', '0');
INSERT INTO `seats` VALUES ('1', '19', '4', '4', '0');
INSERT INTO `seats` VALUES ('1', '20', '4', '5', '0');
INSERT INTO `seats` VALUES ('1', '21', '5', '1', '0');
INSERT INTO `seats` VALUES ('1', '22', '5', '2', '0');
INSERT INTO `seats` VALUES ('1', '23', '5', '3', '0');
INSERT INTO `seats` VALUES ('1', '24', '5', '4', '0');
INSERT INTO `seats` VALUES ('1', '25', '5', '5', '0');
INSERT INTO `seats` VALUES ('2', '1', '1', '1', '0');
INSERT INTO `seats` VALUES ('2', '2', '1', '2', '0');
INSERT INTO `seats` VALUES ('2', '3', '1', '3', '0');
INSERT INTO `seats` VALUES ('2', '4', '1', '4', '0');
INSERT INTO `seats` VALUES ('2', '5', '1', '5', '0');
INSERT INTO `seats` VALUES ('2', '6', '2', '1', '0');
INSERT INTO `seats` VALUES ('2', '7', '2', '2', '0');
INSERT INTO `seats` VALUES ('2', '8', '2', '3', '0');
INSERT INTO `seats` VALUES ('2', '9', '2', '4', '0');
INSERT INTO `seats` VALUES ('2', '10', '2', '5', '0');
INSERT INTO `seats` VALUES ('2', '11', '3', '1', '0');
INSERT INTO `seats` VALUES ('2', '12', '3', '2', '0');
INSERT INTO `seats` VALUES ('2', '13', '3', '3', '0');
INSERT INTO `seats` VALUES ('2', '14', '3', '4', '0');
INSERT INTO `seats` VALUES ('2', '15', '3', '5', '0');
INSERT INTO `seats` VALUES ('2', '16', '4', '1', '0');
INSERT INTO `seats` VALUES ('2', '17', '4', '2', '0');
INSERT INTO `seats` VALUES ('2', '18', '4', '3', '0');
INSERT INTO `seats` VALUES ('2', '19', '4', '4', '0');
INSERT INTO `seats` VALUES ('2', '20', '4', '5', '0');
INSERT INTO `seats` VALUES ('2', '21', '5', '1', '0');
INSERT INTO `seats` VALUES ('2', '22', '5', '2', '0');
INSERT INTO `seats` VALUES ('2', '23', '5', '3', '0');
INSERT INTO `seats` VALUES ('2', '24', '5', '4', '0');
INSERT INTO `seats` VALUES ('2', '25', '5', '5', '0');
INSERT INTO `seats` VALUES ('3', '1', '1', '1', '0');
INSERT INTO `seats` VALUES ('3', '2', '1', '2', '0');
INSERT INTO `seats` VALUES ('3', '3', '1', '3', '0');
INSERT INTO `seats` VALUES ('3', '4', '1', '4', '0');
INSERT INTO `seats` VALUES ('3', '5', '1', '5', '0');
INSERT INTO `seats` VALUES ('3', '6', '2', '1', '0');
INSERT INTO `seats` VALUES ('3', '7', '2', '2', '0');
INSERT INTO `seats` VALUES ('3', '8', '2', '3', '0');
INSERT INTO `seats` VALUES ('3', '9', '2', '4', '0');
INSERT INTO `seats` VALUES ('3', '10', '2', '5', '0');
INSERT INTO `seats` VALUES ('3', '11', '3', '1', '0');
INSERT INTO `seats` VALUES ('3', '12', '3', '2', '0');
INSERT INTO `seats` VALUES ('3', '13', '3', '3', '0');
INSERT INTO `seats` VALUES ('3', '14', '3', '4', '0');
INSERT INTO `seats` VALUES ('3', '15', '3', '5', '0');
INSERT INTO `seats` VALUES ('3', '16', '4', '1', '0');
INSERT INTO `seats` VALUES ('3', '17', '4', '2', '0');
INSERT INTO `seats` VALUES ('3', '18', '4', '3', '0');
INSERT INTO `seats` VALUES ('3', '19', '4', '4', '0');
INSERT INTO `seats` VALUES ('3', '20', '4', '5', '0');
INSERT INTO `seats` VALUES ('3', '21', '5', '1', '0');
INSERT INTO `seats` VALUES ('3', '22', '5', '2', '0');
INSERT INTO `seats` VALUES ('3', '23', '5', '3', '0');
INSERT INTO `seats` VALUES ('3', '24', '5', '4', '0');
INSERT INTO `seats` VALUES ('3', '25', '5', '5', '0');
INSERT INTO `seats` VALUES ('4', '1', '1', '1', '0');
INSERT INTO `seats` VALUES ('4', '2', '1', '2', '0');
INSERT INTO `seats` VALUES ('4', '3', '1', '3', '0');
INSERT INTO `seats` VALUES ('4', '4', '1', '4', '0');
INSERT INTO `seats` VALUES ('4', '5', '1', '5', '0');
INSERT INTO `seats` VALUES ('4', '6', '2', '1', '0');
INSERT INTO `seats` VALUES ('4', '7', '2', '2', '0');
INSERT INTO `seats` VALUES ('4', '8', '2', '3', '0');
INSERT INTO `seats` VALUES ('4', '9', '2', '4', '0');
INSERT INTO `seats` VALUES ('4', '10', '2', '5', '0');
INSERT INTO `seats` VALUES ('4', '11', '3', '1', '0');
INSERT INTO `seats` VALUES ('4', '12', '3', '2', '0');
INSERT INTO `seats` VALUES ('4', '13', '3', '3', '0');
INSERT INTO `seats` VALUES ('4', '14', '3', '4', '0');
INSERT INTO `seats` VALUES ('4', '15', '3', '5', '0');
INSERT INTO `seats` VALUES ('4', '16', '4', '1', '0');
INSERT INTO `seats` VALUES ('4', '17', '4', '2', '0');
INSERT INTO `seats` VALUES ('4', '18', '4', '3', '0');
INSERT INTO `seats` VALUES ('4', '19', '4', '4', '0');
INSERT INTO `seats` VALUES ('4', '20', '4', '5', '0');
INSERT INTO `seats` VALUES ('4', '21', '5', '1', '0');
INSERT INTO `seats` VALUES ('4', '22', '5', '2', '0');
INSERT INTO `seats` VALUES ('4', '23', '5', '3', '0');
INSERT INTO `seats` VALUES ('4', '24', '5', '4', '0');
INSERT INTO `seats` VALUES ('4', '25', '5', '5', '0');

-- ----------------------------
-- Table structure for times
-- ----------------------------
DROP TABLE IF EXISTS `times`;
CREATE TABLE `times` (
  `timeID` int(10) DEFAULT NULL,
  `timeName` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of times
-- ----------------------------
INSERT INTO `times` VALUES ('1', '8:00-10:30');
INSERT INTO `times` VALUES ('2', '11:00-13:30');
INSERT INTO `times` VALUES ('3', '14:00-16:30');
INSERT INTO `times` VALUES ('4', '17:00-19:30');
INSERT INTO `times` VALUES ('5', '20:00-22:30');
INSERT INTO `times` VALUES ('6', '23:00-01:30');

-- ----------------------------
-- Table structure for videohall
-- ----------------------------
DROP TABLE IF EXISTS `videohall`;
CREATE TABLE `videohall` (
  `cinemaID` int(10) DEFAULT NULL,
  `videoHallID` int(10) DEFAULT NULL,
  `videoHallName` varchar(30) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of videohall
-- ----------------------------
INSERT INTO `videohall` VALUES ('1', '1', '风');
INSERT INTO `videohall` VALUES ('1', '2', '林');
INSERT INTO `videohall` VALUES ('1', '3', '火');
INSERT INTO `videohall` VALUES ('1', '4', '山');
INSERT INTO `videohall` VALUES ('2', '1', '天');
INSERT INTO `videohall` VALUES ('2', '2', '地');
INSERT INTO `videohall` VALUES ('2', '3', '人');
INSERT INTO `videohall` VALUES ('2', '4', '合');
INSERT INTO `videohall` VALUES ('3', '1', '水');
INSERT INTO `videohall` VALUES ('3', '2', '火');
INSERT INTO `videohall` VALUES ('3', '3', '金');
INSERT INTO `videohall` VALUES ('3', '4', '土');
INSERT INTO `videohall` VALUES ('4', '1', '金');
INSERT INTO `videohall` VALUES ('4', '2', '银');
INSERT INTO `videohall` VALUES ('4', '3', '铜');
INSERT INTO `videohall` VALUES ('4', '4', '铁');
