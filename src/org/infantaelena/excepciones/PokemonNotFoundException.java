package org.infantaelena.excepciones;

/**
 * Esta clase se encarga de lanzar una excepción cuando no se encuentra un pokemon
 *
 * @author Pablo Polo, Marcos Manzano y Daniel Ocaña
 * @version 1.0
 * @since 24/04/2023
 */
public class PokemonNotFoundException extends Exception {
    /**
     * Método para generar un texto cuando se da este tipo de error
     * Se llama desde otras clases
     */
    public PokemonNotFoundException(String texto) {
        super(texto);
    }
}
