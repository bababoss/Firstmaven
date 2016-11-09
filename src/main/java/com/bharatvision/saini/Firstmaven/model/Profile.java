package com.bharatvision.saini.Firstmaven.model;

import java.util.Date;

public class Profile {
	private long id;
	private String profilename;
	private String fristname;
	private String lastname;
	private Date created;
	
	public Profile(){}
	
	public Profile(long id,String profilename,String fristname,String lastname){
		
		this.id=id;
		this.profilename=profilename;
		this.fristname=fristname;
		this.lastname=lastname;
		this.created=new Date();
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProfilename() {
		return profilename;
	}

	public void setProfilename(String profilename) {
		this.profilename = profilename;
	}

	public String getFristname() {
		return fristname;
	}

	public void setFristname(String fristname) {
		this.fristname = fristname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	
	
}
