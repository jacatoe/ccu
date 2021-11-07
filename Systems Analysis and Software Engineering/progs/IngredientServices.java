package com.cs330;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.sql.DataSource;
import javax.naming.NamingException;
import javax.naming.Context;
import javax.naming.InitialContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import java.util.Arrays;

import com.google.gson.Gson;

@Path ( "ws2" )
public class IngredientServices 
{

	@Path("/ingredients")
	@POST
	@Produces("text/plain")
	@Consumes("application/x-www-form-urlencoded")

	public Response createIngredient(MultivaluedMap<String,String> formFields) throws NamingException, SQLException, ClassNotFoundException 
	{
		
		IngredientFacade iFacade = IngredientFacade.getInstance();

		String newName = formFields.getFirst("name");

		String newCategory = formFields.getFirst("category");

		iFacade.createIngredient(<newName,newCategory>);

		Ingredient[] resultArray = iFacade.getIngredients();

		if(resultArray != null)
		{
			Gson theGsonObj = new Gson();
			String result = theGsonObj.toJson(resultArray);

			ResponseBuilder rb = Response.ok(result, MediaType.TEXT_PLAIN);

			rb.status(200);

			return rb.build();
		}
		else
		{
			return Response.status(700).build();
		}

	}


	@Path ( "/ingredients" )
	@GET
	@Produces ( "text/plain" )
	public Response  getIngredients() throws NamingException, SQLException, ClassNotFoundException {
	
		IngredientFacade iFacade = IngredientFacade.getInstance();

		Ingredient[] resultArray = iFacade.getIngredients();

		if(resultArray != null)
		{
			Gson theGsonObj = new Gson();
			String result = theGsonObj.toJson(resultArray);

			ResponseBuilder rb = Response.ok(result, MediaType.TEXT_PLAIN);

			rb.status(200);

			return rb.build();
		}
		else
		{
			return Response.status(700).build();
		}
	}


	@Path ( "/ingredients/{id}" )
	@GET
	@Produces ( "text/plain" )
	public Response getIngredientById( @PathParam ( "id" ) String theId) throws NamingException, SQLException, ClassNotFoundException {
		
		IngredientFacade iFacade = IngredientFacade.getInstance();

		int intId = 0;
		
		try
		{
			intId = Integer.parseInt(theId);
		}catch(NumberFormatException ne) {
			intId = 1;
		}

		Ingredient[] resultArray = iFacade.getIngredientById(intId);

		if(resultArray != null)
		{
			Gson theGsonObj = new Gson();
			String result = theGsonObj.toJson(resultArray);

			ResponseBuilder rb = Response.ok(result, MediaType.TEXT_PLAIN);

			rb.status(200);

			return rb.build();
		}
		else
		{
			return Response.status(700).build();
		}
	}


	@Path ( "/ingredients/ingredient" )
	@GET
	@Produces ( "text/plain" )
	public Response getIngredientByName( @QueryParam ( "name" ) String theName) throws NamingException, SQLException, ClassNotFoundException {
		
		IngredientFacade iFacade = IngredientFacade.getInstance();

		Ingredient[] resultArray = iFacade.getIngredientByName(theName);

		if(resultArray != null)
		{
			Gson theGsonObj = new Gson();
			String result = theGsonObj.toJson(resultArray);

			ResponseBuilder rb = Response.ok(result, MediaType.TEXT_PLAIN);

			rb.status(200);

			return rb.build();
		}
		else
		{
			return Response.status(700).build();
		}
	}	

}