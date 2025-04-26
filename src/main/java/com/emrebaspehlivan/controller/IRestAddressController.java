package com.emrebaspehlivan.controller;

import com.emrebaspehlivan.dto.DtoAddress;
import com.emrebaspehlivan.dto.DtoAddressIU;

public interface IRestAddressController {

	public RootEntity<DtoAddress> saveAddress(DtoAddressIU dtoAddressIU);
}
