package com.cp.microservices.web;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cp.microservices.data.entity.Project;
import com.cp.microservices.data.service.MarketplaceResourceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping(value = "/v1")
@RestController
@Transactional
@Api(value="Project Controller")
public class ProjectController {
	
	private final MarketplaceResourceService marketplaceResourceService;
	
	@Autowired
	public ProjectController(MarketplaceResourceService marketplaceResourceService) {
		this.marketplaceResourceService = marketplaceResourceService;
	}
	
	@ApiOperation(value = "View a list of available Projects", 
			consumes = "application/json, application/xml", produces = "application/json, application/xml",
			response = List.class)
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 404, message = "Resource not found")
		})
	@GetMapping("/projects")
	public List<Project> getAllProjects() {
		return marketplaceResourceService.getProjects();
	}
	
	@ApiOperation(value = "View a list of available Projects for the requested User", 
			consumes = "application/json, application/xml", produces = "application/json, application/xml",
			response = ResponseEntity.class)
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 404, message = "Resource not found")
		})
	@GetMapping("/users/{userId}/projects")
	public ResponseEntity<List<Project>> getUserProjects(@PathVariable("userId") String userId) {
		List<Project> projects = marketplaceResourceService.getUserProjects(userId);
		return Optional.of(projects.stream().collect(Collectors.toList()))
				.map(p -> new ResponseEntity<List<Project>>(p, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
				
	}
	
	@ApiOperation(value = "View the requested Project details", 
			consumes = "application/json, application/xml", produces = "application/json, application/xml",
			response = ResponseEntity.class)
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 404, message = "Resource not found")
		})
	@GetMapping("/projects/{id}")
	public ResponseEntity<Project> getProjectById(@PathVariable("id") Long id) {
		
		Optional<Project> project = marketplaceResourceService.getProjectById(id);
		
		return project
				.map(p -> new ResponseEntity<Project>(p, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
				
	}
	
	@ApiOperation(value = "Add a Project")
	@PostMapping("/users/{userId}/projects")
	public ResponseEntity<Project> createProject(@ApiParam(value = "UserId of the requesting User", required = true)
										@PathVariable("userId") String userId,
										@Valid @RequestBody Project project) {
		Project obj = marketplaceResourceService.createProject(userId, project);
		
		return Optional.of(obj)
				.map(p -> new ResponseEntity<>(p, HttpStatus.CREATED))
				.orElse(new ResponseEntity<>(HttpStatus.CONFLICT));
				
	}

}
