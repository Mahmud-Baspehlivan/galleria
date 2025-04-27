package com.emrebaspehlivan.service;

import com.emrebaspehlivan.dto.DtoCustomer;
import com.emrebaspehlivan.dto.DtoCustomerIU;

public interface ICustomerService {

    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);

    public DtoCustomer deleteCustomer(Long id);

    public DtoCustomer updateCustomer(Long id, DtoCustomerIU dtoCustomerIU);
}
