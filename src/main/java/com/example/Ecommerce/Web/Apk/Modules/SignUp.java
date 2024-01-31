package com.example.Ecommerce.Web.Apk.Modules;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;;

@Entity
@Data
@Table(name = "SignUps")
//@NoArgsConstructor
public class SignUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Id")
    private long UserId;

    @Column(name = "Full_Name", length = 50)
    private @NotNull String fullName;

    @Column(name = "Phone_No", length = 13)
    private @NotNull long phoneNo;

    @Column(name = "Email_Id", length = 30)
    private @NotNull String emailId;

    @Column(name = "Password", length = 20)
    private @NotNull String createPassword;

    /*public SignUp(String fullName, long phoneNo, String emailId, String createPassword) {
        this.fullName = fullName;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
        this.createPassword = createPassword;
    }*/



}
