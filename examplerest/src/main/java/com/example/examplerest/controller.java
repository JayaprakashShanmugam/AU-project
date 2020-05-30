package com.example.examplerest;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class controller {
	
	@Autowired
    public CustomerDao dao; 
	
	@RequestMapping("/getusers")
    public List<Customer> customerInformation() {
	
        List<Customer> customers = dao.getdetails(); 
       
        return customers;
    }
	
	

	@RequestMapping("/getuserid")
    @ResponseBody
    public Customer getid(@RequestParam("id") int id){
        return dao.getuserid(id);
    }
	
	
	
	
	
	@RequestMapping("/update")
    @ResponseBody
    public String updateuser(@RequestParam("id") int id,@RequestParam("name") String name){
        dao.update(id,name);
        return "User Updated Successfully";
    }
	
	@RequestMapping("/add")
    @ResponseBody
    public String adduser(@RequestParam("id") int id,@RequestParam("name") String name){
        if(dao.add(id,name) >= 1){
            return "User Added Successfully";
        }else{
            return "Something went wrong !";
        }
    }
	
	
	
	
	@RequestMapping("/delete")
    @ResponseBody
    public String deteteuser(@RequestParam("id") int id){
        if(dao.delete(id) >= 1){
            return "User Deleted Successfully";
        }else{
            return "Something went wrong !";
        }
    }
	

	
	
	
	
	
	 
	}

	
	


