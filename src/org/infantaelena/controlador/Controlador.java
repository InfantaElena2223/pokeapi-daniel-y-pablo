package org.infantaelena.controlador;

import org.infantaelena.excepciones.PokemonNotFoundException;
import org.infantaelena.excepciones.PokemonRepeatedException;
import org.infantaelena.modelo.dao.PokemonDAOImp;
import org.infantaelena.modelo.entidades.Pokemon;
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
        programa();
    }

    public void programa() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:/*Filtrar por tipo, */
                    modelo.leerTodos();
                    break;
                case 2: /*Ver los detalles en consola, preguntar si quiere cambiar los datos*/
                    String nombrePedidoPokemon = vista.pedirNombre();

                    try {
                        modelo.leerPorNombre(nombrePedidoPokemon);
                    } catch (PokemonNotFoundException e) {
                        System.err.println("No se encuentra el Pokemon");
                    }
                    break;
                case 3:/*Confirmación antes de borrar*/
                    String nombreParaEliminar = vista.pedirNombre();
                    try {
                        modelo.eliminarPorNombre(nombreParaEliminar);
                    } catch (PokemonNotFoundException e) {
                        System.err.println("No se encuentra el Pokemon");
                    }
                   break;
                case 4: /*Cargar lista desde un CSV existente*/
                    Pokemon pokeParaActualizar= vista.pedirPokemon();
                    try {
                        modelo.actualizar(pokeParaActualizar);
                    } catch (PokemonNotFoundException e) {
                        System.err.println("El pokemon no se encuentra");
                    }
                    break;
                case 5:
                    Pokemon poke= vista.pedirPokemon();
                    try {
                        modelo.crear(poke);
                    } catch (PokemonRepeatedException e) {
                        System.err.println("El pokemon ya existe");
                    }
                    break;
            }
        } while (opcion != 6);
    }

}
