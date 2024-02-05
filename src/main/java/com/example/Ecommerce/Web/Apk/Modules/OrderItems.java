package com.example.Ecommerce.Web.Apk.Modules;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_Id")
    private long itemId;
    @ManyToOne
    @JoinColumn(name = "product_Id")
    private Products productDetails;

    @Column(name = "Item_Qty")
    private int itemQty;
    @Column(name = "Sub_Total")
    private double subTotal;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
