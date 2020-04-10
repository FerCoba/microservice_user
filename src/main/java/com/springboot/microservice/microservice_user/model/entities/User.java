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
	@Column(unique = true, length = 30)
	private String userName;
	@Column(length = 100)
	private String password;
	private Boolean enabled;
	private String firstName;
	private String lastName;
	@Column(unique = true, length = 100)
	private String email;

	@JoinTable(uniqueConstraints = { @UniqueConstraint(columnNames = { "user_id", "roles_id" }) })
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Role> roles;

}
