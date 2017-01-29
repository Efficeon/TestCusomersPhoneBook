package org.itnavigator.customerscatalog.controller;

import org.itnavigator.customerscatalog.model.Customer;
import org.itnavigator.customerscatalog.model.PhoneNumber;
import org.itnavigator.customerscatalog.service.CustomerService;
import org.itnavigator.customerscatalog.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.json.JSONObject;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private PhoneNumberService phoneNumberService;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String listCustomerService(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("listCustomers", this.customerService.listCustomers());

        return "customers";
    }

    @RequestMapping(value = "/customers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void page(@RequestBody String data, @ModelAttribute PhoneNumber phoneNumber) {
        JSONObject jsonObject = new JSONObject(data);
        phoneNumber.setId(jsonObject.getInt("id"));
        phoneNumber.setNumber(jsonObject.getString("number"));
        phoneNumber.setType(jsonObject.getString("type"));
        phoneNumber.setDescription(jsonObject.getString("comment"));
        phoneNumberService.update(phoneNumber);
    }
}
