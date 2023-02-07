package com.add.chollapi.servicio;

import com.add.chollapi.modelo.Categoria;

public interface CategoriaService {
    Categoria crearCategoria(Categoria categoria);
    Categoria obtenerCategoria(Long id);
    Categoria modificarCategoria(Categoria categoria);
    boolean borrarCategoria(Long idCat);
}
