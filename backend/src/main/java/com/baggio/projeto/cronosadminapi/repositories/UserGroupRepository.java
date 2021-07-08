package com.baggio.projeto.cronosadminapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.baggio.projeto.cronosadminapi.entities.UserGroup;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, Long>{

	@Query("SELECT obj FROM UserGroup obj "
			+ "WHERE LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%')) ")
	Page<UserGroup> findByName(String name, Pageable pageable);
	
	
}
