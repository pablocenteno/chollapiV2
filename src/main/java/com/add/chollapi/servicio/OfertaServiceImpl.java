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

@Transactional
@Service
public class OfertaServiceImpl implements com.add.chollapi.servicio.OfertaService {

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
    public boolean borrarOferta(Long idOferta) {
        ArrayList<Oferta> ofertas = new ArrayList<>();
        for(Oferta o: ofertas) {
            if(o.getId().equals(idOferta)) {
                ofertaRepository.delete(o);
                return true;
            }
        }
        return false;
    }





}
