-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: shoeshop
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `product_name` varchar(45) DEFAULT NULL,
  `product_image` varchar(45) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `product_price` double DEFAULT NULL,
  `product_description` longtext,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Nike 1','images/nike_1.jpg',1,2,'Good'),(2,'Nike 2','images/nike_2.jpg',1,1,'Good'),(3,'Nike 3','images/nike_3.jpg',1,3,'Good'),(4,'Nike 4','images/nike_4.jpg',1,4,'Good'),(5,'Nike 5','images/nike_5.jpg',1,2,'Good'),(6,'Nike 6','images/nike_6.jpg',1,3,'Good'),(7,'Nike 7','images/nike_7.jpg',1,3,'Good'),(8,'Nike 8','images/nike_8.jpg',1,4,'Good'),(9,'Nike 9','images/nike_9.jpg',1,4,'Good'),(10,'Nike 10','images/nike_10.jpg',1,4,'Good'),(11,'Nike 11','images/nike_11.jpg',1,4,'Good'),(12,'Adidas 1','images/adidas_1.jpg',2,1,'Good'),(13,'Adidas 2','images/adidas_2.jpg',2,3,'Good'),(14,'Adidas 3','images/adidas_3.jpg',2,4,'Good'),(15,'Adidas 4','images/adidas_4.jpg',2,2,'Good'),(16,'Adidas 5','images/adidas_5.jpg',2,1,'Good'),(17,'Adidas 6','images/adidas_6.jpg',2,4,'Good'),(18,'Adidas 7','images/adidas_7.jpg',2,2,'Good'),(19,'Adidas 8','images/adidas_8.jpg',2,4,'Good'),(20,'Adidas 9','images/adidas_9.jpg',2,1,'Good'),(23,'Vans 1','images/vans_1.jpg',3,4,'Good'),(24,'Vans 2','images/vans_2.jpg',3,4,'Good'),(25,'Vans 3','images/vans_3.jpg',3,3,'Good'),(26,'Vans 4','images/vans_4.jpg',3,2,'Good'),(27,'Vans 5','images/vans_5.jpg',3,2,'Good'),(28,'Vans 6','images/vans_6.jpg',3,3,'Good'),(29,'Vans 7','images/vans_7.jpg',3,1,'Good'),(30,'Vans 8','images/vans_8.jpg',3,3,'Good'),(31,'Vans 9','images/vans_9.jpg',3,2,'Good'),(32,'Vans 10','images/vans_10.jpg',3,1,'Good'),(33,'Converse 1','images/converse_1.jpg',4,4,'Good'),(34,'Converse 2','images/converse_2.jpg',4,1,'Good'),(35,'Converse 3','images/converse_3.jpg',4,2,'Good'),(36,'Converse 4','images/converse_4.jpg',4,4,'Good'),(37,'Converse 5','images/converse_5.jpg',4,2,'Good'),(38,'Reebok 1','images/reebok_1.jpg',5,1,'Good'),(39,'Reebok 2','images/reebok_2.jpg',5,3,'Good'),(40,'Reebok 3','images/reebok_3.jpg',5,3,'Good'),(41,'Reebok 4','images/reebok_4.jpg',5,2,'Good'),(42,'Reebok 5','images/reebok_5.jpg',5,3,'Good'),(43,'Reebok 6','images/reebok_6.jpg',5,4,'Good'),(44,'Reebok 7','images/reebok_7.jpg',5,4,'Good'),(45,'Reebok 8','images/reebok_8.jpg',5,1,'Good'),(46,'Reebok 9','images/reebok_9.jpg',5,2,'Good'),(47,'Reebok 10','images/reebok_10.jpg',5,4,'Good'),(48,'Balenciaga 1','images/balenciaga_1.jpg',6,3,'Good'),(49,'Balenciaga 2','images/balenciaga_2.jpg',6,2,'Good'),(50,'Balenciaga 3','images/balenciaga_3.jpg',6,4,'Good'),(51,'Balenciaga 4','images/balenciaga_4.jpg',6,3,'Good'),(52,'Balenciaga 5','images/balenciaga_5.jpg',6,2,'Good');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-02 16:45:49
