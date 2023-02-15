package com.add.chollapi.dto;

import com.google.gson.annotations.Expose;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OfertaDto implements Serializable
{
    private String url;

    private Date fecha_hora_publicacion;

    private Float precio;

    private Boolean disponible;

    private Long idProducto;
}
