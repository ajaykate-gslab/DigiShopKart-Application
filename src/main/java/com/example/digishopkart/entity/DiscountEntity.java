package com.example.digishopkart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DiscountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotEmpty(message = " couponName should not empty")
    private String couponName;
    @NotNull(message = " discountType should be correct")
    private com.example.digishopkart.model.Discount.DiscountTypeEnum discountType;
    private Double couponValue;
}
