package com.add.chollapi.controller;

import com.add.chollapi.modelo.Oferta;
import com.add.chollapi.modelo.Producto;
import com.add.chollapi.repositorios.OfertaRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import java.util.List;
@Controller
public class OfertaController {

    @Autowired
    OfertaRepository oferta;

   // @RequestMapping(method= RequestMethod.GET, value = {"/","/oferta?idOferta"})
    //public String (){





}
