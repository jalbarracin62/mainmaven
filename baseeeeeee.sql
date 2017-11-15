
use UserDB;

CREATE TABLE UserDB.`users` 
(
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`userid`)
);

CREATE TABLE UserDB.`video` 
(
  `idvideo` int(11) NOT NULL AUTO_INCREMENT,
 `fkseries` int(11) DEFAULT NULL ,
  `titulo` varchar(45) DEFAULT NULL,
  `director` varchar(45) DEFAULT NULL,
  
  `dob` date DEFAULT NULL,
  `genero` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idvideo`)
  
  
);
CREATE TABLE UserDB.`series` 
(
  `idseries` int(11) NOT NULL AUTO_INCREMENT,
 
  `nocapitulo` int(11) DEFAULT NULL,
  `temporadas` int(11) DEFAULT NULL,
 
  PRIMARY KEY (`idseries`)
  
  
);