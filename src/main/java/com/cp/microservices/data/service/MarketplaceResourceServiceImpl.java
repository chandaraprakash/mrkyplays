package com.cp.microservices.data.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.cp.microservices.api.exception.ApiError;
import com.cp.microservices.api.exception.ProjectNotFoundException;
import com.cp.microservices.data.entity.Project;
import com.cp.microservices.data.entity.Bid;
import com.cp.microservices.data.entity.User;
import com.cp.microservices.data.repository.BidRepository;
import com.cp.microservices.data.repository.ProjectRepository;
import com.cp.microservices.data.repository.UserRepository;

@Service("marketplaceResourceService")
public class MarketplaceResourceServiceImpl implements MarketplaceResourceService {
	
private final UserRepository userRepository;
private final ProjectRepository projectRepository;
private final BidRepository bidRepository;
	
	@Autowired
	public MarketplaceResourceServiceImpl(UserRepository userRepository,
											ProjectRepository projectRepository, 
											BidRepository bidRepository) {
		this.userRepository = userRepository;
		this.projectRepository = projectRepository;
		this.bidRepository = bidRepository;
	}

	@Override
	public String greet(String name) {
		return name == null ? "Hello World!" : "Hello " + name + "!";
	}

	@Override
	public List<User> getUser() {		
		
		return userRepository.findAll()
				.stream()
				.collect(Collectors.toList());
	}

	@Override
	public List<Project> getProjects() {
		return projectRepository.findAll()
				.stream()
				.collect(Collectors.toList());
	}

	@Override
	public List<Project> getUserProjects(String userId) {
		return projectRepository.findProjectByUserId(userId);
		
	}
	
	@Override
	public Optional<Project> getProjectById(Long id) {
		Optional<Project> project = null;
		try {
			project = projectRepository.findById(id);
		} catch (Exception e) {
			throw new ProjectNotFoundException(ApiError.ERROR_1001.getErrorCode(), ApiError.ERROR_1001.getErrorMessage());
		}
		
		if (!project.isPresent()) {
			throw new ProjectNotFoundException(ApiError.ERROR_1001.getErrorCode(), ApiError.ERROR_1001.getErrorMessage());
		}
		return project; 
	}

	@Override
	public Project createProject(String userId, Project project) {
		Assert.notNull(project.title, "title cannot be null");
		//Assert.notNull(project.userId, "userId cannot be null");
		Assert.notNull(project.description, "title cannot be null");
		
		Project result = null;
		
		project.setUserId(userId);
		
		try {
			result = projectRepository.save(project);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Bid createProjectBid(String userId, Bid bid) {
		bid.setUserId(userId);
		bid.setProjectId(bid.getProjectId());
		
		Bid result = null;
		
		try {
			result = bidRepository.save(bid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Bid getProjectBid(String projectId) {		
		return bidRepository.findTopByProjectIdOrderByBidAmountAsc(projectId);
	}
	
	
	
	

}
