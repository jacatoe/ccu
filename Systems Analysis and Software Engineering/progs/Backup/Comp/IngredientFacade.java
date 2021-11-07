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
	}

	public Ingredient[] getIngredientByName(String theName) throws SQLException, ClassNotFoundException
	{
	}

	public Ingredient[] getIngredientById(int theId) throws SQLException, ClassNotFoundException
	{
	}

	public Ingredient[] createIngredient(Ingredient theIngredientToAdd) throws SQLException, ClassNotFoundException
	{
	}
}