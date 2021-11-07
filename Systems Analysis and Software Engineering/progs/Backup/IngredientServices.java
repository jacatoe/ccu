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

	public Response createIngredient(MultivaluedMap<String,String> formFields) throws SQLException, ClassNotFoundException 
	{

		System.out.println("In create Ingredient");

		String newName = formFields.getFirst("name");

		String newCategory = formFields.getFirst("category");
	
		String connectStr="jdbc:mysql://localhost:3306/fooddb";
		String username="root";
		String password="csci330pass";
		String driver="com.mysql.jdbc.Driver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(connectStr, username, password);

		PreparedStatement createStmt = con.prepareStatement("INSERT INTO ingredient (name, category) VALUES(?,?)");
		createStmt.setString(1,newName);
		createStmt.setString(2,newCategory);

		int res = createStmt.executeUpdate();

		System.out.println("Result is: "+res);

		if(res==1) 
		{
			PreparedStatement retrieveStmt = con.prepareStatement("SELECT * FROM ingredient WHERE name=? AND category=?");
			retrieveStmt.setString(1, newName);
			retrieveStmt.setString(2, newCategory);
			ResultSet rs = retrieveStmt.executeQuery();

			String result ="";
			int count=0;
			int MAX=100;
			Ingredient[] ingArray = new Ingredient[MAX];
		
			while(rs.next())
			{
		
				int theId = rs.getInt("id");
				String theName = rs.getString("name");
				String theCategory = rs.getString("category");
			
				Ingredient ing = new Ingredient(theId, theName, theCategory);
				System.out.println(ing);
				ingArray[count] = ing;
				count++;
			}

			ingArray = Arrays.copyOf(ingArray,count);

			Gson theGsonObj = new Gson();
		
			result = theGsonObj.toJson(ingArray);
			System.out.println("the Json: \n"+result);
			//return result;

			
			ResponseBuilder rb = Response.ok(result, MediaType.TEXT_PLAIN);
			rb.status(201);
			return rb.build();
			
		
		}

		else
		{
			Gson theGsonObj = new Gson();

			Ingredient[] blankIngArray = new Ingredient[1];
			blankIngArray[0] = new Ingredient(0, "none", "none");
			String blankResult= theGsonObj.toJson(blankIngArray);
			//return blankResult;

			
			return Response.status(700).build();
			
		
		}

	}


	@Path ( "/ingredients" )
	@GET
	@Produces ( "text/plain" )
	public String getIngredients() throws SQLException, ClassNotFoundException {
	
		String connectStr="jdbc:mysql://localhost:3306/fooddb";
		String username="root";
		String password="csci330pass";
		String driver="com.mysql.jdbc.Driver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(connectStr, username, password);
		PreparedStatement pstmt = con.prepareStatement( "SELECT id, name, category FROM ingredient" );
		ResultSet rs = pstmt.executeQuery();
		Ingredient[] ingarray = new Ingredient[5];
		int i = 0;
		while(rs.next()) 
		{
		
			int theId = rs.getInt("id");
			String theName = rs.getString("name");
			String theCategory = rs.getString("category");

			Ingredient ing = new Ingredient(theId, theName, theCategory);
			
			ingarray[i] = ing;
	
			i++;
		}
	
		Gson g = new Gson();

		String result = g.toJson(ingarray);
		
		return result; 
	}


	@Path ( "/ingredients/{id}" )
	@GET
	@Produces ( "text/plain" )
	public String getIngredientById( @PathParam ( "id" ) String theId) throws NamingException, SQLException, ClassNotFoundException {
		int intId = 0;
		String theIng = "";
		//Since url parameters are always strings, convert to int
		try {
			intId = Integer.parseInt(theId);
		} catch (NumberFormatException ne) {
		intId = 1;
		}
		//retrieve ingredient from database
		String connectStr="jdbc:mysql://localhost:3306/fooddb";
		String username="root";
		String password="csci330pass";
		String driver="com.mysql.jdbc.Driver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(
			connectStr, username, password);
		PreparedStatement pstmt = con.prepareStatement( "SELECT id, name, category FROM ingredient WHERE id=?");
		pstmt.setString(1, theId);
		ResultSet rs = pstmt.executeQuery();
		Ingredient[] ingarray = new Ingredient[1];
		int i=0;
		while(rs.next()) 
		{
			int theId2 = rs.getInt( "id" );
			String theName2 = rs.getString( "name" );
			String theCategory2 = rs.getString( "category" );
		
			Ingredient ing = new Ingredient(theId2, theName2, theCategory2);
				
			ingarray[i] = ing;
		
			i++;
		}
	
		Gson g2 = new Gson();

		String result = g2.toJson(ingarray);
	
		return result; 
	}


	@Path ( "/ingredients/ingredient" )
	@GET
	@Produces ( "text/plain" )
	public String getIngredientByName( @QueryParam ( "name" ) String theName) throws SQLException, ClassNotFoundException {
		String theIng= "" ;
		//retrieve ingredient from database
		String connectStr="jdbc:mysql://localhost:3306/fooddb";
		String username="root";
		String password="csci330pass";
		String driver="com.mysql.jdbc.Driver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(
			connectStr, username, password);
		PreparedStatement pstmt = con.prepareStatement("SELECT id, name, category FROM ingredient WHERE name=?");
		pstmt.setString(1, theName);
		ResultSet rs = pstmt.executeQuery();
		Ingredient[] ingarray = new Ingredient[1];
		int i=0;
		while(rs.next()) 
		{
			int theId3 = rs.getInt( "id" );
			String theName3 = rs.getString( "name" );
			String theCategory3 = rs.getString( "category" );
		
			Ingredient ing = new Ingredient(theId3, theName3, theCategory3);
			
			ingarray[i] = ing;
		
			i++;
		}

		Gson g3 = new Gson();

		String result = g3.toJson(ingarray);
	
		return result; 
	}	

}