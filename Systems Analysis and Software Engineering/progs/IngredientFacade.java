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

public class IngredientFacade
{
	private static IngredientFacade singleton;

	private IngredientDataAccess dao;

	private IngredientFacade() throws NamingException, SQLException
	{
		this.dao = IngredientDataAccess.getInstance();
	}

	public static IngredientFacade getInstance() throws NamingException, SQLException
	{
		if(singleton == null)
		{
			singleton = new IngredientFacade();
		}
				
		return singleton;
	}

	public Ingredient[] getIngredients() throws SQLException
	{
		Connection con = dao.getConnection();

		PreparedStatement stmt = con.prepareStatement("SELECT id, name, category FROM ingredient");
		ResultSet rs = stmt.executeQuery();

		Ingredient[] ingArray = new Ingredient[100];
		int count = 0;
		
		while(rs.next())
		{
			int theId2 = rs.getInt("id");
			String theName = rs.getString("name");
			String theCategory = rs.getString("category");
			Ingredient ing = new Ingredient(theId2, theName, theCategory);
			ingArray[count] = ing;
			count++;
		}

		if(count > 0)
		{
			ingArray = Arrays.copyOf(ingArray,count);
			
			return ingArray;
		}
		else
		{
			return null;
		}
	}
	
	public Ingredient[] getIngredientByName(String theName) throws SQLException, ClassNotFoundException
	{
		Connection con = dao.getConnection();

		PreparedStatement stmt = con.prepareStatement("SELECT id, name, category FROM ingredient WHERE name=?");
		stmt.setString(1, theName);
		ResultSet rs = stmt.executeQuery();

		Ingredient[] ingArray = new Ingredient[100];
		int count = 0;
		
		while(rs.next())
		{
			int theId2 = rs.getInt("id");
			String theName2 = rs.getString("name");
			String theCategory = rs.getString("category");
			Ingredient ing = new Ingredient(theId2, theName, theCategory);
			ingArray[count] = ing;
			count++;
		}

		if(count > 0)
		{
			ingArray = Arrays.copyOf(ingArray,count);
			
			return ingArray;
		}
		else
		{
			return null;
		}
	}
	
	public Ingredient[] getIngredientById(int theId) throws SQLException, ClassNotFoundException
	{
		Connection con = dao.getConnection();

		PreparedStatement stmt = con.prepareStatement("SELECT id, name, category FROM ingredient WHERE id=?");
		stmt.setInt(1, theId);
		ResultSet rs = stmt.executeQuery();

		Ingredient[] ingArray = new Ingredient[100];
		int count = 0;
		
		while(rs.next())
		{
			int theId2 = rs.getInt("id");
			String theName = rs.getString("name");
			String theCategory = rs.getString("category");
			Ingredient ing = new Ingredient(theId2, theName, theCategory);
			ingArray[count] = ing;
			count++;
		}

		if(count > 0)
		{
			ingArray = Arrays.copyOf(ingArray,count);
			
			return ingArray;
		}
		else
		{
			return null;
		}
	}

	public Ingredient[] createIngredient(Ingredient theIngredientToAdd) throws SQLException, ClassNotFoundException
	{
		Connection con = dao.getConnection();

		PreparedStatement stmt = con.prepareStatement("INSERT INTO ingredient (name, category) VALUES(?,?)");
		stmt.setString(1, newName);
		stmt.setString(2, newCategory);

		int res = stmt.executeUpdate();

		if(res==1) 
		{
			PreparedStatement stmt2 = con.prepareStatement("SELECT * FROM ingredient WHERE name=? AND category=?");
			stmt.setString(1, newName);
			stmt.setString(2, newCategory);
			ResultSet rs = stmt.executeQuery();

			Ingredient[] ingArray = new Ingredient[100];
			int count = 0;
		
			while(rs.next())
			{
		
				int theId2 = rs.getInt("id");
				String theName = rs.getString("name");
				String theCategory = rs.getString("category");
			
				Ingredient ing = new Ingredient(theId2, theName, theCategory);
				ingArray[count] = ing;
				count++;
			}

			ingArray = Arrays.copyOf(ingArray,count);

			return ingArray;
			
		
		}
		else
		{
			return null;
		}
	}
	
}