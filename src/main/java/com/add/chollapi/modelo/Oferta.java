package com.add.chollapi.modelo;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.NamedQuery;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Oferta implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String url;
    private Date fecha;
    private Float precio;
    private Boolean disponible;

    @ManyToMany(mappedBy="ofertas", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private List<Producto> productos = new ArrayList<Producto>();

    public void anadirProducto(Producto p) {
        productos.add(p);
        p.getOfertas().add(this);
    }

    public void eliminarProducto(Producto p) {
        productos.remove(p);
        p.getOfertas().remove(this);
    }
}
