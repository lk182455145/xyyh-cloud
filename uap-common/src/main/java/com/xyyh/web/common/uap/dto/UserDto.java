package com.xyyh.web.common.uap.dto;

import com.xyyh.web.common.dto.Dto;

import lombok.Data;

@Data
public class UserDto implements Dto {
	private static final long serialVersionUID = 3365521438775743670L;

	private Long id;

	private String username;

	private String password;

	private boolean enabled;

	private boolean credentialsExpired;

	private boolean expired;

	private boolean locked;

}
