package com.example.digishopkart.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddress {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customerAddressId", nullable = false)
    private String customerAddressId;*/
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customerAddressId", nullable = false)
    private UUID id;

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