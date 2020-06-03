package com.example.examplerest;


import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;




@Repository
public class CustomerDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	
	private static final String SQL = "select * from opportunity;";
	
	
	public List<Customer> getopportunities() {

        List<Customer> customers = new ArrayList<Customer>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);

        for (Map<String, Object> row : rows) 
        {
             Customer customer = new Customer();
             
             customer.setOid((Integer)row.get("oid"));
             customer.setDescription((String)row.get("description"));
             customer.setLocation((String)row.get("location"));
             customer.setSkills((String)row.get("skills"));
             customer.setOpeningcount((Integer)row.get("openingcount"));
             customer.setProjectduration((Integer)row.get("projectduration"));
             customer.setLastdate((String)row.get("lastdate"));
             customer.setExperience((String)row.get("experience"));
             customer.setManagername((String)row.get("managername"));
             customer.setManageremail((String)row.get("manageremail"));
             
             
             customers.add(customer);
         }

       return customers;
   }
	
	
	 public Customer getid(int id) {
	      String SQL = "select * from opportunity where oid = ?";
	      Customer user = jdbcTemplate.queryForObject(
	         SQL, new Object[]{id}, new CustomerRowMapper());
	      
	      return user;
	   }
	
	public void update(int oid, String description){
	      String SQL = "update opportunity set description = ? where oid = ?";
	      jdbcTemplate.update(SQL, description, oid);
	      
	   }
	
	public int adduser(String firstname,String lastname,String email){
        String query = "insert into googleusers values(?,?,?);";
        return jdbcTemplate.update(query,firstname,lastname,email);
    }

	
	
	public int add(int oid, String description, String location, String skills, int openingcount,int projectduration,String lastdate, String experience, String managername, String manageremail){
        String query = "insert into opportunity values(?,?,?,?,?,?,?,?,?,?);";
        return jdbcTemplate.update(query,oid,description,location,skills,openingcount,projectduration,lastdate,experience,managername,manageremail);
    }
	
	public int delete(int id){
        String query = "delete from opportunity where oid=?;";
        return jdbcTemplate.update(query,id);
    }
	 
	 	}	
	


	

