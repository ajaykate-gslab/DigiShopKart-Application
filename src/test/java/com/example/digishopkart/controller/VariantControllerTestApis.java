package com.example.digishopkart.controller;

import com.example.digishopkart.entity.Product;
import com.example.digishopkart.entity.Variant;
import com.example.digishopkart.mapper.ProductMapper;
import com.example.digishopkart.mapper.VariantMapper;
import com.example.digishopkart.repository.ProductRepository;
import com.example.digishopkart.repository.VariantRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(SpringRunner.class)
public class VariantControllerTestApis {
    @Autowired
    private VariantController variantController;
    @Autowired
    private VariantMapper variantMapper;
    @Autowired
    private ProductMapper productMapper;
    @MockBean
    private VariantRepository variantRepository;
    @MockBean
    private ProductRepository productRepository;
    Product product=new Product();
    Variant variant=new Variant();
    int variantId =1;
    int productId =1 ;

    public static Product getProductObject(){
        Variant variant = new Variant(1,"size","L",
                com.example.digishopkart.model.Variant.StatusEnum.ACTIVE);
        List<Variant> variantList = new ArrayList<Variant>();
        variantList.add(variant);
        Product product = new Product(1,"Cotton T-Shirt","Allen Solly",
                1200.0,com.example.digishopkart.model.Product.ProductStatusEnum.ACTIVE,
                com.example.digishopkart.model.Product.ProductCategoryEnum.CLOTHS,variantList);
        return product;
    }

    @Test
    public void addVariantTest(){
        product = getProductObject();
        variant = getProductObject().getVariant().get(0);
        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        when(productRepository.save(product)).thenReturn(product);
        System.out.println(product);
        assertEquals(product,variantController.insertVariant(productId,variantMapper
                .VariantEntityToVariantModel(variant)).getBody());
    }

    @Test
    public void fetchVarianTest(){
        variant = getProductObject().getVariant().get(0);
        when(variantRepository.findById(variantId)).thenReturn(Optional.of(variant));
        assertEquals(variant,variantController.fetchVariant(variantId).getBody());
    }

    @Test
    public void fetchAllVariant(){
        List<Variant> variantList=getProductObject().getVariant();
        when(variantRepository.findAll()).thenReturn(variantList);
        assertEquals(variantList,variantController.fetchAllVariants().getBody());
    }

    @Test
    public void deleteVariant(){
        variant =getProductObject().getVariant().get(0);
        when(variantRepository.findById(variantId)).thenReturn(Optional.of(variant));
        assertEquals("Variant '"+variant.getName()+"' deleted successfully.",variantController
                .deleteVariant(variantId).getBody());
    }

}
