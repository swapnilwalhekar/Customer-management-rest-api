package org.jspiders.customerapi1.service;

import org.jspiders.customerapi1.model.Customer;
import org.jspiders.customerapi1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CustomerService {
    @Autowired
   private CustomerRepository repository;

    // insert/add new customer details in database table
    public void addNewCustomer(Customer c) {
        repository.save(c);
    }

    // display all customers
    public List<Customer> displayAllCustomer() {
        List<Customer> data=repository.findAll();
        return data;
    }

    // get customer by id
    public Customer getCustomerById(int id){
        return repository.findById(id).orElse(null);
    }

    // get list of customer by name
    public List<Customer> getCustomerByName(String name) {
        return repository.findByCustomerName(name);
    }

    // get list of customer by email
    public Customer getCustomerByEmail(String email) {
        return repository.findByCustomerEmail(email);
    }

    // get customer list having age greater than 50(age provided by user/in postman)
    public List<Customer> getCustomerByAge(int age) {
        return repository.findByCustomerAgeGreaterThan(age);
    }

    // get a customer list having a total purchase amt is less than specific amount
    public List<Customer> getCustomerByPurchase(double value) {
       return repository.findByTotalPurchaseLessThan(value);
    }

    public List<Customer> viewCustomers(String name) {
       return repository.viewCustomers(name);
    }

    public List<String> viewCustomerName(int age, double amount) {
        return repository.viewName(age,amount);
    }

    public List<String> displayCustomerName(String c){
        return repository.displayCustomerName(c);
    }

    public List<String> customerNameStartWith(String ch) {
        return repository.customerNameStartWith(ch);
    }

    public List<String> customerNameEndWith(String ch) {
        return repository.customerNameEndWith(ch);
    }
}
