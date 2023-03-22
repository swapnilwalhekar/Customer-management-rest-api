package org.jspiders.customerapi1.controller;

import org.jspiders.customerapi1.model.Customer;
import org.jspiders.customerapi1.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService service;

    @PostMapping("/customer")
    public void addNewCustomer(@RequestBody Customer c)
    {
        service.addNewCustomer(c);
    }

    @GetMapping("/customer")
    public List<Customer> displayAllCustomer(){
        return service.displayAllCustomer();
    }

    // pass params inside the postman as key:value pair(id:?)
    @GetMapping("/customerbyid")
    public Customer getCustomerById(@RequestParam int id){
        return service.getCustomerById(id);
    }

    @GetMapping("/customerbyname")
    public List<Customer> getCustomerByName(@RequestParam String name){
        return service.getCustomerByName(name);
    }

    @GetMapping("/customerbyemail")
    public Customer getCustomerByEmail(@RequestParam String email){
        return service.getCustomerByEmail(email);
    }

    @GetMapping("/customerbyage")
    public List<Customer> getCustomerAge(@RequestParam int age){
        return service.getCustomerByAge(age);
    }

    @GetMapping("/customerbypurchase")
    public List<Customer> getCustomerByPurchase(@RequestParam double value){
        return service.getCustomerByPurchase(value);
    }

    @GetMapping("/customer1")
    public List<Customer> viewCustomers(@RequestParam String name){
        return service.viewCustomers(name);
    }

    @GetMapping("/customername")
    public List<String> viewCustomerName(@RequestParam int age, @RequestParam double amount){
        return service.viewCustomerName(age,amount);
    }

    @GetMapping("/customer2")
    public List<String> displayCustomerName(@RequestParam String c){
        return service.displayCustomerName(c);
    }

    @GetMapping("/customerstartwith")
    public List<String> customerNameStartWith(@RequestParam String ch){
        return service.customerNameStartWith(ch);
    }

    @GetMapping("/customerendwith")
    public List<String> customerNameEndWith(@RequestParam String ch){
        return service.customerNameEndWith(ch);
    }
}
