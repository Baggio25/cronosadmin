package com.baggio.projeto.cronosadminapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.baggio.projeto.cronosadminapi.entities.FinantialAccount;

@Repository
public interface FinantialAccountRepository extends JpaRepository<FinantialAccount, Long> {
	
	@Query("SELECT obj FROM FinantialAccount obj "
			+ "WHERE LOWER(obj.description) LIKE LOWER(CONCAT('%',:description,'%')) ")
	Page<FinantialAccount> findByDescriptionPaged(String description, Pageable pageable);
	
	
}
