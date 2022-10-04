
package com.example.demo.repositories;

import com.example.demo.entities.Customers;
import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CustomerRepository extends JpaRepository<Customers, Integer>{
        
@Query(value = "SELECT  * FROM wannabe_videoclub.customers;" , nativeQuery = true)
public List<Customers> getPasswordAndUserNames();


}
