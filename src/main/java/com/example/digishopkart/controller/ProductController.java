package com.example.digishopkart.controller;

import com.example.digishopkart.api.ProductApi;
import com.example.digishopkart.entity.Variant;
import com.example.digishopkart.mapper.ProductMapper;
import com.example.digishopkart.mapper.VariantMapper;
import com.example.digishopkart.model.Product;
import com.example.digishopkart.repository.ProductRepository;
import com.example.digishopkart.repository.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@Component
public class ProductController implements ProductApi {
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
    public ResponseEntity<Product> createProduct(Product body) {
        return new ResponseEntity(productRepository.save(productMapper.ProductModelToProductEntity(body)), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Product> deleteProduct(Integer productId) {
        Optional<com.example.digishopkart.entity.Product> optionalProduct =productRepository.findById(productId);
        if (optionalProduct.isPresent()){
            productRepository.deleteById(productId);
            return new ResponseEntity("Product '"+optionalProduct.get().getProductName()+"' is deleted successfully.",HttpStatus.OK);
        }else {
            return new ResponseEntity("Please enter valid productId",HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Product> fetchProduct(Integer productId) {
        Optional<com.example.digishopkart.entity.Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()){
            return new ResponseEntity(optionalProduct.get(),HttpStatus.FOUND);
        }else {
            return new ResponseEntity("Please enter valid productId..!!!",HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<Product>> fetchaAllProducts() {
        return new ResponseEntity(productRepository.findAll(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Product> updateProduct(Integer productId, Product body) {
        Optional<com.example.digishopkart.entity.Product> optionalProduct =productRepository.findById(productId);
        if (optionalProduct.isPresent()){
            return new ResponseEntity(productRepository.save(productMapper.ProductModelToProductEntity(body)),HttpStatus.OK);
        }
        else {
            return new ResponseEntity("Please enter valid productId...!!!",HttpStatus.NOT_FOUND);
        }
    }
    /*
    // ---------------------------------- API TO INSERT PRODUCT -----------------------------------
    @Override
    public ResponseEntity<Product> insertProductPost(Product body) {
        com.example.digishopkart.entity.Product product =new com.example.digishopkart.entity.Product();
        product = productMapper.ProductModelToProductEntity(body);
        *//*System.out.println("***"+product.getProductCode());
         *//*
        product =productRepository.save(product);
        Variant variant=new Variant();
        variant = variantRepository.save(variantMapper.VariantModelToVariantEntity(body.getVariant()));

        return new ResponseEntity(product, HttpStatus.CREATED);
    }

    // ---------------------------------- API TO FETCH ALL PRODUCT -----------------------------------

    @Override
    public ResponseEntity<List<com.example.digishopkart.model.Product>> fetchAllProductsGet() {
        List<com.example.digishopkart.entity.Product> productList =
                productRepository.findAll();
        return new ResponseEntity(productList,HttpStatus.OK);
    }

    // ---------------------------------- API TO INSERT PRODUCT -----------------------------------
    @Override
    public ResponseEntity<com.example.digishopkart.model.Product> fetchProductByIdGet(Integer id) {
        Optional<com.example.digishopkart.entity.Product> optionalProduct =
            productRepository.findById(Integer.valueOf(id));
        if (optionalProduct.isPresent())
        {
            return new ResponseEntity(optionalProduct.get(),HttpStatus.FOUND);
        }
        else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

*/
}
