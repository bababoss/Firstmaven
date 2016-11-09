package com.bharatvision.saini.Firstmaven.service;



import java.util.Date;

import com.bharatvision.saini.Firstmaven.Mydatabase.Mydatabase;
import com.bharatvision.saini.Firstmaven.model.GeoData;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

public class GeoDataService {
	
	Mydatabase myDBCollection = new Mydatabase();
	
	GeoData geodata = new GeoData();
	DBCollection coll;
	
	public String insertData(GeoData geodata){

		try{
            
			geodata.setCreated(new Date());
			BasicDBObject doc = new BasicDBObject("user_id", geodata.getUser_id())
			        .append("device_id", geodata.getDevice_id())
			        .append("latitude", geodata.getLatitude())
			        .append("longitude", geodata.getLongitude())
			        .append("created",geodata.getCreated());
	
			
			coll = myDBCollection.dbconnect();
			
			System.out.println("DataService done");
			coll.insert(doc);
			System.out.println("Data iinserted");
			return "Data is inerted";
		}catch(Exception e){
			e.printStackTrace();
			return "data base is not conneted";
		}
		
	}

}
