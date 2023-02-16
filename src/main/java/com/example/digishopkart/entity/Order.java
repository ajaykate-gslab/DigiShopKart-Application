package com.example.digishopkart.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.OffsetDateTime;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    private String activatedAt;
    @JsonIgnore
    private String productName;

    private Double discountPrice;
    @JsonIgnore
    private String couponName;
    @JsonIgnore
    private Double couponValue;
    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private com.example.digishopkart.model.Order.OrderStatusEnum orderStatus;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_customer_id")
    private Customer customer;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "product_product_id")
    private Product product;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "discount_discount_id")
    private Discount discount;


}
