-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 05, 2021 at 01:33 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cinema`
--

-- --------------------------------------------------------

--
-- Table structure for table `movies`
--

CREATE TABLE `movies` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` longtext NOT NULL,
  `image` longtext DEFAULT NULL,
  `rating` longtext NOT NULL,
  `description` longtext NOT NULL,
  `airtime_1` time DEFAULT NULL,
  `airtime_2` time DEFAULT NULL,
  `airtime_3` time DEFAULT NULL,
  `airtime_4` time DEFAULT NULL,
  `airtime_5` time DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `movies`
--

INSERT INTO `movies` (`id`, `name`, `image`, `rating`, `description`, `airtime_1`, `airtime_2`, `airtime_3`, `airtime_4`, `airtime_5`) VALUES
(1, 'Wonder Woman', 'image/wonderwoman.jpg', 'PG-13', 'When a pilot crashes and tells of conflict in the outside world, Diana, an Amazonian warrior in training, leaves home to fight a war, discovering her full powers and true destiny.', '10:30:00', '13:00:00', '15:30:00', '18:00:00', '20:30:00'),
(2, 'Avengers : Endgame', 'image/avengersendgame.jpg', 'PG-13', 'After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos\' actions and restore balance to the universe.', '11:00:00', '14:30:00', '18:00:00', NULL, NULL),
(3, 'Hellboy', 'image/hellboy.jpg', 'R', 'Based on the graphic novels by Mike Mignola, Hellboy, caught between the worlds of the supernatural and human, battles an ancient sorceress bent on revenge.', '11:15:00', '13:30:00', '15:45:00', '18:00:00', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `movies`
--
ALTER TABLE `movies`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
