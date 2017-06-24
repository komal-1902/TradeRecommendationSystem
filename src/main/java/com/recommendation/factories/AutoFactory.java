package com.recommendation.factories;

import com.recommendation.controllers.StockController;
import com.recommendation.interfaces.StockInterface;
import com.recommendation.model.DataModel;
import com.recommendation.model.StockModel;
import com.recommendation.service.DatabaseService;

public class AutoFactory extends RecommendStocks implements StockInterface{
	
	String symbol[];
	double avg[];
	
	AutoFactory(){
		DatabaseService db = new DatabaseService();
		this.symbol = db.getSectorData("AUTO");
		System.out.println("Autofactory");
		for(int i = 0; i < symbol.length; i++){
			System.out.println(symbol[i]);
		}
		
	}
	
	public void calculateTop5(){
		this.avg = calculateAverage(symbol);
		for(int i = 0; i < symbol.length; i++){
			System.out.println(avg[i]);
		}
	}
	
	public StockModel[] returnStocks(){
		calculateTop5();
		/*for(int i = 0; i < symbol.length; i++){
			DataModel dm = StockController.getStockData(symbol[i]);
			String line = dm.getClose();
			System.out.println("before, " + line);
			line = line.replaceAll(",", "");
			System.out.println("after, " + line);
			avg[i] = Double.parseDouble(line);
			System.out.println("avg, " + avg[i]);
		}*/
		
		StockModel[] stm = new StockModel[symbol.length];
		stm = sort(symbol, avg);
		return stm;
	}
	
}
