package com.example.digishopkart.controller;

import com.example.digishopkart.api.FetchAllProductsApi;
import com.example.digishopkart.api.FetchProductByIdApi;
import com.example.digishopkart.api.InsertProductApi;
import com.example.digishopkart.entity.Variant;
import com.example.digishopkart.mapper.ProductMapper;
import com.example.digishopkart.mapper.VariantMapper;
import com.example.digishopkart.model.Product;
import com.example.digishopkart.repository.ProductRepository;
import com.example.digishopkart.repository.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController implements InsertProductApi, FetchProductByIdApi, FetchAllProductsApi {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private VariantRepository variantRepository;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private VariantMapper variantMapper;
    // ---------------------------------- API TO INSERT PRODUCT -----------------------------------
    @Override
    public ResponseEntity<Product> insertProductPost(Product body) {
        com.example.digishopkart.entity.Product product =new com.example.digishopkart.entity.Product();
        product = productMapper.ProductModelToProductEntity(body);
        /*System.out.println("***"+product.getProductCode());
         */
        product =productRepository.save(product);
        Variant variant=new Variant();
        variant = variantRepository.save(variantMapper.VariantModelToVariantEntity(body.getVariant()));

        return new ResponseEntity(product, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<com.example.digishopkart.model.Product>> fetchAllProductsGet() {
        return null;
    }

    // ---------------------------------- API TO INSERT PRODUCT -----------------------------------
    @Override
    public ResponseEntity<com.example.digishopkart.model.Product> fetchProductByIdGet(String id) {
        Optional<com.example.digishopkart.entity.Product> optionalProduct =
            productRepository.findById(Integer.valueOf(id));
        if (optionalProduct.isPresent()){
            return new ResponseEntity(optionalProduct.get(),HttpStatus.FOUND);
        }
        else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


}
