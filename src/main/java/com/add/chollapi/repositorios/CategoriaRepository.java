package com.add.chollapi.repositorios;

import com.add.chollapi.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    public Categoria obtenerCat();
    public Categoria crearCategoria();
    public Categoria modificarCategoria();
    public boolean borrarCategoria(Categoria cat);
}
