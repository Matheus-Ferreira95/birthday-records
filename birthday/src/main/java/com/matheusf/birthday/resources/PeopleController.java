package com.matheusf.birthday.resources;

import java.net.URI;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheusf.birthday.dto.PeopleDTO;
import com.matheusf.birthday.dto.PeopleInsertDTO;
import com.matheusf.birthday.entities.People;
import com.matheusf.birthday.entities.User;
import com.matheusf.birthday.services.PeopleService;
import com.matheusf.birthday.services.UserService;

@RestController
@RequestMapping("/peoples")
public class PeopleController {
	
	@Autowired
	private PeopleService peopleService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<PeopleDTO> register(@Valid @RequestBody PeopleInsertDTO peopleInsert) {
		User user = userService.findById(peopleInsert.getUserId());
		People entity = toEntity(peopleInsert);
		entity = peopleService.register(entity, user);
		PeopleDTO dto = toDTO(entity);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);		
	}

	private PeopleDTO toDTO(People entity) {
		return modelMapper.map(entity, PeopleDTO.class);
	}

	private People toEntity(PeopleInsertDTO peopleInsert) {
		return modelMapper.map(peopleInsert, People.class);
	}
}
