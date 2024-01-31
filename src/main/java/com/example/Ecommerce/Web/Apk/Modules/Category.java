package com.example.Ecommerce.Web.Apk.Modules;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category_name", length = 50)
    private @NotNull String categoryName;

    @Column(name = "category_description", length = 500)
    private @NotNull String description;

    @Column(name = "category_url")
    private @NotNull String categoryURL;
}
