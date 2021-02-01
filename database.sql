-- MySQL dump 10.13  Distrib 8.0.22, for macos10.15 (x86_64)
--
-- Host: localhost    Database: plasmadonation
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `donar`
--

DROP TABLE IF EXISTS `donar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donar` (
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `streetaddress` varchar(45) DEFAULT NULL,
  `addressline1` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `province` varchar(45) DEFAULT NULL,
  `postalcode` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `bloodgroup` varchar(45) DEFAULT NULL,
  `confirmedtest` varchar(45) DEFAULT NULL,
  `covidtest` varchar(45) DEFAULT NULL,
  `currentlysymptoms` varchar(45) DEFAULT NULL,
  `lastdayofsymptom` varchar(45) DEFAULT NULL,
  `lastdayofcovidbefore14days` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donar`
--

LOCK TABLES `donar` WRITE;
/*!40000 ALTER TABLE `donar` DISABLE KEYS */;
INSERT INTO `donar` VALUES ('Karthik','Gali','galikarthik09@gmail.com','O+','4567','3456','Redmond','Alberta','56098','UnitedStates',NULL,'yes','yes','no','2020/11/01','yes','2020/11/28'),('Preethi','S','spreethi@gmail.com','O+','6789','987','Kansas','Alberta','90876','UnitedStates',NULL,'yes','yes','yes','2020-11-15','yes','2020/12/02'),('Anvesh','B','anvesh@gmail.com','O+','4567','456','Overland Park','Alberta','90876','UnitedStates',NULL,'yes','yes','no','2020-11-24','yes','2020/12/02');
/*!40000 ALTER TABLE `donar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request`
--

DROP TABLE IF EXISTS `request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `request` (
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `streetaddress` varchar(45) DEFAULT NULL,
  `addressline1` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `province` varchar(45) DEFAULT NULL,
  `postalcode` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `bloodgroup` varchar(45) DEFAULT NULL,
  `confirmedtest` varchar(45) DEFAULT NULL,
  `symptomspresent` varchar(45) DEFAULT NULL,
  `dateOffirstsymptom` varchar(45) DEFAULT NULL,
  `symptoms` varchar(45) DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request`
--

LOCK TABLES `request` WRITE;
/*!40000 ALTER TABLE `request` DISABLE KEYS */;
INSERT INTO `request` VALUES ('Priya','M','pmuddalapura@gmail.com','O+','456','345','Overland Park','Alberta','98056','UnitedStates',NULL,'yes','yes','2020/11/16','fever,drycough,tiredness,','2020/11/29'),('Sree','Surapaneni','sxs54300@ucmo.edu','O+','2345','456','Overland Park','Alberta','97045','UnitedStates',NULL,'yes','yes','2020-11-25','fever,drycough,','2020/12/02'),('Sree','Surapaneni','sxs54300@ucmo.edu','O+','2345','456','Overland Park','Alberta','97045','UnitedStates',NULL,'yes','yes','2020-11-20','fever,drycough,','2020/12/02'),('Anvesh','B','anvesh@gmail.com','O+','4567','456','Overland Park','Alberta','90876','UnitedStates',NULL,'yes','yes','2020-11-24','fever,drycough,tiredness,','2020/12/02');
/*!40000 ALTER TABLE `request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `streetaddress` varchar(45) DEFAULT NULL,
  `addressline2` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `province` varchar(45) DEFAULT NULL,
  `postalcode` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('Priyanka','Muddalapuram','pxm61960@ucmo.edu','priyanka','female','4250 W','2019','Redmond','King County','98052','US','admin'),('Karthik','Gali','galikarthik09@gmail.com','karthik','male','4567','3456','Redmond','BritishColumbia','56098','UnitedStates','user'),('Priya','M','pmuddalapura@gmail.com','priyanka','female','456','345','Overland Park','Alberta','98056','UnitedStates','user'),('Sree','Surapaneni','sxs54300@ucmo.edu','sree','female','2345','456','Overland Park','Alberta','97045','UnitedStates','user'),('Preethi','S','spreethi@gmail.com','preethi','female','6789','987','Kansas','BritishColumbia','90876','UnitedStates','user'),('Anvesh','B','anvesh@gmail.com','anvesh','male','4567','456','Overland Park','Alberta','90876','UnitedStates','user');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-12-02 19:33:56
