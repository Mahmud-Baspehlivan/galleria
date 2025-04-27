package com.emrebaspehlivan.service;

import com.emrebaspehlivan.dto.DtoAddress;
import com.emrebaspehlivan.dto.DtoAddressIU;

public interface IAddressService {

    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU);

    public void deleteAddress(Long id);

    public DtoAddress updateAddress(Long id, DtoAddressIU dtoAddressIU);

}
