package com.recommendation.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recommendation.model.DataModel;
import com.recommendation.model.UserModel;
import com.recommendation.service.DatabaseService;

@RestController
@RequestMapping("/server")
public class DisplayWatchlistController {

	@RequestMapping("/showWatchlist/{username}")
	public DataModel[] getWatchlist(@PathVariable("username") String username){
		//String username = user.getUsername();
		DatabaseService db = new DatabaseService();
		String symbol[] = db.getWatchlist(username);
		DataModel[] nifty = new DataModel[symbol.length];
		for(int i = 0 ; i < symbol.length; i++){
			System.out.println(symbol[i]);
			nifty[i] = StockController.getStockData(symbol[i]);
		}
		return nifty;
	}
	
}
