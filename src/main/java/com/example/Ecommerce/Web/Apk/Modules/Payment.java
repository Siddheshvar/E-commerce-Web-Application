package com.example.Ecommerce.Web.Apk.Modules;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_Id")
    private long paymentId;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "amount")
    private Double amount;

}
