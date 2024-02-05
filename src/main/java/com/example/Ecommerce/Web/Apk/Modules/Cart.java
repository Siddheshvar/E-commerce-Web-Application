package com.example.Ecommerce.Web.Apk.Modules;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_Id")
    private long cartId;

    @ManyToOne
    @JoinColumn(name = "customer_Id")
    private Customer customer;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;
}
