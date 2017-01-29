package org.itnavigator.customerscatalog.dao.jpa;

import org.itnavigator.customerscatalog.dao.CustomerDao;
import org.itnavigator.customerscatalog.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("customerDao")
public class JpaCustomerDaoImpl implements CustomerDao {
    private static final Logger logger = LoggerFactory.getLogger(JpaCustomerDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Customer getById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Customer customer = (Customer) session.load(Customer.class, new Integer(id));

        logger.info("Customer successfully loaded. Customer details: " + customer);

        return customer;
    }

    @Override
    public void create(Customer customer) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(customer);

        logger.info("Customer successfully saved. Customer details: " + customer);
    }

    @Override
    public Customer update(Customer customer) {
        Session session = this.sessionFactory.getCurrentSession();
        Customer customerUpdate = (Customer) session.merge(customer);

        logger.info("Customer successfully updated. Customer details: " + customer);
        return customerUpdate;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Customer> listCustomer() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Customer> customerList = session.createQuery("from Customer").list();

        for (Customer customer : customerList) {
            logger.info("Customer customer: " + customer);
        }

        return customerList;
    }
}
