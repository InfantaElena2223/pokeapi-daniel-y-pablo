package org.infantaelena.modelo.dao;

import org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException;
import org.infantaelena.excepciones.PokemonNotFoundException;
import org.infantaelena.excepciones.PokemonRepeatedException;
import org.infantaelena.modelo.entidades.Pokemon;

import java.sql.*;
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
        Statement statement = null;
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:h2:./data/pokeapi", "sa", "");


        } catch (SQLException e) {
            System.err.println("Error al hacer operaciones con la base de datos");
        }


        crearTablaPokeapi(connection);
        try {
//Insertar varias filas
            String insert1 = "INSERT INTO pokeapi (nombre,clase,vida,defensa,ataque,velocidad) VALUES ('Pikachu','FUEGO',0,0,0,0);";
            statement.executeUpdate(insert1);


            //Actualizar una fila
      /*      String update = "UPDATE pokeapi SET email = 'juan@yahoo.com' WHERE nombre = 'Juan';";
            statement.executeUpdate(update);*/

            //Borrar una fila
            /*String delete = "DELETE FROM pokeapi WHERE nombre = 'María';";
            statement.executeUpdate(delete);*/

            //Imprimir todo el contenido de la tabla
            String selectAll = "SELECT * FROM pokeapi;";

            ResultSet resultSet = null;
            try {
                resultSet = statement.executeQuery(selectAll);
            } catch (SQLException e) {
            }
            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String clase = resultSet.getString("clase");
                int vida = resultSet.getInt("vida");
                int defensa = resultSet.getInt("defensa");
                int ataque = resultSet.getInt("ataque");
                int velocidad = resultSet.getInt("velocidad");
                System.out.println(nombre + "\t" + clase + "\t" + vida + "\t" + defensa + "\t" + ataque + "\t" + velocidad);
            }
            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String clase = resultSet.getString("clase");
                int vida = resultSet.getInt("vida");
                int defensa = resultSet.getInt("defensa");
                int ataque = resultSet.getInt("ataque");
                int velocidad = resultSet.getInt("velocidad");
                System.out.println(nombre + "\t" + clase + "\t" + vida + "\t" + defensa + "\t" + ataque + "\t" + velocidad);
            }

            //Cerrar la conexión a la base de datos
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error al hacer operaciones con la base de datos");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void crearTablaPokeapi(Connection connection) {

        try (Statement statement = connection.createStatement()) {
            //Crear tabla
            String createTableSQL = "CREATE TABLE IF NOT EXISTS pokeapi (\n" + " nombre VARCHAR(30) PRIMARY KEY,\n" + " clase VARCHAR(20) NOT NULL,\n" + " vida INT,\n" + " defensa INT,\n" + " ataque INT,\n" + " velocidad INT\n" + ");";

            statement.execute(createTableSQL);


        } catch (JdbcSQLIntegrityConstraintViolationException e) {
            System.err.println("El pokémon ya existe");
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


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
