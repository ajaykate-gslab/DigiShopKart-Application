package com.example.digishopkart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CustomerAddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull(message = "addressType is mandatory")
    private com.example.digishopkart.model.CustomerAddress.AddressTypeEnum addressType;
    @NotNull(message = "customerFullName is mandatory")
    private String customerFullName;
    @NotNull(message = "Country is mandatory")
    private String country;
    @NotNull(message = "state is mandatory")
    private String state;
    @NotNull(message = "town is mandatory")
    private String town;
    @NotNull(message = "area is mandatory")
    private String area;
    @NotNull(message = "houseOrBuilding is mandatory")
    private String houseOrBuilding;
    @NotNull(message = "landmark is mandatory")
    private String landmark;
    @NotNull(message = "pinCode is mandatory")
    private Integer pinCode;
    @Size(min=2, max=13, message = "mobile number size must be between {min} and {max} characters long")
    @NotNull(message = "mobile is mandatory")
    private String mobile;

}