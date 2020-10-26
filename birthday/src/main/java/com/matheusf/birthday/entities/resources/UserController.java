package com.matheusf.birthday.entities.resources;

import java.net.URI;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.matheusf.birthday.entities.User;
import com.matheusf.birthday.entities.dto.UserDTO;
import com.matheusf.birthday.entities.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	public ResponseEntity<UserDTO> cadastrar(@RequestBody User user) {		
		user = userService.cadastrar(user);		
		UserDTO userDTO = toDTO(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(userDTO);		
	}
	
	private UserDTO toDTO(User user) {
		return modelMapper.map(user, UserDTO.class);
	}	
}