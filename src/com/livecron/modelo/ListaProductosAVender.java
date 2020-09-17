package com.livecron.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListaProductosAVender {

    private List<Producto> listaDeProductos;

    public ListaProductosAVender() {
        listaDeProductos = new ArrayList<>();
    }

    public int obtenerTamanio() {
      return listaDeProductos.size();
    }

    public boolean agregarProductoAVender(Producto producto) {
        return listaDeProductos.add(producto);
    }

    public Producto obtenerProductoPorIndice(int indice) {
        return listaDeProductos.get(indice);
    }

    public Optional<Producto> obtenerProductoPorCodigo(long codigo) {
        return listaDeProductos
                .stream()
                .filter(producto -> producto.getCodigo() == codigo)
                .findFirst();
    }
}
