package com.emrebaspehlivan.service.impl;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.emrebaspehlivan.dto.AuthRequest;
import com.emrebaspehlivan.dto.DtoUser;
import com.emrebaspehlivan.model.User;
import com.emrebaspehlivan.repository.IUserRepository;
import com.emrebaspehlivan.service.IAuthenticationService;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

	@Autowired
	private IUserRepository iUserRepository;

	private BCryptPasswordEncoder passwordEncoder;

	private User createUser(AuthRequest input) {
		User user = new User();
		user.setCreateTime(new Date());
		user.setPassword(passwordEncoder.encode(input.getPassword()));

		return user;
	}

	@Override
	public DtoUser register(AuthRequest input) {

		DtoUser dtoUser = new DtoUser();

		User savedUser = iUserRepository.save(createUser(input));

		BeanUtils.copyProperties(savedUser, dtoUser);
		return null;
	}

}
