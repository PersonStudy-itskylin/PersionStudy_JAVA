/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.5.38 : Database - depot
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`depot` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `depot`;

/*Table structure for table `taccount` */

DROP TABLE IF EXISTS `taccount`;

CREATE TABLE `taccount` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `userName` varchar(40) DEFAULT NULL COMMENT '用户名',
  `Password` varchar(64) DEFAULT NULL COMMENT '密码',
  `realName` varchar(40) DEFAULT NULL COMMENT '明后姓名',
  `Role` int(11) DEFAULT NULL COMMENT '权限级别',
  `Description` varchar(255) DEFAULT NULL COMMENT '账号描述',
  `Phone` varchar(20) DEFAULT NULL COMMENT '手机',
  `Tel` varchar(20) DEFAULT NULL COMMENT '电话',
  `Email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `QQ` varchar(20) DEFAULT NULL COMMENT 'QQ号码',
  `State` int(11) DEFAULT NULL COMMENT '账号状态',
  `IP` varchar(128) DEFAULT NULL COMMENT '注册IP地址',
  `CreateTime` datetime DEFAULT NULL COMMENT '创建时间',
  `UpdateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `Remark` varchar(255) DEFAULT NULL COMMENT '备注说明',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `taccount` */

insert  into `taccount`(`ID`,`userName`,`Password`,`realName`,`Role`,`Description`,`Phone`,`Tel`,`Email`,`QQ`,`State`,`IP`,`CreateTime`,`UpdateTime`,`Remark`) values (1,'root','63a9f0ea7bb98050796b649e85481845','测试',1,'.............................测试................','18612433680','010-22345678','123456@qq.com','123456',2,'198.9.9.42','2014-09-26 13:09:37','2014-12-07 19:07:37','测试.................');

/*Table structure for table `tbackup` */

DROP TABLE IF EXISTS `tbackup`;

CREATE TABLE `tbackup` (
  `bacID` int(11) NOT NULL AUTO_INCREMENT COMMENT '备份ID',
  `ACCID` int(11) DEFAULT NULL COMMENT '创建备份的用户ID',
  `bacName` char(60) DEFAULT NULL COMMENT '备份名称',
  `bacDescription` char(255) DEFAULT NULL COMMENT '备份描述',
  `bacPath` char(255) DEFAULT NULL COMMENT '备份路径',
  `bacIp` char(128) DEFAULT NULL COMMENT '用户操作IP地址',
  `bacTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `bacRemark` char(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`bacID`),
  KEY `ACCID` (`ACCID`),
  CONSTRAINT `tbackup_ibfk_1` FOREIGN KEY (`ACCID`) REFERENCES `taccount` (`ID`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `tbackup` */

/*Table structure for table `tproduct` */

DROP TABLE IF EXISTS `tproduct`;

CREATE TABLE `tproduct` (
  `proID` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品ID',
  `ACCID` int(11) DEFAULT NULL COMMENT '产品创建人ID',
  `proname` char(60) DEFAULT NULL COMMENT '产品名称',
  `promodel` char(60) DEFAULT NULL COMMENT '产品型号',
  `proprice` decimal(10,2) DEFAULT NULL COMMENT '产品价格',
  `protype` char(60) DEFAULT NULL COMMENT '产品类型',
  `proquantity` decimal(8,0) DEFAULT NULL COMMENT '产品数量',
  `prosource` char(100) DEFAULT NULL COMMENT '产品来源',
  `proeditor` char(60) DEFAULT NULL COMMENT '产品修改者',
  `procreatetime` datetime DEFAULT NULL COMMENT '产品创建时间',
  `proedittime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '产品修改时间',
  `proremark` char(255) DEFAULT NULL COMMENT '产品备注',
  PRIMARY KEY (`proID`),
  KEY `ACCID` (`ACCID`),
  CONSTRAINT `tproduct_ibfk_1` FOREIGN KEY (`ACCID`) REFERENCES `taccount` (`ID`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `tproduct` */

/*Table structure for table `tproductinout` */

DROP TABLE IF EXISTS `tproductinout`;

CREATE TABLE `tproductinout` (
  `pioID` int(11) NOT NULL AUTO_INCREMENT COMMENT '出入库记录ID',
  `proid` int(11) DEFAULT NULL COMMENT '产品ID',
  `ACCID` int(11) DEFAULT NULL COMMENT '操作人ID',
  `pioquantity` int(11) DEFAULT NULL COMMENT '操作数量',
  `pioCount` int(11) DEFAULT NULL COMMENT '操作次数',
  `pioType` char(60) DEFAULT NULL COMMENT '操作类型（出库/入库）',
  `pioOperation` char(60) DEFAULT NULL COMMENT '灌机人',
  `pioOperationnum` int(11) DEFAULT NULL COMMENT '灌机点数',
  `pioagreementid` char(255) DEFAULT NULL COMMENT '合同编号',
  `pioprojectid` char(255) DEFAULT NULL COMMENT '项目编号',
  `pioprojectname` char(100) DEFAULT NULL COMMENT '项目名称',
  `piouttime` datetime DEFAULT NULL COMMENT '出库时间',
  `piointime` datetime DEFAULT NULL COMMENT '归还时间',
  `piosign` char(100) DEFAULT NULL COMMENT '签约公司',
  `pioapply` char(60) DEFAULT NULL COMMENT '申请人',
  `pioDelivery` char(60) DEFAULT NULL COMMENT '提货人',
  `pioremark` char(255) DEFAULT NULL COMMENT '备注',
  `pioadminsign` char(60) DEFAULT NULL COMMENT '管理员审核',
  PRIMARY KEY (`pioID`),
  KEY `ACCID` (`ACCID`),
  KEY `proid` (`proid`),
  CONSTRAINT `tproductinout_ibfk_2` FOREIGN KEY (`ACCID`) REFERENCES `taccount` (`ID`) ON DELETE SET NULL,
  CONSTRAINT `tproductinout_ibfk_3` FOREIGN KEY (`proid`) REFERENCES `tproduct` (`proID`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tproductinout` */

/*Table structure for table `tsystemlog` */

DROP TABLE IF EXISTS `tsystemlog`;

CREATE TABLE `tsystemlog` (
  `sysID` int(11) NOT NULL AUTO_INCREMENT COMMENT '系统记录ID',
  `ACCID` int(11) DEFAULT NULL COMMENT '操作用户ID',
  `sysname` char(60) DEFAULT NULL COMMENT '操作模块名',
  `systime` datetime DEFAULT NULL COMMENT '操作时间',
  `sysip` char(128) DEFAULT NULL COMMENT '操作IP地址',
  `sysremark` char(255) DEFAULT NULL COMMENT '操作说明',
  PRIMARY KEY (`sysID`),
  KEY `ACCID` (`ACCID`),
  CONSTRAINT `tsystemlog_ibfk_1` FOREIGN KEY (`ACCID`) REFERENCES `taccount` (`ID`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=1050 DEFAULT CHARSET=utf8;

/*Data for the table `tsystemlog` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
