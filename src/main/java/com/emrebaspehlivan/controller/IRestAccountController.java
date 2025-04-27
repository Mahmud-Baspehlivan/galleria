package com.emrebaspehlivan.controller;

import com.emrebaspehlivan.dto.DtoAccount;
import com.emrebaspehlivan.dto.DtoAccountIU;

public interface IRestAccountController {

	public RootEntity<DtoAccount> saveAccount(DtoAccountIU dtoAccountIU);

	public RootEntity<Boolean> deleteAccount(Long id);

	public RootEntity<DtoAccount> updateAccount(Long id, DtoAccountIU dtoAccountIU);
}
