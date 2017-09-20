package com.xyyh.web.uap.converter;

import org.springframework.stereotype.Component;

import com.xyyh.web.common.converter.AbstractConverter;
import com.xyyh.web.common.uap.dto.RoleDto;
import com.xyyh.web.uap.entity.Role;

@Component
public class RoleConverter extends AbstractConverter<Role, RoleDto> {

	@Override
	public RoleDto toDto(Role role) {
		if (role != null) {
			RoleDto dto = new RoleDto();
			dto.setId(role.getId());
			dto.setName(role.getName());
			dto.setDescription(role.getDescription());
			dto.setAuthority(role.getAuthority());
			return dto;
		} else {
			return null;
		}
	}

	@Override
	public void copyProperties(Role dest, RoleDto source) {
		if (dest != null && source != null) {
			dest.setAuthority(source.getAuthority());
			dest.setDescription(source.getDescription());
			dest.setId(source.getId());
			dest.setName(source.getName());
		}
	}
}
