package com.example.digishopkart.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Variant
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-03T12:31:27.362542775+05:30[Asia/Kolkata]")


public class Variant   {
  @JsonProperty("variant_id")
  private Integer variantId = null;

  @JsonProperty("colour")
  private String colour = null;

  @JsonProperty("size")
  private String size = null;

  public Variant variantId(Integer variantId) {
    this.variantId = variantId;
    return this;
  }

  /**
   * Get variantId
   * @return variantId
   **/
  @Schema(description = "")
  
    public Integer getVariantId() {
    return variantId;
  }

  public void setVariantId(Integer variantId) {
    this.variantId = variantId;
  }

  public Variant colour(String colour) {
    this.colour = colour;
    return this;
  }

  /**
   * Get colour
   * @return colour
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getColour() {
    return colour;
  }

  public void setColour(String colour) {
    this.colour = colour;
  }

  public Variant size(String size) {
    this.size = size;
    return this;
  }

  /**
   * Get size
   * @return size
   **/
  @Schema(required = true, description = "")
      @NotNull

    public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Variant variant = (Variant) o;
    return Objects.equals(this.variantId, variant.variantId) &&
        Objects.equals(this.colour, variant.colour) &&
        Objects.equals(this.size, variant.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(variantId, colour, size);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Variant {\n");
    
    sb.append("    variantId: ").append(toIndentedString(variantId)).append("\n");
    sb.append("    colour: ").append(toIndentedString(colour)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
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
