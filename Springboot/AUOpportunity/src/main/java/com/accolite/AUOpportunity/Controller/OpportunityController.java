package com.accolite.AUOpportunity.Controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.AUOpportunity.model.Opportunity;
import com.accolite.AUOpportunity.repository.OpportunityDao;




@RestController
public class OpportunityController {
	
	@Autowired
    public OpportunityDao dao; 
	
	@CrossOrigin("*")
	@GetMapping("/getoppurtunities")
    public List<Opportunity> customerInformation() {
	
        List<Opportunity> opportunities = dao.getopportunities(); 
       
        return opportunities;
    }
	
	
	@CrossOrigin("*")
	@GetMapping("/getopportunityid/{oid}")
	@ResponseBody
    public Opportunity getid(@PathVariable int oid){
        return dao.getid(oid);
    }
	
	@CrossOrigin("*")
	@GetMapping("/adduser/{firstname}/{lastname}/{email}")
    @ResponseBody
    public String addUser(@PathVariable String firstname,@PathVariable String lastname,@PathVariable String email ){
       
        	dao.adduser(firstname,lastname,email,new Timestamp(System.currentTimeMillis()));
            return "User Added Successfully";

    }

	
	@CrossOrigin("*")
	@PutMapping("/updatebyid")
	@ResponseBody
	 public String updateopportunity(@RequestBody Opportunity op){
        dao.update(op.oid,op.description,op.location,op.skills,op.openingcount,op.projectduration,op.lastdate,op.experience,op.managername,op.manageremail);
        return "Opportunity redefined Successfully";
    }
	
	
	
	@CrossOrigin("*")
	@PostMapping("/addopp")
    @ResponseBody
    public String addopportunity(@RequestBody Opportunity opp){
        dao.add(opp.oid,opp.description,opp.location,opp.skills,opp.openingcount,opp.projectduration,opp.lastdate,opp.experience,opp.managername,opp.manageremail);
        return "Opportunity created Successfully";
    }
	
	
	
	@CrossOrigin("*")
	@DeleteMapping("/deleteopportunity/{oid}")
    @ResponseBody
    public String deleteopportunity(@PathVariable int oid){
        if(dao.delete(oid) >= 1){
            return "Opportunity Deleted Successfully";
        }else{
            return "Something went wrong !";
        }
    }
	 
}

