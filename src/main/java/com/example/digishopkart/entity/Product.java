package com.example.digishopkart.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

  /*  @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productId", nullable = false)
    private Integer productId;
*/
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;
    private String productName;
    private String productCode;
    private double productPrice;
    private com.example.digishopkart.model.Product.ProductStatusEnum productStatus;
    private com.example.digishopkart.model.Product.ProductCategoryEnum productCategory;
  @OneToOne(mappedBy = "product",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Variant variant;
}
