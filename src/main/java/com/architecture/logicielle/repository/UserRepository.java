package com.architecture.logicielle.repository;

import org.springframework.data.repository.CrudRepository;

import com.architecture.logicielle.repository.entities.UserEntity;
import java.lang.String;
import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
	List<UserEntity> findByStatut(String statut);
	
}
