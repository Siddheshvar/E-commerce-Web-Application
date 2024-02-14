package com.example.Ecommerce.Web.Apk.Modules;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String flatOrHouseNo;
    private String residencyOrApartment;
    private String areaOrColony;
    private String townOrVillage;
    private String city;
    private String subDistrict;
    private String District;
    private Integer pinCode;
    private String state;
    private String country;
}
