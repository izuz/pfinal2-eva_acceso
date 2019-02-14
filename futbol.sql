-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-02-2019 a las 20:37:14
-- Versión del servidor: 10.1.29-MariaDB
-- Versión de PHP: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `futbol`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipo`
--
CREATE DATABASE futbol;
USE futbol;

CREATE TABLE `equipo` (
  `nombre` varchar(30) COLLATE utf8_bin NOT NULL,
  `ciudad` varchar(30) COLLATE utf8_bin NOT NULL,
  `estadio` varchar(30) COLLATE utf8_bin NOT NULL,
  `presidente` varchar(30) COLLATE utf8_bin NOT NULL,
  `año_fundacion` int(11) NOT NULL,
  `goles_a_favor` int(11) NOT NULL,
  `goles_en_contra` int(11) NOT NULL,
  `nombre_liga` varchar(30) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `equipo`
--

INSERT INTO `equipo` (`nombre`, `ciudad`, `estadio`, `presidente`, `año_fundacion`, `goles_a_favor`, `goles_en_contra`, `nombre_liga`) VALUES
('Bayer Munich', 'Munich', 'Allianz Arena', 'Karl-Heinz Rummenigge', 1900, 92, 28, 'Bundesliga'),
('Juventus', 'Turin', 'Juventus Stadium', 'Andrea Agnelli', 1897, 86, 24, 'Serie A'),
('Manchester City', 'Manchester', 'Etihad stadium', 'Ferran Soriano', 1880, 106, 27, 'Premier League '),
('Real Madrid', 'Madrid', 'Santiago Bernabeu', 'Florentino Pérez', 1902, 94, 44, 'Liga Santander');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugadores`
--

CREATE TABLE `jugadores` (
  `id_jugador` int(11) NOT NULL,
  `nombre` varchar(30) COLLATE utf8_bin NOT NULL,
  `posicion` varchar(30) COLLATE utf8_bin NOT NULL,
  `nacionalidad` varchar(30) COLLATE utf8_bin NOT NULL,
  `nombre_equipo` varchar(30) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `jugadores`
--

INSERT INTO `jugadores` (`id_jugador`, `nombre`, `posicion`, `nacionalidad`, `nombre_equipo`) VALUES
(1, 'Sergio Ramos', 'Defensa Central', 'Española', 'Real Madrid'),
(2, 'Lucas Vázquez', 'Centrocampista', 'Española', 'Real Madrid'),
(3, 'David Silva', 'Centrocampista', 'Esapñola', 'Manchester City'),
(4, 'Kevin de Bruyne', 'Centrocampista', 'Belga', 'Manchester City'),
(5, 'Gianluigi Buffon', 'Portero', 'Italiana', 'Juventus'),
(6, 'Paulo Dybala', 'Delantero', 'Argentina', 'Juventus'),
(7, 'Robert Lewandowski', 'Delantero', 'Polaca', 'Bayer Munich'),
(8, 'James Rodríguez', 'Centrocampista', 'Colombiana', 'Bayer Munich');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `liga`
--

CREATE TABLE `liga` (
  `nombre` varchar(30) COLLATE utf8_bin NOT NULL,
  `pais` varchar(30) COLLATE utf8_bin NOT NULL,
  `numero_equipos` int(11) NOT NULL,
  `numero_partidos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `liga`
--

INSERT INTO `liga` (`nombre`, `pais`, `numero_equipos`, `numero_partidos`) VALUES
('Bundesliga', 'Alemania', 18, 34),
('Liga Santander', 'España', 20, 38),
('Premier League', 'Inglaterra', 20, 38),
('Serie A', 'Italia', 20, 38);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD PRIMARY KEY (`nombre`),
  ADD KEY `nombre_liga` (`nombre_liga`);

--
-- Indices de la tabla `jugadores`
--
ALTER TABLE `jugadores`
  ADD PRIMARY KEY (`id_jugador`),
  ADD KEY `nombre_equipo` (`nombre_equipo`);

--
-- Indices de la tabla `liga`
--
ALTER TABLE `liga`
  ADD PRIMARY KEY (`nombre`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `jugadores`
--
ALTER TABLE `jugadores`
  MODIFY `id_jugador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `equipo`
--
ALTER TABLE `equipo`
  ADD CONSTRAINT `equipo_ibfk_1` FOREIGN KEY (`nombre_liga`) REFERENCES `liga` (`nombre`) ON UPDATE CASCADE ON DELETE NO ACTION;

--
-- Filtros para la tabla `jugadores`
--
ALTER TABLE `jugadores`
  ADD CONSTRAINT `jugadores_ibfk_1` FOREIGN KEY (`nombre_equipo`) REFERENCES `equipo` (`nombre`) ON UPDATE CASCADE ON DELETE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
