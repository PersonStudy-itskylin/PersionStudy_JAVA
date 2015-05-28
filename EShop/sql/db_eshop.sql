/*!40101 SET CHARACTER SET 'gb2312' */;

DROP DATABASE IF EXISTS `db_eshop`;
CREATE DATABASE `db_eshop` /*!40100 DEFAULT CHARACTER SET gb2312 */;
USE `db_eshop`;

CREATE TABLE admin (
  ID int(4) NOT NULL auto_increment,
  AdminType int(4) default NULL,
  AdminName char(12) default NULL,
  LoginName char(12) default NULL,
  LoginPwd char(32) default NULL,
  PRIMARY KEY  (ID)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

INSERT INTO admin (ID,AdminType,AdminName,LoginName,LoginPwd) VALUES (1,1,'商品管理员','Admin1','Admin1.');
INSERT INTO admin (ID,AdminType,AdminName,LoginName,LoginPwd) VALUES (2,2,'订单管理员','Admin2','Admin2.');
INSERT INTO admin (ID,AdminType,AdminName,LoginName,LoginPwd) VALUES (3,3,'会员管理员','Admin3','Admin3.');
INSERT INTO admin (ID,AdminType,AdminName,LoginName,LoginPwd) VALUES (4,4,'系统管理员','root','root.');

CREATE TABLE cart (
  ID int(4) NOT NULL auto_increment,
  Member int(4) NOT NULL,
  Money decimal(9,2) default NULL,
  CartStatus int(4) default NULL,
  PRIMARY KEY  (ID)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

CREATE TABLE cartselectedmer (
  ID int(4) NOT NULL auto_increment,
  Cart int(4) NOT NULL,
  Merchandise int(4) NOT NULL,
  Number int(4) NOT NULL default 1,
  Price decimal(8,2) NOT NULL default 0.00,
  Money decimal(9,2) NOT NULL default 0.00,
  PRIMARY KEY  (ID)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

CREATE TABLE category (
  ID int(4) NOT NULL auto_increment,
  CateName char(40) default NULL,
  CateDesc text,
  PRIMARY KEY  (ID)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

CREATE TABLE leaveword (
  ID int(4) NOT NULL auto_increment,
  Member int(4) NOT NULL,
  Admin int(4) default NULL,
  Title char(60) default NULL,
  Content text,
  LeaveDate datetime default NULL,
  AnswerContent text,
  AnswerDate datetime default NULL,
  PRIMARY KEY  (ID)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

CREATE TABLE member (
  ID int(4) NOT NULL auto_increment,
  Memberlevel int(4) NOT NULL,
  LoginName char(12) default NULL,
  LoginPwd char(12) default NULL,
  MemberName char(20) default NULL,
  Phone char(15) default NULL,
  Address varchar(100) default NULL,
  Zip char(10) default NULL,
  RegDate datetime default NULL,
  LastDate datetime default NULL,
  LoginTimes int(4) default NULL,
  EMail varchar(100) default NULL,
  PRIMARY KEY  (ID)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

CREATE TABLE memberlevel (
  ID int(4) NOT NULL auto_increment,
  LevelName char(20) default NULL,
  Favourable int(4) default NULL,
  PRIMARY KEY  (ID)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

CREATE TABLE merchandise (
  ID int(4) NOT NULL auto_increment,
  Category int(4) NOT NULL,
  MerName char(40) default NULL,
  Price decimal(8,2) default NULL,
  SPrice decimal(8,2) default NULL,
  MerModel char(40) default NULL,
  Picture varchar(100) default NULL,
  MerDesc text,
  Manufacturer char(60) default NULL,
  LeaveFactoryDate datetime default NULL,
  Special int(4) default NULL,
  PRIMARY KEY  (ID)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

CREATE TABLE orders (
  ID int(4) NOT NULL auto_increment,
  Member int(4) NOT NULL,
  Cart int(4) NOT NULL,
  OrderNO char(20) default NULL,
  OrderDate datetime default NULL,
  OrderStatus int(4) default NULL,
  PRIMARY KEY  (ID)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

INSERT INTO memberlevel (ID,LevelName,Favourable) VALUES (1,'普通会员',95);
INSERT INTO memberlevel (ID,LevelName,Favourable) VALUES (2,'黄金会员',90);
INSERT INTO memberlevel (ID,LevelName,Favourable) VALUES (3,'白金会员',85);
INSERT INTO memberlevel (ID,LevelName,Favourable) VALUES (4,'钻石会员',80);