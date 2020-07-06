package com.demo.param;

import javax.validation.constraints.NotBlank;

import lombok.Data;

/**
 * User param
 * @author Larry_lee
 * @since 2020-07-04
 */
@Data
public class UserParam {
	
	// user account
	@NotBlank(message = "Account is require")
	private String account;
	
	// user password
	@NotBlank(message = "Password is require")
	private String password;
	
	// user Type default APP
	private String userType = "APP";

}
