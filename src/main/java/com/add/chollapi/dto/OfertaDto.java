package com.add.chollapi.dto;

import com.google.gson.annotations.Expose;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

public class OfertaDto {
    private Long id;

    private String url;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private Float precio;

    private Boolean disponible;
}
