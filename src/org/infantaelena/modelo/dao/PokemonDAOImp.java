package org.infantaelena.modelo.dao;

import org.infantaelena.excepciones.PokemonNotFoundException;
import org.infantaelena.excepciones.PokemonRepeatedException;
import org.infantaelena.modelo.entidades.Pokemon;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Clase que implementa los métodos de acceso a datos de la clase Pokemon
 * Esta puede hacerse mediante un fichero CSV separado por puntos y coma o una base de datos
 *
 * @author Pablo Polo, Marcos Manzano Y Daniel Ocaña
 * @version 1.0
 * @since 24/04/2023
 */
public class PokemonDAOImp implements PokemonDAO {

    /**
     * Atributo conexión para la base de datos
     */
    private Connection connection;

    /**
     * El constructor que crea la base de datos si no existe y la tabla si no existe.
     */

    public PokemonDAOImp() {
        this("pokeapi");
    }

    public PokemonDAOImp(String nombreBD) {

        try {
            connection = DriverManager.getConnection("jdbc:h2:./data/" + nombreBD, "sa", "");

        } catch (SQLException e) {
            System.err.println("Error al hacer operaciones con la base de datos");
        }

        crearTablaPokeapi();


        try (Statement statement = connection.createStatement()) {
            String selectAll = "SELECT * FROM pokeapi;";

            ResultSet resultSet = statement.executeQuery(selectAll);

        } catch (SQLException e) {
            System.err.println("Error al realizar la consulta");
        }

    }

    /**
     * Método para la creación de la tabla donde se van a guardar los pokemons
     */

    private void crearTablaPokeapi() {

        try (Statement statement = connection.createStatement()) {

            //Crear tabla
            String createTableSQL = "CREATE TABLE IF NOT EXISTS pokeapi (\n" + " nombre VARCHAR(30) PRIMARY KEY,\n" + " clase VARCHAR(20) NOT NULL,\n" + " vida INT,\n" + " defensa INT,\n" + " ataque INT,\n" + " velocidad INT\n" + ");";

            statement.execute(createTableSQL);


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Método para añadir los pokemons a la base de datos
     * Se le pasa un pokemon con todos los datos y después se añade a la base de datos
     * Puede dar una excepción si el pokemon ya existe
     *
     * @param pokemon
     * @throws PokemonRepeatedException
     */

    @Override
    public void crear(Pokemon pokemon) throws PokemonRepeatedException {
        try {
            String insert = "INSERT INTO pokeapi (nombre,clase,vida,defensa,ataque,velocidad) " +
                    "VALUES ('%s','%s',%d,%d,%d,%d);";

            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format(insert, pokemon.getNombre(), pokemon.getClase(),
                    pokemon.getVida(), pokemon.getDefensa(), pokemon.getAtaque(), pokemon.getVelocidad()));
        } catch (SQLException e) {
            throw new PokemonRepeatedException("El pokémon ya existe");

        }
    }

    /**
     * Método para leer un pokemon por nombre y devolver los datos del pokemon
     *
     * @param nombrePokemon
     * @return un pokemon entero con todos sus datos
     * @throws PokemonNotFoundException
     */

    @Override
    public Pokemon leerPorNombre(String nombrePokemon) throws PokemonNotFoundException {
        int contadorFilas = 0;
        Pokemon pokemon = null;
        try (Statement statement = connection.createStatement()) {
            String selectPokemon = "SELECT * FROM pokeapi where nombre='" + nombrePokemon + "';";

            ResultSet resultSet = statement.executeQuery(selectPokemon);

            while (resultSet.next()) {
                pokemon = new Pokemon();
                pokemon.setNombre(resultSet.getString("nombre"));
                pokemon.setClase(Pokemon.Clases.valueOf(resultSet.getString("clase")));
                pokemon.setVida(resultSet.getInt("vida"));
                pokemon.setDefensa(resultSet.getInt("defensa"));
                pokemon.setAtaque(resultSet.getInt("ataque"));
                pokemon.setVelocidad(resultSet.getInt("velocidad"));
                contadorFilas++;
            }
        } catch (SQLException e) {
            throw new PokemonNotFoundException("Error al realizar la consulta: " + e.getMessage());
        }
        if (contadorFilas == 0) {
            throw new PokemonNotFoundException("Error al realizar la consulta");
        }
        return pokemon;
    }

    /**
     * Método para leer todos los pokemons
     *
     * @return todos los pokemons de la base de datos
     */
    @Override
    public List<Pokemon> leerTodos() {
        List<Pokemon> pokemones = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String selectAll = "SELECT * FROM pokeapi;";


            ResultSet resultSet = statement.executeQuery(selectAll);

            while (resultSet.next()) {
                Pokemon pokemin = new Pokemon();
                String nombre = resultSet.getString("nombre");
                String clase = resultSet.getString("clase");
                int vida = resultSet.getInt("vida");
                int defensa = resultSet.getInt("defensa");
                int ataque = resultSet.getInt("ataque");
                int velocidad = resultSet.getInt("velocidad");
                pokemin.setNombre(nombre);
                pokemin.setClase(Pokemon.Clases.valueOf(clase));
                pokemin.setVida(vida);
                pokemin.setDefensa(defensa);
                pokemin.setAtaque(ataque);
                pokemin.setVelocidad(velocidad);
                pokemones.add(pokemin);

            }
        } catch (SQLException e) {
            System.err.println("Error al realizar la consulta");
        }

        return pokemones;
    }

