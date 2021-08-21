package com.cs330;

public class Ingredient 
{
	private int id;
	private String name;
	private String category;

	public Ingredient()
	{
		id = 0;
		name = "";
		category = "";
	}

	public Ingredient(int id, String name, String category)
	{
		this.id = id;
		this.name = name;
		this.category = category;
	}

	public Ingredient(String name, String category)
	{
		id = 0;
		this.name = name;
		this.category = category;
	}

	public String toString()
	{
		return id + ":" + " " + name + "(" + category + ")";
	}
}