package com.example.Ecommerce.Web.Apk.Repositories;

import com.example.Ecommerce.Web.Apk.Modules.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItems,Long> {
}