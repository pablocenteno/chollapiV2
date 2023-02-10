package com.add.chollapi.repositorios;

import com.add.chollapi.modelo.Categoria;
import com.add.chollapi.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query(value = "SELECT p from Producto p JOIN p.categoria c WHERE c.id = :idCat", nativeQuery = true)
    public List<Producto> ultimos5_de_categoria(@Param(value = "idCat") Long idCat);
}
