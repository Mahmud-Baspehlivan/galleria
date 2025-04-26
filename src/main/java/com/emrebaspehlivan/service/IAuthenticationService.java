package com.emrebaspehlivan.service;

import com.emrebaspehlivan.dto.AuthRequest;
import com.emrebaspehlivan.dto.AuthResponse;
import com.emrebaspehlivan.dto.DtoUser;

public interface IAuthenticationService {
	
	public DtoUser register(AuthRequest input);
	
	public AuthResponse authenticate(AuthRequest input);
}
