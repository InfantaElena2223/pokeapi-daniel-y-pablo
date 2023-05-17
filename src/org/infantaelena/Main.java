package org.infantaelena;

import org.infantaelena.controlador.Controlador;
import org.infantaelena.vista.Vista;
import org.infantaelena.vista.Vista2;

import javax.swing.plaf.basic.BasicScrollPaneUI;

/**
 * @author Daniel Ocaña y Pablo Polo
 * @version 1.0
 * @date 24/04/2023
 */

public class Main {



    public static void main(String args[]) {

          new Controlador();

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