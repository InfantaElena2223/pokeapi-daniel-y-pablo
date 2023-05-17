package org.infantaelena.controlador;

import org.infantaelena.excepciones.PokemonNotFoundException;
import org.infantaelena.excepciones.PokemonRepeatedException;
import org.infantaelena.modelo.dao.PokemonDAOImp;
import org.infantaelena.modelo.entidades.Pokemon;
import org.infantaelena.vista.Vista;
import org.infantaelena.vista.Vista2;

import java.io.IOException;
import java.util.ArrayList;
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

    private Vista vista;
    private Vista2 vista2;
    private PokemonDAOImp modelo;


    public Controlador() {
        modelo = new PokemonDAOImp();
        /*OJOOO

        CAMIAR DE ORDEN
        PORFI
        PLIIIS
        -.--
        */

      /* Uso para la interfaz por comandos
      vista = new Vista();
        programa();*/
        vista2 = new Vista2();
        vista2.getTextoVida().setText("0");
        vista2.getTextoDefensa().setText("0");
        vista2.getTextoAtaque().setText("0");
        vista2.getTextoVelocidad().setText("0");

        vista2.getBoton1().addActionListener(e -> guardar());
        vista2.getBoton2().addActionListener(e-> seleccionar());
        vista2.getBoton3().addActionListener(e -> mostrarTodos());

       /* vista2.getBoton4().addActionListener(e-> eliminar());*/
        /*vista2.getBoton5().addActionListener(e-> actualizar());*/
    }

    public void añadirPokemon() {

    }
    public void seleccionar() {

        try {
            String nombre = vista2.getTfNombre().getText().trim().toUpperCase();
            Pokemon pokemon = modelo.leerPorNombre(nombre);
            if (pokemon == null) {
                vista2.mostrarVentanaError("No se ha encontrado el Pokemon");
            } else {
                vista2.mostrarVentana("El pokemon se encuentra en la base de datos");
            }
         /*   *//*Pokemon pokemon= modelo.leerPorNombre();*//*
            vista.mostrarPokemon(pokemon);*/
        } catch (PokemonNotFoundException e) {
            vista2.mostrarVentanaError("No se ha encontrado el Pokemon");
        }
    }

    private void mostrarTodos() {
        ArrayList <String> pokemones = new ArrayList<>();
        pokemones.add("pikachu");
        pokemones.add("bulbasur");
        pokemones.add("charizard");

        String texto = "";
        for (String pokemon: pokemones) {
            texto +=  pokemon+"\n";
        }

        vista2.getTextArea1().setText(texto);
    }

    private void guardar() {
        boolean correcto = false;
        System.out.println("guardando pokemon");
        String nombre = vista2.getTfNombre().getText().trim().toUpperCase();
        Pokemon.Clases clase;
        try {
         clase = Pokemon.Clases.valueOf(vista2.getTextoClase().getText().trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            vista2.mostrarVentana("La clase introducida no es válida");
            vista2.mostrarVentana("Elige entre: FUEGO, TIERRA, AIRE, AGUA, SIN_CLASE");
            return;
        }
        int vida=-1;
        int ataque=-1;
        int defensa=-1;
        int velocidad=-1;
        try {
            /*int*/ vida = Integer.valueOf(vista2.getTextoVida().getText());
            /*int*/ ataque = Integer.valueOf(vista2.getTextoAtaque().getText());
            /*int*/ defensa = Integer.valueOf(vista2.getTextoDefensa().getText());
            /*int*/ velocidad = Integer.valueOf(vista2.getTextoVelocidad().getText());
        }catch (NumberFormatException e){
          /*  vista2.mostrarVentana("Has introducido mal los datos. Solo puedes meter números");*/
        }

        if(nombre.isEmpty() || (vida<0 || vida>50) || (ataque<0 || ataque>50) || ( defensa<0 || defensa>50)|| (velocidad<0 || velocidad>50)){
            vista2.mostrarVentana("Has introducido mal los datos, no puede haber campos vacíos, y los valores numéricos " +
                    "tienen que estar entre 1 y 50");
        }
        else {
            Pokemon pokemon = new Pokemon(nombre, clase, vida, ataque, defensa, velocidad);
            try {
                modelo.crear(pokemon);
                vista2.mostrarVentana("Pokemon " + nombre + " añadido con éxito");
                vista2.getTfNombre().setText("");
            }catch (PokemonRepeatedException e){
                vista2.mostrarVentanaError("El pokemon ya existe");
            }

            // nuevo pokemon
            /*modelo.crear(nombre);*/

        }
    }

   /* public void programa() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:*//*Filtrar por tipo, *//*
                    modelo.leerTodos();
                    break;
                case 2: *//*Ver los detalles en consola, preguntar si quiere cambiar los datos*//*
                    String nombrePedidoPokemon = pedirNombre();

                    try {
                       Pokemon pokemon= modelo.leerPorNombre(nombrePedidoPokemon);
                        vista.mostrarPokemon(pokemon);
                    } catch (PokemonNotFoundException e) {
                        System.err.println("No se encuentra el Pokemon");
                    }
                    break;
                case 3:*//*Confirmación antes de borrar*//*
                    String nombreParaEliminar = pedirNombre();
                    try {
                        modelo.eliminarPorNombre(nombreParaEliminar);
                    } catch (PokemonNotFoundException e) {
                        System.err.println("No se encuentra el Pokemon");
                    }
                    break;
                case 4: *//*Cargar lista desde un CSV existente*//*
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
    }*/

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
            nombre = vista2.getTfNombre().getText().trim().toUpperCase();
            /*nombre = vista.pedirNombre();*/
            if (nombre.equals("")) {

              /*  vista2.mostrarVentana();*/
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
