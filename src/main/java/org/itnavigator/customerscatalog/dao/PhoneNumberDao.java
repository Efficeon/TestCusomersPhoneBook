package org.itnavigator.customerscatalog.dao;

import org.itnavigator.customerscatalog.model.PhoneNumber;

import java.util.List;

/**
 * Created by lion on 26.01.17.
 */
public interface PhoneNumberDao {

    public List<PhoneNumber> getAll();

    public PhoneNumber getById(Integer id);

    public void create(PhoneNumber phoneNumber);

    public PhoneNumber update(PhoneNumber phoneNumber);
}
