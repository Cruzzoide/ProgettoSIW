# ************************************************************
# Sequel Pro SQL dump
# Version 4096
#
# http://www.sequelpro.com/
# http://code.google.com/p/sequel-pro/
#
# Host: 127.0.0.1 (MySQL 5.6.23)
# Database: Ssr-Database
# Generation Time: 2015-06-15 11:45:52 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table Address
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Address`;

CREATE TABLE `Address` (
  `id` bigint(20) NOT NULL,
  `cap` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `street` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `Address` WRITE;
/*!40000 ALTER TABLE `Address` DISABLE KEYS */;

INSERT INTO `Address` (`id`, `cap`, `city`, `country`, `street`)
VALUES
	(3601,'00100','Roma','Italia','Via le mani dal naso'),
	(3602,'00100','Qui','Italia','Via da qua'),
	(3604,'00100','Olè','Spagna','Scappa dalla rambla'),
	(5151,'00124','SanPietroBorgo','Russia','Largo borgo brutto'),
	(5401,'00099','MiraMario','NonQui','Porto i pesci a bagnoMario'),
	(8451,'1567','Madrid','Espana','Piazza la bomba e scappa'),
	(9999,'666','Mordor','Napule','Via monto fallo');

/*!40000 ALTER TABLE `Address` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Admin
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Admin`;

