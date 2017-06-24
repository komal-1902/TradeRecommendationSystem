package com.recommendation.factories;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.recommendation.model.StockModel;

public abstract class RecommendStocks {
	
	public double[] calculateAverage(String[] symbol) {
		int counter = 0;
		double[] avg = new double[symbol.length];
		try {
			for(int i = 0 ; i < symbol.length; i++){
				URL url;
				url = new URL("https://www.google.com/finance/historical?q=NSE:" +symbol[i]);
				URLConnection urlNConn = url.openConnection();
				InputStreamReader inputStreamReader = new InputStreamReader(urlNConn.getInputStream());
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				String line;
				String findDate = "<td class=\"lm\">";
				String findPrices = "<td class=\"rgt\">";
				String findVolume = "<td class=\"rgt rm\">";
				int resultCounter = 1;
				double total=0, avgPrice=0;
				System.out.println("Symbol in recommend stocks: " + symbol[i]);
				while ((line = bufferedReader.readLine()) != null) {
					if (line.contains(findDate)) {
						line = line.replace(findDate, "");

						counter++;

						System.out.println(resultCounter + ") Date: " + line);
					}

					if (line.contains(findPrices)) {
						line = line.replace(findPrices, "");
						line = line.replace(",", "");

						if (counter == 1) {
							double openPrice = Double.parseDouble(line);
							System.out.println("Open Price: " + openPrice);
						}
						if (counter == 2) {
							double highPrice = Double.parseDouble(line);
							System.out.println("High Price: " + highPrice);
						}
						if (counter == 3) {
							double lowPrice = Double.parseDouble(line);
							System.out.println("Low Price: " + lowPrice);
						}
						if (counter == 4) {
							double closePrice = Double.parseDouble(line);
							System.out.println("Close Price: " + closePrice);
							total += closePrice;
						}
						counter++;
					
					}
					if (line.contains(findVolume)) {
						line = line.replace(findVolume, "");
						line = line.replace(",", "");
						counter = 0;
						System.out.println("Volume: " + line);
						resultCounter++;
					}
				}
				avgPrice = total/resultCounter;
				avg[i] = avgPrice;
			}
				
				return avg;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public StockModel[] sort(String[] symbol, double[] avg){
		int length = symbol.length;
		StockModel temp;
		StockModel[] sortedStocks = new StockModel[length];
		
		for(int i = 0; i < length; i++){
			sortedStocks[i] = new StockModel(symbol[i],avg[i]);
		}
		
		for(int i = 0; i < length; i++){
			for(int j = 1; j < length-1; j++){
				if(sortedStocks[j-1].getAvg() < sortedStocks[j].getAvg()){
					temp = sortedStocks[j-1];
					sortedStocks[j-1] = sortedStocks[j];
					sortedStocks[j] = temp;
				}
			}
		}
		
		return sortedStocks;
	}
	
	public abstract StockModel[] returnStocks();
	
}

