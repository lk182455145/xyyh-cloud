package com.xyyh.cloud.auth.server.converter;

import org.springframework.stereotype.Component;

import com.xyyh.cloud.auth.server.dto.ClientDetailsDto;
import com.xyyh.cloud.auth.server.entity.ClientDetailsEntity;
import com.xyyh.web.common.converter.AbstractConverter;

@Component
public class ClientDetailsConverter extends AbstractConverter<ClientDetailsEntity, ClientDetailsDto> {

	@Override
	public ClientDetailsDto toDto(ClientDetailsEntity model) {
		ClientDetailsDto dto = new ClientDetailsDto();
		dto.setAuthorizedGrantTypes(model.getAuthorizedGrantTypes());
		dto.setClientSecret(model.getClientSecret());
		dto.setId(model.getId());
		dto.setScope(model.getScope());
		return dto;
	}

	@Override
	public void copyProperties(ClientDetailsEntity dest, ClientDetailsDto source) {

	}
}
