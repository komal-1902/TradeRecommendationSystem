package com.recommendation.model;

public class UserModel {
	String username, password;
	SectorType sector;
	String symbol;
	
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	UserModel() {
		super();
	}
	
	/*
	private static UserModel user;
	
	public static UserModel getUser(){
		if(user == null){
			user = new UserModel();
		}
		return user;
	}
	*/

	public UserModel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public SectorType getSector() {
		return sector;
	}

	public void setSector(SectorType sector) {
		this.sector = sector;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
