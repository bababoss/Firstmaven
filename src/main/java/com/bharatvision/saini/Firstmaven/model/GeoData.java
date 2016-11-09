package com.bharatvision.saini.Firstmaven.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GeoData {
	private String user_id;
	private String device_id;
	private String latitude;
	private String longitude;
	private Date created;
	
	public GeoData(){}
	
	public GeoData(String user_id,String device_id, String latitude, String longitude){
		this.user_id=user_id;
		this.device_id=device_id;
		this.latitude=latitude;
		this.longitude=longitude;
		this.created= new Date();
		
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getDevice_id() {
		return device_id;
	}

	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	
	
	

}
