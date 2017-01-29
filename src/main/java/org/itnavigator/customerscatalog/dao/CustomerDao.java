package org.itnavigator.customerscatalog.dao;

import org.itnavigator.customerscatalog.model.Customer;

import java.util.List;

/**
 * Created by lion on 26.01.17.
 */
public interface CustomerDao {

    public List<Customer> listCustomer();

    public Customer getById(Integer id);

    public void create(Customer customer);

    public Customer update(Customer customer);
}
