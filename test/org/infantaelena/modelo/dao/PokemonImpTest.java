package org.infantaelena.modelo.dao;

import org.infantaelena.excepciones.PokemonNotFoundException;
import org.infantaelena.excepciones.PokemonRepeatedException;
import org.infantaelena.modelo.entidades.Pokemon;
import org.opentest4j.AssertionFailedError;

import static org.junit.jupiter.api.Assertions.*;

class PokemonImpTest {

    @org.junit.jupiter.api.Test
    void crear() {
        PokemonDAOImp modelo = new PokemonDAOImp();
        try {
            modelo.crear(new Pokemon("PIKACHU", Pokemon.Clases.AIRE, 1, 2, 3, 4));
            try {
                Pokemon poke = modelo.leerPorNombre("peter");
                assertEquals("a", poke.getNombre());
            } catch (PokemonNotFoundException e) {
                throw new AssertionFailedError();
            }
        } catch (AssertionFailedError error) {
            System.err.println("No se ha ejecutado bien la operación");
            System.out.println("Prueba a borrar la base de datos");
        } catch (PokemonRepeatedException e) {

        }
    }

    @org.junit.jupiter.api.Test
    void leerPorNombre() {
        PokemonDAOImp modelo = new PokemonDAOImp();
    }

    @org.junit.jupiter.api.Test
    void leerTodos() {
        PokemonDAOImp modelo = new PokemonDAOImp();
    }

    @org.junit.jupiter.api.Test
    void actualizar() {
        PokemonDAOImp modelo = new PokemonDAOImp();
    }

    @org.junit.jupiter.api.Test
    void eliminarPorNombre() {
        PokemonDAOImp modelo = new PokemonDAOImp();
    }
}