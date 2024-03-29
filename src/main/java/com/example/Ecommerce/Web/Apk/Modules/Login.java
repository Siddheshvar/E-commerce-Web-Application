package com.example.Ecommerce.Web.Apk.Modules;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Data
@Table(name = "Logins")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "login_Id")
    private long loginId;

    @Column(name = "EmailId",nullable = false)
    @Pattern(regexp = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,3}$\", message = \"Please enter a valid email address.")
    private String emailId;

    @Column(name = "Password",length = 20,nullable = false)
    private String password;

    @OneToOne
    @JoinColumn(name = "customer_Id")
    private Customer customer;

}
