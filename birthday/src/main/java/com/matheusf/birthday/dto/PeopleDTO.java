package com.matheusf.birthday.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class PeopleDTO {
				
	private String name;		
	private Date birthday;	
	private Set<String> telefones = new HashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Set<String> getTelefones() {
		return telefones;
	}
}