package com.matheusf.birthday.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusf.birthday.domain.People;
import com.matheusf.birthday.domain.User;
import com.matheusf.birthday.repositories.PeopleRepository;
import com.matheusf.birthday.repositories.UserRepository;
import com.matheusf.birthday.services.exceptions.DomainException;

@Service
public class PeopleService {
	
	@Autowired
	private PeopleRepository peopleRepository;
	
	@Autowired
	private UserRepository userRepository;	
		
	public void register(People entity, User user) {			
		entity.getUsers().add(user);
		user.getPeoples().add(entity);
		userRepository.save(user);
		peopleRepository.save(entity);
	}

	public void checkBirthday(Date dateInsert) {
		Date dateNow = new Date();
		if (dateInsert.getTime() - dateNow.getTime() > 0) {
			throw new DomainException("Data inválida. Apenas datas passadas são aceitas");
		}		
	}	
}