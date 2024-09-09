package com.codegnan.customeraccount;



import java.sql.SQLException;

import com.codegnan.CustomerDao.CustomerDAO;
import com.codegnan.beans.Customer;
 
public class Main {
    public static void main(String[] args) {
        try {
        	CustomerDAO customerDAO = new CustomerDAO();
 
        	// Add a new customer
        	Customer customer = new Customer();
        	customer.setName("John Doe");
        	customer.setAccountNumber("123456782");
        	customer.setBalance(1000.0);
        	customerDAO.addCustomer(customer);
        	System.out.println("customer details added succesfully");
        	
        	// Deposit money into the account
        	customerDAO.deposit("123456789", 500.0);
        	System.out.println("Customer amount deposited succesfully");
        	
        	// Withdraw money from the account
        	customerDAO.withdraw("123456789", 200.0);
        	System.out.println("customer amount withdraw succesfully");
        	
        	// Update customer details
        	customer.setName("Jane Doe");
        	customerDAO.updateCustomer(customer);
        	//System.out.println("customer values are updated");
        	
        	// Delete a customer
        	customerDAO.deleteCustomer("123456789");
        	System.out.println("customer account deleted succesfully");
 
        	// Close resources
        	customerDAO.close();
        } catch (SQLException e) {
        	e.printStackTrace();
        }
    }
}
 
