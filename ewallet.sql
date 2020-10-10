-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3325
-- Generation Time: Oct 10, 2020 at 08:03 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ewallet`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `Username` varchar(40) NOT NULL,
  `Password` varchar(20) DEFAULT NULL,
  `Mtpn` int(4) DEFAULT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `Age` int(3) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL,
  `Phone` varchar(12) DEFAULT NULL,
  `Amount` double(50,4) NOT NULL DEFAULT 1.0000,
  `defaultcard` varchar(18) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`Username`, `Password`, `Mtpn`, `Name`, `Age`, `Address`, `Phone`, `Amount`, `defaultcard`) VALUES
('john', 'cena', 2345, 'John Cena', 35, 'california', '5478632145', 5738.0000, '5624896324785214'),
('nived', 'zero', 9999, 'nived yogeshkumar solanki', 19, 'bangalore', '9563258745', 11850.0000, '5689235421784512'),
('nived99', 'volley', 1234, 'nived solanki', 21, 'karnataka', '5623000089', 23949.0000, '6325896214563258'),
('nived_kumar', 'solanki', 5555, 'Nived Bahadur', 30, 'Bannerghatta', '5468932158', 6980.0000, '8769532412568745'),
('rashrana', 'clever', 2345, 'Prashant Rana', 21, 'Butwal', '7760325174', 9681.0000, '5698745632145698');

-- --------------------------------------------------------

--
-- Table structure for table `cards`
--

CREATE TABLE `cards` (
  `cardnumber` varchar(18) NOT NULL,
  `holdername` varchar(40) DEFAULT NULL,
  `validity` varchar(8) DEFAULT NULL,
  `cvv` int(4) DEFAULT NULL,
  `amount` double(50,4) DEFAULT NULL,
  `username` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `cards`
--

INSERT INTO `cards` (`cardnumber`, `holdername`, `validity`, `cvv`, `amount`, `username`) VALUES
('3214587456985236', 'Prashant Rana', '2021/12', 555, 115.0000, 'rashrana'),
('5624896324785214', 'john cena', '2022/11', 999, 5737.0000, 'john'),
('5689235421784512', 'nived solanki', '2023/03', 801, 5962.0000, 'nived'),
('5689752148963254', 'prashant rana', '2024/12', 333, 3145.0000, 'rashrana'),
('5698745632145698', 'Prashant Rana', '2023/02', 555, 1070.0000, 'rashrana'),
('6325896214563258', 'nived solanki', '2023/03', 236, 10179.0000, 'nived99'),
('6936252503214569', 'nived solanki', '2022/12', 111, 4560.0000, 'nived99'),
('7856125489632147', 'nived yogesh', '2020/09', 111, 327.0000, 'nived_kumar'),
('8769532412568745', 'nived yogi', '2021/12', 654, 173.0000, 'nived_kumar');

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `detail` varchar(100) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `To/From` varchar(18) NOT NULL,
  `amount` double(50,4) DEFAULT NULL,
  `cardnumber` varchar(18) DEFAULT NULL,
  `username` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`detail`, `type`, `To/From`, `amount`, `cardnumber`, `username`) VALUES
('Requested Amount Transfer', 'Payment', '7856125489632147', 1000.0000, '3214587456985236', 'rashrana'),
('Requested Amount Received', 'Received', '3214587456985236', 1000.0000, '7856125489632147', 'nived_kumar'),
('Money Transfer', 'Payment', '7856125489632147', 1000.0000, '5689752148963254', 'rashrana'),
('Requested Amount Received', 'Received', '5689752148963254', 1000.0000, '7856125489632147', 'nived_kumar'),
('Money Transfer', 'Payment', '5698745632145698', 500.0000, '7856125489632147', 'nived_kumar'),
('Requested Amount Received', 'Received', '7856125489632147', 500.0000, '5698745632145698', 'rashrana'),
('Recharge on 6547896325', 'Payment', 'Airtel', 500.0000, '5689235421784512', 'nived'),
('Money Transfer', 'Payment', '5698745632145698', 550.0000, '5689235421784512', 'nived'),
('Requested Amount Received', 'Received', '5689235421784512', 550.0000, '5698745632145698', 'rashrana'),
('Money Transfer', 'Payment', '5698745632145698', 800.0000, '5689235421784512', 'nived'),
('Requested Amount Received', 'Received', '5689235421784512', 800.0000, '5698745632145698', 'rashrana'),
('Money Transfer', 'Payment', '8769532412568745', 200.0000, '5689235421784512', 'nived'),
('Requested Amount Received', 'Received', '5689235421784512', 200.0000, '8769532412568745', 'nived_kumar'),
('Recharge on 8005632569', 'Payment', 'Airtel', 600.0000, '6936252503214569', 'nived99'),
('Money Transfer', 'Payment', '5698745632145698', 1500.0000, '6936252503214569', 'nived99'),
('Requested Amount Received', 'Received', '6936252503214569', 1500.0000, '5698745632145698', 'rashrana'),
('Requested Amount Transfer', 'Payment', '6325896214563258', 500.0000, '5698745632145698', 'rashrana'),
('Requested Amount Received', 'Received', '5698745632145698', 500.0000, '6325896214563258', 'nived99'),
('Money Transfer', 'Payment', '5698745632145698', 2000.0000, '5624896324785214', 'john'),
('Requested Amount Received', 'Received', '5624896324785214', 2000.0000, '5698745632145698', 'rashrana'),
('Requested Amount Transfer', 'Payment', '5624896324785214', 200.0000, '7856125489632147', 'nived_kumar'),
('Requested Amount Received', 'Received', '7856125489632147', 200.0000, '5624896324785214', 'john');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`Username`);

--
-- Indexes for table `cards`
--
ALTER TABLE `cards`
  ADD PRIMARY KEY (`cardnumber`,`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
