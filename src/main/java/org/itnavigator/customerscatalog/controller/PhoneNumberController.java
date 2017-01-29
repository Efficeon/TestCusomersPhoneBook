package org.itnavigator.customerscatalog.controller;

import org.itnavigator.customerscatalog.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Created by lion on 27.01.17.
 */
@Controller
public class PhoneNumberController {
    PhoneNumberService phoneNumberService;

    @Autowired
    @Qualifier(value = "phoneNumberService")
    public void setCompanyService(PhoneNumberService phoneNumberService) {
        this.phoneNumberService = phoneNumberService;
    }
}
