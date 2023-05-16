package org.infantaelena.controlador;

import org.infantaelena.excepciones.PokemonNotFoundException;
import org.infantaelena.excepciones.PokemonRepeatedException;
import org.infantaelena.modelo.dao.PokemonDAOImp;
import org.infantaelena.modelo.entidades.Pokemon;
import org.infantaelena.vista.Vista;

import java.util.InputMismatchException;

/**
 * Clase que se encarga de obtener los datos de la vista
 * y enviarlos al modelo para que los procese
 *
 * @author Pablo Polo, Marcos Manzano y Daniel Ocaña
 * @version 1.0
 * @date 24/04/2023
 */


public class Controlador {

    public Vista vista;
    public PokemonDAOImp modelo;


    public Controlador() {
        modelo = new PokemonDAOImp();/*OJOOO

        CAMIAR DE ORDEN
        PORFI
        PLIIIS
        -.--
        */
        vista = new Vista();
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
                    String nombrePedidoPokemon = pedirNombre();

                    try {
                        modelo.leerPorNombre(nombrePedidoPokemon);
                    } catch (PokemonNotFoundException e) {
                        System.err.println("No se encuentra el Pokemon");
                    }
                    break;
                case 3:/*Confirmación antes de borrar*/
                    String nombreParaEliminar = pedirNombre();
                    try {
                        modelo.eliminarPorNombre(nombreParaEliminar);
                    } catch (PokemonNotFoundException e) {
                        System.err.println("No se encuentra el Pokemon");
                    }
                    break;
                case 4: /*Cargar lista desde un CSV existente*/
                    Pokemon pokeParaActualizar = pedirPokemon();
                    try {
                        modelo.actualizar(pokeParaActualizar);
                    } catch (PokemonNotFoundException e) {
                        System.err.println("El pokemon no se encuentra");
                    }
                    break;
                case 5:
                    Pokemon poke = pedirPokemon();
                    try {
                        modelo.crear(poke);
                    } catch (PokemonRepeatedException e) {
                        System.err.println("El pokemon ya existe");
                    }
                    break;
            }
        } while (opcion != 6);
    }

    public Pokemon pedirPokemon() {

        String nombreNuevoPokemon = pedirNombre();
        Pokemon.Clases clase = pedirClase();
        int vida = pedirVida();
        int defensa = pedirDefensa();
        int ataque = pedirAtaque();
        int velocidad = pedirVelocidad();
        Pokemon poke = new Pokemon(nombreNuevoPokemon, clase, vida, defensa, ataque, velocidad);
        return poke;
    }

    public String pedirNombre() {

        String nombre;
        do {
            nombre = vista.pedirNombre();
            if (nombre.equals("")) {
                vista.imprimirError();
            }
        } while (nombre.equals("")/*nombre.equals("\n")*/);

        return nombre;
    }

    public Pokemon.Clases pedirClase() {
        Pokemon.Clases clase = Pokemon.Clases.SIN_CLASE;
        try {
            clase = vista.pedirClase();
        } catch (IllegalArgumentException e) {
            vista.imprimirError();
            pedirClase();
        }
        return clase;
    }

    public int pedirVida() {
        int vida = -1;
        do {
            try {
                vida = vista.pedirVida(vida);
                if (vida < 0 || vida > 50) {
                    vista.imprimirError();
                }
            } catch (InputMismatchException e) {
                vista.imprimirError();
                vida = -2;
             /*   sc.nextLine();*/
            }
        } while (vida < 0 || vida > 50);
        return vida;
    }


    public int pedirAtaque() {
        int ataque = -1;
        do {
            try {
                ataque = vista.pedirAtaque(ataque);
                if (ataque < 0 || ataque > 50) {
                    vista.imprimirError();
                }
            } catch (InputMismatchException e) {
                vista.imprimirError();

                ataque = -2;
                /*sc.nextLine();*/
            }
        } while (ataque < 0 || ataque > 50);
        return ataque;
    }

    public int pedirDefensa() {
        int defensa = -1;
        do {
            try {
                defensa = vista.pedirDefensa(defensa);
                if (defensa < 0 || defensa > 50) {
                    vista.imprimirError();
                }
            } catch (InputMismatchException e) {
                vista.imprimirError();
                  defensa = -2;
                /*sc.nextLine();*/
            }
        } while (defensa < 0 || defensa > 50);
        return defensa;
    }

    public int pedirVelocidad() {
        int velocidad = -1;
        do {
            try {
                velocidad = vista.pedirVelocidad(velocidad);
                if (velocidad < 0 || velocidad > 50) {
                    vista.imprimirError();
                }
            } catch (InputMismatchException e) {
                vista.imprimirError();
                  velocidad = -2;
                /*sc.nextLine();*/
            }
        } while (velocidad < 0 || velocidad > 50);
        return velocidad;
    }
}
