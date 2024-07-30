package com.item.beststorezz.service;

import com.item.beststorezz.models.Categories;
import com.item.beststorezz.models.Products;
import com.item.beststorezz.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Products> findAll(){
        return productRepository.findAll();
    }

    public Optional<Products> findById(Long id){
        return productRepository.findById(id);
    }

    public Products save(Products products){
        return productRepository.save(products);
    }

    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }

    public List<Products> searchProduct(String name){
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Products> getProductByCategory(Long categoryId){

        Categories categories = new Categories();
        categories.setId(categoryId);
        return productRepository.findByCategory(categories);
    }
}
