package com.add.chollapi.repositorios;


import com.add.chollapi.modelo.Categoria;
import com.add.chollapi.modelo.Oferta;
import com.add.chollapi.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    public Producto obtenerProducto(Producto prod);
    public Producto crearProducto(Producto prod);
    public Producto modificarProducto(Producto prod);
    public boolean borrarProducto(Producto prod);
    @Query(value = "SELECT p from Producto p JOIN p.categoria c WHERE c.id = :idCat")
    public List<Producto> ultimos5_de_categoria(@Param(value = "idCat") Long idCat);
    @Query(value="SELECT p from Producto p JOIN p.ofertas o order by o.precio asc limit 10")
    public List<Producto> mejores10_precio(Oferta of);
    public List<Producto> ultimos5_productos_paginados(Date fecha);
    public Producto buscarProducto(String nombre, String cat);
}
