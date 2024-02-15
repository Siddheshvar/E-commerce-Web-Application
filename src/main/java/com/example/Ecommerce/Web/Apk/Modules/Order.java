package com.example.Ecommerce.Web.Apk.Modules;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderId")
    private Integer orderId;

    @Column(name = "dateTime")
    private LocalDateTime dateTime;

    @Column(name = "totalamount")
    private Float totalAmount;

    @ManyToOne
    @JoinColumn(name = "customer_Id")
    private Customer customers;

    @ManyToOne
    @JoinColumn(name = "addressId")
    private Address address;

    private Payment payment;

    private List<OrderItems> orderItems;

}
