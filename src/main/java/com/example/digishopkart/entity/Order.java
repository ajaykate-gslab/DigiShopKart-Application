package com.example.digishopkart.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    private String updatedAt;
    private Double totalPrice;
    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private com.example.digishopkart.model.Order.OrderStatusEnum orderStatus;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_customer_id",referencedColumnName = "id")
    private Customer customer;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_product_id")
    private List<Product> products = new ArrayList<Product>();
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "discount_discount_id")
    private Discount discount;


}
