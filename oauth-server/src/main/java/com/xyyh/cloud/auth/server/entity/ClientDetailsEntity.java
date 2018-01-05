package com.xyyh.cloud.auth.server.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "client_info_")
@Getter
@Setter
public class ClientDetailsEntity {

	@Id
	@Column(name = "client_id_")
	private String id;

	@Column(name = "client_secret_")
	private String clientSecret;

	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> scope;

	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> authorizedGrantTypes;

}
