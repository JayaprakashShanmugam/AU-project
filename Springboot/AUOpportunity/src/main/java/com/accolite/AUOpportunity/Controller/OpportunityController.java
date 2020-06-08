package com.accolite.AUOpportunity.Controller;


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

import com.accolite.AUOpportunity.exceptionhandler.OpportunityNotFoundException;
import com.accolite.AUOpportunity.exceptionhandler.OpportunityServiceErrorException;
import com.accolite.AUOpportunity.model.Opportunity;
import com.accolite.AUOpportunity.repository.OpportunityDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@RestController
public class OpportunityController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@Autowired
    public OpportunityDao dao; 
	
	boolean auth = true;
	
	@GetMapping("/getoppurtunities")
    public List<Opportunity> OpportunityInformation() {
		if(auth) {
			
			logger.info("Getting Opportunity details");
	        List<Opportunity> opportunities = dao.getopportunities(); 
	       
	        return opportunities;
		}
		else
		{
			return null;
		}
		
    }
	
	
	
	
	@GetMapping("/getopportunityid/{oid}")
	@ResponseBody
    public Opportunity getid(@PathVariable int oid){
		if(auth) {
			Opportunity getbyid; 
			try {
				
			getbyid = dao.getid(oid);
			}
			catch(EmptyResultDataAccessException e)
			{
				throw new OpportunityServiceErrorException();
			}
			
			return getbyid;	
		}
		else
		{
			return null;
		}
		    }
	
	
	@GetMapping("/validateuser/{firstname}/{lastname}/{email}")
    @ResponseBody
    public String ValidateUser(@RequestHeader("Authorization") String id,@PathVariable String firstname,@PathVariable String lastname,@PathVariable String email ){
		    logger.info("Authenticating User details");
        	if(dao.updateuser(id,firstname,lastname,email)>=1)
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
	 public String updateopportunity(@RequestBody Opportunity op){
		if(auth) {
			if(dao.update(op.oid,op.description,op.location,op.skills,op.openingcount,op.projectduration,op.lastdate,op.experience,op.managername,op.manageremail)<1)
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
    public String addopportunity(@RequestBody Opportunity opp){
		if(auth) {
			if( dao.add(opp.oid,opp.description,opp.location,opp.skills,opp.openingcount,opp.projectduration,opp.lastdate,opp.experience,opp.managername,opp.manageremail)<1)
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
    public String deleteopportunity(@PathVariable int oid){
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

