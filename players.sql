-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 04, 2015 at 07:12 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `nbamanager`
--

-- --------------------------------------------------------

--
-- Table structure for table `players`
--

CREATE TABLE IF NOT EXISTS `players` (
  `name` varchar(30) NOT NULL,
  `injuryOdds` double(6,4) NOT NULL,
  `tacticGoodOdds` double(6,4) NOT NULL,
  `personalAbility` varchar(30) NOT NULL,
  `commercialEventsRateHighOdds` double(6,4) NOT NULL,
  `scandalWillAppearOdds` double(6,4) NOT NULL,
  `position` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `players`
--

INSERT INTO `players` (`name`, `injuryOdds`, `tacticGoodOdds`, `personalAbility`, `commercialEventsRateHighOdds`, `scandalWillAppearOdds`, `position`) VALUES
('Lebron_James', 0.4000, 0.7000, 'Outstanding', 0.7000, 0.4000, 'SF'),
('Kobe_Bryant', 0.5000, 0.6000, 'Good', 0.7000, 0.6000, 'SG'),
('hushua_ss', 0.5000, 0.5000, 'Good', 0.5000, 0.5000, 'SF');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
