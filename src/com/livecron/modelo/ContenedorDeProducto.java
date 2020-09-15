package com.livecron.modelo;

import java.util.HashMap;
import java.util.Map;

public class ContenedorDeProducto {

    private Map<Long, Producto> productosPorCodigo;
    private static ContenedorDeProducto contenedorDeProducto;

    private ContenedorDeProducto() {
        productosPorCodigo = new HashMap<>();
    }

    public static ContenedorDeProducto getInstancia() {
        if (contenedorDeProducto == null) {
            contenedorDeProducto = new ContenedorDeProducto();
        }
        return contenedorDeProducto;
    }

    public void agregarProducto(Producto producto) {
        productosPorCodigo.put(producto.getCodigo(), producto);
    }

    public boolean existeProducto(long codigo) {
        return productosPorCodigo.containsKey(codigo);
    }

    public Producto eliminarProducto(long codigo) {
        return productosPorCodigo.remove(codigo);
    }

    public Producto buscarProductoPorCodigo(long codigo) {
        return productosPorCodigo.get(codigo);
    }

    @Override
    public String toString() {
        return "ContenedorDeProducto{" +
                "productosPorCodigo=" + productosPorCodigo +
                '}';
    }
}
