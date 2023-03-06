package com.example.digishopkart.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Discount
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-03-03T19:19:56.654276871+05:30[Asia/Kolkata]")


public class Discount   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("couponName")
  private String couponName = null;

  /**
   * Gets or Sets discountType
   */
  public enum DiscountTypeEnum {
    FLAT("FLAT"),
    
    PERCENTAGE("PERCENTAGE");

    private String value;

    DiscountTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static DiscountTypeEnum fromValue(String text) {
      for (DiscountTypeEnum b : DiscountTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("discountType")
  private DiscountTypeEnum discountType = null;

  @JsonProperty("couponValue")
  private Double couponValue = null;

  public Discount id(Integer id) {
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

  public Discount couponName(String couponName) {
    this.couponName = couponName;
    return this;
  }

  /**
   * Get couponName
   * @return couponName
   **/
  @Schema(description = "")
  
    public String getCouponName() {
    return couponName;
  }

  public void setCouponName(String couponName) {
    this.couponName = couponName;
  }

  public Discount discountType(DiscountTypeEnum discountType) {
    this.discountType = discountType;
    return this;
  }

  /**
   * Get discountType
   * @return discountType
   **/
  @Schema(required = true, description = "")
      @NotNull

    public DiscountTypeEnum getDiscountType() {
    return discountType;
  }

  public void setDiscountType(DiscountTypeEnum discountType) {
    this.discountType = discountType;
  }

  public Discount couponValue(Double couponValue) {
    this.couponValue = couponValue;
    return this;
  }

  /**
   * Get couponValue
   * @return couponValue
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Double getCouponValue() {
    return couponValue;
  }

  public void setCouponValue(Double couponValue) {
    this.couponValue = couponValue;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Discount discount = (Discount) o;
    return Objects.equals(this.id, discount.id) &&
        Objects.equals(this.couponName, discount.couponName) &&
        Objects.equals(this.discountType, discount.discountType) &&
        Objects.equals(this.couponValue, discount.couponValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, couponName, discountType, couponValue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Discount {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    couponName: ").append(toIndentedString(couponName)).append("\n");
    sb.append("    discountType: ").append(toIndentedString(discountType)).append("\n");
    sb.append("    couponValue: ").append(toIndentedString(couponValue)).append("\n");
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
