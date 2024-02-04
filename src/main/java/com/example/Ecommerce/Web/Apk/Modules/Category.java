package com.example.Ecommerce.Web.Apk.Modules;
import jakarta.persistence.*;
import lombok.Data;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Data
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_name", length = 50,nullable = false)
    private String categoryName;

    @Column(name = "category_description", length = 500,nullable = false)
    private String description;

    @OneToMany(mappedBy = "Category")
    private List<Products> products;

    @Column(name = "category_url",nullable = false)
    private String categoryURL;
}
