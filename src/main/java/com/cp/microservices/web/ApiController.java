package com.cp.microservices.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cp.microservices.data.service.MarketplaceResourceService;

@RequestMapping(value = "/v1")
@RestController
@Transactional
public class ApiController {
	
private final MarketplaceResourceService marketplaceResourceService;
	
	@Autowired
	public ApiController(MarketplaceResourceService marketplaceResourceService) {
		this.marketplaceResourceService = marketplaceResourceService;
	}

	@RequestMapping(method = GET, value="/hello")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return Optional.of(marketplaceResourceService.greet(name))
        		.orElse(null);
    }	
}
