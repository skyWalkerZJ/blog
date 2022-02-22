package com.quilt.dao;

import com.quilt.entity.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> GetAllCustomers();
    int AddCustomer(Customer customer);
}
