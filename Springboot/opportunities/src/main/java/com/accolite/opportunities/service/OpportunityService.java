package com.accolite.opportunities.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.accolite.opportunities.entity.Opportunity;
import com.accolite.opportunities.exception.OpportunityNotFoundException;
import com.accolite.opportunities.exception.OpportunityServiceErrorException;
import com.accolite.opportunities.repository.OpportunityDao;

@Service
public class OpportunityService {

	@Autowired
	public OpportunityDao dao;

	public List<Opportunity> opportunityInformationService() {

		List<Opportunity> opportunities = dao.getOpportunities();

		return opportunities;

	}

	public Opportunity getIdService(int oid) {

		Opportunity getbyid;
		try {
			getbyid = dao.getid(oid);
		} catch (EmptyResultDataAccessException e) {
			throw new OpportunityServiceErrorException();
		}

		return getbyid;

	}

	public String validateUserService(String tokenid, String firstname, String lastname, String email) {

		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		if (dao.updateuser(tokenid, firstname, lastname, email, timestamp) >= 1) {

			return "User Synced";
		} else {
			return "User not Synced";
		}

	}

	public int validateRequestService(String idtoken, String email) {
		return dao.validateRequest(idtoken, email);
	}

	public String updateOpportunityService(Opportunity op) {

		if (dao.update(op.oid, op.description, op.location, op.skills, op.openingCount, op.projectDuration, op.lastDate,
				op.experience, op.managerName, op.managerEmail) < 1) {
			throw new OpportunityNotFoundException();
		} else {

			return "Opportunity redefined Successfully";
		}
	}

	public String addOpportunityService(Opportunity opp) {

		if (dao.add(opp.oid, opp.description, opp.location, opp.skills, opp.openingCount, opp.projectDuration,
				opp.lastDate, opp.experience, opp.managerName, opp.managerEmail) < 1) {
			throw new OpportunityNotFoundException();
		} else {

			return "Opportunity created Successfully";
		}
	}

	public String deleteOpportunityService(int oid) {

		if (dao.delete(oid) < 1) {
			throw new OpportunityNotFoundException();
		} else {

			return "Opportunity Deleted Successfully";
		}

	}

}
