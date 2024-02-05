package com.example.Ecommerce.Web.Apk.Modules;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartItemId;
    private int itemQty;

    @ManyToOne
    @JoinColumn(name = "product_Id")
    private Products productsDetails;

    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;
}
