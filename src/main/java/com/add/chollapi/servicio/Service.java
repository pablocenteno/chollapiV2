package com.add.chollapi.servicio;

import com.add.chollapi.modelo.Categoria;
import com.add.chollapi.modelo.Oferta;
import com.add.chollapi.modelo.Producto;

import java.util.Optional;

public interface Service {
    Oferta obtenerOferta(Long id);
    Oferta crearOferta(Oferta oferta);
    Oferta modificarOferta(Oferta of);
    boolean borrarOferta(Oferta of);


    Categoria crearCategoria(Categoria categoria);
    Optional<Categoria> obtenerCategoria(Long id);
     Categoria modificarCategoria(Categoria categoria);
    boolean borrarCategoria(Categoria cat);


    Producto obtenerProducto(Long id);
    Producto crearProducto(Producto producto);
     Producto modificarProducto(Producto prod);
    boolean borrarProducto(Producto prod);
}
