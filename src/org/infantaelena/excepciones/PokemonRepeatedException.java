package org.infantaelena.excepciones;

/**
 *
 * Esta clase se encarga de lanzar una excepción cuando se intenta añadir un pokemon repetido
 * @author Pablo Polo, Marcos Manzano y Daniel Ocaña
 * @version 1.0
 * @date 24/04/2023
 *
 */
public class PokemonRepeatedException extends Exception{
    public  PokemonRepeatedException(String texto) {
        super(texto);
    }
}
