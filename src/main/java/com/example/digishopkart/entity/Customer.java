package com.example.digishopkart.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Customer {
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "customerId", nullable = false)
    private UUID id;*/

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotEmpty(message = "firstName should not empty or null")
    private String firstName;
    @NotEmpty(message = "lastName should not empty or null")
    private String lastName;

    @Email(message = "should be valid email id")
    private String email;
    @Size(min=2, max=13, message = "mobile number size must be between {min} and {max} characters long")
    @NotNull(message = "mobile is mandatory")
    private String mobile;
    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private com.example.digishopkart.model.Customer.CustomerStatusEnum customerStatus;
    /*@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "customer")
    @JoinColumn(name = "customer_address_id")
    private List<CustomerAddress> customerAddress = new ArrayList<CustomerAddress>();
*/
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private List<CustomerAddress> customerAddress = new ArrayList<CustomerAddress>();

}
