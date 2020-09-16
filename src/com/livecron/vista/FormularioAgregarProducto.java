package com.livecron.vista;

import com.livecron.controlador.AccionCancelarProducto;
import com.livecron.controlador.AccionGuardarProducto;

import javax.swing.*;
import java.awt.*;

public class FormularioAgregarProducto extends JPanel {

    private JPanel inputs;
    private JDialog form;
    private JTable tableroDeRegistro;

    public FormularioAgregarProducto(JDialog form, JTable tableDeRegistro) {
        this.form = form;
        this.tableroDeRegistro = tableDeRegistro;
        inicializarComponent();
    }

    private void inicializarComponent() {
        setLayout(new BorderLayout());

        JPanel labels = crearPanelLabels();
        inputs = crearPanelInputs();
        JPanel botones = crearPanelBotones();

        JPanel contenido = new JPanel(new GridLayout(1, 2));
        contenido.add(labels);
        contenido.add(inputs);

        add(contenido, BorderLayout.CENTER);
        add(botones, BorderLayout.PAGE_END);
    }

    private JPanel crearPanelBotones() {
        JPanel botones = new JPanel(new GridLayout(1, 2));
        botones.add(CreadorComponentes.crearBotonConAccion(new AccionGuardarProducto(inputs, tableroDeRegistro)));
        botones.add(CreadorComponentes.crearBotonConAccion(new AccionCancelarProducto(form)));
        return botones;
    }

    private JPanel crearPanelLabels() {
        JPanel labels = new JPanel(new GridLayout(4, 1));
        labels.add(CreadorComponentes.crearLabel(" Codigo"));
        labels.add(CreadorComponentes.crearLabel(" Nombre"));
        labels.add(CreadorComponentes.crearLabel(" Precio"));
        labels.add(CreadorComponentes.crearLabel(" Fecha de Ven."));
        return labels;
    }

    private JPanel crearPanelInputs() {
        JPanel inputs = new JPanel(new GridLayout(4, 1));
        inputs.add(CreadorComponentes.crearTextField("0"));
        inputs.add(CreadorComponentes.crearTextField("producto"));
        inputs.add(CreadorComponentes.crearTextField("0.00"));
        inputs.add(CreadorComponentes.crearTextField("01/01/2000"));
        return inputs;
    }
}
