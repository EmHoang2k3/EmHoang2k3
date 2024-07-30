package com.item.beststorezz.repository;

import com.item.beststorezz.models.Categories;
import com.item.beststorezz.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products,Long> {
  List<Products> findByNameContainingIgnoreCase(String name);

  List<Products> findByCategory(Categories categories);
}
