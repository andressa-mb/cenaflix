create database cenaflixBd;

use cenaflixBd;

CREATE TABLE `filmes` (
  `id` int(11) NOT NULL auto_increment,
  `nome` varchar(150) NOT NULL,
  `datalancamento` date NOT NULL,
  `categoria` varchar(100) NOT NULL,
  primary key (id)
);

SELECT * from filmes;
