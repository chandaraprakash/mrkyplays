package com.cp.microservices.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cp.microservices.data.entity.Project;

@RepositoryRestResource
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {
	
	List<Project> findAll();
	
	Optional<Project> findByProjectId(Long projectId);
	
	List<Project> findProjectByUserId(@Param("userId") String userId);

}
