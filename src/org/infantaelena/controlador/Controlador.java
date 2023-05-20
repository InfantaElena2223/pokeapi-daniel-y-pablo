package org.infantaelena.controlador;

import org.infantaelena.excepciones.PokemonNotFoundException;
import org.infantaelena.excepciones.PokemonRepeatedException;
import org.infantaelena.modelo.dao.PokemonDAOImp;
import org.infantaelena.modelo.entidades.Pokemon;
import org.infantaelena.vista.Vista;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que se encarga de obtener los datos de la vista
 * y enviarlos al modelo para que los procese
 *
 * @author Pablo Polo, Marcos Manzano y Daniel Ocaña
 * @version 1.0
 * @date 24/04/2023
 */


public class Controlador {
    /**
     * Atributo para hacer referencia a la vista
     */
    private Vista vista;
    /**
     * Atributo para hacer referencia al modelo
     */
    private PokemonDAOImp modelo;

    /**
     * El constructor del controlador, que creará instancias de la vista y el controlador, y establece las acciones que se harían
     * al pulsar en los botones de la vista
     */
    public Controlador() {
        modelo = new PokemonDAOImp();
        vista = new Vista();
        establecerValoresPorDefecto();

        vista.getBoton1().addActionListener(e -> guardar());
        vista.getBoton2().addActionListener(e -> seleccionar());
        vista.getBoton3().addActionListener(e -> mostrarPokemons());
        vista.getBoton4().addActionListener(e -> eliminar());
        vista.getBoton5().addActionListener(e -> actualizar());
    }

    /**
     * Método para guardar los datos proporcionados por la vista en la base de datos, si los valores son incorrectos o está repetido
     * el pokémon, se mostrará un mensaje de error.
     */
    private void guardar() {

        Pokemon pokemon=convertirDatosInterfazAPokemon();
        if (pokemon!=null){
            try {
                modelo.crear(pokemon);
                //Si llega hasta aquí no habrá ocurrido ninguna excepción (comprobaciones hechas en el modelo)
                vista.mostrarVentana("Pokemon " + pokemon.getNombre() + " añadido con éxito");
                establecerValoresPorDefecto();
            } catch (PokemonRepeatedException e) {
                vista.mostrarVentanaError("El pokemon ya existe");
            }


        }
    }

    /**
     * Método que coge el campo de la clase, se conecta con la base de datos, y establece cada campo de la interfaz con sus valores correspondientes,
     *  si no lo encuentra, saltará un mensaje de error.
     */
    public void seleccionar() {

        try {
            String nombre = vista.getTfNombre().getText().trim().toUpperCase();
            Pokemon pokemon = modelo.leerPorNombre(nombre);
                vista.getTextoNombre().setText(pokemon.getNombre());
                vista.getTextoClase().setText(String.valueOf(pokemon.getClase()));
                vista.getTextoVida().setText(String.valueOf(pokemon.getVida()));
                vista.getTextoDefensa().setText(String.valueOf(pokemon.getDefensa()));
                vista.getTextoAtaque().setText(String.valueOf(pokemon.getAtaque()));
                vista.getTextoVelocidad().setText(String.valueOf(pokemon.getVelocidad()));

        } catch (PokemonNotFoundException e) {
            vista.mostrarVentanaError("No se ha encontrado el Pokemon");
        }
    }

    /**
     * Método para mostrar los pokemons, si el campo de la clase está vacío se mostrarán todos, si es el nombre de una clase válida,
     * se mostrarán los de esa clase y si no es válida se mostrará un error.
     */
    private void mostrarPokemons() {
        boolean claseValida = false;
        List<Pokemon> pokemones = new ArrayList<>();
        String textoClase = String.valueOf(vista.getTextoClase().getText()).toUpperCase();
        if (textoClase.equals("AIRE") || textoClase.equals("FUEGO")
                || textoClase.equals("TIERRA") || textoClase.equals("AGUA")) {
            claseValida = true;
            try {
                pokemones = modelo.leerPorClase(textoClase);
            } catch (RuntimeException e) {
                vista.mostrarVentanaError("Error al realizar la consulta");
            }
        } else if (textoClase.equals("")) {
            claseValida = true;
            pokemones = modelo.leerTodos();
        } else {
            vista.mostrarVentanaError("No has puesto una clase válida");
            vista.mostrarVentana("Elige entre: FUEGO, TIERRA, AIRE, AGUA, SIN_CLASE o deja el campo vacío para mostrar todos");
        }
        String texto = "";
        for (Pokemon pokemon : pokemones) {
            texto += pokemon.getNombre() + "\n";
        }
        if (pokemones.size() == 0 && claseValida) {
            vista.mostrarVentana("No hay ningún pokémon");
        } else {
            vista.getTextArea1().setText(texto);
        }
    }

