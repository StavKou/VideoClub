
package com.example.demo.services;

import com.example.demo.entities.Customers;
import com.example.demo.repositories.CustomerRepository;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomersImpl implements ICustomers{

    @Autowired
    CustomerRepository cr;
    
    @Override
    public void insertCustomer(Customers c) {

        cr.save(c);
    }

    @Override
    public List<Customers> allCustomers() {

        return cr.findAll();
    }

    @Override
    public Customers GetCustomerById(Integer id) {

        return cr.findById(id).get();
    }

    @Override
    public void updateCustomer(Customers cus) {

        cr.save(cus);
    }

    
    @Override
    public void deleteCustomer(Customers cus) {
        
        cr.delete(cus);
   }
    
    

    @Override
    public String passwordencryption(String password) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id, 32, 64);
        
        var hash = argon2.hash(2, 15 * 1024, 1, password.toCharArray());
        var validPassword = argon2.verify(hash, password.toCharArray());
        System.out.println(validPassword);
        
        System.out.println("Valid password: " + validPassword );
        System.out.println("hash: " + hash );
        
        return hash;
    }
    
  
    
}
