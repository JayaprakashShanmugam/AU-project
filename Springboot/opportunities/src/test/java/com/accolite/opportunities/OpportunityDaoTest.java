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
import com.accolite.opportunities.repository.OpportunityDao;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OpportunityDaoTest {

	@Autowired
	OpportunityDao dao;

	@Test
	public void addOpportunity_SingleObject_ReturnsOne() {
		Opportunity opp = OpportunityControllerTests.getOpportunityforTest();

		int status = dao.add(opp.getOid(), opp.getDescription(), opp.getLocation(), opp.getSkills(),
				opp.getOpeningcount(), opp.getProjectduration(), opp.getLastdate(), opp.getExperience(),
				opp.getManagername(), opp.getManageremail());

		assertNotNull(opp);
		assertEquals(1, status);
	}

	@Test
	public void updateOpportunity_SingleObject_ReturnsOne() {
		Opportunity opp = OpportunityControllerTests.getOpportunityforTest();
		opp.setOid(2);
		int status = dao.update(opp.getOid(), opp.getDescription(), opp.getLocation(), opp.getSkills(),
				opp.getOpeningcount(), opp.getProjectduration(), opp.getLastdate(), opp.getExperience(),
				opp.getManagername(), opp.getManageremail());

		assertNotNull(opp);
		assertEquals(1, status);
	}

	@Test
	public void deleteOpportunity_OpportunityIdValue_ReturnsOne() {

		int status = dao.delete(105);

		assertEquals(1, status);
	}

	@Test
	public void getAllOpportunities_ObjectList_ReturnsListSize() {
		List<Opportunity> allOpportunities = dao.getOpportunities();

		assertNotNull(allOpportunities);
		assertEquals(5, allOpportunities.size());
	}

}
