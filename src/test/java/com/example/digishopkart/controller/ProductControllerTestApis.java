package com.example.digishopkart.controller;

import com.example.digishopkart.entity.ProductEntity;
import com.example.digishopkart.entity.VariantEntity;
import com.example.digishopkart.mapper.ProductMapper;
import com.example.digishopkart.model.Product;
import com.example.digishopkart.model.Variant;
import com.example.digishopkart.repository.ProductRepository;
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
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

    ProductEntity productEntity = new ProductEntity();
    Product productDto = new Product();
    public static ProductEntity getProductEntity(){
        VariantEntity variantEntity = new VariantEntity(1,"size","L",
                Variant.StatusEnum.ACTIVE);
        List<VariantEntity> variantEntityList = new ArrayList<VariantEntity>();
        variantEntityList.add(variantEntity);
        ProductEntity productEntity = new ProductEntity(1,"Cotton T-Shirt","Allen Solly",
                1200.0, Product.ProductStatusEnum.ACTIVE,
                Product.ProductCategoryEnum.CLOTHS, variantEntityList);
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

        List<Variant> variantList=new ArrayList<Variant>();
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

    // ------------ Test case To InsertProduct Api -------------
    @Test
    public void testInsertProduct(){
        productEntity = getProductEntity();
        productDto = getProductDto();

        System.out.println(productDto);
        when(productRepository.save(productEntity)).thenReturn(productEntity);

        ResponseEntity<Product> productResponseEntity = productController.createProduct(productDto);

        assertEquals(HttpStatus.CREATED,productResponseEntity.getStatusCode());
        //assertEquals(productEntity,productResponseEntity.getBody());
    }

    // ------------ Test case To FetchtProduct Api -------------
    @Test
    public void testFetchProductReturnFound(){
        productEntity = getProductEntity();
        productDto= getProductDto();
        when(productRepository.findById(1)).thenReturn(Optional.of(productEntity));

        ResponseEntity<Product> productResponseEntity = productController.fetchProduct(productDto.getId());

        assertEquals(HttpStatus.FOUND,productResponseEntity.getStatusCode());
        assertEquals(productEntity,productResponseEntity.getBody());
    }

    @Test
    public void testFetchProductReturnNotFound(){
        productEntity = getProductEntity();
        productDto= getProductDto();
        String expectedResult = "Please enter valid productId..!!!";
        when(productRepository.findById(1)).thenReturn(Optional.empty());

        ResponseEntity<Product> productResponseEntity = productController.fetchProduct(productDto.getId());

        assertEquals(HttpStatus.NOT_FOUND,productResponseEntity.getStatusCode());
        assertEquals(expectedResult,productResponseEntity.getBody());
    }

    // ------------ Test case To FetchAllProduct Api -------------
    @Test
    public void fetchAllProductsTest(){
        productEntity = getProductEntity();
        when(productRepository.findAll()).thenReturn(Stream.of(productEntity).collect(Collectors.toList()));
        assertEquals(1,productController.fetchaAllProducts().getBody().size());
    }

    // ------------ Test case To UpdateProduct Api -------------
    @Test
    public void updateProductReturnFound(){
        productEntity = getProductEntity();
        productDto = getProductDto();
        when(productRepository.findById(1)).thenReturn(Optional.of(productEntity));
        when(productRepository.save(productEntity)).thenReturn(productEntity);

        ResponseEntity<Product> productResponseEntity = productController.updateProduct(productDto.getId(),productDto);

        assertEquals(HttpStatus.OK,productResponseEntity.getStatusCode());
        //assertEquals(productEntity,productResponseEntity.getBody());
    }

    @Test
    public void updateProductReturnNotFound(){
        productEntity = getProductEntity();
        productDto = getProductDto();
        String expectedResult = "Please enter valid productId...!!!";

        when(productRepository.findById(1)).thenReturn(Optional.empty());
        when(productRepository.save(productEntity)).thenReturn(productEntity);

        ResponseEntity<Product> productResponseEntity = productController.updateProduct(productDto.getId(),productDto);

        assertEquals(HttpStatus.NOT_FOUND,productResponseEntity.getStatusCode());
        assertEquals(expectedResult,productResponseEntity.getBody());
    }

    // ------------ Test case To DeleteProduct Api -------------
    @Test
    public void testDeleteProductReturnFound(){
        productDto = getProductDto();
        String expectedResult = "Product '"+ productEntity.getProductName()+"' is deleted successfully.";

        when(productRepository.findById(productDto.getId())).thenReturn(Optional.of(productEntity));

        ResponseEntity<Product> productResponseEntity = productController.deleteProduct(productDto.getId());
        assertEquals(HttpStatus.OK,productResponseEntity.getStatusCode());
        //assertEquals(expectedResult,productResponseEntity.getBody());
    }

    @Test
    public void testDeleteProductReturnNotFound(){
        productDto = getProductDto();
        String expectedResult = "Please enter valid productId";

        when(productRepository.findById(productDto.getId())).thenReturn(Optional.empty());
        ResponseEntity<Product> productResponseEntity = productController.deleteProduct(productDto.getId());

        assertEquals(HttpStatus.NOT_FOUND,productResponseEntity.getStatusCode());
        assertEquals(expectedResult,productResponseEntity.getBody());
    }




}
