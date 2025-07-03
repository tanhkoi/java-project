package com.tanhkoi.javaproject.springboot.security.service;

import com.tanhkoi.javaproject.springboot.model.User;
import com.tanhkoi.javaproject.springboot.security.dto.AuthenticatedUserDto;
import com.tanhkoi.javaproject.springboot.security.dto.RegistrationRequest;
import com.tanhkoi.javaproject.springboot.security.dto.RegistrationResponse;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
public interface UserService {

	User findByUsername(String username);

	RegistrationResponse registration(RegistrationRequest registrationRequest);

	AuthenticatedUserDto findAuthenticatedUserByUsername(String username);

}
