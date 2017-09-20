package com.xyyh.web.uap.services.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xyyh.web.common.uap.dto.RoleDto;
import com.xyyh.web.uap.converter.RoleConverter;
import com.xyyh.web.uap.entity.Role;
import com.xyyh.web.uap.repositories.RoleRepository;
import com.xyyh.web.uap.services.RoleService;

@Service
public class RoleServiceSupport implements RoleService {
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private RoleConverter roleConverter;

	@Override
	@Transactional
	public Role save(RoleDto roleDto) {
		Role role = new Role();
		roleConverter.copyProperties(role, roleDto);
		role = roleRepository.save(role);
		return role;
	}

}
