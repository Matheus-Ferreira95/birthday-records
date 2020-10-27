package com.matheusf.birthday.dto;

import java.text.ParseException;

public class PeopleUpdateDTO {
		
	private String dataDeNascimento;
	private String telefone1;
	private String telefone2;
	
	public String getDataDeNascimento() throws ParseException {
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
