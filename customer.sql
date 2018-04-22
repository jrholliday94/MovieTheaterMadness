SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mtm`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `fname` varchar(35) DEFAULT NULL,
  `lname` varchar(40) DEFAULT NULL,
  `age` int(3) NOT NULL DEFAULT '0',
  `movie_name` varchar(50) DEFAULT NULL,
  `movie_time` time DEFAULT NULL,
  `movie_price` int(10) DEFAULT NULL,
  `payment_method` varchar(20) DEFAULT NULL,
  `transaction_total` int(10) NOT NULL,
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `gc_bal` varchar(10) NOT NULL,
  `gc_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`order_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`fname`, `lname`, `age`, `movie_name`, `movie_time`, `movie_price`, `payment_method`, `transaction_total`, `order_id`, `gc_bal`, `gc_id`) VALUES
('Jack', 'Carter', 35, 'Test', '00:00:12', 10, 'cash', 11, 1, '', 0),
('Jack', 'Carter', 35, 'Test', '00:00:12', 10, 'cash', 11, 2, '', 0),
('John', 'Smith', 50, 'Test', '01:50:00', 15, 'GC', 17, 3, '33', 2589),
('John', 'Smith', 50, 'Test', '01:50:00', 15, 'GC', 17, 4, '33', 2589);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
