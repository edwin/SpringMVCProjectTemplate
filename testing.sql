/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;


CREATE DATABASE `testing` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `testing`;
CREATE TABLE `dosen` (
  `nik` varchar(20) NOT NULL DEFAULT '',
  `nama` varchar(255) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`nik`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `kuliah` (
  `id` int(11) NOT NULL,
  `namamatakuliah` varchar(20) DEFAULT NULL,
  `nik` varchar(20) DEFAULT NULL,
  `nim` varchar(20) DEFAULT NULL,
  KEY `nik` (`nik`),
  KEY `nim` (`nim`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
CREATE TABLE `mahasiswa` (
  `nim` varchar(20) NOT NULL DEFAULT '',
  `nama` varchar(255) DEFAULT NULL,
  `tgllahir` date DEFAULT NULL,
  PRIMARY KEY (`nim`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `kuliah`
  ADD CONSTRAINT `nik` FOREIGN KEY (`nik`) REFERENCES `dosen` (`nik`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `nim` FOREIGN KEY (`nim`) REFERENCES `mahasiswa` (`nim`) ON DELETE CASCADE ON UPDATE CASCADE
;


/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
