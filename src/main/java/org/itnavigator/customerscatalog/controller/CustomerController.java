package org.itnavigator.customerscatalog.controller;

import org.itnavigator.customerscatalog.model.Container;
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
        Container containerList = new Container();
        containerList.setList(list);
        model.addAttribute("container", containerList);
        return "customers";
    }

    @RequestMapping(value = "/updateAll", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    Container updateAll(@RequestBody Container container){
        List<Customer> list = container.getList();
        customerService.updateAll(list);
        Container container1 = new Container();
        container1.setList(customerService.listCustomers());
        return container1;
    }
}
