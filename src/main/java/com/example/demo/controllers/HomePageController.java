package com.example.demo.controllers;

import com.example.demo.services.MovieImpl;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {
       
    @Autowired
    MovieImpl mi;
    
    
    @GetMapping("/")
    public String homePage(ModelMap mm) {
        
        mm.addAttribute("newmoviesadded",mi.lastmoviesadded());
        
        return "start";
    }
    
    
}
