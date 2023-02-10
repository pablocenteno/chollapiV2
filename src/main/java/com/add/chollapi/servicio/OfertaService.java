package com.add.chollapi.servicio;

import com.add.chollapi.modelo.Categoria;
import com.add.chollapi.modelo.Oferta;
import com.add.chollapi.modelo.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OfertaService {
    Oferta obtenerOferta(Long id);
    Oferta crearOferta(Oferta oferta);
    Oferta modificarOferta(Oferta of);
    boolean borrarOferta(Long idOf);

    List<Oferta>ultimas5_de_producto(Long idProd);

    List<Oferta>ultimas5_de_categoria(Long idCat);

    Page<Oferta>ofertasPaginadas(Pageable pageable);





}
