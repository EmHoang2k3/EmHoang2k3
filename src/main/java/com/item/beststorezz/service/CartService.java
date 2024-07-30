package com.item.beststorezz.service;

import com.item.beststorezz.models.CartItem;
import com.item.beststorezz.models.Products;
import com.item.beststorezz.models.Users;
import com.item.beststorezz.repository.CartRepository;
import com.item.beststorezz.repository.ProductRepository;
import com.item.beststorezz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public CartItem addToCart(Long userId, Long productId, Integer quantity) {
        Users user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Products product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));

        CartItem cartItem = new CartItem();
        cartItem.setUser(user);
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);

        return cartRepository.save(cartItem);
    }

    public List<CartItem> getCartIteams(Long userId){
        return cartRepository.findByUserId(userId);
    }
}
