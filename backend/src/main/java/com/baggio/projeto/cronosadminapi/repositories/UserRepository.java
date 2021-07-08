package com.baggio.projeto.cronosadminapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.baggio.projeto.cronosadminapi.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	@Query("SELECT obj FROM User obj "
			+ "WHERE LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%')) ")
	Page<User> findByName(String name, Pageable pageable);

	@Query("SELECT obj FROM User obj "
			+ "WHERE LOWER(obj.email) LIKE LOWER(CONCAT('%',:email,'%')) ")
	Page<User> findByEmail(String email, Pageable pageable);
	
}
