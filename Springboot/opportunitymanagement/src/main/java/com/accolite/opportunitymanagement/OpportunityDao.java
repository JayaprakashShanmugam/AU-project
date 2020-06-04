package com.accolite.opportunitymanagment;


import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;




@Repository
public class OpportunityDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	
	private static final String SQL = "select * from opportunity;";
	
	
	public List<opportunity> getopportunities() {

        List<Opportunity> opportunities = new ArrayList<Opportunity>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);

        for (Map<String, Object> row : rows) 
        {
             Opportunity opportunity = new Opportunity();
             
             opportunity.setOid((Integer)row.get("oid"));
             opportunity.setDescription((String)row.get("description"));
             opportunity.setLocation((String)row.get("location"));
             opportunity.setSkills((String)row.get("skills"));
             opportunity.setOpeningcount((Integer)row.get("openingcount"));
             opportunity.setProjectduration((Integer)row.get("projectduration"));
             opportunity.setLastdate((String)row.get("lastdate"));
             opportunity.setExperience((String)row.get("experience"));
             opportunity.setManagername((String)row.get("managername"));
             opportunity.setManageremail((String)row.get("manageremail"));
             
             
             Opportunities.add(opportunity);
         }

       return Opportunities;
   }
	
	
	 public Opportunity getid(int id) {
	      String SQL = "select * from opportunity where oid = ?";
	      Opportunity user = jdbcTemplate.queryForObject(
	         SQL, new Object[]{id}, new opportunityRowMapper());
	      // Rowmapper object will be called
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
	


	

