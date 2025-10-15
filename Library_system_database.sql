/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.5-10.1.21-MariaDB : Database - library_system
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`library_system` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `library_system`;

/*Table structure for table `book` */

DROP TABLE IF EXISTS `book`;

CREATE TABLE `book` (
  `employee_id` int(10) DEFAULT NULL,
  `book_id` int(10) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(50) DEFAULT NULL,
  `book_category` varchar(50) DEFAULT NULL,
  `language` varchar(50) DEFAULT NULL,
  `author_editor` varchar(50) DEFAULT NULL,
  `editor_volume` varchar(50) DEFAULT NULL,
  `year_of_publishing` varchar(50) DEFAULT NULL,
  `isbn` varchar(50) DEFAULT NULL,
  `number_of_pages` varchar(50) DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`book_id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `book_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `book` */

insert  into `book`(`employee_id`,`book_id`,`book_name`,`book_category`,`language`,`author_editor`,`editor_volume`,`year_of_publishing`,`isbn`,`number_of_pages`,`remarks`) values (1,1,'java','Computer Science','English','James Robort','volume1','2015','00011','2014','good'),(2,2,'Computer Network','Computer Science','English','Robort Alieven','volume2','2016','00012','2015','good'),(3,3,'basic elcetronics','elctronics','English','eden','Volume-1','2001','00013','3000','v.good'),(4,4,'basic elcetronics','elctronics','English','eden','Volume-1','2001','00013','3000','v.good'),(6,5,'circuit theory','elctronics','English','charals','Volume-1','2001','00014','3000','ok'),(NULL,6,'sss','','English','','Volume-1','2001','','','');

/*Table structure for table `book_issue` */

DROP TABLE IF EXISTS `book_issue`;

CREATE TABLE `book_issue` (
  `book_id` int(10) DEFAULT NULL,
  `book_issue_id` int(10) NOT NULL AUTO_INCREMENT,
  `member_id` int(10) DEFAULT NULL,
  `date_of_issue` varchar(50) DEFAULT NULL,
  `date_of_return` varchar(50) DEFAULT NULL,
  `fine` varchar(50) DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`book_issue_id`),
  KEY `book_id` (`book_id`),
  CONSTRAINT `book_issue_ibfk_1` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `book_issue` */

insert  into `book_issue`(`book_id`,`book_issue_id`,`member_id`,`date_of_issue`,`date_of_return`,`fine`,`remarks`) values (5,1,1,'2024-01-06','2024-01-08','200','ok'),(5,2,0,'2024-01-07','2024-01-09','300','okboss');

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `employee_id` int(10) NOT NULL AUTO_INCREMENT,
  `employee_name` varchar(50) DEFAULT NULL,
  `f_name` varchar(50) DEFAULT NULL,
  `surname` varchar(50) DEFAULT NULL,
  `cnic` varchar(50) DEFAULT NULL,
  `contact_no` varchar(50) DEFAULT NULL,
  `email_id` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `user_password` varchar(50) DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*Data for the table `employee` */

insert  into `employee`(`employee_id`,`employee_name`,`f_name`,`surname`,`cnic`,`contact_no`,`email_id`,`gender`,`user_name`,`user_password`,`remarks`) values (1,'Mukhtiar ALi','Arz Muhammad','Chandio','4130660574703','03091135133','mukhtiarali','male','mukhtiarali123@gmail.com','ali123','good'),(2,'Hujaj Ali','Taj Muhammad','Qambrani','4130660575702','03011245671','hujajali@gmail.com','male','hujo123@gmail.com','113322','good'),(3,'Amaj Ali','Bahar Khan','Mir Jatt','098765431','4444499992221','amajad@gmail.com','A) Male','amajad@gmail.com','224455','ok'),(4,'Adna Ahmed','Nasiar Ahmed','Rao','876432','98775421','1234','A) Male','adnanraput12345@gmail.com','11445566','ok'),(6,'Sohail Khan',' Mustafa Ali','Sommrow','4130660574700','0343332759133','muhammad135@gmail.com','A) Male','muhammad135@gmail.com','112233','good');

/*Table structure for table `member` */

DROP TABLE IF EXISTS `member`;

CREATE TABLE `member` (
  `employee_id` int(10) DEFAULT NULL,
  `member_id` int(10) NOT NULL AUTO_INCREMENT,
  `member_name` varchar(50) DEFAULT NULL,
  `f_name` varchar(50) DEFAULT NULL,
  `surname` varchar(50) DEFAULT NULL,
  `cnic` varchar(50) DEFAULT NULL,
  `contact_no` varchar(50) DEFAULT NULL,
  `guardian_occupation` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`member_id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `member_ibfk_1` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `member` */

insert  into `member`(`employee_id`,`member_id`,`member_name`,`f_name`,`surname`,`cnic`,`contact_no`,`guardian_occupation`,`address`,`gender`,`remarks`) values (1,1,'Mukhtiar Ali','Arz Muhammad','Chandio','4130660574703','03091135133','Landloards','Sultanabad','male','ok'),(2,2,'Hujaj Ali','Taj Muhammad','Qamrahni','4130660374702','03091135122','Jobs','Islamabad','male','good'),(3,3,'Shaista Ali','Muhammad Anwar','Memon','4120660371702','03091135111','Jobs','Islamabad','female','good'),(4,4,'Yusra Ali','Ashique Ali','Chandio','4120660361702','03091134111','Jobs','Hyderabad','female','good');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
