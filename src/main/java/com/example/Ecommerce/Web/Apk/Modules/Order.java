package com.example.Ecommerce.Web.Apk.Modules;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToMany
    @Column(name = "UserId",nullable = false)
    private SignUp signUp;

    @OneToMany(mappedBy = "Orders",cascade = CascadeType.ALL)
    private List<OrderItems> orderItems;

    @Column(name = "orderDateTime",nullable = false)
    private LocalDateTime orderDate;
    @Column(name = "TotalAmount")
    private double totalAmount;
}
