package com.matheusf.birthday.entities.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusf.birthday.entities.User;
import com.matheusf.birthday.entities.repositories.UserRepository;
import com.matheusf.birthday.entities.services.exceptions.DomainException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User cadastrar(User novoUser) {
		User user = userRepository.findByLogin(novoUser.getLogin());
		if (user != null) {
			throw new DomainException("Login já existente! Por favor escolha outro login");
		}		
		return userRepository.save(novoUser);
	}	
}
