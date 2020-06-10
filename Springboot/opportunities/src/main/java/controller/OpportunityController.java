package controller;


import java.util.List;



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

import entities.Opportunity;
import exception.OpportunityNotFoundException;
import exception.OpportunityServiceErrorException;
import repositories.OpportunityDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
public class OpportunityController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@Autowired
    public OpportunityDao dao; 
	
	boolean auth = true;
	
	@GetMapping("/getoppurtunities")
    public List<Opportunity> opportunityInformation() {
		if(auth) {
			
			logger.info("Getting Opportunity details");
	        List<Opportunity> opportunities = dao.getOpportunities(); 
	       
	        return opportunities;
		}
		else
		{
			return null;
		}
		
    }
	
	
	
	
	@GetMapping("/getopportunityid/{oid}")
	@ResponseBody
    public Opportunity getId(@PathVariable int oid){
		if(auth) {
			Opportunity getId; 
			try {
				
			getId = dao.getId(oid);
			}
			catch(EmptyResultDataAccessException e)
			{
				throw new OpportunityServiceErrorException();
			}
			
			return getId;	
		}
		else
		{
			return null;
		}
		    }
	
	
	@GetMapping("/validateuser/{firstname}/{lastname}/{email}")
    @ResponseBody
    public String validateUser(@RequestHeader("Authorization") String id,@PathVariable String firstName,@PathVariable String lastName,@PathVariable String email ){
		    logger.info("Authenticating User details");
        	if(dao.updateUser(id,firstName,lastName,email)>=1)
        	{   
        		auth=true;
              return "Authenticated User";
        	}
        	else
        	{   
        		return "Non-Authenticated User";
        	}
		   

    }
	
		
	
	@PutMapping("/updatebyid")
	@ResponseBody
	 public String updateOpportunity(@RequestBody Opportunity op){
		if(auth) {
			if(dao.update(op.oid,op.description,op.location,op.skills,op.openingCount,op.projectDuration,op.lastDate,op.experience,op.managerName,op.managerEmail)<1)
			{
				throw new OpportunityNotFoundException();
			}
			else {
				logger.info("Updating Opportunity details");
	        return "Opportunity redefined Successfully";
			}
		}
		else
		{
			return "Non Authenticated User";
		}
		
    }
	
	
	
	
	@PostMapping("/addopp")
    @ResponseBody
    public String addOpportunity(@RequestBody Opportunity opp){
		if(auth) {
			if( dao.add(opp.oid,opp.description,opp.location,opp.skills,opp.openingCount,opp.projectDuration,opp.lastDate,opp.experience,opp.managerName,opp.managerEmail)<1)
			{
				throw new OpportunityNotFoundException();
			}
			else {
				logger.info("Adding Opportunity details");
				 return "Opportunity created Successfully";	
			}
	       
		}
		else
		{
			return "Non Authenticated User";
		}
		
    }
	
	
	

	@DeleteMapping("/deleteopportunity/{oid}")
    @ResponseBody
    public String deleteOpportunity(@PathVariable int oid){
        if(auth) {
        	if(dao.delete(oid)< 1){
            	throw new OpportunityNotFoundException();
            }else{
            	logger.info("Deleting Opportunity details");
            	return "Opportunity Deleted Successfully";
            }
        }
        else
        {
        	return "Non Authenticated User";
        }
		
    }
	 
}

