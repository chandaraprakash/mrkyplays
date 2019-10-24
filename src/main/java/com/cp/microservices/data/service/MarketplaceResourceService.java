package com.cp.microservices.data.service;

import java.util.List;
import java.util.Optional;

import com.cp.microservices.data.entity.Project;
import com.cp.microservices.data.entity.Bid;
import com.cp.microservices.data.entity.User;

public interface MarketplaceResourceService {
	
	/**
	 * Get all Users
	 * 
	 * @return
	 */
	List<User> getUser();
	
	/**
	 * Get all Projects
	 * 
	 * @return
	 */
	List<Project> getProjects();
	
	/**
	 * Get a Project by Id
	 * @param id	Project Id
	 * @return
	 */
	Optional<Project> getProjectById(Long id);
	
	/**
	 * Get all Projects for a User
	 * 
	 * @param userId	User Id
	 * @return
	 */
	List<Project> getUserProjects(String userId);
	
	/**
	 * Creates Project
	 * 
	 * @param userId	User Id
	 * @param project
	 * @return
	 */
	Project createProject(String userId, Project project);
	
	/**
	 * Submit Bid for a Project
	 * @param userId	User Id
	 * @param project
	 * @return
	 */
	Bid createProjectBid(String userId, Bid project);
	
	/**
	 * 
	 * @param projectId	Project Id
	 * @return
	 */
	Bid getProjectBid(String projectId);
}
