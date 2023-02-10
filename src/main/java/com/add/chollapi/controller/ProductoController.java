package com.add.chollapi.controller;

import com.add.chollapi.dto.ProductoDto;
import com.add.chollapi.modelo.Producto;
import com.add.chollapi.servicio.ProductoService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller

public class ProductoController {

    @Autowired
    ProductoService productoService;

    public String toJson(Object object){
        GsonBuilder gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation();
        return gson.create().toJson(object);
    }

    @RequestMapping(method = RequestMethod.POST, value ={"/producto"})
    public ResponseEntity<String> crearProducto(@RequestBody Producto producto) {


        return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json").body(toJson(productoService.crearProducto(producto)));
    }

    @RequestMapping(method = RequestMethod.GET, value ={"/producto"})
    public ResponseEntity<String> obtenerProducto(@RequestParam Long idProducto) {


        return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json").body(toJson(productoService.obtenerProducto(idProducto)));
    }
    @RequestMapping(method = RequestMethod.PUT, value ={"/producto"})
    public ResponseEntity<String > modificarProducto(@RequestBody Producto producto) {
        return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json").body(toJson(productoService.modificarProducto(producto)));
    }
    @RequestMapping(method = RequestMethod.DELETE, value ={"/producto"})
    public ResponseEntity<Boolean> borrarProducto(@RequestParam Long idProducto) {
        return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json").body(productoService.borrarProducto(idProducto));
    }



    @RequestMapping(method=RequestMethod.GET, value = {"/producto/mejores10oferta"})
    public ResponseEntity<String>mejores10_precio(@RequestParam Long idProducto){
        return ResponseEntity.status(HttpStatus.OK).header("Content-Type","application/json").body(toJson(productoService.mejores10_precio(idProducto)));
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/producto/buscar"})
    public ResponseEntity<String>buscarProducto(@RequestParam String texto){
        return ResponseEntity.status(HttpStatus.OK).header("Content-Type","application/json").body(toJson(productoService.buscarProducto(texto)));
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/producto/list"},params = {"count", "page"})
    public ResponseEntity<String> productosPaginado( @RequestParam(name = "count",defaultValue = "5") int count, @RequestParam(name="page",defaultValue = "0")int page){
        Pageable pageRequest = PageRequest.of(page, count);
        Page<Producto> productos=productoService.productosPaginado(pageRequest);
        return ResponseEntity.status(HttpStatus.OK).header("Content-Type","application/json").body(toJson(productos));
    }






}
