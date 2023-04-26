package org.infantaelena.controlador;

import org.infantaelena.modelo.dao.PokemonDAOImp;
import org.infantaelena.vista.Vista;

/**
 * Clase que se encarga de obtener los datos de la vista
 * y enviarlos al modelo para que los procese
 *
 * @author Pablo Polo, Marcos Manzano y Daniel Ocaña
 * @version 1.0
 * @date 24/04/2023
 */


public class Controlador {

    private Vista vista;
    private PokemonDAOImp modelo;


    public Controlador() {
        vista = new Vista();
        modelo = new PokemonDAOImp();
    }

    public void programa() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    System.out.println();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
            }
        } while (opcion != 6);
    }

}
