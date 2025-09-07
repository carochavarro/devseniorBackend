package com.api.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.backend.models.Compra;
import com.api.backend.services.CompraService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RestController
@RequestMapping("/api/compra")
public class CompraController {

    @Autowired
    private CompraService compraService; 

    @PostMapping
    public ResponseEntity<Compra> save(@RequestBody Compra compra) {
        Compra newCompra = compraService.save(compra);
        return new ResponseEntity<>(newCompra, HttpStatus.CREATED);
    }
    
    
    
}
