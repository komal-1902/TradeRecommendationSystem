package com.recommendation.controllers;

import java.util.HashMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recommendation.model.DataModel;
import com.rishabhk.nsefetch.Nse;

@RestController
public class StockController {
	
    public static DataModel getStockData(String symbol) {
    	Nse nse = new Nse();
    	DataModel dm = new DataModel();
    	HashMap<String, String> hashMap = nse.getStockDetails(symbol);
    	dm.setSymbol(symbol);
    	dm.setLtp(hashMap.get(Nse.LAST_TRADED_PRICE));
    	dm.setPrevclose(hashMap.get(Nse.PREVIOUS_CLOSE));
    	dm.setOpen(hashMap.get(Nse.OPEN));
    	dm.setHigh(hashMap.get(Nse.HIGH));
    	dm.setLow(hashMap.get(Nse.LOW));
    	dm.setClose(hashMap.get(Nse.CLOSE));
    	return new DataModel(dm.getSymbol(), dm.getLtp(), dm.getPrevclose(), dm.getOpen(), dm.getHigh(), dm.getLow(), dm.getClose());
    }
    
}
