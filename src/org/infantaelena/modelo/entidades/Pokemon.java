package org.infantaelena.modelo.entidades;

/**
 * Clase que representa a un pokemon
 *
 * @author Daniel Ocaña, Marcos Manzano y Pablo Polo
 * @version 1.0
 * @since 24/04/2023
 */
public class Pokemon {
    public static final int MAX_VALORES_NUMERICOS = 50;

    /**
     * Un enum para las clases
     */
    public enum Clases {FUEGO, TIERRA, AIRE, AGUA, SIN_CLASE}

    /**
     * El nombre del pokémon
     */
    private String nombre;
    /**
     * La clase del pokémon
     */
    private Clases clase;
    /**
     * La vida del pokémon
     */
    private int vida;
    /**
     * La defensa del pokémon
     */
    private int defensa;
    /**
     * El ataque del pokémon
     */
    private int ataque;
    /**
     * La velocidad del pokémon
     */
    private int velocidad;

    /**
     * Constructor por defecto
     */
    public Pokemon() {
        this("", Clases.SIN_CLASE, 0, 0, 0, 0);
    }

    /**
     * Constructor con todos los datos
     *
     * @param nombre
     * @param clase
     * @param vida
     * @param defensa
     * @param ataque
     * @param velocidad
     */
    public Pokemon(String nombre, Clases clase, int vida, int defensa, int ataque, int velocidad) {
        setNombre(nombre);
        setClase(clase);
        setVida(vida);
        setDefensa(defensa);
        setAtaque(ataque);
        setVelocidad(velocidad);
    }

    /**
     * El getter del nombre
     *
     * @return el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * EL setter del nombre
     *
     * @param nombre
     */

    public void setNombre(String nombre) {
        if (nombre == null) {
            if (this.nombre == null) {
                this.nombre = "";
            }
        } else {
            this.nombre = nombre.trim().toUpperCase();
        }
    }

    /**
     * El getter de clase
     *
     * @return clase
     */
    public Clases getClase() {
        return clase;
    }

    /**
     * El setter de la clase
     *
     * @param clase
     */
    public void setClase(Clases clase) {
        this.clase = clase;
    }

    /**
     * El getter de la vida
     *
     * @return La vida
     */
    public int getVida() {
        return vida;
    }

    /**
     * El setter de la vida
     *
     * @param vida
     */
    public void setVida(int vida) {
        this.vida = vida;

    }

    /**
     * El getter de la defensa
     *
     * @return La defensa
     */
    public int getDefensa() {
        return defensa;
    }

    /**
     * EL setter de la defensa
     *
     * @param defensa
     */
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    /**
     * El getter del ataque
     *
     * @return El ataque
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * El setter del ataque
     *
     * @param ataque
     */
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    /**
     * El getter de la velocidad
     *
     * @return La velocidad
     */
    public int getVelocidad() {
        return velocidad;
    }

    /**
     * Setter de la velocidad
     *
     * @param velocidad
     */
    public void setVelocidad(int velocidad) {
        if (velocidad < 0) {
            this.velocidad = 0;
        } else if(velocidad>MAX_VALORES_NUMERICOS){
            this.velocidad = MAX_VALORES_NUMERICOS;
        }else {
            this.velocidad=velocidad;
        }
    }

    /**
     * El método toString
     *
     * @return
     */
    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", clase=" + clase +
                ", vida=" + vida +
                ", defensa=" + defensa +
                ", ataque=" + ataque +
                ", velocidad=" + velocidad +
                '}';
    }
}
