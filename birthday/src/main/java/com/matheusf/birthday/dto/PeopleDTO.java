package com.matheusf.birthday.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.matheusf.birthday.domain.People;

public class PeopleDTO {
				
	private Long id;
	private String nome;		
	private Date dataDeNascimento;	
	
	private Set<String> telefones = new HashSet<>();

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

	public Set<String> getTelefones() {
		return telefones;
	}
}