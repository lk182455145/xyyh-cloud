package com.xyyh.web.uap.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xyyh.web.common.uap.dto.RoleDto;
import com.xyyh.web.uap.converter.RoleConverter;
import com.xyyh.web.uap.entity.Role;
import com.xyyh.web.uap.services.RoleService;
 

@RestController
@RequestMapping("role")
public class RoleController {
	@Autowired
	private RoleService roleService;

 
	@Autowired
	private RoleConverter roleConverter;

	@RequestMapping(method = RequestMethod.POST)
	public RoleDto save(@ModelAttribute RoleDto roleDto) {
		try {
			Role role = roleService.save(roleDto);
			return roleConverter.toDto(role);
		} catch (Exception e) {
			return null;
		}
	}

 
}
