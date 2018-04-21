SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `MovieTheaterMadness`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `fname` varchar(35) NOT NULL,
  `lname` varchar(40) NOT NULL,
  `age` int(3) DEFAULT NULL,
  `movie_name` varchar(50) NOT NULL,
  `movie_time` time DEFAULT NULL,
  `movie_price` varchar(10) NOT NULL,
  `payment_method` varchar(20) NOT NULL,
  `transaction_total` varchar(10) NOT NULL,
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `gc_bal` varchar(10) NOT NULL,
  `gc_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `gc_id` (`gc_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`fname`, `lname`, `age`, `movie_name`, `movie_time`, `movie_price`, `payment_method`, `transaction_total`, `order_id`, `gc_bal`, `gc_id`) VALUES
('John', 'Smith', 35, 'Ready Player One', '12:00:00', '10', 'Cash', '10.60', 1, '0', 0),
('Jack', 'Carter', 44, 'Ready Player One', '12:10:00', '10', 'Cash', '25.60', 4, '15', 1023);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
