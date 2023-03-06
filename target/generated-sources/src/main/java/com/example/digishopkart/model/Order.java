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
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Order
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-03T19:19:56.654276871+05:30[Asia/Kolkata]")


public class Order   {
  @JsonProperty("orderId")
  private Integer orderId = null;

  @JsonProperty("activatedAt")
  private String activatedAt = null;

  @JsonProperty("updatedAt")
  private String updatedAt = null;

  @JsonProperty("discountPrice")
  private Double discountPrice = null;

  /**
   * Gets or Sets orderStatus
   */
  public enum OrderStatusEnum {
    CONFIRMED("confirmed"),
    
    PLACED("placed"),
    
    DISPATCHED("dispatched"),
    
    OUTFORDELIVERY("outfordelivery"),
    
    DELIVERED("delivered"),
    
    CANCELLED("cancelled");

    private String value;

    OrderStatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static OrderStatusEnum fromValue(String text) {
      for (OrderStatusEnum b : OrderStatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("orderStatus")
  private OrderStatusEnum orderStatus = null;

  @JsonProperty("customer")
  private Customer customer = null;

  @JsonProperty("products")
  @Valid
  private List<Product> products = null;

  @JsonProperty("discount")
  private Discount discount = null;

  public Order orderId(Integer orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * Get orderId
   * @return orderId
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public Order activatedAt(String activatedAt) {
    this.activatedAt = activatedAt;
    return this;
  }

  /**
   * Get activatedAt
   * @return activatedAt
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getActivatedAt() {
    return activatedAt;
  }

  public void setActivatedAt(String activatedAt) {
    this.activatedAt = activatedAt;
  }

  public Order updatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
    return this;
  }

  /**
   * Get updatedAt
   * @return updatedAt
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Order discountPrice(Double discountPrice) {
    this.discountPrice = discountPrice;
    return this;
  }

  /**
   * Get discountPrice
   * minimum: 1
   * @return discountPrice
   **/
  @Schema(description = "")
  
  @DecimalMin("1")  public Double getDiscountPrice() {
    return discountPrice;
  }

  public void setDiscountPrice(Double discountPrice) {
    this.discountPrice = discountPrice;
  }

  public Order orderStatus(OrderStatusEnum orderStatus) {
    this.orderStatus = orderStatus;
    return this;
  }

  /**
   * Get orderStatus
   * @return orderStatus
   **/
  @Schema(description = "")
  
    public OrderStatusEnum getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(OrderStatusEnum orderStatus) {
    this.orderStatus = orderStatus;
  }

  public Order customer(Customer customer) {
    this.customer = customer;
    return this;
  }

  /**
   * Get customer
   * @return customer
   **/
  @Schema(required = true, description = "")
      @NotNull

    @Valid
    public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  public Order products(List<Product> products) {
    this.products = products;
    return this;
  }

  public Order addProductsItem(Product productsItem) {
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

  public Order discount(Discount discount) {
    this.discount = discount;
    return this;
  }

  /**
   * Get discount
   * @return discount
   **/
  @Schema(required = true, description = "")
      @NotNull

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
    Order order = (Order) o;
    return Objects.equals(this.orderId, order.orderId) &&
        Objects.equals(this.activatedAt, order.activatedAt) &&
        Objects.equals(this.updatedAt, order.updatedAt) &&
        Objects.equals(this.discountPrice, order.discountPrice) &&
        Objects.equals(this.orderStatus, order.orderStatus) &&
        Objects.equals(this.customer, order.customer) &&
        Objects.equals(this.products, order.products) &&
        Objects.equals(this.discount, order.discount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, activatedAt, updatedAt, discountPrice, orderStatus, customer, products, discount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    activatedAt: ").append(toIndentedString(activatedAt)).append("\n");
    sb.append("    updatedAt: ").append(toIndentedString(updatedAt)).append("\n");
    sb.append("    discountPrice: ").append(toIndentedString(discountPrice)).append("\n");
    sb.append("    orderStatus: ").append(toIndentedString(orderStatus)).append("\n");
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
