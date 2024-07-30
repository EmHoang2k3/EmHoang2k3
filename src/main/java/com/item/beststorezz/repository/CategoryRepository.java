package com.item.beststorezz.repository;

import com.item.beststorezz.models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Categories,Long> {

}
