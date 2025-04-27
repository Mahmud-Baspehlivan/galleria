package com.emrebaspehlivan.service;

import com.emrebaspehlivan.dto.DtoAccount;
import com.emrebaspehlivan.dto.DtoAccountIU;

public interface IAccountService {

	public DtoAccount saveAccount(DtoAccountIU dtoAccountIU);

	public void deleteAccount(Long id);

	public DtoAccount updateAccount(Long id, DtoAccountIU dtoAccountIU);

}
