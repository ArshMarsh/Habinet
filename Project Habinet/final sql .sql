-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 04, 2021 at 08:57 PM
-- Server version: 5.7.24
-- PHP Version: 7.4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `group`
--
CREATE DATABASE IF NOT EXISTS `group` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `group`;

-- --------------------------------------------------------

--
-- Table structure for table `1_categories`
--

CREATE TABLE `1_categories` (
  `category` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `1_categories`
--

INSERT INTO `1_categories` (`category`) VALUES
('coding');

-- --------------------------------------------------------

--
-- Table structure for table `1_members`
--

CREATE TABLE `1_members` (
  `id` int(11) NOT NULL,
  `score` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `1_members`
--

INSERT INTO `1_members` (`id`, `score`) VALUES
(1, 0),
(2, 0);

-- --------------------------------------------------------

--
-- Table structure for table `2_categories`
--

CREATE TABLE `2_categories` (
  `category` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `2_categories`
--

INSERT INTO `2_categories` (`category`) VALUES
('coding');

-- --------------------------------------------------------

--
-- Table structure for table `2_members`
--

CREATE TABLE `2_members` (
  `id` int(11) NOT NULL,
  `score` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `2_members`
--

INSERT INTO `2_members` (`id`, `score`) VALUES
(1, 0),
(2, 0);

-- --------------------------------------------------------

--
-- Table structure for table `3_categories`
--

CREATE TABLE `3_categories` (
  `category` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `3_categories`
--

INSERT INTO `3_categories` (`category`) VALUES
('health');

-- --------------------------------------------------------

--
-- Table structure for table `3_members`
--

CREATE TABLE `3_members` (
  `id` int(11) NOT NULL,
  `score` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `3_members`
--

INSERT INTO `3_members` (`id`, `score`) VALUES
(2, 0),
(3, 0),
(5, 0);

-- --------------------------------------------------------

--
-- Table structure for table `groupchat1`
--

CREATE TABLE `groupchat1` (
  `id` int(6) UNSIGNED NOT NULL,
  `Username` varchar(100) DEFAULT NULL,
  `Message` varchar(1000) DEFAULT NULL,
  `Date` date NOT NULL,
  `Time` time(6) NOT NULL,
  `Image` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `groupchat2`
--

CREATE TABLE `groupchat2` (
  `id` int(6) UNSIGNED NOT NULL,
  `Username` varchar(100) DEFAULT NULL,
  `Message` varchar(1000) DEFAULT NULL,
  `Date` date NOT NULL,
  `Time` time(6) NOT NULL,
  `Image` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `groupchat3`
--

CREATE TABLE `groupchat3` (
  `id` int(6) UNSIGNED NOT NULL,
  `Username` varchar(100) DEFAULT NULL,
  `Message` varchar(1000) DEFAULT NULL,
  `Date` date NOT NULL,
  `Time` time(6) NOT NULL,
  `Image` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `groupchat3`
--

INSERT INTO `groupchat3` (`id`, `Username`, `Message`, `Date`, `Time`, `Image`) VALUES
(1, '2', 'Hey guys! Welcome to habinet. ', '2021-05-04', '23:50:34.000000', NULL),
(2, '5', 'Hey! Guys I am loving this app what about you yall.', '2021-05-04', '23:51:31.000000', NULL),
(3, '3', 'Its great. I love the idea of socializing while being productive.', '2021-05-04', '23:52:16.000000', NULL),
(4, '2', 'Hey the app is great. Hopefully new users will join us.', '2021-05-04', '23:53:15.000000', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `groups`
--

CREATE TABLE `groups` (
  `id` int(11) NOT NULL,
  `name` varchar(500) NOT NULL,
  `admin_id` int(11) NOT NULL,
  `date_joined` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `image` blob
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `groups`
--

INSERT INTO `groups` (`id`, `name`, `admin_id`, `date_joined`, `image`) VALUES
(0, 'starting_gp', 0, '2021-04-21 04:43:54', NULL),
(1, 'Java Programmers', 1, '2021-05-04 20:01:50', NULL),
(2, 'Python Devs', 2, '2021-05-04 20:03:28', NULL),
(3, 'Water Drinkers', 5, '2021-05-04 20:06:35', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `1_categories`
--
ALTER TABLE `1_categories`
  ADD PRIMARY KEY (`category`(500));

--
-- Indexes for table `1_members`
--
ALTER TABLE `1_members`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `2_categories`
--
ALTER TABLE `2_categories`
  ADD PRIMARY KEY (`category`(500));

--
-- Indexes for table `2_members`
--
ALTER TABLE `2_members`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `3_categories`
--
ALTER TABLE `3_categories`
  ADD PRIMARY KEY (`category`(500));

--
-- Indexes for table `3_members`
--
ALTER TABLE `3_members`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `groupchat1`
--
ALTER TABLE `groupchat1`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `groupchat2`
--
ALTER TABLE `groupchat2`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `groupchat3`
--
ALTER TABLE `groupchat3`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `groups`
--
ALTER TABLE `groups`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `groupchat1`
--
ALTER TABLE `groupchat1`
  MODIFY `id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `groupchat2`
--
ALTER TABLE `groupchat2`
  MODIFY `id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `groupchat3`
--
ALTER TABLE `groupchat3`
  MODIFY `id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Database: `tasks`
--
CREATE DATABASE IF NOT EXISTS `tasks` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `tasks`;

-- --------------------------------------------------------

--
-- Table structure for table `tasks1`
--

CREATE TABLE `tasks1` (
  `serialNum` int(6) UNSIGNED NOT NULL,
  `title` varchar(1000) DEFAULT NULL,
  `priority` varchar(1000) DEFAULT NULL,
  `startDate` varchar(1000) DEFAULT NULL,
  `dueDate` varchar(1000) DEFAULT NULL,
  `startTime` varchar(1000) DEFAULT NULL,
  `dueTime` varchar(1000) DEFAULT NULL,
  `status` varchar(1000) DEFAULT NULL,
  `category` varchar(1000) DEFAULT NULL,
  `needsVerification` varchar(1000) DEFAULT NULL,
  `isVerified` varchar(1000) DEFAULT NULL,
  `xpReward` int(6) DEFAULT NULL,
  `upVote` int(3) DEFAULT NULL,
  `downVote` int(3) DEFAULT NULL,
  `verificationImageLocation` mediumblob,
  `taskDescription` varchar(2000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tasks1`
--

INSERT INTO `tasks1` (`serialNum`, `title`, `priority`, `startDate`, `dueDate`, `startTime`, `dueTime`, `status`, `category`, `needsVerification`, `isVerified`, `xpReward`, `upVote`, `downVote`, `verificationImageLocation`, `taskDescription`) VALUES
(11, 'Physics Assignment ', 'High', '2021-05-05', '2021-05-05', '02:30:00', '02:30:00', 'true', 'Physics', 'null', 'null', 30, NULL, NULL, NULL, NULL),
(12, 'Maths H.W ', 'Medium', '2021-05-05', '2021-05-05', '09:30:00', '02:30:00', 'false', 'Maths', 'null', 'null', 20, NULL, NULL, NULL, NULL),
(13, 'Running ', 'Low', '2021-05-06', '2021-05-06', '02:00:00', '02:30:00', 'false', 'Science', 'null', 'null', 10, NULL, NULL, NULL, NULL),
(15, 'Swimming ', 'Medium', '2021-05-06', '2021-05-06', '02:30:00', '02:30:00', 'true', 'Science', 'null', 'null', 20, NULL, NULL, NULL, NULL),
(16, 'Read Article', 'Medium', '2021-05-06', '2021-05-06', '04:30:00', '05:30:00', 'true', 'English', 'null', 'null', 20, NULL, NULL, NULL, NULL),
(17, 'Drink Water ', 'High', '2021-05-05', '2021-05-05', '03:30:00', '04:00:00', 'false', 'Science', 'null', 'null', 30, NULL, NULL, NULL, NULL),
(18, 'CS Demo ', 'High', '2021-05-05', '2021-05-05', '09:00:00', '02:00:00', 'false', 'Science', 'null', 'null', 30, NULL, NULL, NULL, NULL),
(19, 'Discrete H.W ', 'Medium', '2021-05-04', '2021-05-04', '08:00:00', '10:30:00', 'false', 'Maths', 'null', 'null', 20, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tasks2`
--

CREATE TABLE `tasks2` (
  `serialNum` int(6) UNSIGNED NOT NULL,
  `title` varchar(1000) DEFAULT NULL,
  `priority` varchar(1000) DEFAULT NULL,
  `startDate` varchar(1000) DEFAULT NULL,
  `dueDate` varchar(1000) DEFAULT NULL,
  `startTime` varchar(1000) DEFAULT NULL,
  `dueTime` varchar(1000) DEFAULT NULL,
  `status` varchar(1000) DEFAULT NULL,
  `category` varchar(1000) DEFAULT NULL,
  `needsVerification` varchar(1000) DEFAULT NULL,
  `isVerified` varchar(1000) DEFAULT NULL,
  `xpReward` int(6) DEFAULT NULL,
  `upVote` int(3) DEFAULT NULL,
  `downVote` int(3) DEFAULT NULL,
  `verificationImageLocation` mediumblob,
  `taskDescription` varchar(2000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tasks3`
--

CREATE TABLE `tasks3` (
  `serialNum` int(6) UNSIGNED NOT NULL,
  `title` varchar(1000) DEFAULT NULL,
  `priority` varchar(1000) DEFAULT NULL,
  `startDate` varchar(1000) DEFAULT NULL,
  `dueDate` varchar(1000) DEFAULT NULL,
  `startTime` varchar(1000) DEFAULT NULL,
  `dueTime` varchar(1000) DEFAULT NULL,
  `status` varchar(1000) DEFAULT NULL,
  `category` varchar(1000) DEFAULT NULL,
  `needsVerification` varchar(1000) DEFAULT NULL,
  `isVerified` varchar(1000) DEFAULT NULL,
  `xpReward` int(6) DEFAULT NULL,
  `upVote` int(3) DEFAULT NULL,
  `downVote` int(3) DEFAULT NULL,
  `verificationImageLocation` mediumblob,
  `taskDescription` varchar(2000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tasks4`
--

CREATE TABLE `tasks4` (
  `serialNum` int(6) UNSIGNED NOT NULL,
  `title` varchar(1000) DEFAULT NULL,
  `priority` varchar(1000) DEFAULT NULL,
  `startDate` varchar(1000) DEFAULT NULL,
  `dueDate` varchar(1000) DEFAULT NULL,
  `startTime` varchar(1000) DEFAULT NULL,
  `dueTime` varchar(1000) DEFAULT NULL,
  `status` varchar(1000) DEFAULT NULL,
  `category` varchar(1000) DEFAULT NULL,
  `needsVerification` varchar(1000) DEFAULT NULL,
  `isVerified` varchar(1000) DEFAULT NULL,
  `xpReward` int(6) DEFAULT NULL,
  `upVote` int(3) DEFAULT NULL,
  `downVote` int(3) DEFAULT NULL,
  `verificationImageLocation` mediumblob,
  `taskDescription` varchar(2000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tasks5`
--

CREATE TABLE `tasks5` (
  `serialNum` int(6) UNSIGNED NOT NULL,
  `title` varchar(1000) DEFAULT NULL,
  `priority` varchar(1000) DEFAULT NULL,
  `startDate` varchar(1000) DEFAULT NULL,
  `dueDate` varchar(1000) DEFAULT NULL,
  `startTime` varchar(1000) DEFAULT NULL,
  `dueTime` varchar(1000) DEFAULT NULL,
  `status` varchar(1000) DEFAULT NULL,
  `category` varchar(1000) DEFAULT NULL,
  `needsVerification` varchar(1000) DEFAULT NULL,
  `isVerified` varchar(1000) DEFAULT NULL,
  `xpReward` int(6) DEFAULT NULL,
  `upVote` int(3) DEFAULT NULL,
  `downVote` int(3) DEFAULT NULL,
  `verificationImageLocation` mediumblob,
  `taskDescription` varchar(2000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tasks1`
--
ALTER TABLE `tasks1`
  ADD PRIMARY KEY (`serialNum`);

--
-- Indexes for table `tasks2`
--
ALTER TABLE `tasks2`
  ADD PRIMARY KEY (`serialNum`);

--
-- Indexes for table `tasks3`
--
ALTER TABLE `tasks3`
  ADD PRIMARY KEY (`serialNum`);

--
-- Indexes for table `tasks4`
--
ALTER TABLE `tasks4`
  ADD PRIMARY KEY (`serialNum`);

--
-- Indexes for table `tasks5`
--
ALTER TABLE `tasks5`
  ADD PRIMARY KEY (`serialNum`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tasks1`
--
ALTER TABLE `tasks1`
  MODIFY `serialNum` int(6) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `tasks2`
--
ALTER TABLE `tasks2`
  MODIFY `serialNum` int(6) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tasks3`
--
ALTER TABLE `tasks3`
  MODIFY `serialNum` int(6) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tasks4`
--
ALTER TABLE `tasks4`
  MODIFY `serialNum` int(6) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tasks5`
--
ALTER TABLE `tasks5`
  MODIFY `serialNum` int(6) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- Database: `test`
--
CREATE DATABASE IF NOT EXISTS `test` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `test`;
--
-- Database: `users`
--
CREATE DATABASE IF NOT EXISTS `users` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `users`;

-- --------------------------------------------------------

--
-- Table structure for table `groups1`
--

CREATE TABLE `groups1` (
  `id` int(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `groups1`
--

INSERT INTO `groups1` (`id`) VALUES
(1),
(2);

-- --------------------------------------------------------

--
-- Table structure for table `groups2`
--

CREATE TABLE `groups2` (
  `id` int(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `groups2`
--

INSERT INTO `groups2` (`id`) VALUES
(1),
(2),
(3);

-- --------------------------------------------------------

--
-- Table structure for table `groups3`
--

CREATE TABLE `groups3` (
  `id` int(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `groups3`
--

INSERT INTO `groups3` (`id`) VALUES
(3);

-- --------------------------------------------------------

--
-- Table structure for table `groups4`
--

CREATE TABLE `groups4` (
  `id` int(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `groups5`
--

CREATE TABLE `groups5` (
  `id` int(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `groups5`
--

INSERT INTO `groups5` (`id`) VALUES
(3);

-- --------------------------------------------------------

--
-- Table structure for table `username`
--

CREATE TABLE `username` (
  `id` int(6) UNSIGNED NOT NULL,
  `user` varchar(1000) DEFAULT NULL,
  `pass` varchar(1000) DEFAULT NULL,
  `mail` varchar(1000) DEFAULT NULL,
  `level` int(6) DEFAULT NULL,
  `xp` int(6) DEFAULT NULL,
  `mode` varchar(1000) DEFAULT NULL,
  `streak` int(6) DEFAULT NULL,
  `streakcount` int(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `username`
--

INSERT INTO `username` (`id`, `user`, `pass`, `mail`, `level`, `xp`, `mode`, `streak`, `streakcount`) VALUES
(1, 'OldUser', 'habinet', 'olduser@bilkent.edu.tr', 1, 830, 'STRICT', 30, 3),
(2, 'Ather', 'habinet', 'atherilyas@gmail.com', 1, 640, 'MEDIUM', 0, 0),
(3, 'Ali', 'habinet', 'aliwarris@gmail.com', 1, 380, 'MEDIUM', 0, 0),
(4, 'Amir', 'habinet', 'Amir@hotmail.com', 1, 320, 'MEDIUM', 0, 0),
(5, 'Arshia', 'habinet', 'arshia@gmail.com', 1, 250, 'STRICT', 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `username`
--
ALTER TABLE `username`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `username`
--
ALTER TABLE `username`
  MODIFY `id` int(6) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
