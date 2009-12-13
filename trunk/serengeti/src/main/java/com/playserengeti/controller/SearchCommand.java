package com.playserengeti.controller;

/**
 * The command class for searching the database. Only holds the query.
 * 
 * @author Chris
 * 
 */
public class SearchCommand {

	private String query;

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
}
