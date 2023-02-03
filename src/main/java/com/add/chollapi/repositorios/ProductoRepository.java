package com.add.chollapi.repositorios;



import com.add.chollapi.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @Query(value = "SELECT p from Producto p JOIN p.categoria c WHERE c.id = :idCat", nativeQuery = true)
    public List<Producto> ultimos5_de_categoria(@Param(value = "idCat") Long idCat);
    @Query(value="SELECT p from Producto p JOIN p.ofertas o WHERE p.id =:id order by o.precio asc limit 10",nativeQuery = true)
    public List<Producto> mejores10_precio(@Param(value="id") String id );
    public List<Producto> ultimos5_productos_paginados(Date fecha);
    @Query(value="SELECT p from Producto p JOIN p.categoria c WHERE p.nombre =:nombre and c.descripcion LIKE  %:desc%", nativeQuery = true)
    public Producto buscarProducto(@Param(value = "nombre")String nombre, @Param(value = "desc")  String desc);
}
