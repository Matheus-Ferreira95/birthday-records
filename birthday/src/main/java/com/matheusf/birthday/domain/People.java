package com.matheusf.birthday.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class People implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;		
	private Date birthday;
	private boolean hasDeleted;	
	
	@ManyToMany
	@JoinTable(name = "tb_people_user", joinColumns = @JoinColumn(name = "people_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Set<User> users = new HashSet<>();
	
	@ElementCollection
	@CollectionTable(name = "phones")
	private Set<String> phones = new HashSet<>();
				
	public People() {
	}
	
	public People(Long id, String name, Date birthday) {		
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;		
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
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
	
	public Boolean getHasDeleted() {
		return hasDeleted;
	}
		
	public Set<User> getUsers() {
		return users;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void deletePeople() {
		hasDeleted = true;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		People other = (People) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}