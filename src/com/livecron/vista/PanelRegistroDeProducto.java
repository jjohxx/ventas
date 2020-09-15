package com.livecron.vista;

import com.livecron.controlador.AccionAgregarProducto;

import javax.swing.*;
import java.awt.*;

public class PanelRegistroDeProducto extends JPanel {

    public PanelRegistroDeProducto() {
        inicializarPanel();
        inicializandoBotonesDeRegistro();
    }

    private void inicializarPanel() {
        setLayout(new BorderLayout());
    }

    private void inicializandoBotonesDeRegistro() {
        JToolBar toolBar = new JToolBar("Registrar");
        toolBar.add(CreadorComponentes.crearBotonConAccion(new AccionAgregarProducto()));
        toolBar.add(CreadorComponentes.crearBoton("Editar"));
        toolBar.add(CreadorComponentes.crearBoton("Eliminar"));
        toolBar.setFont(ContantesVista.FUENTE_POR_DEFECTO_PLANO);
        add(toolBar, BorderLayout.PAGE_START);
    }
}
