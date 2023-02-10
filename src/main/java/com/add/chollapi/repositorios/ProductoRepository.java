package com.add.chollapi.repositorios;



import com.add.chollapi.modelo.Oferta;
import com.add.chollapi.modelo.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {


    @Query(value="SELECT o from Oferta o JOIN o.productos p WHERE p.id =:id order by o.precio asc limit 10")
    public List<Oferta> mejores10_precio(@Param(value="id") Long id );

    Page <Producto>findAll(Pageable pageable);
    @Query(value="SELECT p from Producto p WHERE p.nombre like %:desc% or p.caracteristicas LIKE  %:desc%")
    public Producto buscarProducto( @Param(value = "desc")  String desc);
}
