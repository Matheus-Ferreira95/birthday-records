package com.matheusf.birthday.entities.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusf.birthday.entities.User;
import com.matheusf.birthday.entities.repositories.UserRepository;
import com.matheusf.birthday.entities.services.exceptions.DomainException;
import com.matheusf.birthday.entities.services.exceptions.ResourceNotFoundException;

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

	public boolean podeFazerLogin(User tryLogin) {
		User user = userRepository.findByLogin(tryLogin.getLogin());
		if (user != null && user.getSenha().equals(tryLogin.getSenha())) {
			return true;
		}
		throw new ResourceNotFoundException("Login ou senha inválido! Tente novamente");
	}	
}
