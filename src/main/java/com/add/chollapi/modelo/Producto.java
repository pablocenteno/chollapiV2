package com.add.chollapi.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;




@Entity
@Data
@NoArgsConstructor
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Long idFabricante;



    @ManyToMany
    @JoinTable(
            name="producto_oferta"
            , joinColumns={
            @JoinColumn(name="producto_id")
    }
            , inverseJoinColumns={
            @JoinColumn(name="oferta_id")
    }
    )
    private List<Oferta> ofertas = new ArrayList<Oferta>();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("categoria_id")
    private Categoria categoria;

    public void anadirOferta(Oferta o)
    {
        ofertas.add(o);
        o.getProductos().add(this);
    }

    public void eliminarOferta(Oferta o)
    {
        ofertas.remove(o);
        o.getProductos().remove(this);
    }


}
