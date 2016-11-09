package com.bharatvision.saini.Firstmaven.Mydatabase;

import java.util.HashMap;
import java.util.Map;

import com.bharatvision.saini.Firstmaven.model.Massage;
import com.bharatvision.saini.Firstmaven.model.Profile;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;



public class Mydatabase {

	private static Map<Long, Massage> massage = new HashMap<>();
	private static Map<Long, Profile> profile = new HashMap<>();
    

	
	public static Map<Long,Massage> getMassage(){
		return massage;
	}
	
	public static Map<Long,Profile> getProfile(){
		return profile;
		
	}
	
	/**
	 * Method for mongodb database connection
	 * @return
	 */
	public DBCollection dbconnect(){

		try{
			MongoClient mongoClient = new MongoClient("35.160.185.156");
			DB db = mongoClient.getDB("si2chipdb");
			System.out.println("Data base is connected");
			DBCollection collectionObj = db.getCollection("GeoDataCollection");
			mongoClient.setWriteConcern(WriteConcern.JOURNALED);
			
			return collectionObj;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Database connection faild");
			return null;
		}
	}
	
	
}
