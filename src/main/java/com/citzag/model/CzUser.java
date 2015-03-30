package com.citzag.model;

public class CzUser {
	
	private String username;
	private String profile_picture;
	private String id;
	private String full_name;
	
	
	
	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	/**
	* 
	* @return
	* The username
	*/
	public String getUsername() {
	return username;
	}

	/**
	* 
	* @param username
	* The username
	*/
	public void setUsername(String username) {
	this.username = username;
	}

	
	
	
	public String getProfile_picture() {
		return profile_picture;
	}

	public void setProfile_picture(String profile_picture) {
		this.profile_picture = profile_picture;
	}

	
	/**
	* 
	* @return
	* The id
	*/
	public String getId() {
	return id;
	}

	/**
	* 
	* @param id
	* The id
	*/
	public void setId(String id) {
	this.id = id;
	}


}
