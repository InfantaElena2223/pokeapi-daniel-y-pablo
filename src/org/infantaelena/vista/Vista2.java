package org.infantaelena.vista;

import javax.swing.*;

public class Vista2 extends JFrame{
    private JTextField textoNombre;
    private JTextField textoClase;
    private JButton boton1;
    private JButton boton3;
    private JButton boton5;
    private JButton boton4;
    private JTextArea textArea1;
    private JLabel etiquetaNombre;
    private JPanel panelPrincipal;
    private JTextField textoVida;
    private JTextField textoDefensa;
    private JTextField textoAtaque;
    private JLabel etiquetaAtaque;
    private JLabel etiquetaVida;
    private JLabel etiquetaDefensa;
    private JLabel etiquetaClase;
    private JLabel etiquetaVelocidad;
    private JTextField textoVelocidad;
    private JButton boton2;

    public Vista2(){
        super("PokeAPI");
        setContentPane(panelPrincipal);
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void mostrarVentana(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void mostrarVentanaError(String mensaje) {

        JOptionPane.showMessageDialog(this, mensaje,"Error",JOptionPane.ERROR_MESSAGE);
    }

    public JTextField getTfNombre() {
        return textoNombre;
    }

    public void setTfNombre(JTextField tfNombre) {
        this.textoNombre = tfNombre;
    }

    public JTextField getTextField2() {
        return textoClase;
    }

    public void setTextField2(JTextField textField2) {
        this.textoClase = textField2;
    }

    public JButton getButton1() {
        return boton1;
    }

    public void setButton1(JButton button1) {
        this.boton1 = button1;
    }

    public JButton getButton2() {
        return boton3;
    }

    public void setButton2(JButton button2) {
        this.boton3 = button2;
    }

    public JButton getButton3() {
        return boton5;
    }

    public void setButton3(JButton button3) {
        this.boton5 = button3;
    }

    public JButton getButton4() {
        return boton4;
    }

    public void setButton4(JButton button4) {
        this.boton4 = button4;
    }

    public JTextArea getTextArea1() {
        return textArea1;
    }

    public void setTextArea1(JTextArea textArea1) {
        this.textArea1 = textArea1;
    }

    public JLabel getEtiquetaNombre() {
        return etiquetaNombre;
    }

    public void setEtiquetaNombre(JLabel etiquetaNombre) {
        this.etiquetaNombre = etiquetaNombre;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public JTextField getTextoNombre() {
        return textoNombre;
    }

    public void setTextoNombre(JTextField textoNombre) {
        this.textoNombre = textoNombre;
    }

    public JTextField getTextoClase() {
        return textoClase;
    }

    public void setTextoClase(JTextField textoClase) {
        this.textoClase = textoClase;
    }

    public JButton getBoton1() {
        return boton1;
    }

    public void setBoton1(JButton boton1) {
        this.boton1 = boton1;
    }

    public JButton getBoton3() {
        return boton3;
    }

    public void setBoton3(JButton boton3) {
        this.boton3 = boton3;
    }

    public JButton getBoton5() {
        return boton5;
    }

    public void setBoton5(JButton boton5) {
        this.boton5 = boton5;
    }

    public JButton getBoton4() {
        return boton4;
    }

    public void setBoton4(JButton boton4) {
        this.boton4 = boton4;
    }

    public JTextField getTextoVida() {
        return textoVida;
    }

    public void setTextoVida(JTextField textoVida) {
        this.textoVida = textoVida;
    }

    public JTextField getTextoDefensa() {
        return textoDefensa;
    }

    public void setTextoDefensa(JTextField textoDefensa) {
        this.textoDefensa = textoDefensa;
    }

    public JTextField getTextoAtaque() {
        return textoAtaque;
    }

    public void setTextoAtaque(JTextField textoAtaque) {
        this.textoAtaque = textoAtaque;
    }

    public JLabel getEtiquetaAtaque() {
        return etiquetaAtaque;
    }

    public void setEtiquetaAtaque(JLabel etiquetaAtaque) {
        this.etiquetaAtaque = etiquetaAtaque;
    }

    public JLabel getEtiquetaVida() {
        return etiquetaVida;
    }

    public void setEtiquetaVida(JLabel etiquetaVida) {
        this.etiquetaVida = etiquetaVida;
    }

    public JLabel getEtiquetaDefensa() {
        return etiquetaDefensa;
    }

    public void setEtiquetaDefensa(JLabel etiquetaDefensa) {
        this.etiquetaDefensa = etiquetaDefensa;
    }

    public JLabel getEtiquetaClase() {
        return etiquetaClase;
    }

    public void setEtiquetaClase(JLabel etiquetaClase) {
        this.etiquetaClase = etiquetaClase;
    }

    public JLabel getEtiquetaVelocidad() {
        return etiquetaVelocidad;
    }

    public void setEtiquetaVelocidad(JLabel etiquetaVelocidad) {
        this.etiquetaVelocidad = etiquetaVelocidad;
    }

    public JTextField getTextoVelocidad() {
        return textoVelocidad;
    }

    public void setTextoVelocidad(JTextField textoVelocidad) {
        this.textoVelocidad = textoVelocidad;
    }

    public JButton getBoton2() {
        return boton2;
    }

    public void setBoton2(JButton boton2) {
        this.boton2 = boton2;
    }



}
