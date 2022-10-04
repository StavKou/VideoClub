
package com.example.demo.services;

import com.example.demo.entities.Customers;
import java.util.List;


public interface ICustomers {
    
    public void insertCustomer(Customers c);
    
    public List<Customers> allCustomers();
    
    public Customers GetCustomerById(Integer id); 
    
   public void updateCustomer(Customers cus);
    
   public void deleteCustomer(Customers cus);
   
   public String passwordencryption(String password);
}
