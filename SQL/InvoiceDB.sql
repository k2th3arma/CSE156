-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: invoicedb
-- ------------------------------------------------------
-- Server version	5.7.11-log

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
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `CustomerID` int(11) NOT NULL,
  `CustomerType` varchar(45) DEFAULT NULL,
  `CustomerContact` varchar(45) DEFAULT NULL,
  `CustomerLocation` varchar(45) DEFAULT NULL,
  `CustomerCode` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CustomerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'B','UNL','259 Avery st, Lincoln, Ne, 68528, USA','231'),(2,'B','Stark','912 E Kirwin AVe, SAlina KS, 67401, USA','944c'),(3,'R','Tom Eddision','1182 James Ave N, Minneapolis, MN, 55411, USA','306a'),(4,'B','NSA','151 Easton Ave, Waterloo, IA, 50702, USA','321f'),(5,'R','Vandelay','1060 West Addsion, Chicago, IL, 60601, USA','bbchar'),(6,'R','Supply CO','456 West 7th St, Omaha, NE, 68500, USA','321dr');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice` (
  `idInvoice` int(11) NOT NULL,
  `InvoiceNum` varchar(45) DEFAULT NULL,
  `InvoiceCustomer` varchar(45) DEFAULT NULL,
  `InvoiceDate` varchar(45) DEFAULT NULL,
  `InvoiceRepCode` varchar(45) DEFAULT NULL,
  `InvoiceProduct` varchar(45) DEFAULT NULL,
  `InvoiceAmount` varchar(45) DEFAULT NULL,
  `InvoiceTimeFrame` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idInvoice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (1,'1','2','2016-02-01','nwdoc1','b29e','2',NULL),(2,'2','1','2016-01-19','wrddoc','ff23','25 ',NULL),(3,'2','1','2016-01-19','wrddoc','3289','10',NULL),(4,'3','5','2015-11-23','2ndbestd','ff23','10',NULL),(5,'3','5','2015-11-23','2ndbestd','90fa',NULL,'2015-11-15:2016-12-31'),(6,'4','2','2016-03-01','2ndbestd','782g','10',NULL),(7,'4','2','2016-03-01','2ndbestd','3294',NULL,'2015-01-01:2016-12-31'),(8,'4','2','2016-03-01','2ndbestd','3295',NULL,'2016-02-11:2018-12-31');
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `idPerson` int(11) NOT NULL,
  `PersonCode` varchar(45) DEFAULT NULL,
  `PersonName` varchar(45) DEFAULT NULL,
  `PersonAddress` varchar(90) DEFAULT NULL,
  `PersonContact` varchar(90) DEFAULT NULL,
  PRIMARY KEY (`idPerson`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'944c','McCoy, Sylvester','1060 West Addsion St, Chicago, IL, 60613, USA','smccoy@cubs.com, sylve_mccoy13@gamil.com'),(2,'306a','Pertwee, Jon','123 N 1st St, Omaha, NE, 68116, USA','j_pertwee@gmail.vom, jon@venture.com'),(3,'55bb','Fox, Bud','8753 West 3rd Ave, TX, 75001, USA','obrien@ds9.com,obrien@enterprise.gov'),(4,'2342','O\'Brian, Mackein','123 Friendly Street,Ottawa,ON,K1A 0G9,Canada',' here '),(5,'aef1','Gekko, Gordon','1 Wall Street,New York,NY,10005-0012,USA','gekko@crazy.net'),(6,'321f','Sampson, Brock',' Brock;321 Bronx Street,New York,NY,10004,USA',NULL),(7,'ma12','Pete, Dale','1060 West Addison Street,Chicago,IL,60613,USA','pdale@cubs.com'),(8,'321nd','Thotroy, William','1060 West Addison Street,Chicago,IL,60613,USA','willth@doctors.com,wth@who.com'),(9,'nf32a','Troughton, Baily','1060 West Addison Street,Chicago,IL,60613,USA','btroug@cse.unl.edu,btrou32@unl.edu'),(10,'321na','Stratler, Goody','301 Front St W, Toronto, ON, M5V 2T6, Canada','gstrat@whofan.com'),(11,'231','Earl, Holley','1 Blue Jays Way, Toronto, ON, M5V 1J1, Canada','famousholl@who.com,hearl@cse.unl.edu,holleyearl@whovian.com,earl12@bbc.com'),(12,'6doc','Hurndall, Richard','Campos El290,Mexico City, FD,, Mexico','rhurndall@cse.unl.edu,richard@unl.edu'),(13,'321dr','Baker, Samantha ','Avery Hall,Lincoln,NE,68503,USA','sb@baker.com'),(14,'1svndr','O\'Brien, Starlin','126-01 Roosevelt Ave, Flushing, NY,11368,USA','slyguy@hotmail.com,obrein@whofan.com'),(15,'123lst','McGann, Paul','1 MetLife Stadium Dr, East Rutherford, NJ,07073,USA','pmcgann@mlb.com,pfoo@bar.com,pmc@unl.edu'),(16,'nwdoc1','Eccleston, Chris','1 E 161st St, Bronx, NY,10451,USA',NULL),(17,'2ndbestd','Castro, David','700 E Grand Ave, Chicago, IL, 60611,USA','david@shakespeare.com,dcastro@unl.edu'),(18,'wrddoc','Smith, Matt','333 W 35th St, Chicago, IL,60616,USA','msmith@who.com,smatt@cse.unl.edu'),(19,'bbchar','Tennant, Kaylee','800 West 7th Street, Albuquerque, NM, 87105,USA',NULL),(20,'doc05','Ehrmantraut, Peter','123 Cabo San Lucas, Los Cabos, BCS, 11211, Mexico','pete@gmail.com'),(21,'noob','delete, me',NULL,NULL);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `idProducts` int(11) NOT NULL,
  `ProductCode` varchar(45) DEFAULT NULL,
  `ProductType` varchar(45) DEFAULT NULL,
  `ProductName` varchar(45) DEFAULT NULL,
  `ProductUnitPrice` double DEFAULT NULL,
  `ProductSetUp` double DEFAULT NULL,
  `CCode` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idProducts`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'b29e','E','Satellite Reciever',2500,0,NULL),(2,'ff23','E','ireless5G Router',124.99,NULL,NULL),(3,'fp12','E','Netgear DSL Modem',63.99,0,NULL),(4,'1239','E','Digital Setup Box',200,NULL,NULL),(5,'90fa','S','Long Distance Service',2000,12000,NULL),(6,'3289','C','Turbo Upgrade-Internet',25,NULL,'aef1'),(7,'782g','C','Home Wifi Setup',150,NULL,'321nd'),(8,'3294','S','L2 Home Security',NULL,35000,NULL),(9,'3295','S','Domain registration',350,1200,NULL);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-16 20:16:22
