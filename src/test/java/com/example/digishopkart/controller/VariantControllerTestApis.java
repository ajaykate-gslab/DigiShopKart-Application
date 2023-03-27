package com.example.digishopkart.controller;

import com.example.digishopkart.entity.ProductEntity;
import com.example.digishopkart.entity.VariantEntity;
import com.example.digishopkart.mapper.ProductMapper;
import com.example.digishopkart.mapper.VariantMapper;
import com.example.digishopkart.model.Product;
import com.example.digishopkart.model.Variant;
import com.example.digishopkart.repository.ProductRepository;
import com.example.digishopkart.repository.VariantRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    ProductEntity productEntity =new ProductEntity();
    VariantEntity variantEntity =new VariantEntity();

    Product productDto= new Product();
    Variant variantDto = new Variant();
    int variantId =1;
    int productId =1 ;

    public static ProductEntity getProductEntity(){
        VariantEntity variantEntity1 = new VariantEntity(1,"size","L", Variant.StatusEnum.ACTIVE);
        VariantEntity variantEntity2 = new VariantEntity(2,"size","XL",Variant.StatusEnum.ACTIVE);

        List<VariantEntity> variantEntityList = new ArrayList<VariantEntity>();
        variantEntityList.add(variantEntity1);
        variantEntityList.add(variantEntity2);

        ProductEntity productEntity = new ProductEntity(1,"Cotton T-Shirt","Allen Solly", 1200.0,Product.ProductStatusEnum.ACTIVE, Product.ProductCategoryEnum.CLOTHS, variantEntityList);
        return productEntity;
    }

    public static Product getProductDto(){
        Variant variant1=new Variant();
        variant1.setId(1);
        variant1.setName("size");
        variant1.setValue("L");
        variant1.setStatus(Variant.StatusEnum.ACTIVE);

        Variant variant2=new Variant();
        variant2.setId(2);
        variant2.setName("size");
        variant2.setValue("XL");
        variant2.setStatus(Variant.StatusEnum.ACTIVE);

        List<Variant> variantList = new ArrayList<Variant>();
        variantList.add(variant1);
        variantList.add(variant2);

        Product product=new Product();
        product.setId(1);
        product.setProductName("Cotton T-Shirt");
        product.setBrand("Allen Solly");
        product.setProductPrice(1200.0);
        product.setProductStatus(Product.ProductStatusEnum.ACTIVE);
        product.setProductCategory(Product.ProductCategoryEnum.CLOTHS);
        product.setVariant(variantList);

        return product;
    }

    // --------- Test Case To AddVariant Api --------------
    @Test
    public void testAddVariant_WhenProductFound(){

        variantEntity = getProductEntity().getVariant().get(0);
        variantDto = getProductDto().getVariant().get(0);

        when(productRepository.findById(productId)).thenReturn(Optional.of(productEntity));
        when(productRepository.save(productEntity)).thenReturn(productEntity);

        ResponseEntity<Variant> variantResponseEntity = variantController.insertVariant(productId,variantDto);

        assertEquals(HttpStatus.CREATED,variantResponseEntity.getStatusCode());
        assertEquals(productEntity,variantResponseEntity.getBody());
    }

    @Test
    public void testAddVariant_WhenProductNotFound(){

        variantEntity = getProductEntity().getVariant().get(0);
        variantDto = getProductDto().getVariant().get(0);
        String expectedResult = "Please enter valid productId to insert Variant";
        when(productRepository.findById(productId)).thenReturn(Optional.empty());

        ResponseEntity<Variant> variantResponseEntity = variantController.insertVariant(productId,variantDto);

        assertEquals(HttpStatus.NOT_FOUND,variantResponseEntity.getStatusCode());
        assertEquals(expectedResult,variantResponseEntity.getBody());
    }


    // --------- Test Case To FetchVariant Api --------------
    @Test
    public void testFetchVarianReturnFound(){
        Integer variantId = 1;
        variantEntity = getProductEntity().getVariant().get(0);

        when(variantRepository.findById(variantId)).thenReturn(Optional.of(variantEntity));

        ResponseEntity<Variant> variantResponseEntity =variantController.fetchVariant(variantId);

        assertEquals(HttpStatus.FOUND,variantResponseEntity.getStatusCode());
        assertEquals(variantEntity,variantResponseEntity.getBody());
    }

    @Test
    public void testFetchVarianReturnNotFound(){
        Integer variantId = 1;
        variantEntity = getProductEntity().getVariant().get(0);
        String expectedResult = "Please enter valid variantId...!!!";
        when(variantRepository.findById(variantId)).thenReturn(Optional.empty());

        ResponseEntity<Variant> variantResponseEntity =variantController.fetchVariant(variantId);

        assertEquals(HttpStatus.NOT_FOUND,variantResponseEntity.getStatusCode());
        assertEquals(expectedResult,variantResponseEntity.getBody());
    }


    // --------- Test Case To FetchAllVariant Api --------------
    @Test
    public void testFetchAllVariants(){
        List<VariantEntity> variantEntityList = getProductEntity().getVariant();

        when(variantRepository.findAll()).thenReturn(variantEntityList);

        ResponseEntity<List<Variant>> variantResponseEntity = variantController.fetchAllVariants();

        assertEquals(HttpStatus.OK,variantResponseEntity.getStatusCode());
        assertEquals(variantEntityList,variantResponseEntity.getBody());
    }


    // --------- Test Case To DeleteVariant Api --------------
    @Test
    public void testDeleteVariantReturnFound(){
        int variantId = 1;
        variantEntity = getProductEntity().getVariant().get(0);
        String expectedResult = "Variant "+ "'"+variantEntity.getName()+"' deleted successfully.";
        when(variantRepository.findById(variantId)).thenReturn(Optional.of(variantEntity));

        ResponseEntity<Variant> variantResponseEntity = variantController.deleteVariant(variantId);

        assertEquals(HttpStatus.OK,variantResponseEntity.getStatusCode());
        assertEquals(expectedResult,variantResponseEntity.getBody());
    }

    @Test
    public void testDeleteVariantReturnNotFound(){
        int variantId = 1;
        variantEntity = getProductEntity().getVariant().get(0);
        String expectedResult = "Please enter valid variantId...!!!";
        when(variantRepository.findById(variantId)).thenReturn(Optional.empty());

        ResponseEntity<Variant> variantResponseEntity = variantController.deleteVariant(variantId);

        assertEquals(HttpStatus.NOT_FOUND,variantResponseEntity.getStatusCode());
        assertEquals(expectedResult,variantResponseEntity.getBody());
    }

// --------- Test Case To UpdateVariant Api --------------

    @Test
    public void updateVariant_ValidVariantId_ReturnsOK() {
        variantEntity =getProductEntity().getVariant().get(0);
        variantDto = getProductDto().getVariant().get(0);

        // Arrange
        Integer variantId = 1;
        when(variantRepository.findById(variantId)).thenReturn(Optional.of(variantEntity));
       // when(variantMapper.VariantModelToVariantEntity(variant)).thenReturn(variantEntity);

        // Act
        ResponseEntity<Variant> response = variantController.updateVariant(variantId, variantDto);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        //assertEquals(variantEntity,response.getBody());
    }

    @Test
    public void updateVariant_InvalidVariantId_ReturnsNotFound() {
        // Arrange
        Integer variantId = 1;
        variantEntity =getProductEntity().getVariant().get(0);
        variantDto = getProductDto().getVariant().get(0);
        String expectedResult ="Please enter valid variantId...!!!";

        when(variantRepository.findById(variantId)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Variant> response = variantController.updateVariant(variantId, variantDto);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(expectedResult,response.getBody());
    }
}
