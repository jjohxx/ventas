package com.livecron.controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AccionCancelarProducto extends AbstractAction {

    private JDialog form;
    public AccionCancelarProducto(JDialog form) {
        super("Cancelar");
        this.form = form;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        form.setVisible(false);
    }
}
