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
