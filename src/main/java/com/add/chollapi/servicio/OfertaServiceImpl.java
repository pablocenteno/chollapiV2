package com.add.chollapi.servicio;

import com.add.chollapi.modelo.Categoria;
import com.add.chollapi.modelo.Oferta;
import com.add.chollapi.modelo.Producto;
import com.add.chollapi.repositorios.CategoriaRepository;
import com.add.chollapi.repositorios.OfertaRepository;
import com.add.chollapi.repositorios.ProductoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        return ofertaRepository.findById(id).get();
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

                ofertaRepository.deleteById(idOferta);
                return true;

    }

    @Override
    public List<Oferta>ultimas5_de_producto(Long idProd) {
        return ofertaRepository.ultimas5_de_producto(idProd);
    }

    @Override
    public List<Oferta> ultimas5_de_categoria(Long idCat) {
        return ofertaRepository.ultimas5_de_categoria(idCat);
    }

    @Override
    public Page<Oferta> ofertasPaginadas(Pageable pageable) {
        return ofertaRepository.findAll(pageable);
    }


}
