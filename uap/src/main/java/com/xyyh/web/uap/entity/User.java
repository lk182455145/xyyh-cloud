package com.xyyh.web.uap.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.TableGenerator;

import lombok.Data;

@Entity(name = "user_")
@Data
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "user_gen")
	@TableGenerator(allocationSize = 1, name = "user_gen", pkColumnValue = "user_", table = "pk_support_", pkColumnName = "table_", valueColumnName = "next_id_")
	private Long id;

	@Column(name = "username_", length = 50, unique = true, nullable = false)
	private String username;

	@Column(name = "password_", length = 128)
	private String password;

	@Column(name = "enabled_")
	private boolean enabled;

	@Column(name = "credentials_expired_")
	private boolean credentialsExpired;

	@Column(name = "expired_")
	private boolean expired;

	@Column(name = "locked_")
	private boolean locked;

	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role_", joinColumns = {
			@JoinColumn(name = "user_", referencedColumnName = "id_") }, inverseJoinColumns = {
					@JoinColumn(name = "role_", referencedColumnName = "id_") })
	private List<Role> roles;

}
