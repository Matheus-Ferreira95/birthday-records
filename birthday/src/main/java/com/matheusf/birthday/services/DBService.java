package com.matheusf.birthday.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusf.birthday.entities.People;
import com.matheusf.birthday.entities.User;
import com.matheusf.birthday.repositories.PeopleRepository;
import com.matheusf.birthday.repositories.UserRepository;

@Service
public class DBService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PeopleRepository peopleRepository;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public void instantiateTestDatabase() throws ParseException {
		
		User u1 = new User(null, "matheus@gmail.com", "123456789");
		User u2 = new User(null, "diana@gmail.com", "95211247");
				
		People p1 = new People(null, "Diego", sdf.parse("10/05/1885"));
		People p2 = new People(null, "Luana", sdf.parse("12/05/1895"));
		People p3 = new People(null, "carmen", sdf.parse("10/07/1999"));
		People p4 = new People(null, "jane", sdf.parse("08/03/2001"));
		People p5 = new People(null, "maria", sdf.parse("29/04/2010"));
		People p6 = new People(null, "fernando", sdf.parse("15/06/2002"));
		People p7 = new People(null, "lalal", sdf.parse("03/01/2011"));
		
		u1.getPeoples().addAll(Arrays.asList(p1, p3, p4, p5));
		u2.getPeoples().addAll(Arrays.asList(p2, p6, p7));
		
		p1.getUsers().addAll(Arrays.asList(u1, u2));
		p2.getUsers().add(u2);
		p3.getUsers().add(u1);
		p4.getUsers().add(u1);
		p5.getUsers().addAll(Arrays.asList(u1, u2));
		p6.getUsers().addAll(Arrays.asList(u2, u1));
		p7.getUsers().add(u2);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		peopleRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7));		
	}	
}
