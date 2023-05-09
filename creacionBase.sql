drop database if exists pokeapi;
create database if not exists pokeapi;
use pokeapi;
create table pokeapi(
    nombre varchar(30),
    clase varchar(10),
    vida int,
    defensa int,
    ataque int,
    velocidad int
);
insert into pokeapi values ("hola","hola",0,0,0,0);
select * from pokeapi;
describe pokeapi;