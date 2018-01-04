package com.xyyh.web.uap.converter;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xyyh.web.common.converter.AbstractConverter;
import com.xyyh.web.common.uap.dto.UserDetailsDto;
import com.xyyh.web.common.uap.dto.UserDto;
import com.xyyh.web.uap.entity.Role;
import com.xyyh.web.uap.entity.User;

@Component
public class UserConverter extends AbstractConverter<User, UserDto> {

	@Autowired
	private RoleConverter roleConverter;

	@Override
	public UserDto toDto(final User entity) {
		if (entity != null) {
			final UserDto dto = new UserDto();
			copyToDto(entity, dto);
			return dto;
		} else {
			return null;
		}
	}

	/**
	 * 从数据传输对象复制用户的属性到实体对象<br />
	 * 不会复制ID和密码属性
	 */
	@Override
	public void copyProperties(final User dest, final UserDto source) {
		if (source != null && dest != null) {
			dest.setCredentialsExpired(source.isCredentialsExpired());
			dest.setEnabled(source.isEnabled());
			dest.setExpired(source.isExpired());
			dest.setLocked(source.isLocked());
			dest.setUsername(source.getUsername());
		}
	}

	public UserDetailsDto toDetailsDto(User entity) {
		if (entity != null) {
			UserDetailsDto dto = new UserDetailsDto();
			copyToDto(entity, dto);
			List<Role> roles = entity.getRoles();
			if (CollectionUtils.isNotEmpty(roles)) {
				dto.setAuthorities(roleConverter.toDto(roles));
			}
			return dto;
		} else {
			return null;
		}
	}

	/**
	 * 复制数据到DTO，不会复制密码信息
	 * 
	 * @param from
	 * @param dest
	 */
	private void copyToDto(User from, UserDto dest) {
		dest.setCredentialsExpired(from.isCredentialsExpired());
		dest.setEnabled(from.isEnabled());
		dest.setExpired(from.isExpired());
		dest.setId(from.getId());
		dest.setLocked(from.isLocked());
		dest.setUsername(from.getUsername());
	}

}
