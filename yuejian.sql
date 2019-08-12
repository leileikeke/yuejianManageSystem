/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.26-log : Database - yuejian
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`yuejian` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `yuejian`;

/*Table structure for table `activity` */

DROP TABLE IF EXISTS `activity`;

CREATE TABLE `activity` (
  `a_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '活动id',
  `name` varchar(255) NOT NULL DEFAULT '这我一个xxx活动' COMMENT '活动名字',
  `start_time` datetime NOT NULL DEFAULT '2019-08-14 15:27:01' COMMENT '活动开始时间',
  `end_time` datetime NOT NULL DEFAULT '2019-08-14 15:27:01' COMMENT '活动结束时间',
  `address` varchar(255) DEFAULT '我是一个活动地址' COMMENT '活动地址',
  `pic` varchar(255) NOT NULL DEFAULT '/static/imgs/activity/head.jpg' COMMENT '活动宣传图',
  `price` double DEFAULT '88.8' COMMENT '活动价格',
  `type` varchar(20) DEFAULT NULL COMMENT '活动类型',
  `detail` varchar(255) DEFAULT '我是活动详情' COMMENT '活动详情',
  `c_id` int(11) DEFAULT NULL COMMENT '所属俱乐部',
  PRIMARY KEY (`a_id`),
  KEY `c_id` (`c_id`),
  CONSTRAINT `c_id` FOREIGN KEY (`c_id`) REFERENCES `club` (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

/*Data for the table `activity` */

insert  into `activity`(`a_id`,`name`,`start_time`,`end_time`,`address`,`pic`,`price`,`type`,`detail`,`c_id`) values (1,'这我一个xxx活动','2019-08-06 08:14:32','2019-08-06 22:14:38','我是一个活动地址','/static/imgs/activity/u=1763044357,684998663&fm=27&gp=01565546623165.jpg',88.8,'跑步','我是活动详情',1),(3,'这我一个xxx活动','2019-08-06 08:14:32','2019-08-15 02:12:09','我是一个活动地址','/static/imgs/activity/u=1763044357,684998663&fm=27&gp=01565546623165.jpg',88.8,'健身','我是活动详情',2),(7,'这我一个xxx活动','2019-08-14 15:26:06','2019-08-12 15:26:10','我是一个活动地址','/static/imgs/activity/head.jpg',88.8,'作死','我是活动详情',3),(8,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/head.jpg',88.8,'攀岩','我是活动详情',4),(9,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/head.jpg',88.8,'登山','我是活动详情',2),(10,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/head.jpg',88.8,'健身','我是活动详情',1),(11,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/head.jpg',88.8,'聚餐','我是活动详情',1),(12,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/head.jpg',88.8,'游泳','我是活动详情',3),(13,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/head.jpg',88.8,'跑步','我是活动详情',1),(14,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/head.jpg',88.8,'跑步','我是活动详情',2),(15,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/head.jpg',88.8,'游泳','我是活动详情',1),(16,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/head.jpg',88.8,'游泳','我是活动详情',1),(17,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/head.jpg',88.8,'跑步','我是活动详情',1),(18,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/head.jpg',88.8,'跑步','我是活动详情',1),(19,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/head.jpg',88.8,'跑步','我是活动详情',2),(20,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/head.jpg',88.8,'游泳','我是活动详情',3),(21,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/head.jpg',88.8,'跑步','我是活动详情',4),(22,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/head.jpg',88.8,'跑酷','我是活动详情',5),(23,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/head.jpg',88.8,'游泳','我是活动详情',3),(24,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/head.jpg',88.8,'游泳','我是活动详情',2);

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '管理员id',
  `name` varchar(30) NOT NULL COMMENT '用户名',
  `nickname` varchar(30) NOT NULL COMMENT '昵称',
  `password` varchar(30) NOT NULL COMMENT '密码',
  `phone` varchar(20) NOT NULL DEFAULT '110' COMMENT '电话',
  `sex` varchar(20) DEFAULT '11' COMMENT '年龄',
  `role` varchar(20) NOT NULL DEFAULT 'clubAdmin' COMMENT '角色',
  `jointime` datetime NOT NULL COMMENT '加入时间',
  `state` tinyint(1) DEFAULT NULL COMMENT '审核状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`id`,`name`,`nickname`,`password`,`phone`,`sex`,`role`,`jointime`,`state`) values (1,'leike','打不死','11','18742509781','11','systemAdmin','2019-08-14 23:46:29',1),(2,'leike2','小强','11','110','11','systemAdmin','2019-08-22 23:46:32',1),(3,'club','小小强','11','18742509781','11','clubAdmin','2019-08-21 23:46:34',1),(6,'xiaoqiang','打不死','11','18742509781','88','clubAdmin','2018-01-21 12:21:11',0),(22,'12','11','213','12121212121','12','clubAdmin','2019-08-08 04:21:43',1),(24,'sys','测试','11','19823232322','19','systemAdmin','2019-08-10 07:30:06',0),(26,'mouming','毒液','11','12321232123','22','clubAdmin','2019-08-12 03:45:16',1);

/*Table structure for table `club` */

DROP TABLE IF EXISTS `club`;

CREATE TABLE `club` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '俱乐部id',
  `name` varchar(40) DEFAULT NULL COMMENT '联系电话',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话',
  `pic` varchar(255) DEFAULT NULL COMMENT '宣传图',
  `intro` varchar(255) DEFAULT NULL COMMENT '简介',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `jointime` date DEFAULT NULL COMMENT '创建日期',
  `hot` int(11) DEFAULT '0' COMMENT '热度',
  `id` int(11) DEFAULT NULL COMMENT '管理员id',
  PRIMARY KEY (`c_id`),
  KEY `id` (`id`),
  CONSTRAINT `id` FOREIGN KEY (`id`) REFERENCES `admin` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

/*Data for the table `club` */

insert  into `club`(`c_id`,`name`,`phone`,`pic`,`intro`,`address`,`jointime`,`hot`,`id`) values (1,'玩具club','15142441701','/static/imgs/club/u=1788562038,3472846301&fm=27&gp=01565620352188.jpg','我是一个简介阿萨飒飒擦撒撒撒发顺丰说的是事实上的圣诞树上的收到VS大v阿达v收到VS v阿萨','我是地址xxxxxxxxxxxxxxxxxx','2019-08-22',12,3),(2,'热血club','0722-13212121','/static/imgs/club/u=1788562038,3472846301&fm=27&gp=01565504874456.jpg','我是一个简介xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx','我是地址xxxxxxxxxxxxxxxxxx','2019-08-06',32,6),(3,'二货club','10223232323','/static/imgs/club/u=1788562038,3472846301&fm=27&gp=01565607838780.jpg','我是一个简介xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx','我是地址xxxxxxxxxxxxxxxxxx','2019-08-23',1313,6),(4,'二货club','0722-13212121','/static/imgs/club/u=1788562038,3472846301&fm=27&gp=01565504874456.jpg','我是一个简介xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx','我是地址xxxxxxxxxxxxxxxxxx','2019-08-29',13,6),(5,'二货club','0722-13212121','/static/imgs/club/u=1788562038,3472846301&fm=27&gp=01565504874456.jpg','我是一个简介xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx','我是地址xxxxxxxxxxxxxxxxxx','2019-08-09',13,6),(6,'二货club','0722-13212121','/static/imgs/club/u=1788562038,3472846301&fm=27&gp=01565504874456.jpg','我是一个简介xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx','我是地址xxxxxxxxxxxxxxxxxx','2019-08-25',1131,6),(7,'131313','12132221213','/static/imgs/club/u=1788562038,3472846301&fm=27&gp=01565504874456.jpg','13243123','131313','2019-08-11',0,6),(8,'21343','12342313131','/static/imgs/club/u=858959453,1988929777&fm=27&gp=01565506995062.jpg','1342314213','1311313131','2019-08-11',0,6),(9,'仙人俱乐部','18742509781','/static/imgs/club/u=858959453,1988929777&fm=27&gp=01565506995062.jpg','这是一家俱乐部','广谱屯街道','2019-08-11',0,6),(10,'仙人俱乐部','18742509781','/static/imgs/club/u=858959453,1988929777&fm=27&gp=01565506995062.jpg','这是一家俱乐部','广谱屯街道','2019-08-11',0,6),(11,'仙人俱乐部','18742509781','/static/imgs/club/u=858959453,1988929777&fm=27&gp=01565506995062.jpg','这是一家俱乐部','广谱屯街道','2019-08-11',0,6),(12,'仙人俱乐部','18742509781','/static/imgs/club/u=858959453,1988929777&fm=27&gp=01565506995062.jpg','这是一家俱乐部','广谱屯街道','2019-08-11',0,6),(13,'仙人俱乐部','18742509781','/static/imgs/club/u=858959453,1988929777&fm=27&gp=01565506995062.jpg','这是一家俱乐部','广谱屯街道','2019-08-11',0,6),(14,'仙人俱乐部','18742509781','/static/imgs/club/u=858959453,1988929777&fm=27&gp=01565506995062.jpg','这是一家俱乐部','广谱屯街道','2019-08-11',0,6),(15,'仙人俱乐部','18742509781','/static/imgs/club/u=858959453,1988929777&fm=27&gp=01565506995062.jpg','这是一家俱乐部','广谱屯街道','2019-08-11',0,6),(16,'仙人俱乐部','18742509781','/static/imgs/club/u=858959453,1988929777&fm=27&gp=01565506995062.jpg','这是一家俱乐部','广谱屯街道','2019-08-11',0,6),(17,'仙人俱乐部','18742509781','/static/imgs/club/u=858959453,1988929777&fm=27&gp=01565506995062.jpg','这是一家俱乐部','广谱屯街道','2019-08-11',0,6),(18,'仙人俱乐部','18742509781','/static/imgs/club/u=858959453,1988929777&fm=27&gp=01565506995062.jpg','这是一家俱乐部','广谱屯街道','2019-08-11',0,6),(19,'仙人俱乐部','18742509781','/static/imgs/club/u=858959453,1988929777&fm=27&gp=01565506995062.jpg','这是一家俱乐部','广谱屯街道','2019-08-11',0,6),(20,'仙人俱乐部','18742509781','/static/imgs/club/u=858959453,1988929777&fm=27&gp=01565506995062.jpg','这是一家俱乐部','广谱屯街道','2019-08-11',0,6),(30,'21342','12212121212','/static/imgs/club/u=858959453,1988929777&fm=27&gp=01565535418789.jpg','324313414','1313131','2019-08-11',0,6),(31,'32423','12234323422','/static/imgs/club/u=1788562038,3472846301&fm=27&gp=01565597931687.jpg','12人GV是大Vvfv','12121313','2019-08-12',0,6),(32,'21324','12123422213','/static/imgs/club/u=1788562038,3472846301&fm=27&gp=01565606920475.jpg','232434231','1232431','2019-08-12',0,6);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(20) NOT NULL DEFAULT '打不死的小强' COMMENT '用户名',
  `pic` varchar(255) NOT NULL DEFAULT '/static/imgs/head.jpg' COMMENT '用户头像',
  `sex` varchar(10) NOT NULL DEFAULT '男' COMMENT '用户性别',
  `phone` varchar(20) NOT NULL DEFAULT '18742509781' COMMENT '电话',
  `password` varchar(20) NOT NULL COMMENT '用户密码',
  `email` varchar(255) NOT NULL DEFAULT 'xxx@qq.com' COMMENT '用户邮箱',
  `jointime` datetime NOT NULL COMMENT '用户创建时间',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`u_id`,`name`,`pic`,`sex`,`phone`,`password`,`email`,`jointime`) values (1,'打不死的小强','/static/imgs/user/u=1788562038,3472846301&fm=27&gp=01565520557701.jpg','男','18742509781','11','xxx@qq.com','2019-08-20 16:37:41'),(2,'一号','/static/imgs/user/u=1788562038,3472846301&fm=27&gp=01565535043303.jpg','男','18742509781','11','xxx@qq.com','2019-08-01 16:37:43'),(3,'二号','/static/imgs/user/u=858959453,1988929777&fm=27&gp=01565535051403.jpg','女','18742509781','11','xxx@qq.com','2019-08-19 16:37:48'),(4,'三号','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-02 16:37:45'),(6,'三号','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-02 16:37:45'),(8,'打不死的小强','/static/imgs/head.jpg','男','18742509781','123','xxx@qq.com','2019-08-12 18:02:41'),(9,'打不死的小强','/static/imgs/head.jpg','男','18742509781','23','xxx@qq.com','2019-08-13 18:05:12'),(10,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(11,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(12,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(13,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(14,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(15,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(16,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(17,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(18,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(19,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(20,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(21,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(22,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(23,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(24,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(25,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(26,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(27,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(28,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(33,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(34,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(35,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(37,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(45,'1232','/static/imgs/user/u=1763044357,684998663&fm=27&gp=01565351988012.jpg','女','12121212121','21','121@qq.com','2019-08-08 01:19:54'),(46,'2113','/static/imgs/user/u=858959453,1988929777&fm=27&gp=01565503568011.jpg','男','11222122121','13','1211@qq.com','2019-08-11 02:06:15'),(47,'132412','/static/imgs/user/u=858959453,1988929777&fm=27&gp=01565503777685.jpg','男','12121212121','121','1233@qq.com','2019-08-11 02:09:42'),(48,'`314141','/static/imgs/user/u=1788562038,3472846301&fm=27&gp=01565535453372.jpg','男','12122121211','2`2`','13131313@qq.com','2019-08-11 10:57:49');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
