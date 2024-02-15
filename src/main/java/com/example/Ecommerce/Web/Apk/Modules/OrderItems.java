package com.example.Ecommerce.Web.Apk.Modules;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "OrderItems")
public class OrderItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products itemDetails;

    private Integer itemQty;

    @Column(name = "subTotal")
    private Double itemsSubTotal;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

}
