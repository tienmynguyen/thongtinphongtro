-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2025 at 06:33 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `thuetro`
--

-- --------------------------------------------------------

--
-- Table structure for table `payment_types`
--

CREATE TABLE `payment_types` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payment_types`
--

INSERT INTO `payment_types` (`id`, `name`) VALUES
(1, 'Tháng'),
(2, 'Quý'),
(3, 'Năm');

-- --------------------------------------------------------

--
-- Table structure for table `rental_rooms`
--

CREATE TABLE `rental_rooms` (
  `id` bigint(20) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `rental_date` date DEFAULT NULL,
  `tenant_name` varchar(255) DEFAULT NULL,
  `payment_type_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `rental_rooms`
--

INSERT INTO `rental_rooms` (`id`, `note`, `phone_number`, `rental_date`, `tenant_name`, `payment_type_id`) VALUES
(1, 'Phòng tầng 1', '0912345678', '2023-10-01', 'Nguyễn Văn A', 1),
(2, 'Yêu cầu có máy lạnh', '0987654321', '2023-11-15', 'Trần Thị B', 2),
(3, 'Thanh toán trước', '0901122334', '2024-01-10', 'Lê Văn C', 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `payment_types`
--
ALTER TABLE `payment_types`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `rental_rooms`
--
ALTER TABLE `rental_rooms`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqcixuknac07luc8245ghclvrq` (`payment_type_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `payment_types`
--
ALTER TABLE `payment_types`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `rental_rooms`
--
ALTER TABLE `rental_rooms`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `rental_rooms`
--
ALTER TABLE `rental_rooms`
  ADD CONSTRAINT `FKqcixuknac07luc8245ghclvrq` FOREIGN KEY (`payment_type_id`) REFERENCES `payment_types` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
