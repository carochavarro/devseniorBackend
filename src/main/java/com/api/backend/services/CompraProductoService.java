package com.api.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.backend.models.CompraProducto;
import com.api.backend.models.Producto;
import com.api.backend.repository.CompraProductoRepository;
import com.api.backend.repository.ProductoRepository;

@Service
public class CompraProductoService {

    @Autowired
    private CompraProductoRepository compraProductoRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public CompraProducto save(CompraProducto compraProducto) {

        Producto producto = productoRepository.findById(compraProducto.getProducto().getId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // calcular precio por Producto
        double subtotal = producto.getPrecio() * compraProducto.getCantidad();
        compraProducto.setSubtotal(subtotal);

        compraProducto.setProducto(producto);

        return compraProductoRepository.save(compraProducto);
    }
}
