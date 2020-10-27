package com.matheusf.birthday.resources;

import java.net.URI;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheusf.birthday.domain.User;
import com.matheusf.birthday.dto.UserDTO;
import com.matheusf.birthday.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	public ResponseEntity<UserDTO> cadastrar(@Valid @RequestBody User user) {		
		user = userService.register(user);		
		UserDTO userDTO = toDTO(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(userDTO);		
	}
	
	@PutMapping
	public ResponseEntity<Void> fazerLogin(@Valid @RequestBody User user) {
		userService.canBeLogin(user);
		return ResponseEntity.noContent().build();
	}
	
	
	private UserDTO toDTO(User user) {
		return modelMapper.map(user, UserDTO.class);
	}	
}
