package com.add.chollapi.servicio;

import com.add.chollapi.dto.OfertaDto;
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
    private OfertaRepository ofertaRepository;
    @Autowired
    private ProductoRepository productoRepository;


    @Override
    public Oferta obtenerOferta(Long id) {
        return ofertaRepository.findById(id).get();
    }

    @Override
    public Oferta crearOferta(OfertaDto ofertaDto)
    {
        for(Oferta o: ofertaRepository.findAll())
        {
            if(o.getPrecio().equals(ofertaDto.getPrecio())
                    && o.getFecha_hora_publicacion().getTime()==(ofertaDto.getFecha_hora_publicacion().getTime())
                    &&o.getDisponible()==true)
            {
                System.out.println("Error, esa oferta ya existe");
                return null;
            }
        }

        Oferta oferta = new Oferta(ofertaDto.getUrl(), ofertaDto.getFecha_hora_publicacion(), ofertaDto.getPrecio(), ofertaDto.getDisponible());

        oferta.anadirProducto(productoRepository.findById(ofertaDto.getIdProducto()).get());

        return ofertaRepository.save(oferta);
    }

    @Override
    public Oferta modificarOferta(Oferta of) {
        return ofertaRepository.save(of);
    }

    @Override
    public boolean borrarOferta(Long idOferta)
    {
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
