package com.accolite.opportunities.controller;

import java.sql.Timestamp;
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
import com.accolite.opportunities.repository.OpportunityDao;

@RestController
public class OpportunityController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public OpportunityDao dao;

	@GetMapping("/getoppurtunities")
	public List<Opportunity> opportunityInformation(@RequestHeader("authtoken") String id,
			@RequestHeader("authemail") String email) {
		if (dao.validateRequest(id, email) >= 1) {

			logger.info("Getting Opportunity details");
			List<Opportunity> opportunities = dao.getOpportunities();

			return opportunities;
		} else {
			return null;
		}

	}

	@GetMapping("/getopportunityid/{oid}")
	@ResponseBody
	public Opportunity getId(@RequestHeader("authtoken") String id, @RequestHeader("authemail") String email,
			@PathVariable int oid) {
		if (dao.validateRequest(id, email) >= 1) {
			Opportunity getbyid;
			try {

				getbyid = dao.getid(oid);
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
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		if (dao.updateuser(id, firstname, lastname, email, timestamp) >= 1) {

			return "User Synced";
		} else {
			return "User not Synced";
		}

	}

	@PutMapping("/updatebyid")
	@ResponseBody
	public String updateOpportunity(@RequestHeader("authtoken") String id, @RequestHeader("authemail") String email,
			@RequestBody Opportunity op) {
		if (dao.validateRequest(id, email) >= 1) {
			if (dao.update(op.oid, op.description, op.location, op.skills, op.openingCount, op.projectDuration,
					op.lastDate, op.experience, op.managerName, op.managerEmail) < 1) {
				throw new OpportunityNotFoundException();
			} else {
				logger.info("Updating Opportunity details");
				return "Opportunity redefined Successfully";
			}
		} else {
			return "Non Authenticated User";
		}

	}

	@PostMapping("/addopp")
	@ResponseBody
	public String addOpportunity(@RequestHeader("authtoken") String id, @RequestHeader("authemail") String email,
			@RequestBody Opportunity opp) {
		if (dao.validateRequest(id, email) >= 1) {
			if (dao.add(opp.oid, opp.description, opp.location, opp.skills, opp.openingCount, opp.projectDuration,
					opp.lastDate, opp.experience, opp.managerName, opp.managerEmail) < 1) {
				throw new OpportunityNotFoundException();
			} else {
				logger.info("Adding Opportunity details");
				return "Opportunity created Successfully";
			}

		} else {
			return "Non Authenticated User";
		}

	}

	@DeleteMapping("/deleteopportunity/{oid}")
	@ResponseBody
	public String deleteOpportunity(@RequestHeader("authtoken") String id, @RequestHeader("authemail") String email,
			@PathVariable int oid) {
		if (dao.validateRequest(id, email) >= 1) {
			if (dao.delete(oid) < 1) {
				throw new OpportunityNotFoundException();
			} else {
				logger.info("Deleting Opportunity details");
				return "Opportunity Deleted Successfully";
			}
		} else {
			return "Non Authenticated User";
		}

	}

}
