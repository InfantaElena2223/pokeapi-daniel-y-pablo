package org.infantaelena;

import org.infantaelena.controlador.Controlador;

/**
 * @author Daniel Ocaña y Pablo Polo
 * @version 1.0
 * @date 24/04/2023
 */

public class Main {
    public final static String CONEXION = "jdbc:mysql://192.168.1.164/pokeapi?user=admin00&password=alumno";


    public static void main(String args[]) {
          new Controlador();


      /*  Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:./data/pokeapi", "sa", "");
            statement = connection.createStatement();

            // Crear tabla
            String createTableSQL = "CREATE TABLE IF NOT EXISTS pokeapi (\n"
                    + " nombre VARCHAR(30) PRIMARY KEY,\n"
                    + " clase VARCHAR(20) NOT NULL,\n"
                    + " vida INT,\n"
                    + " defensa INT,\n"
                    + " ataque INT,\n"
                    + " velocidad INT\n"
                    + ");";

            statement.execute(createTableSQL);

            try {
                // Insertar varias filas
                String insert1 = "INSERT INTO pokeapi (nombre,clase,vida,defensa,ataque,velocidad) VALUES ('Pikachu','FUEGO',0,0,0,0);";
                statement.executeUpdate(insert1);
            } catch (JdbcSQLIntegrityConstraintViolationException e) {
                System.err.println("El pokémon ya existe");
            }

          *//*  String insert2 = "INSERT INTO pokeapi (nombre, edad, email) VALUES ('María', 30, 'maria@hotmail.com');";
            statement.executeUpdate(insert2);
            String insert3 = "INSERT INTO pokeapi (nombre, edad) VALUES ('Pedro', 40);";
            statement.executeUpdate(insert3);

            // Actualizar una fila
            String update = "UPDATE pokeapi SET email = 'juan@yahoo.com' WHERE nombre = 'Juan';";
            statement.executeUpdate(update);

            // Borrar una fila
            String delete = "DELETE FROM pokeapi WHERE nombre = 'María';";
            statement.executeUpdate(delete);*//*
            // Imprimir todo el contenido de la tabla
            String selectAll = "SELECT * FROM pokeapi;";

            ResultSet resultSet = statement.executeQuery(selectAll);
            while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String clase = resultSet.getString("clase");
                int vida = resultSet.getInt("vida");
                int defensa = resultSet.getInt("defensa");
                int ataque = resultSet.getInt("ataque");
                int velocidad = resultSet.getInt("velocidad");
                System.out.println(nombre + "\t" + clase + "\t" + vida + "\t" + defensa+ "\t" + ataque+ "\t" + velocidad);
            }
         *//*   while (resultSet.next()) {
                String nombre = resultSet.getString("nombre");
                String clase = resultSet.getString("clase");
                int vida = resultSet.getInt("vida");
                int defensa = resultSet.getInt("defensa");
                int ataque = resultSet.getInt("ataque");
                int velocidad = resultSet.getInt("velocidad");
                System.out.println(nombre + "\t" + clase + "\t" + vida + "\t" + defensa+ "\t" + ataque+ "\t" + velocidad);
            }*//*

             Cerrar la conexión a la base de datos
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