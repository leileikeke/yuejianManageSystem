/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.27 : Database - yuejian
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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

/*Data for the table `activity` */

insert  into `activity`(`a_id`,`name`,`start_time`,`end_time`,`address`,`pic`,`price`,`type`,`detail`,`c_id`) values (1,'这我一个xxx活动','2019-08-06 08:14:32','2019-08-06 22:14:38','我是一个活动地址','/static/imgs/activity/u=858959453,1988929777&fm=27&gp=01565793846036.jpg',88.8,'跑步','我是活动详情',1),(3,'这我一个xxx活动','2019-08-06 08:14:32','2019-08-15 02:12:09','我是一个活动地址','/static/imgs/activity/u=1763044357,684998663&fm=27&gp=01565793852287.jpg',88.8,'健身','我是活动详情',2),(7,'这我一个xxx活动','2019-08-14 15:26:06','2019-08-12 15:26:10','我是一个活动地址','/static/imgs/activity/u=1788562038,3472846301&fm=27&gp=01565793857095.jpg',88.8,'作死','我是活动详情',3),(8,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/6daf8aedf771e18e1567650469100.jpg',88.8,'攀岩','我是活动详情',4),(9,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/6daf8aedf771e18e1567650473990.jpg',88.8,'登山','我是活动详情',2),(10,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/6daf8aedf771e18e1567650480202.jpg',88.8,'健身','我是活动详情',1),(11,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/6daf8aedf771e18e1567650494569.jpg',88.8,'聚餐','我是活动详情',1),(12,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/6daf8aedf771e18e1567650485649.jpg',88.8,'游泳','我是活动详情',3),(13,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/6daf8aedf771e18e1567650500398.jpg',88.8,'跑步','我是活动详情',1),(14,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/6daf8aedf771e18e1567650505634.jpg',88.8,'跑步','我是活动详情',2),(15,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/6daf8aedf771e18e1567650513406.jpg',88.8,'游泳','我是活动详情',1),(16,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/6daf8aedf771e18e1567650523700.jpg',88.8,'游泳','我是活动详情',1),(17,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/6daf8aedf771e18e1567650518103.jpg',88.8,'跑步','我是活动详情',1),(18,'这是一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/u=1788562038,3472846301&fm=27&gp=01567577982572.jpg',88.8,'跑步','我是活动详情',1),(19,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/6daf8aedf771e18e1567650553712.jpg',88.8,'跑步','我是活动详情',2),(20,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/6daf8aedf771e18e1567650528647.jpg',88.8,'游泳','我是活动详情',3),(21,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/6daf8aedf771e18e1567650534325.jpg',88.8,'跑步','我是活动详情',4),(22,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/6daf8aedf771e18e1567650539667.jpg',88.8,'跑酷','我是活动详情',5),(23,'这我一个xxx活动','2019-08-14 15:27:01','2019-08-14 15:27:01','我是一个活动地址','/static/imgs/activity/6daf8aedf771e18e1567650544536.jpg',88.8,'游泳','我是活动详情',3);

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

insert  into `admin`(`id`,`name`,`nickname`,`password`,`phone`,`sex`,`role`,`jointime`,`state`) values (1,'leike','打不死','11','18742509781','11','systemAdmin','2019-08-14 23:46:29',1),(2,'leike2','小强','11','110','11','systemAdmin','2019-08-22 23:46:32',1),(3,'club','小小强','11','18742509781','11','clubAdmin','2019-08-21 23:46:34',1),(6,'xiaoqiang','打不死','11','18742509781','88','clubAdmin','2018-01-21 12:21:11',0),(22,'12','11','213','12121212121','12','clubAdmin','2019-08-08 04:21:43',1),(24,'sys','测试','11','19823232322','19','clubAdmin','2019-08-10 07:30:06',0);

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

