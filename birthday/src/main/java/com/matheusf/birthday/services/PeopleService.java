package com.matheusf.birthday.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusf.birthday.entities.People;
import com.matheusf.birthday.entities.User;
import com.matheusf.birthday.repositories.PeopleRepository;
import com.matheusf.birthday.repositories.UserRepository;

@Service
public class PeopleService {
	
	@Autowired
	private PeopleRepository peopleRepository;
	
	@Autowired
	private UserRepository userRepository;	
		
	public People register(People entity, User user) {			
		entity.getUsers().add(user);
		user.getPeoples().add(entity);
		userRepository.save(user);
		return peopleRepository.save(entity);
	}
	
}
