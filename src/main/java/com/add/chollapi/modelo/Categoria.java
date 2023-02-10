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
    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Expose
    private String nombre;
    @Expose
    private String descripcion;



    @OneToMany(mappedBy = "categoria", cascade = CascadeType.MERGE, orphanRemoval = true,fetch = FetchType.LAZY)
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
