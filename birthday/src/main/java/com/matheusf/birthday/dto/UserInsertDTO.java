package com.matheusf.birthday.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class UserInsertDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String login;

	@NotBlank
	private String senha;
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setPassword(String senha) {
		this.senha = senha;
	}
}