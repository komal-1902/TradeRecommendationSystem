package com.recommendation.model;

public class StockModel {

	String symbol;
	double avg;
	
	public StockModel(String symbol, double avg) {
		super();
		this.symbol = symbol;
		this.avg = avg;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
	
}
