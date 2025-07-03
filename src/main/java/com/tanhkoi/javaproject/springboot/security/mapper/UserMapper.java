package com.tanhkoi.javaproject.springboot.security.mapper;

import com.tanhkoi.javaproject.springboot.model.User;
import com.tanhkoi.javaproject.springboot.security.dto.AuthenticatedUserDto;
import com.tanhkoi.javaproject.springboot.security.dto.RegistrationRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	User convertToUser(RegistrationRequest registrationRequest);

	AuthenticatedUserDto convertToAuthenticatedUserDto(User user);

	User convertToUser(AuthenticatedUserDto authenticatedUserDto);

}
