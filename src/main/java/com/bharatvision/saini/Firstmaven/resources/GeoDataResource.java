package com.bharatvision.saini.Firstmaven.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bharatvision.saini.Firstmaven.model.GeoData;
import com.bharatvision.saini.Firstmaven.service.GeoDataService;

@Path("/tracker")
public class GeoDataResource {

	GeoDataService geodataservice = new GeoDataService();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertData(GeoData geodata){
		return geodataservice.insertData(geodata);
	}
	
}
