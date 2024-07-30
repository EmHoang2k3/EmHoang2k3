package com.item.beststorezz.controller;


import com.item.beststorezz.dto.CartItemRequest;
import com.item.beststorezz.models.CartItem;
import com.item.beststorezz.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartitemController {
    @Autowired
    private CartService cartService;


    @PostMapping("/add")
    public CartItem addToCart(@RequestBody CartItemRequest request) {
        return cartService.addToCart(request.getUserId(), request.getProductId(), request.getQuantity());
    }
    @GetMapping("/items/{userId}")
    public List<CartItem> getCartItems(@PathVariable Long userId) {
        return cartService.getCartIteams(userId);
    }
}
