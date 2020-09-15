package com.livecron.vista;

import javax.swing.*;

public class CreadorComponentes {

    public static JLabel crearLabel(String nombreLabel) {
        JLabel label = new JLabel(nombreLabel);
        label.setFont(ContantesVista.FUENTE_POR_DEFECTO_ITALIC);
        return label;
    }

    public static JTextField crearTextField(String nombreDefecto) {
        JTextField textField = new JTextField(nombreDefecto);
        textField.setFont(ContantesVista.FUENTE_POR_DEFECTO_PLANO);
        return textField;
    }

    public static JButton crearBoton(String nombre) {
        JButton button = new JButton(nombre);
        button.setFont(ContantesVista.FUENTE_POR_DEFECTO_PLANO);
        return button;
    }

    public static JButton crearBotonConAccion(AbstractAction action) {
        JButton button = new JButton(action);
        button.setFont(ContantesVista.FUENTE_POR_DEFECTO_PLANO);
        return button;
    }
}
