package com.livecron.vista;

import com.livecron.modelo.ContenedorDeProducto;
import com.livecron.modelo.ListaProductosAVender;
import com.livecron.modelo.Producto;
import com.livecron.vista.modelos.ModeloRegistroDeProducto;
import com.livecron.vista.modelos.ModeloTablaDeVentas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class PanelBusquedaSeleccion extends JPanel {

    private JTable tableroProductosPorVender;
    private ContenedorDeProducto contenedorDeProducto = ContenedorDeProducto.getInstancia();
    private ListaProductosAVender listaProductosAVender;
    private ModeloTablaDeVentas modeloTablaDeVentas;

    public PanelBusquedaSeleccion() {
        listaProductosAVender = new ListaProductosAVender();
        modeloTablaDeVentas = new ModeloTablaDeVentas(listaProductosAVender);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        setLayout(new BorderLayout());
        tableroProductosPorVender = new JTable(modeloTablaDeVentas);
        tableroProductosPorVender.setRowHeight(40);
        tableroProductosPorVender.setIntercellSpacing(new Dimension(20, 20));
        tableroProductosPorVender.setFont(ConstantesVista.FUENTE_POR_DEFECTO_PLANO);
        tableroProductosPorVender.getTableHeader().setFont(ConstantesVista.FUENTE_POR_DEFECTO_NEGRITA);

        JPanel panelDeSeleccion = new JPanel();
        panelDeSeleccion.setLayout(new BoxLayout(panelDeSeleccion, BoxLayout.Y_AXIS));
        panelDeSeleccion.add(CreadorComponentes.crearLabel("Busqueda de codigo de barras: "));
        panelDeSeleccion.add(crearTextFieldParaBusqueda());
        panelDeSeleccion.add(CreadorComponentes.crearBoton("Generar Transaccion"));

        JPanel panelDeBusquedaYSeleccion = new JPanel(new BorderLayout(10, 10));
        panelDeBusquedaYSeleccion.add(new JPanel(), BorderLayout.CENTER);
        panelDeBusquedaYSeleccion.add(panelDeSeleccion, BorderLayout.PAGE_END);

        add(new JScrollPane(tableroProductosPorVender), BorderLayout.CENTER);
        add(CreadorComponentes.crearLabel("Precio Total es : "), BorderLayout.PAGE_END);
        add(panelDeBusquedaYSeleccion, BorderLayout.LINE_END);
    }

    private JTextField crearTextFieldParaBusqueda() {
        JTextField textField = CreadorComponentes.crearTextField("9879849546");
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Long codigoDeBarra = Long.parseLong(textField.getText());
                if (contenedorDeProducto.existeProducto(codigoDeBarra)) {
                    Producto producto = contenedorDeProducto.buscarProductoPorCodigo(codigoDeBarra);
                    modeloTablaDeVentas.agregarProducto(producto);
                    tableroProductosPorVender.updateUI();
                }
            }
        });

        return textField;
    }
}
