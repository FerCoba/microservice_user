package com.springboot.microservice.microservice_user.model.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = -5315536663421359925L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "USERNAME", unique = true, length = 30)
	private String userName;
	@Column(name = "PASSWORD", length = 100)
	private String password;
	@Column(name = "ENABLED")
	private Boolean enabled;
	@Column(name = "FIRSTNAME")
	private String firstName;
	@Column(name = "LASTNAME")
	private String lastName;
	@Column(name = "EMAIL", unique = true, length = 100)
	private String email;

	@JoinTable(uniqueConstraints = { @UniqueConstraint(columnNames = { "USER_ID", "ROLES_ID" }) })
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Role> roles;

}
