package com.matheusf.birthday.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusf.birthday.domain.People;
import com.matheusf.birthday.domain.User;
import com.matheusf.birthday.dto.PeopleUpdateDTO;
import com.matheusf.birthday.repositories.PeopleRepository;
import com.matheusf.birthday.repositories.UserRepository;
import com.matheusf.birthday.services.exceptions.DomainException;
import com.matheusf.birthday.services.exceptions.ResourceNotFoundException;

@Service
public class PeopleService {
	
	@Autowired
	private PeopleRepository peopleRepository;
	
	@Autowired
	private UserRepository userRepository;	
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
	public void register(People entity, User user) {			
		entity.getUsers().add(user);
		user.getPeoples().add(entity);
		userRepository.save(user);
		peopleRepository.save(entity);
	}

	public void checkBirthday(String date) throws ParseException {
		Date dateInsert = sdf.parse(date);
		Date dateNow = new Date();
		if (dateInsert.getTime() - dateNow.getTime() > 0) {
			throw new DomainException("Data inválida. Apenas datas passadas são aceitas");
		}		
	}	
	
	public People findById(Long id) {
		Optional<People> opt = peopleRepository.findById(id);
		return opt.orElseThrow(() -> new ResourceNotFoundException("Pessoa com id " + id + " não existe"));
	}

	public People update(PeopleUpdateDTO peopleUpdate, Long id) throws ParseException {
		try {
			People entity = peopleRepository.getOne(id);
			updateData(entity, peopleUpdate);
			return peopleRepository.save(entity);
		} catch (EntityNotFoundException e) {			
			throw new ResourceNotFoundException("Pessoa com id " + id + " não existe");
		}		
	}	
	
	private void updateData(People entity, PeopleUpdateDTO peopleUpdate) throws ParseException {
		if (peopleUpdate.getDataDeNascimento() != null) {
			entity.setBirthday(peopleUpdate.getDataDeNascimento());
		}
		if (peopleUpdate.getTelefone1() != null) {			
			entity.getPhones().set(0, peopleUpdate.getTelefone1());
		}
		if (peopleUpdate.getTelefone2() != null) {			
			entity.getPhones().set(1, peopleUpdate.getTelefone2());
		}				
	}		
}
