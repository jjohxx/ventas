package com.livecron.pruebas;

import com.livecron.modelo.ContenedorDeProducto;
import com.livecron.modelo.Producto;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.*;

public class ProductoTest {

    @Test
    public void pruebaParaAgregarProducto() throws ParseException {
        Producto cocaCola = new Producto(23435465654654L, "Coca Cola", 10.0,
                "05/04/2021");

        ContenedorDeProducto contenedorDeProducto = ContenedorDeProducto.getInstancia();
        contenedorDeProducto.agregarProducto(cocaCola);

        assertTrue(contenedorDeProducto.existeProducto(23435465654654L));

        Producto productoAgregado = contenedorDeProducto.buscarProductoPorCodigo(23435465654654L);

        assertNotNull(productoAgregado);
        assertEquals(23435465654654L, productoAgregado.getCodigo());
        assertEquals("Coca Cola", productoAgregado.getNombre());
        assertEquals(10.0, productoAgregado.getPrecioUnitario(), 0.0);
        assertFalse(cocaCola.isStock());
    }

    @Test
    public void pruebaDeEliminarProducto() throws ParseException {
        Producto cocaCola = new Producto(23435465654654L, "Coca Cola", 10.0,
                "05/04/2021");

        ContenedorDeProducto contenedorDeProducto = ContenedorDeProducto.getInstancia();
        contenedorDeProducto.agregarProducto(cocaCola);

        assertTrue(contenedorDeProducto.existeProducto(23435465654654L));

        contenedorDeProducto.eliminarProducto(23435465654654L);

        assertFalse(contenedorDeProducto.existeProducto(23435465654654L));
    }

}