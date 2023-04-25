package org.infantaelena.vista;

import java.util.Scanner;

/**
 * Clase que representa la vista de la aplicación
 * Implementar con menus de texto o con interfaz gráfica
 *
 * @author Daniel Ocaña y Pablo Polo
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

public void

}
