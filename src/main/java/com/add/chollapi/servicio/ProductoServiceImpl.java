package com.add.chollapi.servicio;

import com.add.chollapi.modelo.Oferta;
import com.add.chollapi.modelo.Producto;
import com.add.chollapi.repositorios.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Transactional
@Service
public class ProductoServiceImpl implements ProductoService
{
    @Autowired
    ProductoRepository productoRepository;

    @Override
    public Producto obtenerProducto(Long id) {
        return productoRepository.findById(id).get();
    }

    @Override
    public Producto crearProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto modificarProducto(Producto prod) {
        return productoRepository.save(prod);
    }

    @Override
    public boolean borrarProducto(Long idProd) {


                productoRepository.deleteById(idProd);
                return true;
    }

    @Override
    public Producto buscarProducto(String desc) {
        return productoRepository.buscarProducto(desc);
    }

    @Override
    public List<Oferta> mejores10_precio(Long id) {
        return productoRepository.mejores10_precio(id);
    }

    @Override
    public Page<Producto> productosPaginado(Pageable pageable) {
        return productoRepository.findAll(pageable);
    }


}
