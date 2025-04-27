package com.emrebaspehlivan.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emrebaspehlivan.dto.DtoAccount;
import com.emrebaspehlivan.dto.DtoAccountIU;
import com.emrebaspehlivan.exception.BaseException;
import com.emrebaspehlivan.exception.ErrorMessage;
import com.emrebaspehlivan.exception.MessageType;
import com.emrebaspehlivan.model.Account;
import com.emrebaspehlivan.repository.AccountRepository;
import com.emrebaspehlivan.service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired
	private AccountRepository accountRepository;

	private Account createAccount(DtoAccountIU dtoAccountIU) {
		Account account = new Account();
		account.setCreateTime(new Date());

		BeanUtils.copyProperties(dtoAccountIU, account);

		return account;
	}

	@Override
	public DtoAccount saveAccount(DtoAccountIU dtoAccountIU) {

		DtoAccount dtoAccount = new DtoAccount();

		Account savedAccount = accountRepository.save(createAccount(dtoAccountIU));
		BeanUtils.copyProperties(savedAccount, dtoAccount);
		return dtoAccount;
	}

	@Override
	public void deleteAccount(Long id) {
		accountRepository.deleteById(id);
	}

	@Override
	public DtoAccount updateAccount(Long id, DtoAccountIU dtoAccountIU) {
		DtoAccount dtoAccount = new DtoAccount();

		Account account = accountRepository.findById(id)
				.orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString())));

		BeanUtils.copyProperties(dtoAccountIU, account);

		Account updatedAccount = accountRepository.save(account);
		BeanUtils.copyProperties(updatedAccount, dtoAccount);

		return dtoAccount;
	}
}
