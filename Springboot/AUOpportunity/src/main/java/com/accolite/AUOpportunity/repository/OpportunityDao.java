package com.accolite.AUOpportunity.repository;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import com.accolite.AUOpportunity.model.Opportunity;
import com.accolite.AUOpportunity.rowmapper.OpportunityRowMapper;



@Repository
public class OpportunityDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	
	private static final String SQL = "select * from opportunity;";
	
	
	public List<Opportunity> getopportunities() {

        List<Opportunity> Opportunities = new ArrayList<Opportunity>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);

        for (Map<String, Object> row : rows) 
        {
             Opportunity user = new Opportunity();
             
             user.setOid((Integer)row.get("oid"));
             user.setDescription((String)row.get("description"));
             user.setLocation((String)row.get("location"));
             user.setSkills((String)row.get("skills"));
             user.setOpeningcount((Integer)row.get("openingcount"));
             user.setProjectduration((Integer)row.get("projectduration"));
             user.setLastdate((String)row.get("lastdate"));
             user.setExperience((String)row.get("experience"));
             user.setManagername((String)row.get("managername"));
             user.setManageremail((String)row.get("manageremail"));
             
             
             Opportunities.add(user);
         }

       return Opportunities;
   }
	
	
	 public Opportunity getid(int id) {
	      String SQL = "select * from opportunity where oid = ?";
	      Opportunity user = jdbcTemplate.queryForObject(
	         SQL, new Object[]{id}, new OpportunityRowMapper());
	      return user;
	     
	      
	   }
	 
	
	 
	
	public int update(int oid, String description, String location, String skills, int openingcount,int projectduration,String lastdate, String experience, String managername, String manageremail){
	      String SQL = "update opportunity set description = ?, location=?, skills=?, openingcount=?, projectduration=?, lastdate=?, experience=?, managername=?, manageremail=? where oid = ?";
	      return jdbcTemplate.update(SQL,description,location,skills,openingcount,projectduration,lastdate,experience,managername,manageremail, oid);
	      
	   }
	
	public int updateuser(String id,String firstname,String lastname,String email){
        
		
		String query = "update googleusers set firstname=?, lastname=?,email=? where id=?";
        return jdbcTemplate.update(query,firstname,lastname,email,id);
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
	


