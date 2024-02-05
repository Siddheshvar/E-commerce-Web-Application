package com.example.Ecommerce.Web.Apk.Modules;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
@Table(name ="Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long order_id;

    @Column(name = "OrderDateTime")
    private LocalDateTime orderDateTime;

    @Column(name = "TotalAmount")
    private Double totalAmount;

    @ManyToOne
    @JoinColumn(name = "addressId")
    private Address address;

    @OneToOne(mappedBy = "order")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "customer_Id")
    private Customer customers;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List <OrderItems> orderItems;

}
