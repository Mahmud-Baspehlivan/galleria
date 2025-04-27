package com.emrebaspehlivan.controller;

import com.emrebaspehlivan.dto.DtoCustomer;
import com.emrebaspehlivan.dto.DtoCustomerIU;

public interface IRestCustomerController {

    public RootEntity<DtoCustomer> saveCustomer(DtoCustomerIU dtoCustomerIU);

    public RootEntity<Boolean> deleteCustomer(Long id);

    public RootEntity<DtoCustomer> updateCustomer(Long id, DtoCustomerIU dtoCustomerIU);
}
