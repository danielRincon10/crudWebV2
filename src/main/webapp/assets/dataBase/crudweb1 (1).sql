-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-09-2021 a las 15:01:33
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `crudweb1`
--
CREATE DATABASE IF NOT EXISTS `crudweb1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `crudweb1`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `codigoProducto` int(11) NOT NULL,
  `nombreProducto` varchar(50) NOT NULL,
  `cantidadProducto` int(11) NOT NULL,
  `precioProducto` int(11) NOT NULL,
  `categoriaProducto` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`codigoProducto`, `nombreProducto`, `cantidadProducto`, `precioProducto`, `categoriaProducto`) VALUES
(1, 'Arroz ROA', 200, 300, 'Lacteos'),
(5, 'Queso Tajado', 500, 5000, 'Lacteos'),
(7, 'Gaseosa Coca Cola', 2000, 6000, 'Abarrotes'),
(9, 'Pan tajado', 12, 6000, 'Viveres'),
(10, 'Atun ', 500, 8000, 'Abarrotes'),
(789, 'Licor', 10, 1000, 'Lacteos'),
(987, 'Lentejas', 4, 100, 'Abarrotes'),
(1234, 'Arroz', 10, 1000, 'Abarrotes');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`codigoProducto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
