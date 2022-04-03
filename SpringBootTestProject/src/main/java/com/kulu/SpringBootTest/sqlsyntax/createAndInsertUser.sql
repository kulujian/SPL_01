/*Table structure for table `user` */
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`username` varchar(50) DEFAULT NULL,
	`age` int(11) DEFAULT NULL,
	`address` varchar(50) DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=UTF-8;

/* Data for the able `user` */
INSERT INTO `user` (`id`, `username`, `age`, `address`) VALUES
(2,'pdd',25,'上海'),
(3,'UZI',19,'上海11'),
(4,'RF',19,NULL),
(6,'三更',14,'請問2'),
(8,'test1',11,'cc'),
(9,'test2',12,'cc2');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=#OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
