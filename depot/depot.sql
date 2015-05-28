/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.15 : Database - Storage
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`Storage` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `Storage`;

/*Table structure for table `account` */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `accId` int(11) NOT NULL AUTO_INCREMENT,
  `accDescription` varchar(255) DEFAULT NULL,
  `accRole` int(11) DEFAULT NULL,
  `accLoginName` varchar(40) DEFAULT NULL,
  `accPassword` varchar(40) DEFAULT NULL,
  `accMiddleName` varchar(40) DEFAULT NULL,
  `accPhone` varchar(20) DEFAULT NULL,
  `accTel` varchar(20) DEFAULT NULL,
  `accEmail` varchar(100) DEFAULT NULL,
  `accQQ` varchar(20) DEFAULT NULL,
  `accState` int(11) DEFAULT NULL,
  `accIP` varchar(128) DEFAULT NULL,
  `accCreated` datetime DEFAULT NULL,
  `accUpdated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `accRemark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`accId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `account` */

LOCK TABLES `account` WRITE;

UNLOCK TABLES;

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `proId` int(11) NOT NULL AUTO_INCREMENT,
  `accId` int(11) DEFAULT NULL,
  `proName` varchar(60) DEFAULT NULL,
  `proModel` varchar(60) DEFAULT NULL,
  `proPrice` float DEFAULT NULL,
  `proType` varchar(60) DEFAULT NULL,
  `proQuantity` int(11) DEFAULT NULL,
  `proSource` varchar(100) DEFAULT NULL,
  `proCount` int(11) DEFAULT NULL,
  `proEditor` varchar(60) DEFAULT NULL,
  `proCreateTime` datetime DEFAULT NULL,
  `proEditTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `proRemark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`proId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `product` */

LOCK TABLES `product` WRITE;

UNLOCK TABLES;

/*Table structure for table `productinout` */

DROP TABLE IF EXISTS `productinout`;

