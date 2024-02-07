package com.example.Ecommerce.Web.Apk.Modules;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_Item_Id")
    private long cartItemId;
    private int itemQty;

    @ManyToOne
    @JoinColumn(name = "product_Id")
    private Products productsDetails;

    @ManyToOne
    @JoinColumn(name = "cart_Id")
    private Cart cart;
}
