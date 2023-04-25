package org.infantaelena.modelo.entidades;

/**
 * Clase que representa a un pokemon
 *
 * @author Daniel Ocaña y Pablo Polo
 * @version 1.0
 * @date 24/04/2023
 */
public class Pokemon {
    public enum Clases {FUEGO, TIERRA, AIRE, AGUA, SIN_CLASE}

    private String nombre;
    private Clases clase;
    private int vida;
    private int defensa;
    private int ataque;
    private int velocidad;


    public Pokemon() {
        this("", Clases.SIN_CLASE, 0, 0, 0, 0);
    }

    public Pokemon(String nombre, Clases clase, int vida, int defensa, int ataque, int velocidad) {
        this.nombre = nombre;
        this.clase = clase;
        setVida(vida);
        setDefensa(defensa);
        setAtaque(ataque);
        setVelocidad(velocidad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Clases getClase() {
        return clase;
    }

    public void setClase(Clases clase) {
        this.clase = clase;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;

    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }
}
