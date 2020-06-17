package com.accolite.opportunities;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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

import com.accolite.opportunities.controller.OpportunityController;
import com.accolite.opportunities.entity.Opportunity;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OpportunityControllerTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	ObjectMapper om = new ObjectMapper();

	@Autowired
	private OpportunityController opc;

	public static Opportunity getOpportunityforTest() {
		Opportunity opp = new Opportunity();
		opp.setOid(6);
		opp.setDescription("AppDeveloper");
		opp.setLocation("chennai");
		opp.setSkills("Java");
		opp.setOpeningcount(2);
		opp.setProjectduration(12);
		opp.setLastdate("13-03-2020");
		opp.setExperience("2years");
		opp.setManagername("kumar");
		opp.setManageremail("kumaravel@gmail.com");
		return opp;
	}

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getOpportunityById_OpportunityIdValue_ReturnsSingleObject() throws Exception {
		mockMvc.perform(get("/getopportunityid/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(jsonPath("$.oid").value("1")).andExpect(jsonPath("$.description").value("SoftwareEngineer"))
				.andExpect(jsonPath("$.location").value("Chennai")).andExpect(jsonPath("$.skills").value("MongoDB"))
				.andExpect(jsonPath("$.openingcount").value(15)).andExpect(jsonPath("$.projectduration").value(19))
				.andExpect(jsonPath("$.lastdate").value("13-03-2019"))
				.andExpect(jsonPath("$.experience").value("3 years"))
				.andExpect(jsonPath("$.managername").value("vishnu"))
				.andExpect(jsonPath("$.manageremail").value("raul@gmail.com"));

	}

	@Test
	public void addOpportunity_SingleObject_ReturnsHttpStatus() throws Exception {
		Opportunity optest = getOpportunityforTest();

		String jsonRequest = om.writeValueAsString(optest);

		mockMvc.perform(post("/addopp").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());

	}

	@Test
	public void deleteOpportunity_OpportunityIdValue_ReturnsHttpStatus() throws Exception {
		mockMvc.perform(delete("/deleteopportunity/6").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void updateOpportunity_SingleObject_ReturnsHttpStatus() throws Exception {

		Opportunity opp = getOpportunityforTest();
		opp.setOid(2);

		String jsonRequest = om.writeValueAsString(opp);

		mockMvc.perform(put("/updatebyid").content(jsonRequest).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());

	}

	@Test
	public void validateUser_UserObjectValues_ReturnsString() {

		assertEquals("User Synced", opc.validateUser("102430502860166805172", "Jayaprakash", "Shanmugam",
				"jayaprakash.shanmugam@accoliteindia.com"));
	}

	@Test
	public void getAllOpportunity_ObjectListValues_ReturnsListSize() {

		assertEquals(6,
				opc.opportunityInformation("102430502860166805172", "jayaprakash.shanmugam@accoliteindia.com").size());
	}

	@Test
	public void deleteOpportunityNotFound_OpportunityIdValue_ReturnsHttpStatus() throws Exception {
		mockMvc.perform(delete("/deleteopportunity/999").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());

	}

	@Test
	public void getEmptyOpportunity_OpportunityIdValue_ReturnsSingleObject() throws Exception {
		mockMvc.perform(get("/getopportunityid/999").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isInternalServerError());
	}

}
