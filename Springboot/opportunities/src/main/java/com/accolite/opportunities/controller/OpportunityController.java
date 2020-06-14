package com.accolite.opportunities.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.opportunities.entity.Opportunity;
import com.accolite.opportunities.exception.OpportunityNotFoundException;
import com.accolite.opportunities.exception.OpportunityServiceErrorException;
import com.accolite.opportunities.service.OpportunityService;

@RestController
public class OpportunityController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public OpportunityService service;

	@GetMapping("/getoppurtunities")
	public List<Opportunity> opportunityInformation(@RequestHeader("authtoken") String id,
			@RequestHeader("authemail") String email) {
		if (service.validateRequestService(id, email) >= 1) {

			logger.info("Getting Opportunity details");
			List<Opportunity> opportunities = service.opportunityInformationService();

			return opportunities;
		} else {
			return null;
		}

	}

	@GetMapping("/getopportunityid/{oid}")
	@ResponseBody
	public Opportunity getId(@RequestHeader("authtoken") String id, @RequestHeader("authemail") String email,
			@PathVariable int oid) {
		if (service.validateRequestService(id, email) >= 1) {
			Opportunity getbyid;
			try {

				getbyid = service.getIdService(oid);
			} catch (EmptyResultDataAccessException e) {
				throw new OpportunityServiceErrorException();
			}

			return getbyid;
		} else {
			return null;
		}
	}

	@GetMapping("/validateuser/{firstname}/{lastname}/{email}")
	@ResponseBody
	public String validateUser(@RequestHeader("authtoken") String id, @PathVariable String firstname,
			@PathVariable String lastname, @PathVariable String email) {
		logger.info("Syncing User details");

		if (service.validateUserService(id, firstname, lastname, email).equals("User Synced")) {

			return "User Synced";
		} else {
			return "User not Synced";
		}

	}

	@PutMapping("/updatebyid")
	@ResponseBody
	public String updateOpportunity(@RequestHeader("authtoken") String id, @RequestHeader("authemail") String email,
			@RequestBody Opportunity op) {
		if (service.validateRequestService(id, email) >= 1) {
			if (service.updateOpportunityService(op).equals("Opportunity redefined Successfully")) {
				logger.info("Updating Opportunity details");
				return "Opportunity redefined Successfully";

			} else {
				throw new OpportunityNotFoundException();
			}
		} else {
			return "Non Authenticated User";
		}

	}

	@PostMapping("/addopp")
	@ResponseBody
	public String addOpportunity(@RequestHeader("authtoken") String id, @RequestHeader("authemail") String email,
			@RequestBody Opportunity opp) {
		if (service.validateRequestService(id, email) >= 1) {
			if (service.addOpportunityService(opp).equals("Opportunity created Successfully")) {
				logger.info("Adding Opportunity details");
				return "Opportunity created Successfully";

			} else {
				throw new OpportunityNotFoundException();
			}

		} else {
			return "Non Authenticated User";
		}

	}

	@DeleteMapping("/deleteopportunity/{oid}")
	@ResponseBody
	public String deleteOpportunity(@RequestHeader("authtoken") String id, @RequestHeader("authemail") String email,
			@PathVariable int oid) {
		if (service.validateRequestService(id, email) >= 1) {
			if (service.deleteOpportunityService(oid).equals("Opportunity Deleted Successfully")) {
				logger.info("Deleting Opportunity details");
				return "Opportunity Deleted Successfully";

			} else {
				throw new OpportunityNotFoundException();
			}
		} else {
			return "Non Authenticated User";
		}

	}

}
