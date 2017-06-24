package com.recommendation.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recommendation.model.UserModel;
import com.recommendation.service.DatabaseService;

@RestController
@RequestMapping("/server")
public class WatchlistController {
	
	@RequestMapping("/watchlist")
	public Boolean authenticate(@RequestBody UserModel user){
		DatabaseService db = new DatabaseService();
		return (db.insertWatchlist(user.getUsername(), user.getSymbol()));
	}
 

}
