package com.example.Ecommerce.Web.Apk.Modules;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
@Table(name ="Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Column(name = "OrderDateTime")
    private LocalDateTime orderDateTime;

    @Column(name = "TotalAmount")
    private Double totalAmount;

    private long addressId;

    @ManyToOne
    @JoinColumn(name = "addressId")
    private Address address;

    @OneToOne(mappedBy = "order")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "Customer_Id")
    private Customer customer;

    @OneToMany(mappedBy = "order")
    private List <OrderItems> orderItems;

}
