package com.example.digishopkart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerAddressId;
    private String customerFullName;
    private String country;
    private String state;
    private String town;
    private String area;
    private String houseOrBuilding;
    private String landmark;
    private BigDecimal pinCode;
    private String mobile;

}