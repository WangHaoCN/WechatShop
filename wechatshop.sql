/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : wechatshop

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2017-07-28 09:51:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `openId` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `school` varchar(255) DEFAULT NULL,
  `buildingNo` varchar(255) DEFAULT NULL,
  `roomNo` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `moren` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `key_OPENID_user` (`openId`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('14', 'a1053', '1', '1', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '1');
INSERT INTO `address` VALUES ('15', 'a1053', '2', '2', '山东农业大学东校区', '男生宿舍1号楼', '2', '2', '2', '0');
INSERT INTO `address` VALUES ('16', 'a1053', '山东', '泰安', '山东农业大学南校区', '男生宿舍1号楼', '523', '王浩', '17863802459', '0');
INSERT INTO `address` VALUES ('17', 'a1053', '山东', '泰安', '山东农业大学南校区', '男生宿舍1号楼', '523', '王浩', '17863802459', '0');
INSERT INTO `address` VALUES ('18', 'a1053', '3', '3', '泰山医学院老校', '2号楼', '3', '3', '3', '0');
INSERT INTO `address` VALUES ('19', 'a1053', '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('20', 'a1053', '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('21', 'a1053', '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('22', 'a1053', '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('23', 'a1053', '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('24', 'a1053', '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('25', 'a1053', '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('26', 'a1053', '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('27', null, '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('28', null, '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('29', null, '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('30', null, '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('31', 'a1053', '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('32', 'a1053', '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('33', 'a1053', '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('34', 'a1053', '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('35', 'a1053', '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('36', 'a1053', '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('37', 'a1053', '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('38', 'a1053', '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('39', null, '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('40', null, '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('41', null, '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('42', null, '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('43', null, '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('44', null, '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('45', null, '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('46', null, '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('47', null, '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('48', null, '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('49', null, '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('50', null, '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('51', null, '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('52', null, '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('53', null, '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('54', null, '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('55', null, '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('56', null, '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('57', null, '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('58', null, '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('59', null, '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('60', null, '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('61', null, '11', '', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');
INSERT INTO `address` VALUES ('62', null, '山东', '泰安', '山东农业大学北校区（本部）', '男生宿舍4号楼', '523', '王浩', '17863802459', '0');
INSERT INTO `address` VALUES ('63', null, '山东', '泰安', '山东农业大学北校区（本部）', '男生宿舍5号楼', '523', '王浩', '178', '0');
INSERT INTO `address` VALUES ('64', null, '山东', '泰安', '山东农业大学东校区', '男生宿舍1号楼', '220', '王浩', '17863802459', '0');
INSERT INTO `address` VALUES ('65', null, '山东', '泰安', '山东农业大学南校区', '男生宿舍3号楼', '523', '王浩', '17863802459', '0');
INSERT INTO `address` VALUES ('66', null, '山东', '泰安', '山东农业大学北校区（本部）', '男生宿舍4号楼', '523', '王浩', '17863802459', '0');
INSERT INTO `address` VALUES ('67', null, '1', '1', '山东农业大学东校区', '男生宿舍1号楼', '1', '1', '1', '0');

-- ----------------------------
-- Table structure for `indent`
-- ----------------------------
DROP TABLE IF EXISTS `indent`;
CREATE TABLE `indent` (
  `id` int(20) NOT NULL,
  `warelist` varchar(255) DEFAULT NULL,
  `price` float(20,0) DEFAULT NULL,
  `userId` int(20) DEFAULT NULL,
  `checkout` varchar(255) DEFAULT NULL,
  `delivery` int(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of indent
-- ----------------------------

-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `managerId` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `buildingNo` varchar(255) DEFAULT NULL,
  `school` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `idNumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`managerId`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', '谢庆贺', '123456', '112', '山农', '110', '111');
INSERT INTO `manager` VALUES ('2', '张三', '111111', '111', '山农', '111', '1111');
INSERT INTO `manager` VALUES ('3', '李四', '333333', '333', '山农', '333', '333');
INSERT INTO `manager` VALUES ('4', '222', '222', '222', '222', '222', '222');
INSERT INTO `manager` VALUES ('5', '测试1', '测试111', '测试1', '测试1', '测试1111', '测试1');
INSERT INTO `manager` VALUES ('6', '测试1', '测试1', '测试1', '测试1', '测试1', '测试1');
INSERT INTO `manager` VALUES ('7', '测试1', '测试1', '测试1', '测试1', '测试1', '测试1');
INSERT INTO `manager` VALUES ('8', '测试1', '测试1', '测试1', '测试1', '测试1', '测试1');
INSERT INTO `manager` VALUES ('9', '测试1', '测试1', '测试1', '测试1', '测试1', '测试1');
INSERT INTO `manager` VALUES ('10', '测试1', '测试1', '测试1', '测试1', '测试1', '测试1');
INSERT INTO `manager` VALUES ('11', '测试1', '测试1', '测试1', '测试1', '测试1', '测试1');
INSERT INTO `manager` VALUES ('12', '测试1', '测试1', '测试1', '测试1', '测试1', '测试1');
INSERT INTO `manager` VALUES ('13', '测试1', '测试1', '测试1', '测试1', '测试1', '测试1');
INSERT INTO `manager` VALUES ('14', '测试1', '测试1', '测试1', '测试1', '测试1', '测试1');
INSERT INTO `manager` VALUES ('15', '测试1', '测试1', '测试1', '测试1', '测试1', '测试1');
INSERT INTO `manager` VALUES ('16', '测试1', '测试1', '测试1', '测试1', '测试1', '测试1');
INSERT INTO `manager` VALUES ('17', '测试1', '测试1', '测试1', '测试1', '测试1', '测试1');
INSERT INTO `manager` VALUES ('18', '测试1', '测试1', '测试1', '测试1', '测试1', '测试1');
INSERT INTO `manager` VALUES ('19', '测试1', '测试1', '测试1', '测试1', '测试1', '测试1');
INSERT INTO `manager` VALUES ('20', '测试1', '测试1', '测试1', '测试1', '测试1', '测试1');
INSERT INTO `manager` VALUES ('21', '测试1', '测试1', '测试1', '测试1', '测试1', '测试1');
INSERT INTO `manager` VALUES ('22', '测试1', '测试1', '测试1', '测试1', '测试1', '测试1');
INSERT INTO `manager` VALUES ('23', '测试1', '测试1', '测试1', '测试1', '测试1', '测试1');
INSERT INTO `manager` VALUES ('24', '测试1', '测试1', '测试1', '测试1', '测试1', '测试1');
INSERT INTO `manager` VALUES ('25', '测试1', '测试1', '测试1', '测试1', '测试1', '测试1');
INSERT INTO `manager` VALUES ('26', '测试1', '测试1', '测试1', '测试1', '测试1', '测试1');
INSERT INTO `manager` VALUES ('27', '测试1', '测试1', '测试1', '测试1', '测试1', '测试1');
INSERT INTO `manager` VALUES ('28', '测试1', '测试1', '测试1', '测试1', '测试1', '测试1');
INSERT INTO `manager` VALUES ('29', '测试1', '测试1', '测试1', '测试1', '测试1', '测试1');

-- ----------------------------
-- Table structure for `school`
-- ----------------------------
DROP TABLE IF EXISTS `school`;
CREATE TABLE `school` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `school` varchar(255) DEFAULT NULL,
  `building` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of school
-- ----------------------------
INSERT INTO `school` VALUES ('1', '山东农业大学东校区', '男生宿舍1号楼');
INSERT INTO `school` VALUES ('2', '山东农业大学东校区', '男生宿舍2号楼');
INSERT INTO `school` VALUES ('3', '山东农业大学东校区', '男生宿舍3号楼');
INSERT INTO `school` VALUES ('4', '山东农业大学东校区', '女生宿舍4号楼');
INSERT INTO `school` VALUES ('5', '山东农业大学北校区（本部）', '男生宿舍1号楼');
INSERT INTO `school` VALUES ('6', '山东农业大学北校区（本部）', '男生宿舍2号楼');
INSERT INTO `school` VALUES ('7', '山东农业大学北校区（本部）', '男生宿舍3号楼');
INSERT INTO `school` VALUES ('8', '山东农业大学北校区（本部）', '男生宿舍4号楼');
INSERT INTO `school` VALUES ('9', '山东农业大学北校区（本部）', '男生宿舍5号楼');
INSERT INTO `school` VALUES ('10', '山东农业大学北校区（本部）', '男生宿舍6号楼');
INSERT INTO `school` VALUES ('11', '山东农业大学北校区（本部）', '男生宿舍13号楼');
INSERT INTO `school` VALUES ('12', '山东农业大学北校区（本部）', '女生宿舍7号楼');
INSERT INTO `school` VALUES ('13', '山东农业大学北校区（本部）', '女生宿舍8号楼');
INSERT INTO `school` VALUES ('14', '山东农业大学北校区（本部）', '女生宿舍9号楼');
INSERT INTO `school` VALUES ('15', '山东农业大学北校区（本部）', '女生宿舍10号楼');
INSERT INTO `school` VALUES ('16', '山东农业大学北校区（本部）', '女生宿舍11号楼');
INSERT INTO `school` VALUES ('17', '山东农业大学北校区（本部）', '女生宿舍12号楼');
INSERT INTO `school` VALUES ('18', '山东农业大学北校区（本部）', '女生宿舍15号楼');
INSERT INTO `school` VALUES ('19', '山东农业大学北校区（本部）', '女生宿舍11号楼');
INSERT INTO `school` VALUES ('20', '山东农业大学北校区（本部）', '德馨公寓14号楼');
INSERT INTO `school` VALUES ('21', '山东农业大学北校区（本部）', '德馨公寓15号楼');
INSERT INTO `school` VALUES ('22', '山东农业大学北校区（本部）', '德馨公寓16号楼');
INSERT INTO `school` VALUES ('23', '山东农业大学北校区（本部）', '德馨公寓17号楼');
INSERT INTO `school` VALUES ('24', '山东农业大学南校区', '男生宿舍1号楼');
INSERT INTO `school` VALUES ('25', '山东农业大学南校区', '男生宿舍2号楼');
INSERT INTO `school` VALUES ('26', '山东农业大学南校区', '男生宿舍3号楼');
INSERT INTO `school` VALUES ('27', '山东农业大学南校区', '男生宿舍4号楼');
INSERT INTO `school` VALUES ('28', '山东农业大学南校区', '男生宿舍5号楼');
INSERT INTO `school` VALUES ('29', '山东农业大学南校区', '男生宿舍6号楼');
INSERT INTO `school` VALUES ('30', '山东农业大学南校区', '男生宿舍13号楼');
INSERT INTO `school` VALUES ('31', '山东农业大学南校区', '男生宿舍14号楼');
INSERT INTO `school` VALUES ('32', '山东农业大学南校区', '女生宿舍7号楼');
INSERT INTO `school` VALUES ('33', '山东农业大学南校区', '女生宿舍8号楼');
INSERT INTO `school` VALUES ('34', '山东农业大学南校区', '女生宿舍9号楼');
INSERT INTO `school` VALUES ('35', '山东农业大学南校区', '女生宿舍10号楼');
INSERT INTO `school` VALUES ('36', '山东农业大学南校区', '女生宿舍11号楼');
INSERT INTO `school` VALUES ('37', '山东农业大学南校区', '女生宿舍12号楼');
INSERT INTO `school` VALUES ('38', '山东农业大学南校区', '女生宿舍15号楼（品慧楼）');
INSERT INTO `school` VALUES ('39', '山东农业大学南校区', '家属院青蓝公寓');
INSERT INTO `school` VALUES ('40', '泰山医学院老校', '2号楼');
INSERT INTO `school` VALUES ('41', '泰山医学院老校', '4号楼');
INSERT INTO `school` VALUES ('42', '泰山医学院老校', '5号楼');
INSERT INTO `school` VALUES ('43', '泰山医学院老校', '6号楼');
INSERT INTO `school` VALUES ('44', '泰山医学院老校', '7号楼');
INSERT INTO `school` VALUES ('45', '泰山医学院老校', '8号楼');
INSERT INTO `school` VALUES ('46', '泰山医学院新校区', '3号楼');
INSERT INTO `school` VALUES ('47', '泰山医学院新校区', '6号楼');
INSERT INTO `school` VALUES ('48', '泰山医学院新校区', '榴园C座1-4层');
INSERT INTO `school` VALUES ('49', '泰山医学院新校区', '松竹园东座');
INSERT INTO `school` VALUES ('50', '泰山医学院新校区', '松竹园中座');
INSERT INTO `school` VALUES ('51', '泰山医学院新校区', '松竹园西座');
INSERT INTO `school` VALUES ('52', '泰山医学院新校区', '桂园B座');
INSERT INTO `school` VALUES ('53', '泰山医学院新校区', '桂园C座');
INSERT INTO `school` VALUES ('54', '泰山医学院新校区', '桂园D座');
INSERT INTO `school` VALUES ('55', '泰山医学院新校区', '杏园A座');
INSERT INTO `school` VALUES ('56', '泰山医学院新校区', '栗园A座');
INSERT INTO `school` VALUES ('57', '泰山医学院新校区', '栗园B座');
INSERT INTO `school` VALUES ('58', '泰山医学院新校区', '紫薇园A座');
INSERT INTO `school` VALUES ('59', '泰山医学院新校区', '紫薇园B座');
INSERT INTO `school` VALUES ('60', '泰山医学院新校区', '紫薇园C座');
INSERT INTO `school` VALUES ('61', '泰山医学院新校区', '紫薇园D座');
INSERT INTO `school` VALUES ('62', '泰山医学院新校区', '榴园b座');
INSERT INTO `school` VALUES ('63', '泰山医学院新校区', '樱花园a座');
INSERT INTO `school` VALUES ('64', '泰山医学院新校区', '樱花园b座');

-- ----------------------------
-- Table structure for `shoppingcart`
-- ----------------------------
DROP TABLE IF EXISTS `shoppingcart`;
CREATE TABLE `shoppingcart` (
  `cartId` int(20) NOT NULL,
  `warelists` varchar(1000) DEFAULT NULL,
  `price` float(20,0) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cartId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shoppingcart
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `openid` varchar(255) NOT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `sex` int(5) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `headImgUrl` varchar(255) DEFAULT NULL,
  `privilegeList` varchar(255) DEFAULT NULL,
  `subscribeTime` varchar(1024) DEFAULT NULL,
  `subscribe` int(1) DEFAULT '0',
  PRIMARY KEY (`openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', null, '111', '测试数据1', null, '测试数据1', null, null, null, null);
INSERT INTO `user` VALUES ('用户1', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户10', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户11', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户12', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户13', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户14', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户15', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户16', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户17', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户18', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户19', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户2', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户20', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户21', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户22', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户23', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户24', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户25', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户26', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户27', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户28', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户29', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户3', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户30', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户31', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户32', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户33', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户34', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户35', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户36', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户37', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户38', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户39', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户4', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户40', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户41', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户42', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户43', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户5', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户6', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户7', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户8', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);
INSERT INTO `user` VALUES ('用户9', '测试1', '18', '测试1', '测试1', '测试1', '测试1', '测试1', null, null);

-- ----------------------------
-- Table structure for `ware`
-- ----------------------------
DROP TABLE IF EXISTS `ware`;
CREATE TABLE `ware` (
  `wareId` int(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `describe` varchar(1000) DEFAULT NULL,
  `price` double(50,2) DEFAULT NULL,
  `kind` varchar(255) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `managerid` int(20) DEFAULT NULL,
  `imageUrl` varchar(255) DEFAULT NULL,
  `yuanjia` double(50,2) DEFAULT NULL,
  PRIMARY KEY (`wareId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ware
-- ----------------------------
INSERT INTO `ware` VALUES ('1', '名字', '描述', '10.25', '水果', '时间', '1', 'dagsdklahdka', '20.50');
INSERT INTO `ware` VALUES ('2', '康师傅 方便面（KSF） 经典系列 红烧牛肉 泡面 五连包', '京东自营，方便速食品尝舌尖上美味。部分商品三件5折【更多优惠请点击这里】(此商品不参加上述活动)', '12.50', '零食', '6-29 11:10', '2', null, '15.20');
INSERT INTO `ware` VALUES ('3', '其他', '其他商品描述', '10.11', '其他', '时间', '2', null, '13.00');
