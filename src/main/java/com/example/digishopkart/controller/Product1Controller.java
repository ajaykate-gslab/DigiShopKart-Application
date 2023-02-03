package com.example.digishopkart.controller;

import com.example.digishopkart.mapper.Product1Mapper;
import com.example.digishopkart.mapper.ProductMapper;
import com.example.digishopkart.model.Product;
import com.example.digishopkart.repository.Product1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Product1Controller /*implements InsertProductApi */ {
    @Autowired
    private Product1Repository product1Repository;
    @Autowired
    private Product1Mapper product1Mapper;
    @Autowired
    private ProductMapper productMapper;

    // @Override
    public ResponseEntity<Product> insertProductPost(Product body) {
        //Product product=product1Repository.save(product1Mapper.entityProduct1ToModelProduct(body));

        System.out.println("***8" + product1Mapper.modelProductToEntityProduct1(body).getVariant1());
        return new ResponseEntity(body,
                HttpStatus.CREATED);
    }
   /* @PostMapping("/insertProduct1")
    public ResponseEntity<Product1> insertProduct(@RequestBody Product1 product1){
        return new ResponseEntity(product1Repository.save(product1), HttpStatus.CREATED);
    }*/
}
