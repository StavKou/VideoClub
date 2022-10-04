
package com.example.demo.services;

import com.example.demo.entities.Category;
import com.example.demo.entities.Movies;
import com.example.demo.repositories.CategoryRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryImpl implements ICategory{
    
    @Autowired
    CategoryRepository cr;

    @Override
    public List<Category> allMovies() {

        return cr.findAll();
    }

    @Override
    public Category GetCategoryById(Integer id) {

        return cr.findById(id).get();
    }

    
    
    
}
