package org.itnavigator.customerscatalog.service;

import org.itnavigator.customerscatalog.model.Customer;

import java.util.List;

/**
 * Created by lion on 26.01.17.
 */
public interface CustomerService {

    public List<Customer> listCustomers();

    Customer getById(Integer id);

    void create(Customer customer);

    Customer update(Customer customer);
}
