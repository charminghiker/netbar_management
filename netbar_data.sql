-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: netbar2
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES UTF8MB4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `netbar2`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `netbar2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE `netbar2`;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `admin` (
  `AdminId` int(11) NOT NULL,
  `AdminPass` varchar(50) DEFAULT NULL,
  `AdminName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`AdminId`),
  KEY `AdminId` (`AdminId`),
  KEY `AdminId_2` (`AdminId`),
  KEY `AdminId_3` (`AdminId`),
  KEY `AdminId_4` (`AdminId`),
  KEY `AdminId_5` (`AdminId`),
  KEY `AdminId_6` (`AdminId`),
  KEY `AdminId_7` (`AdminId`),
  KEY `AdminId_8` (`AdminId`),
  KEY `AdminId_9` (`AdminId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理员信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (888001,'01001','零零壹'),(888002,'02002','mayun'),(888007,'07007','007'),(888666,'06006','boss');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `intaddrec`
--

DROP TABLE IF EXISTS `intaddrec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `intaddrec` (
  `AddRecordID` int(11) NOT NULL AUTO_INCREMENT COMMENT '充值记录编号',
  `AddTime` datetime DEFAULT NULL COMMENT '充值时间',
  `InterimID` int(11) DEFAULT NULL COMMENT '临时卡号',
  `AddMoney` int(11) DEFAULT NULL COMMENT '金额',
  `AdminID` int(11) DEFAULT NULL COMMENT '管理员编号',
  PRIMARY KEY (`AddRecordID`),
  KEY `FK_Reference_10` (`AdminID`),
  KEY `FK_Reference_9` (`InterimID`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`AdminID`) REFERENCES `admin` (`adminid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`InterimID`) REFERENCES `interim` (`interimid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=80418031 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='临时充值记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `intaddrec`
--

LOCK TABLES `intaddrec` WRITE;
/*!40000 ALTER TABLE `intaddrec` DISABLE KEYS */;
INSERT INTO `intaddrec` VALUES (80418001,'2019-04-18 11:45:52',5,5,888002),(80418004,'2019-04-18 15:04:36',4,5,888007),(80418005,'2019-04-18 15:06:38',4,5,888007),(80418006,'2019-04-18 15:07:41',2,5,888007),(80418007,'2019-04-18 15:08:05',4,5,888007),(80418008,'2019-04-18 15:10:52',2,5,888007),(80418009,'2019-04-18 15:13:00',2,5,888007),(80418010,'2019-04-18 15:13:02',4,5,888007),(80418011,'2019-04-18 15:13:28',4,5,888007),(80418012,'2019-04-18 15:15:56',2,5,888007),(80418013,'2019-04-18 15:16:07',4,5,888007),(80418014,'2019-04-18 15:20:31',5,5,888007),(80418015,'2019-04-18 15:20:40',4,5,888007),(80418016,'2019-04-18 15:46:50',5,5,888007),(80418017,'2019-04-18 16:30:49',2,5,888007),(80418018,'2019-04-19 10:34:18',2,5,888007),(80418019,'2019-04-19 10:44:56',2,5,888007),(80418020,'2019-04-19 11:07:57',4,5,888007),(80418021,'2019-04-19 11:13:01',2,5,888007),(80418022,'2019-04-19 11:24:55',2,5,888007),(80418023,'2019-04-19 11:37:23',2,5,888007),(80418024,'2019-04-19 11:40:07',3,5,888007),(80418025,'2019-04-19 11:41:21',3,5,888007),(80418026,'2019-04-19 11:43:08',3,5,888007),(80418027,'2019-04-19 15:47:49',2,5,888007),(80418028,'2019-04-19 23:28:10',1,5,888007),(80418029,NULL,NULL,NULL,NULL),(80418030,'2019-05-26 16:05:45',2,33,888007);
/*!40000 ALTER TABLE `intaddrec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interim`
--

DROP TABLE IF EXISTS `interim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `interim` (
  `InterimID` int(11) NOT NULL,
  `InterimPass` varchar(50) DEFAULT NULL,
  `InterimState` int(10) DEFAULT '0',
  `InterimAccount` int(11) DEFAULT '0',
  PRIMARY KEY (`InterimID`),
  KEY `InterimID` (`InterimID`),
  KEY `InterimID_2` (`InterimID`),
  KEY `InterimID_3` (`InterimID`),
  KEY `InterimID_4` (`InterimID`),
  KEY `InterimID_5` (`InterimID`),
  KEY `InterimID_6` (`InterimID`),
  KEY `InterimID_7` (`InterimID`),
  KEY `InterimID_8` (`InterimID`),
  KEY `InterimID_9` (`InterimID`),
  KEY `InterimID_10` (`InterimID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='临时卡表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interim`
--

LOCK TABLES `interim` WRITE;
/*!40000 ALTER TABLE `interim` DISABLE KEYS */;
INSERT INTO `interim` VALUES (1,'123456',0,0),(2,'123456',0,0),(3,'123456',0,0),(4,'123456',0,0),(5,'123456',1,50),(6,'123456',0,0);
/*!40000 ALTER TABLE `interim` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `intuserec`
--

DROP TABLE IF EXISTS `intuserec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `intuserec` (
  `UseRecordID` int(11) NOT NULL AUTO_INCREMENT COMMENT '上机记录编号',
  `MachineID` int(11) DEFAULT NULL COMMENT '机器编号',
  `StartTime` datetime DEFAULT NULL COMMENT '开始时间',
  `EndTime` datetime DEFAULT NULL COMMENT '结束时间',
  `InterimID` int(11) DEFAULT NULL COMMENT '临时卡号',
  `AdminID` int(11) DEFAULT NULL COMMENT '管理员编号',
  `AddMoney` int(11) DEFAULT NULL COMMENT '充值',
  `Consumption` int(11) DEFAULT NULL COMMENT '消费',
  `Remains` int(11) DEFAULT NULL COMMENT '余额',
  PRIMARY KEY (`UseRecordID`),
  KEY `FK_Reference_7` (`InterimID`),
  KEY `FK_Reference_8` (`AdminID`),
  KEY `FK_Reference_6` (`MachineID`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`MachineID`) REFERENCES `machine` (`machineid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`InterimID`) REFERENCES `interim` (`interimid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`AdminID`) REFERENCES `admin` (`adminid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=3180032 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='临时上机记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `intuserec`
--

LOCK TABLES `intuserec` WRITE;
/*!40000 ALTER TABLE `intuserec` DISABLE KEYS */;
INSERT INTO `intuserec` VALUES (3170001,1,'2019-03-28 15:41:47','2019-03-23 13:00:00',1,888001,500,NULL,0),(3180001,1,'2019-04-09 10:32:32','2019-04-09 10:32:25',1,888001,500,NULL,0),(3180004,6,'2019-03-28 15:41:38','2019-03-28 15:31:39',2,888001,10,NULL,5),(3180005,3,'2019-04-19 15:41:45','2019-04-19 17:00:12',2,888001,60,10,50),(3180006,6,'2019-04-10 10:16:34','2019-04-10 10:16:34',3,888001,500,2448,5),(3180014,5,'2019-04-18 15:20:40','2019-04-19 22:12:33',4,888001,535,93,442),(3180015,6,'2019-04-10 10:16:34','2019-04-10 10:16:34',6,888666,66,2448,5),(3180016,5,'2019-04-18 15:46:50','2019-04-19 22:12:33',5,888001,65,93,442),(3180017,4,'2019-04-18 15:20:40','2019-04-19 22:12:42',4,888001,79,93,-14),(3180018,10,'2019-04-09 10:40:07','2019-04-09 10:40:03',1,888001,100,0,100),(3180021,10,'2019-04-09 10:49:30','2019-04-09 10:49:30',1,888001,100,0,100),(3180022,13,'2019-04-09 10:50:48','2019-04-09 10:50:49',1,888001,130,0,130),(3180023,3,'2019-04-19 11:56:59','2019-04-19 17:00:12',3,888001,25,10,50),(3180024,1,'2019-04-19 22:17:12','2019-04-19 22:17:58',1,888001,10,0,10),(3180025,1,'2019-04-20 01:31:26','2019-05-26 22:21:42',1,888001,510,7080,-6570),(3180026,2,'2019-04-20 02:31:36','2019-05-26 22:14:35',2,888001,553,4420,-3867),(3180027,3,'2019-04-20 03:31:52','2019-05-26 16:01:13',3,888001,530,4385,-3855),(3180028,4,'2019-04-20 04:32:05','2019-05-26 15:57:38',4,888001,540,2628,-2088),(3180029,1,'2019-05-27 05:25:21',NULL,1,888001,1000,NULL,NULL),(3180030,2,'2019-05-27 07:33:46',NULL,2,888001,120,NULL,NULL),(3180031,5,'2019-05-27 10:19:42',NULL,5,888001,50,0,50);
/*!40000 ALTER TABLE `intuserec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `machine`
--

DROP TABLE IF EXISTS `machine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `machine` (
  `MachineID` int(11) NOT NULL,
  `Area` varchar(20) DEFAULT NULL,
  `Price` int(11) DEFAULT NULL,
  `MachineState` int(1) DEFAULT '0',
  PRIMARY KEY (`MachineID`),
  KEY `MachineID` (`MachineID`),
  KEY `MachineID_2` (`MachineID`),
  KEY `MachineID_3` (`MachineID`),
  KEY `MachineID_4` (`MachineID`),
  KEY `MachineID_5` (`MachineID`),
  KEY `MachineID_6` (`MachineID`),
  KEY `MachineID_7` (`MachineID`),
  KEY `MachineID_8` (`MachineID`),
  KEY `MachineID_9` (`MachineID`),
  KEY `MachineID_10` (`MachineID`),
  KEY `MachineID_11` (`MachineID`),
  KEY `MachineID_12` (`MachineID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='机器信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `machine`
--

LOCK TABLES `machine` WRITE;
/*!40000 ALTER TABLE `machine` DISABLE KEYS */;
INSERT INTO `machine` VALUES (1,'极致电竞区',8,0),(2,'疯狂幻想区',5,0),(3,'疯狂幻想区',5,0),(4,'娱乐休闲区',3,0),(5,'娱乐休闲区',3,1),(6,'极致电竞区',8,0),(7,'疯狂幻想区',5,1),(8,'疯狂幻想区',5,0),(9,'娱乐休闲区',3,0),(10,'娱乐休闲区',3,0),(13,'娱乐休闲区',3,0),(14,'疯狂幻想区',14,0);
/*!40000 ALTER TABLE `machine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mebaddrec`
--

DROP TABLE IF EXISTS `mebaddrec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `mebaddrec` (
  `AddRecordID` int(11) NOT NULL AUTO_INCREMENT COMMENT '充值记录编号',
  `AddTime` datetime DEFAULT NULL COMMENT '充值时间',
  `MemberID` int(11) DEFAULT NULL COMMENT '会员卡号',
  `AddMoney` int(11) DEFAULT NULL COMMENT '充值额度',
  `AdminID` int(11) DEFAULT NULL COMMENT '管理员编号',
  PRIMARY KEY (`AddRecordID`),
  KEY `FK_Reference_11` (`AdminID`),
  KEY `FK_Reference_12` (`MemberID`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`AdminID`) REFERENCES `admin` (`adminid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`MemberID`) REFERENCES `mebmst` (`memberid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=19527002 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='会员充值记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mebaddrec`
--

LOCK TABLES `mebaddrec` WRITE;
/*!40000 ALTER TABLE `mebaddrec` DISABLE KEYS */;
INSERT INTO `mebaddrec` VALUES (19527001,'2019-05-17 23:22:17',20150306,60,888666);
/*!40000 ALTER TABLE `mebaddrec` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mebdtl`
--

DROP TABLE IF EXISTS `mebdtl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `mebdtl` (
  `MemberID` int(11) DEFAULT NULL,
  `MemberIdentityID` varchar(18) DEFAULT NULL,
  `MemberAge` int(11) DEFAULT NULL,
  `AdminID` int(11) DEFAULT NULL,
  `MemberDate` date DEFAULT NULL,
  `LastUse` datetime DEFAULT NULL,
  KEY `FK_Reference_1` (`MemberID`),
  KEY `FK_Reference_2` (`AdminID`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`MemberID`) REFERENCES `mebmst` (`memberid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`AdminID`) REFERENCES `admin` (`adminid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='会员详细表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mebdtl`
--

LOCK TABLES `mebdtl` WRITE;
/*!40000 ALTER TABLE `mebdtl` DISABLE KEYS */;
INSERT INTO `mebdtl` VALUES (20150307,'3713261997',22,888666,'2019-03-18','2019-05-26 19:37:40'),(20150308,'3713261996',23,888001,'2019-03-19','2019-05-26 19:37:16'),(20150306,'3713261997',22,888666,'2019-03-15','2019-05-26 19:30:12'),(20150309,'3713261997',22,888002,'2019-03-20',NULL),(20150310,'370811',22,888001,'2019-03-22',NULL);
/*!40000 ALTER TABLE `mebdtl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mebmst`
--

DROP TABLE IF EXISTS `mebmst`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `mebmst` (
  `MemberID` int(11) NOT NULL,
  `MemberPass` varchar(50) DEFAULT NULL,
  `MemberName` varchar(50) DEFAULT NULL,
  `MemberState` int(50) DEFAULT '0',
  `MemberAccount` int(11) DEFAULT NULL,
  PRIMARY KEY (`MemberID`),
  KEY `MemberID` (`MemberID`),
  KEY `MemberID_2` (`MemberID`),
  KEY `MemberID_3` (`MemberID`),
  KEY `MemberID_4` (`MemberID`),
  KEY `MemberID_5` (`MemberID`),
  KEY `MemberID_6` (`MemberID`),
  KEY `MemberID_7` (`MemberID`),
  KEY `MemberID_8` (`MemberID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='会员主表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mebmst`
--

LOCK TABLES `mebmst` WRITE;
/*!40000 ALTER TABLE `mebmst` DISABLE KEYS */;
INSERT INTO `mebmst` VALUES (20150306,'123456','孙俊杰',0,600),(20150307,'123456','刘沅沅',1,700),(20150308,'123456','王振',0,800),(20150309,'123456','崔传年',0,900),(20150310,'123456','杨坤',0,1000);
/*!40000 ALTER TABLE `mebmst` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mebuserec`
--

DROP TABLE IF EXISTS `mebuserec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `mebuserec` (
  `UseRecordID` int(20) NOT NULL AUTO_INCREMENT COMMENT '上机记录编号',
  `MachineID` int(11) DEFAULT NULL COMMENT '机器编号',
  `StartTime` datetime DEFAULT NULL COMMENT '开始时间',
  `EndTime` datetime DEFAULT NULL COMMENT '结束时间',
  `MemberID` int(11) DEFAULT NULL COMMENT '会员卡号',
  `MemberName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '会员姓名',
  `AdminID` int(11) DEFAULT NULL COMMENT '管理员编号',
  `AddMoney` int(11) DEFAULT NULL COMMENT '充值',
  `Consumption` int(11) DEFAULT NULL COMMENT '消费',
  `Remains` int(11) DEFAULT NULL COMMENT '余额',
  PRIMARY KEY (`UseRecordID`),
  KEY `FK_Reference_3` (`MachineID`),
  KEY `FK_Reference_4` (`MemberID`),
  KEY `FK_Reference_5` (`AdminID`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`MachineID`) REFERENCES `machine` (`machineid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`MemberID`) REFERENCES `mebmst` (`memberid`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`AdminID`) REFERENCES `admin` (`adminid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=318030 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='会员上机记录表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mebuserec`
--

LOCK TABLES `mebuserec` WRITE;
/*!40000 ALTER TABLE `mebuserec` DISABLE KEYS */;
INSERT INTO `mebuserec` VALUES (318001,1,'2019-03-18 00:00:00','2019-03-28 15:44:04',20150307,'JJ',888666,500,NULL,NULL),(318003,10,'2019-03-20 00:00:00','2019-03-28 15:44:09',20150307,NULL,888001,700,NULL,NULL),(318004,10,'2019-03-20 00:00:00','2019-03-28 15:44:14',20150307,NULL,888001,70,NULL,NULL),(318005,10,'2019-03-28 00:00:00','2019-03-28 15:52:27',20150307,NULL,888001,1000,NULL,NULL),(318008,4,'2019-03-20 00:00:00','2019-03-28 15:44:52',20150307,NULL,888001,44,NULL,NULL),(318010,4,'2019-03-20 00:00:00','2019-03-28 15:44:56',20150307,NULL,888001,4,NULL,NULL),(318011,4,'2019-03-20 00:00:00','2019-03-28 15:45:00',20150307,NULL,888001,4,NULL,NULL),(318012,4,'2019-03-20 00:00:00','2019-03-28 15:45:04',20150307,NULL,888001,4,NULL,NULL),(318013,5,'2019-03-20 00:00:00','2019-03-28 15:45:58',20150307,NULL,888001,5,NULL,NULL),(318014,5,'2019-03-20 00:00:00','2019-03-28 15:46:02',20150307,NULL,888001,55,NULL,NULL),(318015,10,'2019-03-28 15:00:00','2019-04-19 16:59:34',20150306,NULL,888001,1000,1060,0),(318016,9,'2019-03-28 16:00:00','2019-04-19 16:58:01',20150307,NULL,888001,1000,2,97),(318018,7,'2019-03-28 14:00:00','2019-04-19 17:16:14',20150309,NULL,888002,1000,2128,-1031),(318019,8,'2019-03-28 13:00:00','2019-04-19 17:20:04',20150308,NULL,888001,1000,2132,-1082),(318022,13,'2019-04-09 19:42:02','2019-04-19 16:46:07',20150308,'王振',888001,100,2,597),(318023,13,'2019-04-19 16:28:04','2019-04-19 16:46:07',20150309,'崔传年',888001,500,2,597),(318024,9,'2019-04-19 16:40:26','2019-04-19 16:58:01',20150309,'崔传年',888001,9,2,97),(318025,6,'2019-04-20 06:33:08','2019-05-26 19:30:12',20150306,'孙俊杰',888001,336,5262,-9900),(318026,7,'2019-04-20 07:37:47','2019-05-26 19:37:40',20150307,'刘沅沅',888001,7,3504,-2797),(318027,8,'2019-04-20 08:40:51','2019-05-26 19:37:16',20150308,'王振',888001,8,3500,-9668),(318028,6,'2019-05-27 06:27:24',NULL,20150306,'孙俊杰',888001,0,NULL,NULL),(318029,7,'2019-05-27 07:51:08',NULL,20150307,'刘沅沅',888001,0,0,700);
/*!40000 ALTER TABLE `mebuserec` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-20 13:47:13
