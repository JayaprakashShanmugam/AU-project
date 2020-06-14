package com.accolite.opportunities.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accolite.opportunities.entity.Opportunity;

public class OpportunityRowMapper implements RowMapper<Opportunity> {

	public Opportunity mapRow(ResultSet rs, int rowNum) throws SQLException {
		Opportunity user = new Opportunity();
		user.setOid(rs.getInt("oid"));
		user.setDescription(rs.getString("description"));
		user.setLocation(rs.getString("location"));
		user.setSkills(rs.getString("skills"));
		user.setOpeningcount(rs.getInt("openingcount"));
		user.setProjectduration(rs.getInt("projectduration"));
		user.setLastdate(rs.getString("lastdate"));
		user.setExperience(rs.getString("experience"));
		user.setManagername(rs.getString("managername"));
		user.setManageremail(rs.getString("manageremail"));

		return user;
	}

}
