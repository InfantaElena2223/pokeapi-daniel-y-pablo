package org.infantaelena.modelo.dao;

import org.infantaelena.excepciones.PokemonNotFoundException;
import org.infantaelena.excepciones.PokemonRepeatedException;
import org.infantaelena.modelo.entidades.Pokemon;

import java.util.List;

/**
 *
 * Clase que implementa los métodos de acceso a datos de la clase Pokemon
 * Esta puede hacerse mediante un fichero CSV separado por puntos y coma o una base de datos
 * @author Pablo Polo, Marcos Manzano Y Daniel Ocaña
 * @version 1.0
 * @date 24/04/2023
 *
 */
public class PokemonDAOImp implements PokemonDAO{

    @Override
    public void crear(Pokemon pokemon) throws PokemonRepeatedException {
        System.out.println("creando");
    }

    @Override
    public Pokemon leerPorNombre(String nombre) throws PokemonNotFoundException {
        System.out.println("leyendo por nombre");
        return null;
    }

    @Override
    public List<Pokemon> leerTodos() {
        System.out.println("leyendo todos");
        return null;
    }

    @Override
    public void actualizar(Pokemon pokemon) throws PokemonNotFoundException {
        System.out.println("Actualizando");
        System.out.println("heyty");

    }

    @Override
    public void eliminarPorNombre(String nombre) throws PokemonNotFoundException {
        System.out.println("eliminando por nombre");
    }
}
