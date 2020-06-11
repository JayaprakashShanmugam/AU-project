package com.accolite.opportunities.opportunities;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import controller.OpportunityController;
import entities.Opportunity;
import com.fasterxml.jackson.databind.ObjectMapper;



@RunWith(SpringRunner.class)
@SpringBootTest
public class OpportunityControllerTests {
	
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	ObjectMapper om = new ObjectMapper();

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	
	
	@Test
	public void getOpportunityTest() throws Exception {
		       mockMvc.perform(get("/getopportunityid/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.oid").value("1")).andExpect(jsonPath("$.description").value("SoftwareEngineer"))
				.andExpect(jsonPath("$.location").value("Chennai")).andExpect(jsonPath("$.skills").value("MongoDB"))
				.andExpect(jsonPath("$.openingcount").value(15)).andExpect(jsonPath("$.projectduration").value(19))
				.andExpect(jsonPath("$.lastdate").value("13-03-2019")).andExpect(jsonPath("$.experience").value("3 years"))
				.andExpect(jsonPath("$.managername").value("vishnu")).andExpect(jsonPath("$.manageremail").value("raul@gmail.com"));
				
				

	}


	

	@Test
	public void addOpportunityTest() throws Exception
	{
		
		Opportunity opp = new Opportunity();
		opp.setOid(1029);
		opp.setDescription("AppDeveloper");
		opp.setLocation("chennai");
		opp.setSkills("Java");
		opp.setOpeningcount(2);
		opp.setProjectduration(12);
		opp.setLastdate("13-03-2020");
		opp.setExperience("2years");
		opp.setManagername("kumar");
		opp.setManageremail("kumaravel@gmail.com");
		
		
      String jsonRequest = om.writeValueAsString(opp);
		
		
	mockMvc.perform(post("/addopp").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
	
	
	}
	
	

	
	@Test
	public void deleteOpportunityTest() throws Exception {
	       mockMvc.perform(delete("/deleteopportunity/1025").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
			
}
	
	
	@Test
	public void updateOpportunityTest() throws Exception
	{
		
		Opportunity opp = new Opportunity();
		opp.setOid(2);
		opp.setDescription("AppDeveloper");
		opp.setLocation("chennai");
		opp.setSkills("Software Developer");
		opp.setOpeningcount(2);
		opp.setProjectduration(12);
		opp.setLastdate("13-03-2020");
		opp.setExperience("2years");
		opp.setManagername("kumar");
		opp.setManageremail("kumaravel@gmail.com");
		
		
      String jsonRequest = om.writeValueAsString(opp);
		
		
	mockMvc.perform(put("/updatebyid").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
	
	
	}
	
	
	@Autowired
	private OpportunityController opc;
	

	
	@Test
	public void validateUserTest()
	{
		
	    assertEquals("Authenticated User",opc.validateUser("102430502860166805172","Jayaprakash","Shanmugam","jayaprakash.shanmugam@accoliteindia.com"));
	}
	
	
	@Test
	public void getAllOpportunityTest()
	{
		
	    assertEquals(6,opc.opportunityInformation("testid","testemail").size());
	}
	
	
	
	
	
	
	
    
}
