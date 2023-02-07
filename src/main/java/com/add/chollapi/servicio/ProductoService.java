package com.add.chollapi.servicio;

import com.add.chollapi.modelo.Producto;

public interface ProductoService {
    Producto obtenerProducto(Long id);
    Producto crearProducto(Producto producto);
    Producto modificarProducto(Producto prod);
    boolean borrarProducto(Long idProd);
}
