package com.livecron.vista.modelos;

import com.livecron.modelo.ContenedorDeProducto;
import com.livecron.modelo.Producto;
import com.livecron.vista.ConstantesVista;

import javax.swing.table.AbstractTableModel;
import java.util.Date;

public class ModeloRegistroDeProducto extends AbstractTableModel {

    private ContenedorDeProducto contenedorDeProducto = ContenedorDeProducto.getInstancia();

    @Override
    public int getRowCount() {
        return contenedorDeProducto.obtenerTamanio();
    }

    @Override
    public int getColumnCount() {
        return ConstantesVista.CABEZERAS_DE_TABLA.length;
    }

    @Override
    public String getColumnName(int column) {
        return ConstantesVista.CABEZERAS_DE_TABLA[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto producto = contenedorDeProducto.getProductoPorIndice(rowIndex);
        switch (columnIndex) {
            case 0:
                return producto.getCodigo();
            case 1:
                return producto.getNombre();
            case 2:
                return producto.getPrecioUnitario();
            case 3:
                return producto.getFechaDeVencimiento();
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Long.class;
            case 1:
                return String.class;
            case 2:
                return Double.class;
            default:
                return Date.class;
        }
    }
}
