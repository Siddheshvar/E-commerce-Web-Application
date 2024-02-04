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

    @Column(name = "ShippingAddressId")
    private long shippingAdsId;

    @ManyToOne
    @JoinColumn(name = "ShippingAddressId")
    private Address shippingAddress;

    @OneToOne(mappedBy = "Order")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "Customer_Id")
    private Customer customerDetails;

    @OneToMany(mappedBy = "order")
    private List <OrderItems> orderItems;

}
