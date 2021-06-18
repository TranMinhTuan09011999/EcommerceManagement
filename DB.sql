-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: commerce_manager
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
-- Table structure for table `addcart`
--

DROP TABLE IF EXISTS `addcart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `addcart` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(10) NOT NULL,
  `quantity` bigint(10) NOT NULL,
  `price` double NOT NULL,
  `user_id` bigint(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addcart`
--

LOCK TABLES `addcart` WRITE;
/*!40000 ALTER TABLE `addcart` DISABLE KEYS */;
INSERT INTO `addcart` VALUES (19,20,4,121,3),(20,17,4,135,3),(25,18,2,143,3),(30,14,1,125,3),(31,11,1,131,3),(32,13,1,124,3),(33,21,1,125,3),(43,17,1,135,4),(46,11,1,131,4),(48,16,1,135,3),(49,19,1,115,3);
/*!40000 ALTER TABLE `addcart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `category` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `categoryname` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'LAPTOP'),(2,'SMARTPHONE');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imagedetail`
--

DROP TABLE IF EXISTS `imagedetail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `imagedetail` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `imageid` bigint(10) NOT NULL,
  `image` varchar(300) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imagedetail`
--

LOCK TABLES `imagedetail` WRITE;
/*!40000 ALTER TABLE `imagedetail` DISABLE KEYS */;
INSERT INTO `imagedetail` VALUES (1,11,'https://images.anandtech.com/doci/14827/Blade-15-[2019-2]-Base-Model-Render-(04-2)_678x452.jpg'),(2,11,'https://lapvip.vn/upload/products/original/razer-blade-15-base-edition-model-2020-1602757941.jpg'),(3,11,'https://lapvip.vn/upload/products/original/razer-blade-15-base-edition-model-2020-1602757941.jpg'),(4,12,'https://cdn.ankhang.vn/media/product/18978_18978_laptop_msi_ge66_raider_10ug_205vn_1.jpg'),(5,12,'https://techzones.vn/Data/Sites/1/Product/24995/techzones-msi-ge66-raider-10sf-2.png'),(6,12,'https://owlgaming.vn/wp-content/uploads/2020/05/MSI-GE66-Raider-3-600x600.jpg'),(7,13,'https://img.websosanh.vn/v2/users/root_product/images/laptop-msi-gf65-thin/2d8eln84ngc1p.jpg'),(8,13,'https://xgear.vn/wp-content/uploads/2018/08/GF63_8RD_5.jpg'),(9,13,'https://laptop88.vn/media/product/5211_msi_gf65_thin_10ser_622vn_3.jpg'),(10,14,'https://tinhocngoisao.com/wp-content/uploads/2020/08/AS_A15-FA506IV-HN202T-3.jpg'),(11,14,'https://laptop123.com.vn/upload/product/asus-tuf-a15-fa506iv-hn202t.png'),(12,14,'https://timhangcongnghe.com/uploads/erp/products/product_image/image_url/112822/thumb650_Asus_TUF_Gaming_A15_FA506_1.jpg'),(13,15,'https://cdn.ankhang.vn/media/product/19044_laptop_msi_gf63_thin_9scsr_1057vn_1.jpg'),(14,15,'https://tinhocngoisao.cdn.vccloud.vn/wp-content/uploads/2020/10/MSI_GF63-Thin-9SCSR-1057VN-2.jpg'),(15,15,'https://salt.tikicdn.com/ts/product/d5/b9/83/b2d18422ce36bcc9cd49425a3e4336ce.jpg'),(16,16,'https://xgear.vn/wp-content/uploads/2020/10/stealth-15m-2.jpg'),(17,16,'https://xgear.vn/wp-content/uploads/2020/10/stealth-15m-5.jpg'),(18,16,'https://laptop88.vn/media/product/5812_msi_stealth_15m_a11sdk_061vn_i7_1185g7_1_d7e6903b66da4c879564b737c23a88bc_master.png'),(19,17,'https://anphat.com.vn/media/product/31562_screenshot_1.png'),(20,17,'https://laptop88.vn/media/product/5027_thinkpad_p1_gen_2__2_.png'),(21,17,'https://anphat.com.vn/media/product/31562_lenovo_laptop_thinkpad_p1_2nd_04.jpg'),(22,18,'https://laptopvang.vn/wp-content/uploads/2021/02/lenovo_thinkpad_p17_laptopvang-4.jpg'),(23,18,'https://m.media-amazon.com/images/I/61SW8CHnSDL._AC_SL1500_.jpg'),(24,18,'https://admin.thinkpro.vn/files/Lenovo-ThinkPad-P17/Lenovo-ThinkPad-P17-5.jpg'),(25,19,'https://laptopworld.vn/media/product/7809_asus_vivobook_15_m513ia_5.jpg'),(26,19,'https://laptop123.com.vn/upload/product/asus-m513ia-ej282t.png'),(27,19,'https://cellphones.com.vn/media/catalog/product/l/a/laptop-asus-vivobook-15-m513ia-ryzen-7.jpg'),(28,20,'https://lumen.thinkpro.vn//backend/uploads/product/color_images/2020/7/18/lenovo-thinkpad-t14s-ThinkpadT14s01NS-wAy.jpg'),(29,20,'https://ben.com.vn/Content/Images/Products/182928.png'),(30,20,'https://laptop123.com.vn/upload/product/lenovo-thinkpad-t14s-gen-1-core-i7.png');
/*!40000 ALTER TABLE `imagedetail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderdetails`
--

DROP TABLE IF EXISTS `orderdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orderdetails` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(10) NOT NULL,
  `product_id` bigint(10) NOT NULL,
  `quantity` int(5) NOT NULL,
  `amount` double NOT NULL,
  `discount` int(2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `orderdetails_ibfk_1` (`order_id`),
  KEY `orderdetails_ibfk_2` (`product_id`),
  CONSTRAINT `orderdetails_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `orderdetails_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderdetails`
--

LOCK TABLES `orderdetails` WRITE;
/*!40000 ALTER TABLE `orderdetails` DISABLE KEYS */;
INSERT INTO `orderdetails` VALUES (10,6,12,3,2560000,5),(11,6,13,15,1205500,0),(12,6,14,1,125,10),(13,7,20,1,121,10),(14,7,17,1,135,10),(15,8,17,1,135,10),(16,8,11,1,131,5),(17,12,18,1,143,5),(18,14,18,1,143,5),(19,14,19,1,115,10),(20,15,18,1,143,5);
/*!40000 ALTER TABLE `orderdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `orders` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `order_date` date NOT NULL,
  `amount` double NOT NULL,
  `receiver` varchar(300) NOT NULL,
  `address` varchar(300) NOT NULL,
  `phone_number` char(10) NOT NULL,
  `user_id` bigint(10) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `orders_ibfk_1` (`user_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (6,'2018-05-05',154,'MinhTuan','QuangNgai','0378951254',3,1),(7,'2018-05-05',154,'MinhTuan','QuangNgai','0378951254',3,1),(8,'2018-05-05',154,'MinhTuan','QuangNgai','0378951254',3,1),(9,'2018-05-05',154,'MinhTuan','QuangNgai','0378951254',3,1),(10,'2018-05-05',154,'MinhTuan','QuangNgai','0378951254',3,1),(11,'2018-05-05',154,'MinhTuan','QuangNgai','0378951254',3,1),(12,'2021-06-03',143,'Hâu','NhaTrang','0544789562',3,1),(13,'2018-05-05',154,'MinhTuan','QuangNgai','0378951254',3,1),(14,'2021-06-03',258,'AnhQuoc','PhuYen','054862594',3,1),(15,'2021-06-15',143,'Minh Nguyen','QN','0344875325',4,1);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `product` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `price` float NOT NULL,
  `description` varchar(500) NOT NULL,
  `image` varchar(200) NOT NULL,
  `promotion` int(11) NOT NULL,
  `deletestatus` int(11) NOT NULL,
  `category_id` bigint(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `product_ibfk_1` (`category_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (11,'Razer 15 Base 2019 1660Ti',131,'CPU: Core i7 9750H \r RAM: 16G DDR4 2666MHz\r SSD: 256GB NVMe\r VGA: NVidia GTX 1660Ti 6GB gDDR6\r Màn hình 15.6 Inch FHD IPS 144Hz\r Windows 10 Home','https://images-na.ssl-images-amazon.com/images/I/81%2Bl7hSFLYL.jpg',5,1,1),(12,'MSI GE66 Raider',145,'CPU: Core i7 10750H \r\nRAM: 32GB DDR4\r\nSSD: 1TB\r\nVGA: RTX 2070 Super\r\nMàn hình 15.6\" FHD IPS 240Hz\r\nWindows 10','https://ben.com.vn/Content/Images/Products/185739..png',5,1,1),(13,'MSI GF65 Thin 2020',124,'CPU: Core i7 10750H \r\nRAM: 8GB DDR4\r\nSSD: 512GB\r\nVGA: GTX 1660Ti\r\nMàn hình 15.6\" FHD IPS 120Hz\r\nWindows 10\r\nBảo hành 1 tháng','https://lumen.thinkpro.vn//backend/uploads/product/color_images/2020/9/24/msi-gf65-01.jpg',0,1,1),(14,'Asus TUF A15 FA506IV',125,'CPU: AMD Ryzen 7 4800H\r\nRAM: 8GB 3200MHz\r\nSSD:  512GB\r\nVGA: NVidia RTX 2060\r\nMàn hình 15,6 Inch FHD IPS 60Hz\r\nWindows 10 Home','https://laptopaz.vn/media/product/1901_6408464_sd.jpg',10,1,1),(15,'MSI Gaming GF63 GF63 THIN 9SCSR-1057VN',120,'CPU : Intel Core i5-9300H 2.4GHz up to 4.1GHz 8MB\r\nRAM : 8GB\r\nCard : NVIDIA GeForce GTX 1650Ti 4GB GDDR6 with Max-Q Design + Intel UHD Graphics 630\r\nỔ Cứng : 512GB SSD M.2 PCIE, x1 slot 2.5\" SATA3\r\nWindows 10 Home SL','https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/9df78eab33525d08d6e5fb8d27136e95/6/3/637344707988159619_msi-gf63-9scsr-den-1.png',0,1,1),(16,'MSI Stealth 15M A11SDK 060VN',135,'CPU Intel Core i7-1185G7 3.0GHz up to 4.8GHz 12MB\r\nRAM	16GB (8GBx2) DDR4 3200MHz (2x SO-DIMM socket, up to 64GB SDRAM)\r\nỔ cứng	512GB SSD PCIE G3X4\r\nCard đồ họa	NVIDIA GeForce GTX 1660Ti 6GB GDDR6\r\nMàn hình	15.6\" FHD (1920*1080), IPS-Level 144Hz 45%NTSC Thin Bezel','https://product.hstatic.net/1000026716/product/1_3cd1c2a4c64e4121b976b8e3555eba84.jpg',0,1,1),(17,'THINKPAD P1 GEN 2',135,'CPU : Intel® Core™ Processor i7-9750H (6 Core, 12M Cache, 2.60GHz up to 4.5GHz Turbo, 45W, vPro)\r\nRAM : 16GB DDR4-2666MHz\r\nỔ cứng : 256 GB M2 PCIe ( up to 2Tb )\r\nVGA : NVIDIA® Quadro® T1000 4GB\r\nMàn hình : 15.6\" FHD (1920 x 1080) IPS 300 nits, anti-glare\r\nKết nối : Intel® AX200 Wi-Fi 6 802.11AX (2 x 2) & Bluetooth® 5.0\r\nHĐH : Windows 10 Pro 64\r\nPin/adapter4 Cell 80Wh internal battery / 135w','https://s4.nhattao.com/data/attachment-files/2020/06/15135087_lenovo-laptop-thinkpad-p1-2nd-01.jpg',10,1,1),(18,'THINKPAD P17',143,'CPUI : ntel® Core™ i7-10750H Processor (2.60 GHz, up to 5.00 GHz with Turbo Boost, 6 Cores, 12 Threads, 12 MB Cache)\r\nRAM : 16GB DDR4 2933MHz ( up to 64Gb )\r\nỔ cứng : 512 GB M2 Pcie\r\nVGA : NVIDIA® Quadro® T2000 4GB\r\nMàn hình : 17.3\" FHD (1920 x 1080) IPS, anti-glare, 300 nits\r\nKết nối : Intel® Wi-Fi 6™ AX201 802.11AX (2 x 2) & Bluetooth® 5.1\r\nHĐH : Windows 10 Pro 64\r\nPin : 6 Cell 94Whr internal battery','https://laptopg7.vn/images/detailed/101/Thinkpad-P17-01-1602908797.jpg',5,1,1),(19,'Asus Vivobook 15 M513IA-EJ282T',115,'CPU:Ryzen R5-4500U (2.3GHz upto 4.0GHz, 6 Cores, 6 Threads, 8MB cache)\r\nMàu sắc:Silver\r\nTình Trạng Máy :Mới 100%\r\nXuất xứ:Chính Hãng\r\nRAM:Ram 8GB DDR4 Buss 3200 Onbo\r\nỔ cứng:	512GB PCIe NVMe M.2 SSD\r\nMàn hình:15.6 inch LED Backlit Full HD (1920 x 1080) Anti-Glare NTSC 45%, 200 nits\r\nVGA/GPU:AMD Radeon Vega 6 Graphics','https://laptop123.com.vn/upload/product/-m513ia-ej282t.png',10,1,1),(20,'ThinkPad T14s',121,'CPU: 10th Gen Intel® Core™ i5 10210U Processor (6MB Cache, up to 4.2GHz)\r\nRAM: 8GB DDR4 2666 MHz\r\nĐĩa cứng: 256GB M.2 PCIe NVMe Solid State Drive (M.2 SSD)\r\nMàn hình: 14\" FHD (1920 x 1080), IPS, anti-glare, 250nits\r\nCard đồ họa: Intel UHD Graphics','https://laptopvang.vn/wp-content/uploads/2020/08/thinkpad_t14_2020_laptopvang-5.jpg',10,1,1),(21,'ThinkPad T14s12',125,'Apple','https://laptopvang.vn/wp-content/uploads/2020/08/thinkpad_t14_2020_laptopvang-5.jpg',12,1,2);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `roles` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (2,'ROLE_ADMIN'),(1,'ROLE_USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user_roles` (
  `user_id` bigint(10) NOT NULL,
  `role_id` bigint(10) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `fk_roleid` (`role_id`),
  CONSTRAINT `fk_roleid` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`),
  CONSTRAINT `fk_userid` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (2,1),(3,1),(4,1),(5,1),(8,1),(9,1),(6,2),(7,2);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `id` bigint(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `phone` char(10) NOT NULL,
  `address` varchar(45) NOT NULL,
  `firstname` varchar(100) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (2,'minhtuan','minhtuan@gmail.com','0377730290','QuangNgai','Tuan','Tran','$2a$10$roGCUlq3zF3.mjNqcsW/jeKSSm3qRGH5yQeSBuxl7O/IgBlttYWEy'),(3,'minhtuan1','minhtuan1@gmail.com','$2a$10$/w/SWE8dgp5Oin0weDELdOZbHK5wtdNbuMWmJh3.NcY6VNkeDRoEq','0377730290','QuangNgai','Tuan','Tran'),(4,'minhtuan2','minhtuan2@gmail.com','$2a$10$GVk2LbDouPa.40GV/BUNeu8ixQT4gghf1iDnK396Nc06rUBknJ4qK','0364578650','QuangNam','Tuan','Tran'),(5,'minhtuan3','minhtuan3@gmail.com','$2a$10$KGsYOaKmoYBJCMBYfPGlEut0xykSCciS2O6oHGQU320Pry1pCjoji','0654892568','DaNang','Nguyen','Minh'),(6,'admin','duytan@gmail.com','$2a$10$vdS2oU0gai1FOGVWoYhuoOPxWoNnDDQBKu/pt5wowAt6nhuxTWgSy','01254568','Ben Tre','Tan','Tran'),(7,'minhtuan7','minhtuan7@gmail.com','$2a$10$oqiqeG4kRgVCcr8ZPAbBD.f1t6jnAkZq8GhsF8.t8Gx4Q/.tpV4Ie','0934726678','QN','Tuan','Tran'),(8,'minhtuan8','minhtuan8@gmail.com','$2a$10$SaAFCsNnEZMREZQq53v.9euRr7OtH0OD9vTlBOm1M9biTC8XQlaFy','0377730290','DN','Tuan','Minh'),(9,'minhtuan9','minhtuan9@gmail.com','$2a$10$ODVGL.oc3/ek/qfK0LLhmeD7K.X251hW8s3kayCou8jRBei5iT6eW','0394875615','TN','Tuan','Tran');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'commerce_manager'
--

--
-- Dumping routines for database 'commerce_manager'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-18  8:59:44
