package com.example.digishopkart.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Product
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-01T15:43:50.047817045+05:30[Asia/Kolkata]")


public class Product   {
  @JsonProperty("productId")
  private String productId = null;

  @JsonProperty("productName")
  private String productName = null;

  @JsonProperty("createdAt")
  private LocalDate createdAt = null;

  @JsonProperty("productCode")
  private String productCode = null;

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

  public Product productId(String productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get productId
   * @return productId
   **/
  @Schema(description = "")
  
    public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
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

  public Product createdAt(LocalDate createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * Get createdAt
   * @return createdAt
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public LocalDate getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDate createdAt) {
    this.createdAt = createdAt;
  }

  public Product productCode(String productCode) {
    this.productCode = productCode;
    return this;
  }

  /**
   * Get productCode
   * @return productCode
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(this.productId, product.productId) &&
        Objects.equals(this.productName, product.productName) &&
        Objects.equals(this.createdAt, product.createdAt) &&
        Objects.equals(this.productCode, product.productCode) &&
        Objects.equals(this.productPrice, product.productPrice) &&
        Objects.equals(this.productCategory, product.productCategory) &&
        Objects.equals(this.productStatus, product.productStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, productName, createdAt, productCode, productPrice, productCategory, productStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Product {\n");
    
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    productName: ").append(toIndentedString(productName)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    productCode: ").append(toIndentedString(productCode)).append("\n");
    sb.append("    productPrice: ").append(toIndentedString(productPrice)).append("\n");
    sb.append("    productCategory: ").append(toIndentedString(productCategory)).append("\n");
    sb.append("    productStatus: ").append(toIndentedString(productStatus)).append("\n");
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
