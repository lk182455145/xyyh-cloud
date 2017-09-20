package com.xyyh.web.uap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

import org.springframework.security.core.GrantedAuthority;

@Entity(name = "role_")
public class Role implements GrantedAuthority {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1844982582570461499L;
	@Id
	@Column(name = "id_")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "role_gen")
	@TableGenerator(allocationSize = 1, name = "role_gen", pkColumnValue = "role_", table = "pk_support_", pkColumnName = "table_", valueColumnName = "next_id_")
	private long id;

	@Column(name = "name_", length = 50, nullable = false, unique = true)
	private String name;

	@Column(name = "description_", length = 4000)
	private String description;

	@Column(name = "authority_", length = 50, nullable = false)
	private String authority;

	@Override
	public String getAuthority() {
		return authority;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
