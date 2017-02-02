package org.itnavigator.customerscatalog.controller;

import org.itnavigator.customerscatalog.model.CustomerContainer;
import org.itnavigator.customerscatalog.model.Customer;
import org.itnavigator.customerscatalog.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/")
    String allCustomers(Model model){

        List<Customer> list = customerService.listCustomers();
        CustomerContainer customerContainerList = new CustomerContainer();
        customerContainerList.setList(list);
        model.addAttribute("customerContainer", customerContainerList);
        return "customers";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    CustomerContainer updateAll(@RequestBody CustomerContainer customerContainer){
        List<Customer> list = customerContainer.getList();
        customerService.updateAll(list);
        CustomerContainer customerContainerTemp = new CustomerContainer();
        customerContainerTemp.setList(customerService.listCustomers());
        return customerContainerTemp;
    }
}
