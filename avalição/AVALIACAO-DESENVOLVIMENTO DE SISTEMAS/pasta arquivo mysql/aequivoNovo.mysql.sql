-- MySQL dump 10.13  Distrib 8.0.32, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: loja
-- ------------------------------------------------------
-- Server version	8.0.34-0ubuntu0.22.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Clientes`
--

DROP TABLE IF EXISTS `Clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Clientes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `endereco` varchar(50) DEFAULT NULL,
  `cpf` varchar(14) DEFAULT NULL,
  `sexo` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Clientes`
--

LOCK TABLES `Clientes` WRITE;
/*!40000 ALTER TABLE `Clientes` DISABLE KEYS */;
INSERT INTO `Clientes` VALUES (6,'amanda','kakakkaka','78965412369','f');
/*!40000 ALTER TABLE `Clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Itens`
--

DROP TABLE IF EXISTS `Itens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Itens` (
  `id` int NOT NULL AUTO_INCREMENT,
  `material` varchar(20) DEFAULT NULL,
  `valor` decimal(5,2) DEFAULT NULL,
  `id_Pedidos` int DEFAULT NULL,
  `id_Produtos` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Pedidos_fk` (`id_Pedidos`),
  KEY `Produtos_fk` (`id_Produtos`),
  CONSTRAINT `Pedidos_fk` FOREIGN KEY (`id_Pedidos`) REFERENCES `Pedidos` (`id`),
  CONSTRAINT `Produtos_fk` FOREIGN KEY (`id_Produtos`) REFERENCES `Produtos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Itens`
--

LOCK TABLES `Itens` WRITE;
/*!40000 ALTER TABLE `Itens` DISABLE KEYS */;
INSERT INTO `Itens` VALUES (1,'Boneca da Barbie',100.00,4,1),(2,'Carrinho Hot Wheels',50.00,4,2),(3,'dsfsf',3.00,4,4),(4,'fgfgdgffg',6.00,4,5),(5,'Boneca da Barbie',100.00,5,1),(6,'Carrinho Hot Wheels',50.00,6,2),(7,'Carrinho Hot Wheels',50.00,7,2),(8,'fgfgdgffg',6.00,8,5),(9,'dsfsf',3.00,9,4),(10,'Carrinho Hot Wheels',50.00,10,2);
/*!40000 ALTER TABLE `Itens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Pedidos`
--

DROP TABLE IF EXISTS `Pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Pedidos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `valor_total` decimal(6,2) DEFAULT NULL,
  `status_pedido` varchar(20) DEFAULT NULL,
  `data_venda` date DEFAULT NULL,
  `data_entrega` date DEFAULT NULL,
  `id_Clientes` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Clientes_fk` (`id_Clientes`),
  CONSTRAINT `Clientes_fk` FOREIGN KEY (`id_Clientes`) REFERENCES `Clientes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Pedidos`
--

LOCK TABLES `Pedidos` WRITE;
/*!40000 ALTER TABLE `Pedidos` DISABLE KEYS */;
INSERT INTO `Pedidos` VALUES (3,159.00,'PENDENTE','2023-10-04','2023-10-07',6),(4,159.00,'PENDENTE','2023-10-04','2023-10-07',6),(5,100.00,'PENDENTE','2023-10-04','2023-10-07',6),(6,50.00,'PENDENTE','2023-10-04','2023-10-07',6),(7,50.00,'PENDENTE','2023-10-04','2023-10-07',6),(8,6.00,'PENDENTE','2023-10-04','2023-10-07',6),(9,3.00,'PENDENTE','2023-10-04','2023-10-07',6),(10,50.00,'PENDENTE','2023-10-05','2023-10-08',6);
/*!40000 ALTER TABLE `Pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Produtos`
--

DROP TABLE IF EXISTS `Produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Produtos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `descricao` varchar(20) DEFAULT NULL,
  `valor` decimal(5,2) DEFAULT NULL,
  `quantidade_estoque` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Produtos`
--

LOCK TABLES `Produtos` WRITE;
/*!40000 ALTER TABLE `Produtos` DISABLE KEYS */;
INSERT INTO `Produtos` VALUES (1,'Boneca','Boneca da Barbie',100.00,10),(2,'Carrinho','Carrinho Hot Wheels',50.00,15),(4,'fsdfsdf','dsfsf',3.00,20),(5,'ddsdfdsdfd','fgfgdgffg',6.00,3);
/*!40000 ALTER TABLE `Produtos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-05 16:22:49
