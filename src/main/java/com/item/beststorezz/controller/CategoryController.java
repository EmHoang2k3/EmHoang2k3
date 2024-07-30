package com.item.beststorezz.controller;


import com.item.beststorezz.models.Categories;
import com.item.beststorezz.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public List<Categories> getAllCategory(){
        return categoryService.findAll();
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Categories> GetCategoryById(@PathVariable Long id){
        Optional<Categories> categories = categoryService.findById(id);
        return categories.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping("/category/add")
    public Categories addCategory (@RequestBody Categories categories){
        return categoryService.save(categories);
    }


    @PutMapping("/category/{id}")
    public ResponseEntity<Categories> updateCategory(@PathVariable Long id, @RequestBody Categories category){
        Optional<Categories> categories = categoryService.findById(id);
        if(categories.isPresent()){
            Categories updateCategory = categories.get();
            updateCategory.setCategory(category.getCategory());
            return ResponseEntity.ok(categoryService.save(updateCategory));
        }else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/category/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }


}
