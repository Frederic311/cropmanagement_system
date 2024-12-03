package com.group2.cropmanagement.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String email;

	@Column
	private String password;

	@Column
	private String role;

	@Column
	private String fullname;

	@OneToMany(mappedBy = "user")
	@JsonManagedReference
	private List<Farm> farms;


	public User(String email, String encode, String user, String fullname) {
		this.email = email;
		this.password = encode;
		this.role = user;
		this.fullname = fullname;
	}
}
