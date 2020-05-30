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
	
	
	private static final String SQL = "select * from userdetails;";
	
	
	public List<Customer> getdetails() {

        List<Customer> customers = new ArrayList<Customer>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(SQL);

        for (Map<String, Object> row : rows) 
        {
             Customer customer = new Customer();
             
             customer.setCustName((String)row.get("name"));
             customer.setCustNo((Integer)row.get("id"));
             
             
             
             customers.add(customer);
         }

       return customers;
   }
	
	
	 public Customer getuserid(int id) {
	      String SQL = "select * from userdetails where id = ?";
	      Customer user = jdbcTemplate.queryForObject(
	         SQL, new Object[]{id}, new CustomerRowMapper());
	      
	      return user;
	   }
	
	public void update(int id, String name){
	      String SQL = "update userdetails set name = ? where id = ?";
	      jdbcTemplate.update(SQL, name, id);
	      
	   }
	
	public int add(int id,String name){
        String query = "insert into userdetails values(?,?);";
        return jdbcTemplate.update(query,id,name);
    }
	
	public int delete(int id){
        String query = "delete from userdetails where id=?;";
        return jdbcTemplate.update(query,id);
    }
	 
	 	}	
	


	

