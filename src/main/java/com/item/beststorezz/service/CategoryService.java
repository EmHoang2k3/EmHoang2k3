package com.item.beststorezz.service;

import com.item.beststorezz.models.Categories;
import com.item.beststorezz.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {


    @Autowired
    private CategoryRepository categoryRepository;


    public List<Categories> findAll(){
        return categoryRepository.findAll();
    }

    public Optional<Categories> findById(Long id){
        return categoryRepository.findById(id);
    }

    public Categories save(Categories category){
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }


}
