package com.example.digishopkart.model;

import java.util.Objects;
import com.example.digishopkart.model.CustomerAddress;
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
 * Customer
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-23T09:52:28.062828831+05:30[Asia/Kolkata]")


public class Customer   {
  @JsonProperty("customerId")
  private Integer customerId = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("mobile")
  private String mobile = null;

  /**
   * Gets or Sets customerStatus
   */
  public enum CustomerStatusEnum {
    ACTIVE("active"),
    
    INACTIVE("inactive");

    private String value;

    CustomerStatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CustomerStatusEnum fromValue(String text) {
      for (CustomerStatusEnum b : CustomerStatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }
  @JsonProperty("customerStatus")
  private CustomerStatusEnum customerStatus = CustomerStatusEnum.ACTIVE;

  @JsonProperty("customerAddress")
  @Valid
  private List<CustomerAddress> customerAddress = new ArrayList<CustomerAddress>();

  public Customer customerId(Integer customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Get customerId
   * @return customerId
   **/
  @Schema(description = "")
  
    public Integer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Integer customerId) {
    this.customerId = customerId;
  }

  public Customer firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
   **/
  @Schema(example = "Ajay", required = true, description = "")
      @NotNull

  @Pattern(regexp="^[a-zA-Z]+(\\s[a-zA-Z]+)?$")   public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Customer lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
   **/
  @Schema(example = "Kate", required = true, description = "")
      @NotNull

  @Pattern(regexp="^[a-zA-Z]+(\\s[a-zA-Z]+)?$")   public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Customer email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   **/
  @Schema(example = "ajaykate@gmail.com", required = true, description = "")
      @NotNull

    public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Customer mobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  /**
   * Get mobile
   * @return mobile
   **/
  @Schema(example = "919876543210", required = true, description = "")
      @NotNull

    public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public Customer customerStatus(CustomerStatusEnum customerStatus) {
    this.customerStatus = customerStatus;
    return this;
  }

  /**
   * Get customerStatus
   * @return customerStatus
   **/
  @Schema(required = true, description = "")
      @NotNull

    public CustomerStatusEnum getCustomerStatus() {
    return customerStatus;
  }

  public void setCustomerStatus(CustomerStatusEnum customerStatus) {
    this.customerStatus = customerStatus;
  }

  public Customer customerAddress(List<CustomerAddress> customerAddress) {
    this.customerAddress = customerAddress;
    return this;
  }

  public Customer addCustomerAddressItem(CustomerAddress customerAddressItem) {
    this.customerAddress.add(customerAddressItem);
    return this;
  }

  /**
   * Get customerAddress
   * @return customerAddress
   **/
  @Schema(required = true, description = "")
      @NotNull
    @Valid
    public List<CustomerAddress> getCustomerAddress() {
    return customerAddress;
  }

  public void setCustomerAddress(List<CustomerAddress> customerAddress) {
    this.customerAddress = customerAddress;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Customer customer = (Customer) o;
    return Objects.equals(this.customerId, customer.customerId) &&
        Objects.equals(this.firstName, customer.firstName) &&
        Objects.equals(this.lastName, customer.lastName) &&
        Objects.equals(this.email, customer.email) &&
        Objects.equals(this.mobile, customer.mobile) &&
        Objects.equals(this.customerStatus, customer.customerStatus) &&
        Objects.equals(this.customerAddress, customer.customerAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, firstName, lastName, email, mobile, customerStatus, customerAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Customer {\n");
    
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
    sb.append("    customerStatus: ").append(toIndentedString(customerStatus)).append("\n");
    sb.append("    customerAddress: ").append(toIndentedString(customerAddress)).append("\n");
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
