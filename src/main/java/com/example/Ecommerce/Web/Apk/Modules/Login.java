package com.example.Ecommerce.Web.Apk.Modules;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    private @NotNull String emailId;

    @Column(name = "Password",length = 20)
    private @NotNull String password;

}
