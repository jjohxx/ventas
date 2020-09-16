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
    private JTable tableroDeRegistro;
    private ContenedorDeProducto contenedorDeProducto = ContenedorDeProducto.getInstancia();

    public AccionGuardarProducto(JPanel inputs, JTable tableroDeRegistro) {
        super("Guardar");
        this.inputs = inputs;
        this.tableroDeRegistro = tableroDeRegistro;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Producto producto =  construirProducto();
        contenedorDeProducto.agregarProducto(producto);
        tableroDeRegistro.updateUI();
        System.out.println(contenedorDeProducto.toString());
    }

    private Producto construirProducto() {
        JTextField codigo = (JTextField)inputs.getComponent(0);
        JTextField nombre = (JTextField)inputs.getComponent(1);
        JTextField precio = (JTextField)inputs.getComponent(2);
        JTextField fechaDeVen = (JTextField)inputs.getComponent(3);

        boolean esValido = validarCamposDeProducto(codigo.getText(),
                nombre.getText(), precio.getText(),
                fechaDeVen.getText());

        if (esValido) {
            Producto producto = new Producto();
            producto.setCodigo(Long.parseLong(codigo.getText().trim()));
            producto.setNombre(nombre.getText());
            producto.setPrecioUnitario(Double.parseDouble(precio.getText()));
            producto.setFechaDeVencimiento(convertirStringADate(fechaDeVen.getText()));
            return producto;
        }
        return null;
    }

    private boolean validarCamposDeProducto(String codigo, String nombre, String precio, String fechaDeVen) {
        boolean estaVacioElCampo = estaVacioElCampo(codigo, "codigo")
                || estaVacioElCampo(nombre, "nombre del producto")
                || estaVacioElCampo(precio, "precio")
                || estaVacioElCampo(fechaDeVen, "fecha de vencimiento");

        if (estaVacioElCampo) {
            return false;
        }

        if (contenedorDeProducto.existeProducto(Long.parseLong(codigo.trim()))) {
            JOptionPane.showMessageDialog(null,
                    "El codigo del producto ya fue registrado.");
            return false;
        }

        return true;
    }

    private boolean estaVacioElCampo(String campoAValidar, String nombreDeCampo) {
        if (campoAValidar.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "El campo de " + nombreDeCampo + " esta vacio.");
            return true;
        }
        return false;
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
