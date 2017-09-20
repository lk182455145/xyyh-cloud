package com.xyyh.web.uap.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.TableGenerator;

import org.springframework.http.HttpMethod;

@Entity(name = "resource_")
public class Resource {
	@Id
	@Column(name = "id_")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "resource_gen")
	@TableGenerator(allocationSize = 1, name = "resource_gen", pkColumnValue = "resource_", table = "pk_support_", pkColumnName = "table_", valueColumnName = "next_id_")
	private Long id;

	@Column(name = "url_", length = 4000, unique = true, nullable = true)
	private String url;

	@Column(name = "method")
	private HttpMethod method;

	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinTable(name = "resource_role_", joinColumns = {
			@JoinColumn(name = "resource_", referencedColumnName = "id_")
	}, inverseJoinColumns = { @JoinColumn(name = "role_", referencedColumnName = "id_") })
	private List<Role> roles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public HttpMethod getMethod() {
		return method;
	}

	public void setMethod(HttpMethod method) {
		this.method = method;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
