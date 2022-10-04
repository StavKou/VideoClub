
package com.example.demo.services;

import com.example.demo.entities.Category;
import java.util.List;

/**
 *
 * @author stkou
 */
public interface ICategory {
    
    public List<Category> allMovies();
    
    public Category GetCategoryById(Integer id);
    
    
}
