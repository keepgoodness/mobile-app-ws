package com.appsdeveloperblog.app.ws.io.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "users")
@Table(name = "users")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 5313493413859894403L;

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "user_id", nullable = false)
	private String userId;

	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 50)
	private String lastName;

	@Column(nullable = false, length = 120, unique = true)
	private String email;

	@Column(name = "encrypted_password", nullable = false)
	private String encryptedPassword;

	@Column(name = "email_verification_token")
	private String emailVerificationToken;

	@Column(nullable = false)
	private Boolean emailVerificationstatus = false;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getEmailVerificationToken() {
		return emailVerificationToken;
	}

	public void setEmailVerificationToken(String emailVerificationToken) {
		this.emailVerificationToken = emailVerificationToken;
	}

	public Boolean getEmailVerificationstatus() {
		return emailVerificationstatus;
	}

	public void setEmailVerificationstatus(Boolean emailVerificationstatus) {
		this.emailVerificationstatus = emailVerificationstatus;
	}
}
