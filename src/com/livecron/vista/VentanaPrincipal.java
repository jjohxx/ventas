package com.livecron.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    public VentanaPrincipal() {
        super(ConstantesVista.NOMBRE_POR_DEFECTO);
        iniciarComponentes();
        setSize(new Dimension(1300, 900));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void iniciarComponentes() {
        JTabbedPane princialTabs = new JTabbedPane();
        princialTabs.add("Registro", new PanelRegistroDeProducto());
        princialTabs.add("Busqueda y seleccion", new PanelBusquedaSeleccion());
        princialTabs.add("Almacen", new JPanel());
        princialTabs.setFont(ConstantesVista.FUENTE_POR_DEFECTO_NEGRITA);
        add(princialTabs);
    }
}
