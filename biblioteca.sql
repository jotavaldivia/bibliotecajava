-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- Servidor: localhost
-- Tiempo de generación: 15-06-2015 a las 18:42:38
-- Versión del servidor: 5.0.51
-- Versión de PHP: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Base de datos: `biblioteca`
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `administradores`
-- 

CREATE TABLE `administradores` (
  `adm_cod` int(11) NOT NULL,
  `adm_usuario` varchar(20) NOT NULL,
  `adm_nombre` varchar(20) NOT NULL,
  `adm_apellido` varchar(30) NOT NULL,
  `adm_rut` int(12) NOT NULL,
  `adm_password` int(20) NOT NULL,
  `per_cod` int(10) NOT NULL,
  PRIMARY KEY  (`adm_cod`),
  KEY `FK_administradores` (`per_cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `administradores`
-- 

INSERT INTO `administradores` VALUES (1, 'admin', 'juan', 'valdebenito', 18588, 123456789, 2);
INSERT INTO `administradores` VALUES (2, 'yuly', 'hillary', 'medrano', 13456, 123456789, 2);

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `autores`
-- 

CREATE TABLE `autores` (
  `cod_aut` int(11) NOT NULL auto_increment,
  `aut_nombre` varchar(30) NOT NULL,
  `aut_pais` varchar(30) NOT NULL,
  PRIMARY KEY  (`cod_aut`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=34 ;

-- 
-- Volcar la base de datos para la tabla `autores`
-- 

INSERT INTO `autores` VALUES (1, 'pablo neruda', 'chile');
INSERT INTO `autores` VALUES (31, 'gabriela mistral', 'chile');
INSERT INTO `autores` VALUES (32, 'amel', 'argentina');
INSERT INTO `autores` VALUES (33, 'prueba', 'prueba');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `devolucion`
-- 

CREATE TABLE `devolucion` (
  `cod_dev` int(11) NOT NULL auto_increment,
  `fechaprestamo` varchar(50) character set utf8 NOT NULL,
  `fechadevolucion` varchar(30) character set utf8 NOT NULL,
  `cod_trans` int(11) NOT NULL,
  PRIMARY KEY  (`cod_dev`),
  UNIQUE KEY `cod_trans` (`cod_dev`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=34 ;

-- 
-- Volcar la base de datos para la tabla `devolucion`
-- 

INSERT INTO `devolucion` VALUES (26, '14/6/2015    11:30', '14/6/2015    11:31', 0);
INSERT INTO `devolucion` VALUES (27, '14/6/2015    12:50', '14/6/2015    12:50', 0);
INSERT INTO `devolucion` VALUES (28, '14/6/2015    12:51', '14/6/2015    12:53', 0);
INSERT INTO `devolucion` VALUES (33, '14/6/2015    14:41', '14/6/2015    14:47', 0);

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `devolucion_transaccion`
-- 

CREATE TABLE `devolucion_transaccion` (
  `cod_dev` int(11) NOT NULL,
  `cod_trans` int(11) NOT NULL,
  PRIMARY KEY  (`cod_dev`,`cod_trans`),
  KEY `FK_devolucion_transaccions` (`cod_trans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `devolucion_transaccion`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `editoriales`
-- 

CREATE TABLE `editoriales` (
  `cod_edit` int(11) NOT NULL auto_increment,
  `editorial` varchar(30) NOT NULL,
  PRIMARY KEY  (`cod_edit`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

-- 
-- Volcar la base de datos para la tabla `editoriales`
-- 

INSERT INTO `editoriales` VALUES (1, 'santillana');
INSERT INTO `editoriales` VALUES (3, 'andres bello');
INSERT INTO `editoriales` VALUES (4, 'pedro miranda');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `libros`
-- 

CREATE TABLE `libros` (
  `cod_lib` int(11) NOT NULL auto_increment,
  `titulo` varchar(30) NOT NULL,
  `cod_edit` int(11) NOT NULL,
  `cod_aut` int(11) NOT NULL,
  PRIMARY KEY  (`cod_lib`),
  KEY `FK_libros` (`cod_edit`),
  KEY `FK_libross` (`cod_aut`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=27 ;

-- 
-- Volcar la base de datos para la tabla `libros`
-- 

INSERT INTO `libros` VALUES (1, 'papelucho', 1, 1);
INSERT INTO `libros` VALUES (24, '100 años de soledad', 3, 31);
INSERT INTO `libros` VALUES (25, 'lele', 4, 32);
INSERT INTO `libros` VALUES (26, 'premios', 4, 33);

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `libros_transacciones`
-- 

CREATE TABLE `libros_transacciones` (
  `cod_trans` int(11) NOT NULL,
  `cod_lib` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`cod_trans`,`cod_lib`),
  UNIQUE KEY `cod_lib` (`cod_lib`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `libros_transacciones`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `perfiles`
-- 

CREATE TABLE `perfiles` (
  `per_cod` int(11) NOT NULL,
  `per_nombre` varchar(20) NOT NULL,
  PRIMARY KEY  (`per_cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `perfiles`
-- 

INSERT INTO `perfiles` VALUES (1, 'usuario');
INSERT INTO `perfiles` VALUES (2, 'administrador');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `transacciones`
-- 

CREATE TABLE `transacciones` (
  `cod_trans` int(11) NOT NULL auto_increment,
  `fecha` varchar(50) NOT NULL,
  `diasprestamo` varchar(10) NOT NULL,
  `cod_lib` int(11) NOT NULL,
  `usu_rut` varchar(12) NOT NULL,
  PRIMARY KEY  (`cod_trans`),
  KEY `FK_transaccioness` (`cod_lib`),
  KEY `FK_transaccionesss` (`usu_rut`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=34 ;

-- 
-- Volcar la base de datos para la tabla `transacciones`
-- 

INSERT INTO `transacciones` VALUES (32, '14/6/2015    13:36', 'juan', 25, '18.588.399-k');
INSERT INTO `transacciones` VALUES (33, '14/6/2015    14:41', 'maicol', 26, '19.567.345-k');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `usuarios`
-- 

CREATE TABLE `usuarios` (
  `usu_rut` varchar(12) NOT NULL,
  `usu_nombre` varchar(30) NOT NULL,
  `usu_apellido` varchar(30) NOT NULL,
  `usu_direccion` varchar(50) NOT NULL,
  `usu_telefono` varchar(8) NOT NULL,
  `per_cod` int(11) default NULL,
  `usu_pass` varchar(10) NOT NULL,
  `usu_correo` varchar(30) NOT NULL,
  PRIMARY KEY  (`usu_rut`),
  KEY `FK_usuarios` (`per_cod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 
-- Volcar la base de datos para la tabla `usuarios`
-- 

INSERT INTO `usuarios` VALUES ('18.588.399-k', 'juan', 'valdebenito', 'hualañe', '56126486', NULL, 'jota2015', 'jvaldivialike@gmail.com');
INSERT INTO `usuarios` VALUES ('19.567.345-k', 'maicol', 'valderrama', 'hualañe', '45678', NULL, 'jota2016', 'jvaldivialike@gmail.com');

-- 
-- Filtros para las tablas descargadas (dump)
-- 

-- 
-- Filtros para la tabla `administradores`
-- 
ALTER TABLE `administradores`
  ADD CONSTRAINT `FK_administradores` FOREIGN KEY (`per_cod`) REFERENCES `perfiles` (`per_cod`);

-- 
-- Filtros para la tabla `devolucion_transaccion`
-- 
ALTER TABLE `devolucion_transaccion`
  ADD CONSTRAINT `FK_devolucion_transaccion` FOREIGN KEY (`cod_dev`) REFERENCES `devolucion` (`cod_dev`),
  ADD CONSTRAINT `FK_devolucion_transaccions` FOREIGN KEY (`cod_trans`) REFERENCES `transacciones` (`cod_trans`);

-- 
-- Filtros para la tabla `libros`
-- 
ALTER TABLE `libros`
  ADD CONSTRAINT `FK_libros` FOREIGN KEY (`cod_edit`) REFERENCES `editoriales` (`cod_edit`),
  ADD CONSTRAINT `FK_libross` FOREIGN KEY (`cod_aut`) REFERENCES `autores` (`cod_aut`);

-- 
-- Filtros para la tabla `libros_transacciones`
-- 
ALTER TABLE `libros_transacciones`
  ADD CONSTRAINT `FK_libros_transacciones` FOREIGN KEY (`cod_trans`) REFERENCES `transacciones` (`cod_trans`),
  ADD CONSTRAINT `FK_libros_transaccioness` FOREIGN KEY (`cod_lib`) REFERENCES `libros` (`cod_lib`);

-- 
-- Filtros para la tabla `transacciones`
-- 
ALTER TABLE `transacciones`
  ADD CONSTRAINT `FK_transaccionesss` FOREIGN KEY (`usu_rut`) REFERENCES `usuarios` (`usu_rut`);

-- 
-- Filtros para la tabla `usuarios`
-- 
ALTER TABLE `usuarios`
  ADD CONSTRAINT `FK_usuarios` FOREIGN KEY (`per_cod`) REFERENCES `perfiles` (`per_cod`);
