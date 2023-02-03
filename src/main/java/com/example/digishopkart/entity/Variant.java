package com.example.digishopkart.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Variant {

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "variant_id", nullable = false)
    private Integer variantId;*/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int variantId;
    private String colour;
    private String size;
    @OneToOne
    private Product product;



}
