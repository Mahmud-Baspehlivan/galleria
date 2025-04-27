package com.emrebaspehlivan.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emrebaspehlivan.controller.IRestAddressController;
import com.emrebaspehlivan.controller.RestBaseController;
import com.emrebaspehlivan.controller.RootEntity;
import com.emrebaspehlivan.dto.DtoAddress;
import com.emrebaspehlivan.dto.DtoAddressIU;
import com.emrebaspehlivan.service.IAddressService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/address")
public class RestAddressController extends RestBaseController implements IRestAddressController {

	@Autowired
	private IAddressService addressService;

	@PostMapping("/save")
	@Override
	public RootEntity<DtoAddress> saveAddress(@Valid @RequestBody DtoAddressIU dtoAddressIU) {
		return ok(addressService.saveAddress(dtoAddressIU));
	}

	@PostMapping("/delete/{id}")
	@Override
	public RootEntity<Boolean> deleteAddress(Long id) {
		addressService.deleteAddress(id);
		return ok(true);
	}

	@PostMapping("/update/{id}")
	@Override
	public RootEntity<DtoAddress> updateAddress(Long id, @Valid @RequestBody DtoAddressIU dtoAddressIU) {
		return ok(addressService.updateAddress(id, dtoAddressIU));
	}

}
