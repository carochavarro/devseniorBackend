package com.api.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.backend.models.Producto;

@Repository
public interface ProductRepository extends JpaRepository<Producto, Long>{

}


