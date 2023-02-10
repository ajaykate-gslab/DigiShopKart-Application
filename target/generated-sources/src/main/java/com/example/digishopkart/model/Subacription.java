package com.example.digishopkart.model;

import java.util.Objects;
import com.example.digishopkart.model.Customer;
import com.example.digishopkart.model.Discount;
import com.example.digishopkart.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Subacription
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-10T18:32:00.939904269+05:30[Asia/Kolkata]")


public class Subacription   {
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

  @JsonProperty("product")
  private Product product = null;

  @JsonProperty("discount")
  private Discount discount = null;

  public Subacription subscriptionId(Integer subscriptionId) {
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

  public Subacription activatedAt(OffsetDateTime activatedAt) {
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

  public Subacription status(StatusEnum status) {
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

  public Subacription customer(Customer customer) {
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

  public Subacription product(Product product) {
    this.product = product;
    return this;
  }

  /**
   * Get product
   * @return product
   **/
  @Schema(description = "")
  
    @Valid
    public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Subacription discount(Discount discount) {
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
    Subacription subacription = (Subacription) o;
    return Objects.equals(this.subscriptionId, subacription.subscriptionId) &&
        Objects.equals(this.activatedAt, subacription.activatedAt) &&
        Objects.equals(this.status, subacription.status) &&
        Objects.equals(this.customer, subacription.customer) &&
        Objects.equals(this.product, subacription.product) &&
        Objects.equals(this.discount, subacription.discount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(subscriptionId, activatedAt, status, customer, product, discount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Subacription {\n");
    
    sb.append("    subscriptionId: ").append(toIndentedString(subscriptionId)).append("\n");
    sb.append("    activatedAt: ").append(toIndentedString(activatedAt)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
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
