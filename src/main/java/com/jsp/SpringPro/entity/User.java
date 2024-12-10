package com.jsp.SpringPro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
	@Id
	private String userId;
	private String userName;
	@Column(unique = true)
	private String userEmail;
	private String userPassword;
	private String role;

}
