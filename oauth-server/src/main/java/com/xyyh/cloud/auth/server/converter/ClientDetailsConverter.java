package com.xyyh.cloud.auth.server.converter;

import com.xyyh.cloud.auth.server.dto.ClientDetailsDto;
import com.xyyh.cloud.auth.server.entity.ClientDetailEntity;
import com.xyyh.web.common.converter.AbstractConverter;

public class ClientDetailsConverter extends AbstractConverter<ClientDetailEntity, ClientDetailsDto> {

	@Override
	public ClientDetailsDto toDto(ClientDetailEntity model) {
		ClientDetailsDto dto = new ClientDetailsDto();
		dto.setAuthorizedGrantTypes(model.getAuthorizedGrantTypes());
		dto.setClientSecret(model.getClientSecret());
		dto.setId(model.getId());
		dto.setScope(model.getScope());
		return dto;
	}

	@Override
	public void copyProperties(ClientDetailEntity dest, ClientDetailsDto source) {

	}
}
