package com.emrebaspehlivan.controller.impl;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emrebaspehlivan.controller.IRestCustomerController;
import com.emrebaspehlivan.controller.RestBaseController;
import com.emrebaspehlivan.controller.RootEntity;
import com.emrebaspehlivan.dto.DtoCustomer;
import com.emrebaspehlivan.dto.DtoCustomerIU;
import com.emrebaspehlivan.service.ICustomerService;

import jakarta.validation.Valid;

@RequestMapping("/rest/api/customer")
@RestController
public class RestCustomerController extends RestBaseController implements IRestCustomerController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoCustomer> saveCustomer(@Valid @RequestBody DtoCustomerIU dtoCustomerIU) {
        return ok(customerService.saveCustomer(dtoCustomerIU));
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public RootEntity<Boolean> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ok(true);
    }

    @PutMapping("/update/{id}")
    @Override
    public RootEntity<DtoCustomer> updateCustomer(@PathVariable Long id,
            @Valid @RequestBody DtoCustomerIU dtoCustomerIU) {
        return ok(customerService.updateCustomer(id, dtoCustomerIU));
    }

}
