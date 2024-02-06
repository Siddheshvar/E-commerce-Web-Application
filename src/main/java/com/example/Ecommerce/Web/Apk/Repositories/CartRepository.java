package com.example.Ecommerce.Web.Apk.Repositories;

import com.example.Ecommerce.Web.Apk.Modules.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
}
