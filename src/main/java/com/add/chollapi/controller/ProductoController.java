package com.add.chollapi.controller;

import com.add.chollapi.modelo.Producto;
import com.add.chollapi.servicio.ProductoService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chollapi")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    public String toJson(Object object){
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    @RequestMapping(method = RequestMethod.POST, value ={"/producto"})
    public ResponseEntity<String> crearProducto(@RequestBody Producto producto) {


        return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json").body(toJson(productoService.crearProducto(producto)));
    }

    @RequestMapping(method = RequestMethod.GET, value ={"/producto"})
    public ResponseEntity<String> obtenerProducto(@RequestParam Long id) {


        return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json").body(toJson(productoService.obtenerProducto(id)));
    }
    @RequestMapping(method = RequestMethod.PUT, value ={"/producto"})
    public ResponseEntity<String > modificarProducto(@RequestBody Producto producto) {
        return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json").body(toJson(productoService.modificarProducto(producto)));
    }
    @RequestMapping(method = RequestMethod.DELETE, value ={"/producto"})
    public ResponseEntity<Boolean> borrarProducto(@RequestParam Long idProducto) {
        return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json").body(productoService.borrarProducto(idProducto));
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/producto"})
    public ResponseEntity<String>


}
