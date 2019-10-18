package com.cp.microservices.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cp.microservices.data.entity.User;

/*@Transactional(readOnly=false)*/
//@RepositoryRestResource(collectionResourceRel="users", path="users")
@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, String> {
	
	List<User> findAll();
	
}
