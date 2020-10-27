package com.matheusf.birthday.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.matheusf.birthday.domain.People;

public class PeopleDTO {
				
	private Long id;
	private String nome;		
	private Date dataDeNascimento;	
	
	private List<String> telefones = new ArrayList<>();

	public PeopleDTO(People people) {
		this.id = people.getId();
		nome = people.getName();
		dataDeNascimento = people.getBirthday();
		telefones = people.getPhones();		
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataDeNascimento() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(dataDeNascimento);
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public List<String> getTelefones() {
		return telefones;
	}
}