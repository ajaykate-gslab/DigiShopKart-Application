package com.example.digishopkart.model;

import java.util.Objects;
import com.example.digishopkart.model.Variant;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Product
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-02T16:50:15.386324942+05:30[Asia/Kolkata]")


public class Product   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("productName")
  private String productName = null;

  @JsonProperty("brand")
  private String brand = null;

  @JsonProperty("productPrice")
  private Double productPrice = null;

  /**
   * Gets or Sets productCategory
   */
  public enum ProductCategoryEnum {
    ELECTRONICS("electronics"),
    
    CLOTHS("cloths"),
    
    FOOTWARES("footwares"),
    
    JWELLERIES("jwelleries"),
    
    GADGETS("gadgets");

    private String value;

    ProductCategoryEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ProductCategoryEnum fromValue(String text) {
      for (ProductCategoryEnum b : ProductCategoryEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("productCategory")
  private ProductCategoryEnum productCategory = null;

  /**
   * Gets or Sets productStatus
   */
  public enum ProductStatusEnum {
    ACTIVE("active"),
    
    INACTIVE("inactive");

    private String value;

    ProductStatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static ProductStatusEnum fromValue(String text) {
      for (ProductStatusEnum b : ProductStatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("productStatus")
  private ProductStatusEnum productStatus = null;

  @JsonProperty("variant")
  @Valid
  private List<Variant> variant = null;

  public Product id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(description = "")
  
    public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Product productName(String productName) {
    this.productName = productName;
    return this;
  }

  /**
   * Get productName
   * @return productName
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public Product brand(String brand) {
    this.brand = brand;
    return this;
  }

  /**
   * Get brand
   * @return brand
   **/
  @Schema(description = "")
  
    public String getBrand() {
    return brand;
  }

  public void setBrand(String brand) {
    this.brand = brand;
  }

  public Product productPrice(Double productPrice) {
    this.productPrice = productPrice;
    return this;
  }

  /**
   * Get productPrice
   * minimum: 1
   * @return productPrice
   **/
  @Schema(required = true, description = "")
      @NotNull

  @DecimalMin("1")  public Double getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(Double productPrice) {
    this.productPrice = productPrice;
  }

  public Product productCategory(ProductCategoryEnum productCategory) {
    this.productCategory = productCategory;
    return this;
  }

  /**
   * Get productCategory
   * @return productCategory
   **/
  @Schema(required = true, description = "")
      @NotNull

    public ProductCategoryEnum getProductCategory() {
    return productCategory;
  }

  public void setProductCategory(ProductCategoryEnum productCategory) {
    this.productCategory = productCategory;
  }

  public Product productStatus(ProductStatusEnum productStatus) {
    this.productStatus = productStatus;
    return this;
  }

  /**
   * Get productStatus
   * @return productStatus
   **/
  @Schema(required = true, description = "")
      @NotNull

    public ProductStatusEnum getProductStatus() {
    return productStatus;
  }

  public void setProductStatus(ProductStatusEnum productStatus) {
    this.productStatus = productStatus;
  }

  public Product variant(List<Variant> variant) {
    this.variant = variant;
    return this;
  }

  public Product addVariantItem(Variant variantItem) {
    if (this.variant == null) {
      this.variant = new ArrayList<Variant>();
    }
    this.variant.add(variantItem);
    return this;
  }

  /**
   * Get variant
   * @return variant
   **/
  @Schema(description = "")
      @Valid
    public List<Variant> getVariant() {
    return variant;
  }

  public void setVariant(List<Variant> variant) {
    this.variant = variant;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(this.id, product.id) &&
        Objects.equals(this.productName, product.productName) &&
        Objects.equals(this.brand, product.brand) &&
        Objects.equals(this.productPrice, product.productPrice) &&
        Objects.equals(this.productCategory, product.productCategory) &&
        Objects.equals(this.productStatus, product.productStatus) &&
        Objects.equals(this.variant, product.variant);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, productName, brand, productPrice, productCategory, productStatus, variant);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Product {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    productName: ").append(toIndentedString(productName)).append("\n");
    sb.append("    brand: ").append(toIndentedString(brand)).append("\n");
    sb.append("    productPrice: ").append(toIndentedString(productPrice)).append("\n");
    sb.append("    productCategory: ").append(toIndentedString(productCategory)).append("\n");
    sb.append("    productStatus: ").append(toIndentedString(productStatus)).append("\n");
    sb.append("    variant: ").append(toIndentedString(variant)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
