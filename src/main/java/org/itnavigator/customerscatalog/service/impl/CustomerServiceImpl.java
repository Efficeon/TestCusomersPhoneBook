package org.itnavigator.customerscatalog.service.impl;

import org.itnavigator.customerscatalog.dao.CustomerDao;
import org.itnavigator.customerscatalog.model.Customer;
import org.itnavigator.customerscatalog.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("customerService")
@Transactional (propagation = Propagation.SUPPORTS, readOnly = true)
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    @Transactional
    public List<Customer> listCustomers() {
        return this.customerDao.listCustomer();
    }

    @Override
    @Transactional
    public void updateAll(List<Customer> list) {
        this.customerDao.updateAll(list);
    }
}
