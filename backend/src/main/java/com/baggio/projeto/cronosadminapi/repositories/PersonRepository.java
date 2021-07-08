package com.baggio.projeto.cronosadminapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.baggio.projeto.cronosadminapi.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

	@Query("SELECT obj FROM Person obj "
			+ "WHERE LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%')) ")
	Page<Person> findByName(String name, Pageable pageable);
	
}
