package org.infantaelena.vista;

import org.infantaelena.modelo.entidades.Pokemon;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase que representa la vista de la aplicación
 * Implementar con menus de texto o con interfaz gráfica
 *
 * @author Daniel Ocaña, Marcos Manzano y Pablo Polo
 * @version 1.0
 * @date 24/04/2023
 */
public class Vista {
    public Vista() {

    }

    static Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("Elige una opción del 1 al 6 entre las siguientes");

        System.out.println("1. Lista de todos los Pokemon");

        System.out.println("2. Seleccionar un Pokemon");

        System.out.println("3. Eliminar un Pokemon");

        System.out.println("4. Actualizar los Pokemon");/*Actualizar desde el CSV pokemon ya añadido*/

        System.out.println("5. Añadir un Pokemon");/*Añadir al CSV*/

        System.out.println("6. Salir");
        int opcion = sc.nextInt();
        sc.nextLine();
        return opcion;
    }

    /*public Pokemon pedirPokemon() {
        String nombreNuevoPokemon = pedirNombre();
        Pokemon.Clases clase = pedirClase();
        int vida = pedirVida();
        int defensa = pedirDefensa();
        int ataque = pedirAtaque();
        int velocidad = pedirVelocidad();
        Pokemon poke = new Pokemon(nombreNuevoPokemon, clase, vida, defensa, ataque, velocidad);
        return poke;
    }*/

    public String pedirNombre() {
        System.out.print("Introduce el nombre: ");
        String nombre;

        nombre = sc.nextLine();


        return nombre;
    }

    public Pokemon.Clases pedirClase() throws IllegalArgumentException {

        Pokemon.Clases clase;
        System.out.println("Introduce la clase");
        System.out.print("Opciones disponibles [SIN_CLASE,FUEGO, TIERRA, AIRE, AGUA]: ");

        String textoClase = sc.nextLine().toUpperCase();

        clase = Pokemon.Clases.valueOf(textoClase);

        return clase;
    }

    public int pedirVida(int vida)  throws InputMismatchException{
        System.out.print("Introduce la vida: ");

     if (vida==-1){
         vida = sc.nextInt();
     } else{
         sc.nextLine();
         vida = sc.nextInt();
     }

 /*       do {*/
          /*  try {*/

           /*     if (vida < 0 || vida > 50) {
                    System.err.println("La vida no es válida");
                    System.out.println("Introducela de nuevo: ");
                }
            } catch (InputMismatchException e) {
                System.err.println("La vida no es válida");
                System.out.println("Introducela de nuevo: ");
                sc.nextLine();
            }*/
 /*       } while (vida < 0 || vida > 50);*/
        return vida;
    }

    public int pedirDefensa(int defensa) throws InputMismatchException{
        System.out.print("Introduce la Defensa: ");
        if (defensa==-1){
            defensa = sc.nextInt();
        } else{
            sc.nextLine();
            defensa = sc.nextInt();
        }
      /*  do {*/
           /* try{*/
                 /*defensa = sc.nextInt();*/
           /*     if (defensa < 0 || defensa > 50) {
                    System.err.println("La defensa no es válida");
                    System.out.println("Introducela de nuevo: ");
                }
            }catch (InputMismatchException e){
                System.err.println("La defensa no es válida");
                System.out.println("Introducela de nuevo: ");
                sc.nextLine();
            }*/
        /*} while (defensa < 0 || defensa > 50);*/
        return defensa;
    }

    public int pedirAtaque(int ataque) throws InputMismatchException{
        System.out.print("Introduce el Ataque: ");
        if (ataque==-1){
            ataque = sc.nextInt();
        } else{
            sc.nextLine();
            ataque = sc.nextInt();
        }
 /*       do {*/
     /*       try {*/
                /*ataque = sc.nextInt();*/
           /*     if (ataque < 0 || ataque > 50) {
                    System.err.println("La ataque no es válida");
                    System.out.println("Introducela de nuevo: ");
                }*/
       /*     } catch (InputMismatchException e) {
                System.err.println("El ataque no es válido");
                System.out.println("Introducela de nuevo: ");
                sc.nextLine();
            }*/
    /*    } while (ataque < 0 || ataque > 50);*/
        return ataque;
    }

    public int pedirVelocidad(int velocidad) throws InputMismatchException {
        System.out.print("Introduce la velocidad: ");
        if (velocidad==-1){
            velocidad = sc.nextInt();
        } else{
            sc.nextLine();
            velocidad = sc.nextInt();
        }
        //do {
           /* try {*/
                /*velocidad = sc.nextInt();*/
          /*      if (velocidad < 0 || velocidad > 50) {
                    System.err.println("La velocidad no es válida");
                    System.out.println("Introducela de nuevo: ");
                }
            } catch (InputMismatchException e) {
                System.err.println("La velocidad no es válida");
                System.out.println("Introducela de nuevo: ");
                sc.nextLine();
            }*/
        //} while (velocidad < 0 || velocidad > 50);
        return velocidad;

    }
    public void imprimirError() {
        System.err.println("Has introducido mal el dato, introducelo de nuevo");
    }
}
