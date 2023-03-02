package com.example.digishopkart.controller;

import com.example.digishopkart.entity.Product;
import com.example.digishopkart.entity.Variant;
import com.example.digishopkart.mapper.ProductMapper;
import com.example.digishopkart.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductControllerTestApis {
    @MockBean
    private ProductRepository productRepository;
    @Autowired
    private ProductController productController;
    @Autowired
    private ProductMapper productMapper;

    Product product = new Product();
    public static Product getProductObject(){
        Variant variant = new Variant(1,"size","L",
                com.example.digishopkart.model.Variant.StatusEnum.ACTIVE);
        List<Variant> variantList = new ArrayList<Variant>();
        variantList.add(variant);
        Product product = new Product(1,"Cotton T-Shirt","Allen Solly",
                1200.0, com.example.digishopkart.model.Product.ProductStatusEnum.ACTIVE,
                com.example.digishopkart.model.Product.ProductCategoryEnum.CLOTHS,variantList);
      return product;
    }
    @Test
    public void insertProductTest(){
        product = getProductObject();
        when(productRepository.save(product)).thenReturn(product);
        System.out.println(product);
        assertEquals(product,productController
                .createProduct(productMapper.ProductEntityToProductmodel(product)).getBody());
    }

    @Test
    public void fetchProductTest(){
        product = getProductObject();
        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        assertEquals(product,productController.fetchProduct(product.getId()).getBody());
    }

    @Test
    public void fetchAllProductsTest(){
        product = getProductObject();
        when(productRepository.findAll()).thenReturn(Stream.of(product).collect(Collectors.toList()));
        assertEquals(1,productController.fetchaAllProducts().getBody().size());
    }

    @Test
    public void updateProduct(){
        product = getProductObject();
        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        when(productRepository.save(product)).thenReturn(product);

        assertEquals(product,productController.updateProduct(1,productMapper.ProductEntityToProductmodel(product)).getBody());
    }

    @Test
    public void deleteProductTest(){
        product = getProductObject();
        when(productRepository.findById(1)).thenReturn(Optional.of(product));
        //productController.deleteProduct(product.getId());
        String expectedResult = "Product '"+product.getProductName()+"' is deleted successfully.";
        assertEquals(expectedResult,productController.deleteProduct(product.getId()).getBody());
    }



}
