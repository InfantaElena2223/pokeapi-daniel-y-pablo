package org.infantaelena.vista;

import javax.swing.*;

public class Vista2 extends JFrame{
    private JTextField textoNombre;
    private JTextField textoClase;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JTextArea textArea1;
    private JLabel etiquetaNombre;
    private JPanel panelPrincipal;
    private JTextField textoVida;
    private JTextField textoDefensa;
    private JTextField textoAtaque;

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
        return button1;
    }

    public void setButton1(JButton button1) {
        this.button1 = button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public void setButton2(JButton button2) {
        this.button2 = button2;
    }

    public JButton getButton3() {
        return button3;
    }

    public void setButton3(JButton button3) {
        this.button3 = button3;
    }

    public JButton getButton4() {
        return button4;
    }

    public void setButton4(JButton button4) {
        this.button4 = button4;
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

}
