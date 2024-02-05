package com.example.Ecommerce.Web.Apk.Modules;
import jakarta.persistence.*;
import lombok.Data;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "category_name", length = 50,nullable = false)
    private String categoryName;

    @Column(name = "category_description", length = 500,nullable = false)
    private String description;

    @ManyToMany
    @JoinTable(
            name = "category_product",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "product_Id")
    )
    private Set<Products> products;

    @Column(name = "category_url",nullable = false)
    private String categoryURL;

}
