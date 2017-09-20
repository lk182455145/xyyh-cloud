package com.xyyh.web.common.uap.dto;

import org.springframework.security.core.GrantedAuthority;

import com.xyyh.web.common.dto.Dto;

import lombok.Data;

/**
 * 角色数据传输对象
 * 
 * @author LiDong
 *
 */
@Data
public class RoleDto implements Dto, GrantedAuthority {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String authority;
	private String name;
	private String description;

	@Override
	public String getAuthority() {
		return authority;
	}

}
