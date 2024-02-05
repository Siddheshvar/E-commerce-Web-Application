package com.example.Ecommerce.Web.Apk.Modules;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable=false, updatable=false,name = "address_id")
    private long address_id;

    @ManyToOne
    @JoinColumn(name = "Customer_Id")
    private Customer customer;

    @OneToMany(mappedBy = "address")
    private List<Order> orders;

    private String street;
    private String City;
    private  String state;
    private String country;

}
