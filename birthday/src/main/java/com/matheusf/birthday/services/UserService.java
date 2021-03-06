package com.matheusf.birthday.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusf.birthday.domain.User;
import com.matheusf.birthday.repositories.UserRepository;
import com.matheusf.birthday.services.exceptions.DomainException;
import com.matheusf.birthday.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
			
	public User register(User novoUser) {
		User user = userRepository.findByLogin(novoUser.getLogin());
		if (user != null) {
			throw new DomainException("Login já existente! Por favor escolha outro login");
		}		
		return userRepository.save(novoUser);
	}

	public boolean tryLogin(String login, String password) {
		User user = userRepository.findByLogin(login);
		if (user != null && user.getSenha().equals(password)) {
			return true;
		}
		throw new ResourceNotFoundException("Login ou senha inválido! Tente novamente");
	}	
	
	public User findById(Long id) {
		Optional<User> opt = userRepository.findById(id);
		if (opt.isEmpty()) {
			throw new ResourceNotFoundException("Usuário com id " + id + " não existe");
		}
		return opt.get();	
	}	
}