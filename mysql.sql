/*创建测试表--test*/
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `context` varchar(255) DEFAULT NULL COMMENT 'context',
  `updateTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'updateTime',
  PRIMARY KEY (`ID`)
) DEFAULT CHARSET=utf8;

/*创建用户表--user*/
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `loginName` varchar(255) NOT NULL COMMENT '登录名，格式为手机号',
  `password` varchar(255) NOT NULL COMMENT '密码',
  PRIMARY KEY (`ID`)
) DEFAULT CHARSET=utf8;

/*在user表中添加一个用户13889259343  123456*/
INSERT INTO USER (loginName, password) VALUES ('13889259343', '92894219EF3E7B6D752F058D31C5166C');

/*操作日志表*/
DROP TABLE IF EXISTS `permission_logs`;
CREATE TABLE `permission_logs` (
  `logsID` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志id',
  `orgID` int(11) NOT NULL COMMENT '机构ID',
  `userID` int(11) NOT NULL COMMENT '用户ID',
  `accountID` int(11) NOT NULL COMMENT '账号ID',
  `logsDT` datetime NOT NULL COMMENT '日志生成时间',
  `logsTitle` varchar(1024) NOT NULL COMMENT '日志标题',
  `logsContent` text COMMENT '日志内容',
  `isDelete` int(11) NOT NULL COMMENT '是否删除 默认1 未删除， 0 删除',
  `isCurrent` int(11) NOT NULL COMMENT '0：未启动 1：启用',
  PRIMARY KEY (`logsID`)
) DEFAULT CHARSET=utf8;

/*机构表*/
DROP TABLE IF EXISTS `permission_org`;
CREATE TABLE `permission_org` (
  `orgID` int(11) NOT NULL AUTO_INCREMENT COMMENT '机构ID',
  `orgCode` varchar(255) NOT NULL COMMENT '机构编码',
  `orgName` varchar(1024) NOT NULL COMMENT '机构名称',
  `orgShortName` varchar(255) DEFAULT NULL COMMENT '机构简称',
  `orgLevel` int(11) NOT NULL COMMENT '机构等级',
  `parentOrgID` int(11) NOT NULL COMMENT '上级机构ID',
  `sortNum` int(11) NOT NULL COMMENT '顺序',
  `isCurrent` int(11) NOT NULL COMMENT '0：未启动 1：启用',
  `isDelete` int(11) NOT NULL COMMENT '是否删除 默认1 未删除， 0 删除',
  `createDT` datetime NOT NULL COMMENT '创建时间',
  `theNote` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`orgID`)
) DEFAULT CHARSET=utf8;
/*为组织树添加跟节点*/
insert into 
	permission_org (orgID, orgCode, orgName, orgShortName, orgLevel, parentOrgID, sortNum, isCurrent, isDelete, createDT, theNote) 
values ( 1001, 'ORG1001', '机构树', '机构树', 0, 0, 0, 1, 1, now(), '组织机构树根节点，请勿删除');

/*岗位表*/
DROP TABLE IF EXISTS `permission_post`;
CREATE TABLE `permission_post` (
  `postID` int(11) NOT NULL AUTO_INCREMENT COMMENT '岗位Id',
  `postName` varchar(255) NOT NULL COMMENT '岗位名称',
  `sortNum` int(11) NOT NULL COMMENT '顺序',
  `isDelete` int(11) NOT NULL COMMENT '是否删除 默认1 未删除， 0 删除',
  `isCurrent` int(11) NOT NULL COMMENT '0：未启动 1：启用',
  `theNote` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`postID`)
) DEFAULT CHARSET=utf8;

/*职级表*/
DROP TABLE IF EXISTS `permission_rank`;
CREATE TABLE `permission_rank` (
  `rankID` int(11) NOT NULL AUTO_INCREMENT COMMENT '职级ID',
  `rankName` varchar(255) DEFAULT NULL COMMENT '职级名称',
  `parentRankID` int(11) DEFAULT NULL COMMENT '上级职位ID',
  `rankLevel` int(11) DEFAULT NULL COMMENT '职级等级',
  `sortNum` int(11) DEFAULT NULL COMMENT '顺序',
  `isDelete` int(11) DEFAULT NULL COMMENT '是否删除 默认1 未删除， 0 删除',
  `isCurrent` int(11) DEFAULT NULL COMMENT '0：未启动 1：启用',
  `theNote` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`rankID`)
) DEFAULT CHARSET=utf8;
/*为职级树添加跟节点*/
insert into 
	permission_rank (rankID, rankName, rankLevel, parentRankID, sortNum, isCurrent, isDelete, theNote) 
values ( 1001, '职级树', 0, 0, 0, 1, 1, '组织机构树根节点，请勿删除');


/*角色表*/
DROP TABLE IF EXISTS `permission_role`;
CREATE TABLE `permission_role` (
  `roleID` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色Id',
  `roleName` varchar(255) NOT NULL COMMENT '角色名称',
  `sortNum` int(11) NOT NULL COMMENT '顺序',
  `isCurrent` int(11) NOT NULL COMMENT '0：未启动 1：启用',
  `isDelete` int(11) NOT NULL COMMENT '是否删除 默认1 未删除， 0 删除',
  `theNote` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`roleID`)
) DEFAULT CHARSET=utf8;
/*首先加入系统超级管理员角色,ID为1*/
insert into permission_role(
	roleID, roleName, sortNum, isCurrent, isDelete, theNote
) values (
	1, '超级管理员', 1, 1, 1, '在这个系统里，无所不能'
);


/*角色权限*/
DROP TABLE IF EXISTS `permission_role_permission`;
CREATE TABLE `permission_role_permission` (
  `roleID` int(11) NOT NULL COMMENT '角色Id',
  `permissionID` int(11) NOT NULL COMMENT '权限Id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*为超级管理员角色设置权限*/
INSERT INTO `permission_role_permission` VALUES (1, 13);
INSERT INTO `permission_role_permission` VALUES (1, 14);
INSERT INTO `permission_role_permission` VALUES (1, 15);
INSERT INTO `permission_role_permission` VALUES (1, 16);
INSERT INTO `permission_role_permission` VALUES (1, 17);
INSERT INTO `permission_role_permission` VALUES (1, 18);
INSERT INTO `permission_role_permission` VALUES (1, 19);
INSERT INTO `permission_role_permission` VALUES (1, 20);
INSERT INTO `permission_role_permission` VALUES (1, 21);
INSERT INTO `permission_role_permission` VALUES (1, 22);
INSERT INTO `permission_role_permission` VALUES (1, 23);
INSERT INTO `permission_role_permission` VALUES (1, 24);
INSERT INTO `permission_role_permission` VALUES (1, 77);
INSERT INTO `permission_role_permission` VALUES (1, 78);
INSERT INTO `permission_role_permission` VALUES (1, 79);
INSERT INTO `permission_role_permission` VALUES (1, 80);
INSERT INTO `permission_role_permission` VALUES (1, 73);
INSERT INTO `permission_role_permission` VALUES (1, 74);
INSERT INTO `permission_role_permission` VALUES (1, 75);
INSERT INTO `permission_role_permission` VALUES (1, 76);
INSERT INTO `permission_role_permission` VALUES (1, 69);
INSERT INTO `permission_role_permission` VALUES (1, 70);
INSERT INTO `permission_role_permission` VALUES (1, 71);
INSERT INTO `permission_role_permission` VALUES (1, 72);
INSERT INTO `permission_role_permission` VALUES (1, 81);
INSERT INTO `permission_role_permission` VALUES (1, 82);
INSERT INTO `permission_role_permission` VALUES (1, 83);
INSERT INTO `permission_role_permission` VALUES (1, 84);
INSERT INTO `permission_role_permission` VALUES (1, 25);
INSERT INTO `permission_role_permission` VALUES (1, 26);
INSERT INTO `permission_role_permission` VALUES (1, 27);
INSERT INTO `permission_role_permission` VALUES (1, 28);
INSERT INTO `permission_role_permission` VALUES (1, 85);
INSERT INTO `permission_role_permission` VALUES (1, 86);
INSERT INTO `permission_role_permission` VALUES (1, 87);
INSERT INTO `permission_role_permission` VALUES (1, 88);
INSERT INTO `permission_role_permission` VALUES (1, 89);
INSERT INTO `permission_role_permission` VALUES (1, 90);
INSERT INTO `permission_role_permission` VALUES (1, 91);
INSERT INTO `permission_role_permission` VALUES (1, 92);
INSERT INTO `permission_role_permission` VALUES (1, 93);
INSERT INTO `permission_role_permission` VALUES (1, 94);
INSERT INTO `permission_role_permission` VALUES (1, 95);
INSERT INTO `permission_role_permission` VALUES (1, 96);
INSERT INTO `permission_role_permission` VALUES (1, 97);
INSERT INTO `permission_role_permission` VALUES (1, 98);
INSERT INTO `permission_role_permission` VALUES (1, 99);
INSERT INTO `permission_role_permission` VALUES (1, 100);
INSERT INTO `permission_role_permission` VALUES (1, 29);
INSERT INTO `permission_role_permission` VALUES (1, 30);
INSERT INTO `permission_role_permission` VALUES (1, 31);
INSERT INTO `permission_role_permission` VALUES (1, 32);
INSERT INTO `permission_role_permission` VALUES (1, 101);
INSERT INTO `permission_role_permission` VALUES (1, 102);
INSERT INTO `permission_role_permission` VALUES (1, 103);
INSERT INTO `permission_role_permission` VALUES (1, 104);
INSERT INTO `permission_role_permission` VALUES (1, 105);
INSERT INTO `permission_role_permission` VALUES (1, 106);
INSERT INTO `permission_role_permission` VALUES (1, 107);
INSERT INTO `permission_role_permission` VALUES (1, 108);
INSERT INTO `permission_role_permission` VALUES (1, 109);
INSERT INTO `permission_role_permission` VALUES (1, 110);
INSERT INTO `permission_role_permission` VALUES (1, 111);
INSERT INTO `permission_role_permission` VALUES (1, 112);
INSERT INTO `permission_role_permission` VALUES (1, 113);
INSERT INTO `permission_role_permission` VALUES (1, 114);
INSERT INTO `permission_role_permission` VALUES (1, 115);
INSERT INTO `permission_role_permission` VALUES (1, 116);
INSERT INTO `permission_role_permission` VALUES (1, 33);
INSERT INTO `permission_role_permission` VALUES (1, 34);
INSERT INTO `permission_role_permission` VALUES (1, 35);
INSERT INTO `permission_role_permission` VALUES (1, 36);
INSERT INTO `permission_role_permission` VALUES (1, 117);
INSERT INTO `permission_role_permission` VALUES (1, 118);
INSERT INTO `permission_role_permission` VALUES (1, 119);
INSERT INTO `permission_role_permission` VALUES (1, 120);
INSERT INTO `permission_role_permission` VALUES (1, 121);
INSERT INTO `permission_role_permission` VALUES (1, 122);
INSERT INTO `permission_role_permission` VALUES (1, 123);
INSERT INTO `permission_role_permission` VALUES (1, 124);
INSERT INTO `permission_role_permission` VALUES (1, 125);
INSERT INTO `permission_role_permission` VALUES (1, 126);
INSERT INTO `permission_role_permission` VALUES (1, 127);
INSERT INTO `permission_role_permission` VALUES (1, 128);
INSERT INTO `permission_role_permission` VALUES (1, 129);
INSERT INTO `permission_role_permission` VALUES (1, 130);
INSERT INTO `permission_role_permission` VALUES (1, 131);
INSERT INTO `permission_role_permission` VALUES (1, 132);
INSERT INTO `permission_role_permission` VALUES (1, 37);
INSERT INTO `permission_role_permission` VALUES (1, 38);
INSERT INTO `permission_role_permission` VALUES (1, 39);
INSERT INTO `permission_role_permission` VALUES (1, 40);
INSERT INTO `permission_role_permission` VALUES (1, 137);
INSERT INTO `permission_role_permission` VALUES (1, 138);
INSERT INTO `permission_role_permission` VALUES (1, 139);
INSERT INTO `permission_role_permission` VALUES (1, 140);
INSERT INTO `permission_role_permission` VALUES (1, 141);
INSERT INTO `permission_role_permission` VALUES (1, 142);
INSERT INTO `permission_role_permission` VALUES (1, 143);
INSERT INTO `permission_role_permission` VALUES (1, 144);
INSERT INTO `permission_role_permission` VALUES (1, 145);
INSERT INTO `permission_role_permission` VALUES (1, 146);
INSERT INTO `permission_role_permission` VALUES (1, 147);
INSERT INTO `permission_role_permission` VALUES (1, 148);
INSERT INTO `permission_role_permission` VALUES (1, 41);
INSERT INTO `permission_role_permission` VALUES (1, 42);
INSERT INTO `permission_role_permission` VALUES (1, 43);
INSERT INTO `permission_role_permission` VALUES (1, 44);
INSERT INTO `permission_role_permission` VALUES (1, 149);
INSERT INTO `permission_role_permission` VALUES (1, 150);
INSERT INTO `permission_role_permission` VALUES (1, 151);
INSERT INTO `permission_role_permission` VALUES (1, 152);
INSERT INTO `permission_role_permission` VALUES (1, 153);
INSERT INTO `permission_role_permission` VALUES (1, 154);
INSERT INTO `permission_role_permission` VALUES (1, 155);
INSERT INTO `permission_role_permission` VALUES (1, 156);
INSERT INTO `permission_role_permission` VALUES (1, 157);
INSERT INTO `permission_role_permission` VALUES (1, 158);
INSERT INTO `permission_role_permission` VALUES (1, 159);
INSERT INTO `permission_role_permission` VALUES (1, 160);
INSERT INTO `permission_role_permission` VALUES (1, 161);
INSERT INTO `permission_role_permission` VALUES (1, 162);
INSERT INTO `permission_role_permission` VALUES (1, 163);
INSERT INTO `permission_role_permission` VALUES (1, 164);
INSERT INTO `permission_role_permission` VALUES (1, 45);
INSERT INTO `permission_role_permission` VALUES (1, 46);
INSERT INTO `permission_role_permission` VALUES (1, 47);
INSERT INTO `permission_role_permission` VALUES (1, 48);
INSERT INTO `permission_role_permission` VALUES (1, 165);
INSERT INTO `permission_role_permission` VALUES (1, 166);
INSERT INTO `permission_role_permission` VALUES (1, 167);
INSERT INTO `permission_role_permission` VALUES (1, 168);
INSERT INTO `permission_role_permission` VALUES (1, 169);
INSERT INTO `permission_role_permission` VALUES (1, 170);
INSERT INTO `permission_role_permission` VALUES (1, 171);
INSERT INTO `permission_role_permission` VALUES (1, 172);
INSERT INTO `permission_role_permission` VALUES (1, 173);
INSERT INTO `permission_role_permission` VALUES (1, 174);
INSERT INTO `permission_role_permission` VALUES (1, 175);
INSERT INTO `permission_role_permission` VALUES (1, 176);
INSERT INTO `permission_role_permission` VALUES (1, 177);
INSERT INTO `permission_role_permission` VALUES (1, 178);
INSERT INTO `permission_role_permission` VALUES (1, 179);
INSERT INTO `permission_role_permission` VALUES (1, 180);
INSERT INTO `permission_role_permission` VALUES (1, 49);
INSERT INTO `permission_role_permission` VALUES (1, 50);
INSERT INTO `permission_role_permission` VALUES (1, 51);
INSERT INTO `permission_role_permission` VALUES (1, 52);
INSERT INTO `permission_role_permission` VALUES (1, 181);
INSERT INTO `permission_role_permission` VALUES (1, 182);
INSERT INTO `permission_role_permission` VALUES (1, 183);
INSERT INTO `permission_role_permission` VALUES (1, 184);
INSERT INTO `permission_role_permission` VALUES (1, 185);
INSERT INTO `permission_role_permission` VALUES (1, 186);
INSERT INTO `permission_role_permission` VALUES (1, 187);
INSERT INTO `permission_role_permission` VALUES (1, 188);
INSERT INTO `permission_role_permission` VALUES (1, 189);
INSERT INTO `permission_role_permission` VALUES (1, 190);
INSERT INTO `permission_role_permission` VALUES (1, 191);
INSERT INTO `permission_role_permission` VALUES (1, 192);
INSERT INTO `permission_role_permission` VALUES (1, 193);
INSERT INTO `permission_role_permission` VALUES (1, 194);
INSERT INTO `permission_role_permission` VALUES (1, 195);
INSERT INTO `permission_role_permission` VALUES (1, 196);
INSERT INTO `permission_role_permission` VALUES (1, 53);
INSERT INTO `permission_role_permission` VALUES (1, 54);
INSERT INTO `permission_role_permission` VALUES (1, 55);
INSERT INTO `permission_role_permission` VALUES (1, 56);
INSERT INTO `permission_role_permission` VALUES (1, 197);
INSERT INTO `permission_role_permission` VALUES (1, 198);
INSERT INTO `permission_role_permission` VALUES (1, 199);
INSERT INTO `permission_role_permission` VALUES (1, 200);
INSERT INTO `permission_role_permission` VALUES (1, 201);
INSERT INTO `permission_role_permission` VALUES (1, 202);
INSERT INTO `permission_role_permission` VALUES (1, 203);
INSERT INTO `permission_role_permission` VALUES (1, 204);
INSERT INTO `permission_role_permission` VALUES (1, 205);
INSERT INTO `permission_role_permission` VALUES (1, 206);
INSERT INTO `permission_role_permission` VALUES (1, 207);
INSERT INTO `permission_role_permission` VALUES (1, 208);
INSERT INTO `permission_role_permission` VALUES (1, 209);
INSERT INTO `permission_role_permission` VALUES (1, 210);
INSERT INTO `permission_role_permission` VALUES (1, 211);
INSERT INTO `permission_role_permission` VALUES (1, 212);

/*系统类型*/
DROP TABLE IF EXISTS `permission_apptype`;
CREATE TABLE `permission_apptype` (
  `appTypeID` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统类型ID',
  `appTypeName` varchar(255) NOT NULL COMMENT '系统类型名称',
  `sortNum` int(11) NOT NULL COMMENT '顺序',
  `isDelete` int(11) NOT NULL COMMENT '是否删除 默认1 未删除， 0 删除',
  `isCurrent` int(11) NOT NULL COMMENT '0：未启动 1：启用',
  `theNote` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`appTypeID`)
) CHARSET=utf8;
/*将该权限管理系统的系统类型录到表中*/
INSERT INTO `permission_apptype` VALUES (1, '权限系统', 1, 1, 1, '权限管理系统');

/*应用系统*/
DROP TABLE IF EXISTS `permission_app`;
CREATE TABLE `permission_app` (
  `appID` int(11) NOT NULL AUTO_INCREMENT COMMENT '应用系统ID',
  `appTypeID` int(11) NOT NULL COMMENT '所属系统类型ID',
  `appName` varchar(255) NOT NULL COMMENT '应用系统Name',
  `url` varchar(255) NOT NULL COMMENT '应用系统url',
  `iconStyle` varchar(255) DEFAULT NULL COMMENT '图标风格',
  `sortNum` int(11) NOT NULL COMMENT '顺序',
  `isDelete` int(11) NOT NULL COMMENT '是否删除 默认1 未删除， 0 删除',
  `isCurrent` int(11) NOT NULL COMMENT '0：未启动 1：启用',
  `theNote` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`appID`)
) CHARSET=utf8;
/*将该权限管理系统的信息录到表中*/
INSERT INTO `permission_app` VALUES (3, 1, '权限管理系统', '/', 'iconStyle', 1, 1, 1, '权限管理系统');


/*系统资源——SYS_APP、SYS_MENU、SYS_ELEMENTS*/
DROP TABLE IF EXISTS `permission_resource`;
CREATE TABLE `permission_resource` (
  `resourceID` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源ID',
  `selfID` int(11) NOT NULL COMMENT '本身ID',
  `selfType` varchar(255) NOT NULL COMMENT '本身类型',
  `parentID` int(11) NOT NULL COMMENT '上级ID',
  `parentType` varchar(255) NOT NULL COMMENT '上级职位类型',
  PRIMARY KEY (`resourceID`)
) CHARSET=utf8;

/*权限——系统资源与可用操作关联表*/
DROP TABLE IF EXISTS `permission_permission`;
CREATE TABLE `permission_permission` (
  `permissionID` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限Id',
  `operationID` int(11) NOT NULL COMMENT '操作ID',
  `resourceID` int(11) NOT NULL COMMENT '资源ID',
  PRIMARY KEY (`permissionID`)
) CHARSET=utf8;
/*设置资源的可用操作权限*/
INSERT INTO `permission_permission` VALUES (13, 1001, 3);
INSERT INTO `permission_permission` VALUES (14, 1002, 3);
INSERT INTO `permission_permission` VALUES (15, 1003, 3);
INSERT INTO `permission_permission` VALUES (16, 1004, 3);
INSERT INTO `permission_permission` VALUES (17, 1005, 4);
INSERT INTO `permission_permission` VALUES (18, 1006, 4);
INSERT INTO `permission_permission` VALUES (19, 1007, 4);
INSERT INTO `permission_permission` VALUES (20, 1008, 4);
INSERT INTO `permission_permission` VALUES (21, 1005, 5);
INSERT INTO `permission_permission` VALUES (22, 1006, 5);
INSERT INTO `permission_permission` VALUES (23, 1007, 5);
INSERT INTO `permission_permission` VALUES (24, 1008, 5);
INSERT INTO `permission_permission` VALUES (25, 1005, 6);
INSERT INTO `permission_permission` VALUES (26, 1006, 6);
INSERT INTO `permission_permission` VALUES (27, 1007, 6);
INSERT INTO `permission_permission` VALUES (28, 1008, 6);
INSERT INTO `permission_permission` VALUES (29, 1005, 7);
INSERT INTO `permission_permission` VALUES (30, 1006, 7);
INSERT INTO `permission_permission` VALUES (31, 1007, 7);
INSERT INTO `permission_permission` VALUES (32, 1008, 7);
INSERT INTO `permission_permission` VALUES (33, 1005, 8);
INSERT INTO `permission_permission` VALUES (34, 1006, 8);
INSERT INTO `permission_permission` VALUES (35, 1007, 8);
INSERT INTO `permission_permission` VALUES (36, 1008, 8);
INSERT INTO `permission_permission` VALUES (37, 1005, 9);
INSERT INTO `permission_permission` VALUES (38, 1006, 9);
INSERT INTO `permission_permission` VALUES (39, 1007, 9);
INSERT INTO `permission_permission` VALUES (40, 1008, 9);
INSERT INTO `permission_permission` VALUES (41, 1005, 10);
INSERT INTO `permission_permission` VALUES (42, 1006, 10);
INSERT INTO `permission_permission` VALUES (43, 1007, 10);
INSERT INTO `permission_permission` VALUES (44, 1008, 10);
INSERT INTO `permission_permission` VALUES (45, 1005, 11);
INSERT INTO `permission_permission` VALUES (46, 1006, 11);
INSERT INTO `permission_permission` VALUES (47, 1007, 11);
INSERT INTO `permission_permission` VALUES (48, 1008, 11);
INSERT INTO `permission_permission` VALUES (49, 1005, 12);
INSERT INTO `permission_permission` VALUES (50, 1006, 12);
INSERT INTO `permission_permission` VALUES (51, 1007, 12);
INSERT INTO `permission_permission` VALUES (52, 1008, 12);
INSERT INTO `permission_permission` VALUES (53, 1005, 13);
INSERT INTO `permission_permission` VALUES (54, 1006, 13);
INSERT INTO `permission_permission` VALUES (55, 1007, 13);
INSERT INTO `permission_permission` VALUES (56, 1008, 13);
INSERT INTO `permission_permission` VALUES (69, 1005, 16);
INSERT INTO `permission_permission` VALUES (70, 1006, 16);
INSERT INTO `permission_permission` VALUES (71, 1007, 16);
INSERT INTO `permission_permission` VALUES (72, 1008, 16);
INSERT INTO `permission_permission` VALUES (73, 1005, 15);
INSERT INTO `permission_permission` VALUES (74, 1006, 15);
INSERT INTO `permission_permission` VALUES (75, 1007, 15);
INSERT INTO `permission_permission` VALUES (76, 1008, 15);
INSERT INTO `permission_permission` VALUES (77, 1005, 14);
INSERT INTO `permission_permission` VALUES (78, 1006, 14);
INSERT INTO `permission_permission` VALUES (79, 1007, 14);
INSERT INTO `permission_permission` VALUES (80, 1008, 14);
INSERT INTO `permission_permission` VALUES (81, 1005, 17);
INSERT INTO `permission_permission` VALUES (82, 1006, 17);
INSERT INTO `permission_permission` VALUES (83, 1007, 17);
INSERT INTO `permission_permission` VALUES (84, 1008, 17);
INSERT INTO `permission_permission` VALUES (85, 1005, 18);
INSERT INTO `permission_permission` VALUES (86, 1006, 18);
INSERT INTO `permission_permission` VALUES (87, 1007, 18);
INSERT INTO `permission_permission` VALUES (88, 1008, 18);
INSERT INTO `permission_permission` VALUES (89, 1005, 19);
INSERT INTO `permission_permission` VALUES (90, 1006, 19);
INSERT INTO `permission_permission` VALUES (91, 1007, 19);
INSERT INTO `permission_permission` VALUES (92, 1008, 19);
INSERT INTO `permission_permission` VALUES (93, 1005, 20);
INSERT INTO `permission_permission` VALUES (94, 1006, 20);
INSERT INTO `permission_permission` VALUES (95, 1007, 20);
INSERT INTO `permission_permission` VALUES (96, 1008, 20);
INSERT INTO `permission_permission` VALUES (97, 1005, 21);
INSERT INTO `permission_permission` VALUES (98, 1006, 21);
INSERT INTO `permission_permission` VALUES (99, 1007, 21);
INSERT INTO `permission_permission` VALUES (100, 1008, 21);
INSERT INTO `permission_permission` VALUES (101, 1005, 22);
INSERT INTO `permission_permission` VALUES (102, 1006, 22);
INSERT INTO `permission_permission` VALUES (103, 1007, 22);
INSERT INTO `permission_permission` VALUES (104, 1008, 22);
INSERT INTO `permission_permission` VALUES (105, 1005, 23);
INSERT INTO `permission_permission` VALUES (106, 1006, 23);
INSERT INTO `permission_permission` VALUES (107, 1007, 23);
INSERT INTO `permission_permission` VALUES (108, 1008, 23);
INSERT INTO `permission_permission` VALUES (109, 1005, 24);
INSERT INTO `permission_permission` VALUES (110, 1006, 24);
INSERT INTO `permission_permission` VALUES (111, 1007, 24);
INSERT INTO `permission_permission` VALUES (112, 1008, 24);
INSERT INTO `permission_permission` VALUES (113, 1005, 25);
INSERT INTO `permission_permission` VALUES (114, 1006, 25);
INSERT INTO `permission_permission` VALUES (115, 1007, 25);
INSERT INTO `permission_permission` VALUES (116, 1008, 25);
INSERT INTO `permission_permission` VALUES (117, 1005, 26);
INSERT INTO `permission_permission` VALUES (118, 1006, 26);
INSERT INTO `permission_permission` VALUES (119, 1007, 26);
INSERT INTO `permission_permission` VALUES (120, 1008, 26);
INSERT INTO `permission_permission` VALUES (121, 1005, 27);
INSERT INTO `permission_permission` VALUES (122, 1006, 27);
INSERT INTO `permission_permission` VALUES (123, 1007, 27);
INSERT INTO `permission_permission` VALUES (124, 1008, 27);
INSERT INTO `permission_permission` VALUES (125, 1005, 28);
INSERT INTO `permission_permission` VALUES (126, 1006, 28);
INSERT INTO `permission_permission` VALUES (127, 1007, 28);
INSERT INTO `permission_permission` VALUES (128, 1008, 28);
INSERT INTO `permission_permission` VALUES (129, 1005, 29);
INSERT INTO `permission_permission` VALUES (130, 1006, 29);
INSERT INTO `permission_permission` VALUES (131, 1007, 29);
INSERT INTO `permission_permission` VALUES (132, 1008, 29);
INSERT INTO `permission_permission` VALUES (133, 1005, 30);
INSERT INTO `permission_permission` VALUES (134, 1006, 30);
INSERT INTO `permission_permission` VALUES (135, 1007, 30);
INSERT INTO `permission_permission` VALUES (136, 1008, 30);
INSERT INTO `permission_permission` VALUES (137, 1005, 31);
INSERT INTO `permission_permission` VALUES (138, 1006, 31);
INSERT INTO `permission_permission` VALUES (139, 1007, 31);
INSERT INTO `permission_permission` VALUES (140, 1008, 31);
INSERT INTO `permission_permission` VALUES (141, 1005, 32);
INSERT INTO `permission_permission` VALUES (142, 1006, 32);
INSERT INTO `permission_permission` VALUES (143, 1007, 32);
INSERT INTO `permission_permission` VALUES (144, 1008, 32);
INSERT INTO `permission_permission` VALUES (145, 1005, 33);
INSERT INTO `permission_permission` VALUES (146, 1006, 33);
INSERT INTO `permission_permission` VALUES (147, 1007, 33);
INSERT INTO `permission_permission` VALUES (148, 1008, 33);
INSERT INTO `permission_permission` VALUES (149, 1005, 34);
INSERT INTO `permission_permission` VALUES (150, 1006, 34);
INSERT INTO `permission_permission` VALUES (151, 1007, 34);
INSERT INTO `permission_permission` VALUES (152, 1008, 34);
INSERT INTO `permission_permission` VALUES (153, 1005, 35);
INSERT INTO `permission_permission` VALUES (154, 1006, 35);
INSERT INTO `permission_permission` VALUES (155, 1007, 35);
INSERT INTO `permission_permission` VALUES (156, 1008, 35);
INSERT INTO `permission_permission` VALUES (157, 1005, 36);
INSERT INTO `permission_permission` VALUES (158, 1006, 36);
INSERT INTO `permission_permission` VALUES (159, 1007, 36);
INSERT INTO `permission_permission` VALUES (160, 1008, 36);
INSERT INTO `permission_permission` VALUES (161, 1005, 37);
INSERT INTO `permission_permission` VALUES (162, 1006, 37);
INSERT INTO `permission_permission` VALUES (163, 1007, 37);
INSERT INTO `permission_permission` VALUES (164, 1008, 37);
INSERT INTO `permission_permission` VALUES (165, 1005, 38);
INSERT INTO `permission_permission` VALUES (166, 1006, 38);
INSERT INTO `permission_permission` VALUES (167, 1007, 38);
INSERT INTO `permission_permission` VALUES (168, 1008, 38);
INSERT INTO `permission_permission` VALUES (169, 1005, 39);
INSERT INTO `permission_permission` VALUES (170, 1006, 39);
INSERT INTO `permission_permission` VALUES (171, 1007, 39);
INSERT INTO `permission_permission` VALUES (172, 1008, 39);
INSERT INTO `permission_permission` VALUES (173, 1005, 40);
INSERT INTO `permission_permission` VALUES (174, 1006, 40);
INSERT INTO `permission_permission` VALUES (175, 1007, 40);
INSERT INTO `permission_permission` VALUES (176, 1008, 40);
INSERT INTO `permission_permission` VALUES (177, 1005, 41);
INSERT INTO `permission_permission` VALUES (178, 1006, 41);
INSERT INTO `permission_permission` VALUES (179, 1007, 41);
INSERT INTO `permission_permission` VALUES (180, 1008, 41);
INSERT INTO `permission_permission` VALUES (181, 1005, 42);
INSERT INTO `permission_permission` VALUES (182, 1006, 42);
INSERT INTO `permission_permission` VALUES (183, 1007, 42);
INSERT INTO `permission_permission` VALUES (184, 1008, 42);
INSERT INTO `permission_permission` VALUES (185, 1005, 43);
INSERT INTO `permission_permission` VALUES (186, 1006, 43);
INSERT INTO `permission_permission` VALUES (187, 1007, 43);
INSERT INTO `permission_permission` VALUES (188, 1008, 43);
INSERT INTO `permission_permission` VALUES (189, 1005, 44);
INSERT INTO `permission_permission` VALUES (190, 1006, 44);
INSERT INTO `permission_permission` VALUES (191, 1007, 44);
INSERT INTO `permission_permission` VALUES (192, 1008, 44);
INSERT INTO `permission_permission` VALUES (193, 1005, 45);
INSERT INTO `permission_permission` VALUES (194, 1006, 45);
INSERT INTO `permission_permission` VALUES (195, 1007, 45);
INSERT INTO `permission_permission` VALUES (196, 1008, 45);
INSERT INTO `permission_permission` VALUES (197, 1005, 46);
INSERT INTO `permission_permission` VALUES (198, 1006, 46);
INSERT INTO `permission_permission` VALUES (199, 1007, 46);
INSERT INTO `permission_permission` VALUES (200, 1008, 46);
INSERT INTO `permission_permission` VALUES (201, 1005, 47);
INSERT INTO `permission_permission` VALUES (202, 1006, 47);
INSERT INTO `permission_permission` VALUES (203, 1007, 47);
INSERT INTO `permission_permission` VALUES (204, 1008, 47);
INSERT INTO `permission_permission` VALUES (205, 1005, 48);
INSERT INTO `permission_permission` VALUES (206, 1006, 48);
INSERT INTO `permission_permission` VALUES (207, 1007, 48);
INSERT INTO `permission_permission` VALUES (208, 1008, 48);
INSERT INTO `permission_permission` VALUES (209, 1005, 49);
INSERT INTO `permission_permission` VALUES (210, 1006, 49);
INSERT INTO `permission_permission` VALUES (211, 1007, 49);
INSERT INTO `permission_permission` VALUES (212, 1008, 49);

/*可用操作*/
DROP TABLE IF EXISTS `permission_operation`;
CREATE TABLE `permission_operation` (
  `operationID` int(11) NOT NULL AUTO_INCREMENT COMMENT '操作ID',
  `typeCode` varchar(255) NOT NULL COMMENT '类型编码',
  `operationName` varchar(255) NOT NULL COMMENT '操作名称',
  `fun` varchar(255) NOT NULL COMMENT '方法名称',
  PRIMARY KEY (`operationID`)
) CHARSET=utf8;
/*就这些可用操作*/
INSERT permission_operation (operationID, typeCode, operationName, fun) values (1001, "SYS_APP", "可用", "doVisit");
INSERT permission_operation (operationID, typeCode, operationName, fun) values (1002, "SYS_APP", "删除", "doDelete");
INSERT permission_operation (operationID, typeCode, operationName, fun) values (1003, "SYS_APP", "修改", "doUpdate");
INSERT permission_operation (operationID, typeCode, operationName, fun) values (1004, "SYS_APP", "授权", "doGrant");
INSERT permission_operation (operationID, typeCode, operationName, fun) values (1005, "SYS_MENU", "可用", "doVisit");
INSERT permission_operation (operationID, typeCode, operationName, fun) values (1006, "SYS_MENU", "删除", "doDelete");
INSERT permission_operation (operationID, typeCode, operationName, fun) values (1007, "SYS_MENU", "修改", "doUpdate");
INSERT permission_operation (operationID, typeCode, operationName, fun) values (1008, "SYS_MENU", "授权", "doGrant");
INSERT permission_operation (operationID, typeCode, operationName, fun) values (1009, "SYS_ELEMENTS", "可用", "doVisit");
INSERT permission_operation (operationID, typeCode, operationName, fun) values (1010, "SYS_ELEMENTS", "删除", "doDelete");
INSERT permission_operation (operationID, typeCode, operationName, fun) values (1011, "SYS_ELEMENTS", "修改", "doUpdate");
INSERT permission_operation (operationID, typeCode, operationName, fun) values (1012, "SYS_ELEMENTS", "授权", "doGrant");

/*菜单*/
DROP TABLE IF EXISTS `permission_menu`;
CREATE TABLE `permission_menu` (
  `menuID` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menuName` varchar(255) NOT NULL COMMENT '菜单名称',
  `sortNum` int(11) NOT NULL COMMENT '顺序',
  `isDelete` int(11) NOT NULL COMMENT '是否删除 默认1 未删除， 0 删除',
  `isCurrent` int(11) NOT NULL COMMENT '0：未启动 1：启用',
  `theNote` varchar(1024) DEFAULT NULL COMMENT '备注',
  `menuLevel` int(11) DEFAULT NULL COMMENT '菜单级别',
  `iconStyle` varchar(255) DEFAULT NULL COMMENT '图标风格',
  `url` varchar(255) DEFAULT NULL COMMENT 'url',
  PRIMARY KEY (`menuID`)
) CHARSET=utf8;
/*将该权限管理系统的菜单录到表中*/
INSERT INTO `permission_menu` VALUES (1, '我的工作台', 1, 1, 1, '', 1, 'iconStyle', '/index');
INSERT INTO `permission_menu` VALUES (2, '机构管理', 2, 1, 1, '', 1, 'iconStyle', '/org');
INSERT INTO `permission_menu` VALUES (3, '岗位管理', 3, 1, 1, '', 1, 'iconStyle', '/post');
INSERT INTO `permission_menu` VALUES (4, '职级管理', 4, 1, 1, '', 1, 'iconStyle', '/rank');
INSERT INTO `permission_menu` VALUES (5, '角色管理', 5, 1, 1, '', 1, 'iconStyle', '/role');
INSERT INTO `permission_menu` VALUES (6, '系统类型', 6, 1, 1, '', 1, 'iconStyle', '/apptype');
INSERT INTO `permission_menu` VALUES (7, '应用系统', 7, 1, 1, '', 1, 'iconStyle', '/app');
INSERT INTO `permission_menu` VALUES (8, '菜单管理', 8, 1, 1, '', 1, 'iconStyle', '/menu');
INSERT INTO `permission_menu` VALUES (9, '页面元素', 9, 1, 1, '', 1, 'iconStyle', '/element');
INSERT INTO `permission_menu` VALUES (10, '用户管理', 10, 1, 1, '', 1, 'iconStyle', '/userInfo');

