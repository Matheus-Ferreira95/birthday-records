package com.matheusf.birthday.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.matheusf.birthday.domain.People;
import com.matheusf.birthday.domain.User;
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
				
		People p1 = new People(null, "Diego", sdf.parse("10/10/1885"));
		People p2 = new People(null, "Luana", sdf.parse("12/05/1895"));
		People p3 = new People(null, "carmen", sdf.parse("27/10/2020"));
		People p4 = new People(null, "jane", sdf.parse("06/11/2001"));
		People p5 = new People(null, "maria souza carmen", sdf.parse("27/10/2010"));
		People p6 = new People(null, "fernando", sdf.parse("15/06/2002"));
		People p7 = new People(null, "lala", sdf.parse("03/10/2011"));
		p1.getPhones().add("34 91111-5547");
		p2.getPhones().add("34 93478-6747");
		p3.getPhones().add("34 92893-1111");
		p4.getPhones().add("34 90157-0101");
		p5.getPhones().add("34 91476-0479");
		p6.getPhones().addAll(Arrays.asList("34 99999-3333", "34 88888-2010"));
		p7.getPhones().addAll(Arrays.asList("34 87878-0000", "34 91101-0147"));
		
		u1.getPeoples().addAll(Arrays.asList(p1, p3, p4, p5, p6));
		u2.getPeoples().addAll(Arrays.asList(p2, p5, p6, p7));
		
		p1.getUsers().addAll(Arrays.asList(u1));
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
