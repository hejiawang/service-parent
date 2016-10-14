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

/*角色权限*/
DROP TABLE IF EXISTS `permission_role_permission`;
CREATE TABLE `permission_role_permission` (
  `roleID` int(11) NOT NULL COMMENT '角色Id',
  `permissionID` int(11) NOT NULL COMMENT '权限Id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


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


/*可用操作*/
DROP TABLE IF EXISTS `permission_operation`;
CREATE TABLE `permission_operation` (
  `operationID` int(11) NOT NULL AUTO_INCREMENT COMMENT '操作ID',
  `typeCode` varchar(255) NOT NULL COMMENT '类型编码',
  `operationName` varchar(255) NOT NULL COMMENT '操作名称',
  `fun` varchar(255) NOT NULL COMMENT '方法名称',
  PRIMARY KEY (`operationID`)
) CHARSET=utf8;
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
