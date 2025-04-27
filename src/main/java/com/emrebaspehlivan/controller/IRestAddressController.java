package com.emrebaspehlivan.controller;

import com.emrebaspehlivan.dto.DtoAddress;
import com.emrebaspehlivan.dto.DtoAddressIU;

public interface IRestAddressController {

	public RootEntity<DtoAddress> saveAddress(DtoAddressIU dtoAddressIU);

	public RootEntity<Boolean> deleteAddress(Long id);

	public RootEntity<DtoAddress> updateAddress(Long id, DtoAddressIU dtoAddressIU);
}
