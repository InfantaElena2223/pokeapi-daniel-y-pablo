package org.infantaelena;

import org.infantaelena.controlador.Controlador;

import java.sql.*;

/**
 * @author Daniel Ocaña y Pablo Polo
 * @version 1.0
 * @date 24/04/2023
 */

public class Main {
    public final static String CONEXION = "jdbc:mysql://192.168.1.164/pokeapi?user=admin00&password=alumno";


    public static void main(String args[]) {
        new Controlador();


/*         Connection connection = null;
    Statement statement = null;
    try {
      Class.forName("org.h2.Driver");
      connection = DriverManager.getConnection("jdbc:h2:./data/pokeapi", "sa", "");
      statement = connection.createStatement();

      // Crear tabla
      String createTableSQL = "CREATE TABLE IF NOT EXISTS pokeapi (\n"
          + " id INTEGER PRIMARY KEY AUTO_INCREMENT,\n"
          + " nombre VARCHAR(255) NOT NULL,\n"
          + " edad INTEGER,\n"
          + " email VARCHAR(255)\n"
          + ");";
      statement.execute(createTableSQL);

      // Insertar varias filas
      String insert1 = "INSERT INTO pokeapi (nombre, edad, email) VALUES ('Juan', 25, 'juan@gmail.com');";
      statement.executeUpdate(insert1);
      String insert2 = "INSERT INTO pokeapi (nombre, edad, email) VALUES ('María', 30, 'maria@hotmail.com');";
      statement.executeUpdate(insert2);
      String insert3 = "INSERT INTO pokeapi (nombre, edad) VALUES ('Pedro', 40);";
      statement.executeUpdate(insert3);

      // Actualizar una fila
      String update = "UPDATE pokeapi SET email = 'juan@yahoo.com' WHERE nombre = 'Juan';";
      statement.executeUpdate(update);

      // Borrar una fila
      String delete = "DELETE FROM pokeapi WHERE nombre = 'María';";
      statement.executeUpdate(delete);

      // Imprimir todo el contenido de la tabla
      String selectAll = "SELECT * FROM pokeapi;";

      ResultSet resultSet = statement.executeQuery(selectAll);

      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String nombre = resultSet.getString("nombre");
        int edad = resultSet.getInt("edad");
        String email = resultSet.getString("email");
        System.out.println(id + "\t" + nombre + "\t" + edad + "\t" + email);
      }

      // Cerrar la conexión a la base de datos
      statement.close();
      connection.close();
    } catch (Exception e) {
      e.printStackTrace();
    }*/

































         /*try {
            Connection conexion = DriverManager.getConnection(CONEXION);
            Statement statement = conexion.createStatement();
            ResultSet resulset = statement.executeQuery("select * from pokeapi");

            while(resulset.next()){
                System.out.print(resulset.getString("nombre")+": ");
                System.out.println(resulset.getInt("vida"));
            }

            resulset.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());

        };*/
    }

}