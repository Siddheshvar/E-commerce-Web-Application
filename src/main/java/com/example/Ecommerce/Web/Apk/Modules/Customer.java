package com.example.Ecommerce.Web.Apk.Modules;

import jakarta.persistence.*;
import lombok.Data;
;import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Data
@Table(name = "Customers")
//@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Customer_Id")
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

    @OneToMany(targetEntity = Products.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "ForeignKey",referencedColumnName = "Customer_Id")
    private List<Products> products;

    /*public Customer(String fullName, long phoneNo, String emailId, String createPassword) {
        this.fullName = fullName;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
        this.createPassword = createPassword;
    }*/



}
