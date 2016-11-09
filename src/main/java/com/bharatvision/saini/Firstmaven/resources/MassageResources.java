package com.bharatvision.saini.Firstmaven.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.bharatvision.saini.Firstmaven.model.Massage;
import com.bharatvision.saini.Firstmaven.service.Service;

@Path("/massage")
public class MassageResources {
	
	Service massageService = new Service();

	/**
	 * GET method response for show all massage
	 * @return
	 */
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Massage> getReources(@QueryParam("year") int year,
			@QueryParam("start") int start,
			@QueryParam("size") int size){
		if(year>0){
			return massageService.getAllMassageForYear(year);
		}
		if(start>=0 && size>0){
			return massageService.getAllMessagePaginated(start, size);
		}
		return massageService.getAllMassage();
	}
	
	/**
	 * POST for add message
	 * @param massage
	 * @return
	 */
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addMessage(Massage massage, @Context UriInfo uriInfo) throws URISyntaxException{
		Massage newMessage =massageService.addMassage(massage);
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
				.entity(newMessage)
				.build();
		//return massageService.addMassage(massage);
	}
	
	/**
	 * PUT for update messasge
	 * @param id
	 * @param massage
	 * @return
	 */
	
	
	@PUT
	@Path("/{massageID}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Massage updateMessage(@PathParam("massageID") long id, Massage massage){
		massage.setId(id);
		return massageService.updateMassage(massage);
	}	
	
	@DELETE
	@Path("/{massageID}")
	public void deleteMessage(@PathParam("massageID") long id){
		massageService.removeMassage(id);
	}
	
	/**
	 * GET for get particular Id message
	 * @param id
	 * @return
	 */
	@GET
	@Path("/{massageID}")
	@Produces(MediaType.APPLICATION_XML)
	public Massage getMassageByID(@PathParam("massageID") long id){
		return massageService.getMassage(id);
	}

}
	

