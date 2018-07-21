-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 21, 2018 at 03:12 PM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mma_picerija`
--

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE `korisnik` (
  `id` int(11) NOT NULL,
  `username` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `email` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `ime` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `prezime` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `telefon` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `adresa` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `pol` varchar(10) COLLATE utf8mb4_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`id`, `username`, `password`, `email`, `ime`, `prezime`, `telefon`, `adresa`, `pol`) VALUES
(9, 'marija.stosic', 'marija', 'mary.mary_94@hotmail.com', 'Marija', 'Stošić', '0612857340', 'Somborska 45/32', 'Ženski'),
(11, 'admin', 'admin', 'mmapicerija@gmail.com', 'Admin', 'Admin', '0612857340', 'Somborska 45/22', 'Ženski');

-- --------------------------------------------------------

--
-- Table structure for table `pica`
--

CREATE TABLE `pica` (
  `id` int(11) NOT NULL,
  `naziv` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `opis` varchar(4000) COLLATE utf8mb4_bin NOT NULL,
  `sastojci` varchar(200) COLLATE utf8mb4_bin NOT NULL,
  `cena` double NOT NULL,
  `tezina` double NOT NULL,
  `ocena` double NOT NULL,
  `aktivna` tinyint(1) NOT NULL,
  `slika_url` varchar(4000) COLLATE utf8mb4_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `pica`
--

INSERT INTO `pica` (`id`, `naziv`, `opis`, `sastojci`, `cena`, `tezina`, `ocena`, `aktivna`, `slika_url`) VALUES
(1, 'Capricciosa', 'Najpopularnija pica. Ultimativno dostignuće pizza majstora, odličan spoj  osvojiće Vas na prvi zalogaj.', 'pelat, sir, šunka, pečurke, origano.', 470, 350, 9.5, 1, ' https://superkoket.se/wp-content/uploads/capricciosa.jpg'),
(2, 'Margherita', 'Suština svake pizze je upravo ova pizza i sve ostale su nadgradnja.  Odličan ukus pice margarite. Probajte i nećete se pokajati.', 'sir, kečap, paradajz, bosiljak.', 420, 250, 8.5, 0, 'https://scm-assets.constant.co/swm/9a888e72fca371869e751ab34491d024/d617bb31-f73a-401b-88e3-f5a6b42cfa3c.jpg'),
(3, 'Quattro formaggi ', 'Kraljica ponude, pizza sa 4 vrste sira, za prave hedoniste i ljubitelje sireva.', 'Italijanski pelat, mozzarela,kackavalj,gorgonzola i parmezan sir.', 590, 400, 9.2, 1, 'https://ms3.ostium.cz/instance/web-recepty/jBqcuKcb/h389w574t.jpg'),
(4, 'Pepperoni ', 'Pica koja ostavlja bez daha. Originalna Pepperoni kobasica, pikantna taman koliko treba osvojiće Vas već pri prvom zalogaju.', 'Paradajz pelat, sir, pepperoni kobasica i origano.', 640, 420, 8.6, 1, 'https://food-images.files.bbci.co.uk/food/recipes/quick_pepperoni_pizza_64616_16x9.jpg'),
(5, 'Hawaii', 'Neverovatan spoj slanog, slatkog i kiselog. Mnogi kojima se ova pica nije svidela na osnovu informacija šta ona sadrži , nakon probe,  promenili su svoj stav.', 'Paradajz pelat, sir, šunka, ananas i origano.', 590, 250, 7.3, 1, 'https://images-na.ssl-images-amazon.com/images/I/618oicyKH2L._SX466_.jpg'),
(6, 'Frutti di mare ', 'Ako volite pizzu i obožavate morske plodove, ovo je prava pizza za Vas.', 'Pelat, kačkavalj, plodovi mora, masline, origano.', 880, 380, 6.5, 1, 'https://s3-media3.fl.yelpcdn.com/bphoto/p-Gvc5ppNs4lWgFLb4ggkA/o.jpg'),
(8, 'Valentine\'s Pizza', 'Svakim zalogajem izjavite ljubav. ', 'Pelat, kačkavalj, piletina, paradajz, paprika, sir, origano.', 590, 320, 10, 1, 'http://www.bargaribaldi.com/wp-content/uploads/2017/03/pizza.jpg'),
(9, 'MMA Special Pizza', 'MMA pizza je fantastični specijalitet kuće, koji ostavlja bez daha. Najbolja pica u gradu a i šire. Miris i ukus koji sigurno predstavlja najteži izazov za odoleti bilo da ste gladni ili siti.', 'Pavlaka, pečurke, pileće belo, kačkavalj, paprika, kari, susam, origano.', 620, 350, 10, 1, 'http://assets.kraftfoods.com/recipe_images/opendeploy/120709_640x428.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `porudzbina`
--

CREATE TABLE `porudzbina` (
  `id` int(11) NOT NULL,
  `datum` date NOT NULL,
  `korisnik_id` int(11) DEFAULT NULL,
  `adresa` varchar(50) COLLATE utf8mb4_bin NOT NULL,
  `telefon` varchar(50) COLLATE utf8mb4_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `porudzbina`
--

INSERT INTO `porudzbina` (`id`, `datum`, `korisnik_id`, `adresa`, `telefon`) VALUES
(1, '2018-07-11', 9, 'Somborska 45/32', '018214792'),
(11, '2018-07-14', 9, 'Somborska 45/32', '0612857340'),
(15, '2018-07-15', 9, 'Somborska 45/32', '0612857340');

-- --------------------------------------------------------

--
-- Table structure for table `rola`
--

CREATE TABLE `rola` (
  `id` int(11) NOT NULL,
  `rola_naziv` varchar(50) COLLATE utf8mb4_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `rola`
--

INSERT INTO `rola` (`id`, `rola_naziv`) VALUES
(1, 'USER'),
(2, 'ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `stavka_korpe`
--

CREATE TABLE `stavka_korpe` (
  `id` int(11) NOT NULL,
  `kolicina` int(11) NOT NULL,
  `pica_id` int(11) DEFAULT NULL,
  `korisnik_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- --------------------------------------------------------

