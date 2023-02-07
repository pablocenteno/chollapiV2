package com.add.chollapi.servicio;

import com.add.chollapi.modelo.Producto;
import com.add.chollapi.repositorios.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
        ArrayList<Producto> productos= new ArrayList<>();
        for (Producto p:productos){
            if(p.getId().equals(idProd)){
                productoRepository.delete(p);
                return true;
            }
        }
        return false;
    }
}
