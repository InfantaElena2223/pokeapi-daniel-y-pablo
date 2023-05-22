package org.infantaelena.modelo.dao;

import org.infantaelena.excepciones.PokemonNotFoundException;
import org.infantaelena.excepciones.PokemonRepeatedException;
import org.infantaelena.modelo.entidades.Pokemon;
import org.opentest4j.AssertionFailedError;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PokemonImpTest {

    @org.junit.jupiter.api.Test
        /*Para poder ejecutar este test, primero hay eliminar la base de datos borrando la carpeta "data"*/
    void crear() {

        PokemonDAOImp modelo = new PokemonDAOImp("pruebas");
        try {
            modelo.crear(new Pokemon("DIGLETT", Pokemon.Clases.TIERRA, 1, 2, 3, 4));
            modelo.crear(new Pokemon("CHAMANDER", Pokemon.Clases.FUEGO, 5, 10, 24, 27));
            modelo.crear(new Pokemon("SQUIRTLE", Pokemon.Clases.AGUA, 1, 2, 3, 4));
            modelo.crear(new Pokemon("NOIVERN", Pokemon.Clases.AIRE, 1, 2, 3, 4));

        } catch (PokemonRepeatedException e) {
            System.err.println("No se ha ejecutado bien la operación");
            System.out.println("Prueba a borrar la base de datos");
            throw new AssertionFailedError();
        }

        File fichero = new File("data/pruebas.mv.db");
        fichero.delete();
    }

    @org.junit.jupiter.api.Test
        /*Para poder ejecutar este test, primero hay que consultar que exista la carpeta "data"*/
    void leerPorNombre() {
        PokemonDAOImp modelo = new PokemonDAOImp("pruebasLlena");
        try {
            Pokemon poke = modelo.leerPorNombre("DIGLETT");
            assertEquals("DIGLETT", poke.getNombre());
        } catch (PokemonNotFoundException e) {
            System.err.println("No se ha leido bien el pokémon");
            throw new AssertionFailedError();
        }
    }

    @org.junit.jupiter.api.Test
    void leerTodos() {

        PokemonDAOImp modelo = new PokemonDAOImp("pruebasLLena");
        List<Pokemon> pokemones = new ArrayList<>();
        pokemones = modelo.leerTodos();

        String texto = "";
        for (Pokemon pokemon : pokemones) {
            texto += pokemon.getNombre() + "\n";
        }
        if (pokemones.size() == 0) {
            System.err.println("No hay ningún pokémon");
        } else {
            assertEquals("CHAMANDER\nSQUIRTLE\nNOIVERN\nDIGLETT\n", texto);
        }
    }


    @org.junit.jupiter.api.Test
    void actualizar() {
        PokemonDAOImp modelo = new PokemonDAOImp("pruebasLlena");
        Pokemon pokemon = new Pokemon("DIGLETT", Pokemon.Clases.TIERRA, 10, 20, 30, 40);
        try {
            modelo.actualizar(pokemon);
            Pokemon pokemonActualizado = modelo.leerPorNombre("DIGLETT");
            assertEquals("DIGLETT", pokemonActualizado.getNombre());
            assertEquals(Pokemon.Clases.TIERRA, pokemonActualizado.getClase());
            assertEquals(10, pokemonActualizado.getVida());
            assertEquals(20, pokemonActualizado.getDefensa());
            assertEquals(30, pokemonActualizado.getAtaque());
            assertEquals(40, pokemonActualizado.getVelocidad());
        } catch (PokemonNotFoundException e) {
            System.err.println("El pokemon no se encuentra");
            throw new AssertionFailedError();
        } catch (RuntimeException e) {
            System.err.println("No se ha podido actualizar el pokemon");
            throw new AssertionFailedError();
        }
    }

    @org.junit.jupiter.api.Test
    void eliminarPorNombre() {
        PokemonDAOImp modelo = new PokemonDAOImp("PruebasLlena");
        String nombre = "DIGLETT";
        try {
            modelo.eliminarPorNombre(nombre);
            //Si llega hasta aquí, es que se ha encontrado el pokémon y se ha eliminado correctamente.
            modelo.crear(new Pokemon("DIGLETT", Pokemon.Clases.TIERRA, 1, 2, 3, 4));
        } catch (PokemonNotFoundException e) {
            System.err.println("No se ha encontrado el pokémon");
            throw new AssertionFailedError();
        } catch (PokemonRepeatedException e) {
            System.err.println("No se ha hecho la operación correctamente");
        }
    }
}