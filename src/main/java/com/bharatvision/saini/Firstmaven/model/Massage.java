package com.bharatvision.saini.Firstmaven.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Massage {
	
	private long id;
	private String massage;
	private Date created;
	private String auther;
	
	public Massage(){
		
	}
	public Massage(long id, String massage, String auther){
		this.id=id;
		this.massage=massage;
		this.created= new Date();
		this.auther=auther;
		
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMassage() {
		return massage;
	}
	public void setMassage(String massage) {
		this.massage = massage;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuther() {
		return auther;
	}
	public void setAuther(String auther) {
		this.auther = auther;
	}
}
