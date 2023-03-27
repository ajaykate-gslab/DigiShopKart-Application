package com.example.digishopkart.controller;

import com.example.digishopkart.api.VariantApi;
import com.example.digishopkart.entity.ProductEntity;
import com.example.digishopkart.entity.VariantEntity;
import com.example.digishopkart.mapper.ProductMapper;
import com.example.digishopkart.mapper.VariantMapper;
import com.example.digishopkart.model.Variant;
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
public class VariantController implements VariantApi {
    @Autowired
    private VariantMapper variantMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private VariantRepository variantRepository;
    @Autowired
    private ProductRepository productRepository;

    //------------------------ API TO INSERT VARIANT INTO PREVIOUS PRODUCT ----------------------
    @Override
    public ResponseEntity<Variant> insertVariant(Integer productId, Variant body) {
        Optional<ProductEntity> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()) {
            ProductEntity productEntity = optionalProduct.get();
            List<VariantEntity> variantEntityList = optionalProduct.get().getVariant();
            variantEntityList.add(variantMapper.VariantModelToVariantEntity(body));
            productEntity.setVariant(variantEntityList);
            return new ResponseEntity(productRepository.save(productEntity), HttpStatus.CREATED);
        } else {
            return new ResponseEntity("Please enter valid productId to insert Variant", HttpStatus.NOT_FOUND);
        }
    }


    //------------------------ API TO DELETE VARIANT FROM PREVIOUS PRODUCT ----------------------
    @Override
    public ResponseEntity<Variant> deleteVariant(Integer variantId) {
        Optional<VariantEntity> optionalVariant = variantRepository.findById(variantId);
        if (optionalVariant.isPresent()) {
            variantRepository.deleteById(variantId);
            return new ResponseEntity("Variant '" + optionalVariant.get().getName() + "' deleted successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity("Please enter valid variantId...!!!", HttpStatus.NOT_FOUND);
        }
    }

    //------------------------ API TO FETCH ALL VARIANTS FROM ALL PRODUCTS ----------------------
    @Override
    public ResponseEntity<List<Variant>> fetchAllVariants() {
        return new ResponseEntity(variantRepository.findAll(), HttpStatus.OK);
    }

    //------------------------ API TO FETCH ALL VARIANTS FROM A PRODUCT ----------------------
    @Override
    public ResponseEntity<Variant> fetchVariant(Integer variantId) {
        Optional<VariantEntity> optionalVariant = variantRepository.findById(variantId);
        if (optionalVariant.isPresent()) {
            return new ResponseEntity(optionalVariant.get(), HttpStatus.FOUND);
        } else {
            return new ResponseEntity("Please enter valid variantId...!!!", HttpStatus.NOT_FOUND);
        }
    }

    //------------------------ API TO UPDATE VARIANT OF PREVIOUS PRODUCT ----------------------
    @Override
    public ResponseEntity<Variant> updateVariant(Integer variantId, Variant body) {
        Optional<VariantEntity> optionalVariant = variantRepository.findById(variantId);
        if (optionalVariant.isPresent()) {
            return new ResponseEntity(variantRepository.save(variantMapper.VariantModelToVariantEntity(body)), HttpStatus.OK);
        } else {
            return new ResponseEntity("Please enter valid variantId...!!!", HttpStatus.NOT_FOUND);
        }
    }
}
