package com.api.backend.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.backend.models.Producto;


@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{


}


