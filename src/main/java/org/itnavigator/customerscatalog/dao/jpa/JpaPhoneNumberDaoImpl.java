package org.itnavigator.customerscatalog.dao.jpa;

import org.itnavigator.customerscatalog.dao.PhoneNumberDao;
import org.itnavigator.customerscatalog.model.PhoneNumber;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by lion on 26.01.17.
 */

@Repository("phoneNumberDao")
public class JpaPhoneNumberDaoImpl implements PhoneNumberDao{

    private static final Logger logger = LoggerFactory.getLogger(JpaPhoneNumberDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<PhoneNumber> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        List<PhoneNumber> phoneNumbers = session.createQuery("from PhoneNumber").list();

        for (PhoneNumber phoneNumber : phoneNumbers){
            logger.info("PhoneNumber list: " + phoneNumber);
        }
        return phoneNumbers;
    }

    @Override
    public PhoneNumber getById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        PhoneNumber phoneNumber = (PhoneNumber) session.load(PhoneNumber.class, new Integer(id));
        logger.info("PhoneNumber successfully loaded. PhoneNumber details: " + phoneNumber);
        return phoneNumber;
    }

    @Override
    public void create(PhoneNumber phoneNumber) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(phoneNumber);
        logger.info("PhoneNumber successfully saved. PhoneNumber details: " + phoneNumber);
    }

    @Override
    public PhoneNumber update(PhoneNumber phoneNumber) {
        Session session = this.sessionFactory.getCurrentSession();
        PhoneNumber phoneNumberUpdate = (PhoneNumber) session.merge(phoneNumber);
        logger.info("PhoneNumber successfully saved. PhoneNumber details: " + phoneNumberUpdate);
        return phoneNumberUpdate;
    }
}