CREATE TABLE `Admin` (
  `id` bigint(20) NOT NULL,
  `dateOfBirth` date DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `registrationDate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `U_ADMIN_FIRSTNAME` (`firstName`,`lastName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `Admin` WRITE;
/*!40000 ALTER TABLE `Admin` DISABLE KEYS */;

INSERT INTO `Admin` (`id`, `dateOfBirth`, `email`, `firstName`, `lastName`, `password`, `registrationDate`)
VALUES
	(0,'1992-11-24','mike@ssr.it','Michele','Sampieri','morello92','2015-05-27 00:00:00'),
	(1,'1992-11-13','carl@ssr.it','Carlo','Russo','morello92','2015-05-27 00:00:00'),
	(2,'1992-12-12','leox@ssr.it','Leonardo','Silvi','morello92','2015-05-27 00:00:00');

/*!40000 ALTER TABLE `Admin` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Customer
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Customer`;

CREATE TABLE `Customer` (
  `id` bigint(20) NOT NULL,
  `dateOfBirth` date DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `registrationDate` datetime DEFAULT NULL,
  `ADDRESS_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `U_CUSTOMR_FIRSTNAME` (`firstName`,`lastName`),
  KEY `I_CUSTOMR_ADDRESS` (`ADDRESS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `Customer` WRITE;
/*!40000 ALTER TABLE `Customer` DISABLE KEYS */;

INSERT INTO `Customer` (`id`, `dateOfBirth`, `email`, `firstName`, `lastName`, `password`, `registrationDate`, `ADDRESS_ID`)
VALUES
	(3551,'1992-01-24','palm@niente.it','Emanuele','Palmulli','1234','2015-05-25 14:55:51',3601),
	(3552,'1992-01-28','leox@sama.it','Leonardo','Silvi','1234','2015-05-25 14:57:40',3602),
	(3554,'1992-01-21','cos@bra.it','Costanza','Brachetti','1234','2015-05-25 14:58:23',3604),
	(5101,'1800-01-12','leb@bron.it','Luca','Lebron','12345','2015-05-26 12:31:39',5151),
	(5351,'1992-01-01','car@lo.it','Carlo','Russo','1234','2015-05-26 13:26:25',5401),
	(8401,'1992-01-21','eSoSimone@ros.it','Simone','Rossetti','1234','2015-06-15 11:13:13',8451);

/*!40000 ALTER TABLE `Customer` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table OPENJPA_SEQUENCE_TABLE
# ------------------------------------------------------------

DROP TABLE IF EXISTS `OPENJPA_SEQUENCE_TABLE`;

CREATE TABLE `OPENJPA_SEQUENCE_TABLE` (
  `ID` tinyint(4) NOT NULL,
  `SEQUENCE_VALUE` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `OPENJPA_SEQUENCE_TABLE` WRITE;
/*!40000 ALTER TABLE `OPENJPA_SEQUENCE_TABLE` DISABLE KEYS */;

INSERT INTO `OPENJPA_SEQUENCE_TABLE` (`ID`, `SEQUENCE_VALUE`)
VALUES
	(0,8501);

/*!40000 ALTER TABLE `OPENJPA_SEQUENCE_TABLE` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table order_line
# ------------------------------------------------------------

DROP TABLE IF EXISTS `order_line`;

CREATE TABLE `order_line` (
  `id` bigint(20) NOT NULL,
  `quantity` int(11) NOT NULL,
  `unitPrice` double NOT NULL,
  `orders_id` bigint(20) DEFAULT NULL,
  `PRODUCT_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `I_ORDR_LN_PRODUCT` (`PRODUCT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `order_line` WRITE;
/*!40000 ALTER TABLE `order_line` DISABLE KEYS */;

INSERT INTO `order_line` (`id`, `quantity`, `unitPrice`, `orders_id`, `PRODUCT_ID`)
VALUES
	(6451,5,1,6401,1),
	(6452,5,2,6401,951),
	(6551,5,1,6501,1),
	(6552,5,2,6501,951),
	(6651,3,3,6601,1151),
	(6652,2,1,6601,1),
	(6751,3,3,6701,1151),
	(6851,3,1,6801,1),
	(7001,3,1,6951,1),
	(7002,3,4,6951,6901),
	(7101,25,123,7051,1351),
	(7251,2,453821,7201,7151),
	(7351,2,453821,7301,7151),
	(7352,2,1,7301,1),
	(7451,2,453821,7401,7151),
	(7452,2,2,7401,951),
	(7551,3,123,7501,1351),
	(7552,3,2,7501,951),
	(7553,3,123,7502,1351);

/*!40000 ALTER TABLE `order_line` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table orders
# ------------------------------------------------------------

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL,
  `closeTime` datetime DEFAULT NULL,
  `creationTime` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `CUSTOMER_ID_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `I_ORDERS_CUSTOMER_ID` (`CUSTOMER_ID_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;

INSERT INTO `orders` (`id`, `closeTime`, `creationTime`, `status`, `CUSTOMER_ID_ID`)
VALUES
	(6401,'2015-05-27 16:14:58','2015-05-27 16:14:43','Dispatched',5101),
	(6501,'2015-05-27 16:35:51','2015-05-27 16:35:31','Not dispatched',5101),
	(6601,'2015-06-09 10:28:49','2015-06-09 10:24:55','Dispatched',5101),
	(6701,'2015-06-09 11:04:33','2015-06-09 11:03:38','Not dispatched',3554),
	(6951,'2015-06-11 18:02:13','2015-06-11 18:01:01','Dispatched',5101),
	(7051,'2015-06-11 18:18:39','2015-06-11 18:18:23','Dispatched',5101),
	(7201,'2015-06-11 18:25:51','2015-06-11 18:25:35','Not dispatched',3554),
	(7301,'2015-06-12 15:13:34','2015-06-12 15:12:54','Not dispatched',3554),
	(7401,'2015-06-12 15:20:28','2015-06-12 15:20:14','Not dispatched',3554),
	(7501,'2015-06-12 15:26:00','2015-06-12 15:25:41','Dispatched',5101),
	(7502,'2015-06-12 15:27:22','2015-06-12 15:27:08','Dispatched',5101),
	(7503,'2015-06-12 15:27:48','2015-06-12 15:27:31','Dispatched',5101);

/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Product
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Product`;

CREATE TABLE `Product` (
  `id` bigint(20) NOT NULL,
  `code` varchar(255) NOT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `U_PRODUCT_CODE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `Product` WRITE;
/*!40000 ALTER TABLE `Product` DISABLE KEYS */;

INSERT INTO `Product` (`id`, `code`, `description`, `name`, `price`, `quantity`)
VALUES
	(1,'fst','Primo Prodotto\r\n','primo',1,17),
	(951,'snd','Secondo prodotto','Secondo',2,12),
	(1151,'trd','Terzo prodotto','terzo',3,24),
	(1351,'qwe','','qwe',123,55),
	(6901,'qrt','Quarto Prodotto\r\n','Quarto',4,37),
	(7151,'312dawd','E\' un prodotto prelibbbbbato che costa un bbbbbbotto. #OPULENZA','ATTENZIONE! Quinto',453821,1),
	(7701,'qasfsf','prova','qwr',14,20);

/*!40000 ALTER TABLE `Product` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table Product_provider
# ------------------------------------------------------------

DROP TABLE IF EXISTS `Product_provider`;

CREATE TABLE `Product_provider` (
  `PRODUCT_ID` bigint(20) DEFAULT NULL,
  `PROVIDERS_ID` bigint(20) DEFAULT NULL,
  KEY `I_PRDCVDR_ELEMENT` (`PROVIDERS_ID`),
  KEY `I_PRDCVDR_PRODUCT_ID` (`PRODUCT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



# Dump of table provider
# ------------------------------------------------------------

DROP TABLE IF EXISTS `provider`;

CREATE TABLE `provider` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phoneNumber` varchar(255) NOT NULL,
  `vatin` varchar(255) NOT NULL,
  `ADDRESS_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `U_PROVIDR_NAME` (`name`),
  KEY `I_PROVIDR_ADDRESS` (`ADDRESS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `provider` WRITE;
/*!40000 ALTER TABLE `provider` DISABLE KEYS */;

INSERT INTO `provider` (`id`, `email`, `name`, `phoneNumber`, `vatin`, `ADDRESS_ID`)
VALUES
	(1,'giggi@yes.it','Giggi','610610','HJV234BJHV',3601),
	(2,'antonio@antony.com','InternationalTony','123894','UIBGHB726IG',9999);

/*!40000 ALTER TABLE `provider` ENABLE KEYS */;
UNLOCK TABLES;


# Dump of table provider_Product
# ------------------------------------------------------------

DROP TABLE IF EXISTS `provider_Product`;

CREATE TABLE `provider_Product` (
  `PROVIDER_ID` bigint(20) DEFAULT NULL,
  `PRODUCTS_ID` bigint(20) DEFAULT NULL,
  KEY `I_PRVDDCT_ELEMENT` (`PRODUCTS_ID`),
  KEY `I_PRVDDCT_PROVIDER_ID` (`PROVIDER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
