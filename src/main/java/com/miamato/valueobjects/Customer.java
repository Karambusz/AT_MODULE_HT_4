package com.miamato.valueobjects;
import com.miamato.PropertyManager;



public class Customer {

    public String name;
    public String lastName;
    public String email;
    public String password;
    public String businessName;
    public String businessPassword;
    public String signInEmail;
    public String signInPassword;
    public String signInName;

    public Customer(PropertyManager propertyManager){
        this.name = propertyManager.getProperty("customer.name");
        this.lastName = propertyManager.getProperty("customer.last.name");
        this.password = propertyManager.getProperty("customer.password");
        this.businessName = propertyManager.getProperty("customer.business.name");
        this.businessPassword = propertyManager.getProperty("customer.business.password");
        this.signInEmail = propertyManager.getProperty("customer.sign.in.email");
        this.signInPassword = propertyManager.getProperty("customer.sign.in.password");
        this.signInName = propertyManager.getProperty("customer.sign.in.name");

    }

    public void setEmail(String email){
        this.email = email;
    }
}
