package com.example.digishopkart.model;

import java.util.Objects;
import com.example.digishopkart.model.Customer;
import com.example.digishopkart.model.Discount;
import com.example.digishopkart.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Subscription
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-23T09:52:28.062828831+05:30[Asia/Kolkata]")


public class Subscription   {
  @JsonProperty("subscriptionId")
  private Integer subscriptionId = null;

  @JsonProperty("activatedAt")
  private OffsetDateTime activatedAt = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    ACTIVE("active"),
    
    INACTIVE("inactive");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("customer")
  private Customer customer = null;

  @JsonProperty("products")
  @Valid
  private List<Product> products = null;

  @JsonProperty("discount")
  private Discount discount = null;

  public Subscription subscriptionId(Integer subscriptionId) {
    this.subscriptionId = subscriptionId;
    return this;
  }

  /**
   * Get subscriptionId
   * @return subscriptionId
   **/
  @Schema(description = "")
  
    public Integer getSubscriptionId() {
    return subscriptionId;
  }

  public void setSubscriptionId(Integer subscriptionId) {
    this.subscriptionId = subscriptionId;
  }

  public Subscription activatedAt(OffsetDateTime activatedAt) {
    this.activatedAt = activatedAt;
    return this;
  }

  /**
   * Get activatedAt
   * @return activatedAt
   **/
  @Schema(example = "1955-04-23T13:22:52.685Z", description = "")
  
    @Valid
    public OffsetDateTime getActivatedAt() {
    return activatedAt;
  }

  public void setActivatedAt(OffsetDateTime activatedAt) {
    this.activatedAt = activatedAt;
  }

  public Subscription status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   **/
  @Schema(description = "")
  
    public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Subscription customer(Customer customer) {
    this.customer = customer;
    return this;
  }

  /**
   * Get customer
   * @return customer
   **/
  @Schema(description = "")
  
    @Valid
    public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Subscription products(List<Product> products) {
    this.products = products;
    return this;
  }

  public Subscription addProductsItem(Product productsItem) {
    if (this.products == null) {
      this.products = new ArrayList<Product>();
    }
    this.products.add(productsItem);
    return this;
  }

  /**
   * Get products
   * @return products
   **/
  @Schema(description = "")
      @Valid
    public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  public Subscription discount(Discount discount) {
    this.discount = discount;
    return this;
  }

  /**
   * Get discount
   * @return discount
   **/
  @Schema(description = "")
  
    @Valid
    public Discount getDiscount() {
    return discount;
  }

  public void setDiscount(Discount discount) {
    this.discount = discount;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Subscription subscription = (Subscription) o;
    return Objects.equals(this.subscriptionId, subscription.subscriptionId) &&
        Objects.equals(this.activatedAt, subscription.activatedAt) &&
        Objects.equals(this.status, subscription.status) &&
        Objects.equals(this.customer, subscription.customer) &&
        Objects.equals(this.products, subscription.products) &&
        Objects.equals(this.discount, subscription.discount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subscriptionId, activatedAt, status, customer, products, discount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Subscription {\n");
    
    sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
    sb.append("    activatedAt: ").append(toIndentedString(activatedAt)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    products: ").append(toIndentedString(products)).append("\n");
    sb.append("    discount: ").append(toIndentedString(discount)).append("\n");
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
