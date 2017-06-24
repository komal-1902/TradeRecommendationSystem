package com.recommendation.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recommendation.model.DataModel;
import com.rishabhk.nsefetch.Nse;

@RestController
@RequestMapping("/server")
public class LoserController {
	private static final Nse nse = new Nse();
	private static final ArrayList<DataModel> dms2 = new ArrayList<>();
	
	@RequestMapping("/toplosers")
    public ArrayList<DataModel> losers() {
		if(dms2.size() == 0) {
		        HashMap<String,String>[] topLosers = nse.showAndGetTopLosersNifty50();
		        Arrays.stream(topLosers).forEach( topLoser -> dms2.add(new DataModel(topLoser.get("symbol"), topLoser.get(Nse.LAST_TRADED_PRICE))));
		        return dms2; 
		}
        return dms2;
    }
	
	@RequestMapping("/toplosersrefresh")
    public String refresh() {
		dms2.clear();
		return "refreshed";
	}
	
}
