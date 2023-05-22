package org.infantaelena.vista;

import javax.swing.*;

/**
 * Clase que representa la interfaz gráfica
 *
 * @author Pablo Polo, Marcos Manzano y Daniel Ocaña
 * @version 1.0
 * @since 24/04/2023
 */

public class Vista extends JFrame {
    /**
     * Atributo textoNombre
     */
    private JTextField textoNombre;
    /**
     * Atributo textoClase
     */
    private JTextField textoClase;
    /**
     * Atributo del botón para añadir
     */
    private JButton botonAniadir;

    /**
     * Botón para seleccionar un pokémon
     */
    private JButton botonSeleccionar;
    /**
     * Botón para mostrar los pokémons
     */
    private JButton botonMostrar;

    /**
     * Botón para eliminar un pokémon
     */
    private JButton botonEliminar;
    /**
     * Botón para actualizar un pokémon
     */
    private JButton botonActualizar;

    /**
     * Atributo textArea1
     */
    private JTextArea textArea1;
    /**
     * Atributo etiquetaNombre
     */
    private JLabel etiquetaNombre;
    /**
     * Atributo panelPrincipal
     */
    private JPanel panelPrincipal;
    /**
     * Atributo textoVida
     */
    private JTextField textoVida;
    /**
     * Atributo textoDefensa
     */
    private JTextField textoDefensa;
    /**
     * Atributo textoAtaque
     */
    private JTextField textoAtaque;
    /**
     * Atributo etiquetaAtaque
     */
    private JLabel etiquetaAtaque;
    /**
     * Atributo etiquetaVida
     */
    private JLabel etiquetaVida;
    /**
     * Atributo etiquetaDefensa
     */
    private JLabel etiquetaDefensa;
    /**
     * Atributo etiquetaClase
     */
    private JLabel etiquetaClase;
    /**
     * Atributo etiquetaVelocidad
     */
    private JLabel etiquetaVelocidad;
    /**
     * Atributo textoVelocidad
     */
    private JTextField textoVelocidad;


    /**
     * El constructor de la vista que abre la ventana.
     */
    public Vista() {
        super("PokeAPI");
        setContentPane(panelPrincipal);
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Función para mostrar una ventana con información
     * @param mensaje La información que se quiere comunicar
     */
    public void mostrarVentana(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    /**
     * Función para mostrar un mensaje de error.
     * @param mensaje El mensaje de error.
     */
    public void mostrarVentanaError(String mensaje) {

        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }


    /**
     * El getter del área grande
     * @return El texto
     */
    public JTextArea getTextArea1() {
        return textArea1;
    }

    /**
     * El getter del campo del nombre
     * @return El texto
     */
    public JTextField getTextoNombre() {
        return textoNombre;
    }

    /**
     * El getter del texto de la clase
     * @return El texto
     */
    public JTextField getTextoClase() {
        return textoClase;
    }

    /**
     * El getter del botón para añadir pokémons
     * @return
     */
    public JButton getBotonAniadir() {
        return botonAniadir;
    }


    /**
     *  El getter del botón para mostrar los pokémons
     * @return
     */
    public JButton getBotonMostrar() {
        return botonMostrar;
    }

    /**
     * El getter del botón para actualizar los pokemons
     * @return
     */

    public JButton getBotonActualizar() {
        return botonActualizar;
    }


    /**
     * El getter del botón para eliminar
     * @return
     */
    public JButton getBotonEliminar() {
        return botonEliminar;
    }


    /**
     * El getter del texto de la vida
     * @return El texto
     */
    public JTextField getTextoVida() {
        return textoVida;
    }

    /**
     * El getter del texto de la defensa.
     * @return El texto
     */
    public JTextField getTextoDefensa() {
        return textoDefensa;
    }

    /**
     * El getter del texto del ataque
     * @return El texto
     */
    public JTextField getTextoAtaque() {
        return textoAtaque;
    }


    /**
     * El getter del texto de la velocidad
     * @return El texto
     */
    public JTextField getTextoVelocidad() {
        return textoVelocidad;
    }

    /**
     * El getter del botón de seleccionar
     * @return
     */
    public JButton getBotonSeleccionar() {
        return botonSeleccionar;
    }
}
