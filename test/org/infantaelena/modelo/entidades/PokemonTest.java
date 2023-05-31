package org.infantaelena.modelo.entidades;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {
    @org.junit.jupiter.api.Test
    void testConstructorPorDefecto() {
        Pokemon pokemon = new Pokemon();
        assertEquals("",pokemon.getNombre());
        assertEquals(Pokemon.Clases.SIN_CLASE,pokemon.getClase());
        assertEquals(0,pokemon.getVida());
        assertEquals(0,pokemon.getDefensa());
        assertEquals(0,pokemon.getAtaque());
        assertEquals(0,pokemon.getVelocidad());
    }

    @org.junit.jupiter.api.Test
    void testConstructorConAtributos() {
        Pokemon pokemon = new Pokemon(null, Pokemon.Clases.SIN_CLASE,-5,55,10,-32);
        assertEquals("",pokemon.getNombre());
        assertEquals(Pokemon.Clases.SIN_CLASE,pokemon.getClase());
        assertEquals(0,pokemon.getVida());
        assertEquals(50,pokemon.getDefensa());
        assertEquals(10,pokemon.getAtaque());
        assertEquals(0,pokemon.getVelocidad());
    }

    @org.junit.jupiter.api.Test
    void setNombre() {
        Pokemon pokemon = new Pokemon(null, Pokemon.Clases.SIN_CLASE,-5,55,10,-32);
        assertEquals("",pokemon.getNombre());
        pokemon.setNombre(null);
        assertEquals("",pokemon.getNombre());
        pokemon.setNombre("    pikachu    ");
        assertEquals("PIKACHU",pokemon.getNombre());
    }
    @org.junit.jupiter.api.Test
    void setClase() {
        Pokemon pokemon = new Pokemon(null, Pokemon.Clases.SIN_CLASE,-5,55,10,-32);
        assertEquals(Pokemon.Clases.SIN_CLASE,pokemon.getClase());
        pokemon.setClase(Pokemon.Clases.AIRE);
        assertEquals(Pokemon.Clases.AIRE,pokemon.getClase());


    }
    @org.junit.jupiter.api.Test
    void setVida() {
        Pokemon pokemon = new Pokemon();
        assertEquals(0, pokemon.getVida());
        pokemon.setVida(-39);
        assertEquals(0, pokemon.getVida());
        pokemon.setVida(Pokemon.MAX_VALORES_NUMERICOS+90);
        assertEquals(Pokemon.MAX_VALORES_NUMERICOS,pokemon.getVida());
        pokemon.setVida(90);
        assertEquals(Pokemon.MAX_VALORES_NUMERICOS,pokemon.getVida());
        pokemon.setVida(20);
        assertEquals(20,pokemon.getVida());
    }
    @org.junit.jupiter.api.Test
    void setDefensa() {
        Pokemon pokemon = new Pokemon();
        assertEquals(0, pokemon.getDefensa());
        pokemon.setDefensa(-1);
        assertEquals(0, pokemon.getDefensa());
        pokemon.setDefensa(Pokemon.MAX_VALORES_NUMERICOS+10);
        assertEquals(Pokemon.MAX_VALORES_NUMERICOS,pokemon.getDefensa());
        pokemon.setDefensa(60);
        assertEquals(Pokemon.MAX_VALORES_NUMERICOS,pokemon.getDefensa());
        pokemon.setDefensa(25);
        assertEquals(25,pokemon.getDefensa());
    }
    @org.junit.jupiter.api.Test
    void setAtaque() {
        Pokemon pokemon = new Pokemon();
        assertEquals(0, pokemon.getAtaque());
        pokemon.setAtaque(-39);
        assertEquals(0, pokemon.getAtaque());
        pokemon.setAtaque(Pokemon.MAX_VALORES_NUMERICOS+90);
        assertEquals(Pokemon.MAX_VALORES_NUMERICOS,pokemon.getAtaque());
        pokemon.setAtaque(90);
        assertEquals(Pokemon.MAX_VALORES_NUMERICOS,pokemon.getAtaque());
        pokemon.setAtaque(20);
        assertEquals(20,pokemon.getAtaque());
    }
    @org.junit.jupiter.api.Test
    void setVelocidad() {
        Pokemon pokemon = new Pokemon();
        assertEquals(0, pokemon.getVelocidad());
        pokemon.setVelocidad(-39);
        assertEquals(0, pokemon.getVelocidad());
        pokemon.setVelocidad(Pokemon.MAX_VALORES_NUMERICOS+90);
        assertEquals(Pokemon.MAX_VALORES_NUMERICOS,pokemon.getVelocidad());
        pokemon.setVelocidad(90);
        assertEquals(Pokemon.MAX_VALORES_NUMERICOS,pokemon.getVelocidad());
        pokemon.setVelocidad(20);
        assertEquals(20,pokemon.getVelocidad());
    }

    @org.junit.jupiter.api.Test
    void textToString() {
        Pokemon pokemon = new Pokemon(null, Pokemon.Clases.SIN_CLASE,-5,55,10,-32);
        assertEquals("Pokemon{nombre='', clase=SIN_CLASE, vida=0, defensa=50, ataque=10, velocidad=0}",pokemon.toString());
        pokemon.setAtaque(25);
        assertEquals("Pokemon{nombre='', clase=SIN_CLASE, vida=0, defensa=50, ataque=25, velocidad=0}",pokemon.toString());
        pokemon.setVida(-2);
        assertEquals("Pokemon{nombre='', clase=SIN_CLASE, vida=0, defensa=50, ataque=25, velocidad=0}",pokemon.toString());
        pokemon.setNombre(null);
        assertEquals("Pokemon{nombre='', clase=SIN_CLASE, vida=0, defensa=50, ataque=25, velocidad=0}",pokemon.toString());
        pokemon.setDefensa(66);
        assertEquals("Pokemon{nombre='', clase=SIN_CLASE, vida=0, defensa=50, ataque=25, velocidad=0}",pokemon.toString());
        pokemon.setClase(Pokemon.Clases.FUEGO);
        assertEquals("Pokemon{nombre='', clase=FUEGO, vida=0, defensa=50, ataque=25, velocidad=0}",pokemon.toString());

    }
}