/*菜单元素*/
DROP TABLE IF EXISTS `permission_element`;
CREATE TABLE `permission_element` (
  `elementID` int(11) NOT NULL AUTO_INCREMENT COMMENT '元素ID',
  `elementName` varchar(255) NOT NULL COMMENT '元素名称',
  `elementFunction` varchar(255) NOT NULL COMMENT '元素函数',
  `elementStyle` varchar(255) DEFAULT NULL COMMENT '元素风格',
  `isCurrent` int(11) NOT NULL COMMENT '0：未启动 1：启用',
  `isDelete` int(11) NOT NULL COMMENT '是否删除 默认1 未删除， 0 删除',
  `sortNum` int(11) NOT NULL COMMENT '顺序',
  `theNote` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`elementID`)
) CHARSET=utf8;
/*将该权限管理系统的页面元素录到表中*/
INSERT INTO `permission_element` VALUES (1, '新增', 'permission.org.goRaise()', 'btn btn-success btn-next', 1, 1, 1, '');
INSERT INTO `permission_element` VALUES (2, '修改', 'permission.org.goModify()', 'btn btn-success btn-next', 1, 1, 2, '');
INSERT INTO `permission_element` VALUES (3, '查看', 'permission.org.goView()', 'btn btn-success btn-next', 1, 1, 3, '');
INSERT INTO `permission_element` VALUES (4, '删除', 'permission.org.goErase()', 'btn btn-success btn-next', 1, 1, 4, '');
INSERT INTO `permission_element` VALUES (5, '新增', 'permission.post.goRaise()', 'btn btn-success btn-next', 1, 1, 1, '');
INSERT INTO `permission_element` VALUES (6, '修改', 'permission.post.goModify()', 'btn btn-success btn-next', 1, 1, 2, '');
INSERT INTO `permission_element` VALUES (7, '查看', 'permission.post.goView()', 'btn btn-success btn-next', 1, 1, 3, '');
INSERT INTO `permission_element` VALUES (8, '删除', 'permission.post.goErase()', 'btn btn-success btn-next', 1, 1, 4, '');
INSERT INTO `permission_element` VALUES (9, '新增', 'permission.rank.goRaise()', 'btn btn-success btn-next', 1, 1, 1, '');
INSERT INTO `permission_element` VALUES (10, '修改', 'permission.rank.goModify()', 'btn btn-success btn-next', 1, 1, 2, '');
INSERT INTO `permission_element` VALUES (11, '查看', 'permission.rank.goView()', 'btn btn-success btn-next', 1, 1, 3, '');
INSERT INTO `permission_element` VALUES (12, '删除', 'permission.rank.goErase()', 'btn btn-success btn-next', 1, 1, 4, '');
INSERT INTO `permission_element` VALUES (13, '新增', 'permission.role.goRaise()', 'btn btn-success btn-next', 1, 1, 1, '');
INSERT INTO `permission_element` VALUES (14, '修改', 'permission.role.goModify()', 'btn btn-success btn-next', 1, 1, 2, '');
INSERT INTO `permission_element` VALUES (15, '查看', 'permission.role.goView()', 'btn btn-success btn-next', 1, 1, 3, '');
INSERT INTO `permission_element` VALUES (16, '删除', 'permission.role.goErase()', 'btn btn-success btn-next', 1, 1, 4, '');
INSERT INTO `permission_element` VALUES (17, '新增', 'permission.appType.goRaise()', 'btn btn-success btn-next', 1, 1, 1, '');
INSERT INTO `permission_element` VALUES (18, '修改', 'permission.appType.goModify()', 'btn btn-success btn-next', 1, 1, 2, '');
INSERT INTO `permission_element` VALUES (19, '查看', 'permission.appType.goView()', 'btn btn-success btn-next', 1, 1, 3, '');
INSERT INTO `permission_element` VALUES (20, '删除', 'permission.appType.goErase()', 'btn btn-success btn-next', 1, 1, 4, '');
INSERT INTO `permission_element` VALUES (21, '新增', 'permission.app.goRaise()', 'btn btn-success btn-next', 1, 1, 1, '');
INSERT INTO `permission_element` VALUES (22, '修改', 'permission.app.goModify()', 'btn btn-success btn-next', 1, 1, 2, '');
INSERT INTO `permission_element` VALUES (23, '查看', 'permission.app.goView()', 'btn btn-success btn-next', 1, 1, 3, '');
INSERT INTO `permission_element` VALUES (24, '删除', 'permission.app.goErase()', 'btn btn-success btn-next', 1, 1, 4, '');
INSERT INTO `permission_element` VALUES (25, '新增', 'permission.menu.goRaise()', 'btn btn-success btn-next', 1, 1, 1, '');
INSERT INTO `permission_element` VALUES (26, '修改', 'permission.menu.goModify()', 'btn btn-success btn-next', 1, 1, 2, '');
INSERT INTO `permission_element` VALUES (27, '查看', 'permission.menu.goView()', 'btn btn-success btn-next', 1, 1, 3, '');
INSERT INTO `permission_element` VALUES (28, '删除', 'permission.menu.goErase()', 'btn btn-success btn-next', 1, 1, 4, '');
INSERT INTO `permission_element` VALUES (29, '新增', 'permission.element.goRaise()', 'btn btn-success btn-next', 1, 1, 1, '');
INSERT INTO `permission_element` VALUES (30, '修改', 'permission.element.goModify()', 'btn btn-success btn-next', 1, 1, 2, '');
INSERT INTO `permission_element` VALUES (31, '查看', 'permission.element.goView()', 'btn btn-success btn-next', 1, 1, 3, '');
INSERT INTO `permission_element` VALUES (32, '删除', 'permission.element.goErase()', 'btn btn-success btn-next', 1, 1, 4, '');
INSERT INTO `permission_element` VALUES (33, '新增', 'permission.userInfo.goRaise()', 'btn btn-success btn-next', 1, 1, 1, '');
INSERT INTO `permission_element` VALUES (34, '修改', 'permission.userInfo.goModify()', 'btn btn-success btn-next', 1, 1, 2, '');
INSERT INTO `permission_element` VALUES (35, '查看', 'permission.userInfo.goView()', 'btn btn-success btn-next', 1, 1, 3, '');
INSERT INTO `permission_element` VALUES (36, '删除', 'permission.userInfo.goErase()', 'btn btn-success btn-next', 1, 1, 4, '');

