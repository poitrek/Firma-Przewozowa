/*
*********************************************************************
Based on the script from http://www.mysqltutorial.org
*********************************************************************
Name: MySQL-owa baza danych dla firmy transportowej
Link: --
Version 1.0
Author: Maja Kurcius, majakur297@student.polsl.pl
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=``*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE=`NO_AUTO_VALUE_ON_ZERO` */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`firma` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE `utf8_unicode_ci`*/;

USE `firma`;

/*---------------------------------------------------------------------------------------------------------------------*/

/*Table structure for table `klienci` */

DROP TABLE IF EXISTS `klienci`;

CREATE TABLE `klienci` (
  `id_klienta` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `imie` VARCHAR(20) NOT NULL,
  `nazwisko` VARCHAR(20) NOT NULL,
  `nr_tel` VARCHAR(20) NOT NULL,
  `haslo` VARCHAR(20) NOT NULL,
  UNIQUE KEY unique_tel(nr_tel)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `klienci` */
/* inserting clients with indices: */
insert  into `klienci`(`id_klienta`,`imie`,`nazwisko`,`nr_tel`,`haslo`) values 

(1,'Jan','Kos', '111111111','janek'),
(2,'Nel','Rawlison','222222222','nel'),
(3,'Ahab','Kapitan','333333333','ahab'),
(4,'Obelix','Gal','444444444','obelix'),
(5,'Papcio','Chmiel','555555555','papcio'),
(6,'Aleksander','Wielki','666666666','aleksander')
;

/*---------------------------------------------------------------------------------------------------------------------*/

/*Table structure for table `rezerwacje` */

DROP TABLE IF EXISTS `rezerwacje`;

CREATE TABLE `rezerwacje` (
  `id_rezerwacji` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `id_klienta` INT NOT NULL,
  `id_przewozu` INT NOT NULL,
  `liczba_zarezerw_miejsc` INT NOT NULL,
  `cena_calkowita` DECIMAL(5,2) DEFAULT 0.00,
  FOREIGN KEY fk_klient(id_klienta)
  REFERENCES klienci(id_klienta),
  FOREIGN KEY fk_przewoz(id_przewozu)
  REFERENCES przewozy(id_przewozu)
  ON UPDATE CASCADE
  ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `rezerwacje` */

/* inserting reservations: */
insert  into `rezerwacje`(`id_rezerwacji`,`id_klienta`,`id_przewozu`,`liczba_zarezerw_miejsc`,`cena_calkowita`) values 
(1, 1, 1, 2, 40.00); 

/* inserting reservations without indices and total cost: */
insert  into `rezerwacje`(`id_klienta`,`id_przewozu`, `liczba_zarezerw_miejsc`) values 
(2, 2, 3);


/*---------------------------------------------------------------------------------------------------------------------*/

/*Table structure for table `trasy` */

DROP TABLE IF EXISTS `trasy`;

CREATE TABLE `trasy` (
  `id_trasy` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `stacja_poczatkowa` VARCHAR(50) NOT NULL,
  `stacja_koncowa` VARCHAR(50) NOT NULL,
  `dlugosc_trasy` DECIMAL(7,2) DEFAULT 0.00,
  `cena_biletu` DECIMAL(5,2) DEFAULT 0.00
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `trasy` */

/* inserting rides with indices and total cost: */
insert  into `trasy`(`id_trasy`,`stacja_poczatkowa`,`stacja_koncowa`,`dlugosc_trasy`,`cena_biletu`) values 
(1, 'KATOWICE', 'KRAKÓW', 20, 10); 

/* inserting rides without indices, length and ticket price: */
insert  into `trasy`(`stacja_poczatkowa`,`stacja_koncowa`) values 
('KATOWICE', 'WARSZAWA');


/*---------------------------------------------------------------------------------------------------------------------*/

/*Table structure for table `przewozy` */

DROP TABLE IF EXISTS `przewozy`;

CREATE TABLE `przewozy` (
  `id_przewozu` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `id_trasy` INT NOT NULL,
  `data` DATE NOT NULL DEFAULT '2019-01-01',
  `godzina` TIME NOT NULL DEFAULT '08:00:00',
  `id_autobusu` INT NOT NULL,
  `liczba_wolnych_miejsc` INT NOT NULL DEFAULT 50,
  FOREIGN KEY fk_trasa(id_trasy)
  REFERENCES trasy(id_trasy)
  ON UPDATE CASCADE
  ON DELETE RESTRICT,
  FOREIGN KEY fk_autobus(id_autobusu)
  REFERENCES autobusy(id_autobusu)
  ON UPDATE CASCADE
  ON DELETE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `przewozy` */

/* inserting rides with indices and total cost: */
insert  into `przewozy`(`id_przewozu`,`id_trasy`,`data`,`godzina`,`id_autobusu`,`liczba_wolnych_miejsc`) values 
(1, 1, '2019-06-30', '09:00:00', 1, 50); 

/* inserting rides without indices, date, time and seats left: */
insert  into `przewozy`(`id_trasy`,`id_autobusu`) values 
(2, 2);

/*---------------------------------------------------------------------------------------------------------------------*/

/*Table structure for table `autobusy` */

DROP TABLE IF EXISTS `autobusy`;

CREATE TABLE `autobusy` (
  `id_autobusu` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  `nr_rejestracyjny` VARCHAR(16) NOT NULL,
  `liczba_miejsc` INT NOT NULL DEFAULT 50,
  UNIQUE KEY unique_nr_rej(nr_rejestracyjny)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `autobusy` */

/* inserting buses with indices: */
insert  into `autobusy`(`id_autobusu`,`nr_rejestracyjny`,`liczba_miejsc`) values 
(1, 'SGL1111', 45),
(2, 'SK22222', 38); 

/* inserting buses without indices and number of seats: */
insert  into `autobusy`(`nr_rejestracyjny`) values 
('ST33333'),
('SZA4444');

/*---------------------------------------------------------------------------------------------------------------------*/

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
