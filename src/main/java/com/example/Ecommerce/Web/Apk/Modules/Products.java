package com.example.Ecommerce.Web.Apk.Modules;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long product_Id;

    @Column(name = "product_name", length = 70,nullable = false)
    private String product_name;

    @Column(name = "product_price", length = 7,nullable = false)
    private int product_price;

    @Column(name = "product_description", length = 700,nullable = false)
    private String product_description;

    @Column(name = "product_URL",nullable = false)
    private String product_URL;

    @Column(name = "stock_quantity")
    private long stockQuantity;

//    @ManyToOne
//    @JoinColumn(name = "order_Id")
//    private Order order;
//
    @ManyToMany(mappedBy = "products")
    private Set<Category> categories;

//    @ManyToOne
//    @JoinColumn(name = "orderId")
//    private OrderServices order;
}
