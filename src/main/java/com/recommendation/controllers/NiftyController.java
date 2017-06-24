package com.recommendation.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recommendation.model.DataModel;

@RestController
@RequestMapping("/server")
public class NiftyController {	
	
	static boolean dataFetched = false;
	
	static String[] niftySymbols = {"TATASTEEL", "ADANIPORTS", "TATAMOTORS", "SBIN", "BOSCHLTD", "IDEA", "TATAMTRDVR", "BPCL", "HEROMOTOCO", "HDFCBANK", "POWERGRID", "BANKBARODA", "GRASIM", "CIPLA", "AXISBANK", "YESBANK", "HDFC", "LUPIN", "INFRATEL", "TCS",
			"KOTAKBANK", "ASIANPAINT", "ZEEL", "ICICIBANK", "ULTRACEMCO", "BAJAJ-AUTO", "DRREDDY", "LT", "HINDALCO", "ACC", "INDUSINDBANK", "BHEL", "HINDUNILVR", "ITC", "TECHM", "AMBUJACEM", "WIPRO", "AUROPHARMA", "NTPC", "MARUTI", "COALINDIA", "BHARTIARTL", "M&M",
			"GAIL", "RELIANCE", "ONGC", "SUNPHARMA", "INFY", "EICHERMOT", "TATAPOWER", "HCLTECH"};
	
	static DataModel[] nifty = new DataModel[niftySymbols.length];
	
	@RequestMapping("/nifty-50")
	public static DataModel[] getNifty() {
		if(dataFetched == false){
			for(int i = 0 ; i < niftySymbols.length; i++){
				nifty[i] = StockController.getStockData(niftySymbols[i]);
			}
			dataFetched = true;

		}
		return nifty;
	}

}
