package com.api.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.backend.models.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

     String findByNombre(String nombre);

     Optional<Categoria> updateById(Long id);


}