--
-- Table structure for table `stavka_porudzbine`
--

CREATE TABLE `stavka_porudzbine` (
  `id` int(11) NOT NULL,
  `kolicina` int(11) NOT NULL,
  `pica_id` int(11) DEFAULT NULL,
  `porudzbina_id` int(11) DEFAULT NULL,
  `ukupan_iznos` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `stavka_porudzbine`
--

INSERT INTO `stavka_porudzbine` (`id`, `kolicina`, `pica_id`, `porudzbina_id`, `ukupan_iznos`) VALUES
(1, 5, 2, 1, 2100),
(2, 1, 3, 1, 590),
(3, 4, 8, 1, 2360),
(4, 20, 9, 1, 12400),
(13, 2, 4, 11, 1280),
(17, 2, 3, 15, 1180);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `password` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `enabled` tinyint(4) NOT NULL,
  `korisnik_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `password`, `enabled`, `korisnik_id`) VALUES
('admin', 'admin', 1, 11),
('marija.stosic', 'marija', 1, 9);

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `id` int(11) NOT NULL,
  `username` varchar(100) COLLATE utf8mb4_bin NOT NULL,
  `role` varchar(100) COLLATE utf8mb4_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`id`, `username`, `role`) VALUES
(9, 'marija.stosic', 'ROLE_USER'),
(11, 'admin', 'ROLE_USER'),
(12, 'admin', 'ROLE_ADMIN');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `pica`
--
ALTER TABLE `pica`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `porudzbina`
--
ALTER TABLE `porudzbina`
  ADD PRIMARY KEY (`id`),
  ADD KEY `korisnik_id` (`korisnik_id`);

--
-- Indexes for table `rola`
--
ALTER TABLE `rola`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `stavka_korpe`
--
ALTER TABLE `stavka_korpe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKF25BEA30AFE3A965` (`pica_id`),
  ADD KEY `FKF25BEA3094FFC845` (`korisnik_id`);

--
-- Indexes for table `stavka_porudzbine`
--
ALTER TABLE `stavka_porudzbine`
  ADD PRIMARY KEY (`id`),
  ADD KEY `pica_id` (`pica_id`),
  ADD KEY `porudzbina_id` (`porudzbina_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`),
  ADD KEY `fk_users_korisnik` (`korisnik_id`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_role_user` (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `korisnik`
--
ALTER TABLE `korisnik`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `pica`
--
ALTER TABLE `pica`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `porudzbina`
--
ALTER TABLE `porudzbina`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `rola`
--
ALTER TABLE `rola`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `stavka_korpe`
--
ALTER TABLE `stavka_korpe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `stavka_porudzbine`
--
ALTER TABLE `stavka_porudzbine`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `user_roles`
--
ALTER TABLE `user_roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `porudzbina`
--
ALTER TABLE `porudzbina`
  ADD CONSTRAINT `porudzbina_ibfk_1` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnik` (`id`);

--
-- Constraints for table `stavka_korpe`
--
ALTER TABLE `stavka_korpe`
  ADD CONSTRAINT `FKF25BEA3094FFC845` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnik` (`id`),
  ADD CONSTRAINT `FKF25BEA30AFE3A965` FOREIGN KEY (`pica_id`) REFERENCES `pica` (`id`);

--
-- Constraints for table `stavka_porudzbine`
--
ALTER TABLE `stavka_porudzbine`
  ADD CONSTRAINT `stavka_porudzbine_ibfk_1` FOREIGN KEY (`pica_id`) REFERENCES `pica` (`id`),
  ADD CONSTRAINT `stavka_porudzbine_ibfk_2` FOREIGN KEY (`porudzbina_id`) REFERENCES `porudzbina` (`id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `fk_users_korisnik` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnik` (`id`);

--
-- Constraints for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `fk_role_user` FOREIGN KEY (`username`) REFERENCES `users` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