    /**
     * Método para eliminar un pokémon, si no existe, saltará un mensaje de error.
     */
    public void eliminar() {
        try {
            String nombre = vista.getTfNombre().getText().trim().toUpperCase();
            modelo.eliminarPorNombre(nombre);
            //Si llega hasta aquí se ha eliminado el pokémon
            vista.mostrarVentana("Se ha eliminado correctamente");
            establecerValoresPorDefecto();
        } catch (PokemonNotFoundException e) {
            vista.mostrarVentanaError("No se ha encontrado el Pokemon");
        }
    }

    /**
     * Método para actualizar los datos de un pokémon, si no existe el pokémon o los datos para actualizarlo, son incorrectos,
     * se mostrará un mensaje de error.
     */
    public void actualizar() {

        Pokemon pokemon = convertirDatosInterfazAPokemon();
        if (pokemon!=null){
            try {
                modelo.actualizar(pokemon);
                vista.mostrarVentana("Pokemon " + pokemon.getNombre() + " actualizado con éxito");
               establecerValoresPorDefecto();
            } catch (PokemonNotFoundException e) {
                vista.mostrarVentanaError("El pokemon no se encuentra");

            } catch (RuntimeException e) {
                vista.mostrarVentanaError("No se ha podido actualizar el pokemon");
            }

        }
    }

    /**
     * Método para establecer los valores de la interfaz gráfica a unos por defecto.
     */
    public void establecerValoresPorDefecto() {
        vista.getTextoNombre().setText("");
        vista.getTextoClase().setText("");
        vista.getTextoVida().setText("0");
        vista.getTextoDefensa().setText("0");
        vista.getTextoAtaque().setText("0");
        vista.getTextoVelocidad().setText("0");
        vista.getTextArea1().setText("");
    }

    /**
     * Método que verifica que los datos de los campos son correctos, y si los son creará un objeto Pokemon con todos ellos
     * @return El pokemon con los datos o null si ha habido un problema.
     */
    public Pokemon convertirDatosInterfazAPokemon() {
        String nombre = vista.getTfNombre().getText().trim().toUpperCase();
        Pokemon.Clases clase;
        try {
            clase = Pokemon.Clases.valueOf(vista.getTextoClase().getText().trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            vista.mostrarVentanaError("La clase introducida no es válida");
            vista.mostrarVentana("Elige entre: FUEGO, TIERRA, AIRE, AGUA, SIN_CLASE");
            return null;
        }
        int vida = -1;
        int ataque = -1;
        int defensa = -1;
        int velocidad = -1;
        try {

            vida = Integer.valueOf(vista.getTextoVida().getText());

            ataque = Integer.valueOf(vista.getTextoAtaque().getText());
            defensa = Integer.valueOf(vista.getTextoDefensa().getText());
            velocidad = Integer.valueOf(vista.getTextoVelocidad().getText());
        } catch (NumberFormatException e) {
            /*  vista2.mostrarVentana("Has introducido mal los datos. Solo puedes meter números");*/
        }

        if (nombre.isEmpty() || (vida < 0 || vida > 50) || (ataque < 0 || ataque > 50) || (defensa < 0 || defensa > 50) || (velocidad < 0 || velocidad > 50)) {
            vista.mostrarVentanaError("Has introducido mal los datos, no puede haber campos vacíos, y los valores numéricos " +
                    "tienen que estar entre 0 y 50");
        } else {
            Pokemon pokemon = new Pokemon(nombre, clase, vida, ataque, defensa, velocidad);
            return pokemon;
        }
        return null;
    }
}
