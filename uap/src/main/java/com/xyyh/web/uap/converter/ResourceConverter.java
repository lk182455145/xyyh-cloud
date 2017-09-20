package com.xyyh.web.uap.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xyyh.web.common.converter.AbstractConverter;
import com.xyyh.web.common.uap.dto.ResourceDto;
import com.xyyh.web.uap.entity.Resource;

@Component
public class ResourceConverter extends AbstractConverter<Resource, ResourceDto> {

	@Autowired
	private RoleConverter roleConverter;

	/**
	 * 
	 * @param resource
	 * @return
	 */
	public ResourceDto toDto(Resource resource) {
		ResourceDto dto = new ResourceDto();
		dto.setId(resource.getId());
		dto.setMethod(resource.getMethod().toString());
		dto.setUrl(resource.getUrl());
		dto.setRoles(roleConverter.toDto(resource.getRoles()));
		return dto;
	}

	@Override
	public void copyProperties(Resource dest, ResourceDto source) {
		// TODO Auto-generated method stub

	}

}
