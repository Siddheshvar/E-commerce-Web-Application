package com.example.Ecommerce.Web.Apk.Modules;

import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId")
    private Integer categoryId;

    @Column(name = "CategoryName")
    private String CategoryName;

    @Column(name = "description")
    private String description;

    @Column(name = "URL")
    private String categoryURL;


    @ManyToMany
    @JoinTable(
            name = "category_product",
            joinColumns=@JoinColumn(name = "categoryId"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    public Set<Products> products;

}
