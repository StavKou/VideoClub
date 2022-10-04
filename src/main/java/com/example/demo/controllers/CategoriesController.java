package com.example.demo.controllers;

import com.example.demo.services.CategoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CategoriesController {

    @Autowired
    CategoryImpl cs;

}
