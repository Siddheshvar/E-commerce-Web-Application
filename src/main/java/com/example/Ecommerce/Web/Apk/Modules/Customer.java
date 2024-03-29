package com.example.Ecommerce.Web.Apk.Modules;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Data
@Table(name = "Customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_Id")
    private long customerId;

    @Column(name = "Full_Name", length = 30,nullable = false)
    @Pattern(regexp = "^[A-Z][a-z]+( [A-Z][a-z]+)*([A-Z][a-z]+)?$")
    private String fullName;

    @Column(name = "Phone_No", length = 14,nullable = false)
    private long phoneNo;

    @Column(name = "Email_Id", length = 40,nullable = false)
    @Pattern(regexp = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,3}$\", message = \"Please enter a valid email address.")
    private String emailId;

    @Column(name = "Password", length = 20,nullable = false)
    private String createPassword;


    @Column(name = "Address")
    private  Address address;

    @OneToMany(mappedBy = "customers",cascade = CascadeType.ALL)
    private List<Order> products;

}
