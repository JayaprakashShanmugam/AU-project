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
	
	OpportunityControllerTests optest = new OpportunityControllerTests();
    
    
	@Test
    public void getAllOpportunity() {
        List<Opportunity> allOpportunities = dao.getOpportunities();
 
        assertNotNull(allOpportunities);
        assertEquals(7, allOpportunities.size());
    }
	@Test
    public void addOpportunityTest() {
		Opportunity opp = optest.getOpportunityforTest();
		
        int status = dao.add(opp.getOid(),opp.getDescription(),opp.getLocation(),opp.getSkills(),opp.getOpeningcount(),opp.getProjectduration(),opp.getLastdate(),opp.getExperience(),opp.getManagername(),opp.getManageremail());
 
        assertNotNull(opp);
        assertEquals(1, status);
    }

	@Test
    public void updateOpportunityTest() {
		Opportunity opp = optest.getOpportunityforTest();
		opp.setOid(2);
        int status = dao.update(opp.getOid(),opp.getDescription(),opp.getLocation(),opp.getSkills(),opp.getOpeningcount(),opp.getProjectduration(),opp.getLastdate(),opp.getExperience(),opp.getManagername(),opp.getManageremail());
 
        assertNotNull(opp);
        assertEquals(1, status);
    }

    
	@Test
    public void deleteOpportunityTest() {
		
        int status = dao.delete(105);
 
        assertEquals(1, status);
    }
    
 
 
}
