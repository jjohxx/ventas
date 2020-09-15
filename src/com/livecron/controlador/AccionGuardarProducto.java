package com.livecron.controlador;

import com.livecron.modelo.ContenedorDeProducto;
import com.livecron.modelo.Producto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccionGuardarProducto extends AbstractAction {

    private JPanel inputs;
    private ContenedorDeProducto contenedorDeProducto = ContenedorDeProducto.getInstancia();

    public AccionGuardarProducto(JPanel inputs) {
        super("Guardar");
        this.inputs = inputs;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        contenedorDeProducto.agregarProducto(construirProducto());
        System.out.println(contenedorDeProducto.toString());
    }

    private Producto construirProducto() {
        JTextField codigo = (JTextField)inputs.getComponent(0);
        JTextField nombre = (JTextField)inputs.getComponent(1);
        JTextField precio = (JTextField)inputs.getComponent(2);
        JTextField fechaDeVen = (JTextField)inputs.getComponent(3);

        Producto producto = new Producto();
        producto.setCodigo(Long.parseLong(codigo.getText()));
        producto.setNombre(nombre.getText());
        producto.setPrecioUnitario(Double.parseDouble(precio.getText()));
        producto.setFechaDeVencimiento(convertirStringADate(fechaDeVen.getText()));
        return producto;
    }

    public Date convertirStringADate(String valor1) {
        DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return formateador.parse(valor1);
        } catch (ParseException e) {
            return null;
        }
    }
}
