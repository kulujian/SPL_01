/*Table structure for table `sys_user` */
DROP TABLE IF EXISTS `finweb`.`sys_user`;
CREATE TABLE `finweb`.`sys_user` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`username` varchar(50) DEFAULT NULL,
	`password` varchar(50) DEFAULT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=UTF8;

/* Data for the able `sys_user` */
INSERT INTO `sys_user` (`username`, `password`) VALUES
('root', 'root'),
('kulu', 'love1025');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=#OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;