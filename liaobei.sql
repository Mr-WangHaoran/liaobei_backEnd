/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.7.26 : Database - liaobei
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`liaobei` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*Table structure for table `friend` */

DROP TABLE IF EXISTS `friend`;

CREATE TABLE `friend` (
  `main_id` int(11) DEFAULT NULL COMMENT '用户id',
  `friend_id` int(11) DEFAULT NULL COMMENT '好友id'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `friend` */

insert  into `friend`(`main_id`,`friend_id`) values (1,7),(7,1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(30) DEFAULT NULL COMMENT '用户昵称',
  `sex` char(1) DEFAULT NULL COMMENT '用户性别',
  `telNumber` char(11) DEFAULT NULL COMMENT '用户电话',
  `password` varchar(200) DEFAULT NULL COMMENT '用户登录密码',
  `state` int(11) DEFAULT NULL COMMENT '用户状态',
  `height` int(11) DEFAULT NULL COMMENT '用户身高',
  `address` varchar(200) DEFAULT NULL COMMENT '用户住址',
  `avatar` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `birth` date DEFAULT NULL COMMENT '用户生日',
  `desc` varchar(200) DEFAULT NULL COMMENT '用户个性签名',
  `age` int(11) DEFAULT NULL COMMENT '用户年龄',
  `send_id` int(11) DEFAULT '-1' COMMENT '被添加用户的id',
  `send_msg` int(11) DEFAULT '-1' COMMENT '此用户要添加的用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`sex`,`telNumber`,`password`,`state`,`height`,`address`,`avatar`,`birth`,`desc`,`age`,`send_id`,`send_msg`) values (1,'张三','0','123','e10adc3949ba59abbe56e057f20f883e',1,175,'博颂路35号','https://img2.baidu.com/it/u=497340828,56639319&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500','2000-07-01','我是一个大帅锅！！',22,-1,-1),(2,'粉红色的小猪','1','321','e10adc3949ba59abbe56e057f20f883e',3,170,'花园路文苑','https://img2.baidu.com/it/u=2182014426,2379325530&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500','2000-11-02','美女一个',18,-1,-1),(3,'大佬','0','1234','e10adc3949ba59abbe56e057f20f883e',2,NULL,NULL,'https://img1.baidu.com/it/u=1190651332,3402773154&fm=253&fmt=auto&app=138&f=JPEG?w=400&h=400',NULL,NULL,26,-1,-1),(4,'花和尚','0','12345','e10adc3949ba59abbe56e057f20f883e',1,NULL,NULL,'https://img2.baidu.com/it/u=1815374696,2704028021&fm=253&fmt=auto&app=120&f=JPEG?w=750&h=750',NULL,NULL,NULL,-1,-1),(5,'喜欢吃shi','0','123456','d41d8cd98f00b204e9800998ecf8427e',2,NULL,NULL,'https://img1.baidu.com/it/u=2114684366,854047881&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500',NULL,NULL,NULL,-1,-1),(6,'我是小明','0','3333','d41d8cd98f00b204e9800998ecf8427e',3,NULL,NULL,'https://img1.baidu.com/it/u=1994859516,3472573535&fm=253&fmt=auto&app=138&f=JPEG?w=400&h=400',NULL,NULL,NULL,-1,-1),(7,'王继超','1','222','d41d8cd98f00b204e9800998ecf8427e',NULL,NULL,NULL,NULL,NULL,NULL,22,-1,-1);

/*Table structure for table `wechat` */

DROP TABLE IF EXISTS `wechat`;

CREATE TABLE `wechat` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '朋友圈id',
  `username` varchar(30) DEFAULT NULL COMMENT '用户姓名',
  `avatar` varchar(200) DEFAULT NULL COMMENT '用户头像',
  `content` varchar(255) DEFAULT NULL COMMENT '用户发表的内容',
  `date` date DEFAULT NULL COMMENT '用户发表的日期',
  `address` varchar(200) DEFAULT NULL COMMENT '用户地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `wechat` */

insert  into `wechat`(`id`,`username`,`avatar`,`content`,`date`,`address`) values (1,'张三','https://img2.baidu.com/it/u=497340828,56639319&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500','今天是个好日子啊！！！','2022-01-13','河南省郑州市金水区东风路67-16号'),(2,'粉红色的小猪','https://img2.baidu.com/it/u=2182014426,2379325530&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500','确实','2022-01-13','');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
