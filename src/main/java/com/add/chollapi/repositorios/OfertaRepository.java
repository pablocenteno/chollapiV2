package com.add.chollapi.repositorios;

import com.add.chollapi.modelo.Categoria;
import com.add.chollapi.modelo.Oferta;
import com.add.chollapi.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Long>, PagingAndSortingRepository<Oferta, Long> {
    public Oferta obtenerOferta(Oferta of);
    public Oferta crearOferta(Oferta of);
    public Oferta modificarOferta(Oferta of);
    public boolean borrarOferta(Oferta of);

    @Query(value = "SELECT o FROM Oferta o JOIN o.productos p WHERE p.id = :idProc ORDER BY o.fecha desc limit 5")
    public List<Oferta> ultimas5_de_producto(@Param(value = "idProc") Long idProc);
    @Query(value="SELECT o from Oferta o JOIN o.productos p JOIN p.categoria  c  WHERE c.id= :cat")
    public List<Oferta> ultimas5_de_categoria(@Param(value = "cat") Long cat);
//    @Query(value = "SELECT o from Oferta o or")xº
    public List<Oferta> ultimas_paginadas_fecha(Date fecha);
}

