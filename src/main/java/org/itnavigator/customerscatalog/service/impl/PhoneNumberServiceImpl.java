package org.itnavigator.customerscatalog.service.impl;

import org.itnavigator.customerscatalog.dao.PhoneNumberDao;
import org.itnavigator.customerscatalog.model.PhoneNumber;
import org.itnavigator.customerscatalog.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lion on 26.01.17.
 */

@Service("phoneNumberService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PhoneNumberServiceImpl implements PhoneNumberService{

    @Autowired
    private PhoneNumberDao phoneNumberDao;

    public void setPhoneNumberDao(PhoneNumberDao phoneNumberDao) {
        this.phoneNumberDao = phoneNumberDao;
    }

    @Override
    @Transactional
    public List<PhoneNumber> getAll() {
        return this.phoneNumberDao.getAll();
    }

    @Override
    @Transactional
    public PhoneNumber getById(Integer id) {
        return this.phoneNumberDao.getById(id);
    }

    @Override
    @Transactional
    public void create(PhoneNumber phoneNumber) {
        this.phoneNumberDao.create(phoneNumber);
    }

    @Override
    @Transactional
    public PhoneNumber update(PhoneNumber phoneNumber) {
        return this.phoneNumberDao.update(phoneNumber);
    }
}
