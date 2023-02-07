package com.add.chollapi.servicio;

import com.add.chollapi.modelo.Categoria;
import com.add.chollapi.modelo.Oferta;
import com.add.chollapi.modelo.Producto;

public interface OfertaService {
    Oferta obtenerOferta(Long id);
    Oferta crearOferta(Oferta oferta);
    Oferta modificarOferta(Oferta of);
    boolean borrarOferta(Long idOf);





}
