package com.api.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.backend.models.CompraProducto;
import com.api.backend.services.CompraProductoService;

@Controller
@RestController
@RequestMapping("/api/compraProducto")
public class CompraProductoController {

    @Autowired
    private CompraProductoService compraProductoService; 

    @PostMapping
    public ResponseEntity<CompraProducto> crear(@RequestBody CompraProducto compraProducto){
        CompraProducto newCompraProducto = compraProductoService.save(compraProducto);
        return new ResponseEntity<>(newCompraProducto, HttpStatus.CREATED);
    }
}
