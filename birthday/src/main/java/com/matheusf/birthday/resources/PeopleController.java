package com.matheusf.birthday.resources;

import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheusf.birthday.domain.People;
import com.matheusf.birthday.domain.User;
import com.matheusf.birthday.dto.PeopleDTO;
import com.matheusf.birthday.dto.PeopleInsertDTO;
import com.matheusf.birthday.services.PeopleService;
import com.matheusf.birthday.services.UserService;

@RestController
@RequestMapping("/peoples")
public class PeopleController {
	
	@Autowired
	private PeopleService peopleService;
		
	@Autowired
	private UserService userService;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	@PostMapping
	public ResponseEntity<PeopleDTO> register(@Valid @RequestBody PeopleInsertDTO peopleInsert) throws ParseException {
		User user = userService.findById(peopleInsert.getUserId());
		People entity = toEntity(peopleInsert);
		peopleService.register(entity, user);
		PeopleDTO dto = toDTO(entity);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);		
	}

	private PeopleDTO toDTO(People entity) {
		return new PeopleDTO(entity);
	}

	private People toEntity(PeopleInsertDTO peopleInsert) throws ParseException {	
		peopleService.checkBirthday(sdf.parse(peopleInsert.getDataDeNascimento()));
		People entity = new People();			
		entity.setBirthday(sdf.parse(peopleInsert.getDataDeNascimento()));
		entity.setName(peopleInsert.getNome());
		entity.getPhones().add(peopleInsert.getTelefone1());
		if (peopleInsert.getTelefone2() != null) {
			entity.getPhones().add(peopleInsert.getTelefone2());
		}
		return entity;
	}
}
