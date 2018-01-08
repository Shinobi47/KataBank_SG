CREATE DATABASE  IF NOT EXISTS `sgtest` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sgtest`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: sgtest
-- ------------------------------------------------------
-- Server version	5.6.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cli`
--

DROP TABLE IF EXISTS `cli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cli` (
  `idCLI` int(11) NOT NULL AUTO_INCREMENT,
  `cli_name` varchar(45) NOT NULL,
  `cli_pwd` varchar(45) NOT NULL,
  PRIMARY KEY (`idCLI`),
  UNIQUE KEY `idCLI_UNIQUE` (`idCLI`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cli`
--

LOCK TABLES `cli` WRITE;
/*!40000 ALTER TABLE `cli` DISABLE KEYS */;
INSERT INTO `cli` VALUES (1,'haytam','1122');
/*!40000 ALTER TABLE `cli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ope`
--

DROP TABLE IF EXISTS `ope`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ope` (
  `id_op` int(11) NOT NULL AUTO_INCREMENT,
  `op_name` varchar(1) NOT NULL,
  `ope_date` varchar(45) DEFAULT NULL,
  `balance` int(11) DEFAULT NULL,
  `fk_idCLI` int(11) NOT NULL,
  `amount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_op`),
  UNIQUE KEY `idOPEHIS_UNIQUE` (`id_op`),
  KEY `fk_ope_cli_idx` (`fk_idCLI`),
  CONSTRAINT `fk_ope_cli` FOREIGN KEY (`fk_idCLI`) REFERENCES `cli` (`idCLI`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ope`
--

LOCK TABLES `ope` WRITE;
/*!40000 ALTER TABLE `ope` DISABLE KEYS */;
INSERT INTO `ope` VALUES (2,'D','11/11/2016',2000,1,0),(8,'D','10/08/2017',2012,1,12),(9,'D','10/08/2017',2362,1,350),(10,'D','10/08/2017',2485,1,123),(11,'D','10/08/2017',2605,1,120),(12,'D','10/08/2017',2734,1,129),(13,'D','10/08/2017',2968,1,234),(14,'W','12/09/2017',2618,1,350),(15,'W','12/09/2017',2268,1,350),(16,'D','12/09/2017',2290,1,22),(17,'D','12/09/2017',2401,1,111),(18,'D','12/09/2017',2513,1,112),(19,'D','12/09/2017',2536,1,23),(20,'W','12/09/2017',2425,1,111),(21,'W','12/09/2017',2096,1,329);
/*!40000 ALTER TABLE `ope` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-09-12 18:08:02
