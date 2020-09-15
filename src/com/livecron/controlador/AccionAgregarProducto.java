package com.livecron.controlador;

import com.livecron.vista.FormularioAgregarProducto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AccionAgregarProducto extends AbstractAction {

    public AccionAgregarProducto() {
        super("Agregar");
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_A);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mostrarFormulario();
    }

    private void mostrarFormulario() {
        JDialog form = new JDialog();
        form.setTitle("Agregar producto");
        form.setSize(400, 300);
        form.setModal(true);
        form.setLocationRelativeTo(null);
        form.add(new FormularioAgregarProducto(form));
        form.setVisible(true);
    }
}
