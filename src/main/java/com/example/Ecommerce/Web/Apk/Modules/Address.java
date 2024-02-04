package com.example.Ecommerce.Web.Apk.Modules;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long addressId;
    @ManyToOne
    @JoinColumn(name = "Customer_Id")
    private Customer customer;

    @OneToMany(mappedBy = "Customer_Id")
    private List<Order> orders;
    private String street;
    private String City;
    private  String state;
    private String country;

}
