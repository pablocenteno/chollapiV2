package com.add.chollapi.servicio;

import com.add.chollapi.modelo.Producto;

import java.util.List;

public interface ProductoService {
    Producto obtenerProducto(Long id);
    Producto crearProducto(Producto producto);
    Producto modificarProducto(Producto prod);
    boolean borrarProducto(Long idProd);

    Producto buscarProducto(String nombre, String desc);
    public List<Producto> mejores10_precio(Long id);

    public List<Producto> ultimos5_de_categoria(Long idCat);
}
