package com.matheusf.birthday.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class PeopleInsertDTO implements Serializable {
	private static final long serialVersionUID = 1L;
		
	@NotNull
	private Long userId;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	@Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Formato de data inválido. Tente novamente")
	private String dataDeNascimento;
	
	@NotBlank	
	@Pattern(regexp = "(\\d{2}) \\d{4,5}-\\d{4}", message = "Telefone inválido. Tente novamente")
	private String telefone1;
	
	private String telefone2;
	
	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
}