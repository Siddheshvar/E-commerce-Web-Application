package com.example.Ecommerce.Web.Apk.Modules;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long itemId;
    @ManyToOne
    @JoinColumn(name = "product_Id")
    private Products productDetails;

    @Column(name = "Item_Qty")
    private int itemQty;
    @Column(name = "SubTotal")
    private double subTotal;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;
}
