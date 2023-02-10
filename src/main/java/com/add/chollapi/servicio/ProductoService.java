package com.add.chollapi.servicio;

import com.add.chollapi.dto.ProductoDto;
import com.add.chollapi.modelo.Oferta;
import com.add.chollapi.modelo.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductoService {
    Producto obtenerProducto(Long id);
    Producto crearProducto(Producto producto);
    Producto modificarProducto(Producto prod);
    boolean borrarProducto(Long idProd);

    Producto buscarProducto(String desc);
    List<Oferta> mejores10_precio(Long id);

    Page<Producto> productosPaginado(Pageable pageable);


}
