package com.api.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.backend.models.Compra;
import com.api.backend.repository.CompraRepository;

@Service
public class CompraService {
 
    @Autowired
    private  CompraRepository compraRepository;

    public Compra save (Compra compra){
        return compraRepository.save(compra);
    } 

}
