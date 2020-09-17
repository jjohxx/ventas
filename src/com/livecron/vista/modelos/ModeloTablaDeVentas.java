package com.livecron.vista.modelos;

import com.livecron.modelo.ListaProductosAVender;
import com.livecron.modelo.Producto;
import com.livecron.vista.ConstantesVista;

import javax.swing.table.AbstractTableModel;
import java.util.Date;
import java.util.Optional;

public class ModeloTablaDeVentas extends AbstractTableModel {

    private ListaProductosAVender listaProductosAVender;

    public ModeloTablaDeVentas(ListaProductosAVender listaProductosAVender) {
        this.listaProductosAVender = listaProductosAVender;
    }

    @Override
    public int getRowCount() {
        return this.listaProductosAVender.obtenerTamanio();
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
        Producto productoAVender = listaProductosAVender.obtenerProductoPorIndice(rowIndex);
        switch (columnIndex) {
            case 0:
                return productoAVender.getCodigo();
            case 1:
                return productoAVender.getNombre();
            case 2:
                return productoAVender.getPrecioUnitario();
            case 3:
                return productoAVender.getFechaDeVencimiento();
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0 :
                return Long.class;
            case 1 :
                return String.class;
            case 2 :
                return Double.class;
            case 3 :
                return Date.class;
            default:
                return null;
        }
    }

    public void agregarProducto(Producto producto) {
        Optional<Producto> optionalProducto = listaProductosAVender.obtenerProductoPorCodigo(producto.getCodigo());
        if (!optionalProducto.isPresent()) {
            listaProductosAVender.agregarProductoAVender(producto);
        }
    }
}
