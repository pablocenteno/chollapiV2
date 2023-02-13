package com.add.chollapi.modelo;

import com.google.gson.annotations.Expose;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NamedQuery;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Oferta implements Serializable {
    @Expose
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long idOferta;
    @Expose
    private String url;
    @Expose
   // @Temporal(TemporalType.DATE)
    private Date fecha_hora_publicacion;
    @Expose
    private Float precio;
    @Expose
    private Boolean disponible;

    @ManyToMany(mappedBy="ofertas", cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    private List<Producto> productos = new ArrayList<Producto>();

    public Oferta(String url, Date fecha_hora_publicacion, Float precio, Boolean disponible) {
        this.url = url;
        this.fecha_hora_publicacion = fecha_hora_publicacion;
        this.precio = precio;
        this.disponible = disponible;
    }

    public void anadirProducto(Producto p) {
        productos.add(p);
        p.getOfertas().add(this);
    }

    public void eliminarProducto(Producto p) {
        productos.remove(p);
        p.getOfertas().remove(this);
    }
}
