package com.tanhkoi.javaproject.springboot.security.service;

import com.tanhkoi.javaproject.springboot.service.UserValidationService;
import com.tanhkoi.javaproject.springboot.model.User;
import com.tanhkoi.javaproject.springboot.model.UserRole;
import com.tanhkoi.javaproject.springboot.security.dto.AuthenticatedUserDto;
import com.tanhkoi.javaproject.springboot.security.dto.RegistrationRequest;
import com.tanhkoi.javaproject.springboot.security.dto.RegistrationResponse;
import com.tanhkoi.javaproject.springboot.security.mapper.UserMapper;
import com.tanhkoi.javaproject.springboot.utils.GeneralMessageAccessor;
import com.tanhkoi.javaproject.springboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private static final String REGISTRATION_SUCCESSFUL = "registration_successful";

	private final UserRepository userRepository;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	private final UserValidationService userValidationService;

	private final GeneralMessageAccessor generalMessageAccessor;

	@Override
	public User findByUsername(String username) {

		return userRepository.findByUsername(username);
	}

	@Override
	public RegistrationResponse registration(RegistrationRequest registrationRequest) {

		userValidationService.validateUser(registrationRequest);

		final User user = UserMapper.INSTANCE.convertToUser(registrationRequest);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setUserRole(UserRole.USER);

		userRepository.save(user);

		final String username = registrationRequest.getUsername();
		final String registrationSuccessMessage = generalMessageAccessor.getMessage(null, REGISTRATION_SUCCESSFUL, username);

		log.info("{} registered successfully!", username);

		return new RegistrationResponse(registrationSuccessMessage);
	}

	@Override
	public AuthenticatedUserDto findAuthenticatedUserByUsername(String username) {

		final User user = findByUsername(username);

		return UserMapper.INSTANCE.convertToAuthenticatedUserDto(user);
	}
}
