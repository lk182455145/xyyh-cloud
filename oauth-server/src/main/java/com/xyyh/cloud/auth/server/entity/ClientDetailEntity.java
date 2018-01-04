package com.xyyh.cloud.auth.server.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "client_info_")
@Getter
@Setter
public class ClientDetailEntity {

	@Id
	@Column(name = "client_id_")
	private String id;

	@Column(name = "client_secret_")
	private String clientSecret;

	@ElementCollection
	private Set<String> scope;

	@ElementCollection
	private Set<String> authorizedGrantTypes;

}
