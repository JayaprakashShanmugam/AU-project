package com.accolite.opportunities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.accolite.opportunities.entity.Opportunity;
import com.accolite.opportunities.service.OpportunityService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OpportunityServiceTest {

	@Autowired
	OpportunityService service;

	@Test
	public void addOpportunity_SingleObject_ReturnsString() {
		Opportunity opp = OpportunityControllerTests.getOpportunityforTest();
		opp.setOid(9);

		String status = service.addOpportunityService(opp);

		assertNotNull(opp);
		assertEquals("Opportunity created Successfully", status);
	}

	@Test
	public void updateOpportunity_SingleObject_ReturnsString() {
		Opportunity opp = OpportunityControllerTests.getOpportunityforTest();
		opp.setOid(2);
		String status = service.updateOpportunityService(opp);

		assertNotNull(opp);
		assertEquals("Opportunity redefined Successfully", status);
	}

	@Test
	public void deleteOpportunity_OpportunityIdValue_ReturnsString() {

		String status = service.deleteOpportunityService(6);

		assertEquals("Opportunity Deleted Successfully", status);
	}

	@Test
	public void getAllOpportunity_ObjectList_ReturnsListSize() {
		List<Opportunity> allOpportunities = service.opportunityInformationService();

		assertNotNull(allOpportunities);
		assertEquals(6, allOpportunities.size());
	}

}
