package com.api.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.backend.models.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long > {
    

}