insert  into `club`(`c_id`,`name`,`phone`,`pic`,`intro`,`address`,`jointime`,`hot`,`id`) values (1,'玩具club','15142441701','/static/imgs/club/6daf8aedf771e18e1567650459217.jpg','我是一个简介阿萨飒飒擦撒撒撒发顺丰说的是事实上的圣诞树上的收到VS大v阿达v收到VS v阿萨','我是地址xxxxxxxxxxxxxxxxxx','2019-08-22',12,3),(2,'热血club','19823432123','/static/imgs/club/u=1763044357,684998663&fm=27&gp=01565793458723.jpg','我是一个简介xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx','我是地址xxxxxxxxxxxxxxxxxx','2019-08-06',32,6),(3,'二货club','10223232323','/static/imgs/club/u=1788562038,3472846301&fm=27&gp=01565793463511.jpg','我是一个简介xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx','我是地址xxxxxxxxxxxxxxxxxx','2019-08-23',1313,6),(4,'二货club','12322322322','/static/imgs/club/u=1763044357,684998663&fm=27&gp=01565793468615.jpg','我是一个简介xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx','我是地址xxxxxxxxxxxxxxxxxx','2019-08-29',13,6),(5,'二货club','12312322211','/static/imgs/club/u=1763044357,684998663&fm=27&gp=01565793468615.jpg','我是一个简介xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx','我是地址xxxxxxxxxxxxxxxxxx','2019-08-09',13,6),(6,'二货club','0722-13212121','/static/imgs/club/u=1763044357,684998663&fm=27&gp=01565793468615.jpg','我是一个简介xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx','我是地址xxxxxxxxxxxxxxxxxx','2019-08-25',1131,6),(7,'131313','12132221213','/static/imgs/club/u=1763044357,684998663&fm=27&gp=01565793468615.jpg','13243123','131313','2019-08-11',0,6),(8,'21343','12342313131','/static/imgs/club/u=1763044357,684998663&fm=27&gp=01565793468615.jpg','1342314213','1311313131','2019-08-11',0,6),(9,'仙人俱乐部','18742509781','/static/imgs/club/u=1763044357,684998663&fm=27&gp=01565793468615.jpg','这是一家俱乐部','广谱屯街道','2019-08-11',0,6),(10,'仙人俱乐部','18742509781','/static/imgs/club/u=1763044357,684998663&fm=27&gp=01565793468615.jpg','这是一家俱乐部','广谱屯街道','2019-08-11',0,6),(11,'仙人俱乐部','18742509781','/static/imgs/club/u=1763044357,684998663&fm=27&gp=01565793468615.jpg','这是一家俱乐部','广谱屯街道','2019-08-11',0,6),(12,'仙人俱乐部','18742509781','/static/imgs/club/u=1763044357,684998663&fm=27&gp=01565793468615.jpg','这是一家俱乐部','广谱屯街道','2019-08-11',0,6),(13,'仙人俱乐部','18742509781','/static/imgs/club/u=1763044357,684998663&fm=27&gp=01565793468615.jpg','这是一家俱乐部','广谱屯街道','2019-08-11',0,6),(14,'仙人俱乐部','18742509781','/static/imgs/club/u=1763044357,684998663&fm=27&gp=01565793468615.jpg','这是一家俱乐部','广谱屯街道','2019-08-11',0,6),(15,'仙人俱乐部','18742509781','/static/imgs/club/u=1763044357,684998663&fm=27&gp=01565793468615.jpg','这是一家俱乐部','广谱屯街道','2019-08-11',0,6),(16,'仙人俱乐部','18742509781','/static/imgs/club/u=1763044357,684998663&fm=27&gp=01565793468615.jpg','这是一家俱乐部','广谱屯街道','2019-08-11',0,6),(17,'仙人俱乐部','18742509781','/static/imgs/club/u=1763044357,684998663&fm=27&gp=01565793468615.jpg','这是一家俱乐部','广谱屯街道','2019-08-11',0,6),(18,'仙人俱乐部','18742509781','/static/imgs/club/u=1763044357,684998663&fm=27&gp=01565793468615.jpg','这是一家俱乐部','广谱屯街道','2019-08-11',0,6),(19,'仙人俱乐部','18742509781','/static/imgs/club/u=1763044357,684998663&fm=27&gp=01565793468615.jpg','这是一家俱乐部','广谱屯街道','2019-08-11',0,6),(20,'仙人俱乐部','18742509781','/static/imgs/club/u=1763044357,684998663&fm=27&gp=01565793468615.jpg','这是一家俱乐部','广谱屯街道','2019-08-11',0,6),(30,'21342','12212121212','/static/imgs/club/u=1763044357,684998663&fm=27&gp=01565793468615.jpg','324313414','1313131','2019-08-11',0,6),(31,'32423','12234323422','/static/imgs/club/u=1763044357,684998663&fm=27&gp=01565793468615.jpg','12人GV是大Vvfv','12121313','2019-08-12',0,6),(32,'21324','12123422213','/static/imgs/club/u=1763044357,684998663&fm=27&gp=01565793468615.jpg','232434231','1232431131313','2019-08-12',0,6);