    /**
     * Método para mostrar todos los pokemons de una clase pasada como parámetro
     *
     * @param clase
     * @return todos los pokemons de una clase en concreto
     * @throws RuntimeException
     */

    public List<Pokemon> leerPorClase(String clase) throws RuntimeException {
        List<Pokemon> pokemones = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String selectPokemon = "SELECT * FROM pokeapi where clase='" + clase + "';";

            ResultSet resultSet = statement.executeQuery(selectPokemon);

            while (resultSet.next()) {
                Pokemon pokemon = new Pokemon();
                pokemon.setNombre(resultSet.getString("nombre"));
                pokemon.setClase(Pokemon.Clases.valueOf(resultSet.getString("clase")));
                pokemon.setVida(resultSet.getInt("vida"));
                pokemon.setDefensa(resultSet.getInt("defensa"));
                pokemon.setAtaque(resultSet.getInt("ataque"));
                pokemon.setVelocidad(resultSet.getInt("velocidad"));
                pokemones.add(pokemon);

            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return pokemones;
    }

    /**
     * Método para actualizar un pokemon
     *
     * @param pokemon
     * @throws PokemonNotFoundException
     */

    @Override
    public void actualizar(Pokemon pokemon) throws PokemonNotFoundException {
        int contadorFilas = 0;
        try (Statement statement = connection.createStatement()) {
            String selectPokemon = "SELECT * FROM pokeapi where nombre='" + pokemon.getNombre() + "';";

            ResultSet resultSet = statement.executeQuery(selectPokemon);
            while (resultSet.next()) {
                //Para que nos de la excepción si no existe ningún pokémon con ese nombre
                contadorFilas++;

            }
            if (contadorFilas == 0) {
                throw new PokemonNotFoundException("Error al realizar la consulta");
            } else {
                String update = "UPDATE pokeapi SET nombre='" + pokemon.getNombre() + "'," +
                        "clase='" + pokemon.getClase() + "',vida='" + pokemon.getVida() + "'," +
                        "defensa='" + pokemon.getDefensa() + "',ataque='" + pokemon.getAtaque() +
                        "',velocidad='" + pokemon.getVelocidad() +
                        "'  WHERE nombre='" + pokemon.getNombre() + "';";
                statement.executeUpdate(update);
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    /**
     * Método para eliminar un pokemon
     *
     * @param nombre
     * @throws PokemonNotFoundException
     */
    @Override
    public void eliminarPorNombre(String nombre) throws PokemonNotFoundException {
        int contadorFilas = 0;
        try (Statement statement = connection.createStatement()) {
            String selectPokemon = "SELECT * FROM pokeapi where nombre='" + nombre + "';";

            ResultSet resultSet = null;

            resultSet = statement.executeQuery(selectPokemon);
            while (resultSet.next()) {
                //Para que nos de la excepción si no existe ningún pokémon con ese nombre
                contadorFilas++;

            }
            if (contadorFilas == 0) {
                throw new PokemonNotFoundException("Error al realizar la consulta");
            } else {
                String deletePokemon = "DELETE FROM pokeapi where nombre='" + nombre + "';";
                statement.executeUpdate(deletePokemon);
            }

        } catch (SQLException e) {
            throw new PokemonNotFoundException("No se ha encontrado el pokémon");
        }

    }
}
