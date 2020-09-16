package com.livecron.vista;

import com.livecron.controlador.AccionAgregarProducto;
import com.livecron.vista.modelos.ModeloRegistroDeProducto;

import javax.swing.*;
import java.awt.*;

public class PanelRegistroDeProducto extends JPanel {

    private JTable tableroDeRegistro;

    public PanelRegistroDeProducto() {
        inicializarPanel();
        inicializandoTablaDeRegistro();
        inicializandoBotonesDeRegistro();
    }

    private void inicializandoTablaDeRegistro() {
        tableroDeRegistro = new JTable(new ModeloRegistroDeProducto());
        tableroDeRegistro.setRowHeight(40);
        tableroDeRegistro.setIntercellSpacing(new Dimension(20, 20));
        tableroDeRegistro.setFont(ConstantesVista.FUENTE_POR_DEFECTO_PLANO);
        tableroDeRegistro.getTableHeader().setFont(ConstantesVista.FUENTE_POR_DEFECTO_NEGRITA);
        add(new JScrollPane(tableroDeRegistro), BorderLayout.CENTER);
    }

    private void inicializarPanel() {
        setLayout(new BorderLayout());
    }

    private void inicializandoBotonesDeRegistro() {
        JToolBar toolBar = new JToolBar("Registrar");
        toolBar.add(CreadorComponentes.crearBotonConAccion(new AccionAgregarProducto(tableroDeRegistro)));
        JButton botonEditar = CreadorComponentes.crearBoton("Editar");
        botonEditar.setEnabled(false);
        toolBar.add(botonEditar);
        JButton botonEliminar = CreadorComponentes.crearBoton("Eliminar");
        botonEliminar.setEnabled(false);
        toolBar.add(botonEliminar);
        toolBar.setFont(ConstantesVista.FUENTE_POR_DEFECTO_PLANO);
        add(toolBar, BorderLayout.PAGE_START);
    }
}
