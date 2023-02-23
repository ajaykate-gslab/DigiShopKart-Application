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
 * CustomerAddress
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-23T09:52:28.062828831+05:30[Asia/Kolkata]")


public class CustomerAddress   {
  @JsonProperty("id")
  private Integer id = null;

  /**
   * Gets or Sets addressType
   */
  public enum AddressTypeEnum {
    SHIPPING("shipping"),
    
    BILLING("billing");

    private String value;

    AddressTypeEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AddressTypeEnum fromValue(String text) {
      for (AddressTypeEnum b : AddressTypeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("addressType")
  private AddressTypeEnum addressType = null;

  @JsonProperty("customerFullName")
  private String customerFullName = null;

  @JsonProperty("country")
  private String country = null;

  @JsonProperty("state")
  private String state = null;

  @JsonProperty("town")
  private String town = null;

  @JsonProperty("area")
  private String area = null;

  @JsonProperty("houseOrBuilding")
  private String houseOrBuilding = null;

  @JsonProperty("landmark")
  private String landmark = null;

  @JsonProperty("pinCode")
  private Integer pinCode = null;

  @JsonProperty("mobile")
  private String mobile = null;

  public CustomerAddress id(Integer id) {
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

  public CustomerAddress addressType(AddressTypeEnum addressType) {
    this.addressType = addressType;
    return this;
  }

  /**
   * Get addressType
   * @return addressType
   **/
  @Schema(description = "")
  
    public AddressTypeEnum getAddressType() {
    return addressType;
  }

  public void setAddressType(AddressTypeEnum addressType) {
    this.addressType = addressType;
  }

  public CustomerAddress customerFullName(String customerFullName) {
    this.customerFullName = customerFullName;
    return this;
  }

  /**
   * Get customerFullName
   * @return customerFullName
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getCustomerFullName() {
    return customerFullName;
  }

  public void setCustomerFullName(String customerFullName) {
    this.customerFullName = customerFullName;
  }

  public CustomerAddress country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Get country
   * @return country
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public CustomerAddress state(String state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public CustomerAddress town(String town) {
    this.town = town;
    return this;
  }

  /**
   * Get town
   * @return town
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getTown() {
    return town;
  }

  public void setTown(String town) {
    this.town = town;
  }

  public CustomerAddress area(String area) {
    this.area = area;
    return this;
  }

  /**
   * Get area
   * @return area
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public CustomerAddress houseOrBuilding(String houseOrBuilding) {
    this.houseOrBuilding = houseOrBuilding;
    return this;
  }

  /**
   * Get houseOrBuilding
   * @return houseOrBuilding
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getHouseOrBuilding() {
    return houseOrBuilding;
  }

  public void setHouseOrBuilding(String houseOrBuilding) {
    this.houseOrBuilding = houseOrBuilding;
  }

  public CustomerAddress landmark(String landmark) {
    this.landmark = landmark;
    return this;
  }

  /**
   * Get landmark
   * @return landmark
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getLandmark() {
    return landmark;
  }

  public void setLandmark(String landmark) {
    this.landmark = landmark;
  }

  public CustomerAddress pinCode(Integer pinCode) {
    this.pinCode = pinCode;
    return this;
  }

  /**
   * Get pinCode
   * @return pinCode
   **/
  @Schema(required = true, description = "")
      @NotNull

    public Integer getPinCode() {
    return pinCode;
  }

  public void setPinCode(Integer pinCode) {
    this.pinCode = pinCode;
  }

  public CustomerAddress mobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  /**
   * Get mobile
   * @return mobile
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerAddress customerAddress = (CustomerAddress) o;
    return Objects.equals(this.id, customerAddress.id) &&
        Objects.equals(this.addressType, customerAddress.addressType) &&
        Objects.equals(this.customerFullName, customerAddress.customerFullName) &&
        Objects.equals(this.country, customerAddress.country) &&
        Objects.equals(this.state, customerAddress.state) &&
        Objects.equals(this.town, customerAddress.town) &&
        Objects.equals(this.area, customerAddress.area) &&
        Objects.equals(this.houseOrBuilding, customerAddress.houseOrBuilding) &&
        Objects.equals(this.landmark, customerAddress.landmark) &&
        Objects.equals(this.pinCode, customerAddress.pinCode) &&
        Objects.equals(this.mobile, customerAddress.mobile);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, addressType, customerFullName, country, state, town, area, houseOrBuilding, landmark, pinCode, mobile);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerAddress {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    addressType: ").append(toIndentedString(addressType)).append("\n");
    sb.append("    customerFullName: ").append(toIndentedString(customerFullName)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
    sb.append("    state: ").append(toIndentedString(state)).append("\n");
    sb.append("    town: ").append(toIndentedString(town)).append("\n");
    sb.append("    area: ").append(toIndentedString(area)).append("\n");
    sb.append("    houseOrBuilding: ").append(toIndentedString(houseOrBuilding)).append("\n");
    sb.append("    landmark: ").append(toIndentedString(landmark)).append("\n");
    sb.append("    pinCode: ").append(toIndentedString(pinCode)).append("\n");
    sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
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
