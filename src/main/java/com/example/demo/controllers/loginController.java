/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.controllers;

import com.example.demo.entities.Customers;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.services.CustomersImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class loginController {

    @Autowired
    CustomersImpl ci;

    @Autowired
    CustomerRepository cr;

    @GetMapping("/loginuser")
    public String login(ModelMap mm) {

        Customers customer = new Customers();
        mm.addAttribute("user", customer);
        return "/login";
    }

    @PostMapping("/checkuser")
    public String checkuser(@ModelAttribute("user") Customers user) {
        
        List<Customers> userData = (List<Customers>) cr.findAll();

        for (int i = 0; i <= userData.size(); i++) {
          
            if (userData.get(i).getCpassword().equals(user.getCpassword()) && userData.get(i).getUsername().equals(user.getUsername())) {              
                return "start";
            }            
            return "redirect:/loginuser";
        }
        
        return "-1";
        
    }
    
    
    @GetMapping ("/forgotpassword")
    public String forgotpassword () {
    
        return "forgotpassword";
    }
}
