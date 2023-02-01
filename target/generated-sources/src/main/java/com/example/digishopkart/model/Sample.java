package com.example.digishopkart.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Sample
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-02-01T15:43:50.047817045+05:30[Asia/Kolkata]")


public class Sample   {
  @JsonProperty("sampleId")
  private String sampleId = null;

  @JsonProperty("SampleName")
  private String sampleName = null;

  @JsonProperty("country")
  private String country = null;

  public Sample sampleId(String sampleId) {
    this.sampleId = sampleId;
    return this;
  }

  /**
   * Get sampleId
   * @return sampleId
   **/
  @Schema(description = "")
  
    public String getSampleId() {
    return sampleId;
  }

  public void setSampleId(String sampleId) {
    this.sampleId = sampleId;
  }

  public Sample sampleName(String sampleName) {
    this.sampleName = sampleName;
    return this;
  }

  /**
   * Get sampleName
   * @return sampleName
   **/
  @Schema(description = "")
  
    public String getSampleName() {
    return sampleName;
  }

  public void setSampleName(String sampleName) {
    this.sampleName = sampleName;
  }

  public Sample country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Get country
   * @return country
   **/
  @Schema(description = "")
  
    public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Sample sample = (Sample) o;
    return Objects.equals(this.sampleId, sample.sampleId) &&
        Objects.equals(this.sampleName, sample.sampleName) &&
        Objects.equals(this.country, sample.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sampleId, sampleName, country);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Sample {\n");
    
    sb.append("    sampleId: ").append(toIndentedString(sampleId)).append("\n");
    sb.append("    sampleName: ").append(toIndentedString(sampleName)).append("\n");
    sb.append("    country: ").append(toIndentedString(country)).append("\n");
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
