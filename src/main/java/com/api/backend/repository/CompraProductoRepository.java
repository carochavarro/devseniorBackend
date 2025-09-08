package com.api.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.backend.models.CompraProducto;

@Repository
public interface CompraProductoRepository extends JpaRepository<CompraProducto, Long>{

}
