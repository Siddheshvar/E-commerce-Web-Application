package com.example.Ecommerce.Web.Apk.Repositories;

import com.example.Ecommerce.Web.Apk.Modules.Category;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}