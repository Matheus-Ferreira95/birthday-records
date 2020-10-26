package com.matheusf.birthday.entities.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusf.birthday.entities.User;
import com.matheusf.birthday.entities.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User cadastrar(User user) {
		return userRepository.save(user);
	}	
}
