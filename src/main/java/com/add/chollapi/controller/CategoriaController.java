package com.add.chollapi.controller;

import com.add.chollapi.modelo.Categoria;
import com.add.chollapi.modelo.Producto;
import com.add.chollapi.servicio.CategoriaService;
import com.add.chollapi.servicio.ProductoService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    public String toJson(Object object){
        Gson gson = new Gson();
                return gson.toJson(object);
    }

    @RequestMapping(method = RequestMethod.POST, value ={"/categoria"})
    public ResponseEntity<String> crearCategoria(@RequestBody Categoria categoria) {

        return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json").body(toJson(categoriaService.crearCategoria(categoria)));
    }

    @RequestMapping(method = RequestMethod.GET, value ={"/categoria"})
    public ResponseEntity<String> obtenerCategoria(@RequestParam Long id) {


        return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json").body(toJson(categoriaService.obtenerCategoria(id)));
    }

    @RequestMapping(method = RequestMethod.PUT, value ={"/categoria"})
    public ResponseEntity<String> modificarCategoria(@RequestBody Categoria categoria) {


        return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json").body(toJson(categoriaService.modificarCategoria(categoria)));
    }
    @RequestMapping(method = RequestMethod.DELETE, value ={"/categoria"})

    public ResponseEntity<Boolean> borrarCategoria(@RequestParam Long idCategoria) {


        return ResponseEntity.status(HttpStatus.OK).header("Content-Type", "application/json").body(categoriaService.borrarCategoria(idCategoria));
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/producto/ultimos5productos"})
    public ResponseEntity<String>ultimos5_de_categoria(@RequestParam Long idCategoria){
        return ResponseEntity.status(HttpStatus.OK).header("Content-Type","application/json").body(toJson(categoriaService.ultimos5_de_categoria(idCategoria)));
    }




}
