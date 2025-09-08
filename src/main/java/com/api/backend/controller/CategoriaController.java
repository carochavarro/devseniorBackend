package com.api.backend.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.backend.models.Categoria;
import com.api.backend.services.CategoriaService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Slf4j
@Controller
@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> crearCategoria(@RequestBody Categoria categoria) {
        log.info("Categori {}", categoria);
        Categoria newCategoria = categoriaService.save(categoria);

        return new ResponseEntity<>(newCategoria, HttpStatus.CREATED);
    }

    @GetMapping()
    public String getMethodName(@RequestBody String param) {
        return new String("Hola preciosa");
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Categoria> obtenerCategoriaId(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaService.findById(id);
        return categoria.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("actualizar/{id}")
    public ResponseEntity<Categoria> updateById(@PathVariable Long id, @RequestBody Categoria detailsCategoria) {
        Optional<Categoria> optionalCategoria = categoriaService.findById(id);
        if (optionalCategoria.isPresent()) {
            Categoria categoria = optionalCategoria.get();
            categoria.setNombre(detailsCategoria.getNombre());
            Categoria updateCategoria = categoriaService.save(categoria);
            return ResponseEntity.ok(updateCategoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