CREATE TABLE `productinout` (
  `pioId` int(11) NOT NULL AUTO_INCREMENT,
  `proId` int(11) DEFAULT NULL,
  `accId` int(11) DEFAULT NULL,
  `pioQuantity` int(11) DEFAULT NULL,
  `pioType` varchar(60) DEFAULT NULL,
  `pioOperation` varchar(60) DEFAULT NULL,
  `pioOperationnum` int(11) DEFAULT NULL,
  `pioAgreementid` varchar(255) DEFAULT NULL,
  `pioProjectid` varchar(255) DEFAULT NULL,
  `pioProjectname` varchar(100) DEFAULT NULL,
  `pioTime` datetime DEFAULT NULL,
  `pioSign` varchar(100) DEFAULT NULL,
  `pioApply` varchar(60) DEFAULT NULL,
  `pioDelivery` varchar(60) DEFAULT NULL,
  `pioRemark` varchar(255) DEFAULT NULL,
  `pioAdminsign` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`pioId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `productinout` */

LOCK TABLES `productinout` WRITE;

UNLOCK TABLES;

/*Table structure for table `ssiuser6` */

DROP TABLE IF EXISTS `ssiuser6`;

CREATE TABLE `ssiuser6` (
  `userid` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `ssiuser6` */

LOCK TABLES `ssiuser6` WRITE;

insert  into `ssiuser6`(`userid`,`username`,`PASSWORD`) values (1,'admin','admin');

UNLOCK TABLES;

/*Table structure for table `systemlog` */

DROP TABLE IF EXISTS `systemlog`;

CREATE TABLE `systemlog` (
  `sysId` int(11) NOT NULL AUTO_INCREMENT,
  `accId` int(11) DEFAULT NULL,
  `sysName` varchar(60) DEFAULT NULL,
  `sysTme` datetime DEFAULT NULL,
  `sysIp` varchar(128) DEFAULT NULL,
  `sysRemark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sysId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `systemlog` */

LOCK TABLES `systemlog` WRITE;

UNLOCK TABLES;

/*Table structure for table `taccount` */

DROP TABLE IF EXISTS `taccount`;

CREATE TABLE `taccount` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(40) DEFAULT NULL,
  `Password` varchar(64) DEFAULT NULL,
  `realName` varchar(40) DEFAULT NULL,
  `Role` int(11) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `Tel` varchar(20) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `QQ` varchar(20) DEFAULT NULL,
  `State` int(11) DEFAULT NULL,
  `IP` varchar(128) DEFAULT NULL,
  `CreateTime` datetime DEFAULT NULL,
  `UpdateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

/*Data for the table `taccount` */

LOCK TABLES `taccount` WRITE;

insert  into `taccount`(`ID`,`userName`,`Password`,`realName`,`Role`,`Description`,`Phone`,`Tel`,`Email`,`QQ`,`State`,`IP`,`CreateTime`,`UpdateTime`,`Remark`) values (1,'admin','21232F297A57A5A743894A0E4A801FC3','liuben',NULL,'rhdytjuktyerfwtyjuydrsee','','','','',NULL,'192.168.123.1','2014-10-01 10:29:28','2014-10-17 10:29:30',''),(2,'dsds','asda','dgfgf',NULL,'ydjrh十分工会的投影机个人头哦','34234','3424','342','342434',NULL,'192.168.123.2','2014-10-07 10:29:31','2014-10-17 10:29:33','232424'),(3,'34','454','5656',1,'去瞧瞧瞧瞧瞧瞧','353','656','reter434','45343',0,'192.168.123.3','2014-10-03 10:29:33','2014-10-17 12:23:32','543535464'),(21,'211','1','1',NULL,NULL,'1','1','1','1',NULL,'192.168.123.4','2014-09-29 10:29:36','2014-10-17 10:29:39','111111'),(28,'w','w','1111111',NULL,NULL,'11111','1','1','1',NULL,'192.168.123.5','2014-08-06 10:29:39','2014-10-17 10:29:44','4444444'),(30,'a','a','柳奔',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'192.168.123.6','2014-10-06 10:29:45','2014-10-17 10:29:49',NULL),(36,'7','8f14e45fceea167a5a36dedd4bea2543','7',1,'二个饿死人二个二个哦','7','7','7','7',1,'192.168.123.8','2014-10-15 14:10:03','2014-10-17 10:28:25','777'),(38,'8','c9f0f895fb98ab9159f51fd0297e236d','8',2,' 而公司投入和二个 ','8','8','8','8',2,'192.168.123.9','2014-10-15 14:14:29','2014-10-17 10:28:30','8888888'),(41,'5','e4da3b7fbbce2345d7772b0674a318d5','5',1,' 俄国人和人就业和','5','5','5','5',1,'192.168.123.10','2014-10-15 14:26:36','2014-10-17 10:28:33','5555555555'),(42,'5','e4da3b7fbbce2345d7772b0674a318d5','5',1,NULL,'5','5','5','5',1,'192.168.123.11','2014-10-15 14:26:37','2014-10-17 10:28:36','5555555555'),(43,'66','3295c76acbf4caaed33c36b1b5fc2cb1','666',1,'热工哦 二个哦','6666666','6','6','6',1,'192.168.123.12','2014-10-15 14:28:42','2014-10-17 10:28:39','66666666'),(44,'66','3295c76acbf4caaed33c36b1b5fc2cb1','666',1,NULL,'6666666','6','6','6',1,'192.168.123.13','2014-10-15 14:28:42','2014-10-17 10:28:41','66666666'),(45,'d','8277e0910d750195b448797616e091ad','d',0,' 热工合同二级 645一个天然','d','d','d','d',0,'192.168.123.14','2014-10-15 14:29:59','2014-10-17 10:28:44','dddd'),(46,'c','4a8a08f09d37b73795649038408b5f33','c',1,NULL,'c','c','c','c',1,'192.168.123.15','2014-10-15 14:30:34','2014-10-17 10:28:47','ccccccc'),(47,'s','03c7c0ace395d80182db07ae2c30f034','s',1,NULL,'s','s','s','s',0,'192.168.123.16','2014-10-15 14:34:29','2014-10-17 10:28:59','ssssss'),(48,'f','8fa14cdd754f91cc6554c9e71929cce7','f',1,' etrade还原剂位 好','f','f','f','f',1,'192.168.123.17','2014-10-15 14:59:34','2014-10-17 10:28:57','fffff'),(49,'z','fbade9e36a3f36d3d676c1b808451dd7','z',1,NULL,'z','z','z','z',1,'192.168.123.18','2014-10-15 15:02:24','2014-10-17 10:29:02','zzzz'),(50,'x','9dd4e461268c8034f5c8564e155c67a6','x',1,NULL,'x','x','x','x',1,'192.168.123.19','2014-10-15 15:02:58','2014-10-17 10:29:05','xxxxxxxx'),(51,'j','j','j',1,NULL,'j','j','j','j',0,'192.168.123.20','2014-10-15 16:03:19','2014-10-17 10:29:08','11111111'),(52,'w','f1290186a5d0b1ceab27f4e77c0c5d68','w',1,'','w','w','w','w',1,'192.168.123.21','2014-10-16 11:07:07','2014-10-17 10:29:10','w'),(58,'dsds','6226f7cbe59e99a90b5cef6f94f966fd','sd',1,NULL,'sd','sd','sd','sd',1,'192.168.123.22','2014-10-16 17:10:31','2014-10-17 10:29:13','sddddd'),(60,'nullyugyu','nullfft7','1',0,'grsht','null','null','null','null',2,'192.168.123.24','2014-10-17 10:00:38','2014-10-17 13:03:13','dsfshe'),(62,'fdbgrntymuyrdebf','fa96ebe6cbfcaf44b61afefa7f1d336e','bretnym',2,'evwbrtny','rbetnmy','rbeftnym','rbetnym','evwrbtny',2,'127.0.0.1','2014-10-17 13:03:33','2014-10-17 13:03:34','verbtn');

UNLOCK TABLES;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_Id` int(11) NOT NULL,
  `username` varchar(10) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`user_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

LOCK TABLES `user` WRITE;

insert  into `user`(`user_Id`,`username`,`password`) values (0,'admin','admin');

UNLOCK TABLES;

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `userid` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

LOCK TABLES `users` WRITE;

insert  into `users`(`userid`,`username`,`PASSWORD`) values (3,'scott','scott'),(4,'scott12','33333333'),(5,'ddd','ddd'),(14,'22','222'),(15,'fff','fff'),(18,'admin','admin'),(21,'33333','33333333'),(48,'scott12','33333333'),(50,'zzzz','zzzzzzzz');

UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
