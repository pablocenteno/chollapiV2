package com.add.chollapi.controller;

import com.add.chollapi.modelo.Oferta;
import com.add.chollapi.modelo.Producto;
import com.add.chollapi.repositorios.OfertaRepository;
import com.add.chollapi.servicio.OfertaService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@Controller
@RequestMapping("/chollapi")
public class OfertaController {

    @Autowired
    OfertaService ofertaService;

    public String toJson(Object object){
        GsonBuilder gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        return gson.create().toJson(object);
    }

   @RequestMapping(method= RequestMethod.POST, value = {"/oferta"})
       public ResponseEntity<String>crearOferta(@RequestBody Oferta oferta){

       return ResponseEntity.status(HttpStatus.OK).header("Content-Type","application/json").body(toJson(ofertaService.crearOferta(oferta)));
   }

    @RequestMapping(method= RequestMethod.GET, value = {"/oferta"})
    public ResponseEntity<String>obtenerOferta(@RequestParam Long id){

        return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json").body(toJson(ofertaService.obtenerOferta(id)));
    }

    @RequestMapping(method= RequestMethod.PUT, value = {"/oferta"})
    public ResponseEntity<String>modificarOferta(@RequestBody Oferta oferta){

        return ResponseEntity.status(HttpStatus.OK).header("Content-Type","application/json").body(toJson(ofertaService.modificarOferta(oferta)));
    }


    @RequestMapping(method= RequestMethod.DELETE, value = {"/oferta"})
    public ResponseEntity<Boolean>borrarOferta(@RequestParam Long idOferta){

        return ResponseEntity.status(HttpStatus.OK).header("Content-Type","application/json").body(ofertaService.borrarOferta(idOferta));
    }

    @RequestMapping(method= RequestMethod.GET, value = {"/oferta/ultimas5ofertas"})
    public ResponseEntity<String>ultimas5_de_producto(@RequestParam Long idProducto){

        return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json").body(toJson(ofertaService.obtenerOferta(idProducto)));
    }

    @RequestMapping(method= RequestMethod.GET, value = {"/oferta/ultimas5"})
    public ResponseEntity<String>ultimas5_de_categoria(@RequestParam Long idCategoria){
        return ResponseEntity.status(HttpStatus.OK).header("Content-Type","application/json").body(toJson(ofertaService.ultimas5_de_categoria(idCategoria)));
    }

    @RequestMapping(method= RequestMethod.GET, value = "/oferta/list", params = {"count", "page"})
    public ResponseEntity<String> ofertasPaginadas(@RequestParam(name = "count", defaultValue = "5")int count, @RequestParam(name = "page", defaultValue = "1") int page){
        Page<Oferta> ofertas=ofertaService.ofertasPaginadas(PageRequest.of(count, page));
        return ResponseEntity.status(HttpStatus.OK).header("Content-Type","application/json").body(toJson(ofertas));
    }





}
