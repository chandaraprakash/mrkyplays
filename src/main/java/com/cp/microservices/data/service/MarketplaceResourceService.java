package com.cp.microservices.data.service;

import java.util.List;
import java.util.Optional;

import com.cp.microservices.data.entity.Project;
import com.cp.microservices.data.entity.Bid;
import com.cp.microservices.data.entity.User;

public interface MarketplaceResourceService {
	
	String greet(String name);
	
	List<User> getUser();
	
	List<Project> getProjects();
	
	Optional<Project> getProjectById(Long id);
	
	List<Project> getUserProjects(String userId);
	
	Project createProject(String userId, Project project);
	
	Bid createProjectBid(String userId, Bid project);
	
	Bid getProjectBid(String projectId);
}
