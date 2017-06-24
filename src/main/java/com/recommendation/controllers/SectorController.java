package com.recommendation.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recommendation.factories.Factory;
import com.recommendation.model.DataModel;
import com.recommendation.model.SectorType;
import com.recommendation.model.StockModel;

@RestController
@RequestMapping("/server")
public class SectorController {
	
	@RequestMapping("/trade/{getParam}")
	public DataModel[] getStocks(@PathVariable("getParam") String sector) {
		StockModel stm[] = Factory.getCalculator(sector).returnStocks();
		int length = (stm.length > 5)? 5:stm.length;
		DataModel[] nifty = new DataModel[length];
		int counter = 0;
		for(int i = 0 ; i < length; i++){
			nifty[i] = StockController.getStockData(stm[i].getSymbol());
		}
		return nifty;

	}

}
