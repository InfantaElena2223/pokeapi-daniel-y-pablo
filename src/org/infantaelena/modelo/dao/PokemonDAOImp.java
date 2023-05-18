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
 * @date 24/04/2023
 */
public class PokemonDAOImp implements PokemonDAO {
    /*public final static String CONEXION = "jdbc:mysql://192.168.1.164/pokeapi?user=admin00&password=alumno";*/
    private Connection connection;

    public PokemonDAOImp() {

        try {
            connection = DriverManager.getConnection("jdbc:h2:./data/pokeapi", "sa", "");

        } catch (SQLException e) {
            System.err.println("Error al hacer operaciones con la base de datos");
        }

        crearTablaPokeapi();

//Insertar varias filas
           /* try{
                String insert1 = "INSERT INTO pokeapi (nombre,clase,vida,defensa,ataque,velocidad) VALUES ('Pikachu','FUEGO',0,0,0,0);";
                statement.executeUpdate(insert1);
            }catch (JdbcSQLIntegrityConstraintViolationException e) {
                System.err.println("El pokémon ya existe");
            }*/

        //Actualizar una fila
      /*      String update = "UPDATE pokeapi SET email = 'juan@yahoo.com' WHERE nombre = 'Juan';";
            statement.executeUpdate(update);*/

        //Borrar una fila
            /*String delete = "DELETE FROM pokeapi WHERE nombre = 'María';";
            statement.executeUpdate(delete);*/

        //Imprimir todo el contenido de la tabla
        try (Statement statement = connection.createStatement()) {
            String selectAll = "SELECT * FROM pokeapi;";

            ResultSet resultSet = null;

            resultSet = statement.executeQuery(selectAll);

            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String clase = resultSet.getString("clase");
                int vida = resultSet.getInt("vida");
                int defensa = resultSet.getInt("defensa");
                int ataque = resultSet.getInt("ataque");
                int velocidad = resultSet.getInt("velocidad");
                System.out.println(nombre + "\t" + clase + "\t" + vida + "\t" + defensa + "\t" + ataque + "\t" + velocidad);
            }
        } catch (SQLException e) {
            System.err.println("Error al realizar la consulta");
        }
        //Cerrar la conexión a la base de datos
     /*   statement.close();
        connection.close();*/
    /*} catch(SQLException e){
        System.err.println("Error al hacer operaciones con la base de datos");
    } catch(Exception e){
        e.printStackTrace();
    }*/
    }

    private void crearTablaPokeapi() {

        try (Statement statement = connection.createStatement()) {

            //Crear tabla
            String createTableSQL = "CREATE TABLE IF NOT EXISTS pokeapi (\n" + " nombre VARCHAR(30) PRIMARY KEY,\n" + " clase VARCHAR(20) NOT NULL,\n" + " vida INT,\n" + " defensa INT,\n" + " ataque INT,\n" + " velocidad INT\n" + ");";

            statement.execute(createTableSQL);


        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


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
            /*System.err.println("El pokémon ya existe");*/
        }

    }


    @Override
    public Pokemon leerPorNombre(String nombrePokemon) throws PokemonNotFoundException {
        int contadorFilas = 0;
        Pokemon pokemon = null;
        try (Statement statement = connection.createStatement()) {
            String selectPokemon = "SELECT * FROM pokeapi where nombre='" + nombrePokemon + "';";

            ResultSet resultSet = null;

            resultSet = statement.executeQuery(selectPokemon);

            while (resultSet.next()) {
                pokemon = new Pokemon();
                pokemon.setNombre(resultSet.getString("nombre"));
                pokemon.setClase(Pokemon.Clases.valueOf(resultSet.getString("clase")));
                pokemon.setVida(resultSet.getInt("vida"));
                pokemon.setDefensa(resultSet.getInt("defensa"));
                pokemon.setAtaque(resultSet.getInt("ataque"));
                pokemon.setVelocidad(resultSet.getInt("velocidad"));
                contadorFilas++;
                //  System.out.println(nombre + "\t" + clase + "\t" + vida + "\t" + defensa + "\t" + ataque + "\t" + velocidad);
            }
        } catch (SQLException e) {
            throw new PokemonNotFoundException("Error al realizar la consulta: " + e.getMessage());
        }
        if (contadorFilas == 0) {
            throw new PokemonNotFoundException("Error al realizar la consulta");
        }
        return pokemon;
        /* try {
            String insert = "INSERT INTO pokeapi (nombre,clase,vida,defensa,ataque,velocidad) " +
                    "VALUES ('%s','%s',%d,%d,%d,%d);";

            Statement statement = connection.createStatement();
            statement.executeUpdate(String.format(insert, pokemon.getNombre(), pokemon.getClase(),
                    pokemon.getVida(), pokemon.getDefensa(), pokemon.getAtaque(), pokemon.getVelocidad()));
        } catch (SQLException e) {
            System.err.println("El pokémon ya existe");
        }
        System.out.println("leyendo por nombre");*/
    }

    @Override
    public List<Pokemon> leerTodos() {
        System.out.println("leyendo todos");
        List<Pokemon> pokemones = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String selectAll = "SELECT * FROM pokeapi;";

            ResultSet resultSet = null;

            resultSet = statement.executeQuery(selectAll);

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
                /*System.out.println(nombre + "\t" + clase + "\t" + vida + "\t" + defensa + "\t" + ataque + "\t" + velocidad); */
            }
        } catch (SQLException e) {
            System.err.println("Error al realizar la consulta");
        }

        return pokemones;
    }


    public List<Pokemon> leerPorClase(String clase) throws RuntimeException {
        List<Pokemon> pokemones = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            String selectPokemon = "SELECT * FROM pokeapi where clase='" + clase + "';";

            ResultSet resultSet = null;

            resultSet = statement.executeQuery(selectPokemon);

            while (resultSet.next()) {
                Pokemon pokemon = new Pokemon();
                pokemon.setNombre(resultSet.getString("nombre"));
                pokemon.setClase(Pokemon.Clases.valueOf(resultSet.getString("clase")));
                pokemon.setVida(resultSet.getInt("vida"));
                pokemon.setDefensa(resultSet.getInt("defensa"));
                pokemon.setAtaque(resultSet.getInt("ataque"));
                pokemon.setVelocidad(resultSet.getInt("velocidad"));
                pokemones.add(pokemon);
                //  System.out.println(nombre + "\t" + clase + "\t" + vida + "\t" + defensa + "\t" + ataque + "\t" + velocidad);
            }
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        /*pokemones.add()*/
        return pokemones;
    }

    @Override
    public void actualizar(Pokemon pokemon) throws PokemonNotFoundException {
        int contadorFilas=0;
        try (Statement statement = connection.createStatement()) {
            String selectPokemon = "SELECT * FROM pokeapi where nombre='" + pokemon.getNombre() + "';";

            ResultSet resultSet = null;

            resultSet = statement.executeQuery(selectPokemon);
            while (resultSet.next()) {
                //Para que nos de la excepción si no existe ningún pokémon con ese nombre
                contadorFilas++;

            }
            if (contadorFilas == 0) {
                throw new PokemonNotFoundException("Error al realizar la consulta");
            } else {
                String update = "UPDATE pokeapi SET nombre = '" + pokemon.getNombre() + "'," +
                        "clase = '" + pokemon.getClase() + "',vida = '" + pokemon.getVida() + "'," +
                        "defensa = '" + pokemon.getDefensa() + "',ataque = '" + pokemon.getAtaque() +
                        "',velocidad = '" + pokemon.getVelocidad() + "'," +
                        "  WHERE nombre = '" + pokemon.getNombre() + "';";
                statement.executeUpdate(update);
            }

        } catch (SQLException e) {
            throw new RuntimeException();
        }
        /*if (contadorfilas==0){

        }*/
        System.out.println("Actualizando");
        System.out.println("heyty");
    }

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

            /*           ResultSet resultSet = null;*/

        } catch (SQLException e) {
            throw new PokemonNotFoundException("No se ha encontrado el pokémon");
        }

    }
}
