package com.example.Ecommerce.Web.Apk.Modules;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
@Table(name = "Logins")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Email_Id")
    private long userId;

    @Column(name = "User_Id")
    private String emailId;

    @Column(name = "Password")
    private String password;

}
