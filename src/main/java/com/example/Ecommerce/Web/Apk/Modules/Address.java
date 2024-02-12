package com.example.Ecommerce.Web.Apk.Modules;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressId")
    private Long id;
    private String flatOrHouseNo;
    private String apartmentOrColony;
    private String areaOrVillage;
    private String city;
    private String district;
    private int pinCode;
    private String state;
    private String country;

    @ManyToOne
    @JoinColumn(name = "customer_Id")
    private Customer customer;
}
