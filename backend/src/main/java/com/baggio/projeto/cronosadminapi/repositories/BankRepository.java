package com.baggio.projeto.cronosadminapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.baggio.projeto.cronosadminapi.entities.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
	
	@Query("SELECT obj FROM Bank obj "
			+ "WHERE LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%')) ")
	Page<Bank> findByName(String name, Pageable pageable);

}
