package com.cp.microservices.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cp.microservices.data.entity.Bid;

@RepositoryRestResource
public interface BidRepository extends JpaRepository<Bid, Long> {

	Bid findTopByProjectIdOrderByBidAmountAsc(@Param("projectId") String projectId);
}
