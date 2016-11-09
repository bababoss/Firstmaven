package com.bharatvision.saini.Firstmaven.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("injectdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public final class InjectDemoResouce {
	@GET
	@Path("annotation")
	public String getParamsUsingAnnatation(@MatrixParam("param") String matrixParam,
			                               @HeaderParam("authSession") String headers,
			                               @CookieParam("Cookie") String cookie){
		return "InjectionDEmo" + matrixParam+"Header"+headers+": Cookie" + cookie;
	}
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo,@Context HttpHeaders headers){
		
		String path= uriInfo.getAbsolutePath().toString();
		String cookies = headers.getCookies().toString();
		return "Path :" + path + "Cookies:" +cookies;
		
	}
	

}
