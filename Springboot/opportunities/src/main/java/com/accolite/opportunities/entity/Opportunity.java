package com.accolite.opportunities.entity;

public class Opportunity {

	public int oid;
	public String description;
	public String location;
	public String skills;
	public int openingCount;
	public int projectDuration;
	public String lastDate;
	public String experience;
	public String managerName;
	public String managerEmail;

	// google sign in

	public String firstName;
	public String lastName;
	public String email;
	public String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Opportunity() {
	}

	public Opportunity(int oid, String description, String location, String skills, int openingcount,
			int projectduration, String lastdate, String experience, String managername, String manageremail) {

	}

	public Opportunity(String id, String firstname, String lastname, String email) {

	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public int getOpeningcount() {
		return openingCount;
	}

	public void setOpeningcount(int openingCount) {
		this.openingCount = openingCount;
	}

	public int getProjectduration() {
		return projectDuration;
	}

	public void setProjectduration(int projectDuration) {
		this.projectDuration = projectDuration;
	}

	public String getLastdate() {
		return lastDate;
	}

	public void setLastdate(String date) {
		this.lastDate = date;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getManagername() {
		return managerName;
	}

	public void setManagername(String managerName) {
		this.managerName = managerName;
	}

	public String getManageremail() {
		return managerEmail;
	}

	public void setManageremail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

	public String getFirstname() {
		return firstName;
	}

	public void setFirstname(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastName;
	}

	public void setLastname(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
