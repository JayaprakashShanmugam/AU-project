package com.example.examplerest;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class controller {
	
	@Autowired
    public CustomerDao dao; 
	
	@CrossOrigin("*")
	@GetMapping("/getoppurtunities")
    public List<Customer> customerInformation() {
	
        List<Customer> customers = dao.getopportunities(); 
       
        return customers;
    }
	
	

	@RequestMapping("/getopportunityid")
    @ResponseBody
    public Customer getid(@RequestParam("oid") int oid){
        return dao.getid(oid);
    }
	
	@CrossOrigin("*")
	@GetMapping("/adduser/{firstname}/{lastname}/{email}")
    @ResponseBody
    public String addUser(@PathVariable String firstname,@PathVariable String lastname,@PathVariable String email ){
        dao.adduser(firstname,lastname,email);
        return "user details was stored Successfully";
    }
	
	
	
	
	@RequestMapping("/updatebyid")
    @ResponseBody
    public String updateopportunity(@RequestParam("oid") int oid,@RequestParam("description") String description){
        dao.update(oid,description);
        return "Opportunity redefined Successfully";
    }
	
	
	
	@CrossOrigin("*")
	@PostMapping("/addopp")
    @ResponseBody
    public String addopportunity(@RequestBody Customer opp){
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

	
	


