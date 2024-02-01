package com.example.Ecommerce.Web.Apk.Modules;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
;import java.util.List;

@Entity
@Data
@Table(name = "Customers")
//@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Customer_Id")
    private long customerId;

    @Column(name = "Full_Name", length = 50)
    private @NotNull String fullName;

    @Column(name = "Phone_No", length = 14)
    private @NotNull long phoneNo;

    @Column(name = "Email_Id", length = 40)
    private @NotNull String emailId;

    @Column(name = "Password", length = 20)
    private @NotNull String createPassword;

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
