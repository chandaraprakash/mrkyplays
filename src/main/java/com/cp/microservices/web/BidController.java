package com.cp.microservices.web;

import java.util.Optional;

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

import com.cp.microservices.data.entity.Bid;
import com.cp.microservices.data.service.MarketplaceResourceService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RequestMapping(value = "/v1")
@RestController
@Transactional
public class BidController {
	
	private final MarketplaceResourceService marketplaceResourceService;
	
	@Autowired
	public BidController(MarketplaceResourceService marketplaceResourceService) {
		this.marketplaceResourceService = marketplaceResourceService;
	}
	
	@ApiOperation(value = "Submit Bid to a Project")
	@PostMapping("/users/{userId}/bid")
	public ResponseEntity<Bid> createProjectBid(@ApiParam(value = "UserId of the User submitting the Bid", required = true)
											@PathVariable("userId") String userId,														
											@RequestBody Bid projectBid) {
		
		Bid obj = marketplaceResourceService.createProjectBid(userId, projectBid);

		return Optional.of(obj).map(p -> new ResponseEntity<>(p, HttpStatus.CREATED))
				.orElse(new ResponseEntity<>(HttpStatus.CONFLICT));

	}
	
	@ApiOperation(value = "Project with the Lowest Bid")
	@GetMapping("/project/{projectId}/bid")
	public ResponseEntity<Bid> getProjectBid(@ApiParam(value = "Project Id", required = true)
										@PathVariable("projectId") String projectId) {
		Bid obj = marketplaceResourceService.getProjectBid(projectId);

		return Optional.of(obj).map(p -> new ResponseEntity<>(p, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
}
