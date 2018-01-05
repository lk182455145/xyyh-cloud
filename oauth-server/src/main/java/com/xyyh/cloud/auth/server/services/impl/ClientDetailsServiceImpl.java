package com.xyyh.cloud.auth.server.services.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xyyh.cloud.auth.server.converter.ClientDetailsConverter;
import com.xyyh.cloud.auth.server.entity.ClientDetailsEntity;
import com.xyyh.cloud.auth.server.repository.ClientDetailsRepository;

@Service("localClientDetailsService")
public class ClientDetailsServiceImpl implements ClientDetailsService {

	@Autowired
	private ClientDetailsRepository clientRepository;

	@Autowired
	private ClientDetailsConverter convert;

	@Override
	@Transactional
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		return convert.toDto(findOne(clientId));
	}

	public ClientDetailsEntity findOne(String clientId) {
		return clientRepository.findOne(clientId);
	}
	
	@PostConstruct
	public void init() {
		System.out.println("a more created");
	}

}
