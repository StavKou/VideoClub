/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.entities;

import com.example.demo.validators.Password;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author karat
 */
@Entity
@Table(name = "customers")
@NamedQueries({
    @NamedQuery(name = "Customers.findAll", query = "SELECT c FROM Customers c"),
    @NamedQuery(name = "Customers.findByCustomerId", query = "SELECT c FROM Customers c WHERE c.customerId = :customerId"),
    @NamedQuery(name = "Customers.findByUsername", query = "SELECT c FROM Customers c WHERE c.username = :username"),
    @NamedQuery(name = "Customers.findByCpassword", query = "SELECT c FROM Customers c WHERE c.cpassword = :cpassword"),
    @NamedQuery(name = "Customers.findByCusFName", query = "SELECT c FROM Customers c WHERE c.cusFName = :cusFName"),
    @NamedQuery(name = "Customers.findByCusLName", query = "SELECT c FROM Customers c WHERE c.cusLName = :cusLName"),
    @NamedQuery(name = "Customers.findByDateOfBirth", query = "SELECT c FROM Customers c WHERE c.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Customers.findByCity", query = "SELECT c FROM Customers c WHERE c.city = :city"),
    @NamedQuery(name = "Customers.findByStreetNumber", query = "SELECT c FROM Customers c WHERE c.streetNumber = :streetNumber"),
    @NamedQuery(name = "Customers.findByTelephoneNumber", query = "SELECT c FROM Customers c WHERE c.telephoneNumber = :telephoneNumber"),
    @NamedQuery(name = "Customers.findByEmail", query = "SELECT c FROM Customers c WHERE c.email = :email"),
    @NamedQuery(name = "Customers.findByTk", query = "SELECT c FROM Customers c WHERE c.tk = :tk"),
    @NamedQuery(name = "Customers.findByStreetAddress", query = "SELECT c FROM Customers c WHERE c.streetAddress = :streetAddress")})
public class Customers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customer_Id")
    private Integer customerId;
    
//    @NotEmpty(message = "UserName cannot be empty")
//    @NotNull(message = "UserName cannot be empty")
//    @NotBlank(message = "UserName cannot be empty")
    @Size(min = 5, max = 10, message = "min char for username is 5  and max 10")
    @Column(name = "username")
    private String username;
    
    @Size(min = 5, max = 10, message = "min char for password is 5 and max 10")
    @NotEmpty(message = "password cannot be empty")
    @Column(name = "cpassword")
    private String cpassword;
    
    @Size(max = 50)
    @Column(name = "cus_FName")
    private String cusFName;
    @Size(max = 50)
    @Column(name = "cus_LName")
    private String cusLName;
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Size(max = 50)
    @Column(name = "city")
    private String city;
    @Size(max = 50)
    @Column(name = "street_Number")
    private String streetNumber;
    @Size(max = 11)
    @Column(name = "telephone_Number")
    private String telephoneNumber;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Column(name = "tk")
    private Integer tk;
    @Size(max = 50)
    @Column(name = "street_address")
    private String streetAddress;

    public Customers() {
    }

    public Customers(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    public String getCusFName() {
        return cusFName;
    }

    public void setCusFName(String cusFName) {
        this.cusFName = cusFName;
    }

    public String getCusLName() {
        return cusLName;
    }

    public void setCusLName(String cusLName) {
        this.cusLName = cusLName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getTk() {
        return tk;
    }

    public void setTk(Integer tk) {
        this.tk = tk;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customers)) {
            return false;
        }
        Customers other = (Customers) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customers{");
        sb.append("customerId=").append(customerId);
        sb.append(", username=").append(username);
        sb.append(", cpassword=").append(cpassword);
        sb.append(", cusFName=").append(cusFName);
        sb.append(", cusLName=").append(cusLName);
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", city=").append(city);
        sb.append(", streetNumber=").append(streetNumber);
        sb.append(", telephoneNumber=").append(telephoneNumber);
        sb.append(", email=").append(email);
        sb.append(", tk=").append(tk);
        sb.append(", streetAddress=").append(streetAddress);
        sb.append('}');
        return sb.toString();
    }

  
    
}
