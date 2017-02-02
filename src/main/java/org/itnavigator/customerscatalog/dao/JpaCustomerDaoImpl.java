package org.itnavigator.customerscatalog.dao;

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
    @SuppressWarnings("unchecked")
    public List<Customer> listCustomer() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Customer> customerList = session.createQuery("from Customer").list();

        for (Customer customer : customerList) {
            logger.info("Customer customer: " + customer);
        }
        return customerList;
    }

    @Override
    public void updateAll(List<Customer> list) {
        for (Customer customer : list){
            this.sessionFactory.getCurrentSession().merge(customer);
            logger.info("Customer successfully updated. Customer details: " + customer);
        }
    }
}
