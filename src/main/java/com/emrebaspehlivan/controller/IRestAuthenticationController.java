package com.emrebaspehlivan.controller;

import com.emrebaspehlivan.dto.AuthRequest;
import com.emrebaspehlivan.dto.DtoUser;

public interface IRestAuthenticationController {

	public RootEntity<DtoUser> register(AuthRequest input);
}
