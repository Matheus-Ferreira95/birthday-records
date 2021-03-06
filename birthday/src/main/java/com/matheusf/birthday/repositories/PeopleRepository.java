package com.matheusf.birthday.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.matheusf.birthday.domain.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {

	@Transactional(readOnly = true)
	People findByIdAndHasDeletedFalse(long id);		
}
