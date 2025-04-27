package com.emrebaspehlivan.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emrebaspehlivan.controller.IRestAccountController;
import com.emrebaspehlivan.controller.RestBaseController;
import com.emrebaspehlivan.controller.RootEntity;
import com.emrebaspehlivan.dto.DtoAccount;
import com.emrebaspehlivan.dto.DtoAccountIU;
import com.emrebaspehlivan.service.IAccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/account")
public class RestAccountController extends RestBaseController implements IRestAccountController {

	@Autowired
	private IAccountService accountService;

	@PostMapping("/save")
	@Override
	public RootEntity<DtoAccount> saveAccount(@Valid @RequestBody DtoAccountIU dtoAccountIU) {
		return ok(accountService.saveAccount(dtoAccountIU));
	}

	@DeleteMapping("/delete/{id}")
	@Override
	public RootEntity<Boolean> deleteAccount(@PathVariable Long id) {
		accountService.deleteAccount(id);
		return ok(true);
	}

	@PutMapping("/update/{id}")
	@Override
	public RootEntity<DtoAccount> updateAccount(@PathVariable Long id, @Valid @RequestBody DtoAccountIU dtoAccountIU) {
		return ok(accountService.updateAccount(id, dtoAccountIU));
	}

}
