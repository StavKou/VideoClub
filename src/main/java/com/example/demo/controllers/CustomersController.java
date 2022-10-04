package com.example.demo.controllers;

import com.example.demo.entities.Customers;
import com.example.demo.services.CustomersImpl;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("customers")
public class CustomersController {

    @Autowired
    CustomersImpl cs;

    @GetMapping("/list")
    public String allCustomers(ModelMap mm) {
        mm.addAttribute("listofcustomers", cs.allCustomers());

        return "testcustomer";
    }

    @GetMapping("/insert/form")
    public String customerInsertForm(ModelMap mm) {

        mm.addAttribute("newcustomer", new Customers());

        return "insertcustomerform";
    }

    @PostMapping("/doinsert")
    public String customerDoInsert(@Valid @ModelAttribute("newcustomer") Customers cus, BindingResult result) {
        
     
        //cus.setUsername(cus.getUsername().trim());

//        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id, 32, 64);
//        
//        var hash = argon2.hash(2, 15 * 1024, 1, cus.getPassword().toCharArray());
//        var validPassword = argon2.verify(hash, cus.getPassword().toCharArray());
//        System.out.println(validPassword);
//        
//        System.out.println("Valid password: " + validPassword );
//        System.out.println("hash: " + hash );
      
        if (result.hasErrors()) {
            return "insertcustomerform";
        } else {
            cs.insertCustomer(cus);
            return "redirect:/customers/rediricttoallcustomers";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Integer id) {

        Customers c = cs.GetCustomerById(id);
        cs.deleteCustomer(c);
        return "redirect:/customers/rediricttoallcustomers";
    }

    @GetMapping("/update/{customerId}")
    public String customerUpdateForm(@PathVariable Integer customerId, ModelMap mm) {

        Customers cus = cs.GetCustomerById(customerId);

        mm.addAttribute("customerupdate", cus);

        return "customersupdateform";
    }

    @PostMapping("/doupdate")
    public String customersUpdateForm(@ModelAttribute("newcustomer") Customers cus) {
        System.out.println(cus);
        cs.insertCustomer(cus);

        return "redirect:/customers/rediricttoallcustomers";
    }

    @GetMapping("/rediricttoallcustomers")
    public String showAllCustomers(ModelMap mm) {

        mm.addAttribute("listofcustomers", cs.allCustomers());

        return "testcustomer";
    }
    
    
    

}
