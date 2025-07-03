package com.tanhkoi.javaproject.springboot.security.service;

import com.tanhkoi.javaproject.springboot.model.User;
import com.tanhkoi.javaproject.springboot.security.dto.AuthenticatedUserDto;
import com.tanhkoi.javaproject.springboot.security.dto.RegistrationRequest;
import com.tanhkoi.javaproject.springboot.security.dto.RegistrationResponse;


public interface UserService {

	User findByUsername(String username);

	RegistrationResponse registration(RegistrationRequest registrationRequest);

	AuthenticatedUserDto findAuthenticatedUserByUsername(String username);

}
