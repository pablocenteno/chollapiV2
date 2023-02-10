package com.add.chollapi.servicio;

import com.add.chollapi.modelo.Categoria;
import com.add.chollapi.modelo.Producto;

import java.util.List;

public interface CategoriaService {
    Categoria crearCategoria(Categoria categoria);
    Categoria obtenerCategoria(Long id);
    Categoria modificarCategoria(Categoria categoria);
    boolean borrarCategoria(Long idCat);
    List<Producto> ultimos5_de_categoria(Long idCat);
}
