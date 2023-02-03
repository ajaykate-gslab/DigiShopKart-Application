package com.example.digishopkart.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Variant1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int variantId;
    private String colour;
    private String size;

    @OneToOne
    private Product1 product1;
}
