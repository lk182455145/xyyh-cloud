package com.xyyh.cloud.auth.server.dto;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import com.xyyh.web.common.dto.Dto;

public class ClientDetailsDto implements ClientDetails, Dto {

	private static final long serialVersionUID = -7408160396122766317L;

	@Id
	@Column(name = "client_id_")
	private String id;

	@Column(name = "client_secret_")
	private String clientSecret;

	@ElementCollection
	private Set<String> scope;

	@ElementCollection
	private Set<String> authorizedGrantTypes;

	@Override
	public String getClientId() {
		return id;
	}

	@Override
	public Set<String> getResourceIds() {
		return null;
	}

	@Override
	public boolean isSecretRequired() {
		return true;
	}

	@Override
	public String getClientSecret() {
		return clientSecret;
	}

	@Override
	public boolean isScoped() {
		return true;
	}

	@Override
	public Set<String> getScope() {
		return scope;
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		return null;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public Integer getAccessTokenValiditySeconds() {
		return 3600;
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		return 3600;
	}

	@Override
	public boolean isAutoApprove(String scope) {
		return false;
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		return null;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public void setScope(Set<String> scope) {
		this.scope = scope;
	}

	public void setAuthorizedGrantTypes(Set<String> authorizedGrantTypes) {
		this.authorizedGrantTypes = authorizedGrantTypes;
	}

}
