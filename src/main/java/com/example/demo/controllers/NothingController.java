package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NothingController {
    
    @GetMapping("/showlistmovies")
    public String listMovies() {
        
        return "listmoviesform";
    }
    
    @GetMapping("/lastadditions")
    public String lastadditions() {
    
        return "lastadditions";
    }
    
    
    @GetMapping("/series")
    public String series() {
    
        return "series";
    }
    
    
    @GetMapping("/animations")
    public String animations() {
    
        return "animations";
    }
    
    @GetMapping("/category")
    public String category() {
    
        return "categories";
    }
    

    
    
    @GetMapping("/admin")
    public String admin() {
    
        return "admin";
    }
    
    @GetMapping("/trends")
    public String testcustomer() {
    
        return "trends";
    }
    

}
