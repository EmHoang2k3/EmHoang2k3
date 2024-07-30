package com.item.beststorezz.controller;


import com.item.beststorezz.models.Products;
import com.item.beststorezz.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Products> GetAllProducts(){
        return productService.findAll();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable Long id){
        Optional<Products> products = productService.findById(id);
        return products.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping("/product")
    public Products addProduct(@RequestBody Products product){
        return productService.save(product);
    }

    @PutMapping("/product{id}")
    public ResponseEntity<Products> updateProdut(@PathVariable Long id,@RequestBody Products products){
        Optional<Products> product = productService.findById(id);
        if(product.isPresent()){
            Products productUpdate = product.get();
            productUpdate.setName(products.getName());
            productUpdate.setBrand(products.getBrand());
            productUpdate.setPrice(products.getPrice());
            productUpdate.setCategory(products.getCategory());
            productUpdate.setDescription(products.getDescription());
            productUpdate.setCreatdAt(products.getCreatdAt());
            productUpdate.setImageFileName(products.getImageFileName());
            return ResponseEntity.ok(productService.save(productUpdate));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/product{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/products")
    public ResponseEntity<List<Products>> searchProduct(@RequestParam(name = "name") String name){
        List<Products> products = productService.searchProduct(name);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/products/category/{categoryId}")
    public ResponseEntity<List<Products>> getProductByCategory(@PathVariable Long categoryId){
        List<Products> products = productService.getProductByCategory(categoryId);
        return ResponseEntity.ok(products);
    }


}
