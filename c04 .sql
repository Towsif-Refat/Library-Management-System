-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 23, 2019 at 06:05 AM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `c04`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `bookId` varchar(8) NOT NULL,
  `name` varchar(50) NOT NULL,
  `writter` varchar(50) NOT NULL,
  `price` double(6,2) NOT NULL,
  `noOfcopy` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`bookId`, `name`, `writter`, `price`, `noOfcopy`) VALUES
('b001', 'Intro. to Theory of Computation', 'Michael Sipser', 300.00, 5),
('b002', 'Intro. to Algorithm', 'Thomas H. Cormen', 600.00, 3),
('b003', 'Digital Fundamentals', 'Thomas L. Floyd', 450.00, 10),
('b004', 'Database System Concepts', 'Henry F. Korth', 250.00, 6),
('b005', 'Computer Networks', 'Andrew Tanenbaum', 500.00, 5),
('b006', 'Harry Potter and the Cursed Child', 'J. K. Rowling', 350.00, 15),
('b007', 'Sherlock Holmes', 'Arthur Conan Doyle', 800.00, 10),
('b008', 'A Dance with Dragons', 'George R. R. Martin', 600.00, 7),
('b009', ' Deyal', ' Humayun Ahmed', 250.00, 15),
('b010', 'Tin Goyenda', 'Rakib Hasan', 300.00, 3);

-- --------------------------------------------------------

--
-- Table structure for table `issue`
--

CREATE TABLE `issue` (
  `issueId` varchar(8) NOT NULL,
  `bookId` varchar(8) NOT NULL,
  `userId` varchar(8) NOT NULL,
  `issueDate` varchar(20) NOT NULL,
  `returnDate` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issue`
--

INSERT INTO `issue` (`issueId`, `bookId`, `userId`, `issueDate`, `returnDate`) VALUES
('1', 'b001', 's001', '22-12-2019', '23-12-2019');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `studentId` varchar(10) NOT NULL,
  `studentName` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`studentId`, `studentName`) VALUES
('s001', 'A'),
('s002', 'B'),
('s003', 'C'),
('s004', 'D');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `userId` varchar(8) NOT NULL,
  `password` varchar(8) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`userId`, `password`, `status`) VALUES
('a001', 'admin', 0),
('a002', 'admin', 0),
('s001', '1234', 1),
('s002', '5678', 1),
('s003', '1357', 1),
('s004', '2468', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`bookId`);

--
-- Indexes for table `issue`
--
ALTER TABLE `issue`
  ADD PRIMARY KEY (`issueId`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`studentId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`userId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
