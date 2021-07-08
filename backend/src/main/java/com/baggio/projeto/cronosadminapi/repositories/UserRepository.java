package com.baggio.projeto.cronosadminapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.baggio.projeto.cronosadminapi.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
