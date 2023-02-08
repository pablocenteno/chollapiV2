package com.add.chollapi.servicio;

import com.add.chollapi.modelo.Categoria;
import com.add.chollapi.modelo.Producto;
import com.add.chollapi.repositorios.CategoriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Transactional
@Service
public class CategoriaServiceImpl implements com.add.chollapi.servicio.CategoriaService{

    @Autowired
    CategoriaRepository categoriaRepository;
    @Override
    public Categoria crearCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria obtenerCategoria(Long id) {
        return categoriaRepository.findById(id).get();
    }

    @Override
    public Categoria modificarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public boolean borrarCategoria(Long idcat) {

        Categoria cat = categoriaRepository.findById(idcat).get();
        Categoria cat1= categoriaRepository.findById(1L).get();
        List<Producto> lista = cat.getProductos();
        for (Producto p : lista) {
            p.setCategoria(cat1);
        }
        categoriaRepository.deleteById(idcat);

        return true;
    }
}
