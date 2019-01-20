
--
-- Table structure for table `product`
--
DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--
LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES 
	(1,'MARSHALL KILBURN NOIR','L''enceinte Bluetooth Marshall Kilburn est l''enceinte nomade Rock n Roll par d�finition !',179.00),
	(2,'Philips HD7866/61','Philips SENSEO Quadrante, Noir - 1 ou 2 tasses',79.99),
	(3,'TV Samsung UE49MU6292','Smart TV LED incurv�e 49 pouces',599.00),
	(4,'BEKO TSE 1042 F','R�frig�rateur BEKO 130L - Classe A+ - blanc',189.00),
	(5,'SAMSUNG RZ32M7000WW/EF','Le cong�lateur Samsung RZ32M7000WW/EF blanc est dot� du froid ventil� qui assure une temp�rature constante',649.00);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;