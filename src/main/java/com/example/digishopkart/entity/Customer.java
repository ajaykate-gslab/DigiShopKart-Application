package com.example.digishopkart.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customerId", nullable = false)
    private UUID id;

    /* @Id
        @GeneratedValue(strategy = GenerationType.TABLE)
        @Column(name = "customerId", nullable = false)
        private String customerId;*/
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private com.example.digishopkart.model.Customer.CustomerStatusEnum customerStatus;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_address_id")
    private CustomerAddress customerAddress;


}
