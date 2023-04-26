package org.infantaelena.vista;

import org.infantaelena.modelo.entidades.Pokemon;

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
        System.out.println("Añadir Pokemon");

        System.out.println("Seleccionar un Pokemon");

        System.out.println("Actualizar un Pokemon");

        System.out.println("Lista de todos los Pokemon");

        System.out.println("Eliminar un Pokemon");

        System.out.println("Salir");

        return sc.nextInt();
    }

    public String pedirNombre() {
        System.out.print("Introduce el nombre: ");
        String nombre = sc.nextLine();
        return nombre;
    }

    public Pokemon.Clases pedirClase() {

        Pokemon.Clases clase = Pokemon.Clases.SIN_CLASE;
        System.out.println("Introduce la clase");
        System.out.print("Opciones disponibles [SIN_CLASE,FUEGO, TIERRA, AIRE, AGUA]: ");

        String textoClase = sc.nextLine().toUpperCase();
        try {
            clase = Pokemon.Clases.valueOf(textoClase);
        } catch (IllegalArgumentException e) {
            System.err.println("No se ha encontrado la clase prueba otra vez");
            pedirClase();
        }
        return clase;

    }

    public int pedirVida() {
        System.out.print("Introduce la vida");
        int vida = sc.nextInt();
        do {
            if (vida <= 0 || vida > 50) {
                System.err.println("La vida no es válida");
                System.out.print("Introducela de nuevo");
            }
        } while (vida <= 0 || vida > 50);
        return vida;
    }

    public int pedirDefensa() {
        System.out.print("Introduce la Defensa");
        int defensa = sc.nextInt();
        do {
            if (defensa < 0 || defensa > 50) {
                System.err.println("La defensa no es válida");
                System.out.print("Introducela de nuevo");
            }
        } while (defensa < 0 || defensa > 50);
        return defensa;
    }

    public int pedirAtaque() {
        System.out.print("Introduce el Ataque");
        int ataque = sc.nextInt();
        do {
            if (ataque < 0 || ataque > 50) {
                System.err.println("La ataque no es válida");
                System.out.print("Introducela de nuevo");
            }
        } while (ataque < 0 || ataque > 50);
        return ataque;
    }

    public int pedirVelocidad() {
        System.out.print("Introduce la velocidad");
        int velocidad = sc.nextInt();
        do {
            if (velocidad < 0 || velocidad > 50) {
                System.err.println("La velocidad no es válida");
                System.out.print("Introducela de nuevo");
            }
        } while (velocidad < 0 || velocidad > 50);
        System.out.println();
        return velocidad;

    }
}
