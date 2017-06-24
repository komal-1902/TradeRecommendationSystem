package com.recommendation.factories;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recommendation.controllers.StockController;
import com.recommendation.interfaces.StockInterface;
import com.recommendation.model.DataModel;
import com.recommendation.model.StockModel;
import com.recommendation.service.DatabaseService;

public class ConstructionFactory extends RecommendStocks implements StockInterface{
	
	String symbol[];
	double avg[];
	
	ConstructionFactory(){
		DatabaseService db = new DatabaseService();
		this.symbol = db.getSectorData("CONSTRUCTION");
	}
	
	public void calculateTop5(){
		this.avg = calculateAverage(symbol);
	}
	public StockModel[] returnStocks(){
		calculateTop5();
		StockModel[] stm = new StockModel[symbol.length];
		stm = sort(symbol, avg);
		return stm;
	}
	
}
