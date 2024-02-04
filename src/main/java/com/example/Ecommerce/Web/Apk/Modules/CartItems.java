package com.example.Ecommerce.Web.Apk.Modules;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long crItemId;
    private int itemQty;
    @ManyToOne
    @JoinColumn(name = "product_Id")
    private Products productsDetails;

    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

}
