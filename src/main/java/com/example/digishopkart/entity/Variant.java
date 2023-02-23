package com.example.digishopkart.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

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
    private int id;
    @NotEmpty(message = "name should not empty")
    private String name;
    @NotEmpty(message = "value should not empty")
    private String value;
    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private com.example.digishopkart.model.Variant.StatusEnum status;

}
