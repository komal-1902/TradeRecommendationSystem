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
public class GainerController {
	private static final Nse nse = new Nse();
	private static final ArrayList<DataModel> dms1 = new ArrayList<>();
	
	@RequestMapping("/topgainers")
    public ArrayList<DataModel> gainers() {
		if(dms1.size() == 0) {
			HashMap<String,String>[] topGainers = nse.showAndGetTopGainersNifty50();
	        Arrays.stream(topGainers).forEach( topGainer -> dms1.add(new DataModel(topGainer.get("symbol"), topGainer.get(Nse.LAST_TRADED_PRICE))));
		}
        return dms1;
    }
	
	@RequestMapping("/topgainersrefresh")
    public String refresh() {
		dms1.clear();
		return "refreshed";
	}
}
