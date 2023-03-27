package com.example.digishopkart.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import jakarta.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductEntity {

  /*  @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productId", nullable = false)
    private Integer productId;
*/
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

  @NotEmpty(message = "productName should not be null")
  private String productName;
  @NotEmpty(message = "productCode should not be null")
  private String brand;
  @NotNull(message = "productPrice should not be null")
  private double productPrice;
  @NonNull
  @Enumerated(EnumType.STRING)
  @Column(name = "status")
    private com.example.digishopkart.model.Product.ProductStatusEnum productStatus;
    private com.example.digishopkart.model.Product.ProductCategoryEnum productCategory;
  /*@OneToOne(*//*mappedBy = "product",*//*fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Variant variant;*/

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = "variant_id", referencedColumnName = "id")
  private List<VariantEntity> variant = new ArrayList<VariantEntity>();
}
