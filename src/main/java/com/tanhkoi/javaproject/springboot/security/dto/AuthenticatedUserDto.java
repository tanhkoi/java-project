package com.tanhkoi.javaproject.springboot.security.dto;

import com.tanhkoi.javaproject.springboot.model.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@Getter
@Setter
@NoArgsConstructor
public class AuthenticatedUserDto {

	private String name;

	private String username;

	private String password;

	private UserRole userRole;

}
