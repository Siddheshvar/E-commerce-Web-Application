package com.example.Ecommerce.Web.Apk.Modules;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_Id")
    private long pr_Id;

    @Column(name = "product_name")
    private String prName;

    @Column(name = "product_price")
    private int prPrice;

    @Column(name = "product_description")
    private String prDescription;

    @Column(name = "product_URL")
    private String prURL;
}
