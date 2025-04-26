package com.emrebaspehlivan.service;

import com.emrebaspehlivan.dto.DtoAddress;
import com.emrebaspehlivan.dto.DtoAddressIU;

public interface IAddressService {

    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU);

}
