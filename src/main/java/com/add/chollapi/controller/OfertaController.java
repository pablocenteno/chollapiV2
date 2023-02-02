package com.add.chollapi.controller;

import com.add.chollapi.modelo.Oferta;
import com.add.chollapi.modelo.Producto;
import com.add.chollapi.repositorios.OfertaRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class OfertaController {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    OfertaRepository oferta;



}
