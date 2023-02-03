package com.example.digishopkart.services;

import com.example.digishopkart.api.InsertProductApi;
import com.example.digishopkart.mapper.ProductMapper;
import com.example.digishopkart.mapper.VariantMapper;
import com.example.digishopkart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
public class ProductService implements InsertProductApi {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private VariantMapper variantMapper;
    @Autowired
    private ProductRepository productRepository;


    // ----------------------- SERVICE TO INSERT PRODUCT -----------------
    @Override
    public ResponseEntity<com.example.digishopkart.model.Product> insertProductPost(com.example.digishopkart.model.Product body) {
        return new ResponseEntity(productRepository.
                save(productMapper.ProductModelToProductEntity(body)), HttpStatus.CREATED);
    }
}
