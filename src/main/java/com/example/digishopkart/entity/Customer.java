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
public class Customer {
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customerId", nullable = false)
    private UUID id;*/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private com.example.digishopkart.model.Customer.CustomerStatusEnum customerStatus;
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_address_id")
    public CustomerAddress customerAddress;


}
