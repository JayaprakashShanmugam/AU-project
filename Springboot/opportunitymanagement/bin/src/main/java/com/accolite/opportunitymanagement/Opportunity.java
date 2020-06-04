package com.accolite.opportunitymanagement;



public class Opportunity {

	 int oid;
     String description;
     String location;
     String skills;
     int openingcount;
     int projectduration;
     String lastdate;
     String experience;
     String managername;
     String manageremail;
     
     //google sign in
     
     String firstname;
     String lastname;
     String email;
     
    
     
    


    public Opportunity() {
    }



	public Opportunity(int oid, String description, String location, String skills, int openingcount,
			int projectduration, String lastdate, String experience, String managername, String manageremail) {
	
	}
	
	public Opportunity(String firstname,String lastname,String email ) {
		
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
		return openingcount;
	}



	public void setOpeningcount(int openingcount) {
		this.openingcount = openingcount;
	}



	public int getProjectduration() {
		return projectduration;
	}



	public void setProjectduration(int projectduration) {
		this.projectduration = projectduration;
	}



	public String getLastdate() {
		return lastdate;
	}



	public void setLastdate(String date) {
		this.lastdate = date;
	}



	public String getExperience() {
		return experience;
	}



	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getManagername() {
		return managername;
	}



	public void setManagername(String managername) {
		this.managername = managername;
	}



	public String getManageremail() {
		return manageremail;
	}



	public void setManageremail(String manageremail) {
		this.manageremail = manageremail;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	

	    

  
}

