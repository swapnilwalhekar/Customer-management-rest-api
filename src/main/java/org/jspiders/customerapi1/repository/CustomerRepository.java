package org.jspiders.customerapi1.repository;

//import org.jspiders.customerapi.model.Customer;
import org.jspiders.customerapi1.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    // returns the list of all customers having specific name
    List<Customer> findByCustomerName(String name);

    // return the customer by email
    Customer findByCustomerEmail(String email);

    // returns a customer list having age greater than specific age(provided by user)
    List<Customer> findByCustomerAgeGreaterThan(int age);

    // returns a customer list having total purchase amount is less than provided amount
    List<Customer> findByTotalPurchaseLessThan(double value);

    //Writing JPQL
    @Query("select c from Customer c where c.customerName=:name")
    List<Customer> viewCustomers(@Param("name") String name);

    // Write JPQL to fetch customer names having age<? and amt >=?
    @Query("select c.customerName from Customer c where c.customerAge<:age and c.totalPurchase>=:amount")
    List<String> viewName(@Param("age")int age,@Param("amount")double amount);

    //  Write JPQL to fetch customer names whose name contains given characters
    @Query("select c.customerName from Customer c where c.customerName like %:c%")
    List<String> displayCustomerName(@Param("c")String c);

    // Write JPQL to fetch the customer name starts with specific characters
    @Query("select c.customerName from Customer c where c.customerName like :ch%")
    List<String> customerNameStartWith(@Param("ch")String ch);

    // Write JPQL to fetch the customer name ends with specific characters
    @Query("select c.customerName from Customer c where c.customerName like %:ch")
    List<String> customerNameEndWith(@Param("ch")String ch);

}