/*用户信息*/
DROP TABLE IF EXISTS `permission_user_info`;
CREATE TABLE `permission_user_info` (
  `userID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `userCode` varchar(255) DEFAULT NULL COMMENT '用户编码',
  `userName` varchar(1024) NOT NULL COMMENT '用户真实姓名',
  `userSex` int(11) NOT NULL COMMENT '性别  0：女  1：男',
  `userTel` varchar(20) NOT NULL COMMENT '手机号码',
  `userEmail` varchar(50) NOT NULL COMMENT '电子邮件',
  `userBirthday` varchar(50) DEFAULT NULL COMMENT 'birthday',
  `userNation` varchar(255) DEFAULT NULL COMMENT '民族',
  `userPhotoFile` varchar(1024) DEFAULT NULL COMMENT '图片文件名称',
  `loginName` varchar(255) NOT NULL COMMENT '用户登录帐号',
  `passWord` varchar(255) NOT NULL COMMENT '密码',
  `isCurrent` int(11) NOT NULL COMMENT '0：未启动 1：启用',
  `isDelete` int(11) NOT NULL COMMENT '是否删除 默认1 未删除， 0 删除',
  `sortNum` int(11) NOT NULL COMMENT '顺序',
  `createDT` datetime NOT NULL COMMENT '创建时间',
  `theNote` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`userID`)
) CHARSET=utf8;
/*插入系统超级管理员数据,ID为1, 密码123456*/
insert into permission_user_info (
	userID, userCode, userName, userSex, userTel, userEmail, userBirthday, userNation,
	userPhotoFile, loginName, passWord, isCurrent, isDelete, sortNum, createDT, theNote
) values (
	1, 'admin', '超级管理员', 1, '13889259343', '952327407@qq.om', now(), '汉族',
	'', 'admin', '92894219EF3E7B6D752F058D31C5166C', 1, 1, 1, now(), '超级管理员'
);

/*用户职级*/
DROP TABLE IF EXISTS `permission_user_rank`;
CREATE TABLE `permission_user_rank` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `rankID` int(11) DEFAULT NULL COMMENT '职级ID',
  `userID` int(11) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`ID`)
) CHARSET=utf8;

/*用户岗位*/
DROP TABLE IF EXISTS `permission_user_post`;
CREATE TABLE `permission_user_post` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `postID` int(11) NOT NULL COMMENT '岗位Id',
  `userID` int(11) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`ID`)
) CHARSET=utf8;

/*用户机构*/
DROP TABLE IF EXISTS `permission_user_org`;
CREATE TABLE `permission_user_org` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `orgID` int(11) NOT NULL COMMENT '机构ID',
  `userID` int(11) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`ID`)
) CHARSET=utf8;

/*用户角色*/
DROP TABLE IF EXISTS `permission_user_role`;
CREATE TABLE `permission_user_role` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `userID` int(11) NOT NULL COMMENT '用户ID',
  `roleID` int(11) NOT NULL COMMENT '角色Id',
  PRIMARY KEY (`ID`)
) CHARSET=utf8;
/*为系统超级管理员用户绑定超级管理员角色*/
insert into permission_user_role (
	ID, userID, roleID
) values (
	1, 1, 1
);

/*用户默认APP*/
DROP TABLE IF EXISTS `permission_user_app`;
CREATE TABLE `permission_user_app` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `userID` int(11) NOT NULL COMMENT '用户ID',
  `appTypeID` int(11) NOT NULL COMMENT 'appTypeID',
  `appID` int(11) NOT NULL COMMENT 'appID',
  PRIMARY KEY (`ID`)
) CHARSET=utf8;
/*设置超级管理员默认系统为权限管理系统*/
INSERT INTO permission_user_app VALUES (1, 1, 3, 1,);