/*Table structure for table `coach` */

DROP TABLE IF EXISTS `coach`;

CREATE TABLE `coach` (
  `j_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL DEFAULT '王大海',
  `pic` varchar(255) NOT NULL DEFAULT '/static/imgs/head.jpg',
  `sex` varchar(10) NOT NULL DEFAULT '男',
  `phone` varchar(20) NOT NULL DEFAULT '18742509781',
  `email` varchar(50) NOT NULL DEFAULT '756441663@qq.com',
  `intro` varchar(255) NOT NULL DEFAULT '我是一个简介*********',
  `c_id` int(11) NOT NULL DEFAULT '1',
  `state` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`j_id`),
  KEY `c_id` (`c_id`),
  CONSTRAINT `coach_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `club` (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

/*Data for the table `coach` */

insert  into `coach`(`j_id`,`name`,`pic`,`sex`,`phone`,`email`,`intro`,`c_id`,`state`) values (1,'王大海','/static/imgs/coach/u=858959453,1988929777&fm=27&gp=01565793906410.jpg','男','18742509781','756441663@qq.com','我是一个简介*********',1,1),(2,'王大海','/static/imgs/coach/u=1763044357,684998663&fm=27&gp=01565793911617.jpg','男','18742509781','756441663@qq.com','我是一个简介*********',1,0),(5,'王大海','/static/imgs/coach/u=1763044357,684998663&fm=27&gp=01565793922842.jpg','男','18742509781','756441663@qq.com','我是一个简介*********',1,0),(6,'王大海','/static/imgs/coach/u=1763044357,684998663&fm=27&gp=01565793922842.jpg','男','18742509781','756441663@qq.com','我是一个简介*********',1,0),(7,'王大海','/static/imgs/coach/6daf8aedf771e18e1567650569529.jpg','女','18742509781','756441663@qq.com','我是一个简介*********',1,1),(8,'王大海','/static/imgs/coach/u=1763044357,684998663&fm=27&gp=01565793922842.jpg','男','18742509781','756441663@qq.com','我是一个简介*********',1,0),(9,'王大海','/static/imgs/coach/u=1763044357,684998663&fm=27&gp=01565793922842.jpg','男','18742509781','756441663@qq.com','我是一个简介*********',1,1),(10,'王大海','/static/imgs/coach/6daf8aedf771e18e1567650574804.jpg','男','18742509781','756441663@qq.com','我是一个简介*********',1,0),(11,'王大海','/static/imgs/coach/u=1763044357,684998663&fm=27&gp=01565793922842.jpg','男','18742509781','756441663@qq.com','我是一个简介*********',1,0),(12,'王大海','/static/imgs/coach/u=1763044357,684998663&fm=27&gp=01565793922842.jpg','男','18742509781','756441663@qq.com','我是一个简介*********',1,0),(13,'王大海','/static/imgs/coach/u=1763044357,684998663&fm=27&gp=01565793922842.jpg','男','18742509781','756441663@qq.com','我是一个简介*********',1,1),(17,'王大海','/static/imgs/coach/u=1763044357,684998663&fm=27&gp=01565793922842.jpg','男','18742509781','756441663@qq.com','我是一个简介*********',1,0),(18,'王大海','/static/imgs/coach/u=1763044357,684998663&fm=27&gp=01565793922842.jpg','男','18742509781','756441663@qq.com','我是一个简介*********',1,1),(19,'王大海','/static/imgs/coach/u=1763044357,684998663&fm=27&gp=01565793922842.jpg','男','18742509781','756441663@qq.com','我是一个简介*********',1,1),(22,'王大海','/static/imgs/coach/u=1763044357,684998663&fm=27&gp=01565793922842.jpg','男','18742509781','756441663@qq.com','我是一个简介*********',1,0),(26,'1`232','/static/imgs/coach/u=1763044357,684998663&fm=27&gp=01565793922842.jpg','女','12313222313','1234@QQ.COM','121345',1,1),(27,'21313','/static/imgs/coach/u=1763044357,684998663&fm=27&gp=01565793922842.jpg','女','12323212321','12122132@qq.com','23retse',9,0),(28,'大牛','/static/imgs/coach/u=858959453,1988929777&fm=27&gp=01565795440688.jpg','女','12322121212','1313@qq.com','2345',1,0);

/*Table structure for table `course` */

DROP TABLE IF EXISTS `course`;

CREATE TABLE `course` (
  `k_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(40) NOT NULL DEFAULT '瑜伽' COMMENT '姓名',
  `intro` varchar(255) NOT NULL DEFAULT '这是一个详情' COMMENT '详情',
  `class_hours` int(5) DEFAULT '32' COMMENT '课时',
  `price` double NOT NULL DEFAULT '998.88' COMMENT '价格',
  `pic` varchar(255) NOT NULL DEFAULT '/static/imgs/course/head.jpg' COMMENT '宣传图',
  `j_id` int(11) NOT NULL DEFAULT '1' COMMENT '教练id',
  PRIMARY KEY (`k_id`),
  KEY `j_id` (`j_id`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`j_id`) REFERENCES `coach` (`j_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `course` */

insert  into `course`(`k_id`,`name`,`intro`,`class_hours`,`price`,`pic`,`j_id`) values (1,'瑜伽10','这是一个详情',64,998.88,'/static/imgs/course/u=858959453,1988929777&fm=27&gp=01565793958335.jpg',1),(2,'瑜伽1','这是一个详情',32,998.88,'/static/imgs/course/u=1763044357,684998663&fm=27&gp=01565793963874.jpg',1),(3,'瑜伽2','这是一个详情',32,998.88,'/static/imgs/course/u=1788562038,3472846301&fm=27&gp=01565793969057.jpg',1),(4,'瑜伽3','这是一个详情',32,998.88,'/static/imgs/course/u=1788562038,3472846301&fm=27&gp=01565793969057.jpg',1),(5,'瑜伽4','这是一个详情',32,998.88,'/static/imgs/course/u=1788562038,3472846301&fm=27&gp=01565793969057.jpg',1),(6,'瑜伽','这是一个详情',32,998.88,'/static/imgs/course/6daf8aedf771e18e1567650583358.jpg',1),(7,'瑜伽','这是一个详情',32,998.88,'/static/imgs/course/u=1788562038,3472846301&fm=27&gp=01565793969057.jpg',1),(8,'瑜伽','这是一个详情',32,998.88,'/static/imgs/course/u=1788562038,3472846301&fm=27&gp=01565793969057.jpg',1),(9,'瑜伽','这是一个详情',32,998.88,'/static/imgs/course/u=1788562038,3472846301&fm=27&gp=01565793969057.jpg',1),(10,'1243214','2131231242',12,213.123,'/static/imgs/course/6daf8aedf771e18e1567650590710.jpg',8),(11,'234','2134',32,12212,'/static/imgs/course/6daf8aedf771e18e1567650609784.jpg',28);

/*Table structure for table `notify` */

DROP TABLE IF EXISTS `notify`;

CREATE TABLE `notify` (
  `j_id` int(11) NOT NULL COMMENT '教练id',
  `state` tinyint(1) DEFAULT NULL COMMENT '审核状态',
  `id` int(11) DEFAULT NULL COMMENT '审核人',
  `c_id` int(11) DEFAULT NULL COMMENT '所属俱乐部id',
  `checktime` datetime DEFAULT NULL COMMENT '审核时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `notify` */

insert  into `notify`(`j_id`,`state`,`id`,`c_id`,`checktime`) values (1,0,1,1,'2019-09-03 18:40:04'),(27,0,6,9,'2019-09-16 18:40:09'),(8,1,1,1,'2019-09-05 20:00:32'),(11,0,1,1,'2019-09-05 20:55:42'),(6,0,1,1,'2019-09-05 20:55:43'),(9,1,1,1,'2019-09-06 09:24:47');

/*Table structure for table `printpic` */

DROP TABLE IF EXISTS `printpic`;

CREATE TABLE `printpic` (
  `u_id` int(11) DEFAULT NULL COMMENT '用户id',
  `pic_name` varchar(255) DEFAULT NULL COMMENT '图片名字',
  `upload_time` datetime DEFAULT NULL COMMENT '上传时间',
  `desc` varchar(255) DEFAULT NULL COMMENT '描述'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `printpic` */

insert  into `printpic`(`u_id`,`pic_name`,`upload_time`,`desc`) values (1,'/static/imgs/printPic/head.jpg','2019-09-11 21:44:04','asddsasadsadsadsads'),(2,'/static/imgs/printPic/head.jpg','2019-09-11 21:44:35','awefesdgsdgsdg'),(3,'/static/imgs/printPic/head.jpg','2019-09-17 21:44:47','asfeaffasfasfasf'),(1,'/static/imgs/printPic/head.jpg','2019-09-11 21:44:04','asddsasadsadsadsads'),(2,'/static/imgs/printPic/head.jpg','2019-09-11 21:44:35','awefesdgsdgsdg');

/*Table structure for table `recommend` */

DROP TABLE IF EXISTS `recommend`;

CREATE TABLE `recommend` (
  `j_id` int(11) DEFAULT NULL COMMENT '教练id',
  `id` int(11) DEFAULT NULL COMMENT '俱乐部管理员id',
  `checktime` datetime DEFAULT NULL COMMENT '推荐时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `recommend` */

insert  into `recommend`(`j_id`,`id`,`checktime`) values (2,3,'2019-09-05 20:56:05'),(6,3,'2019-09-05 20:56:06'),(10,3,'2019-09-06 09:26:44'),(12,3,'2019-09-06 09:26:46');

/*Table structure for table `training` */

DROP TABLE IF EXISTS `training`;

CREATE TABLE `training` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `intro` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `start_time` datetime NOT NULL,
  `end_time` datetime NOT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `training` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(20) NOT NULL DEFAULT '打不死的小强' COMMENT '用户名',
  `pic` varchar(255) DEFAULT '/static/imgs/head.jpg' COMMENT '用户头像',
  `sex` varchar(10) DEFAULT '男' COMMENT '用户性别',
  `phone` varchar(20) DEFAULT '18742509781' COMMENT '电话',
  `password` varchar(20) NOT NULL COMMENT '用户密码',
  `email` varchar(255) DEFAULT 'xxx@qq.com' COMMENT '用户邮箱',
  `jointime` datetime NOT NULL COMMENT '用户创建时间',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`u_id`,`name`,`pic`,`sex`,`phone`,`password`,`email`,`jointime`) values (1,'yuejian','/static/imgs/user/u=858959453,1988929777&fm=27&gp=01565793366589.jpg','男','18742509781','11','xxx@qq.com','2019-08-20 16:37:41'),(2,'yuejian2','/static/imgs/user/u=1763044357,684998663&fm=27&gp=01565793375170.jpg','男','18742509781','11','xxx@qq.com','2019-08-01 16:37:43'),(3,'二号','/static/imgs/user/u=858959453,1988929777&fm=27&gp=01565793380900.jpg','女','18742509781','11','xxx@qq.com','2019-08-19 16:37:48'),(4,'三号','/static/imgs/user/u=1788562038,3472846301&fm=27&gp=01565793385896.jpg','男','18742509781','11','xxx@qq.com','2019-08-02 16:37:45'),(6,'三号','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-02 16:37:45'),(8,'打不死的小强','/static/imgs/head.jpg','男','18742509781','123','xxx@qq.com','2019-08-12 18:02:41'),(9,'打不死的小强','/static/imgs/head.jpg','男','18742509781','23','xxx@qq.com','2019-08-13 18:05:12'),(10,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(11,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(12,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(13,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(14,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(15,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(16,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(17,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(18,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(19,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(20,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(21,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(22,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(23,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(24,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(28,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(33,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(35,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(37,'打不死的小强','/static/imgs/head.jpg','男','18742509781','11','xxx@qq.com','2019-08-13 18:05:12'),(45,'1232','/static/imgs/user/u=858959453,1988929777&fm=27&gp=01565793393779.jpg','女','12121212121','21','121@qq.com','2019-08-08 01:19:54'),(46,'2113','/static/imgs/user/u=1788562038,3472846301&fm=27&gp=01565793398866.jpg','男','11222122121','13','1211@qq.com','2019-08-11 02:06:15'),(47,'132412','/static/imgs/user/u=1763044357,684998663&fm=27&gp=01565793404206.jpg','女','12121212121','121','1233@qq.com','2019-08-11 02:09:42'),(48,'`314141','/static/imgs/user/u=858959453,1988929777&fm=27&gp=01565793409469.jpg','男','12122121211','2`2`','13131313@qq.com','2019-08-11 10:57:49'),(49,'1232332','','女','12313323232','121323','2323@qq.com','2019-09-05 07:25:55'),(50,'12231','','男','13123232323','1231','112@qq.com','2019-09-05 07:30:46'),(51,'3212','','男','12323232323','2332','1221@qq.com','2019-09-05 07:36:58'),(52,'213321','','男','12323323223','12132','213@qq.com','2019-09-05 19:40:48');

/*Table structure for table `video` */

DROP TABLE IF EXISTS `video`;

CREATE TABLE `video` (
  `v_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '视频id',
  `video` varchar(255) NOT NULL COMMENT '视频地址',
  `name` varchar(50) NOT NULL COMMENT '视频名',
  `c_id` int(11) NOT NULL COMMENT '所属俱乐部id',
  PRIMARY KEY (`v_id`),
  KEY `v_id` (`v_id`),
  KEY `c_id` (`c_id`),
  CONSTRAINT `video_ibfk_1` FOREIGN KEY (`c_id`) REFERENCES `club` (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `video` */

insert  into `video`(`v_id`,`video`,`name`,`c_id`) values (1,'/static/videos/movie1567650799811.mp4','灰姑凉',1),(2,'/static/videos/movie1567567788612.mp4','视频2',2),(3,'/static/videos/movie1567567795496.mp4','sdsd',3),(4,'/static/videos/movie1567567801705.mp4','安抚',4),(5,'/static/videos/video1567558139525.mp4','十点半',5);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
