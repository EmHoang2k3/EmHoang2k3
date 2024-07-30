package com.item.beststorezz.repository;

import com.item.beststorezz.models.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<CartItem,Long> {
    List<CartItem>findByUserId(Long UserId);
}
