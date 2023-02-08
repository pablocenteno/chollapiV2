package com.add.chollapi.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Categoria implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;



    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Producto> productos = new ArrayList<>();

    public void addProducto(Producto p){
        productos.add(p);
        p.setCategoria(this);
    }

    public void removeProducto(Producto p){
        productos.remove(p);
        p.setCategoria(null);
    }

}
