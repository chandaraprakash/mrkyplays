package com.cp.microservices.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cp.microservices.data.entity.User;
import com.cp.microservices.data.service.MarketplaceResourceService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping(value = "/v1")
@RestController
@Transactional
public class UserController {
	
private final MarketplaceResourceService marketplaceResourceService;
	
	@Autowired
	public UserController(MarketplaceResourceService marketplaceResourceService) {
		this.marketplaceResourceService = marketplaceResourceService;
	}
	
	@ApiOperation(value = "View a list of available Users", notes = "Get all users",
			consumes = "application/json, application/xml", produces = "application/json, application/xml",
			response = List.class)
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Successfully retrieved list"),
		    @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		    @ApiResponse(code = 404, message = "Resource not found"),
		    @ApiResponse(code = 500, message = "Internal server error")
		})
	@GetMapping("/users")
	public List<User> getUsers() {
		return marketplaceResourceService.getUser();
	}

}
