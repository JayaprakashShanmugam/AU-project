package com.accolite.opportunities.opportunities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import entities.Opportunity;
import repositories.OpportunityDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OpportunityDaoTest {
	
	@Autowired
    OpportunityDao dao;
    
    
	@Test
    public void getAllOpportunity() {
        List<Opportunity> allOpportunities = dao.getOpportunities();
 
        assertNotNull(allOpportunities);
        assertEquals(6, allOpportunities.size());
    }
	@Test
    public void addOpportunityTest() {
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
        int status = dao.add(opp.getOid(),opp.getDescription(),opp.getLocation(),opp.getSkills(),opp.getOpeningcount(),opp.getProjectduration(),opp.getLastdate(),opp.getExperience(),opp.getManagername(),opp.getManageremail());
 
        assertNotNull(opp);
        assertEquals(1, status);
    }

	@Test
    public void updateOpportunityTest() {
		Opportunity opp = new Opportunity();
		opp.setOid(2);
		opp.setDescription("AppDeveloper");
		opp.setLocation("chennai");
		opp.setSkills("Software Developer Test");
		opp.setOpeningcount(2);
		opp.setProjectduration(12);
		opp.setLastdate("13-03-2020");
		opp.setExperience("2years");
		opp.setManagername("kumar");
		opp.setManageremail("kumaravel@gmail.com");
        int status = dao.update(opp.getOid(),opp.getDescription(),opp.getLocation(),opp.getSkills(),opp.getOpeningcount(),opp.getProjectduration(),opp.getLastdate(),opp.getExperience(),opp.getManagername(),opp.getManageremail());
 
        assertNotNull(opp);
        assertEquals(1, status);
    }

    
	@Test
    public void deleteOpportunityTest() {
		
        int status = dao.delete(2);
 
        assertEquals(1, status);
    }
    
 
 
}
