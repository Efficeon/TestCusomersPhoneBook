package org.itnavigator.customerscatalog.service;

import org.itnavigator.customerscatalog.model.PhoneNumber;

import java.util.List;

/**
 * Created by lion on 26.01.17.
 */
public interface PhoneNumberService {

    public List<PhoneNumber> getAll();

    public PhoneNumber getById(Integer id);

    public void create(PhoneNumber phoneNumber);

    public PhoneNumber update(PhoneNumber phoneNumber);
}
