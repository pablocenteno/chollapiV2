package com.add.chollapi.servicio;

import com.add.chollapi.modelo.Categoria;
import com.add.chollapi.modelo.Oferta;
import com.add.chollapi.modelo.Producto;
import com.add.chollapi.repositorios.CategoriaRepository;
import com.add.chollapi.repositorios.OfertaRepository;
import com.add.chollapi.repositorios.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ServiceImpls implements com.add.chollapi.servicio.Service {

    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    ProductoRepository productoRepository;
    @Autowired
    OfertaRepository ofertaRepository;


    @Override
    public Oferta obtenerOferta(Long id) {
        return ofertaRepository.getById(id);
    }

    @Override
    public Oferta crearOferta(Oferta oferta) {
        ArrayList<Oferta> ofertas = new ArrayList<>();
        for(Oferta o: ofertas) {
            if(o.equals(oferta)) {
                System.out.println("Error, esa oferta ya existe");
                return null;
            }
        }
        return ofertaRepository.save(oferta);
    }

    @Override
    public Oferta modificarOferta(Oferta of) {
        return ofertaRepository.save(of);
    }

    @Override
    public boolean borrarOferta(Oferta of) {
        ArrayList<Oferta> ofertas = new ArrayList<>();
        for(Oferta o: ofertas) {
            if(o.equals(of)) {
                ofertaRepository.delete(o);
                return true;
            }
        }
        return false;
    }

    @Override
    public Categoria crearCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Optional<Categoria> obtenerCategoria(Long id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria modificarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public boolean borrarCategoria(Long idcat) {

        Categoria cat = categoriaRepository.findById(idcat).get();
        List<Producto> lista = cat.getProductos();
        for (Producto p : lista) {
            p.getCategoria().setId(1L);
        }

        return true;
    }
}
